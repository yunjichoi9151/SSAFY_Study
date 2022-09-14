package Silver_1.Java_files.Code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Housing_Numbering_2667 {
    // map에 지도 자료 입력
    static int[][] map;
    // 방문 여부 boolean형으로 저장
    static boolean[][] visit;
    // 각 단지에 속하는 집 수 저장
    static ArrayList<Integer> house = new ArrayList<>();
    static int n;
    static int cnt = 0;
    // 사방탐색
    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {-1, 1, 0, 0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        visit = new boolean[n][n];
        // String으로 입력받은 후, 한 숫자씩 끊어서 map에 저장
        for(int i = 0; i < n; i++) {
            String s = sc.next();
            for(int j = 0; j < n; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                // 방문한 적이 없고, 집이 있는 곳일 경우
                if(!visit[i][j] && map[i][j] == 1) {
                    // map[i][j] 부분도 cnt해줘야 하기 때문에 cnt++먼저 해줌
                    cnt++;
                    DFS(i, j);
                    // 단지에 속하는 집 수 저장
                    house.add(cnt);
                    // cnt 초기화
                    cnt = 0;
                }
            }
        }
        // 오름차순으로 정렬
        Collections.sort(house);
        // 총 단지수 출력
        System.out.println(house.size());
        for(int i = 0; i < house.size(); i++) {
            // 각 단지별 집 수 출력
            System.out.println(house.get(i));
        }
    }

    public static void DFS(int a, int b) {
        // 방문 여부 true로 바꿔줌
        visit[a][b] = true;
        // 사방탐색
        for(int i = 0; i < 4; i++) {
            int x = a + dx[i];
            int y = b + dy[i];
            // 0보다 크고 n보다 작은지 판별
            if(x >= 0 && x < n && y >= 0 && y < n) {
                // 방문한 적이 없고, 집이 있는 곳일 경우
                if(!visit[x][y] && map[x][y] == 1) {
                    DFS(x, y);
                    cnt++;
                }
            }
        }
    }
}
