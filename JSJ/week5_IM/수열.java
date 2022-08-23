package week5_IM;

import java.util.Scanner;

public class 수열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		int[] arr = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = arr[i - 1] + sc.nextInt();
		}

		int sum = -10000001;
		int max = sum;

		for (int i = N; i >= K; i--) {
			sum = arr[i] - arr[i - K];
			max = Math.max(max, sum);
		}

		System.out.println(max);
	}
}