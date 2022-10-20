package Gold_4.Java_files.Code;

import java.util.Scanner;

public class Go_Trip_1976 {
    static int n, m;
    static int[][] conn;
    static boolean[] visit;
    static int[] plan;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // n : 도시의 수
        n = sc.nextInt();
        // m : 여행 계획에 속한 도시들의 수
        m = sc.nextInt();
        // res 초기값 true
        boolean res = true;
        // conn : 도시의 연결 정보(도시의 번호는 1부터 시작)
        conn = new int[n + 1][n + 1];
        // visit : 방문 여부 저장
        visit = new boolean[n + 1];
        // plan : 여행 계획
        plan = new int[m];
        // 연결 정보 저장
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                conn[i][j] = sc.nextInt();
            }
        }
        // 여행 계획
        for(int i = 0; i < m; i++) {
            plan[i] = sc.nextInt();
        }
        // dfs
        dfs(plan[0]);
        // 탐색
        for(int i = 0; i < m; i++) {
            // 여행 계획에 속한 도시 중 방문여부가 false인 곳이 있다면
            if(!visit[plan[i]]) {
                // 결과는 false
                res = false;
                break;
            }
        }
        // 결과가 true면 yes
        System.out.println(res ? "YES" : "NO");
        sc.close();
    }

    public static void dfs(int num) {
        // 방문여부 true로 바꿔줌
        visit[num] = true;
        for(int i = 1; i <= n; i++) {
            System.out.println("now is " + num + " and " + i);
            // num의 도시와 i의 도시가 연결되어있고, 방문하지 않았었다면
            if(conn[num][i] == 1 && !visit[i]) {
                System.out.println("connection is " + num + " and " + i);
                dfs(i);
            }
        }
    }
}
