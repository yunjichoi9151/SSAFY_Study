package d230218;

import java.util.Scanner;

public class 평범한배낭12856 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[] W = new int[N+1];
		int[] V = new int[N+1];
		int[] dp = new int[K+1];
		
		for(int i=1; i<=N; i++) {
			W[i] = sc.nextInt();
			V[i] = sc.nextInt();
		}
		
		//제한무게 기준으로 물건 담으면서 dp에 담아서 비교
		for(int i=1; i<=N; i++) {
			for(int j=K; j>=W[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j-W[i]]+V[i]);
			}
		}
		
		System.out.println(dp[K]);
		
	}
}
