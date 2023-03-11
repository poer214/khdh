import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List<TestDto> a = new ArrayList<>();
		List<TestDto> b = new ArrayList<>();
		TestDto dto = new TestDto();
		a.add(dto);
		
		b.add(dto);
		b.get(0).a = 1;
		System.out.println(a.get(0).a);
	}
}