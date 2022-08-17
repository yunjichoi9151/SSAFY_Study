package week4_IM;

import java.util.Scanner;

public class 경비원 {
	// 일자로 펴는게 관건
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		// 가로 세로 입력
		int w = sc.nextInt();
		int h = sc.nextInt();

		// 가게 수
		int k = sc.nextInt();
		int[] point = new int[k];

		int police = 0;
		for (int i = 0; i < k + 1; i++) {
			// 방향, 거리 입력받기
			int dir = sc.nextInt();
			int pos = sc.nextInt();

			// 거리
			int tmp = 0;

			// 북 남 서 동
			switch (dir) {
			case 1: // 북: 좌표거리
				tmp = pos;
				break;
			case 2: // 남: 가로 + 세로 + (가로-좌표)
				tmp = w + h + (w - pos);
				break;
			case 3: // 서 : 가로 + 세로 + 가로 + (세로 - 좌표)
				tmp = w + h + w + (h - pos);
				break;
			case 4: // 동 : 가로 + 좌표
				tmp = w + pos;
				break;
			}

			if (i < k) { // 가게
				point[i] = tmp;
			} else { // 경비원
				police = tmp;
			}
		}

		int sum = 0;
		for (int i = 0; i < k; i++) {
			int a = Math.abs(police - point[i]);
			int b = 2 * (w + h) - a;

			sum += Math.min(a, b);
		}

		System.out.println(sum);
	}
}