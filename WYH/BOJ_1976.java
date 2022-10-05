import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1976 {

	static int parents[];
	static int n, m;
	static int[][] city;
	static boolean[] visited;
	static int[] journey;
	static String answer = "YES";
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt(); // 총 도시의 수
		m = sc.nextInt(); // 여행 계획에 속한 도시의 수 
		
		
		parents = new int[n+1];
		visited = new boolean[n+1];
		journey = new int[m];
		city = new int[n+1][n+1];
		for( int i=1; i<=n; i++) {
			parents[i] = i; 
		}
		
		
		for( int i=1; i<=n; i++) {
			for( int j=1; j<=n; j++) {
				city[i][j] = sc.nextInt();
			}
		}
		
		for( int i=0; i<m; i++) {
			journey[i] = sc.nextInt();
		}
		
		// 이동 가능 도시
		for( int i=1; i<=n; i++) {
			// 본인 도시 == 도시 라면 city 만들기
			if( !visited[i]) {				
				makecity(i);
			}
			
		}
		
		// 같은 집합이면 Yes, 아니라면 NO
		for( int i=0; i<m; i++) {
			int Metro = parents [ journey[0] ];
			if ( Metro != parents [ journey[i] ]) {
				answer = "NO";
			}
		}
		
		System.out.println(answer);
				
	}
	private static void makecity(int start) {
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		
		while( !queue.isEmpty()) {
			int S = queue.poll();
			
			for( int target = 1; target <= n; target++) {
				// 갈 수 있는 곳이라면, 방문하지 않았다면
				if( city[S][target] == 1 && !visited[target]) {
					visited[target] = true;
					queue.add(target);
					
					union(S,target);
					
				}
				
			}
		}
	}

	
	private static void union(int x, int y) {
		int px = getParent(x);
		int py = getParent(y);
		
		if ( px == py ) return;
		else {

			 parents[py]= px;
		}
		
		
	}

	private static int getParent(int x) {
		if ( parents[x] == x ) return x;
		return parents[x] = getParent( parents[x] );
	}
	
}
