import java.util.Scanner;
public class dsaa20190003 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int casenumber = input.nextInt();

        input.nextLine();
        int b[] = new int[13];
        String w[] = new String[casenumber];

        String a[] = {"W1", "W2", "W3", "W4", "W5", "W6", "W7", "W8", "W9", "T1", "T2", "T3", "T4", "T5", "T6", "T7", "T8", "T9", "Y1", "Y2", "Y3", "Y4", "Y5", "Y6", "Y7", "Y8", "Y9", "E", "S", "W", "N", "B", "F", "Z"};
        for (int i = 0; i < casenumber; i++) {

            w[i] = "";
            String l = input.nextLine();
            String c[] = l.split(" ");
            for (int j = 0; j < 13; j++) {
                for (int k = 0; k < a.length; k++) {

                    if (a[k].equals(c[j])) {
                        b[j] = k;
                        //System.out.printf("%s\n", b[j]);
                        break;

                    }
                }
            }

            for (int j = 0; j < b.length - 1; j++) {
                for (int k = 0; k < b.length - 1; k++) {
                    int media = 0;
                    if (b[k] > b[k + 1]) {
                        media = b[k];
                        b[k] = b[k + 1];
                        b[k + 1] = media;
                    }

                }
            }

            for (int j = 0; j < b.length; j++) {
                if (j == 12) {
                    w[i] += a[b[j]];
                } else w[i] += a[b[j]] + " ";
            }

            //continue;


            /*for (int j = 0; j < b.length; j++) {
                if (j == 12) {
                    System.out.printf("%s\n", a[b[j]]);
                } else {
                    System.out.printf("%s ", a[b[j]]);
                }
            }
            continue;*/

            // }
        }
        for(int i = 0;i<casenumber;i++) {
            System.out.printf("%s\n", w[i]);

        }
    }
}


