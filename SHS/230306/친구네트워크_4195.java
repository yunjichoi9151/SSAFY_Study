package 이공이삼이월.d230227;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

//UF + MAP
public class 친구네트워크_4195 {

	static int tc;
	static int F;
	static int[] parents;
	static int[] social;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		tc = sc.nextInt();

		for (int i = 0; i < tc; i++) {
			F = sc.nextInt();
			parents = new int[2 * F];
			social = new int[2 * F];

			for (int j = 0; j < 2 * F; j++) {
				parents[j] = j;
			}
			
			//친구 최소 1명 주어짐
			Arrays.fill(social, 1);

			//키에 이름 밸류에 넘버
			HashMap<String, Integer> hm = new HashMap<>();

			int idx = 0;

			for (int j = 0; j < F; j++) {
				String f1 = sc.next();
				String f2 = sc.next();
				
				//친구 이름당 인덱스 넘버 부여
				if (!hm.containsKey(f1)) {
					hm.put(f1, idx++);
				}
				if (!hm.containsKey(f2)) {
					hm.put(f2, idx++);
				}

				System.out.println(union(hm.get(f1), hm.get(f2)));
			}

		}

	}

	private static int union(int x, int y) {

		x = find(x);
		y = find(y);

		if (x != y) {
			if (x < y) {
				parents[y] = x;
				social[x] += social[y];

				return social[x];
			} else {
				parents[x] = y;
				social[y] += social[x];

				return social[y];
			}
		}

		return social[x];
	}

	private static int find(int x) {

		if (parents[x] == x) {
			return x;
		} else {
			return parents[x] = find(parents[x]);
		}
	}

}
