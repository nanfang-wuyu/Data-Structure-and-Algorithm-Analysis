import java.util.Scanner;
public class dsaa20190001 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int casenumber = input.nextInt();

        for (int j = 0;j<casenumber;j++) {
            input.nextLine();
            String a[] = new String[3];

            for (int i = 0; i < 3; i++) {
                a[i] = input.nextLine();
            }

            Character c = a[1].charAt(2);

            System.out.printf("%s\n", c);
        }
    }
}
