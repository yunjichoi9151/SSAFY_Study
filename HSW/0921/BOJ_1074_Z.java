package Baekjoon.Silver;
/*
    2^N = 1<<N
    재귀하는 함수를 만들어서 인자값이 1보다 크면 절반 나누는 식으로 계속
    4개의 함수를 넣어야함
    void func(int[] arr, int N)이렇게 넣으면

 */


import java.util.Scanner;

public class BOJ_1074_Z {
    static int[][] arr;


    static void func(int r, int c, int size) {
        if (size == 1) {
            arr[r][c] = r * (1 << size) + c * (1 << (size - 1));
            arr[r][c + 1] = arr[r][c] + 1;
            arr[r + 1][c] = arr[r][c] + 2;
            arr[r + 1][c + 1] = arr[r][c] + 3;
            return;
        }

        func(0, 0, size / 2);
        func(0, 1 << (size / 2), size / 2);
        func(1 << (size / 2), 0, size / 2);
        func(1 << (size / 2), 1 << (size / 2), size / 2);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();

        arr = new int[1 << N][1 << N];

        func(0, 0, N);

        System.out.println(arr[r][c]);
    }
}
