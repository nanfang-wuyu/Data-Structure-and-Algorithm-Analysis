import java.util.*;

public class dsaa20190053KMP {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int r = 0;r<T;r++){
            String S = in.next();
            char []s = S.toCharArray();
            int length = S.length();
            if(length==1){
                System.out.println(1);
            }
            else {
                String Sub = "";
                Sub+=s[0];
                char w = s[0];
                int i = 1;
                int j = 0;
                int count = 1;
                //char []sub;
                //sub = Sub.toCharArray();
                while(i<length){
                    j=0;
                    while(i<length&&j<Sub.length()){
                        if(s[i]==Sub.charAt(j)){
                            i++;
                            j++;
                        }//相等
                        else{
                            if(w!=s[i])i++;
                            j=0;//防止计算count加一
                            Sub = S.substring(0,i);
                            //System.out.println(Sub);
                            //sub = Sub.toCharArray();
                            count = 1;
                            break;
                        }//不等 子字符串变大
                    }
                    if(j>=Sub.length()){
                        count++;
                    }
                }
                System.out.println((Sub.length() - j));

            }
        }
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
