package day0413;

import java.util.Scanner;

public class BOJ_11920 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		

		for (int j = 1; j <= N; j++) {
			System.out.println(arr[j-1]+"부터 시작");
			for (int k = 0; k < N-j; k++) {
				if (arr[k+1] < arr[k]) {
					System.out.println(arr[k]+"랑 "+arr[k+1]+"를 스왑");
					int tmp = arr[k+1];
					arr[k+1] = arr[k];
					arr[k] = tmp;
				} 

			}

		}

		for (int i = 0; i < N; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
