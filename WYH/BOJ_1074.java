import java.util.*;

public class main
{
    static int N,R,C,ans;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        R = sc.nextInt(); // За
        C = sc.nextInt(); // ї­
        solve(0,0, (int)Math.pow(2,N));

    }

    private solve(int r,int c,int size){
        if(size == 1){
            System.out.println(ans);
            return;
        }
        int newSize = size/2;
        if(R<r+newSize && C<c+newSize){
            solve(r,c,newSize);
        }
        if(R<r+newSize && C>=c+newSize){
            ans += (size*size)/4;
            solve(r,c+newSize,newSize);
        }
        if(R>=r+newSize && C<c+newSize){
            ans +=((size*size)/4)*2;
            solve(r+newSize,c,newSize);
        }
        if(R>=r+newSize&&C>=c+newSize){
            ans += ((size*size)/4)*3;
            solve(r+newSize,c+newSize,newSize);

        } 
           }
}