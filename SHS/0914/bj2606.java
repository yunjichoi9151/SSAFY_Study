package pracprac.bj.study.d0915;
//알고보니 bfs는 큐 사용이 정석이더라..
//큐에 시작 노드를 저장
//꺼낸 노드와 인접한 노드를 차례대로 방문하고 인접 노드가 없으면 노드를 꺼낸다
//방문한 노드를 넣는다
//빌때까지 반복
//https://gmlwjd9405.github.io/2018/08/15/algorithm-bfs.html

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj2606 {
	
	//문제에 주어진 그래프
	static int graph[][];
	//bfs 방문체크용 배열. 1일 경우 방문한것
	static int check[];
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int C = sc.nextInt();
		int P = sc.nextInt();
		
		//0번 인덱스 버리고 크기 맞춤
		graph = new int[C+1][C+1];
		check = new int[C+1];
		
		//연결된 쌍 입력
		for(int i=0; i<P; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			//연결쌍은 쌍방으로 연결되어있으므로 xy yx 같은값 대입
			graph[x][y] = 1;
			graph[y][x] = 1;
		}
		
		BFS(1);
				
	}

	//인접한 컴퓨터끼리 감염되므로 bfs 탐색
	//큐 사용
	private static void BFS(int start) {
		
		Queue<Integer> q = new LinkedList<>();
		
		//시작노드 삽입
		check[start] = 1;
		q.offer(start);
		
		int ans = 0;
		
		//큐가 빌때까지 탐색 반복
		while(!q.isEmpty()) {
			
			int a = q.poll();
			
			for(int i=1; i<graph.length; i++) {
				
				//큐에 저장된 값에 인접한 노드가 1이면 연결된 것, 그리고 방문되지 않은 경우 감염수 카운트
				if(graph[a][i]==1 && check[i]!=1) {
					//큐에 넣고 방문체크 후 반복
					q.offer(i);
					check[i] = 1;
					ans++;
				}				
			}			
		}
		
		System.out.println(ans);
		
	}
	
	

}
