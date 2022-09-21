package Gold_5.Java_files.Code;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class StartLink_5014 {
    // BFS 활용을 위한 큐 선언
    static Queue<Node> queue;
    // 방문여부 boolean형으로 저장
    static boolean[] visit;
    static int f, s, g, u, d;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        f = sc.nextInt();
        s = sc.nextInt();
        g = sc.nextInt();
        u = sc.nextInt();
        d = sc.nextInt();
        int ans = BFS();
        // BFS 결과가 -1이면 엘리베이터를 이용해서 G층에 갈 수 없는 경우이므로 use the stairs 출력
        // 아니라면 ans값 출력
        System.out.println(ans == -1 ? "use the stairs" : ans);
        sc.close();
    }

    public static int BFS() {
        // 큐 선언
        queue = new LinkedList<>();
        // visit 크기 f + 1으로 선언
        visit = new boolean[f + 1];
        // 먼저 Node(start 층, cnt:0) 큐에 넣어줌
        queue.offer(new Node(s, 0));
        // 방문여부 true로 바꿔줌
        visit[s] = true;
        while(!queue.isEmpty()) {
            // 큐 맨 앞에 있는 값을 tmp에 저장한 후 삭제
            Node tmp = queue.poll();
            // tmp 층이 목표한 층과 같다면 cnt return
            if(tmp.x == g) {
                return tmp.cnt;
            }
            // tmp층에서 u만큼 up한 값이 f층 이하이고, 방문한 적이 없다면
            if(tmp.x + u <= f && !visit[tmp.x + u]) {
                // 방문여부 true로 바꿔줌
                visit[tmp.x + u] = true;
                // Node(tmp층에서 u만큼 up한 층, tmp.cnt + 1) 큐에 추가
                queue.offer(new Node(tmp.x + u, tmp.cnt + 1));
            }
            // tmp층에서 d만큼 down한 값이 0보다 크고, 방문한 적이 없다면
            if(tmp.x - d > 0 && !visit[tmp.x - d]) {
                // 방문여부 true로 바꿔줌
                visit[tmp.x - d] = true;
                // Node(tmp층에서 d만큼 down한 층, tmp.cnt + 1) 큐에 추가
                queue.offer(new Node(tmp.x - d, tmp.cnt + 1));
            }
        }
        // 앞에서 tmp.cnt가 return되지 않았다면, -1 return
        return -1;
    }

    public static class Node {
        int x;
        int cnt;

        Node(int x, int cnt) {
            this.x = x;
            this.cnt = cnt;
        }
    }
}
