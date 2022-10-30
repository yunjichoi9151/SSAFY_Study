package Baekjoon.Programmers;

class PRG_신규아이디추천 {
    //디버깅용
    static String new_id = "abcdefghijklmn.p";

    public static void main(String[] args) {
        System.out.println(solution(new_id));
    }

    public static String solution(String new_id) {
        //1단계 : 모든 대문자 소문자로 치환
        new_id = new_id.toLowerCase();

        //2단계 : 알파벳 소문자, 숫자, 빼기, 밑줄, 마침표 제외한 모든 문제 제거
        new_id = new_id.replaceAll("[^a-z0-9-_.]", "");

        //3단계 : .이 2개 이상이면 . 하나로 변환
        new_id = new_id.replaceAll("[.]+", ".");

        //4단계 : 아이디 맨 처음과 끝에 위치한 . 제거
        new_id = new_id.replaceAll("^[.]|[.]$", "");

        //5단계 : 빈 문자열이면 a 대입
        if (new_id.equals("")) new_id = "a";

        //6단계 : 16글자 이상이면 15글자까지만 추출
        if (new_id.length() >= 16) new_id = new_id.substring(0, 15);
        new_id = new_id.replaceAll("[.]$", "");

        //7단계 : 아이디가 2자 이하면 마지막 글자를 3이 될때까지 붙이기
        char ch = new_id.charAt(new_id.length() - 1);
        if (new_id.length() <= 2) {
            StringBuilder new_idBuilder = new StringBuilder(new_id);
            while (new_idBuilder.length() < 3) {
                new_idBuilder.append(ch);
            }
            new_id = new_idBuilder.toString();
        }

        return new_id;
    }
}
