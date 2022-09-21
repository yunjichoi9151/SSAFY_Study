package pracprac.bj.study.d0921;
//https://nahwasa.com/entry/%EC%9E%90%EB%B0%94-%EB%B0%B1%EC%A4%80-10830-%ED%96%89%EB%A0%AC-%EC%A0%9C%EA%B3%B1-java
//https://st-lab.tistory.com/251
//행렬의 곱 개념을 몰랐음
//분할정복으로 곱셈 연산 횟수 절감
//B=1이고 원소가 1000이상일 경우 예외 주의 -> pow가 작동 안해서 처음 행렬값 받을때 1000으로 나눈 나머지로 초기화 필요

import java.util.Scanner;

public class bj10830 {
	
	static int N;
	static long B;
	static int[][] arr;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		B = sc.nextLong();
		
		arr = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {				
				arr[i][j] = sc.nextInt()%1000;				
			}
		}
		
		int[][] ans = pow(arr, B);
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(ans[i][j]+" ");
			}
			
			System.out.println();
		}
		
		
	}

	private static int[][] pow(int[][] arr2, long exp) {
		//B가 1일때 arr 그대로 리턴
		if(exp == 1L) {
			return arr2;
		}
		
		//B를 분할해서 재귀호출
		int[][] arrPow = pow(arr2, exp/2);
		
		//행렬곱 실행
		arrPow = multiply(arrPow, arrPow);
		
		//B가 홀수일 경우 마지막에 arr기본값을 한번 더 곱해주기
		if(exp%2 == 1L) {
			arrPow = multiply(arrPow, arr);
		}
		
		return arrPow;
	}
	
	//행렬곱
	private static int[][] multiply(int[][] arrM1, int[][] arrM2) {
		
		int[][] arrMul = new int[N][N];
		
		//행렬곱의 공식
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				for(int k=0; k<N; k++) {
					
					arrMul[i][j] += arrM1[i][k]*arrM2[k][j];
					arrMul[i][j] %= 1000;
					//곱연산 이후에 1000으로 나눈 나머지 출력
				}
			}
		}
		return arrMul;
	}
	
	

}
