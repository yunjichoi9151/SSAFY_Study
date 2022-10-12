package BOJ_1012;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// bfs
public class 아기상어 {

	// 아기상어 크기 = 2
	// 자기보다 큰 물고기가 있는칸 못지나감
	// 자기보다 크기가 작은 물고기만 먹을 수 있음
	// 크기 같은 물고기 못먹음, 칸은 지나갈 수 있음

	// 먹을 수 있는 물고기 없으면 엄마불러 (종료)
	// 먹을 수 있는 물고기 1마리 => 먹어
	// 먹을 수 있는 물고기 1마리 이상 -> 가장 가까운 물고기 먹어 dfs?
	// 거리 : 맨하탄 거리 최소값 (초)
	// 같은 거리 물고기 다수 -> 1.가장 위에 있는 물고기 2.젤 왼쪽

	// 아기상어 크기와 같은 수의 물고기 먹으면 크기 +1
	// 엄마 안부르고 몇 초 동안 물고기 먹을 수 있니?

	static int n;
	static int[][] map;
	static int drc[][] = { { -1, 0, 1, 0 }, { 0, 1, 0, -1 } }; // 위 왼 아래 오

	static ArrayList<Node> fishes;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		map = new int[n][n];
		Queue<Node> q = new LinkedList<>(); // 물고기 위치, 거리

		// 입력
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();

				if (map[i][j] == 9) { // 아기상어 위치
					q.add(new Node(i, j, 0));
					map[i][j] = 0;
				}
			}
		}

		int eat = 0; // 먹은 고기
		int time = 0; // 걸린 시간
		int size = 2; // 아기상어

		while (true) {
			LinkedList<Node> fish = new LinkedList<>();
			int[][] dist = new int[n][n]; // 상어와의 거리

			while (!q.isEmpty()) {
				Node now = q.poll();

				for (int d = 0; d < 4; d++) {
					int cx = now.x + drc[0][d];
					int cy = now.y + drc[0][d];

					if (cx >= 0 && cy >= 0 && cx < n && cy < n && dist[cx][cy] == 0 && map[cx][cy] <= size) {
						dist[cx][cy] = dist[now.x][now.y] + 1; // 거리 갱신
						q.add(new Node(cx, cy, dist[cx][cy]));

						// 아기상어보다 작은 고기가 있을 때 -> 먹을 수 있음 (위치, 거리)
						if (1 <= map[cx][cy] && map[cx][cy] <= 6 && map[cx][cy] < size)
							fish.add(new Node(cx, cy, dist[cx][cy]));
					}
				}
			}

			// 먹을 수 있는 고기 다 먹었을 때
			if (fish.size() == 0) {
				System.out.println(time);
				return;
			}

			// 현재 위치
			Node currFish = fish.get(0);
			for (int i = 1; i < fish.size(); i++) {
				if (currFish.dist > fish.get(i).dist) { // 지금 고기보다 다른 고기가 위치가 더 가까울때
					currFish = fish.get(i);
				} else if (currFish.dist == fish.get(i).dist) { // 거리 같을 때
					// 좌표 기준 비교
					if (currFish.x > fish.get(i).x)
						currFish = fish.get(i);
					else if (currFish.x == fish.get(i).x) {
						if (currFish.y > fish.get(i).y)
							currFish = fish.get(i);
					}
				}
			}

			// 1칸 당 1초
			time += currFish.dist;
			eat++; // 먹은 고기 세기

			// 현재 좌표 먹을 고기 없을 때
			map[currFish.x][currFish.y] = 0;
			if (eat == size) { // 상어 사이즈랑 같으면 사이즈 증가
				size++;
				eat = 0; // 고기 초기화
			}
			q.add(new Node(currFish.x, currFish.y, 0));
		}
	}

	// 고기 위치, 거리
	public static class Node {
		int x;
		int y;
		int dist;

		public Node(int x, int y, int dist) {
			super();
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}
}