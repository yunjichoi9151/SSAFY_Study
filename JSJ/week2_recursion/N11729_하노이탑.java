package week2_recursion;

import java.util.Scanner;

public class N11729_하노이탑 {

	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 원판의 개수

		sb.append((int) (Math.pow(2, N)) - 1).append('\n');
		hanoi(N, 1, 3, 2);

		System.out.println(sb);

	}

	public static void hanoi(int N, int start, int to, int via) {

		// 원판이 1개일 때 (종료조건)
		if (N == 1) {
			sb.append(start + " " + to + '\n');
		} else {
			// 1. N-1개를 A -> B 로 이동
			hanoi(N - 1, start, via, to);
			// 2. 가장 큰 1개(N)를 A -> C 로 이동
			sb.append(start + " " + to + '\n');
			// 3. N-1개를 B -> C 로 이동
			hanoi(N - 1, via, to, start);
		}
	}
}
