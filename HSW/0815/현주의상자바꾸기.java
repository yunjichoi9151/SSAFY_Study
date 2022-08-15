package Baekjoon.SWEA;

import java.util.Scanner;

public class 현주의상자바꾸기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();
        for (int k = 1; k <= tc; k++) {
            int N = sc.nextInt();
            int Q = sc.nextInt();
            int[] arr = new int[N];

            //L번부터 R번 상자값 변경하기
            for (int i = 0; i < Q; i++) {
                int L = sc.nextInt();
                int R = sc.nextInt();
                for (int j = L - 1; j < R; j++) {
                    arr[j] = i + 1;
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append("#" + k);
            for (int i : arr) {
                sb.append(" " + i);
            }
            System.out.println(sb);
        }

    }
}
