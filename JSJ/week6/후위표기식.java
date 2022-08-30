package week6;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class 후위표기식 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {

			int n = sc.nextInt();
			String s = sc.next();
			Stack<Character> stk = new Stack<>();
			String result = "";

			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (c - '0' >= 0 && c - '0' <= 9) {

					result += String.valueOf(c);

				} else if (c == ')') {
					char last = stk.pop();
					while (!stk.isEmpty() && last != '(') {
						result += String.valueOf(last);
						last = stk.pop();
					}

				} else {
					if (stk.isEmpty()) {
						stk.push(c);
					} else {

						if (c == '(') {
							stk.push(c);
						} else if (rank(stk.peek()) > rank(c)) {
							stk.push(c);
						} else {
							result += String.valueOf(stk.pop());
							stk.push(c);
						}

					}
				}
			}
			while (!stk.isEmpty()) {
				result += String.valueOf(stk.pop());
			}

			Stack<Integer> stk2 = new Stack<Integer>();
			for (int i = 0; i < result.length(); i++) {
				char c = result.charAt(i);
				if (c - '0' >= 0 && c - '0' <= 9) {
					stk2.push(c - '0');
				} else {
					int op1 = stk2.pop();
					int op2 = stk2.pop();
					if (c == '*') {
						stk2.push(op1 * op2);
					} else if (c == '+') {
						stk2.push(op1 + op2);
					}
				}
			}

			System.out.println("#" + t + " " + stk2.pop());

		}

	}

	public static int rank(char c) {

		if (c == '*' || c == '/')
			return 1;
		else if (c == '+' || c == '-')
			return 3;
		else if (c == '(')
			return 5;
		else
			return -1;

	}

}
