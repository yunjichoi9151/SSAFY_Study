import java.util.*;
public class Main
{
	
	public int solution(int n, int[][] wires) {
        int answer = -1;
        arr= new int[n+1][n+1];
        
        for(int i=0;i<wires.length;i++){
            arr[wires[i][0]][wires[i][1]]=1;
            arr[wires[i][1]][wires[i][0]]=1;
        }
        
        int a,b;
        for(int i=0;i<wires.length;i++){
            a = wires[i][0];
            b = wires[i][1];
            
            // 선을 끊고
            arr[a][b] = 0;
            arr[b][a] = 0;
            // bfs 해보고
            answer = Math.min(answer,bfs(n,a));
            // 다시 복구
            arr[a][b] = 1;
            arr[b][a] = 1;
        }
        return answer;
    }
    
    public int bfs(int n,int start){
        int[] visit = new int[n+1];
        int cnt = 1;
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        
        while(!queue.isEmpty()){
            int point = queue.poll(); // 앞에 들어있는 값 반환 후 삭제
            visit[point] = 1;
            
            for(int i=1;i<=n;i++){ // 방문한 적 없는 노드 큐에 넣기
                if(visit[i]==1) continue;
                if(arr[point][i] == 1){
                    queue.offer(i);
                    cnt++;
                }
            }
        }
        return (int)Math.abs(n-2*cnt);
    }
}