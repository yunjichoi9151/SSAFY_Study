package day0912;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_11725 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<Integer> list[]  = new ArrayList[N+1];
		for(int i=0;i<=N;i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i=0;i<N;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			list[x].add(y);
			list[y].add(x);
		}
		
		boolean[] visit = new boolean[N+1];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		visit[1] = true;
		int ans[] = new int[N+1];
		while(!q.isEmpty()) {
			int num = q.poll();
			for(int i : list[num]) {
				if(!visit[i]) {
					visit[i] = true;
					ans[i] = num;
					q.add(i);
				}
			}
		}
		
		for(int i=2;i<ans.length;i++) {
			System.out.println(ans[i]);
		}
		}
}
