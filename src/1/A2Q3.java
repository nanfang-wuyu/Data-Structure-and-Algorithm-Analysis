public class A2Q3 {
    public static void main(String[] args){
        double[] score;
        int[] credit;

        if (0==args.length || 0 != args.length%2){
            System.out.println("Please input the right format of score and credit hour in pair, eg. 95 2 88 3");
            return;
        }

        score = new double[args.length/2];
        credit = new int[args.length/2];
        // to get the input numbers and store in array

        for (int i=0; i<args.length; i+=2){

        }

        // calculate GP
        double[] GP = new double[args.length/2];
        for (int i=0; i<args.length/2; i++){

        }
        double GPA=0.0;

        System.out.printf("GPA = %.2f",GPA);
    }
}