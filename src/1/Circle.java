import java.util.Random;

public class Circle {

    private double x;
    private double y;
    private double r;

    public void setMoney(double x,double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public double area() {
        return r * r * Math.PI;
    }

    public double perimeter() {
        return 2 * Math.PI * r;
    }

    public void position() {
        System.out.printf("Position of the cricle is (%.1f,%.1f)\n", x, y);
    }

    public double distance() {
        return Math.sqrt(x*x+y*y);
    }

}