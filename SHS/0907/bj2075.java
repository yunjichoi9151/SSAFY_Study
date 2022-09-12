package pracprac.bj.study.d0907;

import java.util.PriorityQueue;
import java.util.Scanner;

public class bj2075 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//힙 사용하기 위해 우선순위큐 선언 (오름차순)
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		
		int N = sc.nextInt();
		
		//우선 첫째줄 입력을 받는다
		for(int i=0; i<N; i++) {
				
			heap.add(sc.nextInt());
		}
		
		//나머지 줄 입력을 받으면서 n크기의 힙에서 가장 큰 수를 교체한다
		for(int i=0; i<N-1; i++) {
			for(int j=0; j<N; j++) {
				int n = sc.nextInt();
				if(n > heap.peek()) {
					heap.poll();
					heap.add(n);
				}
			}
		}

		//마지막까지 교체하고 가장 큰 수를 뽑아내면 결국 그게 N번째 큰 수
		System.out.println(heap.poll());
		
	}

}
