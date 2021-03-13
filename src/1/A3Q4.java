import java.util.Scanner;

public class A3Q4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int a[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = in.nextInt();
            }
        }
        int T = in.nextInt();
        int Y = 4;
        int ma[][] = new int[T][Y];
        for (int i = 0; i < T; i++) {
            for (int j = 0; j < Y; j++) {
                ma[i][j] = in.nextInt();
            }
        }
        for (int i = 0; i < T; i++) {
            int sum = 0;
            int x1 = ma[i][0];
            int x2 = ma[i][2];
            int y1 = ma[i][1];
            int y2 = ma[i][3];
            //System.out.printf("%d %d %d %d\n",x1,y1,x2,y2);
            for (int p = x1; p < x2+1; p++) {
                for (int q = y1; q < y2+1; q++) {
                    sum = sum + a[p][q];
                    //System.out.println(sum);
                    //System.out.println(a[p][q]);
                }
            }System.out.println(sum);


        }
    }
}