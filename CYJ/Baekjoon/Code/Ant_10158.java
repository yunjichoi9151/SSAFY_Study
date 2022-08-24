package Silver_4.Java_files.Code;

import java.util.Scanner;

public class Ant_10158 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt(), h = sc.nextInt();
        int p = sc.nextInt(), q = sc.nextInt();
        int t = sc.nextInt();
        int dir = 1;
        for(int tc = 1; tc <= t; tc++) {
            System.out.println("dir is "+ dir);
            if(dir == 1) {
                if(p == w && q == h) {
                    dir = 2;
                    System.out.println("1 -> 2");
                }
                else if(p == w) {
                    dir = 3;
                    System.out.println("1 -> 3");
                }
                else if(q == h) {
                    dir = 4;
                    System.out.println("1 -> 4");
                }
            }
            else if(dir == 2) {
                if(p == 0 && q == 0) {
                    dir = 1;
                    System.out.println("2 -> 1");
                }
                else if(p == 0) {
                    dir = 4;
                    System.out.println("2 -> 4");
                }
                else if(q == 0) {
                    dir = 3;
                    System.out.println("2 -> 3");
                }
            }
            else if(dir == 3) {
                if(p == 0 && q == h) {
                    dir = 4;
                    System.out.println("3 -> 4");
                }
                else if(p == 0) {
                    dir = 1;
                    System.out.println("3 -> 1");
                }
                else if(q == h) {
                    dir = 2;
                    System.out.println("3 -> 2");
                }
            }
            else if(dir == 4) {
                if(p == w && q == 0) {
                    dir = 3;
                    System.out.println("4 -> 3");
                }
                else if(p == w) {
                    dir = 2;
                    System.out.println("4 -> 2");
                }
                else if(q == 0) {
                    dir = 1;
                    System.out.println("4 -> 1");
                }
            }
            switch(dir) {
                case 1: p++; q++;
                        break;
                case 2: p--; q--;
                        break;
                case 3: p--; q++;
                        break;
                case 4: p++; q--;
                        break;
            }
        }
        System.out.println(p + " " + q);
        sc.close();
    }
}
