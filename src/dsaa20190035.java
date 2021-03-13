import java.util.ArrayList;
import java.util.Scanner;

public class dsaa20190035 {

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int r = 0;r<T;r++){
            dsaa20190035 dsaa = new dsaa20190035();
            int n = in.nextInt();
            long m = in.nextLong();
            long max = m;
            if(m==0||m==1){System.out.println(m);}
            else {
                ArrayList<Long>list = new ArrayList<>();
                //list.add(m);
                //m = dsaa.pow(m,n,list);
                System.out.println(dsaa.catchNum(m,n,max,list));
            }
        }
    }
    public long catchNum(long m, int n, long max, ArrayList<Long>list){
        boolean loop = false;
        while(!loop) {
            if (String.valueOf(m).length() <= n) {
                //System.out.println(String.valueOf(m).length());
                if(m>max) {
                    max = m;
                }if (list.contains(m)) {
                    return max;
                }
                list.add(m);
                m *= m;

            } else {
                //StringBuffer sb = new StringBuffer();
                //sb = sb.append(m).substring(0,n);
                //String pre = String.valueOf(m).substring(0,n);
                //pre = pre.substring(0, n);
                //m = Long.parseLong(Long.toString(m).substring(0,n));
                int p = Long.toString(m).length()-n;
                m = m/((long)Math.pow(10,p));
                if(m>max) {
                    max = m;
                }if (list.contains(m)) {
                    return max;
                }
                list.add(m);
                m *= m;

            }
        }
        return max;
    }

    /*public long pow(long m, int n, ArrayList<Long>list){
        while(m<(long)Math.pow(10,n)&&m!=1){
            m *= m;
        }
        clean(m,n,list);
        return m;
    }

    public long clean(long m, int n, ArrayList<Long>list){
        while(String.valueOf(m).length()>n){String pre = String.valueOf(m);
            pre = pre.substring(0,n);
            m = Long.parseLong(pre);
            m *= m;
        }
        pow(m,n,list);
        return m;
    }*/
}