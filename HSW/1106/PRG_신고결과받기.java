package Baekjoon.Programmers;

import java.util.HashMap;
import java.util.HashSet;

public class PRG_신고결과받기 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length]; //유저수 만큼 생성
        HashMap<String, HashSet<String>> reportMap = new HashMap<>();
        HashMap<String, Integer> reportCnt = new HashMap<>();   //유저별 신고당한 횟수 저장할 맵

        for (String str : report) {
            String reporter = str.split(" ")[0]; //신고자
            String reported = str.split(" ")[1]; //피고자
            reportMap.putIfAbsent(reporter, new HashSet<String>() {
                {
                    add(reported);
                }
            });
            reportMap.get(reporter).add(reported);
            reportCnt.put(reported, reportCnt.getOrDefault(reported, 0) + 1);
        }


        for (String reported : reportCnt.keySet()) {
            int cnt = reportCnt.get(reported);
            if (cnt >= k) {
                for (int i = 0; i < id_list.length; i++) {
                    if (reportMap.containsKey(id_list[i]) && reportMap.get(id_list[i]).contains(reported))
                        answer[i]++;
                }
            }
        }

        return answer;
    }
}
