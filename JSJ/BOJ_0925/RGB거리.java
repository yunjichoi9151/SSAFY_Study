package BOJ_0925;

import java.util.Scanner;

public class RGB거리 {
	static final int R = 0;
	static final int G = 1;
	static final int B = 2;

	static int N;
	static int[][] Cost; // R,G,B
	static int[][] DP;
	static int min;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		Cost = new int[N][3]; // R,G,B
		min = Integer.MAX_VALUE;
		DP = new int[N][3];

		for (int i = 0; i < N; i++) {
			Cost[i][R] = sc.nextInt();
			Cost[i][G] = sc.nextInt();
			Cost[i][B] = sc.nextInt();
		}

		// 초기세팅 (시작 지점)
		DP[0][R] = Cost[0][R];
		DP[0][G] = Cost[0][G];
		DP[0][B] = Cost[0][B];

		// 3가지 경우에 대해 min 값 갱신 (거꾸로탐색)
		System.out.print(Math.min(Paint_cost(N - 1, R), Math.min(Paint_cost(N - 1, G), Paint_cost(N - 1, B))));
	}

	// 첫번째 줄에 초기값 세팅 상태 -> 거꾸로 탐색 시작해서 행이 0일 때 멈춤
	static int Paint_cost(int N, int color) {

		// 만약 탐색하지 않은 배열이라면
		if (DP[N][color] == 0) {

			// color의 색에 따라 이전 집의 서로 다른 색을 재귀호출하여 최솟값과 현재 집의 비용을 더해서 DP에 저장한다
			if (color == R) {
				DP[N][R] = Math.min(Paint_cost(N - 1, G), Paint_cost(N - 1, B)) + Cost[N][R];
			} else if (color == G) {
				DP[N][G] = Math.min(Paint_cost(N - 1, R), Paint_cost(N - 1, B)) + Cost[N][G];
			} else {
				DP[N][B] = Math.min(Paint_cost(N - 1, R), Paint_cost(N - 1, G)) + Cost[N][B];
			}

		}

		return DP[N][color];
	}
}