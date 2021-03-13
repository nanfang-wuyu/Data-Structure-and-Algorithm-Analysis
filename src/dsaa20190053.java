import java.util.*;

public class dsaa20190053 {
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
                int re = 1;
                int lastre = 1;
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
}
