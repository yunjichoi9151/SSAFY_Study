package week8_heap;

import java.util.Scanner;

public class 트리 {

	static int pre[]; // 전위순회
	static int in[]; // 중위순회

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		while (t-- > 0) {

			int n = sc.nextInt();	// 노드 개수

			pre = new int[n + 1];
			in = new int[n + 1];

			// 전위 순회 입력
			for (int i = 0; i < n; i++)
				pre[i] = sc.nextInt();

			// 중위 순회 입력
			for (int i = 0; i < n; i++)
				in[i] = sc.nextInt();

			// 후위 순회
			postorder(0, n, 0);
			System.out.println();	// 출력 형식 맞추기
		}
	}

	// 후위 순회
	public static void postorder(int s, int e, int r) { // 시작 , 끝, 루트 노드 인덱스 받기

		for (int i = s; i < e; i++) {
			// 중위순회 i 인덱스의 요소가 루트값일 때 (루트 찾기)
			if (in[i] == pre[r]) {	
				postorder(s, i, r + 1);	// i(이전 루트) 기준 왼쪽 탐색 : 루트 노드 인덱스 r+1로 갱신
				postorder(i + 1, e, r + i - s + 1);	// i(이전 루트) 기준 오른쪽 탐색 : 루트 노드 인덱스 r+i-s+1 로 갱신
				System.out.print(pre[r] + " ");
			}
		}
	}
}