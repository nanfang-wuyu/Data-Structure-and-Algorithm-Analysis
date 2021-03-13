import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
public class dsaa20190026 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int j = 0;j<T;j++) {
            int n = in.nextInt();
            ArrayList<Integer> m = new ArrayList();
            int num[][] = new int[2][];
            num[0] = new int[n];
            num[1] = new int[n];

            for (int i = 0;i<2*n;i+=2) {
                //m.add(in.nextInt());
                num[0][i] = in.nextInt();
                num[1][i] = in.nextInt();

            }

            //if()



            //int power = 0;
            for(int i = 0;i<n;i++){
               //if(m.get(i+1))
            }
        }



    }
    public static void sort(int[]arr){

    }

    public static void quickSort(long[]arr,int l,int r){

        if(l>=r){
            return;
        }
        else{Random ran = new Random();
            int i = ran.nextInt(r-l+1)+l;
            long temp = arr[l];
            arr[l] = arr[i];
            arr[i] = temp;
            long v = arr[l];
            int lt = l;
            int gt = r+1;
            i = l + 1;

            while (i<gt){
                if(arr[i]<v){
                    temp = arr[lt+1];
                    arr[lt+1] = arr[i];
                    arr[i] = temp;
                    lt++;
                    i++;
                }else if(arr[i]>v){
                    temp = arr[gt-1];
                    arr[gt-1] = arr[i];
                    arr[i] = temp;
                    gt--;
                }else {i++;}
            }
            temp = arr[l];
            arr[l] = arr[lt];
            arr[lt] = temp;
            lt--;
            quickSort(arr,l,lt);
            quickSort(arr,gt,r);
            //System.out.println(arr[k]);
        }
    }



}