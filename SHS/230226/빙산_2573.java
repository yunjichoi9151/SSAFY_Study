package 이공이삼이월.d230222;

import java.util.Scanner;

public class 빙산_2573 {

	static int N, M, cnt, y;
	static int[] dr = { -1, 0, 0, 1 };
	static int[] dc = { 0, -1, 1, 0 };
	static boolean[][] visited;
	static int map[][];
	static int melted[][];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		melted = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		y = 0;

		while (true) {
			cnt = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (visited[i][j] == false && map[i][j] != 0) {
						DFS(i, j);
						cnt++;
					}
				}
			}

			if (cnt == 0) {
				System.out.println(0);
				break;
			} else if (cnt >= 2) {
				System.out.println(y);
				break;
			}

			Melt();
			y++;

		}
	}

	private static void DFS(int r, int c) {

		visited[r][c] = true;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
				continue;
			}
			if (map[nr][nc] == 0) {
				melted[r][c]++;
			}
			if (visited[nr][nc] == false && map[nr][nc] != 0) {
				DFS(nr, nc);
			}
		}
	}

	private static void Melt() {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = map[i][j] - melted[i][j];

				if (map[i][j] < 0) {
					map[i][j] = 0;
				}

				visited[i][j] = false;
				melted[i][j] = 0;

			}
		}

	}

}
