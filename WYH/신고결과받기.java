import java.util.*;
public class Main
{
   public static void main(String[] args) {
       String[] id_list = {"muzi", "frodo", "apeach", "neo"};
       String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
       System.out.println(Arrays.toString(solution(id_list,report,3)));
      
   }
   
   public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, HashSet<String>> map = new HashMap<>();
        Map<String, Integer> idxMap = new HashMap<>();
        
        for(int i=0;i<id_list.length;i++){
            String name = id_list[i]; // id_list에서 순서대로 가져와서
            map.put(name, new HashSet<>()); // hashmap에 넣어줌
            idxMap.put(name,i);
        }
        for(String s : report){
            String[] str = s.split(" "); // 띄어쓰기로 나눠줌
            String reporter = str[0]; // 신고자
            String reported = str[1]; // 신고받은 사람
            map.get(reported).add(reporter);
        }
        
        for(int i=0;i<id_list.length;i++){
            HashSet<String> send = map.get(id_list[i]);
            if(send.size()>=k){
                for(String name : send){
                    answer[idxMap.get(name)]++;
                }
            }
        }
        return answer;
      
      
      
      
      
      
      // String[][] alert = new String[id_list.length][2];
      // for(int a=0;a<report.length;a++){
      // for(int i=0;i<alert.length;i++){
      // for(int j=0;j<2;j++){
      // alert[i][j] = report[a].split(" ");
      // }
      // }
      // }
    }
}