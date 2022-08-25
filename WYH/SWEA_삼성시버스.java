package day0819;

import java.util.Scanner;

public class SWEA_삼성시버스 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[] A = new int[N];
			int[] B = new int[N];

			for (int i = 0; i < N; i++) {
				A[i] = sc.nextInt();
				B[i] = sc.nextInt();
			}
			int P = sc.nextInt();
			int[] C = new int[P];
			for (int i = 0; i < P; i++) {
				C[i] = sc.nextInt();
			}

			int[] cnt = new int[P];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < P; j++) {
					if (C[j] >= A[i] && C[j] <= B[i]) {
						cnt[j] += 1;
					}

				}
			}

			System.out.print("#" + tc + " ");
			for(int i=0;i<P;i++) {
				System.out.print(cnt[i] + " ");
			}
			System.out.println();
		}
	}
}
