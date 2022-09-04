package week7;

import java.util.Scanner;

public class 직각삼각형의두변 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = "";
		int cnt = 0;

		while (!str.equals("0 0 0")) { // 0 0 0 이 들어올 때까지 반복
			str = sc.nextLine();
			String[] abc = str.split(" ");

			// 0 0 0 이 들어오면 break
			if (str.equals("0 0 0"))
				break;

			int s = -1; // a,b,c
			double l = -1; // 길이

			for (int i = 0; i < abc.length; i++) {
				if (abc[i].equals("-1")) { // 요소가 -1일때 s 갱신
					s = i;
				}

				if (s == 2) {
					l = Math.sqrt((Math.pow(Integer.parseInt(abc[0]), 2) + Math.pow(Integer.parseInt(abc[1]), 2)));
					break;
				} else if (s == 0 && Integer.parseInt(abc[1]) < Integer.parseInt(abc[2])) {
					l = Math.sqrt((Math.pow(Integer.parseInt(abc[2]), 2) - Math.pow(Integer.parseInt(abc[1]), 2)));
					break;
				} else if (s == 1 && Integer.parseInt(abc[0]) < Integer.parseInt(abc[2])) {
					l = Math.sqrt((Math.pow(Integer.parseInt(abc[2]), 2) - Math.pow(Integer.parseInt(abc[0]), 2)));
					break;
				}

			}

			// 출력용 ch
			char ch = ' ';

			switch (s) {
			case 0:
				ch = 'a';
				break;
			case 1:
				ch = 'b';
				break;

			default:
				ch = 'c';
				break;
			}

			// 출력
			System.out.println("Triangle #" + ++cnt);
			if (l != -1) {
				System.out.printf("%c = %.3f \n", ch, l); // 소수점 셋째자리까지 출력
			} else {
				System.out.println("Impossible.");
			}
			System.out.println();

		}
	}
}
