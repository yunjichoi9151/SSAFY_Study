package pracprac.bj.study.d0921;
//분할정복
//사각형을 4등분 해서 자르면서 재귀적으로 순서대로 방문
//반복해서 자르다가 프레임 크기가 1*1이 되면 답 위치
//이 문제의 경우 범위 아닌 곳까지 완전탐색시 시간초과
//Z자 순회이므로 1-2-3-4분면 순서로 방문
//https://coding-start.tistory.com/13

import java.util.Scanner;

public class bj1074 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		
		N=(int) Math.pow(2, N);
		
		int x = 0;
		int y = 0;
		int ans = 0;
		
		while(N>1) {
			//분할
			N /=2;
			
			//1사분면 통과
			if(r<x+N && c<y+N) {
				
			}
			//2사분면
			else if(r<x+N && c>=y+N) {
				//횟수 추가(1사분면 칸수만큼)
				ans+= N*N*1;
				//위치 이동
				y+=N;
			}
			//3사분면 
			else if(r>=x+N && c<y+N) {
				//횟수추가(1,2사분면 칸수만큼)
				ans += N*N*2;
				x+=N;
			}
			//4사분면
			else {
				//횟수추가(1,2,3사분면 칸수만큼)
				ans+=N*N*3;
				x+=N;
				y+=N;
			}			
			
		}
		
		System.out.println(ans);
	}

}

