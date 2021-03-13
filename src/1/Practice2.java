import java.util.Scanner;

public class Practice2 {
    public static void main(String[] args){


        Scanner in = new Scanner(System.in);
        int sum=0;
            int []array={1,3,5,7,9};
        int i=0;
        int j=1;
        int couple=0;
        int average=5;
        for(i=0;i<array.length;i++){
            for(j=0;j<array.length&&j!=i;j++) {
                sum = array[i] + array[j];
                if (sum > 10) {
                    couple++;
                }
            }
            }
            System.out.printf("%d\n",couple);









    }
}
