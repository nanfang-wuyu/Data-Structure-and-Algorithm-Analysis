import java.util.Scanner;

public class A3Q3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int a[][] = new int[m][n];
        int t=0;

        for(int j=1;j<100;j++){
            for(int p=n-j;p>j-1;p--){
                t++;
                a[j-1][p]=t;
                if(t==m*n){
                    break;
                }
            }
            for(int q=j-1;q<m-j;q++){
                t++;
                a[q][j-1]=t;
                if(t==m*n){
                    break;
                }
            }

            for(int x=j-1;x<n-j;x++){
                t++;
                a[m-j][x]=t;
                if(t==m*n){
                    break;
                }
            }
            for(int y=m-j;y>j-1;y--){
                t++;
                a[y][n-j]=t;
                if(t==m*n){
                    break;
                }
            }




        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(j!=n-1) {System.out.printf("%-2d ",a[i][j]);}
                if(j==n-1) {System.out.printf("%-2d\n",a[i][j]);}
            }
        }


    }
}