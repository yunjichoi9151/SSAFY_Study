package pracprac.programmers.study;
//해시맵을 사용해야함 (id는 변하지 않고, 닉네임만 변함)
//https://taehoung0102.tistory.com/60
//효율성 체크  : 일일히 닉네임 바꾸지 말고  id값을 기억해두고 기록을 순회한 뒤 
//맵에 저장된 닉네임 값으로 바꿔주기
import java.util.*;

public class 오픈채팅방 {
    public String[] solution(String[] record) {
        //결과기록용
        List<String> result = new ArrayList<>();
        //key : id  & value : 닉네임
        Map<String, String> id = new HashMap<>();
        
        for(int i=0; i<record.length; i++){
            String[] tmp = record[i].split(" ");
            //enter일때
            if(tmp[0].equals("Enter")){
            	//동일한 id가 다시 들어오면 닉네임 바꾸기
                id.put(tmp[1], tmp[2]);
                result.add(tmp[1]+"님이 들어왔습니다.");
            }
            //leave
            else if(tmp[0].equals("Leave")){
                result.add(tmp[1]+"님이 나갔습니다.");
            }
            //change
            else if(tmp[0].equals("Change")){
                id.replace(tmp[1], tmp[2]);
            }            
        }
        
        //결과를 닉네임으로 수정
        String[] answer = new String[result.size()];
        for(int i=0; i<result.size(); i++){
        	//id만 가져가기 위해 0~님까지 빼기
            int idx = result.get(i).indexOf("님");
            String idid = result.get(i).substring(0, idx);
            answer[i] = id.get(idid)+result.get(i).substring(idx);
        }
        
        return answer;
    }
}