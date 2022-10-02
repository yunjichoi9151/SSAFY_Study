package BOJ_0928;

import java.util.Scanner;

public class 계단오르기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] arr = new int[301];
		int[] dp = new int[301];
		for (int i = 1; i <= N; i++)
			arr[i] = sc.nextInt();

		dp[1] = arr[1];
		dp[2] = arr[1] + arr[2];
		dp[3] = Math.max(arr[1], arr[2]) + arr[3];

		for (int n = 4; n <= N; n++) {
			dp[n] = Math.max(dp[n - 3] + arr[n - 1], dp[n - 2]) + arr[n];
		}

		System.out.println(dp[N]);
	}
}
