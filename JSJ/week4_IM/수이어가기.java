package week4_IM;

import java.util.ArrayList;
import java.util.Scanner;

public class 수이어가기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 입력받을 수
		int cnt = 0; // 리스트 최대 크기

		// 최종 배열
		ArrayList<Integer> result = new ArrayList<Integer>();

		// N/2 보다 커야 함
		for (int i = N; i > N / 2; i--) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(N);

			int tmp = N; // 첫번째 수
			int tmp2 = i; // 두번째 수

			// 종료될 때까지 반복
			while (true) {

				// 음수가 나오면 종료
				if (tmp < 0)
					break;

				// 앞앞 수 저장
				int tmp3 = tmp;
				// 두번째 수가 0보다 클 경우 list에 저장
				if (tmp2 >= 0)
					list.add(tmp2);

				// 한칸씩 수 갱신
				tmp = tmp2;
				tmp2 = tmp3 - tmp;
			}

			// cnt가 새로운 list의 size보다 작을 경우 갱신
			if (cnt < list.size()) {
				cnt = list.size();
				result = list;
			}
		}

		// 출력
		System.out.println(cnt);
		for (Integer i : result)
			System.out.print(i + " ");

	}
}
