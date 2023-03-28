import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;

public class ButtonTest {
	JButton buttonA;
	JButton buttonB;
	JButton buttonC;
	JButton buttonD;
	public ButtonTest() {
		buttonA = new JButton();
		buttonB = new JButton();
		
		buttonC = new JButton();
		buttonD = new JButton();
		
		buttonA.addActionListener((e) -> buttonListener(e));
		buttonB.addActionListener((e) -> buttonListener(e));
		
		buttonC.addActionListener((e) -> buttonCListener(e));
		buttonD.addActionListener((e) -> {
		    System.out.println("Press Button D");
		});
		
		List<String> list = Arrays.asList("a","b","c");
		list.stream().forEach(System.out::println);
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		numbers.stream().filter(n -> n % 2 == 0).map(n -> n * 2);
	}
	

	private void buttonListener(ActionEvent e) {
		if(e.getSource()==buttonA) {
			System.out.println("Press Button A");
		} else {
			System.out.println("Press Button B");
		}
	}

	private void buttonCListener(ActionEvent e) {
		System.out.println("Press Button C");
	}

	public static void main(String[] args) {
		new ButtonTest();
	}
}