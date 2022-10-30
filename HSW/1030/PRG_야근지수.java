package Baekjoon.Programmers;

public class PRG_야근지수 {
    public long solution(int n, int[] works) {
        long answer = 0;
        int sum = 0;    //총 작업량

        for (int i = 0; i < works.length; i++) sum += works[i];

        if (n >= sum) return 0;

        //평탄화 작업
        while (n != 0) {
            int max = Integer.MIN_VALUE;

            //남은 일 중에 가장 큰 값
            for (int i = 0; i < works.length; i++) {
                if (max < works[i]) max = works[i];
            }

            //최대값부터 하나씩 빼주기
            for (int i = 0; i < works.length; i++) {
                if (works[i] == max) {
                    works[i]--;
                    n--;
                    if (n == 0) break;
                }
            }
        }

        for (int i = 0; i < works.length; i++) answer += Math.pow(works[i], 2);

        return answer;
    }
}
