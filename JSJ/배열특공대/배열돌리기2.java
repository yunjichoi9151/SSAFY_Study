package 배열특공대;

import java.util.*;

public class 배열돌리기2 {

	static int N;
	static int M;
	static int R;

	static int[][] arr;

	static int startR;
	static int endR;

	static int startC;
	static int endC;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		R = sc.nextInt();
		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		startR = 0;
		endR = N - 1;

		startC = 0;
		endC = M - 1;

		while (true) {
			int size = (endR - startR + 1) * 2 + (endC - startC + 1) * 2 - 4;
			rotation(R % size);	// 시간줄이기

			startR++;
			endR--;
			startC++;
			endC--;

			if (startR > endR || startC > endC)
				break;
		}

		printArr();
	}

	public static void rotation(int cnt) {

		for (int k = 0; k < cnt; k++) {
			int temp = arr[startR][startC];

			for (int j = startC; j < endC; j++) {
				arr[startR][j] = arr[startR][j + 1];
			}

			for (int i = startR; i < endR; i++) {
				arr[i][endC] = arr[i + 1][endC];
			}

			for (int j = endC; j > startC; j--) {
				arr[endR][j] = arr[endR][j - 1];
			}

			for (int i = endR; i > startR; i--) {
				arr[i][startC] = arr[i - 1][startC];
			}
			arr[startR + 1][startC] = temp;
		}
	}

	// 출력
	static void printArr() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
