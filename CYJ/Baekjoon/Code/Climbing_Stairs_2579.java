package Silver_3.Java_files.Code;

import java.util.Scanner;

public class Climbing_Stairs_2579 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 계단이 1칸이면 dp[1]과 dp[2]를 구할 때 오류가 발생하므로 크기를 n + 2로 설정
        // 계단 점수 담는 배열
        int[] stairs = new int[n + 2];
        // DP
        int[] dp = new int[n + 2];
        for(int i = 0; i < n; i++) {
            stairs[i] = sc.nextInt();
        }
        // dp[0] : 첫 계단 점수 저장
        dp[0] = stairs[0];
        // dp[1] : 첫 계단 + 두 번째 계단 점수 저장(최대한 많이 밟아야 점수 측면에서 유리함)
        dp[1] = stairs[0] + stairs[1];
        // dp[2] : (0, 2)와 (1, 2) 중 합이 큰 계단 점수 저장
        dp[2] = Math.max(stairs[0], stairs[1]) + stairs[2];
        // dp[3 이상] : i의 직전 계단을 밟지 않는 경우와, 직전 계단을 밟는 경우 중 큰 점수 저장
        // ex) dp[3] = Math.max(dp[1] + stairs[3], dp[0] + stairs[2] + stairs[3])
        for(int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + stairs[i - 1]) + stairs[i];
        }
        // index가 0부터 시작했기 때문에 dp[n - 1] 출력
        System.out.println(dp[n - 1]);
        sc.close();
    }
}
