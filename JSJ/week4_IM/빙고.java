package week4_IM;

import java.util.Scanner;

public class 빙고 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 빙고판 채우기
		int[][] board = new int[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				board[i][j] = sc.nextInt();
			}
		}

		int[][] count = new int[2][5]; // 가로 세로
		int[] Xcount = new int[2]; // 대각선
		boolean bingo = false; // 빙고판별

		int cnt = 0; // 사회자가 부른 횟수
		int line = 0; // 빙고라인 수

		// 빙고가 아닌동안
		while (bingo != true) {

			int k = sc.nextInt(); // 사회자가 부른 수
			cnt++; // 사회자가 부를 때마다 카운트

			// line이 3개 이상일 때 빙고
			if (line >= 3) {
				bingo = true;
			}

			// 빙고판 탐색
			out: for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {

					// 수가 맞을 때
					if (k == board[i][j]) {

						// 해당 열 or 행 개수+1
						count[0][i]++;
						count[1][j]++;

						// 대각선
						if (i == j) {
							Xcount[0]++;
						}
						if (j == 4 - i) {
							Xcount[1]++;
						}

						// 빙고일 때 line+1
						if (count[0][i] == 5 || count[1][j] == 5 || Xcount[0] == 5 || Xcount[1] == 5) {
							line++;
						}

						break out;
					}
				}
			}

		}

		System.out.println(cnt);
	}
}