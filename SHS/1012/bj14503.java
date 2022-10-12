package pracprac.bj.study.d1012;
//문제 규칙이 조금 복잡하지만 완탐
//d 0 1 2 3  북 동 남 서
//탐색규칙 1~3번에 의하면 현재위치 현재 방향에서 시작해서 좌회전 반복
//북쪽에서 좌측이면 서쪽. 0>3>2>1 : -1씩
//왔던길 다시 가는 경우 있으니 주의

import java.util.Scanner;

public class bj14503 {
	
	static int N,M,r,c,d;
	static int[][] map;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int cnt = 1;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		r = sc.nextInt();
		c = sc.nextInt();
		d = sc.nextInt();
		

		map = new int[N][M];
				
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		DFS(r,c,d);
		System.out.println(cnt);
		
	}

	private static void DFS(int x, int y, int di) {
		
		map[x][y] = 2; // visited 대신 2를 청소한 경우로 표기
		
		for(int i=0; i<4; i++) {
			
			di -= 1; // 왼쪽으로
			
			if(di == -1) {
				di = 3; //-1일 경우 서쪽
			}
			
			int nr = x + dr[di];
			int nc = y + dc[di];
			
			//사방탐색
			if(nr>=0 && nc>=0 && nr<N && nc<M) {
				
				if(map[nr][nc] == 0) {
					cnt++;
					
					DFS(nr, nc, di);
					return; // 왔던길로 돌아가는 경우가 있으므로 리턴 필요
				}
				
			}
			
		}
		
		//주변에 더 청소할 곳이 없을 경우
		int di2 = (di+2)%4; //반대방향으로 후진. 0->2 1->3 2->0 3->1
		int br = x + dr[di2]; 
		int bc = y + dc[di2];
		
		if(br>=0 && bc>=0 && br<N && bc<M && map[br][bc]!=1) {
			DFS(br, bc, di); //후진했어도 바라보는 방향은 유지하므로 기존의 방향으로 탐색
		}
				
	}
}
