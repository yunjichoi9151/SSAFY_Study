package Silver_1.Java_files.Code;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Walking_with_Beer_9205 {
    // BFS 활용을 위한 큐 선언
    static Queue<int[]> queue;
    // 방문여부 boolean형으로 저장
    static boolean[] visit;
    // 편의점의 x좌표와 y좌표 담기
    static int[][] arr;
    static int n, x1, y1, x2, y2;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int tc = 1; tc <= t; tc++) {
            n = sc.nextInt();
            // 편의점 수만큼 배열 선언
            arr = new int[n][2];
            // x1 : 상근이네 집 x좌표
            // y1 : 상근이네 집 y좌표
            x1 = sc.nextInt();
            y1 = sc.nextInt();
            // 편의점 x좌표, y좌표 저장
            for(int i = 0; i < n; i++) {
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
            }
            // x2 : 락페스티벌 x좌표
            // y2 : 락페스티벌 y좌표
            x2 = sc.nextInt();
            y2 = sc.nextInt();
            // 상근이네 집과 락페스티벌 사이의 거리가 1000 이하라면 무조건 happy
            if(Math.abs(x2 - x1) + Math.abs(y2 - y1) <= 1000) {
                System.out.println("happy");
            }
            // 아닌 경우 BFS 판별 후, true면 happy, false면 sad 출력
            else {
                System.out.println(BFS() ? "happy" : "sad");
            }
        }
        sc.close();
    }
    // boolean형으로 결과값 출력
    public static boolean BFS() {
        // 큐 선언
        queue = new LinkedList<>();
        // visit 크기 n으로 선언
        visit = new boolean[n];
        // 먼저 상근이네 집 x좌표, y좌표 큐에 넣기
        queue.add(new int[] {x1, y1});
        while(!queue.isEmpty()) {
            // 큐 맨 앞에 있는 값을 tmp에 저장한 후 삭제
            int[] tmp = queue.poll();
            // tmp 좌표와 락페스티벌 좌표의 거리차가 1000 이하이면 true
            if(Math.abs(x2 - tmp[0]) + Math.abs(y2 - tmp[1]) <= 1000) {
                return true;
            }
            // 편의점 좌표와 비교 후 판별
            for(int i = 0; i < n; i++) {
                // 방문한 적이 없고, tmp 좌표와 편의점 좌표의 거리차가 1000 이하라면
                if(!visit[i] && (Math.abs(arr[i][0] - tmp[0]) + Math.abs(arr[i][1] - tmp[1]) <= 1000)) {
                    // 방문여부 true로 바꿔줌
                    visit[i] = true;
                    // 편의점 좌표를 큐에 넣어줌
                    queue.add(new int[] {arr[i][0], arr[i][1]});
                }
            }
        }
        // 앞에서 true로 return되지 않았다면, false return
        return false;
    }
}
