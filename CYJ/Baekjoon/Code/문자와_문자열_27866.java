import java.util.Scanner;

public class 문자와_문자열_27866 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] arr = s.toCharArray();
        int n = sc.nextInt();
        System.out.println(arr[n - 1]);
        sc.close();
    }
}
