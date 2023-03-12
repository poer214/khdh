package asdf;

import java.util.Random;

public class E {
	public static void main(String[] args) {
		int ans = 0;
		for (int x = 0; x < 100000000; x++) {
			int[] n = new int[5];
			boolean[] used = new boolean[6];

			Random rand = new Random();
			for (int i = 0; i < n.length; i++) {
				int num;
				do {
					num = rand.nextInt(5) + 1;
				} while (used[num]);
				n[i] = num;
				used[num] = true;
			}
			if(n[4]==5)
				ans++;
		}
		System.out.println(ans);
	}
}
