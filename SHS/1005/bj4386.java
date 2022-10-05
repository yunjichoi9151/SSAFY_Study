package pracprac.bj.study.d1005;
//간선수가 많은거같아서 프림으로 풀어봄
//거리 계산 어떻게 하는지 모르겠음... 그래서 참고했음...

import java.util.PriorityQueue;
import java.util.Scanner;

public class bj4386 {
	
	static int n;
	static double[][] stars;
	static double[][] map;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		//x,y좌표만 있는 별들 위치
		stars = new double[n][2];
		//전체 맵
		map = new double[n][n];
		
		for(int i=0; i<n; i++) {
			stars[i][0] = sc.nextDouble();
			stars[i][1] = sc.nextDouble();
			
			//거리계산 왜 이렇게 하나요?
			for(int j=0; j<i; j++) {
				double dist = Math.sqrt(Math.pow(stars[j][0]-stars[i][0], 2)
						+Math.pow(stars[j][1]-stars[i][1], 2));
				
				//무방향
				map[i][j]=map[j][i]=dist;
						
			}
			
		}
		
		double ans = prim(0);
		System.out.printf("%.2f", ans); //출력형식
		
		
	}

	
	private static double prim(int star) {
		
		PriorityQueue<StarCost> pq = new PriorityQueue<>();
		
		//연결은 두개씩 : 시작점 1에서부터 돈다고 생각
		for(int i=1; i<n; i++) {
			pq.add(new StarCost(i, map[0][i]));
		}
		
		//1부터 시작
		int StarEdgeCnt = 1;
		double distsum = 0;
		boolean[] visited = new boolean[n];
		visited[0] = true;
		
		while(!pq.isEmpty()) {
			StarCost curr = pq.poll();
			
			//방문 안했으면 cnt++ 거리합누적 방문처리
			if(visited[curr.starnum] == false) {
				StarEdgeCnt++;
				distsum += curr.dist;
				visited[curr.starnum] = true;
				
				//여기서 쫓아내는 이유 : 간선 갯수가 n-1이 되므로 더이상 찾을 필요 없음
				//1에서 시작했으니까 n
				if(StarEdgeCnt == n) {
					break;
				}
				
				//간선 갯수 충족 안된 경우 트리 구성 완료 안됨
				//우선순위큐에 새로운 별 객체를 추가
				for(int i=0; i<n; i++) {
					if(visited[i] == false) {
						pq.add(new StarCost(i, map[curr.starnum][i]));
					}
				}
				
			}
			
		}
		
		
		return distsum;
		
		
	}

}

//비교기준
class StarCost implements Comparable<StarCost>{
	int starnum; //정점 -> 별 넘버
	double dist; //코스트 -> 거리
	
	public StarCost(int starnum, double dist) {
		this.starnum = starnum;
		this.dist = dist;
	}
	
	@Override
	public int compareTo(StarCost sc) {
		
		return Double.compare(dist, sc.dist); //-1, 0, 1
		//dist < sc.dist : -1
		//	   = 		 : 0
		//	   >		 : 1
	}
	
	
}

