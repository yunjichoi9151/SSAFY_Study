package pracprac.bj.study.d0904;

import java.text.DecimalFormat;
import java.util.Scanner;

public class bj6322 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int t = 1;
		
		while(true) {
			
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			//0 0 0 입력시 종료, 탈출
			if(a == 0 && b == 0 && c == 0) {
				break;
			}
			
			//출력형식 맞추려고..
			DecimalFormat df = new DecimalFormat("0.000");
			String s = "";
			
			if(a == -1) {
				if(b>=c) {
					s = "Impossible.";
				}else {
					//빗변보다 길면 삼각형이 될 수 없음
					//피타고라스 정리
					s = s+ "a = " + df.format(Math.sqrt((c*c)-(b*b)));
				}
			}

			if(b == -1) {
				if(a>=c) {
					s = "Impossible.";
				}else {
					s = s+ "b = " + df.format(Math.sqrt((c*c)-(a*a)));
				}
			}			
			
			if(c == -1) {
				
					s = s+ "c = " + df.format(Math.sqrt((b*b)+(a*a)));
				}
			
			System.out.println("Triangle #" + t);
			System.out.println(s + "\n");
			t++;
			
		}
		
	}
}
