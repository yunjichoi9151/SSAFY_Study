package BOJ_0914;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// dfs 
public class 단지번호붙이기 {

	static int N;
	static int[][] arr;
	static boolean[][] check;
	static int num;
	static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		// 배열 입력
		arr = new int[N][N];
		check = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}

		cnt = 0; // 단지 수
		num = 0; // 단지내 집 수

		ArrayList<Integer> level = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!check[i][j] && arr[i][j] == 1) {
					num++;
					dfs(i, j);

					// 층수 기록
					if (num > 0) {
						level.add(num);
						++cnt;
					}
					num = 0;
				}
			}
		}

		// 단지 오름차순 출력 조건 유의
		Collections.sort(level);

		System.out.println(cnt);
		for (Integer i : level) {
			System.out.println(i);
		}
	}

	static void dfs(int i, int j) {

		check[i][j] = true;

		// 사방탐색
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		for (int r = 0; r < 4; r++) {
			int cx = i + dx[r];
			int cy = j + dy[r];

			if (cx >= 0 && cx < N && cy >= 0 && cy < N && arr[cx][cy] == 1 && !check[cx][cy]) {
				check[i][j] = true;
				num++;
				dfs(cx, cy);
			}
		}
	}
}
