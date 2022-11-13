package PRGRMS_1113;

public class 최고의집합 {
	public int[] solution(int n, int s) {
		int[] answer = {};

		// 최고집합 존재 X
		if (n > s) {
			return new int[] { -1 };
		}

		answer = new int[n];

		int div = s / n;
		int divLeft = s % n;

		// n만큼 나눈 값 넣기
		for (int i = 0; i < n; i++) {
			answer[i] = div;
		}

		// n으로 나누어 떨어지지 않을 때
		// n만큼 나누고 나머지에 대해 공평하게 더해주기
		int idx = answer.length - 1; // 마지막 index부터
		if (s % n != 0) {

			// 남은 값이 있는 동안
			while (divLeft > 0) {
				answer[idx--]++;
				divLeft--;
			}
		}

		return answer;
	}
}