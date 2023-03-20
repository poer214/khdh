import java.util.Random;

public class MontyHall {
	public static void main(String[] args) {
		Random random = new Random();
		int answer = 0;
		
		for (int i = 0; i < 10000000; i++) {
			int car = random.nextInt(3);
			int choice = random.nextInt(3);
			int openedDoor;
			do openedDoor = random.nextInt(3);
			while(openedDoor == choice || openedDoor == car);
			int finalChoice = 3 - choice - openedDoor;
			if(finalChoice==car) answer++;
		}
		System.out.println(answer);
	}
}
