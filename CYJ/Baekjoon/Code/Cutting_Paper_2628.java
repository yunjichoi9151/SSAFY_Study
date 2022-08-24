import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Cutting_Paper_2628 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt(), c = sc.nextInt();
        int t = sc.nextInt();
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        ArrayList<Integer> arr3 = new ArrayList<>();
        ArrayList<Integer> arr4 = new ArrayList<>();
        for(int tc = 0; tc < t; tc++) {
            int d = sc.nextInt();
            int l = sc.nextInt();
            if(d == 0 && l <= c) {
                arr1.add(l);
            }
            else if(d == 1 && l <= r) {
                arr2.add(l);
            }
        }
        arr1.add(c);
        arr2.add(r);
        arr1.add(0);
        arr2.add(0);
        Collections.sort(arr1);
        Collections.sort(arr2);
        for(int i = 1; i < arr1.size(); i++) {
            arr3.add(arr1.get(i) - arr1.get(i - 1));
        }
        for(int i = 1; i < arr2.size(); i++) {
            arr4.add(arr2.get(i) - arr2.get(i - 1));
        }
        int tmp = 0, max = 0;
        for(int i = 0; i < arr3.size(); i++) {
            for(int j = 0; j < arr4.size(); j++) {
                tmp = arr3.get(i) * arr4.get(j);
                if(max < tmp) {
                    max = tmp;
                }
            }
        }
        System.out.println(max);
        sc.close();
    }
}
