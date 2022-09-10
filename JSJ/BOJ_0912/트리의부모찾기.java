package BOJ_0912;

import java.util.ArrayList;
import java.util.Scanner;

// 이진트리가 아님 (연결된 그래프 구조)
public class 트리의부모찾기 {

	static int N;

	// 리스트 배열 ArrayList<ArrayList<Integer>> 써도 되지만 길이가 정해져 있으니 배열 사용
	static ArrayList<Integer>[] list;
	static int[] parents;
	static boolean[] check;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		list = new ArrayList[N + 1];
		parents = new int[N + 1]; // 부모 노드
		check = new boolean[N + 1]; // 탐색 유무 체크

		// 인덱스별 리스트 생성 (1 ~ N)
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}

		// 1 ~ N-1
		for (int i = 1; i < N; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			// 연결관계 저장
			list[a].add(b); // a인덱스의 리스트에 b 추가
			list[b].add(a); // b인덱스의 리스트에 a 추가
		}

		// 1 ~ N (부모노드 저장)
		for (int i = 1; i <= N; i++) {
			if (!check[i]) {
				dfs(i);
			}
		}

		// 부모 출력 2~N
		for (int i = 2; i <= N; i++) {
			System.out.println(parents[i]);
		}
	}

	private static void dfs(int i) {

		// 이미 방문한 경우 종료
		if (check[i]) {
			return;
		}

		// 방문하지 않은 경우 
		check[i] = true;
		for (int v : list[i]) {	// i번째 요소의 리스트 값 순회
			if (!check[v]) {	// 방문X
				parents[v] = i;	// 해당 리스트 요소의 부모 노드는 i
				dfs(v);	// 해당 리스트 요소에 대한 dfs 실행
			}
		}
	}
}