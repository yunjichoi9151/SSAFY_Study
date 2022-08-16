package D4.Java_files.Code;

import java.util.Scanner;
import java.util.Stack;

public class Cutting_Iron_Bar_5432 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int tc = 1; tc <= t; tc++) {
            String s = sc.next();
            int sum = 0;
            char[] arr = new char[s.length()];
            Stack<Character> stack = new Stack<>();
            for(int i = 0; i < s.length(); i++) {
                arr[i] = s.charAt(i);
            }
            for(int i = 0; i < arr.length; i++) {
                if(arr[i] == '(') {
                    stack.push(arr[i]);
                }
                else {
                    if(arr[i - 1] == '(') {
                        stack.pop();
                        sum += stack.size();
                    }
                    else {
                        stack.pop();
                        sum++;
                    }
                }
            }
            System.out.println("#" + tc + " " + sum);
        }
        sc.close();
    }
/*    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int tc = 1; tc <= t; tc++) {
            String s = sc.next();
            int sl = s.length();
            int cnt = 0, sum = 0;
            String[] arr = new String[sl];
            for(int i = 0; i < sl; i++) {
                arr[i] = s.charAt(i) + "";
                if(i > 0 && arr[i - 1].equals("(") && arr[i].equals(")")) {
                    arr[i - 1] = "<l";
                    arr[i] = "r>";
                }
            }
            for(int i = 0; i < sl; i++) {
                System.out.print(arr[i]);
            }
            System.out.println();
            for(int i = 0; i < sl; i++) {
                if(arr[i].equals(")")) {
                    System.out.println("I found )!!");
                    for(int j = i; j >= 0; j--) {
                        if(arr[j].equals("(")) {
                            System.out.println("I found (!!");
                            for(int k = j; k <= i; k++) {
                                if(arr[k].equals("<l")) {
                                    System.out.println(("I found <l!!"));
                                    cnt++;
                                    System.out.println("cnt is " + cnt);
                                }
                            }
                            arr[i] = "]";
                            arr[j] = "[";
                            System.out.println("I change () to []");
                            break;
                        }
                    }
                    sum += (cnt + 1);
                    cnt = 0;
                    System.out.println("sum is " + sum);
                }
            }
            System.out.println("#" + tc + " " + sum);
        }
    }*/
}
