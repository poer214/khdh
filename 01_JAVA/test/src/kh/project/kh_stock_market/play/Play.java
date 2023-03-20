package kh.project.kh_stock_market.play;

import kh.project.kh_stock_market.view.View;

public class Play {
	public Play() {
		View view = new View(this);
		view.regist();
		view.play();
	}
}