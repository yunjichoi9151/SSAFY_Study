package BOJ_0912;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// 그래프가 주어졌을 때 트리의 개수를 세라
public class 트리 {

	static int n;
	static int m;

	static ArrayList<Integer>[] list;
//	static int[] tree;
	static boolean[] check;

	static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = 0; // tree > 1 일 때 출력용 TC

		while (true) {

			T++;

			n = sc.nextInt(); // 정점의 개수 (1 ~ n)
			m = sc.nextInt(); // 간선의 개수

			// 종료 조건
			if (n == 0) {
				break;
			}

			check = new boolean[n + 1]; // 트리 연결 check
			list = new ArrayList[n + 1];
			for (int i = 1; i <= n; i++) {
				list[i] = new ArrayList<Integer>();
			}

			cnt = 0;

			// m개의 간선
			for (int i = 0; i < m; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();

				list[a].add(b);
			}
//			System.out.println(Arrays.deepToString(list));

			for (int i = 1; i <= n; i++) {
				if (!check[i]) {
					dfs(i);
				}
			}

			System.out.println(cnt);

			// 출력
			print(T, cnt);

		}

	}

	// 개수 초기화 조건?
	static void dfs(int i) {

		if (check[i]) {
			cnt = 0;
			return;

		} else if (list[i].isEmpty() && !check[i]) {
			cnt++;
		}

		check[i] = true;
//		System.out.println(Arrays.toString(check));
//		System.out.println(cnt);

		for (int v : list[i]) {
			if (!check[v]) {
				dfs(v);
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
