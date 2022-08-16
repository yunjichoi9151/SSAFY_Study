package pracprac.bj.study.d0815;

import java.util.Scanner;

public class swea5432 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			
			int irl=0, ir =0;
			
			String s = sc.next();
			
			for(int i=0; i<s.length()-1; i++) {
				//레이저 발사 지점에서 잘려진 쇠막대기 수는 기존 쇠막대기 수만큼 증가
				if(s.charAt(i) == '(' && s.charAt(i+1) ==')') {
					irl += ir;
					i++;
				}
				//초기 쇠막대기 수 추가
				else if(s.charAt(i) =='(') {
					ir++;
				}
				//쇠막대기 끝지점
				else {
					ir--; 
					irl++;
				}
			}
			System.out.println("#"+ t + " " + ++irl);
			
			
		}
		
		
	}

}
