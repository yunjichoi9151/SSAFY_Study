package day0413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10845 {
	
	static int[] queue = new int[10001];
	static int first = 0;
	static int last = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			String cmd = br.readLine();
			StringTokenizer st = new StringTokenizer(cmd);
			
			switch(st.nextToken()) {
			case "push":
				int num = Integer.parseInt(st.nextToken());
				push(num);
				break;
			case "pop":
				System.out.println(pop());
				break;
			case "size":
				System.out.println(size());
				break;
			case "empty":
				System.out.println(empty());
				break;
			case "front":
				System.out.println(front());
				break;
			case "back":
				System.out.println(back());
				break;
		}
			
			
			
		}
	}
	
	public static void push(int x) {
		queue[last] = x;
		last++;
	}
	
	public static int pop() {
		if(last-first == 0) {
			return -1;
		}else {
			int p = queue[first];
			first++;
			return p;
		}
	}
	
	public static int size() {
		return last-first;
	}
	
	public static int empty() {
		if(last-first==0) {
			return 1;
		}else {
			return 0;
		}
	}
	
	public static int front() {
		if(last-first==0) {
			return -1;
		}else {
			int f = queue[first];
			return f;
		}
	}
	
	public static int back() {
		if(last-first==0) {
			return -1;
		}else {
			int b = queue[last-1];
			return b;
		}
	}	
}
