import java.util.*;

public class BOJ_9370 {
	    public static final int INF = (int) 1e9; // 무한을 의미하는 값으로 10억을 설정
	    public static int T, n, m, t, s, g, h;
	   
	    public static ArrayList<ArrayList<Node>> graph;
	    
	    public static int[] d;

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        T = sc.nextInt();
	        for (int j = 0; j < T; j++){
	            n = sc.nextInt();
	            m = sc.nextInt();
	            t = sc.nextInt();
	            graph = new ArrayList<>();

	            s = sc.nextInt();
	            g = sc.nextInt();
	            h = sc.nextInt();

	           
	            for (int i = 0; i <= n; i++) {
	                graph.add(new ArrayList<>());
	            }

	          
	            for (int i = 0; i < m; i++) {
	                int a = sc.nextInt();
	                int b = sc.nextInt();
	                int d = sc.nextInt();
	                
	                graph.get(a).add(new Node(b, d));
	                graph.get(b).add(new Node(a, d));
	            }

	            PriorityQueue<Integer> pq = new PriorityQueue<>();

	            int[] des = new int[t];
	            for (int i = 0; i < t; i++){
	                des[i] = sc.nextInt();
	            }

	            for (int d : des) {
	                long res1 = dijkstra(s, g) + dijkstra(g, h) + dijkstra(h, d);
	                long res2 = dijkstra(s, h) + dijkstra(h, g) + dijkstra(g, d);
	                long res3 = dijkstra(s, d);

	                if (Math.min(res1, res2) == res3) {
	                    pq.add(d);
	                }
	;            }

	            while (!pq.isEmpty()) {
	                System.out.print(pq.poll() + " ");
	            }
	            System.out.println();
	        }
	    }
	    public static int dijkstra(int start, int end) {
	        d = new int[n + 1];
	        Arrays.fill(d, INF);
	        PriorityQueue<Node> pq = new PriorityQueue<>();
	        // 시작 노드로 가기 위한 최단 경로는 0
	        pq.add(new Node(start, 0));
	        d[start] = 0;
	        while(!pq.isEmpty()) { // 큐가 비어있지 않다면
	            // 가장 최단 거리가 짧은 노드
	            Node node = pq.poll();
	            int now = node.index; 
	            int dist = node.distance; 

	            // 현재 노드가 이미 처리된 적이 있는 노드라면 무시
	            if (d[now] < dist) continue;
	            // 현재 노드와 연결된 다른 인접한 노드들을 확인
	            for (int i = 0; i < graph.get(now).size(); i++) {
	                int cost = d[now] + graph.get(now).get(i).distance;
	                // 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우
	                if (cost < d[graph.get(now).get(i).index]) {
	                    d[graph.get(now).get(i).index] = cost;
	                    pq.offer(new Node(graph.get(now).get(i).index, cost));
	                }
	            }
	        }
	        return d[end];
	    }
	}
}