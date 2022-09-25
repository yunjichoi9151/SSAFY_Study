package Silver_1.Java_files.Code;

import java.util.Scanner;

public class Z_1074 {
    // answer 값 저장
    static int cnt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), r = sc.nextInt(), c = sc.nextInt();
        // num에 2^n 값 저장
        int num = (int)Math.pow(2, n);
        // 탐색
        find(r, c, num);
        System.out.println(cnt);
        sc.close();
    }

    public static void find(int y, int x, int num) {
        // 최종적으로 1칸이 남으면 return
        if(num == 1) {
            return;
        }
        if(x >= 0 && x < num / 2) {
            // 구역 1
            if(y >= 0 && y < num / 2) {
                // 시작값 조정 안함(1구역)
                // num값 조정
                find(y, x, num / 2);
            }
            // 구역 3
            else if(y >= num / 2 && y < num) {
                // 시작값 조정
                cnt += 2 * ((num * num) / 4);
                // y와 num값 조정
                find(y - num / 2, x, num / 2);
            }
        }
        else if(x >= num / 2 && x < num) {
            // 구역 2
            if(y >= 0 && y < num / 2) {
                // 시작값 조정
                cnt += (num * num) / 4;
                // x와 num값 조정
                find(y, x - num / 2, num / 2);
            }
            // 구역 4
            else if(y >= num / 2 && y < num) {
                // 시작값 조정
                cnt += ((num * num) / 4) * 3;
                // y, x, num값 조정
                find(y - num / 2, x - num / 2, num / 2);
            }
        }
    }
}
