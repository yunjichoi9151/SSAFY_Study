package BOJ_0921;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// br, bw 안쓰면 시간초과 남
// 인덱스 계산 주의
public class 별찍기_11 {

	static int N;
	static String[][] stars;

	public static <stars> void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		stars = new String[N][N * 2]; // 열이 2배 많아야 함

		// 배열 초기화
		for (int i = 0; i < stars.length; i++) {
			for (int j = 0; j < stars[i].length; j++) {
				stars[i][j] = " ";
			}
		}

		recur(N, N * 2, N);

		// 출력
		for (int i = 0; i < stars.length; i++) {
			for (int j = 0; j < stars[i].length; j++) {
				bw.write(stars[i][j]);
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}

	// 기준점으로 가장 오른쪽 끝 맨 아래 인덱스 활용
	public static void recur(int r, int c, int N) {

		// 기저 조건
		if (N == 3) {
			// 첫번째 줄
			stars[r - 3][c - 4] = "*";

			// 두번째 줄
			stars[r - 2][c - 3] = "*";
			stars[r - 2][c - 5] = "*";

			// 세번째 줄
			stars[r - 1][c - 2] = "*";
			stars[r - 1][c - 3] = "*";
			stars[r - 1][c - 4] = "*";
			stars[r - 1][c - 5] = "*";
			stars[r - 1][c - 6] = "*";
			return;
		}

		// 간격 반씩 줄여줌
		N /= 2;

		// 윗 삼각형 1개
		recur(r - N, c - N, N);

		// 아랫 삼각형 2개
		recur(r, c - N * 2, N); // 왼
		recur(r, c, N); // 오
	}
}