package 이공이삼이월.d230224;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 인구이동_16234 {
	
	static int N, L, R;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 0, 0, 1};
	static int[] dc = {0, -1, 1, 0};
	static ArrayList<Node> pop;
	
	static class Node {
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();
		
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		System.out.println(move());
		
	}
	
	
	static int move() {
		int day = 0;
		
		while(true) {
			boolean isMoved = false;
			
			visited = new boolean[N][N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					
					if(!visited[i][j]) {
						int total = BFS(i, j);
						if(pop.size() > 1 ) {
							updatePop(total);
							isMoved = true;
						}
					}
					
				}
			}
			
			if(!isMoved) {
				return day;
			}
			day++;
		}
	}


	private static void updatePop(int total) {
		int avg = total / pop.size();
		
		for(Node n : pop) {
			map[n.x][n.y] = avg;
		}
	}


	private static int BFS(int x, int y) {
		
		Queue<Node> q = new LinkedList<>();
		pop = new ArrayList<>();
		
		q.offer(new Node(x,y));
		pop.add(new Node(x,y));
		visited[x][y] = true;
		
		int sum = map[x][y];
		
		while(!q.isEmpty()) {
			Node c = q.poll();
			
			for(int i=0; i<4; i++) {
				int nr = c.x + dr[i];
				int nc = c.y + dc[i];
				
				if(nr>=0 && nc>=0 && nr<N && nc<N && !visited[nr][nc]) {
					int df = Math.abs(map[c.x][c.y] - map[nr][nc]);
					if(L<= df && df<=R) {
						q.offer(new Node(nr, nc));
						pop.add(new Node(nr, nc));
						
						sum+= map[nr][nc];
						
						visited[nr][nc] = true;
					}
				}
			}
		}		
		
		return sum;
	}

}


