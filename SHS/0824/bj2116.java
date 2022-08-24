package pracprac.bj.study.d0824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj2116 {
	//https://orubt.tistory.com/172
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int n = Integer.parseInt(br.readLine());
		int[][] dice = new int[n][6];
		
		//주사위의 마주보는 면끼리 짝짓기 위해서 0,3 1,4 2,5 인덱스에 저장
		for(int i=0; i<n; i++) {
			String[] diceset = br.readLine().split(" ");
			dice[i][0] = Integer.parseInt(diceset[0]);
			dice[i][1] = Integer.parseInt(diceset[1]);
			dice[i][2] = Integer.parseInt(diceset[2]);
			dice[i][3] = Integer.parseInt(diceset[5]);
			dice[i][4] = Integer.parseInt(diceset[3]);
			dice[i][5] = Integer.parseInt(diceset[4]);
			
		}
		//각 주사위에 대해 밑면이 b 윗면이 t일때 최대값 도출을 위해서는 
		//위 아래면 제외 4면 중 가장 큰 값 선택하면 됨
		int max = 0;
		
		for(int i=0; i<6; i++) {
			int b = dice[0][i];
			//마주보는 면
			int t = dice[0][(i+3)%6];
			int sum = side(b,t);
			
			for(int j=1; j<n; j++) {
				for(int k=0; k<6; k++) {
					if(dice[j][k] == t) {
						b = dice[j][k];
						t = dice[j][(k+3)%6];
						break;
					}
				}
				
				sum += side(b,t);
			}
			
			max = Math.max(max, sum);
		}
		System.out.println(max);
		
		
		
	}
	
	//위아래제외 최대값 찾는 함수
	
	static int side(int b, int t) {
		//위아래가 각각 무엇인가에 따라 옆면 최댓값 달라짐
		if(b+t == 11) {
			return 4;
		}else if(b == 6 || t ==6) {
			return 5;
		}else {
			return 6;
		}
	}
	

}
