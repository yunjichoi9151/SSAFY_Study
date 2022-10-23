import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> nickId = new HashMap<>();
        int count = 0; 
        
        for(int i = 0; i < record.length; i++){
            String[] info = record[i].split(" ");
            
            if(info[0].equals("Leave")){        // 나가는 경우
                continue;
            } else if(info[0].equals("Enter")){ // 들어오는 경우
                nickId.put(info[1], info[2]);
            } else {                            // 닉네임을 변경하는 경우
                nickId.put(info[1], info[2]);
                count++;
            }
        }
        
        String[] answer = new String[record.length - count];
        int idx = 0;
        
        for(int i = 0; i < record.length; i++){
            String[] info = record[i].split(" ");
            String nickname = idMap.get(info[1]);
            
            if(info[0].equals("Enter")){                      // 들어오는 경우
                answer[idx++] = nickname + "님이 들어왔습니다.";
            } else if(info[0].equals("Leave")){               // 나가는 경우
                answer[idx++] = nickname + "님이 나갔습니다.";
            }
        }
        
        return answer;
    }
}