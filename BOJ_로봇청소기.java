package day1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_로봇청소기 {
	static int y, x, count, r, c, d;
	static int map[][];
	static int dy[] = { -1, 0, 1, 0 }; // 북동남서
	static int dx[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		y = Integer.parseInt(stk.nextToken());
		x = Integer.parseInt(stk.nextToken());
		map = new int[y][x];
		stk = new StringTokenizer(br.readLine(), " ");
		r = Integer.parseInt(stk.nextToken());
		c = Integer.parseInt(stk.nextToken());
		d = Integer.parseInt(stk.nextToken()); // 0북 , 1동, 2남, 3서
		count = 1;
		for (int i = 0; i < y; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < x; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		dfs(r, c, d);
		System.out.println(count);
	}

	public static void dfs(int r, int c, int direction) {
		map[r][c] = -1; 
		for (int i = 0; i < 4; i++) {
			direction = (direction + 3) % 4; // 왼쪽 방향으로 (북 -> 서 -> 남 -> 동)
			int ny = r + dy[direction];
			int nx = c + dx[direction];
			if (ny >= 0 && ny < y && nx >= 0 && nx < x && map[ny][nx] == 0) {
				count++;
				dfs(ny, nx, direction);
				return;
			}
		}
		int back = (direction + 2) % 4;
		int by = r + dy[back];
		int bx = c + dx[back];
		if (by >= 0 && by < y && bx >= 0 && bx < x && map[by][bx] != 1) {
			dfs(by, bx, direction);
		}
	}

}
