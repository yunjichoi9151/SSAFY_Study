package pracprac.programmers.study;
//이건 외워야할거같다

public class 신규아이디추천 {
	public String solution(String new_id) {
		String answer;

		//1단계 : 소문자로
		String s1 = new_id.toLowerCase();		
		char[] s1Arr = s1.toCharArray();
		
		//2단계 : 문자제거
		StringBuilder s2 = new StringBuilder();
		for (char c : s1Arr) {
			if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == '-' || c == '_' || c == '.') {
				s2.append(c);
			}
		}
		
		//3단계 : 문자치환
		String s3 = s2.toString().replace("..", ".");
		while (s3.contains("..")) {
			s3 = s3.replace("..", ".");
		}

		//4단계 : 처음 위치 끝 위치
		String s4 = s3;
		if (s4.length() > 0) {
			if (s4.charAt(0) == '.') {
				s4 = s4.substring(1, s4.length());
			}
		}
		if (s4.length() > 0) {
			if (s4.charAt(s4.length() - 1) == '.') {
				s4 = s4.substring(0, s4.length() - 1);
			}
		}

		//5단계 : 빈문자열
		String s5 = s4;
		if (s5.equals("")) {
			s5 = "a";
		}
		
		//6단계 : 문자 길이 검사, 문자열 일부 제거
		String s6 = s5;
		if (s6.length() >= 16) {
			s6 = s6.substring(0, 15);

			if (s6.charAt(s6.length() - 1) == '.') {
				s6 = s6.substring(0, s6.length() - 1);
			}
		}
		
		//7단계 : 반복해서 문자열 추가
		StringBuilder s7 = new StringBuilder(s6);
		if (s7.length() <= 2) {
			char last = s7.charAt(s7.length() - 1);

			while (s7.length() < 3) {
				s7.append(last);
			}
		}

		answer = String.valueOf(s7);
		return answer;
	}
}
