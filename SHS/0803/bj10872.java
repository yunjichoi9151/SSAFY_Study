package pracprac.bj.study.d0807;

import java.util.Scanner;

public class bj10872 {
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int fac=1;
		
		for(int i=N; i>=1; i--) {
			fac=fac*i;
		}
		
		System.out.println(fac);
		
	}

}
