package pracprac.bj.study.d0928;
//이번에는 증가하다 감소하는 수열 : 바이토닉
//전과 마찬가지로 왼쪽부터 증가 길이를 기록하는 dp1
//오른쪽부터 역순으로 증가 길이를 기록하는 dp2
//두 dp에 저장된 값을 합치고 -1(중복값 제거)을 해주면 최대길이의 바이토닉 수열 도출 가능

import java.util.Scanner;

public class bj11054 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		//오름차순
		int[] dp1 = new int[N];
		//내침차순
		int[] dp2 = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		//일단 전부 1로 두고 시작
		for(int i=0; i<N; i++) {
			
			dp1[i] = 1;
		 
			for(int j=0; j<i; j++) {
				
				//원소가 커지는 경우 dp 저장값 증가
				//배열의 j번째가 i번째보다 작고, dp의 i번째가 j번째 dp+1보다 작으면
				//j번째 dp +1이 i번째 dp가 됨
				if(arr[j]< arr[i]&& dp1[i] < dp1[j]+1) {
					dp1[i] = dp1[j] + 1;
				}
			}
					
		}
		
		//역순이니까 for문만 거꾸로 돌리면 됨
		//일단 전부 1로 두고 시작
		for(int i=N-1; i>=0; i--) {
			
			dp2[i] = 1;
		 
			for(int j=N-1; j>i; j--) {
				
				//원소가 커지는 경우 dp 저장값 증가
				//배열의 j번째가 i번째보다 작고, dp의 i번째가 j번째 dp+1보다 작으면
				//j번째 dp +1이 i번째 dp가 됨
				if(arr[j] < arr[i]&& dp2[i] < dp2[j]+1) {
					dp2[i] = dp2[j] + 1;
				}
			}
					
		}
		
		
		int ans = 1;
		
		for(int i=0; i<N; i++) {
			
			ans = Math.max(dp1[i]+dp2[i], ans);
			
		}
		
		//중복된 원소(초기값1) 제거
		System.out.println(ans-1);
		
	}
}