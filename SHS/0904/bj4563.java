package pracprac.bj.study.d0904;

import java.util.Scanner;

public class bj4563 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			//범위를 long으로 해야 큰 수도 받음
			long A = sc.nextInt();
			
			if(A == 0) {
				break;
			}
			
			int ans = 0;
			
			long tmp = A*A;
			
			//A^2 = C^2 - B^2 = (C+B)(C-B) = x * y
			// x = C+B , y = C-B
			// tmp = x 로 두고 생각
			// B, C 둘다 자연수, B>A 조건 충족시 직각삼각형 수 ++
			for(int i=1; i<=A; i++) {
					if(tmp%i == 0) {
						if((tmp/i + i)/2 == ((tmp/i + i)/2.0)&&
								(tmp/i - i)/2 == ((tmp/i - i)/2.0)&&
								(tmp/i - i)/2 > A ) {
							ans++;
						}
				}
				
			}
			
			System.out.println(ans);
			
			
		}
		
	}

}
