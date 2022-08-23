package week5_IM;

import java.util.Scanner;

public class 창고다각형 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] arr = new int[1001];

		// 인덱스 최대 최소
		int min = 1001;
		int max = -1;

		// 높이가 가장 긴 기둥 구하기 (탐색 기준)
		int maxValIdx = -1;
		int maxVal = -1;

		int sum = 0; // 창고 넓이

		int N = sc.nextInt(); // 기둥 개수
		for (int i = 0; i < N; i++) {
			int loc = sc.nextInt(); // 위치
			int height = sc.nextInt(); // 높이

			// 최대값, 인덱스 구하기
			if (maxVal < height) {
				maxVal = height;
				maxValIdx = loc;
			}

			// 위치 최대 최소 구하기
			if (loc < min)
				min = loc;
			if (loc > max)
				max = loc;

			// 해당 위치에 값 저장
			arr[loc] = height;
		}

		// 입력값 범위만큼만 탐색

		// 1. 최대값 기준 왼쪽탐색
		int localMax = -1;
		for (int i = min; i < maxValIdx; i++) {
			int pre = arr[i];
			if (localMax < pre) { // 이전값보다 작거나 같은 경우
				localMax = pre;
			}
			arr[i] = localMax;
		}

		// 2. 최대값
		arr[maxValIdx] = maxVal;

		// 3. 최대값 기준 오른쪽 탐색
		localMax = -1;
		for (int i = max; i > maxValIdx; i--) {
			int pre = arr[i];
			if (localMax < pre) { // 이전값보다 작거나 같은 경우
				localMax = pre;
			}
			arr[i] = localMax;
		}

		// 면적합 구하기
		for (int i = min; i <= max; i++) {
			sum += arr[i];
		}

		// 창고면적 출력
		System.out.println(sum);
	}
}