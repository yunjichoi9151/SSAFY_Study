package d230218;

import java.util.HashSet;

public class 폰켓몬 {
	class Solution {
	    public int solution(int[] nums) {
	        int answer = nums.length/2;
	        //해쉬셋 연습
	        HashSet<Integer> ponket = new HashSet<>();
	        
	        for(int i : nums){
	            ponket.add(i);
	        }
	        
	        if(ponket.size() > answer){
	            return answer;
	        }else{
	            return ponket.size();
	        }
	        
	        
	    }
	}
}
