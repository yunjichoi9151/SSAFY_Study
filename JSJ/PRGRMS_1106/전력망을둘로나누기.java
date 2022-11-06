package PRGRMS_1106;

import java.util.LinkedList;
import java.util.Queue;

public class 전력망을둘로나누기 {

	static int[][] map;

	public int solution(int n, int[][] wires) {
		int answer = n;
		map = new int[n + 1][n + 1];

		// 1. 인접행렬에 input
		for (int i = 0; i < wires.length; i++) {
			map[wires[i][0]][wires[i][1]] = 1;
			map[wires[i][1]][wires[i][0]] = 1;
		}

		// 2. 선을 하나씩 끊어보며 순회
		int a, b;
		for (int i = 0; i < wires.length; i++) {
			a = wires[i][0];
			b = wires[i][1];

			// 선을 하나 끊고
			map[a][b] = 0;
			map[b][a] = 0;

			// bfs
			answer = Math.min(answer, bfs(n, a));

			// 선 다시 복구
			map[a][b] = 1;
			map[b][a] = 1;
		}

		return answer;
	}

	public int bfs(int n, int start) {
		int[] visit = new int[n + 1];
		int cnt = 1;

		Queue<Integer> q = new LinkedList<>();
		q.add(start);

		while (!q.isEmpty()) {
			int point = q.poll();
			visit[point] = 1;

			// point와 연결된 애들 중에 방문한적 없는 노드 전부 큐에 넣기
			for (int i = 1; i <= n; i++) {
				if (visit[i] == 1)
					continue;
				if (map[point][i] == 1) {
					q.add(i);
					cnt++;
				}
			}
		}

		// cnt-(n-cnt);
		return (int) Math.abs(n - 2 * cnt);
	}
}