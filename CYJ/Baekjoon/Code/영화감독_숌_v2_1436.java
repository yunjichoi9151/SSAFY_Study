import java.util.Scanner;

public class 영화감독_숌_v2_1436 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int tmp = 0;
        int target_num = 666;
        while(tmp != n) {
            if(String.valueOf(target_num).contains("666")) {
                tmp++;
            }
            target_num++;
        }
        System.out.println(target_num - 1);
    }
}