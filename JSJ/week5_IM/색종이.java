package week5_IM;

import java.util.Scanner;

public class 색종이 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[][] board = new int[1001][1001];

		// 가장 왼쪽 아래 칸의 번호
		int c = 0;
		int r = 0;

		// 너비, 높이
		int w = 0;
		int h = 0;

		int N = sc.nextInt();
		for (int n = 1; n <= N; n++) {

			c = sc.nextInt();
			r = sc.nextInt();

			w = sc.nextInt();
			h = sc.nextInt();

			// 색종이 범위만큼 해당 색종이 순서로 표시
			for (int i = r; i < r + h; i++) {
				for (int j = c; j < c + w; j++) {
					board[i][j] = n;
				}
			}
		}

		int cnt = 0;
		for (int n = 1; n <= N; n++) {

			for (int i = 0; i < 1001; i++) {
				for (int j = 0; j < 1001; j++) {
					if (board[i][j] == n) {	// 겹쳐진 부분은 다른 숫자로 덮였기 때문에 신경 X
						cnt++;
					}
				}
			}

			System.out.println(cnt);
			cnt = 0;
		}
	}
}
