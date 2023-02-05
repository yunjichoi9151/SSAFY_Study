package d230203;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 행성터널_2887 {
	static int N;
	static PriorityQueue<Edge> pq = new PriorityQueue<>();
	
	static class Planet{
		int num;
		int x;
		int y;
		int z;
		
		public Planet(int num, int x, int y, int z) {
			this.num = num;
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	
	static class Edge implements Comparable<Edge> {
		int start;
		int end;
		int weight;
		
		public Edge(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	static int[] pNode;
	
	static void make() {
		pNode = new int[N];
		for(int i=0; i<N; i++) {
			pNode[i] = i;
		}
	}
	
	static int find(int a) {
		if(pNode[a] == a) return a;
		return pNode[a] = find(pNode[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot==bRoot) return false;
		
		pNode[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		Planet[] planet = new Planet[N];
		
		for(int i=0; i<N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int z = sc.nextInt();
			planet[i] = new Planet(i,x,y,z);
		}
		
		Arrays.sort(planet, (p1, p2) -> Integer.compare(p1.x, p2.x));
		for(int i=1; i<N; i++) {
			int weight = planet[i].x - planet[i-1].x;
			pq.offer(new Edge(planet[i].num,planet[i-1].num, weight));
		}
		
		Arrays.sort(planet, (p1, p2) -> Integer.compare(p1.y, p2.y));
		for(int i=1; i<N; i++) {
			int weight = planet[i].y - planet[i-1].y;
			pq.offer(new Edge(planet[i].num,planet[i-1].num, weight));
		}
		
		Arrays.sort(planet, (p1, p2) -> Integer.compare(p1.z, p2.z));
		for(int i=1; i<N; i++) {
			int weight = planet[i].z - planet[i-1].z;
			pq.offer(new Edge(planet[i].num,planet[i-1].num, weight));
		}
		
		make();
		
		int cnt=0, result = 0;
		
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			if(union(edge.start, edge.end)) {
				result += edge.weight;
				if(++cnt==N-1) break;
			}
		}
		
		System.out.println(result);
		
	}
}
