package Silver_3.Java_files.Code;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 트리의 부모 찾기 문제와 비슷하게 BFS 방식으로 풀어봤습니다
public class Virus_2606 {
    // tree 서로 연결되어있는지 여부를 boolean형으로 저장
    static boolean tree[][];
    // 방문 여부 boolean형으로 저장
    static boolean[] visit;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int cnt = 0;
        tree = new boolean[n + 1][n + 1];
        // 컴퓨터 상에서 직접 연결되어 있는 번호 쌍 입력받기
        for(int i = 0; i < m; i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            // 서로 연결되어 있는 것이기 때문에 양쪽 다 넣어주기
            tree[n1][n2] = true;
            tree[n2][n1] = true;
        }
        // 방문여부 저장
        visit = new boolean[n + 1];
        // BFS 방식 활용
        Queue<Integer> queue = new LinkedList<Integer>();
        // 웜 바이러스에 걸리는 컴퓨터는 1번으로 고정되어 있기 때문에, 1번부터 시작
        queue.add(1);
        // 1번 방문여부 true로 바꿔줌
        visit[1] = true;
        // 큐가 비워질 때까지 반복
        while(!queue.isEmpty()) {
            // 큐 맨 앞에 있는 값을 x에 저장한 후 삭제
            int x = queue.poll();
            for(int i = 1; i < tree.length; i++) {
                // 방문한 적이 없고, tree[x][i]가 true라면
                if(!visit[i] && tree[x][i]) {
                    // i번 방문여부 true로 바꿔줌
                    visit[i] = true;
                    // 큐에 i 추가
                    queue.add(i);
                    // count++
                    cnt++;
                }
            }
        }
        // 몇 개의 컴퓨터가 웜 바이러스에 감염되었는지 출력
        System.out.println(cnt);
    }
}
