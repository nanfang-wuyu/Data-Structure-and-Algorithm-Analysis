import java.util.Scanner;


public class Pi1 {

    public static void main(String[] args) {
        float Pi = 0;
        double Pi_d=0;
        float Pi_f=0;
        Scanner in = new Scanner(System.in);
        System.out.println("Please input n:");
        int n = in.nextInt();
        in.close();
        int i = 1;


            for(i=0;i <= n;Pi_d -= 4.0 / (2 * i - 1))

            {
              for ( i++;i<=n;Pi_d += 4.0 / (2 * i - 1));
            }
        System.out.printf("The estimatioin of Pi_d is %.6f \n", Pi_d);

    }

}
