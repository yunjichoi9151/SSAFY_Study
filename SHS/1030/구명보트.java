package pracprac.programmers.study.d1030;
//배열 정렬해서 가장 작은값, 가장큰값 합한게 리미트초과 안하면 계속 태워주는 식으로
import java.util.Arrays;

public class 구명보트 {

	class Solution {
	    public int solution(int[] people, int limit) {
	        int answer = 0;
	        int p1 = 0;
	        int p2 = people.length-1;
	        
	        //오름차순 정렬
	        Arrays.sort(people);
	        
	        //최대 두명이 탈 수 있으니까 가장 가벼운 사람+가장 무거운사람 리미트 이하면 태우기
	        while(p1<=p2){
	        	//일단 배 하나 추가
	            answer+=1;
	            if(people[p1]+people[p2]<=limit){
	                p1+=1;
	            }
	            //같이 못탄 사람은 혼자타기
	            p2-=1;
	        }
	        
	        
	        return answer;
	    }
	}
}
