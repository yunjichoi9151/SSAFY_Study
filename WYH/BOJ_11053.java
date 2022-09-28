package day0928;

import java.util.Scanner;

public class BOJ_11053 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int ans = 0;
		int N = sc.nextInt();
		int[] arr = new int[N];
		int[] dp = new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i=0;i<N;i++) {
			int max = 0;
			for(int j=0;j<i;j++) {
				if(arr[j]<arr[i]) {
					max = Math.max(max, dp[j]);
				}
			}
			dp[i] = max+1;
			ans = Math.max(ans, dp[i]);
		}
		System.out.println(ans);
	}
}
