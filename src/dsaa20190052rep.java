import java.util.*;

public class dsaa20190052rep {
    static char[] s_arr;
    static char[] t_arr;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int r = 0;r<T;r++) {
            int n = in.nextInt();
            int m = in.nextInt();
            String s = in.next();
            String t = in.next();
            if(n-1>m) {
                System.out.println("NO");
                continue;
            }
            s_arr = s.toCharArray();
            t_arr = t.toCharArray();
            if(Right(n,m)){
                if(Left(n,m)){
                    System.out.println("YES");
                    continue;
                }
            }
            System.out.println("NO");
        }
    }

    public static boolean Right(int n , int m){
        int i = 0;
        //int j = 0;
        while(i<n&&i<m) {
            if (s_arr[i]=='*'){
                return true;
            }else if(s_arr[i]==t_arr[i]){
               i++;
            }else return false;
        }
        if(n<m){
            return false;
        }else if(n>m){
            if(s_arr[i]!='*')return false;
        }
        return true;
    }

    public static boolean Left(int n , int m){
        int i = 1;
        //int j = 0;
        while(i<=n&&i<=m) {
            if (s_arr[n-i]=='*'){
                return true;
            }else if(s_arr[n-i]==t_arr[m-i]){
                i++;
            }else return false;
        }
        if(n<m){
            return false;
        }else if(n>m){
            if(s_arr[n-i]!='*')return false;
        }
        return true;
    }

}
