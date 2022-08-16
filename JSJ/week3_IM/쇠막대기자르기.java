package week3_IM;

import java.util.Scanner;
import java.util.Stack;

public class 쇠막대기자르기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			String str = sc.next();

			int sum = 0; // 나무토막 합

			Stack<Character> stack = new Stack<Character>();
			for (int i = 0; i < str.length(); i++) {

				if (str.charAt(i) == '(') {
					stack.add(str.charAt(i));
				} else {
					if (str.charAt(i - 1) == '(') {// 레이저
						stack.pop();
						sum += stack.size();
					} else {
						sum++;
						stack.pop();
					}
				}
			}
			System.out.println("#" + t + " " + sum);
		}

	}

}
