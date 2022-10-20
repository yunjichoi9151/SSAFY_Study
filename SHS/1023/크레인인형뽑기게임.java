package pracprac.programmers.study;
//문제 조건을 보면 후입선출(사라짐) -> 스택 사용
//스택에 뽑은 인형을 쌓고 방금 들어간 인형과 비교해서 같으면 제거하고 답+2씩 누적
//for문 어떻게 돌릴지 고민.. 더 큰게 더 바깥인게 원칙인가?
//board 배열을 move 안에서 돌리기로...

import java.util.*;

public class 크레인인형뽑기게임 {
	
	    public int solution(int[][] board, int[] moves) {
	    	//뽑은 인형을 담을 스택
	        Stack<Integer> basket = new Stack<>();
	        int answer = 0;
	        
	        for(int i=0; i<moves.length; i++){
	        	//2차원배열 길이도 이걸로 추출 가능
	            for(int j=0; j<board.length; j++){
	                //인덱스 주의!! 0번 인덱스부터 돌아가므로 -1해줘야함..
	                if(board[j][moves[i]-1]!=0){
	                    //0이 아닌경우 : 인형이 있는 곳까지 가서 뽑기
	                	//스택 비어있을때 뽑기 실행 시작
	                    if(basket.isEmpty()){
	                        basket.push(board[j][moves[i]-1]);                      
	                    }else{
	                    	//최근에 넣은 인형이 방금 뽑은것과 같으면 꺼내고 답+2씩
	                        if(basket.peek()==board[j][moves[i]-1]){
	                            basket.pop();
	                            answer+=2;
	                        }else{
	                            basket.push(board[j][moves[i]-1]);
	                        }
	                                                
	                    }
	                    //이미 뽑은 인형은 0으로 처리 (방문처리)
	                    board[j][moves[i]-1] = 0;
	                    break;
	                }
	                
	            }
	        }
	        
	      
	        return answer;
	    }
	}
