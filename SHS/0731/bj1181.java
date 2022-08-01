package pracprac.bj.study.d0731;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class bj1181 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] arr = new String[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.next();
		}		
		
		Arrays.sort(arr, new Comparator<String>() {
			public int compare(String s1, String s2) {
				// 단어 길이가 같으면 
				if (s1.length() == s2.length()) {
					return s1.compareTo(s2); //아스키코드값으로 사전순 정렬
				} 
				// 아니면 길이 비교
				else {
					return s1.length() - s2.length();
				}
			}
		});
		
//		Arrays.sort(arr,(String s1, String s2)->{
//		 if(s1.length()==s2.length())
//			return s1.compareTo(s2);
//		else return s1.length()-s2.length();
//		});
			
 
		System.out.println(arr[0]);
		
		for (int i = 0; i < N-1; i++) {
			// 중복단어는 한번만 출력
			if (!arr[i].equals(arr[i + 1])) {
				System.out.println(arr[i]);
			}
		}
		
	}

}
