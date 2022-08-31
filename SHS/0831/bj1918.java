package pracprac.bj.study.d0831;

import java.util.Scanner;
import java.util.Stack;

public class bj1918 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		
		Stack<Character> stk = new Stack<>();
		
		for(int i=0; i<s.length(); i++){
			
			char c = s.charAt(i);
			
			//연산자 아니면 바로 출력
			if(c>='A' && c<='Z') {
				System.out.print(c);
			}
			else if(c==')') {
				// (가 나올 때까지 쭉 뽑기
				while(!stk.isEmpty()) {
					char tmp = stk.pop();
					
					if(tmp=='(') {
						break;
					}
					
					System.out.print(tmp);
				}
			}else if(c=='(') {
				//(는 밖에서 짱이니까 바로 집어넣기
				stk.push(c);
			}else {
			//연산자 우선순위 비교해서 더 클때 집어넣고
			//우선순위 같거나 작을때는 스택에 있는 연산자를 출력한 뒤에 넣기
				while(!stk.isEmpty() && order(stk.peek())>=order(c)) {
					System.out.print(stk.pop());
				}
				stk.push(c);
			}
						
		}
		//나머지는 그냥 쭉 출력
		while(!stk.isEmpty()) {
			System.out.print(stk.pop());
		}
		
		
	}
	
	
	//우선순위 설정
	public static int order(char c) {
		
		if(c=='(') {
			return 0;
		}else if(c=='+' || c=='-') {
			return 1;
		}else{
			return 2;
		}
		
	}

}
