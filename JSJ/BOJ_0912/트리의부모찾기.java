package BOJ_0912;

import java.util.ArrayList;
import java.util.Scanner;

// 이진트리가 아님 (연결된 그래프 구조)
public class 트리의부모찾기 {

	static int N;

	static int[] parent;
	static boolean[] check;

	static ArrayList<Integer>[] list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		parent = new int[N + 1];
		check = new boolean[N + 1];

		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for (int i = 1; i < N; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			list[a].add(b);
			list[b].add(a);
		}

		for (int i = 1; i <= N; i++) {
			if (!check[i]) {
				dfs(i);
			}
		}

		for (int i = 2; i <= N; i++) {
			System.out.println(parent[i]);
		}
	}

	private static void dfs(int i) {
		if (check[i])
			return;

		check[i] = true;
		for (int v : list[i]) {
			if (!check[v]) {
				parent[v] = i;
				dfs(v);
			}
		}
	}
}