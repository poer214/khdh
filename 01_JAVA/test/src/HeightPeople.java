import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HeightPeople {
	private static final int TALLEST_HEIGHT = 4;
	public static void main(String[] args) {
		List<Integer> height = new ArrayList<>(List.of(0, 1, 2, 3, 4));
		int ans = 0;
		for (int i = 0; i < 100000000; i++) {
			Collections.shuffle(height);
			if (height.get(0) == TALLEST_HEIGHT || height.get(1) == TALLEST_HEIGHT) {
				continue;
			} else if (height.get(0) < height.get(2) && height.get(1) < height.get(2)) {
				if (height.get(2) == TALLEST_HEIGHT)
					ans++;
			} else if (height.get(0) < height.get(3) && height.get(1) < height.get(3)) {
				if (height.get(3) == TALLEST_HEIGHT)
					ans++;
			} else if (height.get(4) == TALLEST_HEIGHT)
				ans++;
		}
		System.out.println(ans);
	}
}