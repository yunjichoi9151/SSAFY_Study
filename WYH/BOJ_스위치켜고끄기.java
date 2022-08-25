package day0823;

import java.util.Scanner;

public class BOJ_스위치켜고끄기 {
	public static void main(String[] args) {
		// 1 on 2 off

		// 스위치 개수
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] light = new int[num];
		for (int i = 0; i < num; i++) {
			light[i] = sc.nextInt();
		}
		int stu = sc.nextInt();
		int[][] student = new int[stu][2];
		for (int i = 0; i < stu; i++) {
			student[i][0] = sc.nextInt(); // 학생 성별
			student[i][1] = sc.nextInt(); // 학생이 받은 수
			// 1이면 남 2이면 여

		}
		for (int i = 0; i < stu; i++) {
			if (student[i][0] == 1) {
				for (int j = 0; j < num; j++) {
					if ((j + 1) % student[i][1] == 0)
						light[j] = light[j] == 0 ? 1 : 0;
				}
			} 
			else {
				light[student[i][1] - 1] = light[student[i][1] - 1] == 0 ? 1 : 0;
				for (int k = 1; k < num / 2; k++) {
					if (student[i][1] - 1 - k >= 0 && student[i][1] - 1 + k < num
							&& light[student[i][1] - 1 - k] == light[student[i][1] - 1 + k]) {
						light[student[i][1] - 1 - k] = light[student[i][1] - 1 - k] == 0 ? 1 : 0;
						light[student[i][1] - 1 + k] = light[student[i][1] - 1 + k] == 0 ? 1 : 0;

					}
					else break;
				}
			}

		}
		for (int i = 0; i < num; i++) {
			System.out.print(light[i] + " ");
			if((i+1) % 20 == 0) System.out.println();
		}
	}

}
