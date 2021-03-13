import java.util.Scanner;


public class math {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        double b = 0.00823;
        double u = 981;
        double g = 9.79;
        double n = 0.0000183;
        double p = 101300;
        double d = 0.005;
        double l = 0.0016;
        double tg=0;
        double te=0;
        double U =0;
        double r = 0;
        System.out.println("tg");
        tg = in.nextDouble();
        System.out.println("te");
        te = in.nextDouble();
        System.out.println("U");
        U = in.nextDouble();
        r = Math.sqrt(9*n*l/(2*u*g*tg));
        System.out.printf("r=%.8f",r);
        double q = 18*Math.PI/(Math.sqrt(2*u*g))*(1/tg+1/te)*Math.sqrt(1/tg)*d/U*Math.pow(n*l/(1+b/(p*r)),3/2);
        System.out.printf("r=%.8f,q=%.8f",r,q);
    }

}
