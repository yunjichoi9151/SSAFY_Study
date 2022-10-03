package pracprac.bj.study.d0928;
//규칙 연속계단은 최대 두번 밟을 수 있고
//한번에 1~2계단씩 오를 수 있고
//마지막 계단은 꼭 밟아야 함
//마지막 계단에서 누적합을 구한다 (bottom up)
//한칸 전의 경우 dp로 하면 연속 세번 밟았는지 여부 검사를 할 수 없어짐
//https://st-lab.tistory.com/132

import java.util.Scanner;

public class bj2579 {
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int s = sc.nextInt();
		
		int[] dp = new int[s+1];
		int[] arr = new int[s+1];
		
		for(int i=1; i<=s; i++) {
			arr[i] = sc.nextInt();
		}
		
		//시작점은 똑같음
		dp[1] = arr[1];
		
		//2 이상일 경우 누적
		if(s>=2) {
			dp[2] = arr[1] + arr[2];
		}
		
		//한칸 전은 dp로 돌릴 경우 세칸 연속 밟았는지 여부 검증이 불가능해짐
		for(int i=3; i<=s; i++) {
			dp[i] = Math.max(dp[i-2], dp[i-3]+arr[i-1]) + arr[i];
		}
		
		System.out.println(dp[s]);
		
	}
}


