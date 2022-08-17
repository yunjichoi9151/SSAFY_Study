package week4_IM;

import java.util.Scanner;

public class 색종이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[][] map = new int[100][100];

		int cnt = 0;

		for (int t = 0; t < n; t++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			for (int i = x; i < x + 10; i++) {
				for (int j = y; j < y + 10; j++) {
					if (map[i][j] == 1)
						continue;
					map[i][j] = 1;
					++cnt;
				}
			}
		}
		System.out.println(cnt);
	}
}