package Gold_1.Java_files.Code;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Escape_of_Bead_2_13460 {
    // 빨간 구슬과 파란 구슬 각각 큐 선언
    static Queue<Ball> red_queue;
    static Queue<Ball> blue_queue;
    // board에 보드 자료 입력
    static char[][] board;
    // 방문여부 boolean형으로 저장
    static boolean[][][][] visit;
    // 빨간 구슬과 파란 구슬 선언
    static Ball red_ball, blue_ball;
    // 상하좌우
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    // 결과값
    static int res = -1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        board = new char[n][m];
        visit = new boolean[n][m][n][m];
        for(int i = 0; i < n; i++) {
            // 띄어쓰기가 없으므로 String으로 한 줄을 받았다가 charAt으로 하나씩 나눠줌
            String s = sc.next();
            for(int j = 0; j < m; j++) {
                board[i][j] = s.charAt(j);
                // 빨간 구슬일 경우 위치 정보 저장
                if(board[i][j] == 'R') {
                    red_ball = new Ball(i, j, 0);
                }
                // 파란 구슬일 경우 위치 정보 저장
                else if(board[i][j] == 'B') {
                    blue_ball = new Ball(i, j, 0);
                }
            }
        }
        // BFS
        BFS(red_ball, blue_ball);
        System.out.println(res);
        sc.close();
    }

    public static void BFS(Ball red_ball, Ball blue_ball) {
        // 빨간색 구슬 큐 선언
        red_queue = new LinkedList<>();
        // 파란색 구슬 큐 선언
        blue_queue = new LinkedList<>();
        // 먼저 빨간구슬 정보를 red_queue에 넣어줌
        red_queue.offer(red_ball);
        // 먼저 파란구슬 정보를 blue_queue에 넣어줌
        blue_queue.offer(blue_ball);
        // 방문여부 true로 바꿔줌
        visit[red_ball.x][red_ball.y][blue_ball.x][blue_ball.y] = true;
        // 둘 다 비어있지 않다면
        while(!red_queue.isEmpty() && !blue_queue.isEmpty()) {
            // red_queue 맨 앞에 있는 값을 tmp_rball에 저장 후 삭제
            Ball tmp_rball = red_queue.poll();
            // blue_queue 맨 앞에 있는 값을 tmp_bball에 저장 후 삭제
            Ball tmp_bball = blue_queue.poll();
            // 구슬을 움직인 수가 10을 초과했다면 -1 출력
            if(tmp_rball.cnt > 10) {
                return;
            }
            // 파란구슬이 구멍으로 빠져나갔을 때
            if(board[tmp_bball.x][tmp_bball.y] == 'O') {
                continue;
            }
            // 빨간구슬이 구멍으로 빠져나갔을 때
            if(board[tmp_rball.x][tmp_rball.y] == 'O') {
                res = tmp_rball.cnt;
                return;
            }
            // 상하좌우
            for(int i = 0; i < 4; i++) {
                // rx에 tmp_rball의 x값 저장, ry에 tmp_rball의 y값 저장
                int rx = tmp_rball.x;
                int ry = tmp_rball.y;
                while(true) {
                    // 상하좌우
                    rx += dx[i];
                    ry += dy[i];
                    // 구멍을 만났다면
                    if(board[rx][ry] == 'O') {
                        break;
                    }
                    // 벽을 만났다면
                    else if(board[rx][ry] == '#') {
                        // 다시 원위치로
                        rx -= dx[i];
                        ry -= dy[i];
                        break;
                    }
                }
                // bx에 tmp_bball의 x값 저장, by에 tmp_bball의 y값 저장
                int bx = tmp_bball.x;
                int by = tmp_bball.y;
                while(true) {
                    // 상하좌우
                    bx += dx[i];
                    by += dy[i];
                    // 구멍을 만났다면
                    if(board[bx][by] == 'O') {
                        break;
                    }
                    // 벽을 만났다면
                    else if(board[bx][by] == '#') {
                        // 다시 원위치로
                        bx -= dx[i];
                        by -= dy[i];
                        break;
                    }
                }
                // 두 개의 위치 동일 & 구멍을 만난 것은 아니라면
                if(rx == bx && ry == by && board[rx][ry] != 'O') {
                    // 각각 공이 이동한 거리 계산 후 더 긴 쪽이 덜 이동하게 함
                    int r_dis = Math.abs(tmp_rball.x - rx) + Math.abs(tmp_rball.y - ry);
                    int b_dis = Math.abs(tmp_bball.x - bx) + Math.abs(tmp_bball.y - by);
                    // 빨간 구슬이 더 이동했을 때
                    if(r_dis > b_dis) {
                        rx -= dx[i];
                        ry -= dy[i];
                    }
                    // 파란 구슬이 더 이동했을 때
                    else {
                        bx -= dx[i];
                        by -= dy[i];
                    }
                }
                if(!visit[rx][ry][bx][by]) {
                    // 기울이고 나서의 도달 지점의 방문 여부를 true로 바꿔줌
                    visit[rx][ry][bx][by] = true;
                    // red_queue와 blue_queue에 각각 도달 지점의 좌표 값을 Ball에 넣어줌
                    red_queue.offer(new Ball(rx, ry, tmp_rball.cnt + 1));
                    blue_queue.offer(new Ball(bx, by, tmp_bball.cnt + 1));
                }
            }
        }
    }
    // x좌표, y좌표, count 값 저장
    public static class Ball {
        int x;
        int y;
        int cnt;

        Ball(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
