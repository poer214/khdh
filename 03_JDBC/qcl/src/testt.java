
public class testt {
	
	public testt() {
		test("login","id","pw");
	}
	
	public static void main(String[] args) {
		new testt();
	}
	
	public void test(String...strings) {
		for(String s : strings) {
			System.out.println(s);
		}
	}
}
