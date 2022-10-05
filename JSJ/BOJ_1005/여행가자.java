package BOJ_1005;

import java.util.Scanner;

// 계획대로 방문 가능한지 판별
public class 여행가자 {

	static int parents[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		// 대표자 초기화
		parents = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				int value = sc.nextInt();

				if (value == 1)
					union(i, j);
			}
		}

		int start = find(sc.nextInt());
		for (int i = 0; i < M - 1; i++) {
			if (start != find(sc.nextInt())) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}

	// x의 대표자 찾기 (부모 노드 찾기)
	private static int find(int x) {
		if (parents[x] == x)
			return x;
		return parents[x] = find(parents[x]);
	}

	// x, y 같은 그래프로 합치기
	private static void union(int x, int y) {
		// x, y 부모 찾기
		x = find(x);
		y = find(y);

		// 부모가 다를 경우 y의 부모를 x로 변환 -> 부모 통일
		if (x != y) {
			parents[y] = x;
		}
	}
}