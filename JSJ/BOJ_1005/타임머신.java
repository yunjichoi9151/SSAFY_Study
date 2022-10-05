package BOJ_1005;

import java.util.*;
import java.io.*;

// 참고
public class 타임머신 {
	static class node {
		int start;
		int end;
		int cost;

		public node(int start, int end, int cost) {
			this.end = end;
			this.start = start;
			this.cost = cost;
		}
	}

	static int v;
	static int e;
	static List<node> list;
	static long[] distance;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		v = Integer.parseInt(s[0]);
		e = Integer.parseInt(s[1]);
		list = new ArrayList<>();
		distance = new long[v + 1];
		for (int i = 1; i <= v; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		int a, b, c;

		for (int i = 0; i < e; i++) {
			String[] s1 = br.readLine().split(" ");
			a = Integer.parseInt(s1[0]);
			b = Integer.parseInt(s1[1]);
			c = Integer.parseInt(s1[2]);
			list.add(new node(a, b, c));
		}

		StringBuilder sb = new StringBuilder();

		if (bell()) {
			for (int i = 2; i <= v; i++) {
				if (distance[i] == Integer.MAX_VALUE) {
					sb.append(-1).append("\n");
					continue;
				}
				sb.append(distance[i]).append("\n");
			}
		} else {
			sb.append(-1);
		}

		System.out.println(sb.toString());
	}

	public static boolean bell() {
		distance[1] = 0;
		for (int i = 1; i <= v; i++) {
			for (node a : list) {
				if (distance[a.start] == Integer.MAX_VALUE) {
					continue;
				}
				if (distance[a.end] > distance[a.start] + a.cost) {
					distance[a.end] = distance[a.start] + a.cost;
				}
			}
		}

		for (int i = 1; i <= v; i++) {
			for (node a : list) {
				if (distance[a.start] == Integer.MAX_VALUE) {
					continue;
				}
				if (distance[a.end] > distance[a.start] + a.cost) {
					return false;
				}
			}
		}
		return true;
	}
}