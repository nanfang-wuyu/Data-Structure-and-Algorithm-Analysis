package dsaa2019compitition;
import java.util.*;

public class q1 {
    static char[] m,c;
    static int[] n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int r = 0;r<T;r++){
            int N = in.nextInt();
            String str = in.next();
            m = str.toCharArray();
            c = new char[m.length];
            quickSort(m, 0 ,m.length-1);
            for(int i = 0;i<m.length;i++) c[i] = m[i];
            n = new int[m.length];
            permutation(0);
        }
    }

    public static void permutation(int pos){
        if(pos==m.length){
            print();
            return;
        }
        for(int i = 0;i<m.length;i++){
            if(n[i]==0){
                n[i] = 1;
                m[pos] = c[i];
                permutation(pos+1);
                n[i] = 0;
            }
        }
    }

    public static void quickSort(char[]arr,int l,int r){

        if(l>=r){
            return;
        }
        else{Random ran = new Random();
            int i = ran.nextInt(r-l+1)+l;
            char temp = arr[l];
            arr[l] = arr[i];
            arr[i] = temp;
            char v = arr[l];
            int lt = l;
            int gt = r+1;
            i = l + 1;

            while (i<gt){
                if(arr[i]<v){
                    temp = arr[lt+1];
                    arr[lt+1] = arr[i];
                    arr[i] = temp;
                    lt++;
                    i++;
                }else if(arr[i]>v){
                    temp = arr[gt-1];
                    arr[gt-1] = arr[i];
                    arr[i] = temp;
                    gt--;
                }else {i++;}
            }
            temp = arr[l];
            arr[l] = arr[lt];
            arr[lt] = temp;
            lt--;
            quickSort(arr,l,lt);
            quickSort(arr,gt,r);
            //System.out.println(arr[k]);
        }
    }

    public static void print(){
        for(int i = 0;i<m.length;i++){
            System.out.print(m[i]);
        }
        System.out.println();
    }
}
