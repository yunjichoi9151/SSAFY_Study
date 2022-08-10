package week3_IM;

import java.util.Scanner;

public class N6485_삼성시의버스노선 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {

			int N = sc.nextInt(); // 버스노선 개수
			int[][] AB = new int[N][2];

			for (int i = 0; i < N; i++) {
				// A <= 노선번호 <= B
				AB[i][0] = sc.nextInt();
				AB[i][1] = sc.nextInt();
			}

			System.out.print("#" + t + " ");

			int cnt = 0;
			int P = sc.nextInt(); // 버스정류장 개수

			for (int j = 0; j < P; j++) {
				int C = sc.nextInt();
				for (int i = 0; i < N; i++) {
					if (C >= AB[i][0] && C <= AB[i][1]) {
						cnt++;
					}
				}
				System.out.print(cnt + " ");
				cnt = 0;
			}

			System.out.println();
		}

	}
}
