package week7;

import java.util.Scanner;

public class 리벤지오브피타고라스 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {

			long A = sc.nextInt(); // A < B

			if (A == 0) // 종료 조건
				return;

			int cnt = 0;
			for (int i = 1; i <= A; i++) {

				long k = A * A; // k = A^2

				if (k % i == 0) { // i가 A^2의 약수일 때

					// a^2 = c^2 - b^2 = (c+b)(c-b)
					long b = (A * A / i) - i; // B * 2 (A^2의 약수 C,B 중 작은 수를 B로 (A * A / i) + i == C * 2)

					if (b % 2 == 0 && b / 2 > A) // B > A && B가 자연수일 때
						cnt++;
				}
			}
			System.out.println(cnt);
		}
	}
}