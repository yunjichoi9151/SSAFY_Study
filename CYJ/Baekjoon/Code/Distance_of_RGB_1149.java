package Silver_1.Java_files.Code;

import java.util.Scanner;

public class Distance_of_RGB_1149 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 최솟값 담는 배열
        int[][] dp = new int[n][3];
        for(int i = 0; i < n; i++) {
            // 빨강, 초록, 파랑 순서
            int r = sc.nextInt(), g = sc.nextInt(), b = sc.nextInt();
            // 2번째 집부터
            if(i > 0) {
                dp[i][0] = r + Math.min(dp[i - 1][1], dp[i - 1][2]);
                dp[i][1] = g + Math.min(dp[i - 1][0], dp[i - 1][2]);
                dp[i][2] = b + Math.min(dp[i - 1][0], dp[i - 1][1]);
            }
            // 1번째 집이면 그대로 담기
            else {
                dp[i][0] = r;
                dp[i][1] = g;
                dp[i][2] = b;
            }
        }
        // 답 출력
        System.out.println(Math.min(Math.min(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]));
        sc.close();
    }
}
