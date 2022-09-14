package pracprac.bj.study.d0907;

import java.util.Scanner;

public class bj1300 {
	
	public static void main(String[] args) {
		
		//https://st-lab.tistory.com/281
		//2차원 구구단 배열을 일차원 배열로 펴서 오름차순 정렬했을 때 K번째인덱스 값을 구하라는 뜻
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		//B[K]는 min과 max 사이의 범위에 있다. (N^2, 즉 K값을 초과할 수 없음)
		long min = 1;
		long max = K;
		
		//lower bound 이분탐색 (같은 수가 중복되어 나옴-같은 경우의 수가 여러개 나올 수 있으므로)
		while(min<max) {
			
			//중간값 설정
			long mid = (min + max)/2;
			long cnt = 0;
			
			
			//mid를 i번째 행으로 나눠서 누적합 (단, 나눈 값은 N보다 클 수 없음)			
			for(int i=1; i<=N; i++) {
				
				cnt+= Math.min(mid/i, N);
			
			}
			
			//누적합이 K보다 크거나 같을 경우 mid보다 작은 수가 B[K]보다 많음
			//그럴 경우 max를 mid로 재설정 후 다시 탐색
			//누적합이 K보다 작을 경우 min값을 mid+1로 재설정하고 탐색
			if(K<=cnt) {
				
				max = mid;
				
			}else {
				
				min = mid + 1;
				
			}
						
		}
		
		//탐색 후 도출되는 min 값이 B[K]값
		System.out.println(min);
		
	}

}
