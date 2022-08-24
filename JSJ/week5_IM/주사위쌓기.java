package week5_IM;

import java.util.Scanner;

public class 주사위쌓기 {

	// 뭐가 틀렸을까....
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 주사위 개수
		int[][] arr = new int[N][6]; // 주사위

		// 주사위 입력
		for (int i = 0; i < N; i++) {
			// A B C D E F 순서
			for (int j = 0; j < 6; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		int max = 0; // 최종 최대값

		int[] tmpMax = new int[N]; // 각 주사위의 위,아랫면 제외한 최대값 (4개 중 1개)
		for (int k = 0; k < 6; k++) { // 첫 주사위 인덱스만큼 반복

			int up = k; // 윗면 인덱스
			int down = -1; // 아랫면 인덱스

			int maxN = 0;// 해당 주사위 최대값

			// 주사위 개수만큼 반복
			for (int i = 0; i < N; i++) {

				// 해당 주사위 아랫면 인덱스 찾기
				// A-F, B-D, C-E (idx: 0-5 / 1-3/ 2-4)
				switch (up) {
				case 0:
					down = 5;
					break;
				case 1:
					down = 3;
					break;
				case 2:
					down = 4;
					break;
				case 3:
					down = 1;
					break;
				case 4:
					down = 2;
					break;
				case 5:
					down = 0;
					break;
				}

				// 해당 주사위 위,아래 면 제외 최대값 찾기
				for (int j = 0; j < 6; j++) {
					if (j != up && j != down) {
						maxN = Math.max(maxN, arr[i][j]);
					}
				}

				// 각 주사위 최대값 저장
				tmpMax[i] = maxN;
				maxN = 0;

				// 윗면 인덱스 갱신 (마지막 주사위는 갱신 필요 X)
				for (int j = 0; j < 6; j++) {
					if (i < N - 1 && arr[i + 1][j] == arr[i][down]) {
						up = j;
					}
				}
			}

			int sum = 0;
			for (int i : tmpMax) {
				sum += i;
			}
			max = Math.max(sum, max);
		}

		System.out.println(max);
	}
}
