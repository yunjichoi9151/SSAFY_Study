package week3_IM;
import java.util.Scanner;

public class 어디에단어가들어갈수있을까 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		int cnt = 0;

		for (int t = 0; t < T; t++) {

			int N = sc.nextInt();
			int K = sc.nextInt(); // 단어길이

			int[][] puzzle = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					puzzle[i][j] = sc.nextInt();
				}
			}

			int sum = 0;

			// 가로
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {

					if (puzzle[i][j] == 1) {
						sum++;
					} else {
						if (sum == K) {
							cnt++;
						}
						sum = 0;
					}
				}

				if (sum == K) {
					cnt++;
				}
				sum = 0;
			}

			// 세로
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {

					if (puzzle[j][i] == 1) {
						sum++;
					} else {
						if (sum == K) {
							cnt++;
						}
						sum = 0;
					}
				}
				if (sum == K) {
					cnt++;
				}
				sum = 0;
			}

			System.out.println("#" + (t + 1) + " " + cnt);
			cnt = 0;
		}
	}
}