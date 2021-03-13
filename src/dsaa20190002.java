import java.util.Scanner;
public class dsaa20190002 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        /*int[][]a = new int[9][9];
        for(int i = 0;i<9;i++){
            for(int j=0 ;j<9;j++){
                if
                a[i][j] = input.nextInt();
                System.out.printf("%d ",a[i][j]);
            }


        }*/

        String w[][] = new String[9][9];
        int m = 0 ;
        boolean print = true;
        for(int i = 0;i<11;i++){

            if(i==3||i==7){
                input.nextLine();
            }else {
                //System.out.println(i);
                String l = input.nextLine();
                //System.out.println(l);
                String l2 = l.replace(" | "," ");
                String l3 = l.replace(" |","");
                String c[] = l3.split(" ");
                for(int j = 0;j<9;j++){
                    w[m][j] = c[j];
                    // System.out.printf("%s",w[m][j]);
                    //System.out.println(m);
                }
                m++;
            }

        }
        boolean ifx = false;
        /*for(int i = 0;i<9;i++){
            for(int j =0;j<9;j++) {
                if (w[i][j].equals("x")) {
                   ifx = true;
                }
            }
            //System.out.println(a[j]);
        }*/
        //System.out.println(ifx);
        /*if(!ifx){
            System.out.println("The test data is incorrect!");
        }*/
        do {
            boolean r = true;
            boolean c = true;
            boolean s = true;
            int time = 0;
            for (int i = 0; i < 9; i++) {
                int a[] = new int[9];
                time = 0;
                for (int j = 0; j < 9; j++) {

                    if (w[i][j].equals("x")) {
                        time++;
                    } else {
                        a[j] = Integer.parseInt(w[i][j]);

                        //System.out.println(a[j]);
                    }
                }
                //if(time>1){r = true;}
                if (time == 1) {
                    r = false;
                    int x = 45;
                    for (int k = 0; k < a.length; k++) {
                        x = x - a[k];

                    }
                    for (int j = 0; j < 9; j++) {
                        if (w[i][j].equals("x")) {
                            w[i][j] = String.valueOf(x);
                            break;
                        }

                        //System.out.println(a[j]);
                    }
                    //System.out.println("r"+x);

                }
            }

            //r


            for (int j = 0; j < 9; j++) {
                //System.out.println(w[3][7]);
                int a[] = new int[9];
                time = 0;
                for (int i = 0; i < 9; i++) {

                    if (w[i][j].equals("x")) {
                        time++;
                    } else {
                        a[i] = Integer.parseInt(w[i][j]);

                        //System.out.println(time);
                    }
                }
                //System.out.println(time);
                //if(time>1){   c= true;}
                if (time == 1) {
                    c = false;
                    int x = 45;
                    for (int k = 0; k < a.length; k++) {
                        x = x - a[k];
                    }
                    for (int i = 0; i < 9; i++) {
                        if (w[i][j].equals("x")) {
                            w[i][j] = String.valueOf(x);
                            //System.out.println(j);
                            //System.out.println("c"+x);
                            break;
                        }

                        //System.out.println(a[j]);
                    }


                    //System.out.println(w[4][7]);
                }
            }//c


            for (int p = 0; p < 7; p=p + 3) {

                for (int q = 0; q < 7; q=q + 3) {

                    int a[] = new int[9];
                    time = 0;
                    int n = 0;
                    int y = 0;
                    int z = 0;

                    for (int i = p; i < p + 3; i++) {

                        for (int j = q; j < q + 3; j++) {
                /*if(j%3==0&j!=0){
                    break;
                }*/
                            //System.out.println(q);
                            if (w[i][j].equals("x")) {
                                time++;
                                if(time == 1){
                                    y = i;z = j;
                                }
                            } else {
                                a[n] = Integer.parseInt(w[i][j]);
                                n++;
                            }
                        }

                    }
                    //if(time>1){s = true;}
                    if (time == 1) {
                        s = false;
                        int x = 45;
                        for (int k = 0; k < a.length; k++) {
                            x = x - a[k];
                        }
                        w[y][z] = String.valueOf(x);
                        //System.out.println("s"+x);
                        //break;
                        //System.out.println("a[0]"+a[0]);
                        //System.out.println("y"+y);


                    }
                }
            }//s*/
            ifx = false;
            for(int i = 0;i<9;i++){
                for(int j =0;j<9;j++) {
                    if (w[i][j].equals("x")) {
                        ifx = true;
                    }
                }
                //System.out.println(a[j]);
            }
            if(r==true&&c==true&&s==true){
                ifx = false;
                print = false;
            }
        }while (ifx == true);

        if(print == true) {
            for(int i = 0;i<9;i++){
            for(int j = 0;j<9;j++){
                if(j==8&i==8){System.out.printf("%s |",w[i][j]);}
                else if(j%3 == 2&j!=8){System.out.printf("%s | ",w[i][j]);}
                else if(i%3==2&j==8){System.out.printf("%s |\n\n",w[i][j]);}
            else if(j==8){System.out.printf("%s |\n",w[i][j]);}
            else {System.out.printf("%s ",w[i][j]);}
        }
        }
        }else System.out.print("The test data is incorrect!");
    }

    /*public boolean ifx (int w[][]){
        w[][]
        return ;
    }*/
}


