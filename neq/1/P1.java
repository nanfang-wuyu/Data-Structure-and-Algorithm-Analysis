import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        do {
        System.out.println("Please input three numbers for a, b, c,");
        double a = in.nextDouble();

        double area = 0;
        double perimeter = 0;
        double p = 0;

            if (a != -1) {
                double b = in.nextDouble();
                double c = in.nextDouble();
                if (isValid(a, b, c)) {
                    System.out.printf("The area is %.3f\nThe perimeter is%.3f\n", area(a, b, c), perimeter(a, b, c));
                } else System.out.println("The input is invalid.");
            } else if (a == -1) {
                System.out.println("Bye~");
                break;
            }continue;
        }while(true);
    }
    public static double area(double a, double b, double c) {
        double area = 0;
        double p = 0;
        p = (a + b + c) / 2;
        area = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        return area;
    }
    public static double perimeter(double a, double b, double c) {
        Scanner in = new Scanner(System.in);
        double perimeter=0;
            perimeter = a + b + c;
        return perimeter;
    }
    public static boolean isValid(double a, double b, double c) {
        boolean testResult = true;
        if (a + b > c && a + c > b&&b+c>0) {
           testResult = true;
        }

        if (a + b <=c||a + c <= b||b+c<=0){
           testResult = false;
        }
        return testResult;
    }
}




