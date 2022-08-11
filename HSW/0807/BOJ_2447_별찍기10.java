package HSW;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2447_별찍기10 {
	static char[][] arr;
	public static StringBuilder sb = new StringBuilder();
	
	//별찍기 메소드
	static void star(int x, int y, int N, boolean blank){
		//blank == true
		if(blank){
			for(int i=x; i<x+N; i++){
				for(int j=y; j<y+N; j++){
					arr[i][j] = ' ';
				}
			}
			return;
		}

		//재귀의 끝
		if(N==1){
			arr[x][y]='*';
			return;
		}

		int cnt = 0;
		for(int i=x; i<x+N; i+=N/3){
			for(int j=y; j<y+N; j+=N/3){
				cnt++;
				/*
				 1 2 3
				 4 5 6
				 7 8 9
				 에서 5번째 칸을 공백으로 만드는것
				 */
				if(cnt==5)
					star(i, j, N/3, true);
				else
					star(i, j, N/3, false);
			}
		}




	}

	public static void main(String[] args) throws IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());

		arr = new char[N][N];

		star(0, 0, N, false);

		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

}
