package pracprac.bj.study.d0731;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class bj10814 {
	public static void main(String[] args) {		
		 
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		String[][] arr = new String[N][2];
		
 
		for(int i = 0; i < N; i++) {
			arr[i][0] = in.next();	// 나이
			arr[i][1] = in.next();	// 이름
		}
 
		
		Arrays.sort(arr, new Comparator<String[]>() {
			// 나이순으로 정렬
			public int compare(String[] s1, String[] s2) {
				return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
			}
			
		});
		
		//입력(가입)은 인덱스 순서이므로 그대로 출력
		
		for(int i = 0; i < N; i++) {
			System.out.println(arr[i][0] + " " + arr[i][1]);
		}
        
		
	}
 
}
