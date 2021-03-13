import java.util.Scanner;

public class A3Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s=in.nextInt();
        int[] c = new int[300000];
        int[] w = new int[300000];
        int[] f = new int[300000];
        int x = 0;
        int e = 1;


        for(int u=0;u<s;u++) {


            int[] a = new int[2];

            for (int i = 0; i < a.length; i++) {
                a[i] = in.nextInt();
            }

            w[e]=w[e-1]+a[1];
            f[e]=a[1];
            e++;



            int[] b = new int[a[1] * a[0]];
            for (int i = 0; i < a[0]; i++) {
                for(int j=0;j<a[1];j++){
                    b[i+j*a[0]] = in.nextInt();
                }
            }




            for (int i = 0; i < a[1]; i++) {x++;
                for (int j = i * a[0]; j < a[0] * (i + 1); j++) {
                    for (int k = i * a[0]; k < a[0] * (i + 1)-1; k++) {
                        int media = 0;
                        if (b[k] > b[k + 1]) {
                            media = b[k];
                            b[k] = b[k + 1];
                            b[k + 1] = media;
                        }

                    }
                }


                int min = b[i * a[0]];
                for (int p = min; p >c[x]; p--) {
                    for (int q = i * a[0]; q<(i+1) * a[0]; q++) {
                        if(b[q] % p != 0){
                            break;}
                        else if ((q+1)%a[0]==0) {
                            c[x] = p;
                        }
                    }
                }
            }


            if(u==s-1)
                for(int r=1;r<e;r++) {
                    for (int i = 1+w[r-1]; i <= w[r]; i++) {
                        if (i % w[r] == 0) {
                            System.out.println(c[i]);
                        } else {
                            System.out.printf("%d ", c[i]);}

                    }



                }

        }

    }
}