package 이공이삼이월.d230224;
//https://nahwasa.com/entry/%EB%B0%B1%EC%A4%80-2225-%EC%9E%90%EB%B0%94-%ED%95%A9%EB%B6%84%ED%95%B4-BOJ-2225-JAVA
import java.util.Arrays;
import java.util.Scanner;

public class 합분해_2225 {

	static final int Mod = 1_000_000_000; 
			
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[][] dp = new int[K+1][N+1];
		
		Arrays.fill(dp[1], 1);
		
		for(int i=0; i<=K; i++) {
			dp[i][0] = 1;
		}
		
		for(int i=2; i<=K; i++) {
			for(int j=1; j<=N; j++) {
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
				dp[i][j] %= Mod;
			}
		}
		
		System.out.println(dp[K][N]);
	}
	
}
