package BOJ_0921;

import java.util.Scanner;

public class Z {

	static int count = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // 배열 크기 : 2^N * 2^N

		// r행 c열을 몇 번째로 방문했는지 구해라
		int r = sc.nextInt();
		int c = sc.nextInt();

		int size = (int) Math.pow(2, n);

		find(size, r, c);
		System.out.println(count);

	}

	private static void find(int size, int r, int c) {
		if (size == 1)
			return;

		if (r < size / 2 && c < size / 2) { // 1사분면
			find(size / 2, r, c);
		} else if (r < size / 2 && c >= size / 2) { // 2사분면
			count += size * size / 4;
			find(size / 2, r, c - size / 2);
		} else if (r >= size / 2 && c < size / 2) { // 3사분면
			count += (size * size / 4) * 2;
			find(size / 2, r - size / 2, c);
		} else { // 4사분면
			count += (size * size / 4) * 3;
			find(size / 2, r - size / 2, c - size / 2);
		}
	}

}
