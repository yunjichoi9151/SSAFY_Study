package day1012;

import java.util.Scanner;
import java.util.Stack;

public class SWEA_5432 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			String str = sc.next();
			char[] c = new char[str.length()];
			
			Stack<Character> stack = new Stack<>();
			
			int sum = 0;
			for(int i=0;i<c.length;i++) {
				if(c[i]=='(') {
					stack.push(c[i]);					
				}
				else if(c[i]==')'&&c[i]=='(') {
					stack.pop();
					sum += stack.size();
				}
				else if(c[i]==')'&&c[i-1]==')') {
					stack.pop();
					sum += 1;
				}
			}
			
			System.out.println("#"+tc+" "+sum);
		}
	}
}
