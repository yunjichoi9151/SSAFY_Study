package Baekjoon.Gold;

import java.util.Scanner;

public class BOJ_17069_파이프옮기기2 {
    /*
        전체 지도와 똑같은 크기의 배열 res[][]을 하나 더 생각해보자
        각 칸에 그 칸까지 도달할 수 있는 방법의 수를 저장한다면

        res[a][b]에 도달하는 방법의 수는
        res[a][b] = res[a-1][b] + res[a][b-1] + res[a-1][b-1]뿐이다
        왜냐하면 파이프가 이동할 수 있는건 가로, 세로, 대각선뿐이니까

        -> 풀면서 추가사항
        파이프의 상태(가로, 세로, 대각선)에 따라 나눠서 정리하는게 낫다
        파이프의 상태에 따라 이동방식이나 중간에 벽이 끼어있을 때 제약이 달라지기 때문에
     */

    static int N;

    static int[][] arr;
    static long[][][] res;  //결과값이 int형 범위를 넘어가기 때문에 long으로 해야함!


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        arr = new int[N][N];
        //마지막 인덱스 : 파이프의 상태
        //0: 가로, 1:세로, 2:대각선
        res = new long[N][N][3];


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        //맨 윗줄 가로방향만 설정해줌
        for (int i = 1; i < N; i++) {
            res[0][i][0] = 1;
            if (arr[0][i] == 1) {
                res[0][i][0] = 0;
                break;
            }
        }

        //행은 위에서 2번째줄부터니까 i=1부터
        for (int i = 1; i < N; i++) {
            //j=1을 해도 2번째열까지는 어떤 모양의 파이프도 올 수가 없기 때문에 연산을 줄이기 위해 j=2부터 시작
            for (int j = 2; j < N; j++) {
                //가로로 올 수 있는 경우의 수 = 왼쪽칸에서 가로로 오기 + 왼쪽칸에서 대각선으로 오기
                //벽이 있는 경우를 생각하면서
                if (arr[i][j] != 1) {
                    res[i][j][0] = res[i][j - 1][0] + res[i][j - 1][2];
                    res[i][j][1] = res[i - 1][j][1] + res[i - 1][j][2];
                    if (arr[i - 1][j] != 1 && arr[i][j - 1] != 1) {
                        res[i][j][2] = res[i - 1][j - 1][0] + res[i - 1][j - 1][1] + res[i - 1][j - 1][2];
                    }
                }
            }
        }

        //가로 + 세로 + 대각선 상태로 마지막 칸에 있을 경우의 수를 전부 더해준다
        System.out.println(res[N - 1][N - 1][0] + res[N - 1][N - 1][1] + res[N - 1][N - 1][2]);
    }
}