package week4_IM;

import java.util.Scanner;

public class 개미 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int w = sc.nextInt(); // 가로
		int h = sc.nextInt(); // 세로

		// 좌표 (p,q)
		int p = sc.nextInt();
		int q = sc.nextInt();

		int t = sc.nextInt();

		int x = (p + t) % (2 * w);
		int y = (q + t) % (2 * h);

		x = w - Math.abs(w - x);
		y = h - Math.abs(h - y);

		System.out.println(x + " " + y);

	}
}