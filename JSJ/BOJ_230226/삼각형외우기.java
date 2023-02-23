package 백준;

import java.util.Scanner;

public class 삼각형외우기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        String triangle = "Error";

        if (a == 60 && b == 60 && c == 60) triangle = "Equilateral";
        else if (a + b + c == 180 && a == b || a + b + c == 180 && a == c || a + b + c == 180 && c == b)
            triangle = "Isosceles";
        else if (a + b + c == 180 && a != b && a != c && c != b) triangle = "Scalene";

        System.out.println(triangle);
    }
}
