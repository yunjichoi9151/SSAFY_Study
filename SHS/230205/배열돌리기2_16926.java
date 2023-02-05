package d230203;

import java.util.Scanner;

public class 배열돌리기2_16926 {
	
	static int N;
	static int M;
	static int R;
	static int[][] arr;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		R = sc.nextInt();
		arr = new int[N][M];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
				
		int rs = 0;
		int re = N-1;
		int cs = 0;
		int ce = M-1;
		
		while(true) {
			int bing = (re-rs+1)*2 + (ce-cs+1)*2-4;
			rotate(rs, re, cs, ce, R%bing);
			rs+=1;
			re-=1;
			cs+=1;
			ce-=1;
			
			if(rs>re || cs>ce) {
				break;
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
		
	}

	private static void rotate(int rs, int re, int cs, int ce, int cnt) {
		for(int a=0; a<cnt; a++) {
			int tmp = arr[rs][cs];
			
			for(int y=cs; y<ce; y++) {
				arr[rs][y] = arr[rs][y+1];
			}
			
			for(int x=rs; x<re; x++) {
				arr[x][ce] = arr[x+1][ce];
			}
			
			for(int y=ce; y>cs; y--) {
				arr[re][y] = arr[re][y-1];
			}
			
			for(int x=re; x>rs; x--) {
				arr[x][cs] = arr[x-1][cs];
			}
			
			arr[rs+1][cs] = tmp;
			
		}
		
	}
}
