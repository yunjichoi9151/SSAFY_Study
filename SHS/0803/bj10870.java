package pracprac.bj.study.d0807;

import java.util.Scanner;

public class bj10870 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		System.out.println(Fibo(N));
	}
	
	
	static int Fibo(int N) {
		if(N <=1) return N;
		
		return Fibo(N-1)+Fibo(N-2);
	}

}
