package week2_recursion;

import java.util.Scanner;

public class N2447_별찍기10 {

	static char[][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		arr = new char[N][N]; // 전체 문자를 담을 배열

		star(0, 0, N, false);

		// 출력
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(arr[i][j]);
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

	public static void star(int x, int y, int N, boolean blank) {

		// 공백칸
		if (blank) {
			for (int i = x; i < x + N; i++) {
				for (int j = y; j < y + N; j++) {
					arr[i][j] = ' ';
				}
			}
			return;
		}

		// 블럭의 최소단위
		if (N == 1) {
			arr[x][y] = '*';
			return;
		}

		int size = N / 3; // 해당 블록의 한 칸을 담을 변수
		int cnt = 0; // 별 출력 누적
		for (int i = x; i < x + N; i += size) {
			for (int j = y; j < y + N; j += size) {
				cnt++;
				if (cnt == 5) {
					star(i, j, size, true); // 빈칸 차례
				} else {
					star(i, j, size, false);
				}
			}
		}
	}

}
