package Gold_3.Java_files.Code;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Baby_Shark_16236 {
    // n : 공간의 크기
    // ans : 엄마 상어에게 도움을 요청하지 않고 물고기를 잡아먹을 수 있는 시간
    static int n, ans = 0;
    // map : 공간의 상태
    static int[][] map;
    // 사방탐색
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    // baby : 아기상어(x, y, size, 먹은 횟수)
    static int[] baby = {0, 0, 2, 0};
    // visit : 방문 여부
    static boolean[][] visit;
    // queue : (x, y, 깊이(시간))
    static Queue <int[]> queue = new LinkedList<>();
    // fish : (x, y, 깊이(시간))
    private static PriorityQueue <int[]> fish;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        visit = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
                // 아기 상어의 위치라면
                if(map[i][j] == 9) {
                    // baby(x, y) 좌표 업데이트
                    baby[0] = i;
                    baby[1] = j;
                    // 0 표시로 바꿔줌
                    map[i][j] = 0;
                    // 방문여부 true
                    visit[i][j] = true;
                    // queue에 (i, j, 시간(0)) 추가
                    queue.offer(new int[] {i, j, 0});
                }
            }
        }
        fish = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });
        bfs();
        System.out.println(ans);
        sc.close();
    }

    public static void bfs() {
        while(!queue.isEmpty()) {
            // queue 가장 위에 있는 요소를 가져옴
            int x = queue.peek()[0];
            int y = queue.peek()[1];
            int d = queue.poll()[2];
            // 사방탐색
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                // 범위 안에 없다면, 이미 방문했다면, 현재 아기 상어의 size보다 물고기의 size가 크다면
                if(nx < 0 || nx >= n || ny < 0 || ny >= n || visit[nx][ny] || map[nx][ny] > baby[2]) {
                    continue;
                }
                // 먹을 수 있는 물고기라면
                if(map[nx][ny] > 0 && map[nx][ny] < baby[2]) {
                    // fish에 추가
                    fish.offer(new int[] {nx, ny, d + 1});
                }
                // queue에 추가(시간 + 1)
                queue.offer(new int[] {nx, ny, d + 1});
                // 방문여부 true
                visit[nx][ny] = true;
            }
            // 
            if(fish.size() > 0 && (queue.isEmpty() || d != queue.peek()[2])) {
                int nx = fish.peek()[0];
                int ny = fish.peek()[1];
                // 아기상어 위치 갱신
                baby[0] = nx;
                baby[1] = ny;
                // 먹은 곳 0으로 바꿔줌
                map[nx][ny] = 0;
                // 몸집만큼 먹었으면
                if(++baby[3] == baby[2]) {
                    // 아기상어 size+
                    baby[2]++;
                    // 먹은 횟수 0으로 초기화
                    baby[3] = 0;
                }
                // 결과값에 걸린 시간 추가
                ans += fish.poll()[2];
                // 모두 초기화
                queue.clear();
                fish.clear();
                // 새로운 자리에서 시작
                queue.offer(new int[] {nx, ny, 0});
                // 방문여부 배열 초기화
                visit = new boolean[n][n];
                // 방문여부 true
                visit[nx][ny] = true;
            }
        }
    }
}
