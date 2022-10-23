class Recommend_New_ID {
    public String solution(String new_id) {
        String answer = new_id;
        // 1단계 : 소문자로 변환
        answer = new_id.toLowerCase();
        // 2단계 : 알파벳 소문자, 숫자, -, _, . 제외한 문자들 제거
        answer = answer.replaceAll("[^a-z0-9-_.]", "");
        // 3단계 : 마침표가 2개 이상 연속되면 1개로 치환
        while(answer.contains("..")) {
            answer = answer.replace("..", ".");
        }
        // 4단계 : 마침표가 처음이나 끝에 위치한다면 삭제
        if(answer.length() > 0 && answer.charAt(0) == '.') {
            answer = answer.substring(1, answer.length());
        }
        if(answer.length() > 0 && answer.charAt(answer.length()-1) == '.') {
            answer = answer.substring(0, answer.length()-1);
        }
        // 5단계 : 빈 문자열이면 a 대입
        if(answer.equals("")) {
            answer = "a";
        }
        // 6단계 : 길이가 16자 이상이면 앞 15개 문자만 남김
        if(answer.length() >= 16) {
            answer = answer.substring(0, 15);
        }
        // 6단계 : 제거 후 마침표가 끝에 위치하면 삭제
        if(answer.charAt(answer.length() - 1) == '.') {
            answer = answer.substring(0, answer.length() - 1);
        }
        // 7단계 : 길이가 2자 이하면 마지막 문자를 id의 길이가 3이 될때까지 반복
        if(answer.length() <= 2) {
            while(answer.length() < 3) {
                answer += answer.charAt(answer.length() - 1);
            }
        }
        return answer;
    }
}