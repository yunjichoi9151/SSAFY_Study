package pracprac.bj.study.d0815;

import java.util.Scanner;

public class swea6190 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			
			int N = sc.nextInt();
			
			int[] arr = new int[N];
			
			for(int i=0; i<N; i++) {
				
				arr[i] = sc.nextInt();
			}
			
			int max = -1;
			
			
			//일단 다 곱해서 비교
			
			for(int i=0; i<N; i++) {
				for(int j=i+1; j<N; j++) {
					int m = arr[i]*arr[j];
					
					
					//문자열 형변환 후 단조증가 수인지 검증
					//에러인가? d=1을 단조로 두면 분명 input하면 제대로 나오는데 테스트케이스 통과를 전혀 못함
					//거꾸로 하면 잘 됨
					
					//그런데 실행시간 메모리 노답임.. 다른방법
					String ds = String.valueOf(m);
					int d = 0;
					
					for(int k=1; k<ds.length(); k++) {
						if(ds.charAt(k-1) > ds.charAt(k)) {
							d=1;
						}
					}
					
					if(d==0) {
						max = Math.max(max,m);
					}
					
				}
				
			}
			
			System.out.println("#"+t+" "+max);
			
			
			
		}
		
	}

}
