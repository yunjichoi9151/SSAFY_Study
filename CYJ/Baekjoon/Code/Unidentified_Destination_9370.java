package Gold_2.Java_files.Code;

// 크루스칼 알고리즘 개념 : https://chanhuiseok.github.io/posts/algo-33/
// 크루스칼 알고리즘 예시 : https://m.blog.naver.com/ndb796/221230994142

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node implements Comparable<Node> {
    int e, weight;
    // 끝점, 거리
    public Node(int e, int weight) {
        this.e = e;
        this.weight = weight;
    }
    // 거리 비교
    @Override
    public int compareTo(Node e) {
        return weight - e.weight;
    }
}

public class Unidentified_Destination_9370 {
    static int n, m, t;
    static int[] dist;
    // 이렇게 INF를 지정해주지 않으면 오류 발생
    // Integer.MAX_VALUE도 안됨
    static int INF = 100000000;
    static List<List<Node>> list;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++) {
            // n : 교차로 개수
            // m : 도로 개수
            // t : 목적지 후보의 개수
            n = sc.nextInt();
            m = sc.nextInt();
            t = sc.nextInt();
            // 
            dist = new int[n + 1];
            // dist 배열 INF 값으로 초기화
            Arrays.fill(dist, INF);
            list = new ArrayList<>();
            // list 초기화
            for(int i = 0; i < n + 1; i++) {
                list.add(new ArrayList<>());
            }
            // s : 예술가들의 출발지
            // g, h : 이 둘의 교차로 사이에 있는 도로를 지나감
            int s = sc.nextInt(), g = sc.nextInt(), h = sc.nextInt();
            for(int i = 0; i < m; i++) {
                // a, b : 이 둘 사이에 도로 존재
                // d : 그 도로의 길이
                int a = sc.nextInt(), b = sc.nextInt(), d = sc.nextInt();
                // 입력받은 도로가 예술가들이 지금 지나가고 있는 도로라면
                if((a == g && b == h) || (a == h && b == g)) {
                    // 도로 길이 * 2 - 1로 홀수로 만들어줌
                    // list에 추가
                    list.get(a).add(new Node(b, d * 2 - 1));
                    System.out.println("case 1 : list.add(Node(" + b + ", " + (d * 2 - 1) + "))");
                    list.get(b).add(new Node(a, d * 2 - 1));
                    System.out.println("case 1 : list.add(Node(" + a + ", " + (d * 2 - 1) + "))");
                } else {
                    // 아니라면
                    // 도로 길이 * 2로 짝수로 만들어줌
                    // list에 추가
                    list.get(a).add(new Node(b, d * 2));
                    System.out.println("case 2 : list.add(Node(" + b + ", " + (d * 2) + "))");
                    list.get(b).add(new Node(a, d * 2));
                    System.out.println("case 2 : list.add(Node(" + a + ", " + (d * 2) + "))");
                }
            }
            // candidate : 목적지 후보 저장
            ArrayList<Integer> candidate = new ArrayList<>();
            // 목적지 후보 입력받기
            for(int i = 0; i < t; i++) {
                candidate.add(sc.nextInt());
            }
            // 다익스트라
            dijkstra(s);
            Collections.sort(candidate);
            for(int i = 0; i < dist.length; i++) {
                System.out.println("dist[" + i + "] = " + dist[i]);
            }
            for(int i = 0; i < candidate.size(); i++) {
                // 홀수라면, 즉 예술가들의 목적지 후보 중 가능한 후보라면
                if(dist[candidate.get(i)] % 2 == 1) {
                    System.out.print(candidate.get(i) + " ");
                }
            }
            System.out.println();
        }
        sc.close();
    }

    public static void dijkstra(int s) {
        // visit : 방문 여부 저장
        boolean[] visit = new boolean[n + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        // start 지점의 dist 값 0으로 지정
        dist[s] = 0;
        // start 지점 Node 추가
        pq.add(new Node(s, 0));
        while(!pq.isEmpty()) {
            Node tmp = pq.poll();
            if(!visit[tmp.e]) {
                // 방문여부 true로 바꿔줌
                System.out.println("visit[" + tmp.e + "] = true");
                visit[tmp.e] = true;
                // list에서 다른 점들과 비교
                for(Node node : list.get(tmp.e)) {
                    // 방문한 적이 없고, dist + weight이 현재보다 작다면
                    System.out.println("Now Node(" + node.e + ", " + node.weight + ")");
                    if(!visit[node.e] && dist[tmp.e] + node.weight < dist[node.e]) {
                        // 갱신
                        dist[node.e] = dist[tmp.e] + node.weight;
                        System.out.println("dist[" + node.e + "] = dist[" + tmp.e + "] + " + node.weight + " = " + dist[node.e]);
                        // 큐에 추가
                        pq.add(new Node(node.e, dist[node.e]));
                    }
                }
            }
        }
    }
}
