package Baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_16236_아기상어 {
    //사전 설정
    static int[][] map;
    static boolean[][] visited;
    static int size = 2;    //아기상어의 크기
    static int cnt = 0; //잡아먹어야 하는 애들 수
    static int time = 0;    //걸린 시간(구해야 하는거)
    static Queue<Node> queue = new LinkedList<>();     //위치 {r, c}를 저장하는 큐
    static PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
            if (o1.t != o2.t) return o1.t - o2.t;           //가장 거리가 가까운 순으로 우선정렬
            else if (o1.r != o2.r) return o1.r - o2.r;      //거리가 같으면 위에 있는(r좌표가 더 작은) 물고기부터
            else return o1.c - o2.c;                        //이것도 같으면 왼쪽에 있는(c좌표가 더 작은) 물고기부터
        }
    });

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};


    //입력받을 값
    static int N;   //공간의 크기(N*N)

    public static void bfs() {
        while (true) {
            //먹이 후보 탐색만
            while (!queue.isEmpty()) {
                //현재 상어의 위치
                Node curr = queue.poll();
                int r = curr.r;
                int c = curr.c;
                int t = curr.t;
//                visited[r][c] = true;
                /*
                    pop할때 방문처리를 하면 같은 원소가 큐에 여러번 들어갈 수 있어
                    시간초과나 메모리초과 에러가 발생하기 쉬움
                    방문처리는 꼭 push할때 하도록 할것
                 */

                for (int n = 0; n < 4; n++) {
                    int nr = r + dr[n];
                    int nc = c + dc[n];

                    //경계조건 및 방문여부 탐색
                    if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]) {
                        //자신보다 작은 물고기를 찾았다
                        if (size > map[nr][nc] && map[nr][nc] != 0) {
                            visited[nr][nc] = true;
                            queue.add(new Node(nr, nc, t + 1));     //다음 방문지
                            pq.add(new Node(nr, nc, t + 1));        //먹이후보 리스트
                        }
                        //이동만 할 수 있는 경우
                        if (size == map[nr][nc] || map[nr][nc] == 0) {
                            visited[nr][nc] = true;
                            queue.add(new Node(nr, nc, t + 1));     //먹이가 아니므로 먹이후보 리스트엔 없음
                        }
                    }
                }
            }

            //먹이로 삼을 물고기가 있다면
            if (!pq.isEmpty()) {
                //가장 가까이에 있는 물고기 선택
                Node next = pq.poll();
                time += next.t;     //이동하는데 걸리는 시간 추가
                cnt++;
                //몸집 불리기
                if (cnt == size) {
                    size++;
                    cnt = 0;
                }

                //먹어치우고 처리
                map[next.r][next.c] = 0;
                //그 외 먹이는 관심없음
                pq.clear();

                //방문배열 초기화
                visited = new boolean[N][N];
                visited[next.r][next.c] = true;

                queue.add(new Node(next.r, next.c, 0)); //다음 후보지
            } else //더이상 먹을 먹이가 없을 경우 종료
                return;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    queue.add(new Node(i, j, 0));
                    visited[i][j] = true;
                    map[i][j] = 0;
                }
            }
        }

        bfs();

        System.out.println(time);
    }

    private static class Node {
        int r;
        int c;
        int t;

        public Node(int r, int c, int t) {
            this.r = r;
            this.c = c;
            this.t = t;
        }
    }
}
