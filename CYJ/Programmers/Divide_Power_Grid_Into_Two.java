import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Divide_Power_Grid_Into_Two {
    // arr : 연결된 wire 저장
    static ArrayList<Integer> arr[];
    public int solution(int n, int[][] wires) {
        // ans : 두 전력망이 가지고 있는 송전탑 개수의 차이 저장
        int ans = 10000;
        // len : wires의 길이
        int len = wires.length;
        arr = new ArrayList[n + 1];
        for(int i = 1; i < n + 1; i++) {
            // 초기화
            arr[i] = new ArrayList<>();
        }
        for(int i = 0; i < len; i++) {
            // wire v1에 v2 저장
            arr[wires[i][0]].add(wires[i][1]);
            // System.out.println("arr[" + wires[i][0] + "].add(" + wires[i][1] + ")");
            // wire v2에 v1 저장
            arr[wires[i][1]].add(wires[i][0]);
            // System.out.println("arr[" + wires[i][1] + "].add(" + wires[i][0] + ")");
        }
        // for(int i = 0; i < len; i++) {
        //     System.out.println("arr[" + wires[i][0] + "] = " + arr[wires[i][0]]);
        // }
        // v1와 v2 사이를 끊었을 때 각 전력망의 송전탑 개수 구하기
        for(int i = 0; i < len; i++) {
            // System.out.println("tmp1 = bfs(" + wires[i][0] + ", " + wires[i][1] + ", " + n + ")");
            // tmp1 : wire v1이 있는 전력망의 송전탑 개수
            int tmp1 = bfs(wires[i][0], wires[i][1], n);
            // System.out.println("--------------------------------");
            // System.out.println("tmp2 = bfs(" + wires[i][1] + ", " + wires[i][0] + ", " + n + ")");
            // tmp2 : wire v2가 있는 전력망의 송전탑 개수
            int tmp2 = bfs(wires[i][1], wires[i][0], n);
            // ans와 두 전력망의 송전탑 개수 차이 중 작은 값을 ans에 저장
            ans = Math.min(ans, Math.abs(tmp1 - tmp2));
            // System.out.println("now ans is " + ans);
            // System.out.println("================================");
        }
        // ans return
        return ans;
    }

    public static int bfs(int wire1, int wire2, int n) {
        // que : queue
        Queue<Integer> que = new LinkedList<>();
        // visit : 방문 여부 저장
        boolean[] visit = new boolean[n + 1];
        // cnt : 송전탑 개수 저장
        int cnt = 0;
        // wire 1 큐에 추가
        que.add(wire1);
        // System.out.println("que.add(" + wire1 + ")");
        // wire1 방문여부 true로 바꿔줌
        visit[wire1] = true;
        // System.out.println("visit[" + wire1 + "] = true");

        while(!que.isEmpty()) {
            // tmp : 큐에서 poll한 값
            int tmp = que.poll();
            // System.out.println("tmp is " + tmp);
            // cnt 증가
            cnt++;
            // System.out.println("cnt is now " + cnt);
            // tmp와 연결되어 있는 송전탑 하나씩 가져오기
            for(int i : arr[tmp]) {
                // System.out.println("now i is " + i);
                // 방문여부가 false이고, 연결되어 있는 송전탑이 wire2가 아닌 경우
                if(!visit[i] && i != wire2) {
                    // System.out.println("visit[" + i + "] = false & " + i + " != " + wire2);
                    // 방문여부 true로 바꿔줌
                    visit[i] = true;
                    // System.out.println("visit[" + i + "] = true");
                    // 큐에 추가
                    que.add(i);
                    // System.out.println("que.add(" + i + ")");
                }
            }
        }
        // cnt return
        return cnt;
    }
}
