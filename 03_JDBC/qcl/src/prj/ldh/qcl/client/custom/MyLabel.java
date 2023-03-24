package prj.ldh.qcl.client.custom;

import javax.swing.Icon;
import javax.swing.JLabel;

public class MyLabel extends JLabel{

	public MyLabel() {
		super();
	}

	public MyLabel(Icon image, int horizontalAlignment) {
		super(image, horizontalAlignment);
	}

	public MyLabel(Icon image) {
		super(image);
	}

	public MyLabel(String text, Icon icon, int horizontalAlignment) {
		super(text, icon, horizontalAlignment);
	}

	public MyLabel(String text, int horizontalAlignment) {
		super(text, horizontalAlignment);
	}

	public MyLabel(String text) {
		super(text);
	}
	
}
