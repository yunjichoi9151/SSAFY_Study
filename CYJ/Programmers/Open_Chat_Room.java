import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Open_Chat_Room {
    public String[] solution(String[] record) {
        // map : id와 닉네임 저장
        Map<String, String> map = new HashMap<>();
        // log : log 기록
        List<String[]> log = new LinkedList<>();
        int idx = 0;
        for(int i = 0; i < record.length; i++) {
            String[] words = record[i].split(" ");
            // Enter인 경우 id를 map에 저장하고, log에 추가
            if(words[0].equals("Enter")) {
                map.put(words[1], words[2]);
                log.add(words);
            } else if(words[0].equals("Change")) {
                // Change인 경우 닉네임 업데이트만 해줌
                map.put(words[1], words[2]);
            } else if(words[0].equals("Leave")) {
                // Leave인 경우 log에만 추가
                log.add(words);
            }
        }
        String[] answer = new String[log.size()];
        // 출력
        for(String[] word : log) {
            String name = map.get(word[1]);
            if(word[0].equals("Enter")) {
                answer[idx++] = name + "님이 들어왔습니다.";
            } else if(word[0].equals("Leave")) {
                answer[idx++] = name + "님이 나갔습니다.";
            }
        }
        return answer;
    }
}
