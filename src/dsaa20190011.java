import java.util.Scanner;
public class dsaa20190011 {
    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
       int casenumber = in.nextInt();
       long [] a = new long[casenumber];
       for(int i = 0;i<casenumber;i++){
           int n = in.nextInt();
           a[i] = ((long)(Math.pow(n,3)+3*Math.pow(n,2)+2*n)/6);
       }
        for(int i = 0;i<casenumber;i++){
            System.out.println(a[i]);
        }
    }
}
/*public static int problemsNumber(int days){
        int problemsNumber = 0;
        for(int j = 1;j<=days;j++){
            problemsNumber = problemsNumber + ((j * (j + 1) )/ 2);
        }
        return problemsNumber;
    }*/