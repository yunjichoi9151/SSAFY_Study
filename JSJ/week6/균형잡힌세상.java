package week6;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class 균형잡힌세상 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		String str;
		while (true) {
			str = sc.nextLine(); // 한줄씩 받기

			if (str.equals(".")) { // 종료 조건문
				break;
			}

			System.out.println(solve(str));
		}
	}

	public static String solve(String str) {

		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < str.length(); i++) {

			char c = str.charAt(i); // i 번째 문자

			// 여는 괄호일 경우 스택에 push
			if (c == '(' || c == '[') {
				stack.push(c);
			}

			else if (c == ')') {

				// 스택이 비어있거나 pop할 원소가 소괄호랑 매칭이 안되는 경우
				if (stack.empty() || stack.peek() != '(') {
					return "no";
				} else {
					stack.pop();
				}
			}

			else if (c == ']') {

				// 스택이 비어있거나 pop할 원소가 대괄호랑 매칭이 안되는 경우
				if (stack.empty() || stack.peek() != '[') {
					return "no";
				} else {
					stack.pop();
				}
			}
		}

		if (stack.empty()) {
			return "yes";
		} else {
			return "no";
		}
	}
}