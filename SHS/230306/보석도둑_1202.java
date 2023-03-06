package 이공이삼삼월.d230303;
//해시로 푼 사람 https://jjong2.tistory.com/35
//comparator + 우선순위큐 쓰는 그리디

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 보석도둑_1202 {
	
	static class Jw {
		int weight, price;
		
		Jw(int weight, int price){
			this.weight = weight;
			this.price = price;
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		ArrayList<Jw> jw = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			int M = sc.nextInt();
			int V = sc.nextInt();
			
			jw.add(new Jw(M,V));
		}
		
		int[] bag = new int[K];
		
		for(int i=0; i<K; i++) {
			bag[i] = sc.nextInt();
		}
		
		//무게순 정렬 (오름차순)
		Collections.sort(jw, (o1, o2)-> o1.weight - o2.weight);
		Arrays.sort(bag);
		
		long sum = 0;
		int idx = 0;
		
		
		//가격순 정렬 (내림차순)
		PriorityQueue<Jw> pq  = new PriorityQueue<>((o1, o2)-> o2.price - o1.price);
		
		for(int i=0; i<K; i++) {
			while(idx<N && jw.get(idx).weight <= bag[i]) {
				Jw curr = jw.get(idx++);
				pq.offer(new Jw(curr.weight, curr.price));
			}
			
			if(!pq.isEmpty()) {
				sum+=pq.poll().price;
			}
		}
		
		System.out.println(sum);
		
		
	}
	
}
