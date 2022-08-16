package week3_IM;

import java.util.Scanner;

public class 현주의상자바꾸기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {

			int N = sc.nextInt(); // 상자 개수
			int[] arr = new int[N + 1];

			int Q = sc.nextInt(); // Q회 동안 반복 (1-Q)
			for (int i = 1; i <= Q; i++) {

				int L = sc.nextInt(); // 시작
				int R = sc.nextInt(); // 끝

				for (int a = L; a <= R; a++) {
					arr[a] = i;
				}
			}

			System.out.print("#" + t + " ");
			for (int i = 1; i <= N; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();

		}
	}
}