package pracprac.bj.study.d1005;
//다익스트라 최소신장 트리이나, 의심지점 : 좌표를 꼭 방문해야한다는 점
//처리를 위해 포함여부를 따로 돌리게 되면 다익스트라를 여러번 호출하게 되어서 비효율적
//가중치 저장할때 방문해야하는 지점의 간선을 홀수로 두고, 나머지는 짝수로 두면 검증이 편리해짐
//https://dragon-h.tistory.com/22
//https://pangtrue.tistory.com/255

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;




public class bj9370 {

    private static final int INF = 100000000;
    //integer.maxint를 쓰면 틀림(50~쯤에서 터짐) 
    //생각해보니 홀짝으로 구분하는데 이걸 줘버리면... 홀짝 변경이 안되니까 그래서 터진걸까?
    
    private static int T;
    private static int V, E, t;
    private static List<List<Node>> list;
    private static int dist[];
    private static List<Integer> candidate;
 
    static class Node implements Comparable<Node> {
 
        int v, weight;
 
        public Node(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }
 
        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }
 
    public static void main(String[] args)  {
    	
    	Scanner sc = new Scanner(System.in);
    	
        T = sc.nextInt();
 
        for (int i = 0; i < T; i++) {
        	
            V = sc.nextInt();
            E = sc.nextInt();
            t = sc.nextInt();
 
            dist = new int[V + 1];
            Arrays.fill(dist, INF);
 
            list = new ArrayList<>();
            for (int j = 0; j < V + 1; j++)
                list.add(new ArrayList<>());
 
            int start = sc.nextInt();
            int g = sc.nextInt();
            int h = sc.nextInt();
 
            for (int j = 0; j < E; j++) {

                int u = sc.nextInt();
                int v = sc.nextInt();
                int weight = sc.nextInt();
                
                //그래프 연결 및 가중치 저장해주기
                if ((u == g && v == h) || (u == h && v == g)) {
                    list.get(u).add(new Node(v, weight * 2 - 1));
                    list.get(v).add(new Node(u, weight * 2 - 1));
                } else {
                    list.get(u).add(new Node(v, weight * 2));
                    list.get(v).add(new Node(u, weight * 2));
                }
            }
            
            //후보리스트
            candidate = new ArrayList<>();
            for (int j = 0; j < t; j++)
                candidate.add(sc.nextInt());
            
            //다익스트라
            dijkstra(start);
 
            Collections.sort(candidate);
            
            //홀수일 경우 답안
            for (int num : candidate) {
                if (dist[num] % 2 == 1) System.out.print(num+" ");
            }
            System.out.println();
        }
    }
 
    private static void dijkstra(int u) {
        boolean[] visited = new boolean[V + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
 
        dist[u] = 0;
        pq.add(new Node(u, 0));
 
        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();
            
            if (visited[currentNode.v]) continue;
            visited[currentNode.v] = true;
            
            //방문한적이 없고, 현재 방문하는 곳이 더 작을 경우 갱신
            for (Node node : list.get(currentNode.v)) {
                if (!visited[node.v] && dist[node.v] > dist[currentNode.v] + node.weight) {
                    dist[node.v] = dist[currentNode.v] + node.weight;
                    pq.add(new Node(node.v, dist[node.v]));
                }
            }
        }
    }
}
