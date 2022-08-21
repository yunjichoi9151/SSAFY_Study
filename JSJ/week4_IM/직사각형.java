package week4_IM;

import java.util.Scanner;

public class 직사각형 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 4; i++) {

			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();

			int x3 = sc.nextInt();
			int y3 = sc.nextInt();
			int x4 = sc.nextInt();
			int y4 = sc.nextInt();

			// 점
			if ((x2 == x3 || x1 == x4) && (y2 == y3 || y1 == y4)) {
				System.out.println("c");
			}

			// 겹치지 않을 때 (순서 중요)
			else if ((x2 < x3) || (x1 > x4) || (y2 < y3) || (y1 > y4)) {
				System.out.println("d");
			}

			// 선분
			else if ((y2 == y3) || (y1 == y4) || (x2 == x3) || (x1 == x4)) {
				System.out.println("b");
			}

			// 직사각형
			else {
				System.out.println("a");
			}

		}
	}
}
