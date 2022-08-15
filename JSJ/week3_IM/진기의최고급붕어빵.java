package week3_IM;

import java.util.Arrays;
import java.util.Scanner;

public class 진기의최고급붕어빵 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // tc 개수
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt(); // 예약 손님
			int M = sc.nextInt(); // 붕어빵 K개 만드는데 걸리는 시간
			int K = sc.nextInt();

			int[] Narr = new int[N]; // 손님이 도착하는 시간(초단위)
			boolean check = true;

			for (int j = 0; j < N; j++) {
				Narr[j] = sc.nextInt();
			}

			Arrays.sort(Narr);

			for (int i = 0; i < N; i++) {
				int cnt = (Narr[i] / M * K); // 만들어진 붕어빵 수
				if (cnt - i - 1 < 0) { // 붕어빵수 - 앞선 손님수 - 1
					check = false;
				}
			}

			if (check)
				System.out.println("#" + t + " " + "Possible");
			else
				System.out.println("#" + t + " " + "Impossible");
		}
	}
}