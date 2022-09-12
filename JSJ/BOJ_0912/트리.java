package BOJ_0912;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// 그래프가 주어졌을 때 트리의 개수를 세라
public class 트리 {

	static ArrayList<Integer>[] adj; // 인접리스트
	static boolean[] check; // 방문 판별
	static boolean flag; // 트리 판별

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = 0;
		while (true) {

			int n = sc.nextInt(); // 정점 개수
			int k = sc.nextInt(); // 간선 개수

			adj = new ArrayList[n + 1];
			check = new boolean[n + 1];

			if (n == 0)
				break;

			for (int i = 0; i < n + 1; i++) {
				adj[i] = new ArrayList<Integer>();
			}

			for (int i = 0; i < k; i++) {
				int n1 = sc.nextInt(); // 정점1
				int n2 = sc.nextInt(); // 정점2

				adj[n1].add(n2);
				adj[n2].add(n1);
			}

			System.out.println(Arrays.deepToString(adj));

			int cnt = 0;
			for (int i = 1; i <= n; i++) {
				flag = false;

				if (!check[i]) { // 정점을 방문하지 않았을 때
					dfs(i, 0);

					if (!flag) {
						cnt++;
					}
				}
			}
			print(++T, cnt);
		}
	}

	static void dfs(int cur, int pre) {

		check[cur] = true; // 방문 처리

		// 현재 노드와 연결관계 노드 탐색
		for (int v : adj[cur]) {
			if (!check[v]) { // 방문 전일때
				dfs(v, cur);
			} else if (check[v] && v != pre) { // 사이클 존재
				flag = true;
			}
		}
	}

	// 출력
	static void print(int T, int cnt) {

		System.out.print("Case " + T + ": ");
		if (cnt == 0) {
			System.out.println("No trees.");
		} else if (cnt == 1) {
			System.out.println("There is one tree.");
		} else {
			System.out.println("A forest of " + cnt + " trees.");
		}
	}
}
