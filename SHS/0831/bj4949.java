package pracprac.bj.study.d0831;

import java.util.Scanner;
import java.util.Stack;

public class bj4949 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//스택 사용
		Stack<Character> stk = new Stack<>();
		
		//. 입력시로 조건걸면 무한루프 돌더라..
		while(true) {
			//스택 초기화
			stk.clear();
			//입력 라인구분 받기
			String s = sc.nextLine();
			//. 입력시 종료
			 if(s.equals(".")) {
				 break;
			 }
			 
			//균형 맞을때 pop 아닐때 push
			//불필요한 문자는 스킵
			for(int i=0; i< s.length(); i++) {
				if(s.charAt(i) == '(' || s.charAt(i)=='[') {
					stk.push(s.charAt(i));
				}else {
					if(s.charAt(i)==')') {
						if(stk.isEmpty() || stk.peek() !='(') {
							stk.push(s.charAt(i));
						}else {
							stk.pop();
						}
					}else if(s.charAt(i)==']') {
						if(!stk.isEmpty() && stk.peek() == '[') {
							stk.pop();
						}else {
							stk.push(s.charAt(i));
						}
					}
				}
			}
			
			if(stk.isEmpty()) {
				System.out.println("yes");
			}else {
				System.out.println("no");
			}
			
			
		}
		
	}

}
