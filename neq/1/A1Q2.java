public class A1Q2 {
    public static void main(String[] args){
        float input = Float.parseFloat(args[0]);
        double CNY;
        double HKD;

        if(input >50) {
            CNY = input - 50;
            HKD = (1.17) * CNY;

            System.out.printf("%.2f", HKD);
        }
        else {
            System.out.println("0.00");

        }




    }
}
