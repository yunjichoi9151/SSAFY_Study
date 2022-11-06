package PRGRMS_1030;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class 메뉴리뉴얼 {
	static int N, R, max;
	static char[] arr, tmp; // 단품 메뉴들
	static Map<String, Integer> map;

	public ArrayList<String> solution(String[] orders, int[] course) {
		ArrayList<String> answer = new ArrayList<>();

		// orders : 주문들
		// course : 코스 개수

		// 각 코스 개수만큼 조합 실행
		for (int i = 0; i < course.length; i++) {

			// 각 코스별 조합에 따른 수 count
			map = new HashMap<>();
			
			R = course[i]; // 구해야 할 코스 구성
			max = 0;	// 초기화

			// 각 주문별 코스 개수에 따른 조합 뽑아내기
			for (String order : orders) {
				arr = order.toCharArray();
				Arrays.sort(arr); // 오름차순 정렬

				N = order.length(); // 현재 주문된 단품메뉴 개수
				tmp = new char[R]; // 해당 코스 담을 배열

				Combination(0, 0); // 개수별 조합 실행
			}

			// 최대값에 맞는 조합 answer에 넣기
			for (Entry<String, Integer> entrySet : map.entrySet()) {
				String key = entrySet.getKey(); // 코스 조합
				int val = entrySet.getValue(); // 개수

				// value 값이 최대값일 때 추가
				if (val == max)
					answer.add(key);
			}

			// 정렬
			Collections.sort(answer);
		}

		return answer;
	}

	static void Combination(int cnt, int start) {
		if (cnt == R) {

			// 문자열로 바꾸기
			String key = "";
			for (int i = 0; i < tmp.length; i++)
				key += tmp[i];

			if (map.containsKey(key)) { // 해당 조합이 포함되어 있다면
				map.put(key, map.get(key) + 1);
				max = Math.max(max, map.get(key)); // 최대값 갱신
			} else // 포함 x
				map.put(key, 1);

			return;
		}

		for (int i = start; i < N; i++) {
			tmp[cnt] = arr[i];
			Combination(cnt + 1, i + 1);
		}
	}
}
