package Baekjoon.Programmers;

import java.util.*;

public class PRG_메뉴리뉴얼 {
    static HashMap<String, Integer> map;
    static int max;

    //재귀를 이용한 조합 구하는 메소드
    public static void comb(StringBuilder sb, String str, int idx, int cnt, int N) {
        if (cnt == N) {
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            return;
        }

        for (int i = idx; i < str.length(); i++) {
            sb.append(str.charAt(i));
            comb(sb, str, i + 1, cnt + 1, N);
            sb.delete(cnt, cnt + 1);
        }

    }

    public ArrayList<String> solution(String[] orders, int[] course) {

        ArrayList<String> answer = new ArrayList<>();
        //각 문자열 오름차순 정렬
        for (int i = 0; i < orders.length; i++) {
            char[] ch = orders[i].toCharArray();
            Arrays.sort(ch);
            orders[i] = String.valueOf(ch);
        }


        //course 길이 별로 조합을 구해야함
        for (int i = 0; i < course.length; i++) {
            map = new HashMap<>();
            max = Integer.MIN_VALUE;

            for (int j = 0; j < orders.length; j++) {
                StringBuilder sb = new StringBuilder();
                if (course[i] <= orders[j].length()) comb(sb, orders[j], 0, 0, course[i]);
            }

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                max = Math.max(max, entry.getValue());
            }

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (max >= 2 && entry.getValue() == max) answer.add(entry.getKey());
            }
        }
        Collections.sort(answer);


        return answer;
    }
}
