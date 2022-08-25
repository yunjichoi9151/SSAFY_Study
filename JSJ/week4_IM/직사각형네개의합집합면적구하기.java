package week4_IM;

import java.util.Scanner;

public class 직사각형네개의합집합면적구하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] rec = new int[101][101];

		for (int k = 0; k < 4; k++) {

			int startX = sc.nextInt();
			int startY = sc.nextInt();

			int endX = sc.nextInt();
			int endY = sc.nextInt();

			for (int i = startY; i < endY; i++) {
				for (int j = startX; j < endX; j++) {
					if (rec[i][j] == 0) {
						rec[i][j]++;
					}
				}
			}
		}

		int sum = 0;
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				if (rec[i][j] == 1)
					sum++;
			}
		}

		System.out.println(sum);

	}
}