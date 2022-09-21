package Gold_4.Java_files.Code;

import java.util.Scanner;

public class Matrix_Square_10830 {
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // n : 행렬의 크기
        n = sc.nextInt();
        // b : B제곱
        long b = sc.nextLong();
        // 주어진 행렬
        int[][] arr = new int[n][n];
        // 결과값 담을 행렬
        int[][] res = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
            // (i, i) 부분 초기값 1로 담아줌
            // 이렇게 하면 어떤 행렬이랑 res를 곱하면 행렬이 그대로 담아짐
            res[i][i] = 1;
        }
        // ex) 11일 경우 -> 1) 처음 if문에서 res = arr
        //                  2) arr = arr * arr
        //                  3) b = 5
        //                  4) if문에서 res = arr * (arr * arr)
        //                  5) arr = (arr * arr) * (arr * arr)
        //                  6) b = 2
        //                  7) arr = ((arr * arr) * (arr * arr)) * ((arr * arr) * (arr * arr))
        //                  8) b = 1
        //                  9) if문에서 res = (arr * (arr * arr)) * ((arr * arr) * (arr * arr)) * ((arr * arr) * (arr * arr))
        while(b > 0) {
            // 홀수일 경우
            if(b % 2 == 1) {
                // 결과로 나온 값에서 한번 더 arr 곱해줌
                res = calculate(res, arr);
            }
            // arr에 arr 곱해줌
            arr = calculate(arr, arr);
            b /= 2;
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
        sc.close();
    }

    public static int[][] calculate(int[][] matrix1, int[][]matrix2) {
        // 결과값 담을 배열
        int[][] result = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < n; k++) {
                    // 행렬의 제곱 담기
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                    // 1000으로 나눈 나머지 담기
                    result[i][j] %= 1000;
                }
            }
        }
        return result;
    }
}
