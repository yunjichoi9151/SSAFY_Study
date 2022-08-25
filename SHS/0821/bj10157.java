package pracprac.bj.study.d0821;

import java.util.Scanner;

public class bj10157 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int C = sc.nextInt();
		int R = sc.nextInt();
		
		//상우하좌
		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, 1, 0, -1};

		//세로끝부터 순회해서 헷깔리니까 가로세로 바꿔서 생각
		int [][] arr = new int[R][C];
		
		int K = sc.nextInt();
		
		//좌석번호, 방향
		int cnt=1, dir=0;
		//시작좌표
		int x=R-1, y=0;
		
		//0이 될 경우
		if(K > C*R) {
			System.out.println(0);
			//return안해주면 계속 돌아감
			return;
		}
		
		while(cnt != K) {
			//순회 시작
			arr[x][y] = cnt;
			int dx = x+dr[dir];
			int dy = y+dc[dir];
			
			//끝에 닿을 때마다 방향 전환. 이미 지나간 자리는 거치지 않음
			if(dx<0 || dy<0 || dx>=R || dy>=C || arr[dx][dy] !=0 ) {
				
				dir++;
				if(dir==4) {
					dir=0;
				}
				
				dx = x+dr[dir];
				dy = y+dc[dir];
			}
			
			//좌표값 및 좌석번호 저장
			x=dx;
			y=dy;
			
			cnt++;
		}
		
		//출력시 좌표 반대로, 인덱스값 +1
		System.out.println((y+1)+" "+(R-x));
		
	}

}
