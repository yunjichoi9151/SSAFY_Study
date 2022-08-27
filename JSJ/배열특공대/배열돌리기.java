package 배열특공대;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 배열돌리기 {

	static int N;
	static int d;
	static int[][] arr;
	static int[][] rotationArr; // X자, +자 요소 (오른쪽 위 대각선부터 시계방향)

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine()); // tc 개수
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 배열 크기
			d = Integer.parseInt(st.nextToken()); // 각도

			// 배열 입력받기
			arr = new int[N][N];
			rotationArr = new int[4][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			repeatRotation(d);
			printArr();
		}
	}

	// 회전할 요소 뽑아내기
	static void updateRotationArr() {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				// 1. 주 대각선
				if (i == j) {
					rotationArr[0][i] = arr[i][j];
				}

				// 2. 가운데 열
				if (j == (N - 1) / 2) {
					rotationArr[1][i] = arr[i][j];
				}

				// 3. 부 대각선
				if (j == N - 1 - i) {
					rotationArr[2][i] = arr[i][j];
				}

				// 4. 가운데 행
				if (i == (N - 1) / 2) {
					rotationArr[3][j] = arr[i][j];
				}
			}
		}
	}

	// 45
	static void rotation() {
		updateRotationArr(); // 회전배열 업데이트

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				// 1. 주 대각선(0) -> 가운데 열
				if (j == (N - 1) / 2) {
					arr[i][j] = rotationArr[0][i];
				}

				// 2. 가운데 열(1) -> 부 대각선
				if (j == N - 1 - i) {
					arr[i][j] = rotationArr[1][i];
				}

				// 3. 부 대각선(2) -> 가운데 행 (거꾸로)
				if (i == (N - 1) / 2) {
					arr[i][j] = rotationArr[2][N - 1 - j];
				}

				// 4. 가운데 행(3) -> 주 대각선
				if (i == j) {
					arr[i][j] = rotationArr[3][i];
				}
			}
		}
	}

	// -45
	static void reverseRotation() {
		updateRotationArr();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				// 1. 주 대각선(0) -> 가운데 행
				if (i == (N - 1) / 2) {
					arr[i][j] = rotationArr[0][j];
				}

				// 2. 가운데 열(1) -> 주 대각선
				if (i == j) {
					arr[i][j] = rotationArr[1][i];
				}

				// 3. 부 대각선(2) -> 가운데 열
				if (j == (N - 1) / 2) {
					arr[i][j] = rotationArr[2][i];
				}

				// 4. 가운데 행(3) -> 부 대각선 (거꾸로)
				if (j == N - 1 - i) {
					arr[i][j] = rotationArr[3][N - 1 - i];
				}
			}
		}
	}

	// 반복
	static void repeatRotation(int d) {
		int cnt = d / 45;
		while (cnt > 0 && cnt-- > 0)
			rotation();
		while (cnt < 0 && cnt++ < 0)
			reverseRotation();
	}

	// 출력
	static void printArr() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
