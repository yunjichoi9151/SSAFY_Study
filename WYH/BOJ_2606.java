package day0914;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2606 {
	
	static int[] check;
	static int[][] arr;
	
	static int com, num, start;
	
	static Queue<Integer> q = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		com = Integer.parseInt(st.nextToken()); // 컴퓨터의 수
		num = Integer.parseInt(st.nextToken());  // 연결된 쌍의 수
		start = Integer.parseInt(st.nextToken());
		
		arr = new int[com+1][com+1];
		check = new int[com+1];
		
		
		for(int i=0;i<num;i++) {
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
	}
	
	static void bfs(int start) {
		check[start] = 1;
		q.offer(start);
		int cnt = 0;
		while(!q.isEmpty()) {
			int x = q.poll();
			
			for(int i=1;i<arr.length;i++) {
				if(arr[x][i] == 1 && check[i] != 1) {
					q.offer(i);
					check[i] = 1;
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}
