package pracprac.bj.study.d0912;
//트리의 지름을 구하려면 dfs든 bfs든 두번 돌려서 구하면 효율적
//즉 ?fs 한번 돌려서 임의의 노드와 가장 먼 노드를 구하고
//그 노드에서 ?fs를 한번 더 돌려서 가장 먼 노드까지의 거리를 구한다
//왜냐면 트리는 구조성 모든 노드가 연결되어있고 한 노드에서 다른 노드로 가는 경로는 유일하기 때문
//그리고 가장 멀리 있는 노드간의 방문경로에는 항상 다른 노드간의 방문 경로가 겹침
//dfs https://moonsbeen.tistory.com/101
//bfs https://dundung.tistory.com/34

import java.util.ArrayList;
import java.util.Scanner;


public class bj1167 {
	
	static ArrayList<Node>[] tree;
	static boolean[] visited;
	static int max = 0;
	static int node;
	
	//노드를 저장해서 다시 dfs를 돌리기 위한 클래스
	static class Node{
		
		int edge; //간선
		int cost; //길이
		
		public Node(int edge, int cost) {			
			this.edge = edge;
			this.cost = cost;
		}
		
	}
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		tree = new ArrayList[n+1];
		
		for(int i=1; i<=n; i++) {
			tree[i] = new ArrayList<>();
		}
		
		//입력 주의. 노드 갯수 먼저 나오고 노드 하나가 나오고 
		//그 노드에 연결된 노드의 번호와 거리값이 계속해서 반복입력됨 -1 뜨기전까지
		//이걸 반복
		for(int i=0; i<n; i++) {
			int nodenum = sc.nextInt();
			
			while(true) {
				int edge = sc.nextInt();
				
				if(edge == -1) {
					break;
				}
				
				int cost = sc.nextInt();
				tree[nodenum].add(new Node(edge, cost));
			}
		}
		
		//임의의 노드에서 가장 거리가 먼 노드를 찾기
		visited = new boolean[n+1];
		DFS(1,0);
		
		//그렇게 찾은 노드값을 저장해서 그 노드를 기준으로 가장 먼 노드까지의 거리를 찾으면 그게 지름
		visited = new boolean[n+1];
		DFS(node, 0);
		
		System.out.println(max);
		
	}

	//깊이우선탐색
	private static void DFS(int x, int dst) {
		//측정한 거리가 max보다 크면 max를 갱신하고 찾은 노드번호를 저장
		if(dst>max) {
			max = dst;
			node = x;
		}
		
		visited[x] = true;
		
		//트리 전체를 돌면서 x 노드로부터 가장 거리가 긴 노드 찾기
		for(int i=0; i<tree[x].size(); i++) {
			Node n = tree[x].get(i);
			
			if(visited[n.edge] == false) {
				//가중치에 거리를 누적시켜준다(가중치의 누적합, 즉 노드간의 거리)
				DFS(n.edge, n.cost+dst);
				visited[n.edge] = true;
			}
		}
		
	}
	
	

}
