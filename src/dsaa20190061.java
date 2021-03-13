import java.util.*;

public class dsaa20190061 {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        long T = in.nextInt();
        for(long r = 0;r<T;r++){
            long N = in.nextLong();
            long K = in.nextLong();
            long h = 0;
            long sum = 0;
            find(N,K,h,sum);
        }
    }

    public static void find(long N,long K,long h,long sum){
        long level = (long) Math.pow(K,h);
        sum += level;
        if(sum>N){
            long out = level-(sum-N)+(sum-N)/K;
            System.out.println(out);
            return;
        }
        if(sum==N){
            System.out.println(level);
            return;
        }
        h++;
        find(N,K,h,sum);
    }


}
/*public class treeNode{

    int key;
    treeNode left;
    treeNode right;

}*/

/*
        S=1+N+N^2+N^3+...+N^n
        NS = N+N^2+N^3+...+N^n + N^(n+1)
        (N-1)S = N^(n+1) - 1
        S = (N^(n+1) - 1) / (N-1)
*/
