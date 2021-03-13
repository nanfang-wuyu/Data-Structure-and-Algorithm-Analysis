import java.util.*;

public class dsaa20190061new {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        long T = in.nextInt();
        for(long r = 0;r<T;r++){
            long N = in.nextLong();
            long K = in.nextLong();
            long h = (long)(Math.log(N*(K-1)+1)/Math.log(K));
            long level = (long)(Math.pow(K,h));
            long x = ((long)(Math.pow(K,h+1))-1)/(K-1);
            if(x==N) {
                System.out.println(level);
                continue;
            }
            long sum = level-(x-N)+(x-N)/K;
            System.out.println(sum);
        }
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
