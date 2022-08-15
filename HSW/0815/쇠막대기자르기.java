package Baekjoon.SWEA;

import java.util.Scanner;

public class 쇠막대기자르기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        for (int k = 1; k <= tc; k++) {
            String input = sc.next();
            String output = input.replace("()", "*");   //레이저 쏘는 위치

            int num = 0;
            int sum = 0;

            for (int i = 0; i < output.length(); i++) {
                //레이저로 잘릴때마다 쌓여있는 쇠막대기 층수만큼 합산
                if (output.charAt(i) == '*') {
                    sum += num;
                }
                //쇠막대기 층수 세기
                else if (output.charAt(i) == '(') {
                    num++;
                    sum++;
                }
                //쇠막대기 층수 빼기
                else if (output.charAt(i) == ')') {
                    num--;
                }
            }

            System.out.println("#" + k + " " + sum);
        }
    }
}
