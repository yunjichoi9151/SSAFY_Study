package pracprac.bj.study.d0817;

import java.util.ArrayList;
import java.util.Scanner;

public class bj2605 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int s = sc.nextInt();
		
		//번호표 저장할 배열
		int[] arr= new int[s];
		
		for(int i=0; i<s; i++) {
			arr[i] = sc.nextInt();
		}
		
		//번호표 0일경우 인덱스i와 동일
		//번호표 n일경우  i-n의 자리로 이동
		//i-0=i이므로 식 하나로 모든 경우 커버 가능
		
		//순서 저장할 리스트 배열
		ArrayList<Integer> List = new ArrayList<>();
		
		for(int i=0; i<s; i++) {
			//번호표 
			int n = arr[i];
			//i-n 인덱스에 i값 순차적으로 넣기
			List.add(i-n,i);
		}
		
		for(int i=0; i<s; i++) {
			System.out.print((List.get(i)+1)+" ");
		}
		
	}

}
