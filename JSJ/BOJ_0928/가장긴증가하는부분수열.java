package BOJ_0928;

import java.util.Arrays;
import java.util.Scanner;

public class 가장긴증가하는부분수열 {

	static int[] arr, dp;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 길이
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		dp = new int[N];
		for (int i = 0; i < N; i++) {// 탐색 시작 idx
			dp[i]++;

			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && dp[j] + 1 > dp[i]) {
					dp[i] = dp[j] + 1;
				}
			}
		}

		// 최대값 찾아서 출력
		Arrays.sort(dp);
		System.out.println(dp[N - 1]);
	}
}
