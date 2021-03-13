import java.util.Scanner;
import java.util.Random;
public class dsaa20190025 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
       int n = in.nextInt();
       int p = in.nextInt();
       int q = in.nextInt();
       long hp[] = new long[n];
       long att[] = new long[n];
       long c[] = new long[n];
       long d[] = new long[n];
       //long e[] = new long[n] ;
       for(int i = 0;i<n;i++){
           hp[i] = in.nextLong();
           att[i] = in.nextLong();
           //c[i] = hp[i] - att[i];
       }
       long sum = 0;
       if(q == 0){
           for(int i = 0;i<n;i++){
               sum += att[i];
           }
       }
       else
       {
           int k = 0;
           for(int i = 0;i<n;i++){
               c[i] = (long) Math.pow(2,p)*hp[i] - att[i];
           }
           for(int i = 0;i<n;i++){
               if(c[k]<c[i]){
                   k = i;
               }else if(c[k]==c[i]){
                   if(hp[k]-att[k]>hp[i]-att[i]){
                       k = i;
                   }
               }
           }
           if(c[k]>0){
           att[k] = c[k]+att[k];
           //att[k] = 0;
           }

           if(q>1){
               for(int i = 0;i<n;i++){
                   d[i] = hp[i] - att[i];
               }
               d[k] = 0;
               quickSort(hp,att,d,0,n-1);
               for(int i = n-1;i>=0;i--){
                   if(d[i] > 0&&q>1){
                       sum = sum + hp[i];
                       q--;
                   }else {sum = sum + att[i];}
               }
           }else {
               for(int i = 0;i<n;i++){
                   sum += att[i];
               }
           }
       }
       System.out.println(sum);
       //System.out.println((long) Math.pow(2,18));
    }

    public static void quickSort(long[]hp,long[]att,long[]arr,int l,int r){

        if(l>=r){
            return;
        }
        else{


            Random ran = new Random();
            int i = ran.nextInt(r-l+1)+l;
            long temp = arr[l];
            arr[l] = arr[i];
            arr[i] = temp;
            temp = hp[l];
            hp[l] = hp[i];
            hp[i] = temp;
           temp = att[l];
            att[l] = att[i];
            att[i] = temp;
            long v = arr[l];
            int lt = l;
            int gt = r+1;
            i = l + 1;

            while (i<gt){
                if(arr[i]<v){
                    temp = arr[lt+1];
                    arr[lt+1] = arr[i];
                    arr[i] = temp;
                    temp = hp[lt+1];
                    hp[lt+1] = hp[i];
                    hp[i] = temp;
                    temp = att[lt+1];
                    att[lt+1] = att[i];
                    att[i] = temp;
                    lt++;
                    i++;
                }else if(arr[i]>v){
                    temp = arr[gt-1];
                    arr[gt-1] = arr[i];
                    arr[i] = temp;
                    temp = hp[gt-1];
                    hp[gt-1] = hp[i];
                    hp[i] = temp;
                    temp = att[gt-1];
                    att[gt-1] = att[i];
                    att[i] = temp;
                    gt--;
                }else {i++;}
            }
            temp = arr[l];
            arr[l] = arr[lt];
            arr[lt] = temp;
            temp = hp[l];
            hp[l] = hp[lt];
            hp[lt] = temp;
            temp = att[l];
            att[l] = att[lt];
            att[lt] = temp;
            lt--;
            quickSort(hp,att,arr,l,lt);
            quickSort(hp,att,arr,gt,r);
            //System.out.println(arr[k]);
        }
    }



}