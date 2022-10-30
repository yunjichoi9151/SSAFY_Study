package Baekjoon.Programmers;

import java.util.Stack;

class PRG_크레인인형뽑기게임 {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        int size = board[0].length;

        int answer = 0;
        //크레인 움직인 횟수만큼 반복
        for (int move : moves) {
            for (int j = 0; j < size; j++) {
                if (board[j][move - 1] == 0) continue;   //빈칸이면 넘어가기

                if (!stack.isEmpty() && stack.peek() == board[j][move - 1]) {
                    stack.pop();
                    answer += 2;
                } else {
                    stack.push(board[j][move - 1]);
                }

                board[j][move - 1] = 0;
                break;
            }
        }

        return answer;
    }
}