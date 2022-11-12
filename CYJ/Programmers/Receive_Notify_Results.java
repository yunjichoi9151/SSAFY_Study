import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Receive_Notify_Results {
    public int[] solution(String[] id_list, String[] report, int k) {
        // num : 유저 id 개수
        int num = id_list.length;
        // ans : 정답 배열
        int[] ans = new int[num];
        // reported : <신고당한 사람 id, 이 id를 신고한 사람들 id 목록>
        Map<String, Set<String>> reported = new HashMap<>();
        // cnt : 각 id가 신고당한 횟수
        Map<String, Integer> cnt = new HashMap<>();

        // 각 Map에 유저 id를 key값으로 넣어줌
        for(int i = 0; i < num; i++) {
            reported.put(id_list[i], new HashSet<>());
            cnt.put(id_list[i], 0);
        }

        for(int i = 0; i < report.length; i++) {
            // rs[0] : 신고한 유저 id
            // rs[1] : 신고당한 유저 id
            String[] rs = report[i].split(" ");
            // tmp1 : 신고당한 유저 id에 신고한 유저 id 값 저장
            Set<String> tmp1 = reported.get(rs[1]);
            tmp1.add(rs[0]);
            // System.out.println("reported : " + rs[1] + " <= " + reported.get(rs[1]));
        }

        for(int i = 0; i < num; i++) {
            // tmp2 : reported에서 각 id에 해당하는 value값
            Set<String> tmp2 = reported.get(id_list[i]);
            // 해당 id를 신고한 사람이 k명 이상이라면
            if(tmp2.size() >= k) {
                // 해당 id를 신고한 사람의 목록을 하나씩 가져옴
                for(String s : tmp2) {
                    // val : s가 현재 받을 처리 결과 메일 개수
                    Integer val = cnt.get(s);
                    // 메일 개수 증가
                    cnt.replace(s, val + 1);
                    // System.out.println("s is " + s + ", now val is " + (val + 1));
                }
            }
        }
        // 정답 배열에 각각의 id가 받을 메일 개수 저장
        for(int i = 0; i < num; i++) {
            ans[i] = cnt.get(id_list[i]);
        }
        return ans;
    }
}
