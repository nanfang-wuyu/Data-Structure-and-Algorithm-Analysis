import java.util.Scanner;
import java.util.ArrayList;
public class dsaa20190006 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int casenumber = input.nextInt();
        ArrayList<Integer> a = new ArrayList<Integer>();
        double t[] = new double[casenumber];
        for( int i = 0;i<casenumber;i++){
            t[i] = input.nextInt();
        }
        for( int i = 0;i<casenumber;i++){
            if(t[i]<3){System.out.println("impossible");}else
            {double p = t[i];
                while (p % 2 == 0) {
                    p = p / 2;
                }
                if(p==1){System.out.println("impossible");}
                else
                    for(double n = 1;n<t[i];n++){

                        double x =( t[i]/(n+1)-n/2 );
                        if(x%1==0){
                        System.out.println((int) n+1);
                        break;
                        }


                    }
            }
        }
    }
}



 /*System.out.println(x+" "+n);
                        int q = String.valueOf(x).indexOf(".");
                        String x0 =  String.valueOf(x).substring(0,q);
                        int x1 = Integer.parseInt(x0);
                        if(x%x1==0&&x>0){
                            System.out.println((int) n+1);
                            break;
                        }*/
