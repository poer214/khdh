import java.util.ArrayList;
import java.util.List;

public class Test2 {
	public static void main(String[] args) {
		List<TestDto2> dtos = new ArrayList<>();
		
		dtos.add(new TestDto2("코로나 바이러스 발생",
				new String[]{"바이오","식품","IT"},
				new String[]{"항공사","뷰티","금융","엔터"}));
		
		for(TestDto2 d: dtos) {
			for(String s:d.a) {
				System.out.println(s);
			}
			for(String s:d.b) {
				System.out.println(s);
			}
		}
	}
}
