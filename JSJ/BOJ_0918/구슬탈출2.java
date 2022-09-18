package BOJ_0918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 입력
// 1. 보드 입력 : 가로 N, 세로 M (3 ≤ N, M ≤ 10)
// 2. N개의 줄에 길이가 M인 문자열 주어짐
// 3.  '.', '#', 'O', 'R', 'B'

// 조건
// '.':빈칸 '#':장애물, 'O':구멍 위치 'R':빨간 구슬 'B':파란구슬
// 입력 보드의 가장자리는 모두 '#'	 - 밖으로 빠져나가지 않음
// 구멍, 빨간 구슬, 파란 구슬의 개수는 모두 1개
// 빨간구슬만 빼내야 함 (파란구슬이 빠지면 무조건 실패)
// 왼쪽, 오른쪽, 위쪽, 아래쪽 기울이기 가능
// 각 동작에서 구슬은 동시에 움직임
// 구슬이 더이상 움직이지 않을 때 동작 중지

// 동작
// 사방탐색으로 상하좌우 끝까지 탐색
// R, B 같이 고려해야 함
// 상하좌우 동작 실행 후 R,B 현위치 저장, 장애물 탐색, 상하좌우 실행

// 출력
// 몇 번 만에 구멍을 통해 빨간구슬을 빼낼 수 있는지를 출력
// 10번 이하로 움직여 빼낼 수 없을 경우 -1 출력

// bfs 더 공부
public class 구슬탈출2 {

	static int N, M;

	static int[][] board;
	static boolean[][][][] check;
	static int min = Integer.MAX_VALUE;

	// 사방탐색
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new int[N][M];
		check = new boolean[N][M][N][M];

		int Rx = 0, Ry = 0;
		int Bx = 0, By = 0;
		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split("");
			for (int j = 0; j < M; j++) {

				char ch = str[j].charAt(0);
				board[i][j] = ch;
				if (ch == 'R') {
					Rx = i;
					Ry = j;
				} else if (ch == 'B') {
					Bx = i;
					By = j;
				}
			}
		}

		bfs(Rx, Ry, Bx, By, 0);

		// 출력
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}

	static void bfs(int rx, int ry, int bx, int by, int cnt) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { rx, ry, bx, by, cnt });
		check[rx][ry][bx][by] = true;

		while (!q.isEmpty()) {
			int[] pos = q.poll();
			int pCnt = pos[4];

			// 실패 조건
			if (pCnt >= 10) {
				return;
			}

			for (int i = 0; i < 4; i++) {
				int cRx = pos[0];
				int cRy = pos[1];
				int cBx = pos[2];
				int cBy = pos[3];

				// 빨간 구슬 이동
				while (board[cRx + dx[i]][cRy + dy[i]] != '#') {
					cRx += dx[i];
					cRy += dy[i];
					if (board[cRx][cRy] == 'O')
						break;
				}

				// 파란 구슬 이동
				while (board[cBx + dx[i]][cBy + dy[i]] != '#') {
					cBx += dx[i];
					cBy += dy[i];
					if (board[cBx][cBy] == 'O')
						break;
				}

				// 파란 구슬이 구멍에 들어갔을 때
				if (board[cBx][cBy] == 'O')
					continue;

				// 빨간 구슬이 구멍에 들어갔을 때
				if (board[cRx][cRy] == 'O') {
					min = Math.min(min, pCnt + 1);
					return;
				}

				// 빨간 파랑 서로 만났을 때
				if (cRx == cBx && cRy == cBy && board[cRx][cRy] != 'O') {
					int red_move = Math.abs(cRx - pos[0]) + Math.abs(cRy - pos[1]);
					int blue_move = Math.abs(cBx - pos[2]) + Math.abs(cBy - pos[3]);

					// 인접해 있어야 하기 때문에 늦게 도착한 공위 위치를 한칸씩 빼줌
					// 파란 공이 더 빨리 도착한 경우
					if (red_move > blue_move) {
						cRx -= dx[i];
						cRy -= dy[i];
					} else { // 빨간 공이 더 빨리 도착한 경우
						cBx -= dx[i];
						cBy -= dy[i];
					}
				}

				if (!check[cRx][cRy][cBx][cBy]) {
					check[cRx][cRy][cBx][cBy] = true;
					q.add(new int[] { cRx, cRy, cBx, cBy, pCnt + 1 });
				}
			}
		}
	}
}
