package Gold_4.Java_files.Code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Time_Machine_11657 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // n : 도시의 개수
        // m : 버스 노선의 개수
        int n = sc.nextInt(), m = sc.nextInt();
        // arr : 버스 노선 정보 저장
        ArrayList<Node> arr = new ArrayList<Node>();
        // dist : 거리 정보 저장
        long dist[] = new long[n + 1];
        // isCycle : cycle 여부 판단
        boolean isCycle = false;
        // dist에 long max값들 넣어줌
        Arrays.fill(dist, Long.MAX_VALUE);
        // 버스 노선 정보 저장
        for(int i = 0; i < m; i++) {
            int a = sc.nextInt(), b = sc.nextInt();
            long c = sc.nextLong();
            arr.add(new Node(a, b, c));
        }
        // 처음 값 0으로 지정
        dist[1] = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < m; j++) {
                // 시작도시, 도착도시, 시간 정보 가져오기
                int a = arr.get(j).start;
                int b = arr.get(j).end;
                long c = arr.get(j).time;
                System.out.println(("(" + a + ", " + b + ", " + c + ")"));
                // 도착지점 dist보다 (시작지점 dist + 시간)이 작고, 시작지점 dist가 max가 아닌경우
                if(dist[a] + c < dist[b] && dist[a] != Long.MAX_VALUE) {
                    // i가 n까지 돌았다면 cycle
                    if(i == n) {
                        isCycle = true;
                    }
                    System.out.println("dist[" + b + "] is dist[" + a + "] + " + c + " = " + (dist[a] + c));
                    // dist[도착지점] 갱신
                    dist[b] = dist[a] + c;
                }
            }
        }
        for(int i = 1; i <= n; i++) {
            System.out.println("dist[" + i + "] is " + dist[i]);
        }
        // cycle이라면 -1 출력
        if(isCycle) {
            System.out.println(-1);
        } else {
            for(int i = 2; i <= n; i++) {
                // max값이면(갱신이 되지 않았다면)
                if(dist[i] == Long.MAX_VALUE) {
                    System.out.println(-1);
                } else {
                    System.out.println(dist[i]);
                }
            }
        }
        sc.close();
    }
    // 버스 노선 정보
    public static class Node {
        int start;
        int end;
        long time;
        public Node(int a, int b, long c) {
            start = a;
            end = b;
            time = c;
        }
    }
}
