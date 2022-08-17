package week4_IM;

import java.util.Scanner;

public class 수열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 배열채우기
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		int cnt = 1;
		int max = 1;

		// 커질때
		for (int i = 0; i < N - 1; i++) {
			if (arr[i] <= arr[i + 1])
				cnt++;
			else
				cnt = 1;

			max = Math.max(max, cnt);
		}

		// 작아질때
		int cnt2 = 1;
		for (int i = 0; i < N - 1; i++) {
			if (arr[i] >= arr[i + 1])
				cnt2++;
			else
				cnt2 = 1;
			max = Math.max(max, cnt2);
		}

		System.out.println(max);

	}

}