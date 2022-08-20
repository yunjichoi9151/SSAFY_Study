package week4_IM;

import java.util.Scanner;

public class 자리배정 {

	// 달팽이랑 같은 방법으로 품
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 공연장 크기
		int C = sc.nextInt();
		int R = sc.nextInt();

		int K = sc.nextInt(); // 어떤관객의 대기번호

		int[][] arr = new int[R][C]; // 공연장
		boolean check = true;	// 자리배정 가능 여부

		// 시작 인덱스
		int r = R - 1;
		int c = 0;

		int cnt = 0; // 자리 배정 완료된 관객수 count
		int dir = 1; // 배정 방향
		while (cnt < K) {

			// 대기번호가 공연장 자리수보다 클 경우
			if (K > R * C) {
				check = false;
				break;
			}

			// 자리 배정
			arr[r][c] = ++cnt;

			// 상우하좌
			switch (dir) {
			case 1:
				if (r == 0 || arr[r - 1][c] != 0) {
					c++;
					dir = 2;
				} else {
					r--;
				}
				break;
			case 2:
				if (c == C - 1 || arr[r][c + 1] != 0) {
					r++;
					dir = 3;
				} else {
					c++;
				}
				break;
			case 3:
				if (r == R - 1 || arr[r + 1][c] != 0) {
					c--;
					dir = 4;
				} else {
					r++;
				}
				break;
			case 4:
				if (c == 0 || arr[r][c - 1] != 0) {
					r--;
					dir = 1;
				} else {
					c--;
				}
				break;
			}
		}

		// 다음으로 넘어가기 위해 마지막에 추가된 연산 정리
		if (dir == 1)
			r++;
		else if (dir == 2)
			c--;
		else if (dir == 3)
			r--;
		else if (dir == 4)
			c++;

		// 출력은 (x, y) 좌표기준
		if (check) {
			System.out.println((c + 1) + " " + (R - r));
		} else {
			System.out.println(0);
		}

	}
}
