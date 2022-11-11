package pracprac.programmers.study.d1106;
//해시맵 사용해서 정보 저장하기 : 중복 거르기 위함
//한명의 유저가 같은 유저를 여러번 신고할 경우 1회처리
//

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class 신고결과받기 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        //신고된 id, 신고자id
        Map<String, HashSet<String>> map = new HashMap<>(); //set사용해서 중복을 거른다
        //신고된 id, 메일 수
        Map<String, Integer> idxMap = new HashMap<>();
        
        //초기세팅
        for (int i = 0; i < id_list.length; i++) {
            String name = id_list[i];
            map.put(name, new HashSet<>());
            idxMap.put(name, i);
        }
        
        //맵에 저장
        for (String s : report) {
            String[] str = s.split(" ");
            String from = str[0];
            String to = str[1];
            map.get(to).add(from);
        }
        
        //정지 결과를 세팅
        for (int i = 0; i < id_list.length; i++) {
            HashSet<String> send = map.get(id_list[i]);
            if (send.size() >= k) { //신고된 횟수가 k번 이상일 경우 answer에 저장
                for (String name : send) {
                    answer[idxMap.get(name)]++;
                }
            }
        }
        return answer;
    }
}
