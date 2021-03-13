import java.util.Scanner;
public class dsaa20190016 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int casenumber = in.nextInt();
        long [] a = new long[casenumber];
        for(int i = 0;i<casenumber;i++){
            a[i] = in.nextLong();
            int n = String.valueOf(a[i]).length();
            //long m = a[i]/5;
            long x = 0L;
            //long y = 0L;

                long m = a[i];
                while(m!=0){
                    m = (long)(m/(5));
                    x = x + m;
                }


            a[i] = x;
        }
        for(int i = 0;i<casenumber;i++){
            System.out.println(a[i]);
        }
    }
}

