public class A2Q2 {
    public static void main(String[] args) {
        double average = 0.0;
        double mode = 0.0;
        double median = 0.0;
        double sum = 0.0;
        double[] number = new double[args.length];


        double x = 0;
        int y = 0;

        //1. to get the input numbers and store in array
        for (int i = 0; i < args.length; i++) {
            number[i] = Double.parseDouble(args[i]);
            sum += number[i];
        }
        average = sum / args.length;


        System.out.printf("average = %.2f\n", average);


        //3. count numbers
        int[] count = new int[args.length];
        int maxCount = 0;

        for (int i = 0; i < args.length - 1; i++) {
            for (int j = 0; j < args.length - 1 - i; j++) {
                double media = 0;
                if (number[j] > number[j + 1]) {
                    media = number[j];
                    number[j] = number[j + 1];
                    number[j + 1] = media;
                }
            }
        }


        for (int i = 0; i < args.length; i++) {
            count[i] = 0;
            for (int j = i; j < args.length; j++) {

                if (number[i] == number[j]) {
                    count[i]++;
                }
            }
        }



        for (int i = 0; i < args.length; i++) {
            if (count[i] > maxCount) {
                maxCount = count[i];
            }
        }

        System.out.print("mode=");
        for (int i = 0; i < args.length; i++) {

            if (count[i] == maxCount) {
                System.out.printf("%.2f,", number[i]);
            }
        }


        //3.1 find the max count

        //3.2 find the mode with max count



         if (args.length%2==1) {
             median = number[(args.length  / 2)];
         }else if(args.length%2==0){
             median = (number[(args.length/ 2)]+number[((args.length-2) /2)])/2;
         }

        // 4.2 median
        System.out.printf("\nmedian = %.2f",median);

    }
}

