import java.util.*;

public class dsaa20190052 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int Sl = in.nextInt();
        int Tl = in.nextInt();
        String S = in.next();
        String Test = in.next();
        System.out.println(match(S, Test));

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


    public static int match(String S, String T) {

        char[] s = S.toCharArray();
        char[] t = T.toCharArray();
        int[] next = KMP(t);
        int i = 0;
        int j;
        int count = 0;
        while (i < s.length) {
            j = 0;
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
                count++;
            }
        }
        return count;
    }
}

    /*public static void match(String S, String T){

        char[] s = S.toCharArray();
        char[] t = T.toCharArray();
        int [] next = KMP(t);
        int i = 0;
        int j =0;
        while(i<s.length&&j<t.length)
        {

            if(s[i]==t[j]){
                i++;
                j++;
            }else {
                j = next[j];
                if(j==-1){
                    i++;
                    j++;
                }
            }

        }
    }*/






