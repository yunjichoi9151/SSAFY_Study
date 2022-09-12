package BOJ_0912;

import java.util.ArrayList;
import java.util.Scanner;

// 시간초과
public class 트리의지름 {

	static int V;
	static ArrayList<Node>[] adj; // 인접리스트
	static boolean[] visit;
	static int max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		V = sc.nextInt(); // 트리 정점의 개수

		adj = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			adj[i] = new ArrayList<Node>();
		}

		for (int i = 0; i < V; i++) {
			int n1 = sc.nextInt(); // 정점 번호

			while (true) {
				int n2 = sc.nextInt(); // 연결된 정점 번호
				if (n2 == -1) // 종료 조건
					break;
				int d = sc.nextInt(); // 거리

				adj[n1].add(new Node(n2, d));
				adj[n2].add(new Node(n1, d));
			}
		}

		max = 0;
		for (int i = 1; i <= V; i++) {
			visit = new boolean[V + 1];
			if (!visit[i]) {

				dfs(i, 0);
			}
		}

		// 출력
		System.out.println(max);
	}

	private static void dfs(int num, int dim) {
		visit[num] = true;

		for (Node node : adj[num]) {
			if (!visit[node.num]) {
				dfs(node.num, dim + node.len);
			}
		}
		max = Math.max(max, dim);
	}

	static class Node {
		int num, len;

		public Node(int num, int len) {
			this.num = num;
			this.len = len;
		}
	}
}