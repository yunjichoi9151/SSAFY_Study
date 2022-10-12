package pracprac.bj.study.d1005;
//유니온파인드

import java.util.Scanner;

public class bj1976 {
	
	static int[] parent;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		parent = new int[N+1]; //부모 저장 배열
		
		for(int i=1; i<N+1; i++) {
			parent[i] = i;
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				int visit = sc.nextInt();
				//연결된 도시는 전부 유니온
				if(visit == 1) {
					union(i, j);
				}
			}
		}
		
		int plan = sc.nextInt();
		
		for(int i=0; i<M-1; i++) {
			int next = sc.nextInt();
			//연결정보상 연결된 녀석들은 위에서 돌면서 최상위 부모가 같아진 상태
			//즉 최상위부모 노드가 다를 경우 계획대로 여행 불가능
			if(find(plan)!=find(next)) {
				System.out.println("NO"); //그냥 복붙하자
				return;
			}
		}
		System.out.println("YES ");
		
		
	}
	
	//최상위 부모 찾기
	private static int find(int x) {
		if(parent[x] == x) {
			return x;
		}else {
			return parent[x] = find(parent[x]);
		}
	}
	
	//도시 연결
	private static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		//최상위 부모가 다를 경우 합체해서 최상위 부모 갱신
		if(x<y) {
			parent[y] = x;
		}else {
			parent[x] = y;
		}
	}
	

}
