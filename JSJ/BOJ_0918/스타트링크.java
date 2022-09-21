package BOJ_0918;

import java.util.Scanner;

// 입력 
// 첫째 줄:  F, S, G, U, D 
// 가장 낮은 층: 1, 가장 높은 층: F, 현재 위치: S, 도착 위치: G
// 위로 : U 버튼 n회, 아래로: D버튼 n회 

// 조건
// 1 ≤ S, G ≤ F ≤ 1000000, 0 ≤ U, D ≤ 1000000
// 해당 층이 없을 경우 U,D 움직임 X

// 출력
// G층에 도착하려고 할 때, 버튼을 몇 번 눌러야 하는가? (최소값)
// 도착 불가능일 때: System.out.println("use the stairs");

// 시간 어떻게 줄이지? bfs 사용?
public class 스타트링크 {

	static int F; // 최상층
	static int S; // 현재위치
	static int G; // 도착 위치

	// 한번에 움직이는 층 수 입력받음
	static int U;
	static int D;

	static boolean[] visit; // 방문 check
	static int cnt = 0; // 엘레베이터 움직인 시점 cnt

	static boolean stairs = true; // 엘베 vs 계단

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		F = sc.nextInt(); // 최상층
		S = sc.nextInt(); // 현재위치
		G = sc.nextInt(); // 도착 위치

		// 한번에 움직이는 층 수 입력받음
		U = sc.nextInt();
		D = sc.nextInt();

		visit = new boolean[F + 1];

		// 시작
		dfs(S);

		// 출력
		if (!stairs)
			System.out.println(cnt);
		else
			System.out.println("use the stairs");
	}

	private static void dfs(int i) {

		if (i == G) {
			stairs = false;
			return;
		}

		if (visit[i])
			return;

		visit[i] = true;
		cnt++;

		int up = i + U;
		int down = i - D;

		if (i < G && up <= F && !visit[up] || i > G && down < 1 && up <= F) {
			dfs(up);
		}

		if (i > G && down >= 1 && !visit[down] || i < G && up > F && down >= 1) {
			dfs(down);
		}
	}
}