package pracprac.bj.study.d0904;

import java.util.Scanner;
//https://st-lab.tistory.com/90
public class bj1002 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		int d = 0;
		
		for(int t=1; t<=T; t++) {
			
			int ans = 0;
			
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int r1 = sc.nextInt();
			
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int r2 = sc.nextInt();
			
			d = (int)(Math.pow((x2-x1), 2) + Math.pow((y2-y1),2));
			
			//중점과 반지름이 같으면 무한대
			if(x1 == x2 && y1 == y2 && r1 == r2) {
				ans = -1;
			}
			//두 원의 반지름 합보다 중점간 거리가 더 길면 안만남
			else if(d > Math.pow(r1+r2, 2)) {
				ans = 0;
			}
			//원 안에 원이 있지만 안만남
			else if(d < Math.pow(r2-r1, 2)) {
				ans = 0;
			}
			//한 점에서 내접할때
			else if(d == Math.pow(r2-r1, 2)) {
				ans = 1;
			}
			//한 점에서 외접할때
			else if(d == Math.pow(r1+r2, 2)) {
				ans = 1;
			}
			
			//아닌경우 두 점이 겹침
			else {
				ans = 2;
			}
			
			System.out.println(ans);
			
		}
		
	}

}
