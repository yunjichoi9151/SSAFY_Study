import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu_Renewal {
    static int[] cnt;
    static Map<String, Integer> map;
    public String[] solution(String[] orders, int[] course) {
        // String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        // int[] course = {2, 3, 4};
        // ans : 코스요리 메뉴 구성
        String[] ans = {};
        // map : 문자조합, 빈도
        map = new HashMap<>();
        // cnt : 각 문자열 길이마다 최대 빈도 저장
        cnt = new int[course.length];
        for(int i = 0; i < course.length; i++) {
            for(int j = 0; j < orders.length; j++) {
                // tmp : 1명이 주문한 단품메뉴 조합
                char tmp[] = orders[j].toCharArray();
                // 알파벳 순으로 정렬
                Arrays.sort(tmp);
                // System.out.println("search(0, " + course[i] + ", '', " + tmp.toString() + ", " + i + ")");
                // tmp과 course 기준으로 함수 돌리기
                search(0, course[i], new String(), tmp, i);
            }
        }
        // list : 조건에 맞는 조합들 추가
        List<String> list = new ArrayList<>();
        for(int i = 0; i < course.length; i++) {
            // System.out.println("this course is " + course[i]);
            for(Map.Entry<String, Integer> m : map.entrySet()) {
                // System.out.println("map<" + m.getKey() + ", " + m.getValue() + ">");
                // 두 명 이상 주문했고, 코스 종류와 길이가 같고, value가 최대 빈도값과 같은 경우
                if(cnt[i] >= 2 && course[i] == m.getKey().length() && m.getValue() == cnt[i]) {
                    // System.out.println("Add in list");
                    // list에 추가
                    list.add(m.getKey());
                }
            }
        }
        // 오름차순 정렬
        Collections.sort(list);
        // list를 배열로 형변환
        ans = list.toArray(new String[list.size()]);
        // for(int i = 0; i < ans.length; i++) {
        //     System.out.println(ans[i]);
        // }
        // 답 return
        return ans;
    }
    static void search(int idx, int len, String s, char arr[], int cntIdx) {
        // 구하는 조합 길이와 같다면
        if(s.length() == len) {
            // System.out.println("length is same as " + len);
            // map.put(s(key), s의 값이 존재하면 s의 value를 넣어주고 없다면 0 & +1)
            map.put(s, map.getOrDefault(s, 0) + 1);
            // 더 큰 값으로 갱신해줌
            // 나중에 출력할 조합을 선정할 때 이 최댓값만큼 나왔던 것들로 고를 예정
            cnt[cntIdx] = Math.max(cnt[cntIdx], map.get(s));
            // System.out.println("cnt[" + cntIdx + "] = " + cnt[cntIdx]);
            return;
        }
        // 
        for(int i = idx; i < arr.length; i++) {
            // System.out.println("search(" + (i + 1) + ", " + len + ", " + (s + arr[i]) + ", " + arr.toString() + ", " + cntIdx + ")");
            // 한 글자씩 s에 추가하며 탐색
            search(i + 1, len, s + arr[i], arr, cntIdx);
        }
    }
}