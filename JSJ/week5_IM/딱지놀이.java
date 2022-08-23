package week5_IM;

import java.util.Scanner;

public class 딱지놀이 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 라운드 수

		for (int n = 0; n < N; n++) {
			int[][] AB = new int[4][2]; // A, B의 딱지 종류별 개수 배열

			int aNum = sc.nextInt(); // A가 낸 딱지에 나온 그림의 총 개수
			for (int i = 0; i < aNum; i++) { // A가 낸 딱지의 그림
				AB[sc.nextInt() - 1][0]++;
			}

			int bNum = sc.nextInt(); // B가 낸 딱지에 나온 그림의 총 개수
			for (int i = 0; i < bNum; i++) { // B가 낸 딱지의 그림
				AB[sc.nextInt() - 1][1]++;
			}

			char winner = 0; // 이긴사람
			// 딱지 비교
			for (int i = 3; i >= 0; i--) {
				if (AB[i][0] > AB[i][1]) {
					winner = 'A';
					break;
				} else if (AB[i][1] > AB[i][0]) {
					winner = 'B';
					break;
				} else {
					winner = 'D';
				}
			}
			System.out.println(winner);
		}
	}
}