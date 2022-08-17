package pracprac.bj.study.d0817;

import java.util.Scanner;

public class bj2567 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		

		//둘레 = 칠해진 영역의 테두리 부분 좌표들의 갯수로 이해하면 됨
		//모서리 영역까지 포함시키기 위해 +2씩 해서 102*102영역으로 계산
		
		int[][] arr = new int[102][102];
		
		//테두리 상하좌우 사방탐색
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		
		for(int i=0; i<n; i++) {
			
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			//일단 색칠
			for(int j=x; j<x+10; j++) {
				for(int k=y; k<y+10; k++) {
					arr[j][k]=1;
				}
			}	
		}
		
		//테두리 좌표 세기
		int c=0;
		for(int i=0; i<102; i++) {
			for(int j=0; j<102; j++) {
				if(arr[i][j]==1) {
					//사방탐색해서 테두리 좌표 수 세기
					for(int k=0; k<4; k++) {
						int tx = i+dr[k];
						int ty = j+dc[k];
						
						//끝좌표를 포함해서, 색칠되지 않은 테두리는 전부 0이므로 다 더하면 끝
						if(arr[tx][ty]==0) {
							c++;
						}
					}
				}
			}
		}
		
		System.out.println(c);
		
		
			
	}

}
