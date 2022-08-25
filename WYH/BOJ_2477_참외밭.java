package day0818;

import java.util.Scanner;

public class BOJ_2477_참외밭 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] ground = new int[6];
		for (int i = 0; i < 6; i++) {
			int dir = sc.nextInt();
			int dis = sc.nextInt();

			ground[i] = dis;

		}

		int large = 0;
		int small = 0;
		int idx = -1;
		for (int i = 0; i < 6; i++) {
			int tmp = ground[i] * ground[(i + 1) % 6];
			if (large < tmp) {
				large = tmp;
				idx = i;
			}
		}
		small = ground[(idx + 3) % 6] * ground[(idx + 4) % 6];
		System.out.println(N * (large - small));
	}
}
