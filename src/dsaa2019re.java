import java.util.*;

public class dsaa2019re {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int i = 0;i<T;i++){
            String S = in.next();
            long l = S.length();
            long output = (l+1)*l/2;
            System.out.println(output);
        }


    }


}
