package BOJ_1005;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

// 프림
public class 별자리만들기 {

	// 별, 거리(비용)
	static class Star {
		final int starNo;
		final double cost;

		Star(int starNo, double cost) {
			this.starNo = starNo;
			this.cost = cost;
		}
	}

	static int n;
	static double[][] stars;
	static double[][] dist;
	static final double INF = Double.MAX_VALUE;

	static double totalCost = 0;
	static double[] cost;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		// 별 좌표
		stars = new double[n][2];
		for (int i = 0; i < n; i++) {
			stars[i][0] = sc.nextDouble();
			stars[i][1] = sc.nextDouble();
		}

		// 별 간 거리 입력
		dist = new double[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				dist[i][j] = distCal(stars[i], stars[j]);
			}
		}

		cost = new double[n]; // 연결 비용
		visited = new boolean[n]; // 방문 check
		Arrays.fill(cost, INF); // 최대값으로 초기화

		// 소수점 둘째자리까지 출력
		System.out.printf("%.2f", Prim());
	}

	static double Prim() {
		PriorityQueue<Star> q = new PriorityQueue<>(Comparator.comparingDouble(s -> s.cost)); // 비용으로 정렬
		q.add(new Star(0, 0)); // 처음 순서의 별

		while (!q.isEmpty()) {
			Star currStar = q.poll();
			int curr = currStar.starNo;

			if (!visited[curr]) {
				totalCost += currStar.cost;
				visited[curr] = true;

				for (int i = 0; i < n; i++) {
					if (dist[i][curr] < cost[i]) {
						cost[i] = dist[i][curr];
						q.add(new Star(i, cost[i]));
					}
				}
			}
		}
		return totalCost;
	}

	// 거리 계산식
	static double distCal(double[] star1, double[] star2) {
		return Math.sqrt((star1[0] - star2[0]) * (star1[0] - star2[0]) + (star1[1] - star2[1]) * (star1[1] - star2[1]));
	}
}
