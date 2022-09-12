package BOJ_0912;

import java.util.ArrayList;
import java.util.Scanner;

// 반례가 뭘까요,,
public class 트리의지름 {

	static int V;
	static ArrayList<int[]>[] list; // 인접리스트
	static boolean[] check;

	static int l;
	static int max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		V = sc.nextInt(); // 트리 정점의 개수
		list = new ArrayList[V + 1];

		l = 0;
		max = 0;

		for (int i = 1; i <= V; i++) {
			list[i] = new ArrayList<int[]>();
		}

		for (int i = 0; i < V; i++) {
			int n = sc.nextInt(); // 정점 번호
			while (true) {

				int a = sc.nextInt(); // 연결된 정점 번호
				if (a == -1) // 종료 조건
					break;
				int b = sc.nextInt(); // 거리

				list[n].add(new int[] { a, b });
			}
		}

		check = new boolean[V + 1];
		for (int i = 1; i <= V; i++) {
			if (!check[i]) {
				dfs(i);
			}
		}
		
		// 출력
		System.out.println(max);
	}

	private static void dfs(int i) {

		// 종료 조건
		if (check[i]) {
			return;
		}

		check[i] = true;

		for (int[] v : list[i]) {
			if (!check[v[0]]) {
				l = 0; // 새 경로 시작하면서 값 초기화
				dfs(v[0]);
				l += v[1]; // 빠져나오면서 l값 갱신
			}
			max = Math.max(max, l); // 마지막에 max값 갱신
		}
	}
}
