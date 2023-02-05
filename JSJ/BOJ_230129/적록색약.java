package 백준;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// bfs
// 사방탐색
// 적록색약이 아닌 사람이 봤을 때의 구역의 개수와 적록색약인 사람이 봤을 때의 구역의 수를 공백으로 구분해 출력한다.
public class 적록색약 {

    public static int[][] drc = {{0, 0, -1, 1}, {-1, 1, 0, 0}};
    public static char[][] map;
    public static boolean[][] visited;

    public static int Normal, colorWeek, N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();   // 칸 크기

        // map 입력
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            String str = sc.next();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        // 색약X 카운트
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j);
                    Normal++;
                }
            }
        }

        // 색약 처리
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'G') map[i][j] = 'R';
            }
        }

        // 색약 O 카운트
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j);
                    colorWeek++;
                }
            }
        }

        System.out.println(Normal + " " + colorWeek);
    }

    public static void bfs(int x, int y) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{x, y});
        visited[x][y] = true;

        while (!que.isEmpty()) {
            int[] tmp = que.poll();

            for (int d = 0; d < 4; d++) {
                int cx = tmp[0] + drc[0][d];
                int cy = tmp[1] + drc[1][d];

                if (cx >= 0 && cx < N && cy >= 0 && cy < N && !visited[cx][cy] && map[tmp[0]][tmp[1]] == map[cx][cy]) {
                    que.add(new int[]{cx, cy});
                    visited[cx][cy] = true;
                }
            }
        }
    }
}
