package pracprac.bj.study.d0921;
//분할정복 재귀
//작은 삼각형 하나 만들때 N=3 3*5행렬에 (0,2) *
//(1,4)(1,2) * * 
//(2,0)~(2,4) *****
//분할하면서 재귀반복

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj2448 {
	
	static char[][] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//시간초과^^ 때문에
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
	        
		
		arr = new char[N][2*N-1]; // N=3일때 3*5 행렬 출력
		
		for(int i=0; i<N; i++) {
			Arrays.fill(arr[i], ' ');
		}
		
		starTree(0, N-1, N);
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<2*N-1; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
	}

	private static void starTree(int r, int c, int N) {
		
		//패턴이 가장 작은 단위일 때
		if(N ==3 ) {
			arr[r][c] = '*';
			arr[r+1][c+1] = arr[r+1][c-1] = '*';
			arr[r+2][c-2] = arr[r+2][c-1] = arr[r+2][c] 
					= arr[r+2][c+1] = arr[r+2][c+2]='*';
		}
		else {
			//아닐 경우 *1/2 쪼개서 재귀 반복
			starTree(r,c,N/2);
			starTree(r+N/2,c+N/2,N/2);
			starTree(r+N/2,c-N/2,N/2);
		}
		
		
		
	}

}
