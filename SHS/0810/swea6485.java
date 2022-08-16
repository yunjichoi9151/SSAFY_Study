package pracprac.bj.study.d0810;

import java.util.Scanner;

public class swea6485 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			
			int N = sc.nextInt();
			int[] A = new int[N+1];
			int[] B = new int[N+1];
			
			for(int i=1; i<=N; i++) {
				A[i] = sc.nextInt();
				B[i] = sc.nextInt();
			}
			
			int P = sc.nextInt();
			
			System.out.print("#"+tc + " ");
			
			int cnt=0;
			
			//정류장에 해당 노선이 지나가는지 여부 한번에 처리
			for(int i=1; i<=P; i++) {
				int C = sc.nextInt();
				cnt=0;
				for(int j=1; j<=N; j++) {
					if(A[j]<=C && C<=B[j]) {
						cnt++;
					}
				}
				System.out.print(cnt+" ");
			}
				
			System.out.println();
		}

	}


}
