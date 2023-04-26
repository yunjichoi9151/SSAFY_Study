package 백준.boj_0424;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 조건 추가
public class 문자열폭발 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String bomb = br.readLine();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            sb.append(ch);

            if (sb.length() >= bomb.length()) {    // sb의 길이가 bomb 이상이 되면 확인
                boolean sameFlag = true;

                for (int j = 0; j < bomb.length(); j++) {
                    char ch1 = sb.charAt(sb.length() - bomb.length() + j);
                    char ch2 = bomb.charAt(j);
                    if (ch1 != ch2) {
                        sameFlag = false;
                        break;
                    }
                }

                if (sameFlag) {
                    // 폭발 문자열 삭제
                    sb.delete(sb.length() - bomb.length(), sb.length());
                }
            }
        }
        System.out.println(sb.length() == 0 ? "FRULA" : sb.toString());
    }
}