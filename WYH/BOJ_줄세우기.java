package day0823;

import java.util.LinkedList;
import java.util.Scanner;

public class BOJ_줄세우기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] r = new int[num];

		for (int i = 0; i < num; i++) {
			r[i] = sc.nextInt();
		}

		LinkedList<Integer> list = new LinkedList<>();

		for (int i = 0; i < r.length; i++) {
			list.add(list.size() - r[i], i + 1);
		}

		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}

	}
}
