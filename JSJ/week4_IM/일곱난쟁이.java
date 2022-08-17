package week4_IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 일곱난쟁이 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] arr = new int[9]; // 가짜가 포함된 9난장이
		int overSum = 0;

		int fake1 = 0;
		int fake2 = 0;

		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			overSum += arr[i];
		}

		Arrays.sort(arr);

		// 가짜 난장이의 숫자의 합에 대응하는 수 2개 찾기
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] + arr[j] == overSum - 100) {
					fake1 = i;
					fake2 = j;
					break;
				}
			}
		}

		// 원소가 가짜 난장이의 수일 경우 continue, 아닐 경우 배열 출력
		for (int i = 0; i < arr.length; i++) {
			if (i == fake1 || i == fake2) {
				continue;
			}
			System.out.println(arr[i]);
		}
	}
}
