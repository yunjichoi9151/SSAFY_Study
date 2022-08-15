package pracprac.bj.study.d0815;

import java.util.Scanner;

public class swea4789 {

	public static void main(String[] args) {
		
		//동욱이 미친놈인듯
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
		//기립박수치는 사람이 i-1명 이상일때 i번 인덱스 사람 수만큼 더 일어남
		//i번째 사람들을 일으키기 위해 필요한 인원  + i-1번째 사람까지의 누적합  = i 
			String s = sc.next();
			//기립박수하는 사람 누적합
			int sum=0;
			//고용해야 하는 알바 수
			int emp=0;
			
			
			for(int i=0; i<s.length(); i++) {
				//비교를 위해 정수로 변환
				int tmp = s.charAt(i)-'0';
				
					//기립박수 하는 사람이 인덱스값보다 크거나 같으면 고용 필요 x
					//해당 인덱스 사람 수만큼 기립박수 하는 사람 추가
					if(sum>=i) {
						sum= sum + tmp;
					}
					//필요한 사람 수 (인덱스값-누적기립박수인원) 만큼 고용
					else {
						emp = emp + i - sum;
						sum = i + tmp;
					}
				}
			
			System.out.println("#"+t+" "+emp);
			
		}
		
	}
}
