package day1012;

import java.util.Scanner;

public class SWEA_6190 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			for(int i=0;i<N;i++) {
				arr[i] = sc.nextInt();
			}
			int max = 0;
			for(int i=0;i<N;i++) {
				for(int j=i+1;j<N;j++) {
					int val = arr[i] * arr[j];
					String s = String.valueOf(val);
					int flag = 0;
					for(int k=1;k<s.length();k++) {
						if(s.charAt(k-1)>s.charAt(k)) {
							flag = 1;
							break;
						}
					}
					if(flag == 0) {
						max = Math.max(max, val);
					}
				}
			}
			
			System.out.println("#"+tc+" "+max);
		}
	}
}
