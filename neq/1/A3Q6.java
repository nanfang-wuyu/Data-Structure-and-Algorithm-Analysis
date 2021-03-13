import java.util.Scanner;

public class A3Q6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int a[][] = new int[m][n];
        int sp[][] = new int[m][n];//shortest path ;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                a[i][j]=in.nextInt();
            }
        }
        sp[0][0]=a[0][0];
        //System.out.println(sp[0][0]);
        for(int i=1;i<n;i++)
        {
            sp[0][i]=sp[0][i-1]+a[0][i];
        }
        for(int i=1;i<m;i++)
        {
            sp[i][0]=sp[i-1][0]+a[i][0];
        }
        for(int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){
                sp[i][j] = Math.min(sp[i][j-1],sp[i-1][j])+a[i][j];
                //System.out.println(sp[i][j]);
            }
        }
        System.out.println(sp[m-1][n-1]);
    }
}