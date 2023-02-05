package 백준;

import java.util.Scanner;

// dfs
public class 컴백홈 {

    static int[][] drc = {{0, 0, -1, 1}, {-1, 1, 0, 0}};
    static char[][] map;
    static boolean[][] visited;
    static int R, C, K, cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();
        K = sc.nextInt();   // 제한 거리

        map = new char[R][C];
        visited = new boolean[R][C];

        for (int r = 0; r < R; r++) {
            String tmp = sc.next();
            for (int c = 0; c < C; c++) {
                map[r][c] = tmp.charAt(c);
            }
        }

        visited[R - 1][0] = true;
        dfs(R - 1, 0, 1);   // 시작점

        System.out.println(cnt);

    }

    public static void dfs(int r, int c, int move) {
        // 종료 조건
        if (r == 0 && c == C - 1) {
            if (move == K) {
                cnt++;
            }
            return;
        }

        for (int d = 0; d < 4; d++) {
            int cx = r + drc[0][d];
            int cy = c + drc[1][d];

            if (cx >= 0 && cx < R && cy >= 0 && cy < C && !visited[cx][cy] && map[cx][cy] != 'T') {
                visited[cx][cy] = true;
                dfs(cx, cy, move + 1);
                visited[cx][cy] = false;
            }
        }
    }
}
