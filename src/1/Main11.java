import java.util.Scanner;

public class Main11 {

    public static void main(String[] args) {

        int studentGrade;

        //creating object of Scanner class
        Scanner input = new Scanner(System.in);
        System.out.print("studentGrade");
        studentGrade = input.nextInt();

        String result = studentGrade >= 60 ? "Passed" : "Failed";
        System.out.printf("You got %s.\n ,result");
    }
}