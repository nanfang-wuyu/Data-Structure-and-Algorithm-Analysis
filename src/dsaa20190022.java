import java.util.Scanner;
import java.util.Random;
public class dsaa20190022 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int arr[] = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = in.nextInt();
        }
        quickSort(arr,0,n-1,k);
        System.out.println(arr[k-1]);
    }

    public static void quickSort(int[]arr,int l,int r,int k){

        if(l>=r){
            return;
        }
        else{Random ran = new Random();
            int i = ran.nextInt(r-l+1)+l;//0~bound-1
            int temp = arr[l];
            arr[l] = arr[i];
            arr[i] = temp;
            int v = arr[l];
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
            quickSort(arr,l,lt,k);
            quickSort(arr,gt,r,k);
            //System.out.println(arr[k]);
        }
    }



}