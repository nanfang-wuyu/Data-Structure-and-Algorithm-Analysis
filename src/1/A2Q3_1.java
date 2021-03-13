public class A2Q3_1 {
    public static void main(String[] args) {
        String[] array1 = {"A+", "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-", "F"};
        double[] number = {4.00, 3.94, 3.85, 3.73, 3.55, 3.32, 3.09, 2.78, 2.42, 2.08, 1.63, 1.15, 0};
        double output = 0;
        for (int i = 0; i<array1.length;i++) {
            if (array1[i].equals(args[0])) {
                output = number[i];
                System.out.printf("%.2f\n", output);
            }


        }


    }
}
