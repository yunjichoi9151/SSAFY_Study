package Baekjoon.Programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class PRG_오픈채팅방 {
    public String[] solution(String[] record) {
        HashMap<String, String> user = new HashMap<>(); //유저 정보를 담을 해시맵
        ArrayList<String> log = new ArrayList<>();

        //모든 입력에 대해 역할 수행
        for (String input : record) {
            StringTokenizer st = new StringTokenizer(input, " ");

            String com = st.nextToken();
            String uid = st.nextToken();
            String nick = "";
            if (!com.equals("Leave"))
                nick = st.nextToken();

            switch (com) {
                case "Enter":
                    user.put(uid, nick);
                    log.add(uid + "님이 들어왔습니다.");
                    break;
                case "Change":
                    user.replace(uid, nick);
                    break;
                case "Leave":
                    log.add(uid + "님이 나갔습니다.");
                    break;
                default:
                    break;
            }
        }

        String[] answer = new String[log.size()];
        int idx = 0;

        for (String str : log) {
            int e = str.indexOf("님");
            String uid = str.substring(0, e);
            answer[idx++] = str.replace(uid, user.get(uid));
        }

        return answer;
    }
}
