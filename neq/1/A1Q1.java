public class A1Q1 {
    public static void main(String[] args){
        float radius = Float.parseFloat(args[0]);
        double perimeter;
        double pi=3.14;
        double area;
        perimeter=2*pi*radius;
        area=pi*radius*radius;

        System.out.printf("%.2f \n%.2f \n",perimeter,area );




    }
}
