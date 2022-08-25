package pracprac.bj.study.d0821;

import java.util.ArrayList;
import java.util.Scanner;

public class bj2635 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int max=0;
		
		ArrayList<Integer> ans = new ArrayList<>();	
		

		// n/2보다 작을 경우 3번으로 종료하기 때문에 n/2까지만 검증해도 됨 
		for(int i=n; i>=n/2; i--) {
			
			ArrayList<Integer> list = new ArrayList<>();				
			list.add(n);
			//n1 이전값 n2 현재값 tmp 임시값
			int n1 = n;
			int n2 = i;
					
			while(true) {
				//음수일때 종료
				if(n1<0) {
					break;
				}
				int tmp = n1;
				
				if(n2>=0) {
					list.add(n2);
				}
				//리스트에 현재값 넣은 뒤 다음것 수행
				//전전값-전값
				n1 = n2;
				n2 = tmp-n1;
			}
			
			//최대길이 경우 찾아서 저장			
			if(max < list.size()) {
				max = list.size();
				ans = list;
				
			}
			
		}
		
		//출력
		System.out.println(max);
		for(int i=0; i<ans.size(); i++) {
			System.out.print(ans.get(i)+" ");
		}
		
		
	}

}
