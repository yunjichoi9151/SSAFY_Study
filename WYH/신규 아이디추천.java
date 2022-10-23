class Solution {
    public String solution(String new_id) {
       String answer = "";

        // 1단계
        String first = new_id.toLowerCase();

        // 2단계
        char[] arr = first.toCharArray();
        StringBuilder second = new StringBuilder();
        for(int i=0;i<arr.length;i++){
            if((c[i]>='a'&&c[i]<='z')||(c[i]>='0'&&c[i]<='9')||c[i]=='-'||c[i]=='_'||c[i]=='.'){
                second.append(c[i]);
            }
        }

        // 3단계
        String third = second.toString().replace("..",".");
        while(third.contains("..")){
            third = third.replace("..",".");
        }

        // 4단계
        String fourth = third;
        if(fourth.length()>0){
            if(fourth.charAt(0)=='.'){
                fourth = fourth.substring(1,fourth.length());
            }
        }
         if(fourth.length()>0){
            if(fourth.charAt(fourth.length()-1)=='.'){
                fourth = fourth.substring(0,fourth.length()-1);
            }
        }

        // 5단계
        String fifth = fourth;
        if(fifth.equals("")){
            fifth = "a";
        }

        // 6단계
        String sixth = fifth;
        if(sixth.length()>=16){
            sixth = sixth.substring(0,15);

            if(sixth.charAt(sixth.length()-1)=='.'){
                sixth = sixth.substring(0,sixth.length()-1);
            }
        }

        // 7단계
        StringBuilder seventh = new StringBuilder(sixth);
        if(seventh.length()<=2){
            char last = seventh.charAt(seventh.length()-1);
        }

        while(seventh.length()<3){
            seventh.append(last);
        }
    }



        answer = String.valueOf(seventh);


        
        return answer;
    }
}