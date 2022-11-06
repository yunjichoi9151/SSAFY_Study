package Baekjoon.Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class PRG_전력망둘로나누기 {
    public LinkedList<Integer>[] list;
    public boolean[] visited;

    public int bfs(int v1, int v2, int n) {
        Queue<Integer> q = new LinkedList<>();
        visited = new boolean[n + 1];

        int cnt = 0;

        q.add(v1);
        visited[v1] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();
            cnt++;

            for (int next : list[curr]) {
                if (next != v2 && !visited[next]) {
                    q.add(next);
                    visited[next] = true;
                }
            }
        }
        return cnt;
    }

    public int solution(int n, int[][] wires) {

        int answer = 100;

        list = new LinkedList[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new LinkedList<>();
        }

        //인접리스트에 추가
        for (int[] wire : wires) {
            list[wire[0]].add(wire[1]);
            list[wire[1]].add(wire[0]);
        }


        //각 전선들을 하나씩 끊어보고 최소값 구하기
        for (int[] wire : wires) {
            int n1 = bfs(wire[0], wire[1], n);
            int n2 = bfs(wire[1], wire[0], n);

            answer = Math.min(Math.abs(n1 - n2), answer);
        }


        return answer;
    }
}
