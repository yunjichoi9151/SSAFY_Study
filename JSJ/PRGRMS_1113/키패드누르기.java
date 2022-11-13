package PRGRMS_1113;

public class 키패드누르기 {
	public String solution(int[] numbers, String hand) {
		String answer = "";

		// 손 위치 초기값
		int left = 10; // *
		int right = 12; // #

		for (int i : numbers) {

			// 0 -> 11로 대체
			if (i == 0)
				i = 11;

			if (i == 1 || i == 4 || i == 7) { // 왼손 사용
				answer += "L";
				left = i;

			} else if (i == 3 || i == 6 || i == 9) { // 오른손 사용
				answer += "R";
				right = i;

			} else { // 2,5,8,0 의 경우
				// 거리 계산
				int absL = Math.abs(left - i) / 3 + Math.abs(left - i) % 3;
				int absR = Math.abs(right - i) / 3 + Math.abs(right - i) % 3;

				// 거리 비교해서 왼손 오른손 판별
				if (absL < absR) {
					answer += "L";
					left = i;
				} else if (absL > absR) {
					answer += "R";
					right = i;
				} else {
					if (hand.equals("left")) {
						answer += "L";
						left = i;
					} else {
						answer += "R";
						right = i;
					}
				}
			}
		}

		return answer;
	}
}