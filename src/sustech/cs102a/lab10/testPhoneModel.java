package sustech.cs102a.lab10;
import java.util.EnumSet;
import java.util.Scanner;

public class testPhoneModel {
    public static void main (String args[]){
        Scanner in = new Scanner(System.in);
        System.out.print("Your budget:");
        int budget = in.nextInt();

        if(budget<5588) {
            System.out.println("\nYou do not have sufficient money !");
        }
        for (PhoneModel phone : PhoneModel.values()) {
            if (budget>=phone.getPrice()) {
                System.out.printf("%-10s", phone);
                System.out.printf("price: %-30s\n", phone.getPrice());
            }

        }

    }
}

