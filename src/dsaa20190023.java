import java.util.Scanner;
import java.util.Random;
public class dsaa20190023 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long  m = in.nextLong();
        long arr[] = new long[n];
        long count = 0;
        int q = 0;
        for(int i = 0;i<n;i++){
            long p = in.nextLong();
            if(p<m-1){
            arr[q] = p;
                q++;}
        }
        //quickSort(arr,0,q-1);


    /*for(int i = 0;i<q-2;i++){
        for(int j = i+1;j<q-1;j++){
            if(arr[i]+arr[j]>=m){break;}
            for(int k = j+1;k<q;k++){
                if(arr[i]+arr[j]+arr[k]==m){
                    count++;
                }
            }
        }
    }System.out.println(count);*/
    int i = 0;
    int j = i + 1;
    int k = j + 1;
    while(i!=q-2) {

        if (arr[i] + arr[j] + arr[k] == m) {
            count++;
        }
        k++;
        if (k == q) {
            j++;
            k = j + 1;
            if (j == q - 1) {
                i++;
                j = i + 1;
                k = j + 1;
            }
        }
        //System.out.println(i);
    }System.out.println(count);


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