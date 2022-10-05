package pracprac.bj.study.d1005;
//가중치 있는 bfs -> 다익스트라, 우선순위큐 사용
//연습하기에 좋은 문제인듯..
//우선순위 큐 특성상 최소 가중치합의 정점이 제일 먼저 나가기 때문에 방문처리를 할 필요가 없다
//이미 컨티뉴에서 걸러진단 얘기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//다익스트라 쓰기위한 노드비교기준
//클래스 노드 사용시 주의 : 같은 패키지 안에서 임포트에러
class Node implements Comparable<Node>{
	int v, c; //v:정점 c:시간소요코스트
	public Node(int v, int c) {
		super();
		this.v = v;
		this.c = c;
	}
	@Override
	public int compareTo(Node node) {
		return this.c-node.c;
	}
}

public class bj13549 {
	
	static int N, K;
	static int[] time = new int[100001]; //초기화 주의 : 메모리 제한 문제없음
	static PriorityQueue<Node> pq = new PriorityQueue<>();
	
	public static void main(String[] args) throws IOException { 
		//시간초과ㅜ
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		
		dykstra();
		
		System.out.println(time[K]);
		
	}

	private static void dykstra() {
		Arrays.fill(time,100001);
		
		//시작점 0으로
		time[N] = 0;
		
		//시작
		pq.add(new Node(N,0));
		
		while(!pq.isEmpty()) {
			Node curr = pq.remove();
			
			//경과된 시간보다 먼저 도착한 적이 있다면 넘기기 : 방문처리 생략
			if(time[curr.v] < curr.c) {
				continue;
			}
			
			//-1로 가는 경우
			int ns1 = curr.v - 1;
			if(ns1>=0  && ns1<100001 && time[ns1] > curr.c +1) {
				time[ns1] = curr.c +1;
				pq.add(new Node(ns1, time[ns1]));
			}
			
			//1로 가는경우
			int ns2 = curr.v + 1;
			if(ns2>=0  && ns2<100001 && time[ns2] > curr.c +1) {
				time[ns2] = curr.c +1;
				pq.add(new Node(ns2, time[ns2]));
			}
			
			//순간이동시 시간소요 안됨
			int ns3 = (curr.v)*2;
			if(ns3>=0  && ns3<100001 && time[ns3] > curr.c) {
				time[ns3] = curr.c;
				pq.add(new Node(ns3, time[ns3]));
			}
			
		}
		
	}
}

