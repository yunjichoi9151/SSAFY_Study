package pracprac.bj.study.d0824;

import java.util.Scanner;

public class bj2559 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int K = sc.nextInt();
		
		int[] arr = new int[N];
		
		//마이너스도 기록되므로 정수의 최소값으로 초기화 필요
		int ans = Integer.MIN_VALUE;
		
		for(int i=0; i<N; i++) {
			
			arr[i] = sc.nextInt();
		}
		
		//K개씩 합산
		for(int i=0; i<=N-K; i++) {
			int sum = 0;
			
			//i번째부터 K개 합산
			for(int j=i; j<K+i; j++) {
				sum+=arr[j];
			}
			
			ans = Math.max(sum, ans);
			
		}
		
		System.out.println(ans);
		
	}

}


