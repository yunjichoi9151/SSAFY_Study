package d230203;

import java.util.Scanner;

public class 소수찾기_1978 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			
			boolean pnum = true;

			int n = sc.nextInt();

			if (n == 1) {
				continue;
			}
			for (int j = 2; j <= Math.sqrt(n); j++) {
				if (n % j == 0) {
					pnum = false;
					break;
				}
			}

			if (pnum) {
				cnt++;
			}

		}

		System.out.println(cnt);

	}
}
