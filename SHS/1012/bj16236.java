package pracprac.bj.study.d1012;
//https://zoosso.tistory.com/219
//https://girawhale.tistory.com/39
//조건이 엄청 많아서 우선순위큐 쓴 bfs 필요
//comparator 불러서 규칙을 지정하고 이동거리를 누적

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class bj16236 {
	
	static int N;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int [][] map;
	static boolean[][] visited;
	
	static int ans = 0;
	static Fish baby;
	static PriorityQueue<Fish> pq;
	static Queue<Vertex> q;
	
	
	static class Fish implements Comparable<Fish>{
		int x, y, size, exp;
		
		public Fish(int x, int y, int size) {
			this.x = x;
			this.y = y;
			this.size = size;
			exp = 0;
		}
		
		@Override
		public int compareTo(Fish food) {//먹을 수 있는 물고기가 많을때
			if(this.x < food.x) { //가장 위쪽 우선
				return -1;
			}else if(this.x > food.x) {
				return 1;
			}else { // 동일한 높이=x좌표일 때 왼쪽 우선
				if(this.y < food.y) {
					return -1;
				}
				return 1;
			}
		}
		
		
		public void eatFish(Fish shark) {
			//상어의 이동좌표
			this.x = shark.x;
			this.y = shark.y;
			
			map[shark.x][shark.y] = 0;
			
			if(++this.exp == this.size) { //크기 키우고 경험치 초기화
				this.size++;
				this.exp = 0;
			}
		}
	
	}
	
	static class Vertex {
		int x, y, dist; // 상어가 있는 곳에서부터의 거리
		
		public Vertex(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new int[N][N];
		visited = new boolean[N][N];
		
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
				
				//상어인 경우 상어 입력, map에서는 지워주기(자기자신을 먹는것 방지)
				if(map[i][j] == 9) {
					baby = new Fish(i, j, 2);
					map[i][j] = 0;
				}
			}
		}
		
		BFS();
		
		System.out.println(ans);
		
	}


	private static void BFS() {
		visited = new boolean[N][N];
		q = new LinkedList<>();
		pq = new PriorityQueue<>();
		
		//최소거리 저장
		int min = Integer.MAX_VALUE;
		
		//현재 위치에서부터 시작
		q.add(new Vertex(baby.x, baby.y, 0));
		
		while(!q.isEmpty()) {
			Vertex v = q.poll();
			
			for(int i=0; i<4; i++) {
				int nr = v.x + dr[i];
				int nc = v.y + dc[i];
				
				//맵 안에서, 방문했던 곳, 자신보다 더 큰 물고기, 거리가 더 먼 물고기 skip
				if(nr<0 || nc<0 || nr>=N || nc>=N || visited[nr][nc] ||
						map[nr][nc] > baby.size || min < v.dist+1) {
					continue;
				}
				
				//더 작은 물고기 발견시
				if(map[nr][nc]>0 && map[nr][nc] < baby.size) {
					//최소거리 재설정 및 물고기 먹기
					min = v.dist + 1;
					pq.add(new Fish(nr, nc, map[nr][nc]));
					//통과해서 새로 최소거리의 먹이 찾기
					continue;
				}
				//방문 표시
				visited[nr][nc] = true;
				
				//bfs 반복
				q.add(new Vertex(nr, nc, v.dist + 1));
				
			}
		}
		
		//BFS 끝나고 잡을 수 있는 물고기가 있을 때
		if(!pq.isEmpty()) { //pq가 빌때까지
			baby.eatFish(pq.poll()); //우선순위 높은 물고기 먹고
			ans += min; // 먹은 곳까지의 최소거리 누적
			
			BFS();
		}
		
	}


}

