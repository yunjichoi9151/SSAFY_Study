package pracprac.bj.study.d0817;

import java.util.Scanner;

public class bj2563 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[][] arr = new int[100][100];
		
		int c=0;
		
		for(int i=0; i<n; i++) {
			
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			//덧붙이는 부분의 좌표를 색칠한다고 생각하면 편함
			
			//변의 길이 똑같이 10이고 xy는 좌표 떨어진 만큼을 의미
			//그러니 해당 좌표 값에 1을 대입해서 1이 된 영역 합계 도출
			
			for(int j=x; j<x+10; j++) {
				for(int k=y; k<y+10; k++) {
					if(arr[j][k]==0) {
						arr[j][k]=1;
						c++;
					}
				}
			}
		}
		
		System.out.println(c);	
		
		

	}

}
