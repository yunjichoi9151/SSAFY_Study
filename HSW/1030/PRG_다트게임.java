package Baekjoon.Programmers;

class PRG_다트게임 {
    public int solution(String dartResult) {
        int answer = 0;

        int[] num = new int[4];

        int idx = 0;
        for (int i = 0; i < dartResult.length(); i++) {
            char ch = dartResult.charAt(i);

            //숫자면 스택에 넣기
            if (ch >= '0' && ch <= '9') {
                if (i < dartResult.length() - 1 && ch == '1' && dartResult.charAt(i + 1) == '0') {
                    num[idx] = 10;
                    i++;    //스킵
                } else
                    num[idx] = ch - '0';
            }
            if (ch == 'S') {
                idx++;
            }
            if (ch == 'D') {
                num[idx] = num[idx] * num[idx];
                idx++;
            }
            if (ch == 'T') {
                num[idx] = num[idx] * num[idx] * num[idx];
                idx++;
            }
            if (ch == '*') {
                if (idx == 1) {
                    num[0] *= 2;
                } else if (idx == 2) {
                    num[0] *= 2;
                    num[1] *= 2;
                } else if (idx == 3) {
                    num[1] *= 2;
                    num[2] *= 2;
                }
            }
            if (ch == '#') {
                num[idx - 1] *= -1;
            }
        }
        for (int i = 0; i < 4; i++) {
            answer += num[i];
        }
        return answer;
    }
}