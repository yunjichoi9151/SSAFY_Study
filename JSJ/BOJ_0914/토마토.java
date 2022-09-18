package BOJ_0914;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 토마토 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int M = sc.nextInt(), N = sc.nextInt(); // 가로 세로

		int[][] tomato = new int[N][M];
		int cnt = 0, days = 0;

		Queue<int[]> que = new LinkedList<>();

		for (int n = 0; n < N; n++)
			for (int m = 0; m < M; m++) {
				tomato[n][m] = sc.nextInt(); // 배열 입력

				// 익은 토마토일 경우
				if (tomato[n][m] == 1)
					que.add(new int[] { n, m });

				// 안익은 토마토가 있을 경우
				else if (tomato[n][m] == 0)
					cnt++;
			}

		while (cnt > 0 && !que.isEmpty()) {
			for (int s = que.size(); s > 0; s--) { // queue 사이즈 만큼 반복
				int[] tmp = que.poll();

				// 4방탐색
				int[] dx = { 0, 0, -1, 1 };
				int[] dy = { -1, 1, 0, 0 };

				for (int d = 0; d < 4; d++) {
					int cx = tmp[1] + dx[d];
					int cy = tmp[0] + dy[d];

					if (cy < 0 || cx < 0 || cy >= N || cx >= M || tomato[cy][cx] != 0)
						continue;

					cnt--;

					tomato[cy][cx] = 1;
					que.add(new int[] { cy, cx });
				}
			}
			
			days++;
		}
		System.out.println(cnt == 0 ? days : -1);	// 일 수 갱신
	}
}