package 스터디;

import java.util.Arrays;
import java.util.Scanner;

public class N10814 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		String[][] arr = new String[N][2];

		for (int i = 0; i < N; i++) {
			arr[i][0] = sc.next();
			arr[i][1] = sc.next();
		}

		Arrays.sort(arr, (String[] s1, String[] s2) -> {
			return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
		});

		for (int i = 0; i < N; i++) {
			System.out.println(arr[i][0] + " " + arr[i][1]);
		}

	}
}
