
import java.util.*;

public class dsaa20190051 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int number = 0;
        for(int r = 0;r<T;r++){
            String s1 = in.next();
            String s2 = in.next();
            int m = s1.length()/3+1;
            if(s1.length()%3==0)m--;
            String prefix = s1.substring(0,m);
            int l1 = s2.length();
            int l2 = prefix.length();
            if(l1==l2){
                if(s2.equals(prefix)){
                    number++;
                }
            }else if(l1>l2){
                if(l2==1){if(s2.contains(prefix))number++;}
                else if(match(s2,prefix)){
                    number++;
                }
            }
        }
        System.out.println(number);
    }

    public static int[] KMP(char[] t) {
        int[] next = new int[t.length];
        next[0] = -1;
        next[1] = 0;
        int k;
        for (int j = 2; j < t.length; j++) {
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

    public static boolean match(String S, String T) {

        char[] s = S.toCharArray();
        char[] t = T.toCharArray();
        int[] next = KMP(t);
        int i = 0;
        int j = 0;


        while (i < s.length && j < t.length) {
            if (s[i] == t[j]) {
                i++;
                j++;
            } else {
                j = next[j];
                if (j == -1) {
                    i++;
                    j++;
                }
            }
        }
        if (!(i >= s.length && j < t.length)) {
            return true;
        }
        return false;
    }
}
