package d230218;
//플루이드 워셜https://in-intuition.tistory.com/25
//2차원배열에 승점을 채워보기. 승패의 이행성 염두에 둬서 건너는 정점 수 최소화
//승패가 확실한 경기 수를 rs에 저장해서 이게 n-1이면 그 선수의 순위는 확정 가능

public class 순위 {
	
	class Solution {
	    public int solution(int n, int[][] results) {
	        int answer = 0;
	        boolean[][] game = new boolean[n][n];
	        
	        for(int i=0; i<results.length; i++){
	        	//배열 범위때문에 -1
	            game[results[i][0]-1][results[i][1]-1] = true;
	        }
	        
	        for(int i=0; i<n; i++){
	            for(int j=0; j<n; j++){
	                for(int k=0; k<n; k++){
	                    if(game[j][i]==true && game[i][k]==true){
	                        game[j][k]=true;
	                    }
	                }
	            }
	        }
	        
	        for(int i=0; i<n; i++){
	            int rs = 0;
	            for(int j=0; j<n; j++){
	                if(game[i][j] || game[j][i]){
	                    rs++;
	                }
	            }
	            
	            if(rs==n-1){
	                answer++;
	            }
	        }
	        
	        
	        
	        return answer;
	    }
	}
}
