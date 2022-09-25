package BOJ_0918;

import java.util.Scanner;

	//조건
	// 1. 출발 직후부터 50m가 되기 전 마다 맥주 한병씩 (20개로 시작)
	// 2. 편의점에서 맥주 추가로 구매 가능 - 필수 방문 X
	// 3. 빈병은 버릴 수 있지만 20개를 넘는 맥주를 가질수는 없음
	// 4. 두 좌표 사이는 맨해튼 거리로 계산(X좌표 차이 + Y좌표 차이)

public class 맥주마시면서걸어가기 {
	
	static int beer;
	static int store;
	static int[][] Loc;
	static boolean[] check;
	static boolean arrive;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // tc 개수
		for (int t = 1; t <= T; t++) {

			arrive = false;
			beer = 20;
			store = sc.nextInt(); // 편의점 개수
			check = new boolean[store + 2]; // 들렸는지 check

			// 좌표 받기
			Loc = new int[store + 2][2];

			// 집 (출발)
			Loc[0][0] = sc.nextInt();
			Loc[0][1] = sc.nextInt();

			// 편의점
			for (int s = 1; s <= store; s++) {
				Loc[s][0] = sc.nextInt(); // 편의점 x
				Loc[s][1] = sc.nextInt(); // 편의점 y
			}

			// 페스티벌 (도착)
			Loc[store + 1][0] = sc.nextInt();
			Loc[store + 1][1] = sc.nextInt();

			// 출발
			dfs(0);

			// 출력
			if (arrive)
				System.out.println("happy");
			else
				System.out.println("sad");
		}
	}

	private static void dfs(int i) {

		// 종료 (페스티벌 도착)
		if (i == store + 1) {
			arrive = true;
			return;
		}

		check[i] = true; // 방문 표시
		
		// 방문하지  좌표 탐색
		for (int k = 0; k <= store + 1; k++) {
			
			// 방문 X
			if (!check[k]) {
				
				// 다음 지점까지의 거리
				int d = Math.abs(Loc[i][0] - Loc[k][0]) + Math.abs(Loc[i][1] - Loc[k][1]);

				// 탐색 가능 조건 (20개의 맥주로 갈 수 있는지 판단)
				if (d <= 1000 && d % 50 == 0 && d / 50 <= 20 || d <= 1000 && d % 50 != 0 && d / 50 < 20) {
					dfs(k);
				}
			}
		}
	}
}