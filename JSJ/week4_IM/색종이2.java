package week4_IM;

import java.util.Scanner;

public class 색종이2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // 색종이 개수
		int[][] check = new int[102][102]; // 도화지(여유범위 설정)

		for (int t = 0; t < n; t++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			// 색종이 범위
			for (int i = x; i < x + 10; i++) {
				for (int j = y; j < y + 10; j++) {

					if (check[i][j] == 1)
						continue;

					check[i][j] = 1;
				}
			}
		}

		int cnt = 0;

		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		// 사방 탐색 (1일 때 , 주변이 0이면 cnt++)
		for (int i = 0; i < 102; i++) {
			for (int j = 0; j < 102; j++) {

				for (int d = 0; d < 4; d++) {
					int cx = i + dx[d];
					int cy = j + dy[d];

					if (cx >= 0 && cy >= 0 && cx < 102 && cy < 102 && check[i][j] == 1 && check[cx][cy] == 0) {
						cnt++;
					}

				}
			}
		}

		System.out.println(cnt);
	}
}