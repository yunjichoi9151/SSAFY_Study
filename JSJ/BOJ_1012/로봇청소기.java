package BOJ_1012;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 청소 영역의 개수
public class 로봇청소기 {
	public static int N, M;
	public static int[][] map;
	public static int cnt = 0;
	public static int[][] drc = { { -1, 0, 1, 0 }, { 0, 1, 0, -1 } }; // 북,동,남,서

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		clean(r, c, d);

		bw.write(cnt + "\n");
		br.close();
		bw.flush();
		bw.close();
	}

	public static void clean(int r, int c, int dir) {
		// 1. 현재 위치를 청소한다.
		if (map[r][c] == 0) {
			map[r][c] = 2;
			cnt++;
		}

		// 2. 왼쪽방향부터 차례대로 탐색을 진행한다.
		boolean flag = false;
		int d = dir;
		for (int i = 0; i < 4; i++) {
			int newD = (dir + 3) % 4; // 방향 처리 어려웠음
			int cx = r + drc[0][newD];
			int cy = c + drc[1][newD];

			if (cx > 0 && cy > 0 && cx < N && cy < M) {
				if (map[cx][cy] == 0) { // 아직 청소하지 않은 공간이라면
					clean(cx, cy, newD);
					flag = true;
					break;
				}
			}
			dir = (dir + 3) % 4; // 방향 갱신
		}

		// 네 방향 모두 청소가 되어있거나 벽인 경우 (후진)
		if (!flag) {
			int newD = (d + 2) % 4;
			int cx = r + drc[0][newD];
			int cy = c + drc[1][newD];

			if (cx > 0 && cy > 0 && cx < N && cy < M) {
				if (map[cx][cy] != 1) {
					clean(cx, cy, d); // 바라보는 방향 유지한 채 후진
				}
			}
		}
	}
}