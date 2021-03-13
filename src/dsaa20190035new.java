import java.util.ArrayList;
import java.util.Scanner;

public class dsaa20190035new {

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int r = 0;r<T;r++){
            dsaa20190035new dsaa = new dsaa20190035new();
            int n = in.nextInt();
            long m = in.nextLong();
            long max = m;
            long fast = m;
            if(m==0||m==1){System.out.println(m);}
            else {
                System.out.println(dsaa.catchNum(m,fast,n,max));
            }
        }
    }

    public long catchNum(long m, long fast, int n, long max){
        boolean loop = false;
        int t = 1;
        while(!loop) {

            if(t==0){

                if (String.valueOf(m).length() > n) {
                    int p = Long.toString(m).length()-n;
                    m = m/((long)Math.pow(10,p));
                }
                m *= m;
            }

            if (String.valueOf(fast).length() > n) {
                int p = Long.toString(fast).length()-n;
                fast = fast/((long)Math.pow(10,p));
            }
                if(fast>max) {
                    max = fast;
                }
                fast *= fast;
                if(fast == m){return max;}
                if(t==0){t=1;}
                else t=0;
        }
        return max;
    }
}