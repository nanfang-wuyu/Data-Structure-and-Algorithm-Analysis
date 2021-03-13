import java.util.Scanner;
public class dsaa20190013 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long m = in.nextLong();
        //System.out.println(n+" "+m);
        //long a[] = new long[720];
        long x = 1;
        if(n >= 4){System.out.println(0);}
        else if(n == 3){
            for(int i = 1;i<721;i++){
                x = x * i;
                if(x>m){
                    x = x%m;
                }
                //System.out.println(x);
            }
            System.out.println(x%m);

        }
        else if(n == 2){
            if(m==1||m==2){System.out.println(0);}else System.out.println(2);
        }
        else if(n == 1||n == 0){
            if(m==1){System.out.println(0);}else System.out.println(1);
        }
    }
}