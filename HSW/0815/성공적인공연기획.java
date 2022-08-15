package Baekjoon.SWEA;

import java.util.Scanner;

public class 성공적인공연기획 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        for (int k = 1; k <= tc; k++) {
            //문자열 입력
            char[] people = sc.next().toCharArray();
            //정수형으로 변환할 배열
            int[] cnt = new int[people.length];

            //정수형으로 변환
            for (int i = 0; i < people.length; i++) {
                if (i == 0) {
                    cnt[i] = people[i] - '0';
                }
                //이전에 박수치고 있는 사람 카운트
                else {
                    cnt[i] = cnt[i - 1] + people[i] - '0';
                }
            }

            int sum = 0; //추가로 고용해야할 사람
            for (int i = 0; i < people.length; i++) {
                //사람이 모자를 경우
                if (cnt[i] + sum < i + 1) {
                    sum += (i + 1 - cnt[i] - sum);
                }
            }
            System.out.println("#" + k + " " + sum);
        }
    }
}
