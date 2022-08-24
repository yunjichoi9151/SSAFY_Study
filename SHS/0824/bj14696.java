package pracprac.bj.study.d0824;

import java.util.Scanner;

public class bj14696 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		String result = null;
		for(int i=0; i<N; i++) {
			
			int a = sc.nextInt();
			//1~4 인덱스 사용할 것이므로 5크기 배열 할당
			int[] arrA = new int[5];
			for(int j=0; j<a; j++) {
				arrA[sc.nextInt()]++;
			}
			
			int b = sc.nextInt();
			int[] arrB = new int[5];
			for(int j=0; j<b; j++) {
				arrB[sc.nextInt()]++;
			}
			
			//딱지 각 모양별로 갯수 비교 (더 큰것부터)
			for(int j=4; j>=1; j--) {
				
				if(arrA[j]>arrB[j]) {
					result = "A";
					break;
				}
				else if(arrA[j]<arrB[j]) {
					result = "B";
					break;
				}
				else {
					result ="D";
				}
				
			}
			
			System.out.println(result);
			
			
			
		}
		
		
	}

}
