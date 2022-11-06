package pracprac.programmers.study.d1106;
//BFS, 그래프 문제
//해시맵으로 푼 사람도 있더라 https://lts0606.tistory.com/600
//

import java.util.LinkedList;
import java.util.Queue;

public class 전력망을둘로나누기 {
	static int[][] arr; //인접행렬 선언

	public int solution(int n, int[][] wires) {
		int answer = n;
		arr = new int[n + 1][n + 1];
		
		//인접행렬에 wires 연결 정보 담기
		for (int i = 0; i < wires.length; i++) {
			arr[wires[i][0]][wires[i][1]] = 1;
			arr[wires[i][1]][wires[i][0]] = 1;
		}
		
		//간선을 끊으면서 bfs
		int x, y;
		for (int i = 0; i < wires.length; i++) {
			x = wires[i][0];
			y = wires[i][1];
			
			//연결 끊기
			arr[x][y] = 0;
			arr[y][x] = 0;

			answer = Math.min(answer, bfs(n, x));
			
			//bfs 순회 후 재연결
			arr[x][y] = 1;
			arr[y][x] = 1;
		}

		return answer;
	}

	public int bfs(int n, int start) {
		int[] visit = new int[n + 1];
		int cnt = 1;
		
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);

		while (!queue.isEmpty()) {
			int cur = queue.poll();
			visit[cur] = 1;

			for (int i = 1; i <= n; i++) {

				if (visit[i] == 1)
					continue;
				
				//연결된 간선 중 방문한 적 없는 노드 전부 순회
				if (arr[cur][i] == 1) {
					queue.offer(i);
					cnt++;
				}
			}
		}
		//송전탑 갯수의 차이 절대값 도출
		return (int) Math.abs(cnt - (n - cnt));
	}
}
