package pracprac.bj.study.d0807;

import java.util.Scanner;

public class bj11729 {
	
	//안하면 또 시간초과뜸
	public static StringBuilder sb = new StringBuilder();	
	static int cnt = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		Hanoi(N,1,3,2);
		
		System.out.println(cnt);
		System.out.println(sb);
		
		
	}
	
	//from : 출발하는곳 / to : 목적지 / other : 둘다 아닌곳

	static void Hanoi(int N, int from, int to, int other){
		
		if(N==0) {
			return;
		}
		else {
			cnt++;
			//n개의 원판 중 n-1개를 목적지가 아닌 곳으로 이동
			Hanoi(N-1, from, other, to);
			//마지막 남은 원판을 목적지로
			sb.append(from+" "+to+"\n");
			//목적지가 아닌곳에 있던 원판들을 목적지로
			Hanoi(N-1, other, to, from);
			
		}
		
	}
}
	
