import java.util.Scanner;

public class Practice {
    public static void main(String[] args){


        Scanner in = new Scanner(System.in);
        int counter=0;
        final int ARRAY_LENGTH=10;
        int[]array=new int[ARRAY_LENGTH];

        for (counter=0;counter<array.length;counter++)
        array[ counter ]=2+2*counter;

        System.out.printf("%s%20s\n","Index","Value");

        for(counter=0;counter<array.length;counter++)
        System.out.printf("%5d%20d\n",counter,array[ counter ]);

    }
}
