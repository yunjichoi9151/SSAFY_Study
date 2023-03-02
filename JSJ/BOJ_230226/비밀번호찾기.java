package 백준;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 비밀번호찾기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String address = sc.next();
            String pw = sc.next();

            map.put(address, pw);
        }

        for(int i =0; i< M; i++){
            String findAddress = sc.next();
            System.out.println(map.get(findAddress));
        }
    }
}
