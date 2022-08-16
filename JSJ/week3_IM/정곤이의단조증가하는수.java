package week3_IM;

import java.util.ArrayList;
import java.util.Scanner;
 
public class 정곤이의단조증가하는수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
 
            // 곱한 값 list
            ArrayList<String> list = new ArrayList<>();
 
            // N개의 정수 입력
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
 
            // 곱한 값 넣기
            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    list.add(String.valueOf(arr[i] * arr[j]));
                }
            }
 
            // 최대값
            int max = -1;
            int cres = -1;
 
            // list 탐색
            for (String s : list) {
 
                int pre = s.charAt(0) - '0';
                // 단조 검사
                for (int i = 1; i < s.length(); i++) {
 
                    // 앞자리숫자보다 작으면 break (왜 작동안해)
                    if (s.charAt(i) - '0' < pre) {
                        cres = -1;
                        break;
 
                    } else { // 아니면 pre 업데이트
                        pre = s.charAt(i) - '0';
                        cres = Integer.parseInt(s);
                    }
 
                }
 
                // 죄대값 탐색
                max = Math.max(max, cres);
            }
 
            System.out.println("#" + t + " " + max);
        }
    }
}