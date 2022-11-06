package day1030;

import java.util.Arrays;

public class programmers2_구명보트 {
	public static void main(String[] args) {
		int[] people = {70, 50, 80, 50};
		int limit = 100;
		System.out.println(solution(people,limit));
	}
	
	 public static int solution(int[] people, int limit) {
	        int answer = 0;
	        
	        // 사람들 몸무게 주어지고
	        // 제한
	        
	        Arrays.sort(people);
	        int min = 0;
	        for(int max=people.length-1;min<=max;max--) {
	        	if(people[min]+people[max]<=limit) min ++;
	        	answer++;
	        }
	        
	        return answer;
	    }
	 
	
}
