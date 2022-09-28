package day0928;

import java.util.Scanner;

public class BOJ_2579 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] stair = new int[301];
		int[] sum = new int[301];
		for(int i=1;i<=N;i++) {
			stair[i] = sc.nextInt();
		}
		
		sum[1] = stair[1];
		sum[2] = stair[1]+stair[2];
		sum[3] = Math.max(stair[1], stair[2]) + stair[3];
		
		for(int i=4;i<=N;i++) {
			sum[N] = Math.max(stair[N-3]+stair[N-1], stair[N-2])+stair[N];
		}
		
		System.out.println(sum[N]);
	}
}
