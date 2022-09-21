package pracprac.bj.study.d0918;
//맥주 개수는 중요하지 않음. 맥주 1개당 50미터. 박스당 1000미터 이동
//다음 장소(편의점, 락페스티벌 좌표)까지 1000미터 이내면 연결
//연결후 bfs반복. 방문하지 않은 곳은 큐에 넣고 꺼냈을때 페스티벌 좌표의 인덱스면 happy
//큐가 비었을때까지 도착 못하면 sad

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;



public class bj9205 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for(int tc=1; tc<=t; tc++) {
			
			int n = sc.nextInt();
			int[][] loc = new int[2][n+2];
			int[][] graph = new int[n+2][n+2];
			
			//x,y좌표 저장
			for(int i=0; i<n+2; i++) {
				loc[0][i] = sc.nextInt();
				loc[1][i] = sc.nextInt();				
			}
			
			int dist;
			
			for(int i=0; i<n+2; i++) {
				for(int j=0; j<n+2; j++) {
					dist = 0;
					//거리 계산
					dist += Math.abs(loc[0][i]-loc[0][j]);
					dist += Math.abs(loc[1][i]-loc[1][j]);
					
					//1000이하일때 입력
					if(dist <=1000) {
						graph[i][j] = graph[j][i] = 1;
					}
				}
			}
			
			//bfs
			
			boolean[] visited = new boolean[n+2];
			visited[0] = true;
			
			Queue<Integer> q = new LinkedList();
			q.add(0);
			
			while(!q.isEmpty()) {
				int check = q.poll();
				for(int i=0; i<n+2; i++) {
					//1000미터 이내일때 q에 넣기
					if(graph[check][i] == 1) {
						if(!visited[i]) {
							visited[i] = true;
							q.add(i);
						}
					}
				}
			}
			
			//끝좌표(n+1)까지 방문했으면 happy
			if(visited[n+1]) {
				System.out.println("happy");
			}else {
				System.out.println("sad");
			}
			
		}
		
	}
	
	
	
	
}
