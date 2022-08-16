package Java_files.Code;

import java.util.Scanner;

public class Danjo_Bigger_Number_6190 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int tc = 1; tc <= t; tc++) {
            int n = sc.nextInt();
            int[] arr1 = new int[n];
            int tmp = 0, res = 0;
            for(int i = 0; i < n; i++) {
                arr1[i] = sc.nextInt();
            }
            for(int i = 0; i < n - 1; i++) {
                for(int j = i + 1; j < n; j++) {
                    tmp = arr1[i] * arr1[j];
                    String stmp = tmp + "";
                    int cnt = 0;
                    for(int k = 0; k < stmp.length() - 1; k++) {
                        if(stmp.charAt(k) <= stmp.charAt(k + 1)) {
                            cnt++;
                        }
                        else {
                            break;
                        }
                    }
                    if((cnt == stmp.length() - 1) && tmp > res) {
                        res = tmp;
                    }
                }
            }
            if(res < 10) {
                res = -1;
            }
            System.out.println("#" + tc + " " + res);
        }
        sc.close();
    }
}

