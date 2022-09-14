package Gold_5.Java_files.Code;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Tomato_7576 {
    // store에 토마토 정보 자료 입력
    static int[][] store;
    // BFS 활용을 위한 큐 선언
    static Queue<int[]> queue = new LinkedList<>();
    static int n;
    static int m;
    // 사방탐색
    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {-1, 1, 0, 0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        // 가로 길이가 n, 세로 길이가 m이므로 int[m][n]으로 선언
        store = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                // store에 저장
                store[i][j] = sc.nextInt();
                // 만약 익은 토마토일 경우, 따로 큐에 해당 값 저장
                if(store[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        // (예시) BFS 실행 전 -> 실행 후 변화
        /* 0 0 0 0 0 0     9 8 7 6 5 4
           0 0 0 0 0 0     8 7 6 5 4 3
           0 0 0 0 0 0     7 6 5 4 3 2
           0 0 0 0 0 1     6 5 4 3 2 1 */
        System.out.println(BFS());
    }

    public static int BFS() {
        while(!queue.isEmpty()) {
            // 큐 맨 앞에 있는 값을 tmp에 저장한 후 삭제
            int[] tmp = queue.poll();
            // 사방탐색
            for(int i = 0; i < 4; i++) {
                // tmp[0]에 있는 값이 위의 store[i][j]에서 i값
                int x = tmp[0] + dx[i];
                // tmp[1]에 있는 값이 위의 store[i][j]에서 j값 
                int y = tmp[1] + dy[i];
                // 0보다 크고 x는 m보다 작은지, y는 n보다 작은지 판별
                if(x >= 0 && x < m && y >= 0 && y < n) {
                    // 익지 않은 토마토일 경우
                    if(store[x][y] == 0) {
                        // 기준 좌표의 값 + 1로 변경
                        // 이렇게 해야 값이 누적되면서 max 값을 구할 수 있음
                        store[x][y] = store[tmp[0]][tmp[1]] + 1;
                        // 이제 익은 상태이므로, 큐에 해당 값 저장
                        queue.add(new int[]{x, y});
                    }
                }
            }
        }
        int max = -1;
        // 토마토가 모두 익었을 경우
        if(isZero()) {
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    // max값 판별 후 갱신
                    if(max < store[i][j]) {
                        max = store[i][j];
                    }
                }
            }
            // 앞의 판별문들을 통과했다면, 토마토 최소 1개가 익은 상태로 시작했을 것임
            // 그럼 하루가 지나면, 처음 익은 상태였던 토마토 칸의 값은 2가 됨
            // 그러므로, 익을 때까지 걸린 날짜를 구하려면 max 값에서 1을 빼줘야 함
            return max - 1;
        }
        // 토마토가 모두 익지 못하는 상황
        else {
            return -1;
        }
    }

    public static boolean isZero() {
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                // 안 익은 토마토가 하나라도 있으면 안됨
                if(store[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
