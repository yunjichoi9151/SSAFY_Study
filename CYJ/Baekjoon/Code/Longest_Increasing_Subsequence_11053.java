package Silver_2.Java_files.Code;

import java.util.Scanner;

public class Longest_Increasing_Subsequence_11053 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = -1;
        // 수열 입력받는 배열
        int[] arr = new int[n];
        // DP
        int[] dp = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            // DP 배열 1로 초기화
            dp[i] = 1;
        }
        // 처음부터 돌면서 판별
        for(int i = 0; i < n; i++) {
            // 반복문을 i 전까지 돌기
            for(int j = 0; j < i; j++) {
                // arr[i]의 값이 arr[j]보다 크고(증가하는 형태), dp[j]가 dp[i]보다 크거나 같으면
                // 후자는 증가하는 부분을 연달아 count해주는 것에 필요함
                // i : 1 -> 0 & 1
                // i : 3 -> 0 & 1 & 3
                // i : 5 -> 0 & 1 & 3 & 5
                if(arr[j] < arr[i] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                }
            }
            // 가장 긴 길이로 갱신
            if(dp[i] > res) {
                res = dp[i];
            }
        }
        System.out.println(res);
        sc.close();
    }
}
