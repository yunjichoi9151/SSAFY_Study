package pracprac.bj.study.d0821;

import java.util.Scanner;

public class bj2669 {
	
	public static void main(String[] args) {
		
		//색종이랑 비슷한 문제
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[100][100];
		
		for(int i=0; i<4; i++) {			
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			
			//해당하는 부분 전부 1로 바꾸기
			for(int j=x1; j<x2; j++) {
				for(int k=y1; k<y2; k++) {
					arr[j][k] = 1;
				}
			}
		}
		
		int cnt = 0;
		
		//1인 부분 갯수 세주기
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(arr[i][j]==1) {
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
		
		
	}

}
