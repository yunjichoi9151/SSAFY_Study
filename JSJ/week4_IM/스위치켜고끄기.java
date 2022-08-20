package week4_IM;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 스위치켜고끄기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 스위치 개수
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 1; i <= N; i++) {
			map.put(i, sc.nextInt());
		}

		int student = sc.nextInt(); // 학생수
		int[][] sexAndCnt = new int[student][2];
		for (int i = 0; i < student; i++) {
			sexAndCnt[i][0] = sc.nextInt(); // 성별) 남:1, 여:2
			sexAndCnt[i][1] = sc.nextInt(); // 받은 수
		}

		for (int i = 0; i < student; i++) {

			// 남자
			if (sexAndCnt[i][0] == 1) {
				for (int j = 1; j <= N; j++) {
					if (j % sexAndCnt[i][1] == 0 && map.get(j) == 0) {
						map.put(j, 1);
					} else if (j % sexAndCnt[i][1] == 0 && map.get(j) == 1) {
						map.put(j, 0);
					}
				}

			} else { // 여자
				int min = Math.min(sexAndCnt[i][1] - 1, map.size() - sexAndCnt[i][1]);

				int mid = sexAndCnt[i][1];
				int a = mid - 1;
				int b = mid + 1;

				for (int j = 0; j < min; j++) {
					if (map.get(a) == map.get(b)) {
						a--;
						b++;
					}
				}

				for (int j = a + 1; j < b; j++) {
					if (map.get(j) == 0) {
						map.put(j, 1);
					} else {
						map.put(j, 0);
					}
				}
			}
		}

		for (int i = 1; i <= N; i++) {

			System.out.print(map.get(i) + " ");

			if (i % 20 == 0) {
				System.out.println();
			}
		}
	}
}