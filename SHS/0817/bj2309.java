package pracprac.bj.study.d0817;

import java.util.Arrays;
import java.util.Scanner;

public class bj2309 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[]arr = new int[9];
		
		for(int i=0; i<9; i++) {
			
			arr[i] = sc.nextInt();
		}
		
		
		//우선 다 합한다
		int sum = 0;
		
		for(int i=0; i<9; i++) {
			
			sum +=arr[i];
		}
		
		//정렬
		Arrays.sort(arr);
		
		//가짜 두명 색출하기 - 두 개의 값을 뺐을 때 100이 되는 경우 찾기
		for(int i=0; i<8; i++) {
			for(int j=1+i; j<9; j++) {
				if(sum-arr[i]-arr[j] == 100) {
					
					//색출한 인덱스값 0으로 
					arr[i]=arr[j]=0;
					
					//재정렬
					Arrays.sort(arr);
					
					//0이 아닌 나머지 값 오름차순 출력
					for(int k=2; k<9; k++) {
						System.out.println(arr[k]);
					}
					//이거 안넣으면 오답처리됨...
					//출력 이후에 프로그램을 종료처리해줘야 하는 문제였음!!
					return;
				}
			}			
		}		
	}
}
