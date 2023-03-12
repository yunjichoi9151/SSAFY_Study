package 이공이삼삼월.d230302;

import java.util.HashMap;
import java.util.Map;

public class 전화번호목록Hash {
	
	class Solution {
	    public boolean solution(String[] phone_book) {
	        Map<String, Integer> map = new HashMap<>();
	        
	        for(int i=0; i<phone_book.length; i++){
	            map.put(phone_book[i], i);
	        }
	        
	        //길이 돌면서 검사
	        for(int i=0; i<phone_book.length; i++){         
	            for(int j=0; j<phone_book[i].length(); j++){
	                if(map.containsKey(phone_book[i].substring(0,j))){
	                    return false;
	                }
	            }            
	        }
	        return true;
	        
	    }
	}

}
