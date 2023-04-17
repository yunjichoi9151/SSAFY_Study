package 프로그래머스.카카오;

import java.util.HashMap;
public class 성격유형검사하기 {

    public static void main(String[] args) {
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};

        System.out.println( solution(survey, choices));

    }

    static HashMap<Character, Integer> scores;

    public static String solution(String[] survey, int[] choices) {
        String answer = "";

        char[] types = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};

        // 기본값
        scores = new HashMap<>();
        for (int i = 0; i < 8; i++) {
            scores.put(types[i], 0);
        }

        for (int i = 0; i < survey.length; i++) {
            char disagree = survey[i].charAt(0);
            char agree = survey[i].charAt(1);
            int score = choices[i];

            // 비동의
            if (score < 4) {
                score = (score - 4)  * (-1);
                scores.put(disagree, scores.get(disagree) + score);
            } else if (score > 4) { // 동의
                scores.put(agree, scores.get(agree) + (score - 4));
            }
        }

        for (int i = 1; i <= 4; i++) {
            int firstIdx = i * 2 - 2;
            int secondIdx = i * 2 - 1;

            answer += checkType(types[firstIdx], types[secondIdx]);
        }

        return answer;
    }

    // 유형 판별
    private static char checkType(char a, char b) {
        int aScore = scores.get(a);
        int bScore = scores.get(b);

        return aScore >= bScore ? a : b;
    }
}
