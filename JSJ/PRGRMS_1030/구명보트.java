package PRGRMS_1030;

import java.util.Arrays;

public class 구명보트 {
	public int solution(int[] people, int limit) {
		int answer = 0;

		Arrays.sort(people); // 정렬 -> 제일 작은값 + 제일 큰값 계산

		int start = 0;
		int end = people.length - 1;

		while (start <= end) {
			if (people[start] + people[end] <= limit) {
				start++;
				end--;
			} else {
				end--;
			}
			answer++;
		}

		return answer;
	}
}