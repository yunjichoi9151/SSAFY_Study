package pracprac.bj.study.d0810;

import java.util.Arrays;
import java.util.Scanner;

public class swea1860 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			
			int[] arv = new int[N];
			for(int i=0; i<N; i++) {
				arv[i] = sc.nextInt();
			}
			
			boolean boo = true;
			
			Arrays.sort(arv);
			for(int i=0; i<N; i++) {
				//대기타임동안 만들수 있는 붕어빵 갯수로 다음 손님 도달 전에 커버 가능한지 비교
				if((arv[i]/M)*K < i+1) {
					boo = false;
					break;
				}
				
			}
			
			  System.out.print("#" + tc + " ");
	            if (boo) 
	                System.out.println("Possible");
	            else 
	                System.out.println("Impossible");
	           
			
			
		}
				
	}
}
