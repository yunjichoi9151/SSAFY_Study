package Gold_5.Java_files.Code;

import java.util.Scanner;

public class Ordinary_Backpack_12865 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        // 물건의 무게 저장
        int[] w = new int[n + 1];
        // 물건의 가치 저장
        int[] v = new int[n + 1];
        // DP
        int[] dp = new int[k + 1];

        for(int i = 1; i <= n; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }

        // 문제 예시로 이 반복문을 돌렸을 때의 dp는 아래와 같음
        /* 0 0 0 0 0 0 0 13 
           0 0 0 0 0 0 13 13
           0 0 0 0 0 0 13 13
           0 0 0 0 0 0 13 13
           0 0 0 0 0 8 13 13
           0 0 0 0 8 8 13 13
           0 0 0 0 8 8 13 14
           0 0 0 0 8 8 13 14
           0 0 0 0 8 8 13 14
           0 0 0 0 8 8 13 14
           0 0 0 6 8 8 13 14
           0 0 0 6 8 8 13 14
           0 0 0 6 8 8 13 14
           0 0 0 6 8 12 13 14 */
        for(int i = 1; i <= n; i++) {
            for(int j = k; j - w[i] >= 0; j--) {
                // 기존 dp 값 vs 더 담을 수 있는 무게의 dp값(최대가치) + i번 물건의 가치
                // 둘 중 최댓값으로 계속 갱신
                dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
            }
        }
        System.out.println(dp[k]);
        sc.close();
    }
}
