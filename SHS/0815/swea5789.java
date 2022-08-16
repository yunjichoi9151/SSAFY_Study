package pracprac.bj.study.d0815;

import java.util.Scanner;

public class swea5789 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//인덱스 0~N -> 1~N+1로 생각해서 처리
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			
			int N = sc.nextInt();
			
			int Q = sc.nextInt();
			
			//1번부터 N번까지이므로 N+1길이의 배열로 처리
			int[] arr = new int [N+1];
			
			//i는 1에서 Q까지 범위
			for(int i=1; i<=Q; i++) {
				int L = sc.nextInt();
				int R = sc.nextInt();
				
				//L~R범위 인덱스 숫자값 i로 변경
				for(int j=L; j<=R; j++) {
					arr[j] = i;
				}
				
			}
			
			System.out.print("#"+t);
			//배열 출력 끊어서 (1~N)
			for(int i=1; i<=N; i++) {
				System.out.print(" "+arr[i]);
			}
			
			System.out.println();
			
		}
			
	}

}
