package week4_IM;

import java.util.ArrayList;
import java.util.Scanner;

public class 참외밭 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int K = sc.nextInt(); // 1m^2 넓이에 자라는 참외 개수

		ArrayList<int[]> list = new ArrayList<int[]>();

		// 왼쪽 꼭지점부터 반시계방향으로 돌면서 입력
		// 동서남북 :1 2 3 4 (북->서->남->동->북)
		for (int i = 0; i < 6; i++) {
			list.add(new int[] { sc.nextInt(), sc.nextInt() });
		}

		// 가장 긴 가로 세로 구하기
		int w = 0;
		int h = 0;

		for (int i = 0; i < list.size(); i++) {

			if (list.get(i)[0] == 3 || list.get(i)[0] == 4) { // 가로 (서,동)
				w = Math.max(w, list.get(i)[1]);
			} else if (list.get(i)[0] == 1 || list.get(i)[0] == 2) { // 세로(남,북)
				h = Math.max(h, list.get(i)[1]);
			}
		}

		int sum = w * h; // 전체 넓이
		int minus = 0; // 뺄 넓이

		// 뺄 넓이
		for (int i = 0; i < list.size(); i++) {

			int dir1 = list.get(i % list.size())[0]; // 기준점
			int dir2 = list.get((i + 1) % list.size())[0]; // 빠지는 면적 한 면
			int dir3 = list.get((i + 2) % list.size())[0]; // 빠지는 면적 한 면

			// ┓,┏,┗, ┛ 탐색
			if (dir1 == 3 && dir2 == 1 && dir3 == 3 || dir1 == 1 && dir2 == 4 && dir3 == 1
					|| dir1 == 4 && dir2 == 2 && dir3 == 4 || dir1 == 2 && dir2 == 3 && dir3 == 2) {

				// 빠질 면적 계산
				minus = list.get((i + 1) % list.size())[1] * list.get((i + 2) % list.size())[1];
				break;
			}
		}

		System.out.println((sum - minus) * K);
	}
}
