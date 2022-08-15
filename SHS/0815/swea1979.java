package pracprac.bj.study.d0815;

import java.util.Scanner;

public class swea1979 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			
			int N = sc.nextInt();
			
			int K = sc.nextInt();
			
			int[][] arr = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			//빈칸 세기, 답안 도출
			int cnt, ans = 0; 
			
			
			//열검증
			for(int i=0; i<N; i++) {
				cnt = 0;
				for(int j=0; j<N; j++) {
					//빈칸 수 세기
					if(arr[i][j]==1) {
						cnt++;
					}
					//채워진 칸 or 끝지점에 도달하면 검증
					if(arr[i][j] == 0 || j==N-1) {
						//K길이와 같으면 단어+1
						if(cnt == K) {
							ans++;
						}
						//cnt 초기화
						if(arr[i][j]==0) {
							cnt = 0;
						}
					}
				}
			}
			
			
			
			//행검증
			for(int i=0; i<N; i++) {
				cnt = 0;
				for(int j=0; j<N; j++) {
					if(arr[j][i]==1) {
						cnt++;
					}
					
					if(arr[j][i] == 0 || j==N-1) {
						if(cnt == K) {
							ans++;
						}
						if(arr[j][i]==0) {
							cnt = 0;
						}
					}
				}
			}
			
			
			
			System.out.println("#"+t+" "+ans);
			
			
		}
		
		
	}

}
