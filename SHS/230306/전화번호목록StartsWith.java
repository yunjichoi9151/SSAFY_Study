package 이공이삼삼월.d230302;
import java.util.Arrays;

public class 전화번호목록StartsWith {
	
	class Solution {
	    public boolean solution(String[] phone_book) {
	        Arrays.sort(phone_book);
	        
	        //startsWith, endsWith 짱...
	        for(int i=0; i<phone_book.length-1; i++){
	            if(phone_book[i+1].startsWith(phone_book[i])){
	                return false;
	            }
	        }
	            
	        return true;
	    }
	}

}
