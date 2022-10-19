package PRGRMS_1023;

import java.util.Stack;

public class 크레인인형뽑기 {
	public static int solution(int[][] board, int[] moves) {
		int answer = 0; // 터뜨려 사라진 인형 개수

		// 뽑은 인형 담을 바구니
		Stack<Integer> stack = new Stack<Integer>();
		stack.add(0);

		for (int i : moves) {
			for (int j = 0; j < board.length; j++) {

				// board의 숫자가 0이 아닐 때(인형이 채워져 있을 때)
				if (board[j][i - 1] != 0) {

					// board에서 뽑은 숫자가 stack에서 peek()한 숫자와 같지 않을 때
					if (!stack.peek().equals(board[j][i - 1])) {
						stack.add(board[j][i - 1]);

						// board에서 뽑은 숫자가 stack에서 peek()한 숫자와 같을 때
					} else {
						stack.pop();
						answer += 2;
					}

					board[j][i - 1] = 0;
					break;
				}
			}
		}

		return answer;
	}

}