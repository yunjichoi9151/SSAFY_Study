package Silver_2.Java_files.Code;

import java.util.Scanner;

public class Running_Exciting_Functions_9184 {
    static int[][][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        dp = new int[101][101][101];
        while(true) {
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
            // 모두 -1이면 종료
            if(a == -1 && b == -1 && c == -1) {
                break;
            }
            // 답 출력
            System.out.printf("w(%d, %d, %d) = %d", a, b, c, w(a, b, c));
            System.out.println();
        }
        sc.close();
    }
    // 재귀함수 w
    public static int w(int a, int b, int c) {
        // 여기서부터는 함수 그대로 구현
        if(a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }
        if(a > 20 || b > 20 || c > 20) {
            return dp[a][b][c] = w(20, 20, 20);
        }
        // 이미 계산이 된 값일 경우 return
        // 이 위치에 넣어줘야 앞에서 -1 7 18 과 같은 예시에서 오류 발생 안함
        // 아니면 맨 앞에 넣고 0~20 조건 넣기
        if(dp[a][b][c] != 0) {
            return dp[a][b][c];
        }
        if(a < b && b < c) {
            return dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        }
        return dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
    }
}
