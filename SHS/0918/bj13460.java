package pracprac.bj.study.d0918;
//이건 일타싸피 응용인가요
//https://validming99.tistory.com/m/157
//최소 횟수 구하는거니까 bfs
//탈락기준 10번이상, 파란공 in
//기울이면 그 방향으로 구슬이 움직인다

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj13460 {
		
	    static int N, M;
	    static char[][] map;
	    //사방으로 굴림
	    static int[][] d = {{-1, 1, 0, 0}, {0, 0, -1, 1}};

	    //빨공 파공 움직이는 함수
	    public static class State{
	        int Rrow, Rcol, Brow, Bcol, move;
	        public State(){
	            move = 0;
	        }
	        public State(int rr, int rc, int br, int bc, int m){
	            Rrow = rr;
	            Rcol = rc;
	            Brow = br;
	            Bcol = bc;
	            move = m;
	        }
	    }

	    public static void main(String[] args) {
	        //입력
	        Scanner sc = new Scanner(System.in);
	        N = sc.nextInt();
	        M = sc.nextInt();
	        map = new char[N][M];

	        State ini = new State();
	        int[] hole = new int[2];

	        for(int i=0;i<N;i++){
	            String str = sc.next();
	            for(int j=0;j<M;j++){
	                char c = str.charAt(j);
	                map[i][j] = c;
	                //구멍 좌표 저장
	                if(c=='O'){
	                    hole[0] = i;
	                    hole[1] = j;
	                }
	                //빨공 좌표 저장
	                if(c=='R'){
	                    ini.Rrow = i;
	                    ini.Rcol = j;
	                    map[i][j] = '.';
	                }
	                //파공 좌표 저장
	                if(c=='B'){
	                    ini.Brow = i;
	                    ini.Bcol = j;
	                    map[i][j] = '.';
	                }
	            }
	        }

	        
	        //BFS
	        Queue<State> q = new LinkedList<>();
	        //방문체크
	        boolean[][][][] visit = new boolean[N][M][N][M];
	        q.add(ini);
	        visit[ini.Rrow][ini.Rcol][ini.Brow][ini.Bcol] = true;
	        int answer = -1;
	        
	        while(!q.isEmpty()){
	            State cur = q.poll();
	            //파란공이 들어가면 탈락
	            if(cur.Brow==hole[0] && cur.Bcol==hole[1]) continue;
	            //빨간공 골인시 answer에 움직인 횟수 저장
	            if(cur.Rrow==hole[0] && cur.Rcol==hole[1]){
	                answer = cur.move;
	                break;
	            }

	            for(int i=0;i<4;i++){
	                if(getFirst(cur, i) <= 0) { //음수일 경우 R우선 굴리기
	                    int[] next = moveBall(cur.Rrow, cur.Rcol, cur.Brow, cur.Bcol, i);
	                    int[] red = {next[0], next[1]};
	                    int[] blue = {next[2], next[3]};
	                    //10번 아래 횟수까지만 돌린다
	                    if(!visit[red[0]][red[1]][blue[0]][blue[1]] && cur.move<10){
	                        visit[red[0]][red[1]][blue[0]][blue[1]] = true;
	                        q.add(new State(red[0], red[1], blue[0], blue[1], cur.move+1));
	                    }
	                }
	                else { //아닐 경우 파공 먼저
	                    int[] next = moveBall(cur.Brow, cur.Bcol, cur.Rrow, cur.Rcol, i);
	                    int[] red = {next[2], next[3]};
	                    int[] blue = {next[0], next[1]};
	                    if(!visit[red[0]][red[1]][blue[0]][blue[1]] && cur.move<10){
	                        visit[red[0]][red[1]][blue[0]][blue[1]] = true;
	                        q.add(new State(red[0], red[1], blue[0], blue[1], cur.move+1));
	                    }
	                }
	            }
	        }

	        System.out.println(answer);
	    }
	    
	    //어느 방향으로 기울일때 빨간공이 파란공보다 바깥에 가깝다면 빨간공부터 움직인다
	    //즉 음수면 R우선
	    public static int getFirst(State state, int dir){
	        switch(dir){
	            case 0: //상
	                return state.Rrow - state.Brow;
	            case 1: //하
	                return (state.Rrow - state.Brow)*-1;
	            case 2: //좌
	                return state.Rcol - state.Bcol;
	            case 3: //우
	                return (state.Rcol - state.Bcol)*-1;
	            default: return 0;
	        }
	    }
	    
	    //공 굴리는 함수
	    public static int[] moveBall(int r1, int c1, int r2, int c2, int dir){
	        int[] next = new int[4];

	        //먼저 굴러가는 공 : ball1
	        int nr1 = r1 + d[0][dir];
	        int nc1 = c1 + d[1][dir];

	        while(0<=nr1 && nr1<N && 0<=nc1 && nc1<M){
	            if(map[nr1][nc1]=='#'){
	                nr1 -= d[0][dir];
	                nc1 -= d[1][dir];
	                break;
	            }
	            if(map[nr1][nc1]=='O') break;
	            nr1 += d[0][dir];
	            nc1 += d[1][dir];
	        }

	        next[0] = nr1;
	        next[1] = nc1;

	        //ball2 굴리기
	        int nr2 = r2 + d[0][dir];
	        int nc2 = c2 + d[1][dir];

	        while(0<=nr2 && nr2<N && 0<=nc2 && nc2<M){
	        	//골인하면 빠져나가기
	            if(map[nr2][nc2]=='O') break;
	            
	            if(map[nr2][nc2]=='#' || (nr1==nr2 && nc1==nc2)){
	                nr2 -= d[0][dir];
	                nc2 -= d[1][dir];
	                break;
	            }
	            nr2 += d[0][dir];
	            nc2 += d[1][dir];
	        }

	        next[2] = nr2;
	        next[3] = nc2;

	        return next;
	    }
	}
