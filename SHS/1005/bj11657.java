package pracprac.bj.study.d1005;
//https://dragon-h.tistory.com/25
//https://m.blog.naver.com/kks227/220796963742
//음의 가중치를 써야 하니까 벨만포드 알고리즘을 써야함
//간선 거리 갱신시 갱신된다면 음의 사이클이 존재한다는 것이고
//inf값이면 그 경로는 없다는 뜻이다


import java.util.Arrays;
import java.util.Scanner;

public class bj11657 {
	
	static int N;
	static int M;
	static int[][] map;
	static long[] dist; // 왜  long ? : 이렇게 안하면 출력초과뜸(underflow)
	//https://zangzangs.tistory.com/82

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[M][3];
		//시작지점에서 i번째 위치로 가는 최단거리
		dist = new long[N+1];
		
		//초기화는 이렇게
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[1] = 0;

		for(int i=0; i<M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int cost = sc.nextInt();
			
			map[i][0] = from;
			map[i][1] = to;
			map[i][2] = cost;
			
			//시작위치에서 갈 수 있는 최단경로 초기값 설정
			if(from==1) {
				if(dist[to] > cost) {
					dist[to] = cost;
				}
			}
		}
		
		boolean BelFor = false;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				
				int from = map[j][0];
				int to = map[j][1];
				int cost = map[j][2];
				
					
					//시작지점에서 from 거쳐서 to로 가는 비용
					long fromto = dist[from] + cost;
					
					// inf가 아니라면 경로가 있다는 이야기
					//fromto가 목적지의 최단경로보다 작을 경우 갱신
					if(dist[from] != Integer.MAX_VALUE && dist[to] > fromto) {
						dist[to] = fromto;
						
						//이 상태로 순회를 마쳤을 때 음의 사이클 존재
						if(i == N-1) {
							BelFor = true;
						}
					}
					
				
			}
		}
		
		//음의 사이클이 존재하는 경우
		if(BelFor) {
			System.out.println(-1);
		}
		else { //경로가 없을 경우 -1, 있을 경우 가장 빠른 시간
			for(int i=2; i<=N; i++) {
				if(dist[i]!=Integer.MAX_VALUE) {
					System.out.println(dist[i]);
				}else {
					System.out.println(-1);
				}
			}
		}
		
		
	}
}

