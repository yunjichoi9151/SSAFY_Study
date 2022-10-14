package Gold_5.Java_files.Code;

import java.util.Scanner;

public class Remote_Control_1107 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        // 초기값 설정
        int ans = Math.abs(100 - n);
        // isBroken : 고장났는지 여부 담음
        boolean[] isBroken = new boolean[10];
        for(int i = 0; i < m; i++) {
            // 고장난 번호는 isBroken true로 바꿔줌
            isBroken[sc.nextInt()] = true;
        }
        for(int i = 0; i <= 999999; i++) {
            String tmp = Integer.toString(i);
            boolean check = false;
            for(int j = 0; j < tmp.length(); j++) {
                // 고장난 버튼이라면
                if(isBroken[tmp.charAt(j) - '0']) {
                    check = true;
                    break;
                }
            }
            // 고장난 버튼을 누르지 않았다면
            if(!check) {
                // 번호 누르는 길이 + (+) 혹은 (-)로 조절해야 하는 크기
                ans = Math.min(ans, tmp.length() + Math.abs(i - n));
            }
        }
        // 답 출력
        System.out.println(ans);
        sc.close();
    }
}
