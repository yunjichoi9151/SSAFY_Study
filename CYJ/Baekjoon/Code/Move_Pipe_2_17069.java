package Gold_4.Java_files.Code;

import java.util.Scanner;

public class Move_Pipe_2_17069 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] map = new int[n][n];
        // 가로 : 0, 세로 : 1, 대각선 : 2
        long[][][] dp = new long[n][n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        // 초기값을 1로 설정
        dp[0][1][0] = 1;
        for(int i = 0; i < n; i++) {
            for(int j = 2; j < n; j++) {
                // 벽이면 넘어감
                if(map[i][j] == 1) {
                    continue;
                }
                // 가로 : 가로, 대각선 방향에서 가능
                dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2];
                // i >= 1 조건 안 달아주면 범위 넘어감
                if(i >= 1) {
                    // 세로 : 세로, 대각선 방향에서 가능
                    dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2];
                    // 대각선 방향은 (i, j - 1)과 (i - 1, j)는 벽이어서는 안됨
                    // 그림을 보면 대각선 방향이면 위의 두 공간을 통과해야하기 때문에 이 둘은 벽이어서는 안됨
                    if(map[i][j - 1] == 0 && map[i - 1][j] == 0) {
                        // 대각선 : 가로, 세로, 대각선 방향에서 가능
                        dp[i][j][2] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
                    }
                }
            }
        }
        // 답 출력
        System.out.println(dp[n - 1][n - 1][0] + dp[n - 1][n - 1][1] + dp[n - 1][n - 1][2]);
        sc.close();
    }
}
