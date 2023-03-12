package 이공이삼삼월.d230302;

import java.util.Scanner;

public class 이공사팔easy_12100 {

	static int N;
	static int ans;
	static int[][] map;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		ans = 0;
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		play(0);
		
		System.out.println(ans);
		
	}

	private static void play(int cnt) {
		if(cnt == 5) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					ans = Math.max(ans, map[i][j]);
				}
			}
			return;
		}
		int mapCoppy[][] = new int[N][N];
		
		for(int i=0; i<N; i++) {
			mapCoppy[i] = map[i].clone();
		}
		for(int i=0; i<4; i++) {
			move(i);
			play(cnt+1);
			for(int j=0; j<N; j++) {
				map[j] = mapCoppy[j].clone();
			}
		}
		
	}

	private static void move(int d) {
		//상하좌우
		switch(d) {
		case 0:
			for(int i=0; i<N; i++) {
				int idx = 0;
				int num = 0;
				for(int j=0; j<N; j++) {
					if(map[j][i] != 0) {
						if(num==map[j][i]) {
							map[idx-1][i] = num*2;
							num = 0;
							map[j][i] = 0;
						}else {
							num = map[j][i];
							map[j][i] = 0;
							map[idx][i] = num;
							idx++;
							
						}
					}
				}
			}
			break;
		case 1:
			for(int i=0; i<N; i++) {
				int idx = N-1;
				int num = 0;
				for(int j=N-1; j>=0; j--) {
					if(map[j][i] != 0) {
						if(num==map[j][i]) {
							map[idx+1][i] = num*2;
							num = 0;
							map[j][i] = 0;
						}else {
							num = map[j][i];
							map[j][i] = 0;
							map[idx][i] = num;
							idx--;
							
						}
					}
				}
			}
			break;
		case 2:
			for(int i=0; i<N; i++) {
				int idx = 0;
				int num = 0;
				for(int j=0; j<N; j++) {
					if(map[i][j] != 0) {
						if(num==map[i][j]) {
							map[i][idx-1] = num*2;
							num = 0;
							map[i][j] = 0;
						}else {
							num = map[i][j];
							map[i][j] = 0;
							map[i][idx] = num;
							idx++;
							
						}
					}
				}
			}
			break;
		case 3:
			for(int i=0; i<N; i++) {
				int idx = N-1;
				int num = 0;
				for(int j=N-1; j>=0; j--) {
					if(map[i][j] != 0) {
						if(num==map[i][j]) {
							map[i][idx+1] = num*2;
							num = 0;
							map[i][j] = 0;
						}else {
							num = map[i][j];
							map[i][j] = 0;
							map[i][idx] = num;
							idx--;
							
						}
					}
				}
			}
			break;			
		}
		
	}
	
}
