package pracprac.bj.study.d0731;

import java.util.Arrays;
import java.util.Scanner;

public class bj1427 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		char[] N = sc.next().toCharArray();
		
		Arrays.sort(N);
		
		StringBuilder s = new StringBuilder(new String(N));
		
		System.out.println(s.reverse().toString());
		
		
		
	}

}
