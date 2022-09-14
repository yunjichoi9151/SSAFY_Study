package pracprac.bj.study.d0915;
//사방탐색+bfs/dfs. 둘중 어느걸 써도 될거같음
//일단 여기선 dfs를 사용
//입출력 주의

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class bj2667 {
	//사방탐색
	static int dr[] = {0,0,1,-1};
	static int dc[] = {1,-1,0,0};
	static int N;
	//단지 해당하는 세대 숫자
	static int danzicnt;
	//방문 체크
	static boolean[][] visited;
	static int[][]map;
	//리스트에 단지 수 누적 및 길이에 단지 수를 저장
	static ArrayList<Integer> danzi;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		map = new int[N][N];
		visited = new boolean[N][N];
		
		//띄어쓰기 구분 안되어있으므로 입력 string으로 받아서 쪼개기
		for(int i=0; i<N; i++) {
			String s = sc.next();			
			for(int j=0; j<N; j++) {
				map[i][j] = s.charAt(j)-'0';
			}
		}
		
		//초기화
		danzicnt = 0;
		danzi = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				
				if(map[i][j]==1 && !visited[i][j]) {
					//처음 카운트 1 증가
					danzicnt=1;
					DFS(i,j);
					//탐색한 단지세대 수를 단지리스트에 저장
					danzi.add(danzicnt);
					
				}			
			}
		}
		
		//오름차순 정렬
		Collections.sort(danzi);
		//총 단지수 = 리스트의 길이
		System.out.println(danzi.size());
		//각 단지 내 집의 수
		for(int i=0; i<danzi.size(); i++) {
			System.out.println(danzi.get(i));
		}
		
	}

	//DFS
	//기준점에서 4방탐색하면서 1인지 여부와 방문여부 체크해서 단지내 세대수 증가 반복
	private static int DFS(int x, int y) {
		visited[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int nr = x + dr[i];
			int nc = y + dc[i];
			
			if(nr>=0 && nc>=0 && nr<N && nc<N) {
				if(map[nr][nc]==1 && !visited[nr][nc]) {
					DFS(nr, nc);
					danzicnt++;
				}
			}
		}
		
		return danzicnt;
	}

}



