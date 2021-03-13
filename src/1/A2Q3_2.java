public class A2Q3_2 {
    public static void main(String[] args){
        String[] array1 = {"A+", "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-", "F"};
        double[] number = {4.00, 3.94, 3.85, 3.73, 3.55, 3.32, 3.09, 2.78, 2.42, 2.08, 1.63, 1.15, 0};
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
            score[i/2] = Double.parseDouble(args[i]);
            credit[i/2]= Integer.parseInt(args[i+1]);
        }

        // calculate GP
        double[] GP = new double[args.length/2];
        double total=0;
        double sum=0;
        for (int i=0; i<args.length/2; i++){
            double m=0;
            if (score[i]>96){
                m=4.00;
            } else if (score[i]>=92.5){
                m=3.94;
            } else if (score[i]>=89.5){
                m=3.85;
            } else if (score[i]>=86.5){
                m=3.73;
            } else if (score[i]>=82.5){
                m=3.55;
            } else if (score[i]>=79.5){
                m=3.32;
            } else if (score[i]>=76.5){
                m=3.09;
            } else if (score[i]>=72.5){
                m=2.78;
            } else if (score[i]>=69.5){
                m=2.42;
            } else if (score[i]>=66.5) {
                m=2.08;
            } else if (score[i]>=62.5) {
                m=1.63;
            } else if (score[i]>=59.5) {
                m=1.15;
            } else if (score[i]>=0) {
                m=0;
            }

            GP[i]=m*credit[i];
            total+=GP[i];
            sum+=credit[i];
        }


        double GPA=0.0;
        GPA=total/sum;

        System.out.printf("GPA = %.2f",GPA);
    }
}