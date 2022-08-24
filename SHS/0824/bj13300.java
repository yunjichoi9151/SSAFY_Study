package pracprac.bj.study.d0824;

import java.util.Scanner;

public class bj13300 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int room = 0;
		
		int[][] std = new int[7][2];
		
		//2차원 배열에 저장
		for(int i=0; i<N; i++) {
			int s = sc.nextInt();
			int t = sc.nextInt();
			
			std[t][s]++;
		}
		
		for(int i=1; i<7; i++) {			
			for(int j=0; j<2; j++) {
				//방별 최대인원으로 나눈 만큼 방 갯수 +
				room+= std[i][j]/K;
				//나머지가 0이 아닐 경우 한번 더 갯수 +
				if(std[i][j]%K!=0) {
					room++;
				}
				
				
/*				if(std[i][j]==0) {
					continue;
				} else if(std[i][j]<=K){
					room++;
				} else if(std[i][j]%K==0) {
					room+= std[i][j]/K;
					room++;
				} else if(std[i][j]%K !=0) {
					room+=std[i][j]/K;
					room++;
				}*/
				
			}
			

			
		}
		

		
		System.out.println(room);
		
		
		
	}
	
}