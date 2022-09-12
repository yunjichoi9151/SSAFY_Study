package BOJ_0912;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// 반례가 멀까,,ㅜ
// 그래프가 주어졌을 때 트리의 개수를 세라
public class 트리 {

	static int n;
	static int m;

	static ArrayList<Integer>[] list; // 인접리스트
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

				if (a < b)
					list[a].add(b);
				else
					list[b].add(a);
			}

			System.out.println(Arrays.toString(list));
			for (int i = 1; i <= n; i++) {
				if (!check[i]) {
					dfs(i);
				}
			}

			// 출력
			print(T, cnt);

		}
	}

	static void dfs(int i) {

		if (check[i]) // 종료 조건
			return;
		else if (list[i].isEmpty() && !check[i]) // 개수 증가 조건
			cnt++;

		check[i] = true; // 방문 표시

		for (int v : list[i]) {
			if (!check[v]) { // 미방문일 경우 재귀 실행
				dfs(v);
			} else { // 방문한 경우 (트리 자격 상실)
				cnt = 0;
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
