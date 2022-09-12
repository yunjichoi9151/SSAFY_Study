package BOJ_0912;

import java.util.ArrayList;
import java.util.Scanner;

public class 트리의지름 {

	static ArrayList<Node>[] adj;
	static boolean[] visited;
	static int max = 0;
	static int node;

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);

		int V = scan.nextInt();
		adj = new ArrayList[V + 1];
		for (int i = 1; i < V + 1; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < V; i++) {
			int n1 = scan.nextInt();
			while (true) {
				int n2 = scan.nextInt();
				if (n2 == -1)
					break;
				int d = scan.nextInt();
				adj[n1].add(new Node(n2, d));
			}
		}

		// 임의의 노드(1)에서 부터 가장 먼 노드를 찾는다. 이때 찾은 노드를 node에 저장한다.
		visited = new boolean[V + 1];
		dfs(1, 0);

		// node에서 부터 가장 먼 노트까지의 거리를 구한다.
		visited = new boolean[V + 1];
		dfs(node, 0);

		System.out.println(max);
	}

	public static void dfs(int num, int dim) {

		// 최대값 갱신
		if (dim > max) {
			max = dim;
			node = num;
		}

		visited[num] = true;

		for (int i = 0; i < adj[num].size(); i++) {
			Node node = adj[num].get(i);
			if (visited[node.num] == false) {
				dfs(node.num, node.dim + dim);
				visited[node.num] = true;
			}
		}
	}

	public static class Node {
		int num;
		int dim;

		public Node(int num, int dim) {
			this.num = num;
			this.dim = dim;
		}
	}
}