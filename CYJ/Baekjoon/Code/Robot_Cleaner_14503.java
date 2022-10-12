package Gold_5.Java_files.Code;

import java.util.Scanner;

public class Robot_Cleaner_14503 {
    static int[][] map;
    // 사방탐색
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
    // ans : 결과값
    static int ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // n : 세로 크기, m : 가로 크기
        int n = sc.nextInt(), m = sc.nextInt();
        // r, c : 로봇 청소기가 있는 칸의 좌표, d : 바라보는 방향
        int r = sc.nextInt(), c = sc.nextInt(), d = sc.nextInt();
        // map : 지도 정보
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                map[i][j] = sc.nextInt();
        }
        solve(r, c, d);
        System.out.println(ans);
        sc.close();
    }

    static void solve(int r, int c, int d) {
        // 빈칸이면
        if(map[r][c] == 0) {
            // -1로 바꿔줌
            map[r][c] = -1;
            // 청소했으므로 ans++
            ans++;
        } else if(map[r][c] == 1) {
            // 벽이면 return
            return;
        }
        // nd : 새로운 direction(초기값 : 기존 direction)
        int nd = d;
        for (int i = 0; i < 4; i++) {
            // 0 -> 3, 1 -> 0, 2 -> 1, 3 -> 2의 방향을 바라보게 되므로 (nd + 3) % 4
            nd = (nd + 3) % 4;
            // 각 방향에 맞게 값 더해서 좌표 바꿔주기
            int nr = r + dr[nd];
            int nc = c + dc[nd];
            // 새로운 좌표도 빈 칸이라면
            if (map[nr][nc] == 0) {
                // 새로운 좌표 solve
                solve(nr, nc, nd);
                return;
            }
        }
        // 좌표를 원래대로 되돌림
        solve(r - dr[d], c - dc[d], d);
        return;
    }
}
