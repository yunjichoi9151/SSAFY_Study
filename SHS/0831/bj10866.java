package pracprac.bj.study.d0831;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class bj10866 {
	
	public static void main(String[] args) {
		
		//시간초과 아ㅡㅡ
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		//deque 메서드 사용
		Deque<Integer> deq = new ArrayDeque<Integer>();
		
		for(int i=0; i<N; i++) {
			
			String s = sc.next();
			
			if(s.equals("push_front")) {
				
				deq.addFirst(sc.nextInt());
				
			}else if(s.equals("push_back")) {
				
				deq.addLast(sc.nextInt());

			}else if(s.equals("pop_front")) {
				
				if(deq.size() < 1) {
					
					System.out.println(-1);
					
				}else {
					
					System.out.println(deq.pollFirst());
				}
			}else if(s.equals("pop_back")) {
				
				if(deq.size() < 1) {
					
					System.out.println(-1);

				}else {
					
					System.out.println(deq.pollLast());
					
				}
			}else if(s.equals("size")) {
				
				System.out.println(deq.size());
				
			}else if(s.equals("empty")) {
				
				if(deq.isEmpty()) {
					
					System.out.println(1);
					
				}else {
					
					System.out.println(0);
					
				}
				
			}else if(s.equals("front")) {
				
				if(deq.size()<1) {
										
					System.out.println(-1);

				}else {
					
					System.out.println(deq.peekFirst());
				}
				
			}else if(s.equals("back")) {
				
				if(deq.size()<1) {
										
					System.out.println(-1);

				}else {
					
					System.out.println(deq.peekLast());
				}
			
			}
			
		}
		
		
		
	}

}
