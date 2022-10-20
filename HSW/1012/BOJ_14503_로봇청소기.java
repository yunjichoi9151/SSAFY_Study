package Baekjoon.Gold;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_14503_로봇청소기 {

    static int[][] map;
    static boolean[][] visited; //방문처리 = 청소
    static Queue<Robot> queue = new LinkedList<>();


    static int N;
    static int M;
    static int cnt = 0;

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    private static void bfs() {
        while (!queue.isEmpty()) {
            Robot robot = queue.poll();

            int r = robot.r;
            int c = robot.c;
            int d = robot.dir;

            int nd = d;
            boolean check = false;
            for (int n = 0; n < 4; n++) {
                d = (d + 3) % 4;
                int nr = r + dr[d];
                int nc = c + dc[d];

                //방문한적이 없고 벽이 아니라면
                if (map[nr][nc] == 0 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    cnt++;
                    queue.add(new Robot(nr, nc, d));
                    check = true;
                    break;
                }
            }
            if (!check) {
                //4방향 전부 돌았는데 갈 곳이 없다

                int nr = r - dr[nd];
                int nc = c - dc[nd];

                if (map[nr][nc] == 0) {
                    queue.add(new Robot(nr, nc, d));
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];
        visited = new boolean[N][M];


        int r = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();


        queue.add(new Robot(r, c, d));  //시작 노드 생성
        visited[r][c] = true;   //방문처리
        cnt++;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        bfs();

        System.out.println(cnt);
    }

    private static class Robot {
        int r;      //y좌표
        int c;      //x좌표
        int dir;    //로봇이 보고 있는 방향

        public Robot(int r, int c, int dir) {
            this.r = r;
            this.c = c;
            this.dir = dir;
        }
    }
}
