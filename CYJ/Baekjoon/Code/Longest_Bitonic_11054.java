package Gold_4.Java_files.Code;

import java.util.Scanner;

public class Longest_Bitonic_11054 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 수열 입력받는 배열
        int[] arr = new int[n];
        // 증가하는 부분 DP
        int[] dp1 = new int[n];
        // 감소하는 부분 DP
        int[] dp2 = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            // DP 배열 1로 초기화
            dp1[i] = 1;
            dp2[i] = 1;
        }
        // 처음부터 돌면서 판별
        for(int i = 0; i < n; i++) {
            // 반복문을 i 전까지 돌기
            for(int j = 0; j < i; j++) {
                // arr[i]의 값이 arr[j]보다 크고(증가하는 형태), dp[j]가 dp[i]보다 크거나 같으면
                if(arr[j] < arr[i] && dp1[i] <= dp1[j]) {
                    dp1[i] = dp1[j] + 1;
                }
            }
        }
        // 끝에서부터 돌면서 판별
        for(int i = n - 1; i >= 0; i--) {
            for(int j = i + 1; j < n; j++) {
                // arr[i]의 값이 arr[j]보다 크고(감소하는 형태), dp[j]가 dp[i]보다 크거나 같으면
                if(arr[j] < arr[i] && dp2[i] <= dp2[j]) {
                    dp2[i] = dp2[j] + 1;
                }
            }
        }
        // res값 초기화
        int res = dp1[0] + dp2[0] - 1;
        for(int i = 0; i < n; i++) {
            // 가장 긴 길이로 갱신
            res = Math.max(res, dp1[i] + dp2[i]);
        }
        // 결과값에서 -1(중복되는 개수) 해주기
        System.out.println(res - 1);
        sc.close();
    }
}
