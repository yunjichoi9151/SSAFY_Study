package pracprac.programmers.study.d1113;

public class 키패드누르기 {

    public String solution(int[] numbers, String hand) {
        String answer ="";
        int l = 10;
        int r = 12;
      //*=10 0=11 #=12
        
        for(int n : numbers){
            if(n==1||n==4||n==7){
                answer+="L";
                l = n;
                
            }else if(n==3||n==6||n==9){
                answer+="R";
                r = n;
                
            }else{
                if(n==0){
                    n+=11;
                }
                //거리 계산 및 비교
                int ld = (Math.abs(n-l))/3 + (Math.abs(n-l))%3;
                int rd = (Math.abs(n-r))/3 + (Math.abs(n-r))%3;
                if(ld==rd){
                    if(hand.equals("right")){
                        answer+="R";
                        r = n;
                    }else{
                        answer+="L";
                        l = n;
                    }
                }else if(ld>rd){
                    answer+="R";
                    r = n;
                }else{
                    answer+="L";
                    l = n;
                }
            }
        }
        return answer;
    }
}
