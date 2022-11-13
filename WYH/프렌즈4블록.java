import java.util.*;
public class Main
{
	public static void main(String[] args) {
	}
	
	public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] c = new char[m][n];
        for(int i=0;i<m;i++){
            c[i] = board[i].toCharArray();
        }
      
        while(true){
        int cnt = checkBoard(arr,m,n); // 지워야 할 항목 개수
        if(cnt==0) break; // 없으면 중단
        answer += cnt;
        dropBoard(arr,m,n); // 공백인 부분 위에 항목 채우기
        }
        
        return answer;
    }
    
    public int checkBoard(char[][] arr,int m, int n){
        boolean[][] check = new boolean[m][n]; // 공백인 부분 확인
        int cnt = 0;
        for(int i=0;i<m-1;i++){
            for(int j=0;j<n-1;j++){
                // 공백 아니면 지워도 되는지 확인
                if(arr[i][j] != ' ') checkItem(arr,check,i,j);
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(check[i][j]){ // 지워도 되면 공백으로 바꾸고 cnt 늘려줌
                    arr[i][j] = ' ';
                    cnt++;
                }
            }
        }
        
        return cnt;
        
    }
    
    public void checkItem(char[][] arr, boolean[][] check, int i, int j){
        for(int y=i;y<i+2;y++){
            for(int x=j;x<j+2;x++){
                if(arr[i][j] != arr[y][x]){ // 4개 안에 다른게 나오면 중단
                    return;
                }
            }
        }
        
        for(int y=i;y<i+2;y++){
            for(int x=j;x<j+2;x++){
                check[y][x] = true;
            }
        }
    }
    
    public void dropBoard(char[][] arr, int m, int n){
        for(int j=0;j<n;j++){
            for(int i=m-1;i>=0;i--){
                if(arr[i][j] == ' '){
                    for(int k=i-1;k>=0;k--){
                        if(arr[k][j] != ' '){
                            arr[i][j] = arr[k][j];
                            arr[k][j] = ' ';
                            break;
                        }
                    }
                }
            }
        }
    }
}