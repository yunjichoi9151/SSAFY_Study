package BOJ_0914;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 바이러스 {

	static int N; // 컴퓨터 개수
	static int M; // 네트워크 개수
	static int[][] adj; // 인접 행렬
	static boolean[] virus; // 감염 여부

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		adj = new int[N + 1][N + 1];
		virus = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();

			adj[u][v] = adj[v][u] = 1;
		}

		bfs(1);
	}

	static void bfs(int start) {
		Queue<Integer> que = new LinkedList<Integer>();

		virus[start] = true;
		que.add(start);

		int cnt = 0;

		while (!que.isEmpty()) {
			int curr = que.remove();

			for (int i = 1; i < N + 1; i++) {
				if (adj[curr][i] == 1 && !virus[i]) {
					virus[i] = true;
					que.add(i);
					cnt++; // dequeue된 수에 대해 cnt++
				}
			}
		}
		System.out.println(cnt);
	}

}
