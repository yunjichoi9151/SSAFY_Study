package week3_IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스도쿠검증 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		int[][] puzzle = new int[9][9];

		for (int t = 1; t <= T; t++) {

			// 퍼즐 채우기
			for (int i = 0; i < 9; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 9; j++) {
					puzzle[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			boolean[] check = new boolean[10];
			int answer = 0;

			out: for (int i = 0; i < 9; i++) {

				// 가로
				for (int j = 0; j < 9; j++) {
					if (check[puzzle[i][j]] == false) {
						check[puzzle[i][j]] = true;
					} else {
						break out;
					}
				}

				// 세로
				for (int j = 0; j < 9; j++) {
					if (check[puzzle[j][i]] == false) {
						check[puzzle[j][i]] = true;
					} else {
						break out;
					}
				}

				
				// 모두 통과시
				answer = 1;
			}

			System.out.println("#" + t + " " + answer);
		}
	}
}
