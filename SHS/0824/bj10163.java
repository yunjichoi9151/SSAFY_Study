package pracprac.bj.study.d0824;

import java.util.Scanner;

public class bj10163 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		//놀랍게도 1001 1001 짜리 맵 조건 이거 안맞추면 100점 안나옴
		int[][] arr = new int[1001][1001];
		
		//x y좌표 너비 높이
		for(int i=1; i<=N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int w = sc.nextInt();
			int h = sc.nextInt();
			
			//i번째 색종이 면적이 차지하는 위치에 숫자 i 대입
			//위에 덮어지면 자동 갱신
			for(int j=x; j<x+w; j++) {
				for(int k=y; k<y+h; k++) {
					arr[j][k] = i; 
				}
			}
		}
		
		
		for(int i=1; i<=N; i++) {
			int cnt = 0;
			//똑같은 방식으로 면적 계산
			for(int j=0; j<1001; j++) {
				for(int k=0; k<1001; k++) {
					if(arr[j][k] == i) {
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
		

	}

}
