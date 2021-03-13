import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class te {

    static long b;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        for(int r = 0;r<100;r++) {
            String a = in.next();
            String b = in.next();
            int l = a.length();
            char[] m = a.toCharArray();
            int[] next = KMP(m);
            for (int i = 0; i < next.length; i++) {
                System.out.print(next[i]+" ");
            }
            //System.out.println("s"+(l-next[l]));
        }

    }

    public static int[] KMP(char[] t) {
        int[] next = new int[t.length+1];
        next[0] = -1;
        //next[1] = 0;
        int k;
        for (int j = 1; j < next.length; j++) {
            k = next[j - 1];
            while (k != -1) {
                if (t[j - 1] == t[k]) {
                    next[j] = k + 1;
                    break;
                } else {
                    k = next[k];
                }
            }
        }
        return next;
    }

    public static boolean hash(String C, String T){
        char [] c = C.toCharArray();
        char [] t = T.toCharArray();
        int m = C.length();//prefix length
        int n = T.length();
        long Chash = 0;
        long Thash = 0;
        long q = (long) Math.pow(b,m);//or use for()
        for(int i = 0;i<m;i++) Chash = Chash * b + c[i];
        for(int i = 0;i<m;i++) Thash = Thash * b + t[i];
        for(int i = 0;i+m<n+1;i++){
            if(Chash == Thash)return true;
            else if(i+m<n) Thash = Thash*b-t[i]*q+t[m+i];
        }
        return false;
    }
}