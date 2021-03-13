public class A1Q3 {
    public static void main(String[] args){
        int lecture_attendance = Integer.parseInt (args[0]);
        int lab_attendance = Integer.parseInt (args[1]);
        int assignments = Integer.parseInt (args[2]);
        int project = Integer.parseInt (args[3]);
        int exam = Integer.parseInt (args[4]);
        double total;


        total=lecture_attendance*0.1+lab_attendance*0.1+assignments*0.3+project*0.2+exam*0.3;

        if(total >=80) {
            System.out.println("A");
            System.out.printf("%.2f", total);
        }
        else
            if (total>=50){
                System.out.println("B");
                System.out.printf("%.2f", total);
            }else {
                System.out.println("C");
                System.out.printf("%.2f", total);
            }







    }
}
