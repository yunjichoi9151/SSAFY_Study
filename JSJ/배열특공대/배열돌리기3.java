package 배열특공대;

import java.util.Scanner;

public class 배열돌리기3 {

	static int N;
	static int M;
	static int R; // 연산 횟수

	static int[][] arr;
	static int[][] tmp;
	static int[][] last;

	static int dir; // 연산 종류

	// 5,6 번 연산 보조 배열
	static int[][] div1;
	static int[][] div2;
	static int[][] div3;
	static int[][] div4;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 입력
		// 2<= N, M <=100 && 짝수
		N = sc.nextInt();
		M = sc.nextInt();
		R = sc.nextInt(); // 연산 횟수

		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		// 동작
		for (int i = 0; i < R; i++) {
			dir = sc.nextInt(); // 연산 종류

			if (dir == 1 || dir == 2) {
				reverse_1_2(dir);
			} else if (dir == 3 || dir == 4) {
				rotation_3_4(dir);
			} else {
				rotation_5_6(dir);
			}
		}

		// 출력
		print();
	}

	// 1, 2
	static void reverse_1_2(int dir) {
		tmp = new int[N][M];
		last = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

				if (dir == 1) {
					tmp[N - 1 - i][j] = arr[i][j];
				} else {
					tmp[i][M - 1 - j] = arr[i][j];
				}
			}
		}
		updateArr();
	}

	// 3,4
	static void rotation_3_4(int dir) {

		if (dir == 3) // 3
			rotation90();
		else // 4
			rotationReverse90();

		// N, M 갱신
		int n = N;
		int m = M;

		N = m;
		M = n;

		updateArr();
	}

	// 90도
	static void rotation90() {
		tmp = new int[M][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				tmp[j][N - 1 - i] = arr[i][j];
	}

	// -90도
	static void rotationReverse90() {
		tmp = new int[M][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				tmp[M - 1 - j][i] = arr[i][j];
	}

	// 5, 6
	static void rotation_5_6(int dir) {

		// 배열을 4등분 해야함
		divSec();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

				// 5. 1/4 -> 2/4 -> 3/4 -> 4/4 -> 1/4
				if (dir == 5) {

					// 1
					if (i < N / 2 && j < M / 2) {
						arr[i][j] = div4[i][j];
					}

					// 2
					else if (i < N / 2 && M / 2 <= j) {
						arr[i][j] = div1[i][j - M / 2];
					}

					// 4
					else if (N / 2 <= i && j < M / 2) {
						arr[i][j] = div3[i - N / 2][j];
					}

					// 3
					else if (N / 2 <= i && M / 2 <= j) {
						arr[i][j] = div2[i - N / 2][j - M / 2];
					}
				}

				// 6. 1/4 -> 4/4 -> 3/4 -> 2/4 -> 1/4
				else if (dir == 6) {

					// 1
					if (i < N / 2 && j < M / 2) {
						arr[i][j] = div2[i][j];
					}

					// 2
					else if (i < N / 2 && M / 2 <= j) {
						arr[i][j] = div3[i][j - M / 2];
					}

					// 4
					else if (N / 2 <= i && j < M / 2) {
						arr[i][j] = div1[i - N / 2][j];
					}

					// 3
					else if (N / 2 <= i && M / 2 <= j) {
						arr[i][j] = div4[i - N / 2][j - M / 2];
					}
				}
			}
		}
	}

	// arr 배열 4등분
	static void divSec() {

		div1 = new int[N / 2][M / 2];
		div2 = new int[N / 2][M / 2];
		div3 = new int[N / 2][M / 2];
		div4 = new int[N / 2][M / 2];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

				// 1
				if (i < N / 2 && j < M / 2) {
					div1[i][j] = arr[i][j];
				}

				// 2
				else if (i < N / 2 && M / 2 <= j) {
					div2[i][j - M / 2] = arr[i][j];
				}

				// 4
				else if (N / 2 <= i && j < M / 2) {
					div4[i - N / 2][j] = arr[i][j];
				}

				// 3
				else if (N / 2 <= i && M / 2 <= j) {
					div3[i - N / 2][j - M / 2] = arr[i][j];
				}
			}
		}
	}

	// 다음 연산을 위해 arr 배열 업데이트
	static void updateArr() {
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = tmp[i][j];
			}
		}
	}

	// 출력
	static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
