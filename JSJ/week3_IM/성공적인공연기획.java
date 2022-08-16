package week3_IM;

import java.util.Scanner;

public class 성공적인공연기획 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			String str = sc.next();
			
			int People = 0;
			int partTime = 0;

			for (int i = 0; i < str.length(); i++) {
				if (People < i) {
					partTime++;
					People++;
				}
				People += str.charAt(i) - '0';
			}

			System.out.println("#" + t + " " + partTime);
			
			partTime = 0;
			People = 0;
		}

	}
}
