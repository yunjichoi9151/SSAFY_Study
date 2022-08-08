package 스터디;

import java.util.Arrays;
import java.util.Scanner;

public class N1181 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		String[] str = new String[N];
		for (int i = 0; i < N; i++) {
			str[i] = sc.next();
		}

		Arrays.sort(str, (s1, s2) -> {
			if (s1.length() == s2.length()) {
				return s1.compareTo(s2);
			} else {
				return s1.length() - s2.length();
			}
		});

		for (int i = 1; i < N; i++) {
			if (!str[i].equals(str[i - 1])) {
				System.out.println(str[i]);
			}
		}
	}
}
