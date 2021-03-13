import java.util.*;

public class dsaa20190054 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int r = 0;r<T;r++){
            String a = in.next();
            char []array = a.toCharArray();
            int []next = nplus1KMP(array);
            int l = a.length();
            int rev = l-next[l];
            int mod = l%rev;
            if(mod!=0) System.out.println(rev-mod);
            else if(l/rev>=2) System.out.println(0);
            else System.out.println(rev);
        }
    }

    public static int[] nplus1KMP(char[] t) {
        int[] next = new int[t.length+1];
        next[0] = -1;
        next[1] = 0;
        int k;
        for (int j = 2; j < next.length; j++) {
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
}
