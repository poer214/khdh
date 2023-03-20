package project.mini.play;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import project.mini.dto.Event;
import project.mini.dto.Player;
import project.mini.dto.PlayerStock;
import project.mini.dto.Stock;
import project.mini.view.View;

public class Play {
	public static final int MAX_OF_TURN = 10;
	private static final int MIN_CHANGE_PERCENT = -10;
	private static final int MAX_CHANGE_PERCENT = 10;
	
	private final int MIN_NUMBER_OF_PLAYER = 2;
	private final int MAX_NUMBER_OF_PLAYER = 5;
	private final int MAX_NUMBER_OF_PLAYER_NAME = 5;
	
	private Scanner sc;
	private View view;
	private List<Player> players;
	private List<Stock> stocks;
	private List<Event> events;
	private int turnPlayerIndex;
	private String input;
	private int turn;
	
	public Play() {
		sc = new Scanner(System.in);
		view = new View();
		players = new ArrayList<>();
		stocks = Stock.initStocks();
		events = Event.initEvents();
		turn = 1;
		input="";

		registPlayer(); // 플레이어 등록
		play();
	}
	
	// 플레이어 등록
	private void registPlayer() {
		int playerNum;
		view.setDisp("플레이어를 등록합니다.",View.LINE_OF_FIRST);
		view.setSelect("등록할 플레이어 수를 입력하세요. (2~5)",View.LINE_OF_FIRST);
		while(true) {
			try {
				view.writeDisplay();
				input = sc.nextLine();
				playerNum = Integer.parseInt(input);
				if(playerNum < MIN_NUMBER_OF_PLAYER || playerNum > MAX_NUMBER_OF_PLAYER) throw new Exception();
				break;
			} catch(Exception e) {view.inputError();}
		}
		
		for (int i = 0; i < playerNum; i++) {
			view.setSelect(i+1+"번째 플레이어의 이름을 입력하세요.",View.LINE_OF_FIRST);
			view.setSelect("- 공백문자는 입력할 수 없습니다.");
			view.setSelect("- 이름은 최대 "+MAX_NUMBER_OF_PLAYER_NAME+"글자까지 입력 가능합니다.");
			String player;
			while (true) {
				try {
					view.writeDisplay();
					player = sc.nextLine();
					if(player.length()==0 || player.length()>5) throw new Exception();
					break;
				}catch (Exception e) {
					view.inputError();
				}
			}
			players.add(new Player(player));
			view.setDisp(players.get(i).getName() + "님 등록되었습니다.");
		}
		view.setDisp(new String[]{"플레이어 등록이 완료되었습니다.","게임을 시작합니다."});
		view.cleanSelect();
		view.setSelect("Enter 키를 누르면 게임이 시작됩니다.",0);
		view.writeDisplay();
		sc.nextLine();
	}
	
	// 게임 시작
	private void play() {
		for (turn = 1; turn <= MAX_OF_TURN; turn++) {
			for (turnPlayerIndex = 0; turnPlayerIndex < players.size(); turnPlayerIndex++) {
				boolean pass=false;
				try {
					view.clean();
					view.drawAllInfo(stocks, players, turn, turnPlayerIndex);
					view.drawGameMenu();
					input = sc.nextLine();
					switch (input) {
					case "1":buy();break;
					case "2":
						if(!players.get(turnPlayerIndex).getStocks().isEmpty())
							sell();
						else
							view.inputError("보유중인 주식이 없습니다.");
						break;
					case "3":pass=pass();break;
					case "0":
						if(quit()) return;
					}
				} catch (Exception e) {
					view.inputError();
				}
				if(!pass)
					turnPlayerIndex--;
			}
			view.clean();
			updatePrice(stocks);
			if(turn==MAX_OF_TURN) {
				rank();
				return;
			}
			view.setDisp(turn+"번째 턴이 종료되었습니다.");
			view.setDisp("주식 가격이 변동됩니다.");
			view.setSelect("Enter키를 누르면 다음 턴이 시작됩니다.");
			view.writeDisplay();
			sc.nextLine();
			if ((int) (Math.random() * 2) == 0 && turn<=MAX_OF_TURN-2)
				event();
		}
	}
	
	// 최종 순위
		public void rank() {
			view.setDisp("마지막 시세 변동 후 순위가 집계됩니다.");
			view.setSelect("Enter키를 누르면 순위가 표시됩니다.");
			view.writeDisplay();
			sc.nextLine();
			for(Player p : players)
				p.updateTotalAssets(stocks);
			Collections.sort(players);
			int dp=15;
			view.setDisp("\t\t\t\t\t\t★★★★★★★★★★★★★★★★★★★★★★★★★★ 최종 순위 ★★★★★★★★★★★★★★★★★★★★★★★★★★",dp++);
			view.setDisp("");
			view.setDisp(String.format("\t\t\t\t\t\t\t\tWINNER : %s님 축하드립니다!!\n", players.get(0).getName()));
			

			for (int i = 0; i < players.size(); i++) 
				view.setDisp(String.format("\t\t\t\t\t\t\t\t[%d위] %5s\t\t%,d원\n", i+1, players.get(i).getName(), players.get(i).getTotalAssets()));
			view.setDisp("\t\t\t\t\t\t\t\t플레이해주셔서 감사합니다.");
			view.setDisp("");
			view.setDisp("\t\t\t\t\t\t★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
			view.cleanSelect();
			view.setSelect("Enter키를 누르시면 메인화면으로 돌아갑니다.");
			view.writeDisplay();
			sc.nextLine();
		}
	
	public void updatePrice(List<Stock> stocks) {
		for (Stock s : stocks) {
			int changePercent = (int) (Math.random() * (MAX_CHANGE_PERCENT - MIN_CHANGE_PERCENT + 1))
					+ MIN_CHANGE_PERCENT;
			int changeAmount = (int) (s.getPrice() * changePercent / 100.0);
			int newPrice = s.getPrice() + changeAmount;
			s.setPrevPrice(s.getPrice());
			s.setPrice(newPrice);
		}
	}
	
	// 매수
	private void buy() {
		Stock buyStock;
		int value;

		while(true) {
			try {
				view.cleanSelect();
				view.setSelect("매수 할 종목을 선택하세요.");
				int sp = 0;
				for(int i=0;i<stocks.size();i++) {
					String content = String.format("%d. %s          ",i+1,
							stocks.get(i).getName());
					if(i%6==0)
						sp++;
					view.appendSelect(content,sp);
				}
				view.writeDisplay();
				input = sc.nextLine();
				// 구매할 종목 정보 대입
				buyStock = stocks.get(Integer.parseInt(input)-1);
				break;
			} catch (Exception e) {
				view.inputError();
			}
		}

		
		/* 예외상황.
		 * 1. 숫자 외 입력
		 * 2. input*buyStock.getStockPrice()가 user.getCashHoldings()를 초과하는 경우   
		 * */
		while (true) {
			view.cleanSelect();
			view.setSelect(buyStock.getName() + "의 현재 가격은 " + buyStock.getPrice() + "원 입니다.");
			view.setSelect("몇 주 구매하시겠습니까? ");
			try {
				view.writeDisplay();
				input = sc.nextLine();
				value = Integer.parseInt(input);
				if (Integer.parseInt(input)*buyStock.getPrice() > players.get(turnPlayerIndex).getCash()) {
					view.inputError("보유 현금이 부족합니다.");
					continue;
				}
				view.cleanSelect();
				view.setSelect(String.format("%s %d주의 가격은 %,d원 입니다.", buyStock.getName(),value,buyStock.getPrice()*value));
				view.setSelect("정말 매수하시겠습니까?");
				view.setSelect("1. 매수");
				view.setSelect("2. 취소");
				view.writeDisplay();
				input = sc.nextLine();
				if(input.equals("1")) break;
				else if(input.equals("2")) continue;
				else throw new Exception();
			} catch (Exception e) {
				view.inputError();
			}
		}
		players.get(turnPlayerIndex).buyStock(buyStock,value);
		view.cleanSelect();
		view.setSelect(String.format("%s %d주를 %d원에 매수하였습니다.", buyStock.getName(), value, value*buyStock.getPrice()));
		view.setSelect("돌아가려면 Enter 키를 누르세요.");
		view.writeDisplay();
		sc.nextLine();
	}
	
	// 매도
	private void sell() {
		Stock sellStock = null;
		PlayerStock sellPlayerStock;
		int value;
		while (true) {
			try {
				view.cleanSelect();
				view.setSelect("매도하실 종목을 선택하세요.");
				int sp=1;
				for(int i=0; i<players.get(turnPlayerIndex).getStocks().size();i++) {
					String content = String.format("%d. %s          ",i+1,
							players.get(turnPlayerIndex).getStocks().get(i).getName());
					if(i%6==0) sp++;
					view.appendSelect(content,sp);
				}
				view.writeDisplay();
				input = sc.nextLine();
				sellPlayerStock = players.get(turnPlayerIndex).getStocks().get(Integer.parseInt(input) - 1);
				for(Stock s:stocks) {
					if(sellPlayerStock.getName().equals(s.getName())) {
						sellStock=s;
						break;
					}
				}
				break;
			} catch (Exception e) {
				view.inputError();
			}
		}
		while (true) {
			try {
				view.cleanSelect();
				view.setSelect(sellStock.getName() + "의 현재 가격은 " + sellStock.getPrice() + "원이며");
				view.setSelect("보유량은 "+sellPlayerStock.getCount()+"주 입니다.");
				view.setSelect("몇 주 판매하시겠습니까?");
				view.writeDisplay();
				input = sc.nextLine();
				value=Integer.parseInt(input);
				if (value > sellPlayerStock.getCount()) {
					view.inputError("보유량이 부족합니다.");
					continue;
				}
				view.cleanSelect();
				view.setSelect(String.format("%s %d주의 가격은 %,d원 입니다.", sellStock.getName(),value,sellStock.getPrice()*value));
				view.setSelect("정말 매도하시겠습니까?");
				view.setSelect("1. 매도");
				view.setSelect("2. 취소");
				view.writeDisplay();
				input = sc.nextLine();
				if(input.equals("1")) break;
				else if(input.equals("2")) continue;
				else throw new Exception();
			} catch (Exception e) {
				view.inputError();
			}
		}

		players.get(turnPlayerIndex).sellStock(sellPlayerStock,value,sellStock.getPrice());
		view.cleanSelect();
		view.setSelect(String.format("%s %d주를 %d원에 매도하였습니다.", sellStock.getName(), value, value*sellStock.getPrice()));
		view.setSelect("돌아가려면 Enter 키를 누르세요.");
		view.writeDisplay();
		sc.nextLine();
	}
	
	private boolean pass() {
		boolean pass;
		while(true) {
			try {
				view.cleanSelect();
				view.setSelect("정말 패스하시겠습니까?");
				view.setSelect("1. 패스");
				view.setSelect("2. 취소");
				view.writeDisplay();
				input = sc.nextLine();
				if(input.equals("1")) {pass=true;break;}
				else if(input.equals("2")) {pass=false;break;}
				else throw new Exception();
			} catch(Exception e) {
				view.inputError();
			}
		}
		return pass;
	}
	
	private boolean quit() {
		boolean quit;
		while(true) {
			try {
				view.cleanSelect();
				view.setSelect("메인으로 돌아가면 게임이 종료되며, 현재 상황이 저장되지 않습니다.");
				view.setSelect("정말 메인으로 돌아가시겠습니까?");
				view.setSelect("1. 돌아간다.");
				view.setSelect("2. 취소");
				view.writeDisplay();
				input = sc.nextLine();
				if(input.equals("1")) {quit=true;break;}
				else if(input.equals("2")) {quit=false;break;}
				else throw new Exception();
			} catch(Exception e) {
				view.inputError();
			}
		}
		return quit;
	}
	
	public void event() {
		final int MAX_BIDPRICE = 50000; // 최대 금액
		int bidPrice = 1000; // 입찰가
		int quotePrice = 0; // 회원 제시가
		Player finalBidder = null; // 최종 낙찰자
		String largestBidder = null; // 최대 입찰자의 이름 저장
		boolean[] pass = new boolean[players.size()]; // 패스한 유저 구분을 위한 플래그
		for (int i = 0; i < pass.length; i++) pass[i] = false; // pass에 기본값(false) 대입
		int passCounter = 0; // 패스한 유저 수를 카운트
		int dp=5;
		view.clean();
		String[] strArr = new String[] {
				"\t\t\t\t\t★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★",
				"\t\t\t\t\t\t\t\t\t이벤트 발생!! 정보 경매를 시작합니다.",
				"\t\t\t\t\t★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★",
				"\t\t\t\t\t\t\t- 경매를 진행하여 낙찰받은 최종 1인은 투자에 유용한 정보를 얻게 됩니다.",
				"\t\t\t\t\t\t\t- 입찰가는 1000원부터 시작합니다.",
				"\t\t\t\t\t\t\t- 0을 입력 시 경매를 포기하게 됩니다.",
				"\t\t\t\t\t\t\t- 최대 금액은 " + MAX_BIDPRICE + "원이며, 그 이상 입력하실 경우 최대 금액으로 낙찰됩니다.\n",
		};
		view.setDisp(strArr,dp);
		view.writeDisplay();
		while (true) {
			// 낙찰자가 정해졌다면, 반복문 종료
			if (finalBidder != null)
				break;
			// 모두 패스했다면, 반복문 종료
			if (passCounter == players.size())
				break;
			for (int i = 0; i < players.size(); i++) {
				view.writeDisplay();
				String name = players.get(i).getName();
				// 낙찰자가 정해졌다면, 반복문 종료
				if (finalBidder != null)
					break;
				// 모두 패스했다면, 반복문 종료
				if (passCounter == players.size())
					break;
				// 최대 입찰자를 제외하고 모두 패스했다면, 최대 입찰자를 낙찰자로 간주하고 반복문 종료
				if (passCounter == players.size() - 1 && largestBidder != null) {
					for (int j = 0; j < players.size(); j++)
						if (largestBidder.equals(players.get(j).getName())) {
							finalBidder = players.get(j);
							System.out.println("[ 최종 낙찰자 : " + finalBidder.getName() + "님 ]");
							break;
						}
					break;
				}

				// 패스한 유저는 입찰을 진행하지 않게 됨.
				if (pass[i]);
				// 패스한 유저가 아닌 경우.
				else {
					strArr = new String[] {
							name+"님이 입찰을 진행합니다.",
							largestBidder==null?"":"현재 입찰자는 "+largestBidder+"님 입니다.",
							"현재 입찰가는 " + bidPrice + "원 입니다.",
							"현재 입찰가보다 높은 금액을 입찰해주세요.",
							"포기하시려면 0을 입력하세요."
					};
					view.setSelect(strArr,view.LINE_OF_FIRST);
					view.writeDisplay();

					// 예외시 다시 입력받을 수 있도록 입력받기 전에 무한 반복문
					while (true) {
						try {
							// 입찰가 입력받음.
							view.writeDisplay();
							input = sc.nextLine();
							quotePrice=Integer.parseInt(input);
							
							// 0을 입력한 경우(패스처리)
							if (quotePrice == 0) {
								// 현재 인덱스 패스변수 true로 설정하여 패스한 유저 구분
								pass[i] = true;
								// 패스한 유저 수 카운트 증가
								passCounter++;
								view.setDisp("\t\t\t\t\t\t\t "+name+"님이 경매를 포기하셨습니다.");
								// 입력받는 반복문 종료
								break;
							}

							// 가지고 있는 현금보다 입찰 금액이 높은 경우
							else if (bidPrice > players.get(i).getCash())
								view.inputError("입찰 금액은 보유 현금을 초과할 수 없습니다.");
							// 입찰가보다 낮거나 같은 금액을 입력한 경우
							else if (quotePrice <= bidPrice)
								view.inputError("현재 입찰가보다 낮거나 같은 금액을 입력하셨습니다.");
							// 최대 입찰금액 이상 입찰한 경우 낙찰자로 설정하고 반복문 종료.
							else if (quotePrice >= MAX_BIDPRICE) {
								bidPrice=MAX_BIDPRICE;
								view.setDisp("\t\t\t\t\t\t\t최대 금액이상 입찰로 "+name+"님이 낙찰받으셨습니다.");
								finalBidder = players.get(i);
								view.writeDisplay();
								// 반복문 종료
								break;
							}

							// 그 외의 경우(현재 입찰가보다 높은 입찰가를 입력하여 입찰가 갱신하는 경우)
							else {
								// 입찰가를 현재 입찰가로 설정
								bidPrice = quotePrice;
								// 현재 입찰자의 이름 설정
								largestBidder = name;
								// 반복문 종료
								
								break;
							}
						} catch (Exception e) {
							// 숫자외에 입력 한 경우
							view.inputError();
						}
					}
				}
			}
		}

		// 낙찰자가 있는 경우
		if (finalBidder != null) {

			// 현재 기술 스택으로 구현할 수 없는 부분으로 유저들의 양심에 맡겨 처리
			strArr = new String[]{
					"","\t\t\t\t\t\t\t "+"▶ 최종 낙찰자 "+finalBidder.getName()+"님",
				"\t\t\t\t\t\t\t "+bidPrice+"원에 낙찰되었습니다. 축하드립니다!",
				"\t\t\t\t\t\t\t "+finalBidder.getName() + "님을 제외한 플레이어들은 눈을 감으세요!",
				"\t\t\t\t\t\t\t "+finalBidder.getName() + "님 혼자만 보셔야해요!!!!!"
			};
			view.setDisp(strArr);
			view.cleanSelect();
			view.setSelect("Enter키를 누르시면 정보가 공개됩니다.");
			view.writeDisplay();
			sc.nextLine();
			finalBidder.setCash(finalBidder.getCash()-bidPrice);
			
			view.clean();
			view.setDisp("미구현");
			view.setDisp("현재 "+(turn+1)+"턴이며, 해당 정보는 "+(turn+2)+"턴에 반영됩니다.");
			view.setSelect("Enter 키를 누르면 정보가 사라집니다.");
			view.writeDisplay();
			sc.nextLine();
		}

		// 모두 패스하여 낙찰자가 없는 경우
		else {
			view.setDisp("\t\t\t\t\t\t\t모든 유저가 경매를 포기하여 이벤트가 종료됩니다.");
			view.cleanSelect();
			view.setSelect("Enter키를 눌러 진행하세요.");
			view.writeDisplay();
			sc.nextLine();
		}
	}
}