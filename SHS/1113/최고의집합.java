package pracprac.programmers.study.d1113;
//dp문제같은데 규칙이 뭔지 고민함
//입출력 예시, n이 여러개인 경우 상정했을때 곱 최대화 하려면 s/n에 포진된 숫자들로 구성해야함
//불가능한 경우는 예시처럼 n이 s보다 큰 경우
import java.util.Arrays;

public class 최고의집합 {
	
	   public int[] solution(int n, int s) {
	        
		   //불가능한 경우
	        if(n>s){
	            return new int[] {-1};
	        }
	        
	        int[] answer = new int[n];
	        
	        //이부분 s%n 남고 안남고 분리하면 효율성 탈락 -> 한번에 처리하거나 저장해서..
	        for(int i=0; i<n; i++){
	            answer[i] = s/n;
	        }//나누어 떨어질때

	        for(int i=0; i<s%n; i++){
	            answer[i]++;
	        }//나머지가 있을 경우 
	    
	        Arrays.sort(answer);

	        return answer;
	    }

}
