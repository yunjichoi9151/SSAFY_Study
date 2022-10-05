package BOJ_1005;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 다익스트라 참고
public class 미확인도착지 {
	static class Node implements Comparable<Node> {
		int end, weight;

		public Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return weight - o.weight;
		}
	}

	static final int INF = 10_000_000;
	static int V, E, T;
	static int start, g, h;
	static int[][] graph;
	static int[] dist;
	static boolean[] check;
	static List<Integer> resultList;

	public void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testcase = Integer.parseInt(br.readLine());

		for (int i = 0; i < testcase; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			T = Integer.parseInt(st.nextToken());

			// 그래프 배열 선언
			graph = new int[V + 1][V + 1];
			dist = new int[V + 1];
			for (int j = 0; j < graph.length; j++)
				Arrays.fill(graph[j], INF);
			Arrays.fill(dist, INF);
			check = new boolean[V + 1];

			// s, g, h 초기화
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			// 그래프 정보 저장
			for (int j = 0; j < E; j++) {
				st = new StringTokenizer(br.readLine());
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());
				int distance = Integer.parseInt(st.nextToken());

				graph[v1][v2] = graph[v2][v1] = distance * 2;
			}

			graph[h][g] = graph[g][h] = graph[h][g] - 1;

			resultList = new ArrayList<>();
			for (int j = 0; j < T; j++)
				resultList.add(Integer.parseInt(br.readLine()));
			dijkstra();
			Collections.sort(resultList);
			for (int num : resultList)
				if (dist[num] % 2 == 1)
					bw.write(num + " ");
			bw.write("\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

	public static void dijkstra() {
		PriorityQueue<Node> pqueue = new PriorityQueue<>();
		pqueue.offer(new Node(start, 0));
		dist[start] = 0;

		while (!pqueue.isEmpty()) {
			Node now = pqueue.poll();
			int cur = now.end;

			if (!check[cur]) {
				check[cur] = true;

				for (int i = 1; i <= V; i++) {
					if (!check[i] && dist[i] > dist[cur] + graph[cur][i]) {
						dist[i] = dist[cur] + graph[cur][i];
						pqueue.offer(new Node(i, dist[i]));
					}
				}
			}
		}
	}
}
