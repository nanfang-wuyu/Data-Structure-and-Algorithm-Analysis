import java.util.*;

public class dsaa20190055 {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String s1 = in.next();
        String s2 = in.next();

        if(s1.length()<s2.length()){
            String temp = "";
            temp = s2;
            s2 = s1;
            s1 = temp;
        }//make s1 longer;
        if(s1.length()==1){
            if(s2.contains(s1)) {
                System.out.println(1);
            }else System.out.println(0);
            return;
        }
        sub(s1,s2);
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

        //char[] s = S.toCharArray();
        char[] t = T.toCharArray();
        int[] next = KMP(t);
        int i = 0;
        int j = 0;


        while (i < S.length() && j < t.length) {
            if (S.charAt(i) == t[j]) {
                i++;
                j++;
            }
            else {
                j = next[j];
                if (j == -1) {
                    i++;
                    j++;
                }
            }
        }
        if (!(i >= S.length() && j < t.length)) {
            return true;
        }
        return false;
    }

    public static void sub(String s1, String s2){

        int l1 = s1.length();
        int l2 = s2.length();
        int i = 0;
        int tail = l2-1;
        int j = tail;
        while(tail>0){
            while(j<l2){
                String substring = s2.substring(i,j+1);
                //System.out.println(match(s1,substring));
                if(match(s1,substring)){
                    System.out.println(substring.length());
                    return;
                }else {
                    //System.out.println(i+"i"+j+"j"+tail+"tail");
                    i++;
                    j++;

                }
            }
            tail--;
            j=tail;
            i=0;
        }
    }
}
