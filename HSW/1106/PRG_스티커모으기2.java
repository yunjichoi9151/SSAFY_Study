package Baekjoon.Programmers;

public class PRG_스티커모으기2 {
    public int solution(int[] sticker) {
        if (sticker.length == 1) return sticker[0];

        int[] dp1 = new int[sticker.length + 2];
        int[] dp2 = new int[sticker.length + 2];

        //두번째 스티커를 뗀 경우
        for (int i = 3; i < dp1.length; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + sticker[i - 2]);
        }

        //첫번째 스티커를 뗀 경우
        for (int i = 2; i < dp2.length; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + sticker[i - 2]);
        }


        int answer = Math.max(dp1[dp1.length - 1], dp2[dp2.length - 2]);


        return answer;
    }
}
