package 이공이삼이월.d230228;
//https://st-lab.tistory.com/101
import java.util.Scanner;

public class 체스판다시칠하기_1018 {
	
	static boolean[][] isWhite;
	static int min = 64;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		isWhite = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			
			String s = sc.next();
			
			for(int j=0; j<M; j++) {
				if(s.charAt(j) == 'W') {
					isWhite[i][j] = true;
				}else {
					isWhite[i][j] = false;
				}
			}
		}
		
		int nr = N-7;
		int nc = M-7;
		
		for(int i=0; i<nr; i++) {
			for(int j=0; j<nc; j++) {
				paint(i,j);
			}
		}
		
		System.out.println(min);
		
	}

	private static void paint(int x, int y) {
		
		int ex = x+8;
		int ey = y+8;
		int cnt = 0;
		
		boolean colorWhite = isWhite[x][y];
		
		for(int i=x; i<ex; i++) {
			for(int j=y; j<ey; j++) {
				
				if(isWhite[i][j] != colorWhite) {
					cnt++;
				}
				//다음칸 색깔 바뀜
				colorWhite = (!colorWhite);
			}
			
			colorWhite = !colorWhite;
		}
		
		//같은 위치에서 색 기준 판별
		cnt = Math.min(cnt, 64-cnt);
		//그중 최소값
		min = Math.min(min, cnt);
	}
	

}
