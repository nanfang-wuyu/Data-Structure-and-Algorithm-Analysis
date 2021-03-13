import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please input three numbers for a, b, c,");
        double a = in.nextDouble();
        double b = in.nextDouble();
        double c = in.nextDouble();
        System.out.printf("%.3f%.3f%.3f",a,b,c);
    }
}
