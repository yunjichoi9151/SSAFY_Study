package pracprac.bj.study.d0817;

import java.util.Scanner;

//https://hunucho.tistory.com/entry/Baekjoon-2564-%EA%B2%BD%EB%B9%84%EC%9B%90-JAVA
public class bj2564_0809 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int r = sc.nextInt();
		int c = sc.nextInt();
		int n = sc.nextInt();
		
		int sum = 0;
		//동근이의 위치
		int dk=0;	
		
		//사각형을 하나의 직선으로 생각한다면 
		//끝점 통과시 전체거리에서 끝점을 통과하지 않는 거리를 빼면 됨
		
		int[] map = new int [n];
		
		for (int i = 0; i < n+1; i++) {
			//방향
			int dir = sc.nextInt();
			//해당 경계로부터의 거리
			int loc = sc.nextInt();
			//0,0 좌표로부터의 상점 거리
			int tmp =0;
			
			switch(dir) {
			//북
			case 1 :
				tmp = loc;
				break;
			//남
			case 2 :
				tmp = r+ c+ r - loc;
				break;
			//서	
			case 3 :
				tmp = r+c+r+c-loc;
				break;
			//동	
			case 4 :
				tmp = r+loc;
				break;
				
			}
			
			//상점 거리 저장
			if(i<n) {
				map[i] = tmp;
			}
			else {
				dk = tmp;
			}
			
			
			
		}
		
		for(int i=0; i<n; i++) {
			//0,0좌표로부터 동근이와 상점 사이의 거리 절대값 계산
			int lp = Math.abs(dk-map[i]);
			//통과하는 경우 고려해서 반대의 거리 계산
			int rp = 2*r+2*c-lp;
			//최소값 도출해서 합
			sum+= Math.min(lp,rp);
		}
		
		System.out.println(sum);
		
	}

}
