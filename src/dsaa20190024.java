import java.util.Scanner;
import java.util.Random;
public class dsaa20190024 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long arr[] = new long[n];
        for(int i = 0;i<n;i++){
           arr[i] = in.nextLong();
        }
        long sum = 0;
        MergeSort(arr,n);

        //System.out.println(sum);

    }

    public static void MergeSort(long[]arr,int n){

        if(n>1){
            int p = n/2;
            long []L = new long[p];
            long []R = new long[n-p];
            for(int i = 0;i<p;i++){
                L[i] = arr[i];
            }
            for(int i = 0;i<n-p;i++){
                R[i] = arr[i+p];
            }
            //System.out.println(p);
            MergeSort(L,p);
            MergeSort(R,n-p);
            long A[] = Merge(L,p,R,n-p);
            if(A.length == 3){
            for(int i = 0;i<A.length;i++){
                System.out.println(A[i]);
            }
            }
        }
    }

    public static long[] Merge(long[]L,int nl,long[]R,int nr){

        int n = nl+nr;
        //System.out.println(n);
        long[]A = new long[n];
        int i = 0;
        int j = 0;
        for(int k = 0;k<n;k++){
            if(i<nl&&(j>=nr||L[i]<=R[i])){
                A[k] = L[i];
                i = i+1;
            }else {
                A[k] = R[j];
                j = j+1;
            }
        }
        return A;
    }


}

//quickSort(arr,0,n-1);

            /*for(int j = 0;j<n-1;j++){
                for(int m = 1;m<n;m++){
                    if (arr[m-1] > arr[m]){
                        long temp = arr[m];
                        arr[m] = arr[m-1];
                        arr[m-1] = temp;
                        sum = sum + arr[m-1]+arr[m];

                    }
                }
            }*/

            /*int j = 0;
            int m = 1;
        while(j!=n-1){
            if (arr[m-1] > arr[m]){
                long temp = arr[m];
                arr[m] = arr[m-1];
                arr[m-1] = temp;
                sum = sum + arr[m-1]+arr[m];
            }
            m++;
            if(m == n){
                j++;
                m = 1;
            }
        }
*/
