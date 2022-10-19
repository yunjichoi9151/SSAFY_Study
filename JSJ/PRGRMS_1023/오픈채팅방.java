package PRGRMS_1023;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class 오픈채팅방 {
	public static class User {
		String status, userId, nickName;

		public User(String status, String userId, String nickName) {
			super();
			this.status = status;
			this.userId = userId;
			this.nickName = nickName;
		}
	}

	public ArrayList<String> solution(String[] record) {
		ArrayList<String> answer = new ArrayList<>(); // 리턴용

		Queue<User> q = new LinkedList<>(); // 동작 순서대로 넣기
		Map<String, String> map = new HashMap<>(); // 아이디-닉네임 (중복확인용)

		for (int i = 0; i < record.length; i++) {
			String[] str = record[i].split("\\s"); // 각 유저 정보는 공백으로 분류
			User user; // 유저i: 상태 id 닉넴

			if (!str[0].equals("Leave"))
				user = new User(str[0], str[1], str[2]);
			else // Leave일때는 상태, id만 들어옴
				user = new User(str[0], str[1], map.get(str[1]));

			// 입장
			if (user.status.equals("Enter")) {
				if (map.isEmpty()) { // 첫 입장
					map.put(user.userId, user.nickName);
				} else {
					if (!map.containsKey(user.userId)) { // 신규 유저면
						map.put(user.userId, user.nickName);
					} else { // 닉넴 바꿔서 재입장
						map.replace(user.userId, user.nickName);
					}
				}
			}

			// 닉넴 변경
			else if (user.status.equals("Change")) {
				map.replace(user.userId, user.nickName);
			}

			// 동작 순서대로 넣기
			q.add(new User(user.status, user.userId, user.nickName));
		}

		while (!q.isEmpty()) {
			User user = q.poll();

			if (user.status.equals("Enter")) {
				answer.add(map.get(user.userId) + "님이 들어왔습니다.");
			} else if (user.status.equals("Leave")) {
				answer.add(map.get(user.userId) + "님이 나갔습니다.");
			}

		}

		return answer;
	}
}
