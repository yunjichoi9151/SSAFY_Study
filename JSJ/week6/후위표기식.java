package week6;

import java.util.Scanner;
import java.util.Stack;

public class 후위표기식 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.next();

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < str.length(); i++) {

			char c = str.charAt(i); // 현재 연산

			if ('A' <= c && c <= 'Z') { // 알파벳일때
				System.out.print(c);

			} else if (c == '(') { // 왼쪽 괄호
				stack.push(c);

			} else if (c == ')') { // 오른쪽 괄호
				// 왼쪽괄호가 나올때까지 pop
				while (!stack.isEmpty()) {
					char tmp = stack.pop();
					if (tmp == '(') // 왼쪽 괄호가 나오면 break
						break;
					System.out.print(tmp);
				}

			} else { // +, -, *, /
				// 현재 연산의 우선순위가 이전 연산의 우선순위보다 작은 동안
				while (!stack.isEmpty() && rank(c) <= rank(stack.peek())) {
					System.out.print(stack.pop()); // 이전 연산 뽑아서 출력
				}
				// 현재 연산 넣기
				stack.push(c);
			}

		}

		// 연산 모두 출력
		while (!stack.isEmpty())
			System.out.print(stack.pop());
	}

	// 우선순위 판별
	public static int rank(char c) {

		if (c == '(') {
			return 0;
		} else if (c == '+' || c == '-') {
			return 1;
		}
		return 2;
	}
}
