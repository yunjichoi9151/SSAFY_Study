package pracprac.bj.study.d0821;

import java.util.Scanner;

public class bj2477 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int K = sc.nextInt();
		
		//최대 변길이 인덱스 저장
		int maxh = 0, maxw = 0;
		int hidx= -1, widx = -1;
		
		//입력값 방향, 길이
		int[] drc = new int [6];
		int[] filen = new int [6];
		
		for(int i=0; i<6; i++) {
			
			drc[i] = sc.nextInt();
			filen[i] = sc.nextInt();
			
		}
		
		//
		for(int i=0; i<6; i++) {
			//세로길이 max값 저장
			if(drc[i] == 1 || drc[i] == 2) {
				if(maxh < filen[i]) {
					maxh = filen[i];
					hidx = i;
				}
			}else {
				//가로길이 max값 저장
				if(maxw < filen[i]) {
					maxw = filen[i];
					widx = i;
				}
			}
		}
		//큰 사각형 넓이 도출
		int area1 = maxh*maxw;
		//작은 사각형 넓이 도출
		//(가로세로최댓값 인덱스+3)%6 인덱스는 안쪽 세로가로인덱스임 
		int area2 = filen[(widx + 3)%6]*filen[(hidx + 3)%6];
		
		System.out.println((area1-area2)*K);
		
	}

}
