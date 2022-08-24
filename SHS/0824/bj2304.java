package pracprac.bj.study.d0824;

import java.util.Scanner;
import java.util.Stack;

public class bj2304 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[1001];
		int start = 1000;
		int end = 0;
		int ans =0;
				
		for(int i=0; i<N; i++) {
			int L = sc.nextInt();
			int H = sc.nextInt();
			arr[L] = H;
			//최대 길이 기준 좌우 나눠서 검증
			start = Math.min(L, start);
			end = Math.max(L, end);
		}
		
		Stack<Integer> stk = new Stack<>();
		
		//좌측검증
		int left = arr[start];
		for(int i=start+1; i<=end; i++) {
			if(arr[i]<left) {
				stk.push(i);
			}
			else {
				while(!stk.isEmpty()) {
					int d = stk.pop();
					arr[d] = left;
				}
				left = arr[i];
			}
		}
		stk.clear();
		
		//우측검증
		int right = arr[end];
		for(int i=end-1; i>=start; i--) {
			if(arr[i]<right) {
				stk.push(i);
			}
			else {
				while(!stk.isEmpty()) {
					int d = stk.pop();
					arr[d] = right;
				}
				right = arr[i];
			}
		}

		for(int i=start; i<=end; i++) {
			ans+=arr[i];
		}
		
		System.out.println(ans);
		
	}

}
