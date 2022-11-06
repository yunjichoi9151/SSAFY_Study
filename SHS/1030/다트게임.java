package pracprac.programmers.study.d1030;
//게임 3번 -> 3길이 배열에 점수 저장
//제곱 점수
//스타상 중첩 주의

public class 다트게임 {

	class Solution {
	    public int solution(String dartResult) {
	        int answer = 0;
	        int[] arr = new int[3];
	        
	        int num=0, idx=0;
	        String s = "";
	        
	        for(int i=0; i<dartResult.length();i++){
	            char c = dartResult.charAt(i);
	            
	            //숫자일 때 s에 문자 붙이기 : 두자리수 이상일 경우를 대비해서
	            if(c>='0' && c<='9'){
	                s+= String.valueOf(c);
	                
	                //정수변환 및 점수 계산
	            }else if(c=='S'|| c=='D' || c=='T'){
	                num = Integer.parseInt(s);
	                
	                if(c=='S'){
	                    arr[idx++] = (int)Math.pow(num,1);
	                } else if(c=='D'){
	                    arr[idx++] = (int)Math.pow(num,2);
	                }else{
	                    arr[idx++] = (int)Math.pow(num,3);
	                }
	                
	                s = "";
	            }
	            //점수 저장할때  idx+1씩 되었으므로 -1해주기
	            else{
	                if(c=='*'){
	                    arr[idx-1]*=2;
	                    //*은 첫 게임의 경우를 제외하고 이전 점수도 2배
	                    if(idx-2>=0){
	                        arr[idx-2]*=2;
	                    }
	                }else{
	                    arr[idx-1]*= -1;
	                }
	            }
	        }
	        //각 게임 점수의 합
	        answer=arr[0]+arr[1]+arr[2];
	        
	        return answer;
	    }
	}
}
