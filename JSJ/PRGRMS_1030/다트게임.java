package PRGRMS_1030;

import java.util.Stack;

public class 다트게임 {
	public int solution(String dartResult) {
		int answer = 0;
		char arr[] = dartResult.toCharArray();

		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 'S') {
				int num = stack.pop();
				stack.push(num);
			} else if (arr[i] == 'D') {
				int num = stack.pop();
				stack.push(num * num);
			} else if (arr[i] == 'T') {
				int num = stack.pop();
				stack.push(num * num * num);
			} else if (arr[i] == '*') {
				int num = stack.pop();
				int num2 = stack.pop();
				stack.push(num2 * 2);
				stack.push(num * 2);
			} else if (arr[i] == '#') {
				int num = stack.pop();
				stack.push(num * -1);
			} else {
				int num = arr[i] - '0';
				char num2 = arr[i + 1];
				if (num == 1 && num2 == '0') {
					stack.push(10);
					i += 1;
				} else {
					stack.push(num);
				}
			}
		}

		for (int i = 0; i < 3; i++) {
			answer += stack.pop();
		}
		return answer;
	}
}