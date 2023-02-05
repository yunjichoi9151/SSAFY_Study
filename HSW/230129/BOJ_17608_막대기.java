package Baekjoon.Bronze;

import java.util.Scanner;
import java.util.Stack;

public class BOJ_17608_막대기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            stack.push(sc.nextInt());
        }

        int st = stack.pop(); //제일 오른쪽 숫자

        int cnt = 1;
        int curr = 0;
        while (!stack.isEmpty()) {
            curr = stack.pop();
            if (curr > st) {
                st = curr;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
