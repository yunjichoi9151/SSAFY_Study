package pracprac.bj.study.d0928;
//주어진 배열과 같은 길이의 dp를 생성해서
//같은 인덱스에 증가한 길이를 저장한다

import java.util.Scanner;

public class bj11053 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		int[] dp = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		//일단 전부 1로 두고 시작
		for(int i=0; i<N; i++) {
			
			dp[i] = 1;
		 
			for(int j=0; j<i; j++) {
				
				//원소가 커지는 경우 dp 저장값 증가
				//배열의 j번째가 i번째보다 작고, dp의 i번째가 j번째 dp+1보다 작으면
				//j번째 dp +1이 i번째 dp가 됨
				if(arr[j]< arr[i]&& dp[i] < dp[j]+1) {
					dp[i] = dp[j] + 1;
				}
			}
					
		}
		
		int ans = 1;
		
		for(int i=0; i<N; i++) {
			
			ans = Math.max(dp[i], ans);
			
		}
		
		System.out.println(ans);
		
	}
}
