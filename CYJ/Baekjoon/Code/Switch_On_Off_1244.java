package Silver_3.Java_files.Code;

import java.util.Scanner;

public class Switch_On_Off_1244 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt() + 1;
        int[] arr = new int[s];
        for(int i = 1; i < s; i++) {
            arr[i] = sc.nextInt();
        }
        int n = sc.nextInt();
        for(int i = 1; i <= n; i++) {
            int g = sc.nextInt();
            int s1 = sc.nextInt();
            if(g == 1) {
                for(int j = s1; j < s; j += s1) {
                    arr[j] ^= 1;
                }
            }
            else if(g == 2) {
                int l = s1 - 1;
                int r = s1 + 1;
                while(true) {
                    if(l < 1 || r >= s) break;
                    if(arr[l] != arr[r]) break;
                        l--; r++;
                }
                l++; r--;
                while(l <= r) {
                    arr[l] ^= 1;
                    l++;
                }
            }
        }
        for(int i = 1; i < s; i++) {
            System.out.print(arr[i] + " ");
            if(i % 20 == 0)
                System.out.println();
        }
        sc.close();
    }
}


// public class Switch_On_Off_1244 {
//     static int[] arr;
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int s = sc.nextInt();
//         arr = new int[s + 1];
//         for(int i = 1; i < s + 1; i++) {
//             arr[i] = sc.nextInt();
//         }
//         for(int i = 1; i < s + 1; i++) {
//             System.out.println("arr[" + i + "] is " + arr[i]);
//         }
//         int n = sc.nextInt();
//         for(int i = 0; i < n; i++) {
//             int g = sc.nextInt();
//             int s1 = sc.nextInt();
//             if(g == 1) {
//                 System.out.println("male");
//                 for(int j = s1; j < s + 1; j += s1) {
//                     System.out.println("this turn index is " + j + " and arr[j] is " + arr[j]);
//                     turn(j);
//                     System.out.println("new arr[j] is " + arr[j]);
//                 }
//             }
//             else if(g == 2) {
//                 int k = (s1 > s / 2 ? s - s1 : s1);
//                 System.out.println("female");
//                 System.out.println("k is " + k);
//                 if(k != 0) {
//                     for(int j = 1; j <= k; j++) {
//                         System.out.println("forforfor");
//                         if(s1 - j >= 0 && s1 + j <= s) {
//                             System.out.println("forfor");
//                             if(arr[s1 - j] != arr[s1 + j]) {
//                                 System.out.println("for");
//                                 break;
//                             }
//                             System.out.println("this turn index is " + (s1 - j) + " and arr[s1 - j] is " +  arr[s1 - j]);
//                             System.out.println("this turn index is " + (s1 + j) + " and arr[s1 + j] is " +  arr[s1 + j]);
//                             turn(s1 - j);
//                             turn(s1 + j);
//                         }
//                         else
//                             break;
//                     }
//                 }
//                 turn(s1);
//             }
//         }
//         for(int i = 1; i < s + 1; i++) {
//             System.out.print(arr[i] + " ");
//             if(i % 20 == 0)
//                 System.out.println();
//         }
//         sc.close();
//     }
//     static void turn(int x) {
//         if(arr[x] == 1) {
//             arr[x] = 0;
//             System.out.println("switch : on -> off");
//         }
//         else if(arr[x] == 0) {
//             arr[x] = 1;
//             System.out.println("switch : off -> on");
//         }
//     }
// }
