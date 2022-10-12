package pracprac.bj.study.d1012;
//한수 100 이하일때 왜 갯수 = 입력값 똑같음?
//길이 한개짜리 등차수열과 길이 두개짜리 등차수열 무조건이니까
import java.util.Scanner;

public class bj1065 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println(han(sc.nextInt()));
	}

	private static int han(int num) {
		
		int cnt = 0;
		
		if(num < 100) {
			return num;
		}
		else {
			cnt = 99;
			
			for(int i=100; i<=num; i++) {
				int hund = i/100;
				int ten = (i/10)%10;
				int one = i%10;
				
				if((hund-ten)==(ten-one)) {
					cnt++;
				}
			}
			
			return cnt;
			
		}
		
		
		
		
	}

}
