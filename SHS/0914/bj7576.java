package pracprac.bj.study.d0915;
//최소값 최단거리 구할때는 bfs라더라
//https://brightmango.tistory.com/323#3.%20%F0%9F%97%9D%C2%A0%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4
//bfs 없이 단순 큐만으로도 풀수 있더라 
//https://girawhale.tistory.com/12

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj7576 {
	
	static int M;
	static int N;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};	
	static int[][] box, check;
    static Queue<tomato> q = new LinkedList<>();
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		
		//가로세로 이거때문에 한참 헤멤....
		box = new int[N][M];
		//토마토 익는데 걸린 일수를 저장하기 위한 배열
		check = new int[N][M];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				box[i][j] = sc.nextInt();
				
				//익은 토마토는 큐에 넣는다
				if (box[i][j] == 1) {
                    q.add(new tomato(i,j));
                }
			}
		}
		
        BFS();
        
        //출력시 주의
    
        //다 돌고도 안익은 토마토가 남으면 -1 출력
        int ans = -1;
        if(checkTomato()) {
        	//아닌 경우 check배열 저장값중 가장 큰 값이 모든 토마토가 익는데 걸린 날짜
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    ans = Math.max(ans, check[i][j]);
                }
            }
            System.out.println(ans);
        }
        else System.out.println(ans);
        

    }

	//다 돌고도 안익은 토마토가 있으면 -1 출력
	private static boolean checkTomato() {
		for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(box[i][j] == 0) {
                	return false;
                }
            }
        }
        return true;
	}


	//BFS
	//큐에 들어있는 익은 토마토부터 꺼내면서 주변 사방 익히고
	//익힌 토마토는 또 큐에 넣고 반복
	//토마토 익힐때마다 해당 check배열에 일수 +1씩 해주기
	private static void BFS() {
       
		while(!q.isEmpty()) {
            tomato t = q.poll();
            //사방탐색 하면서 토마토 익히기
            for(int i = 0; i < 4; i++) {
                int nx = t.x + dr[i];
                int ny = t.y + dc[i];
                if(nx >= 0 && nx < N && ny >= 0 && ny < M && box[nx][ny] == 0) {
                    box[nx][ny] = 1;
                    q.add(new tomato(nx, ny));
                    check[nx][ny] = check[t.x][t.y] + 1;
                }
            }
        }
		
	}

	//좌표별 토마토 따로 구현
	static class tomato {
		int x;
		int y;
		
		public tomato(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	

}