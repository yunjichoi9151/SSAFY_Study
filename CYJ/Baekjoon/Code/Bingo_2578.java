package Silver_4.Java_files.Code;

import java.util.Scanner;

public class Bingo_2578 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr1 = new int[5][5];
        int[][] arr2 = new int[5][5];
        int cnt = 0;
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                arr1[i][j] = sc.nextInt();
            }
        }
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                arr2[i][j] = sc.nextInt();
            }
        }
        Loop2:
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                int sum1 = 0, sum2 = 0, sum3 = 0, sum4 = 0;
                Loop1:
                for(int r = 0; r < 5; r++) {
                    for(int k = 0; k < 5; k++) {
                        if(arr1[r][k] == arr2[i][j]) {
                            arr1[r][k] = 0;
                            if(i * 5 + j < 12) {
                                System.out.println("Not yet");
                                break Loop1;
                            }
                        }
                        System.out.print(arr1[r][k] + " ");
                    }
                    System.out.println();                    
                }
                System.out.println();
                for(int r = 0; r < 5; r++) {
                    for(int k = 0; k < 5; k++) {
                        sum1 += arr1[r][k];
                        sum2 += arr1[k][r];
                    }
                    System.out.println("sum1 is " + sum1 + ", sum2 is " + sum2);
                    if(sum1 == 0) {
                        cnt++;
                        System.out.println("sum1 is 0");
                    }
                    if(sum2 == 0) {
                        cnt++;
                        System.out.println("sum2 is 0");
                    }
                    sum1 = 0;
                    sum2 = 0;
                }
                sum3 = arr1[0][4] + arr1[1][3] + arr1[2][2] + arr1[3][1] + arr1[4][0];
                sum4 = arr1[0][0] + arr1[1][1] + arr1[2][2] + arr1[3][3] + arr1[4][4];
                if(sum3 == 0) {
                    cnt++;
                    System.out.println("sum3 is 0");
                }
                if(sum4 == 0) {
                    cnt++;
                    System.out.println("sum4 is 0");
                }
                if(cnt == 3) {
                    System.out.println(i * 5 + j + 1);
                    break Loop2;
                }
                cnt = 0;
            }
        }
        // Loop1:
        // for(int i = 0; i < 25; i++) {
        //     int cnt2 = 0;
        //     if(arr1[0][4] + arr1[1][3] + arr1[2][2] + arr1[3][1] + arr1[4][0] == 0) {
        //         cnt2++;
        //         System.out.println("In case 1 : cnt2++");
        //     }
        //     if(arr1[0][0] + arr1[1][1] + arr1[2][2] + arr1[3][3] + arr1[4][4] == 0) {
        //         cnt2++;
        //         System.out.println("In case 2 : cnt2++");
        //     }
        //     Loop2:
        //     for(int j = 0; j < 5; j++) {
        //         int sum1 = 0, sum2 = 0;
        //         for(int k = 0; k < 5; k++) {
        //             if(i < 12) {
        //                 if(arr2[i] == arr1[j][k]) {
        //                     System.out.println("I am in case1 arr1[" + j + "][" + k + "] is " + arr1[j][k]);
        //                     arr1[j][k] = 0;
        //                     System.out.println("I change to 0, and will break Loop2");
        //                     break Loop2;
        //                 }
        //             }
        //             else {
        //                 if(arr2[i] == arr1[j][k]) {
        //                     System.out.println("I am in case2 arr1[" + j + "][" + k + "] is " + arr1[j][k]);
        //                     arr1[j][k] = 0;
        //                 }
        //                 sum2 += arr1[j][k];
        //                 sum1 += arr1[k][j];
        //                 System.out.println("sum1 is " + sum1 + ", sum2 is " + sum2);
                        
        //                 if(k == 4 && (sum1 == 0 || sum2 == 0)) {
        //                     cnt++;
        //                     System.out.println("cnt++!!");
        //                 }
        //             }
        //             if((cnt + cnt2) == 3) {
        //                 System.out.println(i + 1);
        //                 break Loop1;
        //             }
        //         }
        //     }
        // }
        sc.close();
    }    
}
