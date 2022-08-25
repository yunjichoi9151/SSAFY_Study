package day0819;

import java.util.Scanner;

public class SWEA_스도쿠검증 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int[][] sudoku = new int[9][9];
			int[][] count = new int[27][10];
			boolean check = true;

			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sudoku[i][j] = sc.nextInt();
				}
			}
			// 가로
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					if (count[i][sudoku[i][j]] == 0) {
						count[i][sudoku[i][j]] += 1;
					} else {
						check = false;
						break;
					}
				}
			}
			// 세로
			if(check) {
			for (int j = 0; j < 9; j++) {
				for (int i = 0; i < 9; i++) {
					if (count[i + 9][sudoku[i][j]] == 0) {
						count[i + 9][sudoku[i][j]] += 1;
					} else {
						check = false;
						break;
					}
				}
			}
			}
			// 그리드
			if(check) {
			for (int a = 0; a < 3; a++) {
				for (int b = 0; b < 3; b++) {
					for (int i = 0; i < 3; i++) {
						for (int j = 0; j < 3; j++) {
							if (count[3 * a + b + 18][sudoku[3 * a + i][3 * b + j]] == 0) {
								count[3 * a + b + 18][sudoku[3 * a + i][3 * b + j]] += 1;
							} else {
								check = false;
								break;
							}
						}
					}

				}
			}
			}

			if (check==true)
				System.out.println("#" + tc + " " + 1);
			else
				System.out.println("#" + tc + " " + 0);

		}
	}
}
