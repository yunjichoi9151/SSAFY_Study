package pracprac.bj.study.d0817;

import java.util.Scanner;

public class bj2491 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		
		//오름차순 수열 세기
		int cntincr = 1;
		//내림차순 수열 세기
		int cntdecr = 1;
		//이유는 모르지만 1로 둬야 통과함.. -1, 0으로 두면 안됨...
		int max = 1;
		
		
		//오름차순 검증
		for(int i=0; i<N-1; i++) {
			
			if(arr[i]<=arr[i+1]) {
				cntincr++;
			}
			else {
				cntincr = 1;				
			}
			
			max = Math.max(max, cntincr);
			
		}
		
		//내림차순 검증
		for(int i=0; i<N-1; i++) {
			
			if(arr[i]>=arr[i+1]) {
				cntdecr++;
			}
			else {
				cntdecr = 1;				
			}
			
			max = Math.max(max, cntdecr);
			
		}
		
		System.out.println(max);
		
		
	}
}
