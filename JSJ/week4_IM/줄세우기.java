package week4_IM;

import java.util.LinkedList;
import java.util.Scanner;

public class 줄세우기 re{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] arr = new int[N]; // 처음 줄 선 학생순으로 뽑은 번호

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		LinkedList<Integer> list = new LinkedList<>();

		// 뽑은 번호만큼 앞자리로
		for (int i = 0; i < arr.length; i++) {
			list.add(list.size() - arr[i], i + 1);
		}

		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");

		}
	}
}