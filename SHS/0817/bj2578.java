package pracprac.bj.study.d0817;

import java.util.Scanner;

public class bj2578 {
	
	public static void main(String[] args) {
		
		//입력값 주의
		Scanner sc = new Scanner(System.in);
		
		int[][]bg = new int[5][5];
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				bg[i][j]=sc.nextInt();
			}
		}
		
		//빙고수세기
		int bgcnt = 0;
		
		//사회자 for문 인덱스 지정 1부터 하거나 마지막에 +1 해줘야함
		for(int n=1; n<=25; n++) {
			int lt = sc.nextInt();
			
			//부른 값이 맞으면 0으로 바꾸기
			for(int j=0; j<5; j++) {
				for(int k=0; k<5; k++) {
					
					if(bg[j][k] == lt) {
						bg[j][k] = 0;
					}
				}
			}
			
			
		//0=체크된 값 수 세기	
		int check = 0;
			
		//가로검증
		for(int j=0; j<5; j++) {
			//초기화
			check = 0;
			for(int k=0;k<5;k++) {
				if(bg[j][k]==0) {
					check++;
				}
			}
			if(check==5) {
				bgcnt++;
			}
		}
		
		//세로검증
		for(int j=0; j<5; j++) {
			check = 0;
			for(int k=0;k<5;k++) {
				if(bg[k][j]==0) {
					check++;
				}
			}
			if(check==5) {
				bgcnt++;
			}
		}
		
		//대각선우하향 검증
		//초기화
		check = 0;
		for(int j=0; j<5; j++) {
				if(bg[j][j]==0) {
					check++;
				}
			if(check==5) {
				bgcnt++;
			}
		}
		
		//대각선우상향 검증
		check = 0;
		for(int j=0; j<5; j++) {
				if(bg[j][4-j]==0) {
					check++;
				}
			if(check==5) {
				bgcnt++;
			}
		}
		
		//빙고수 3회 이상일때
		if(bgcnt>=3) {
			System.out.println(n);
			//안하면 뒤에값도다나옴 ㅎㅎ
			break;
		}
		//if문 안걸렸을경우 다시 들어가기 전에 초기화 필요
		bgcnt = 0;
			
		}
	}

}
