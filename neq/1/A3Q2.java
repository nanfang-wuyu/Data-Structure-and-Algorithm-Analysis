import java.util.Scanner;

public class A3Q2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s= in.nextInt();

        int[]a=new int[s];
        int[]b=new int[s];
        for(int i=0;i<a.length;i++){
            a[i]=in.nextInt();
            b[i]=a[i];
        }

        for (int j = 0; j < b.length-1; j++) {
            for (int k = 0; k <b.length-1 ; k++) {
                int media = 0;
                if (b[k] > b[k + 1]) {
                    media = b[k];
                    b[k] = b[k + 1];
                    b[k + 1] = media;
                }

            }
        }
        int max=b[s-1];
        int min=b[0];
        int store=0;
        int left=0;
        int right=0;

        for(int i=0;i<max;i++){
            for(int j=0;j<s;j++){
                if(a[j]>0){
                    left=j;
                    break;
                }
            }//System.out.printf("left=%d\n",left);
            for(int j=s-1;j>=0;j--){
                if(a[j]>0){
                    right=j;
                    break;
                }
            }//System.out.printf("right=%d\n",right);
            for(int j=left;j<right;j++){
                if(a[j]<=0){
                    store=store+1;
                    //System.out.println(store);
                }continue;
            }
            for(int j=0;j<s;j++){
                a[j]=a[j]-1;
            }
        }

        System.out.println(store);




    }
}