package pracprac.bj.study.d0925;
//17070번을 dp를 활용해 풀이
//입력 및 탐색조건은 똑같음
//dp 점화식을 만들때 파이프의 이동방향에 맞춰  →, ↘, ↓ 3가지 고려, 0,1,2
//모든 범위를 돌며 세가지 경우를 합산

import java.util.Scanner;

public class bj17069 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] map = new int[N+1][N+1]; 
		long[][][] dp = new long[N+1][N+1][3]; //int범위 넘어가므로 long으로
		
		for(int r=1; r<=N; r++) {
			for(int c=1; c<=N; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		
		dp[1][2][0] = 1;
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				
				if(map[i][j]==1) { //벽과 만나면 통과
					continue;
				}
				
				 // → : 직전 지점까지 도달했을 때 오른방향인 경우와 대각선 아래인 경우 합 누적
				dp[i][j][0]=dp[i][j][0]+dp[i][j-1][0]+dp[i][j-1][1];
				
				// ↘ : 직전 지점까지 도달했을 때 세 가지 경우 모두의 합 누적
				//직전 지점의 오른쪽, 아래쪽 방향에 벽 있는지 체크 필요 - 벽이 있으면 0
				if(map[i][j-1]!=1 &&map[i-1][j]!=1) {
					dp[i][j][1]= dp[i][j][1]+ dp[i-1][j-1][0]+dp[i-1][j-1][1]+dp[i-1][j-1][2];
				}
				
				// ↓ : 직전 지점까지 도달했을 때 아래방향인 경우와 대각선 아래인 경우 합 누적
				dp[i][j][2]=dp[i][j][2]+dp[i-1][j][1]+dp[i-1][j][2];
				
			}			
		}
		System.out.println(dp[N][N][0]+dp[N][N][1]+dp[N][N][2]);
		
		
	}

}
