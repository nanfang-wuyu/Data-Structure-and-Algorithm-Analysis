import java.util.*;

public class dsaa20190053new {
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
                char w = s[0];
                Sub+=s[0];
                int i = 1;
                int j = 0;
                int re = 1;
                int lastre = 1;
                char []sub;
                sub = Sub.toCharArray();
                while(i<length){
                    j=0;
                    while(i<length&&j<Sub.length()){
                        if(s[i]==w){re = i;}
                        if(s[i]==sub[j]){
                            i++;
                            j++;
                        }//相等
                        else{
                            if(lastre != re){
                                i = re;
                            }else {
                                i++;
                                re = i;
                            }
                            lastre = i;
                            j=0;//防止计算count加一
                            Sub = S.substring(0,i);
                            sub = Sub.toCharArray();
                            break;
                        }//不等 子字符串变大
                    }
                }
                System.out.println((Sub.length() - j));

            }
        }
    }
}
