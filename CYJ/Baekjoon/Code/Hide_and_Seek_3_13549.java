package Gold_5.Java_files.Code;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Hide_and_Seek_3_13549 {
    static int[] time = new int[100001];
    // 이동할 위치 : [0] 부분은 곱해줄 값, [1] 부분은 더해줄 값
    static int[][] dx = {{2, 0}, {1, -1}, {1, 1}};
    // 방문 여부
    static boolean visit[] = new boolean[100001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // n : 수빈이가 있는 위치
        // k : 동생이 있는 위치
        int n = sc.nextInt(), k = sc.nextInt();
        // 수빈이가 0 또는 -로만 이동해야 한다면 x - 1로 가는 방법 밖에 없음
        if(k <= n) {
            System.out.println(n - k);
        } else {
            // 아니라면 bfs
            bfs(n, k);
            System.out.println(time[k]);
        }
        sc.close();
    }

    public static void bfs(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        // 시작 지점(수빈이가 있는 위치)
        queue.offer(start);
        time[start] = 0;
        while(!queue.isEmpty()) {
            int tmp = queue.poll();
            // 이동할 수 있는 위치 하나씩 계산
            for(int i = 0; i < 3; i++) {
                // 이동위치 계산
                int x = dx[i][0] * tmp + dx[i][1] * 1;
                if(x >= 0 && x <= 100000 && !visit[x]) {
                    // time 갱신(순간이동은 고려 X)
                    time[x] = time[tmp] + Math.abs(dx[i][1]);
                    queue.add(x);
                    // 방문여부 true로 바꿔줌
                    visit[x] = true;
                }
            }
        }
    }
}
