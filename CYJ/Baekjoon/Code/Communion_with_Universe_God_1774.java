package Gold_3.Java_files.Code;

// 크루스칼 알고리즘 개념 : https://chanhuiseok.github.io/posts/algo-33/
// 크루스칼 알고리즘 예시 : https://m.blog.naver.com/ndb796/221230994142

import java.util.PriorityQueue;
import java.util.Scanner;

class Edge implements Comparable<Edge> {
    int s, e;
    double weight;
    // 시작점, 끝점, 거리
    public Edge(int s, int e, double weight) {
        this.s = s;
        this.e = e;
        this.weight = weight;
    }
    // 거리 비교
    @Override
    public int compareTo(Edge e) {
        return Double.compare(this.weight, e.weight);
    }
}

public class Communion_with_Universe_God_1774 {
    static int[] parent;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // n : 우주신들의 개수
        // m : 이미 연결된 신들과의 통로의 개수
        int n = sc.nextInt(), m = sc.nextInt();
        // god : 우주신들의 좌표 저장
        int[][] god = new int[n + 1][2];
        // parent : 부모 저장
        parent = new int[n + 1];
        // 우주신들의 좌표 입력받음
        for(int i = 1; i <= n; i++) {
            god[i][0] = sc.nextInt();
            god[i][1] = sc.nextInt();
        }
        // 부모를 자기 자신으로 초기화
        for(int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        // x, y값 union으로 저장
        for(int i = 0; i < m; i++) {
            int s = sc.nextInt(), e = sc.nextInt();
            union(s, e);
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for(int i = 1; i < n; i++) {
            for(int j = i + 1; j < n + 1; j++) {
                int x1 = god[i][0], y1 = god[i][1], x2 = god[j][0], y2 = god[j][1];
                // 두 점 사이의 거리 구하기
                double weight = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
                // System.out.println("Edge(" + i + ", " + j + ", " + weight + ")");
                // pq에 저장
                pq.add(new Edge(i, j, weight));
            }
        }
        // 결과값 0으로 초기화
        double res = 0;
        while(!pq.isEmpty()) {
            Edge edge = pq.poll();
            // 통로의 시작점과 끝점의 그룹 합침(최상위 노드가 다를 경우)
            if(union(edge.s, edge.e)) {
                // true이면 결과값에 해당 edge 거리 더하기
                res += edge.weight;
                // System.out.println("res = " + res);
            }
        }
        // 소수점 둘째짜리까지 출력
        System.out.println(String.format("%.2f", res));
        sc.close();
    }
    // x가 속하는 부모 노드(최상위 노드) 찾기
    public static int find(int x) {
        if(parent[x] == x) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }
    }
    // 두 개의 노드가 속한 집합 연결
    public static boolean union(int x, int y) {
        // 통로의 시작점, 끝점의 최상위 노드 찾기
        x = find(x);
        y = find(y);
        // 최상위 노드가 같지 않을 경우 union
        if(x != y) {
            // System.out.println("parent[" + y + "] = " + x);
            parent[y] = x;
            return true;
        }
        return false;
    }
}
