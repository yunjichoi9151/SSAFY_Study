package BOJ_1005;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 수빈이가 동생을 찾는 가장 빠른 시간을 구해라
// 틀림
public class 숨바꼭질3 {
	static int N;
	static int K;
	static int[] check = new int[100001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();

		if (N == K) {
			System.out.println(0);
		} else {
			bfs(N);
		}
	}

	static void bfs(int num) {
		Queue<Integer> q = new LinkedList<>();
		check[num] = 1;
		q.add(num);

		while (!q.isEmpty()) {
			int curr = q.poll();

			if (curr == K) {
				System.out.println(check[curr] - 1);
				return;
			}

			int walkLeft = curr - 1;
			int walkRight = curr + 1;
			int jump = curr * 2;

			if (walkLeft >= 0 && check[walkLeft] == 0) {
				q.add(walkLeft);
				check[walkLeft] = check[curr] + 1;
			}
			if (walkRight < check.length && check[walkRight] == 0) {
				q.add(walkRight);
				check[walkRight] = check[curr] + 1;
			}
			if (jump < check.length && check[jump] == 0) {
				q.add(jump);
				check[jump] = check[curr];
			}
		}
	}
}