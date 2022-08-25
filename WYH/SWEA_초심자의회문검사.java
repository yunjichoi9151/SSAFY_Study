package day0819;

import java.util.Scanner;

public class SWEA_초심자의회문검사 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		boolean result = false;
		for(int tc=1;tc<=T;tc++) {
			String st = sc.next();
			
			for(int i=0;i<st.length()/2;i++) {
				if(st.charAt(i) == st.charAt(st.length()-(i+1))) {
					result = true;
				}else result = false;
			}
			if(result) System.out.println("#"+tc+" "+1);
			else System.out.println("#"+tc+" "+0);
		}
		

	}

}
