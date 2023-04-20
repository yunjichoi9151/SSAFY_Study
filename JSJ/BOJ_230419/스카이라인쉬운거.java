package 백준.boj_0419;

import java.io.*;
import java.util.Scanner;
import java.util.Stack;

public class 스카이라인쉬운거 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int cnt = 0;

        int N = sc.nextInt();
        int[] arr = new int[N+1];
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr[i] = y;
        }

        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i <= N; i++) {
            while (!stack.empty() && stack.peek() > arr[i]) {
                cnt += 1;
                stack.pop();
            }

            if (!stack.empty() && stack.peek() == arr[i])
                continue;

            stack.push(arr[i]);
        }

        System.out.println(cnt);
    }
}

