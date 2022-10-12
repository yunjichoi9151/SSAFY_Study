package pracprac.bj.study.d1005;
//이상해요
//최소신장트리 크루스칼

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class bj1774 {
	
	static int[] parent;
	static SpaceGod[] sg;
	static ArrayList<SpaceGod> sglist = new ArrayList<>();
	static double ans = 0;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //우주신
		int M = sc.nextInt(); //통로
		
		parent = new int[N];
		sg = new SpaceGod[N];
		
		for(int i=0; i<N; i++) {
			parent[i] = i;
		}
		
		//연결할 황선자 포함 우주신 좌표 저장
		for(int i=0; i<N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			sg[i] = new SpaceGod(x, y, 0);
		}
		
		//이미 연결된 통로 저장
		for(int i=0; i<M; i++) {
			int sp1 = sc.nextInt();
			int sp2 = sc.nextInt();
			union(sp1-1, sp2-1);
		}
		
		//엣지 초기화 및 거리 계산
		for(int i=0; i< sg.length; i++) {
			SpaceGod spg1 = sg[i];
			
			for(int j= i+1; j<sg.length; j++) {
				SpaceGod spg2 = sg[j];
				double cost = Math.sqrt(Math.pow(spg1.x - spg2.x, 2)+Math.pow(spg1.y-spg2.y, 2));
				sglist.add(new SpaceGod(i,j,cost));
			}
		}
		
		//오름차순 정렬
		Collections.sort(sglist);
		
		//최소비용 도출
		for(int i=0; i<sglist.size(); i++) {
			SpaceGod spg = sglist.get(i);
			
			//최상위 부모 다르면 통로길이 추가하고 연결
			if(find(spg.x)!=find(spg.y)) {
				ans += spg.cost;
				union(spg.x, spg.y);
			}
		}
		
		//형식 주의
		System.out.println(String.format("%.2f", ans));
		
	}
	
	
	private static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x<y) {
			parent[y] = x;
		}else {
			parent[x] = y;
		}
		
	}

	private static int find(int x) {
		if(parent[x] == x) {
			return x;
		}else {
			return parent[x] = find(parent[x]);
		}
	}

}

class SpaceGod implements Comparable<SpaceGod>{
	
	int x, y;
	double cost;
	
	public SpaceGod(int x, int y, double cost) {
		this.x = x;
		this.y = y;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(SpaceGod spg) {
		if(cost > spg.cost) {
			return 1;
		}else {
			return -1;
		}
	}
	
}