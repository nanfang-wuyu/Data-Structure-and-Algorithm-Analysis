import java.util.Scanner;

public class A1Q5 {
    public static void main(String[] args){


        Scanner in = new Scanner(System.in);
        int sum;
        sum=0;


            do { System.out.println("Enter the first number:");
                int n = in.nextInt();
                System.out.println("Enter the second number:");
                int m = in.nextInt();
                sum = n + m;
                System.out.printf("Sum of two number is %d\n", sum);

               if(sum!=100)

                    System.out.println("Sum does not equal 100, loop repeats\n");


            } while (sum != 100);


            System.out.println("Sum equals 100, loop terminates");












    }
}
