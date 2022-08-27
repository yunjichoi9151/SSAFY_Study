package 배열특공대;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 배열돌리기1 {

	static int N; // 행
	static int M; // 열
	static int R; // 회전시킬 횟수

	static int[][] arr;
	static int[] tmp;

	static int startR;
	static int endR;
	static int startC;
	static int endC;

	static int size;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		// 배열 입력
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < R; i++) {
			rotation();
		}

		printArr();
	}

	// 배열 회전할 list 뽑기 (테두리별로 -> r,c가 같을때 각 층의 시작점)
	static void rotationListUpdate() {
		// 상 우 하 좌 순으로 ArrayList에 넣기

		for (int c = startC + 1; c <= endC; c++) {
			tmp[size++] = arr[startR][c];
		}

		for (int r = startR + 1; r <= endR; r++) {
			tmp[size++] = arr[r][endC];
		}

		for (int c = endC - 1; c >= startC; c--) {
			tmp[size++] = arr[endR][c];
		}

		for (int r = endR - 1; r >= startR; r--) {
			tmp[size++] = arr[r][startC];
		}

	}

	// 배열 회전
	static void rotation() {

		// 행
		startR = 0;
		endR = N - 1;

		// 열
		startC = 0;
		endC = M - 1;

		while (startR <= endR && startC <= endC) {

			tmp = new int[2 * (N + M)];
			size = 0;

			rotationListUpdate();

			// 상 우 좌 하 한칸씩 앞으로
			int dir = 1;
			int idx = 0;
			while (idx < size) {

				switch (dir) {
				case 1:
					for (int c = startC; c < endC; c++) {
						arr[startR][c] = tmp[idx++];
					}
					dir = 2;
					break;
				case 2:
					for (int r = startR; r < endR; r++) {
						arr[r][endC] = tmp[idx++];
					}
					dir = 3;
					break;
				case 3:
					for (int c = endC; c > startC; c--) {
						arr[endR][c] = tmp[idx++];
					}
					dir = 4;
					break;
				case 4:
					for (int r = endR; r > startR; r--) {
						arr[r][startC] = tmp[idx++];
					}
					dir = 1;
					break;
				}
			}

			startR++;
			endR--;
			startC++;
			endC--;
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
