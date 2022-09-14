package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 사방탐색을 활용해서 visited[] = 0; map[][] = 1이면 시작
 */

public class BOJ_2667_단지번호붙이기 {
    static int N;   //지도 길이
    static int[][] map;     //지도 배열
    static boolean[][] visited;     //방문했는지 확인하는 배열
    static int aptNum = 0;  //단지 번호
    static int[] apt;   //단지별 집의 수

    //델타배열
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());    //지도 크기

        map = new int[N][N];
        visited = new boolean[N][N];
        apt = new int[N * N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';   //입력이 숫자가 다 붙어있기 때문에...
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                //방문한 적이 없고 집이 있는 곳부터 시작
                if (visited[i][j] == false && map[i][j] == 1) {
                    aptNum++;   //~단지 시작
                    dfs(i, j);  //~단지에 관해서 DFS
                }
            }
        }

        Arrays.sort(apt);   //단지별 집 수 오름차순 정렬

        StringBuilder sb = new StringBuilder();
        sb.append(aptNum).append("\n");     //총 단지 수
        for (int i = 0; i < apt.length; i++) {
            if (apt[i] != 0) {
                sb.append(apt[i]).append("\n");
            }
        }
        System.out.println(sb);
    }

    //특정 좌표부터 dfs
    public static void dfs(int x, int y) {
        visited[x][y] = true;   //방문처리
        apt[aptNum]++;  //해당 단지의 아파트 수 추가

        //사방탐색
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            //맵 밖으로 벗어나지 않도록
            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                //방문한 적 없고 집이 있다면
                if (visited[nx][ny] == false && map[nx][ny] == 1) {
                    dfs(nx, ny);    //주변에 집 없을때까지 재귀
                }
            }
        }
    }

}
