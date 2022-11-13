package Baekjoon.Programmers;

import java.util.ArrayList;

public class PRG_프렌즈4블록 {
    public int solution(int n, int m, String[] board) {
        int answer = 0;
        int flag = 0;

        char[][] map = new char[n][m];
        boolean[][] visited;

        for (int i = 0; i < n; i++) {
            map[i] = board[i].toCharArray();
        }

        while (true) {
            flag = 0;
            visited = new boolean[n][m];
            //2x2칸 같은 모양인지 확인
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < m - 1; j++) {
                    if (map[i][j] != '0' && (map[i][j] == map[i + 1][j]) && (map[i][j] == map[i][j + 1]) && (map[i][j] == map[i + 1][j + 1])) {
                        visited[i][j] = true;
                        visited[i + 1][j] = true;
                        visited[i][j + 1] = true;
                        visited[i + 1][j + 1] = true;
                        flag++;
                    }
                }
            }
            if (flag == 0) break;

            //안지워진 칸 내리기
            for (int j = 0; j < m; j++) {
                ArrayList<Character> list = new ArrayList<>();
                for (int i = n - 1; i >= 0; i--) {
                    if (!visited[i][j]) {
                        list.add(map[i][j]);
                    } else {
                        answer++;
                    }
                }
                for (int i = n - 1, idx = 0; i >= 0; i--, idx++) {
                    if (idx < list.size()) {
                        map[i][j] = list.get(idx);
                    } else {
                        map[i][j] = '0';
                    }
                }
            }
        }


        return answer;
    }
}
