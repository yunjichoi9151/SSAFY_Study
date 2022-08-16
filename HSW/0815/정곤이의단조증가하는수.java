package Baekjoon.SWEA;

import java.util.Scanner;

public class 정곤이의단조증가하는수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();
        for (int k = 1; k <= tc; k++) {
            int N = sc.nextInt();

            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }


            int max = -1;
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    //판별할 수 num
                    int num = arr[i] * arr[j];
                    //chatAt() 사용을 위해 num을 문자열로 변환
                    String str = String.valueOf(num);
                    boolean flag = false;

                    for (int r = 1; r < str.length(); r++) {
                        //단조증가가 아닌 경우(앞자리 수가 뒷자리 수보다 큰 경우)
                        if (str.charAt(r - 1) > str.charAt(r)) {
                            flag = true;
                            break;
                        }
                    }

                    //최댓값 찾기
                    if (!flag) {
                        max = Math.max(max, num);
                    }
                }
            }
            System.out.println("#" + k + " " + max);
        }
    }
}
