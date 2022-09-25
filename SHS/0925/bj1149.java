package pracprac.bj.study.d0925;
//https://st-lab.tistory.com/128
//점화식 만드는거부터 어려웠음..
//인접한 집끼리 색이 겹치면 안되기 때문에 단순 최소값을 먼저 고려하면 안되고
//기준 색깔과 다른 두 개의 색의 최소비용에 기준색의 비용을 합산한 경로들을 찾아서
//마지막에 누적합의 최소치를 찾아줘야함

import java.util.Scanner;

public class bj1149 {
	
	static int[][] cost;
	static int[][] dp;
	
	// red = 0, green = 1, blue =2
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		cost = new int[N][3];
		dp = new int[N][3];
		
		for(int i=0; i<N; i++) {
			cost[i][0] = sc.nextInt();
			cost[i][1] = sc.nextInt();
			cost[i][2] = sc.nextInt();
		}
		
		//dp 첫 값을 각 색상의 첫 값으로 초기화
		dp[0][0] = cost[0][0];
		dp[0][1] = cost[0][1];
		dp[0][2] = cost[0][2];
		
		int ans = Math.min(paint(N-1,0),Math.min(paint(N-1,1), paint(N-1,2)));
		
		System.out.println(ans);
		
		
	}

	private static int paint(int N, int color) {
		
		//아직 탐색하지 않은 배열일 경우
		if(dp[N][color] == 0) {
			
			//색에 다라 이전 집의 서로 다른 색을 재귀호출해서 나온 최소값과 현재 집의 비용을 더해서 저장
			if(color == 0) {
				dp[N][0] = Math.min(paint(N-1, 1),paint(N-1,2)) + cost[N][0];
			}
			else if(color == 1) {
				dp[N][1] = Math.min(paint(N-1,0),paint(N-1,2)) + cost[N][1];
			}
			else {
				dp[N][2] = Math.min(paint(N-1,0),paint(N-1,1)) + cost[N][2];
			}
		}
	return dp[N][color];
	}

}
