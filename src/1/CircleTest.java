import java.util.Random;
public class CircleTest {
    public static void main(String[] args) {


            Random m = new Random();
            int small=0;
            int s=0;
            int N = 0;
            N = m.nextInt(5) + 5;

            double minarea=0;
            double mindistance=0;
            //System.out.println(N);
            for(int c=1;c<=N;c++){
            Random n = new Random();
            double x = 0;
            double y = 0;
            double r = 0;


            r = n.nextDouble() * 2 + 1;
            x = n.nextDouble() * 3 + 2;
            y = n.nextDouble() * 3 + 2;

            Circle c1 = new Circle();
            c1.setMoney(x, y, r);
            //5System.out.printf("The area of c1 is %.2f\n", c1.area());
            //System.out.printf("The perimeter of c1 is %.2f\n", c1.perimeter());
            //c1.position();


                if(minarea==0||minarea>c1.area()){minarea=c1.area();small=c;}//System.out.println(c1.area());
                if(mindistance==0||mindistance>c1.distance()){mindistance=c1.distance();s=c;}

            System.out.printf("Circle #%d: radius = %.2f, x = %.2f, y = %.2f\n",c, r, x, y);
        }System.out.printf("Circle #%d is the smallest circle, area = %.2f\n",small,minarea);
         System.out.printf("Circle #%d is the farthest circle, distance to origin = %.2f\n",s,mindistance);

    }


}