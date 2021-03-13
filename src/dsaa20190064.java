import java.util.*;

public class dsaa20190064 {

    static long sum;
    static long level;
    static int i;
    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);

        int T = in.nextInt();
        for(int r = 0;r<T;r++) {
            int N = in.nextInt();
            long[]L = new long[N];
            for(int i = 0;i<N;i++)L[i] = in.nextLong();
            quickSort(L,0,N-1);
            for(i = 0;i<N;i++){if(L[i]!=0)break;}
            if(i < N-1)sum = L[i]+L[i+1];
            else {
                System.out.println(0);
                continue;
            }
            i = i+2;
            level = sum;
            iteration(L);
            System.out.println(sum);

        }

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

    public static void iteration(long[]L){
        if(i>=L.length)return;
        level += L[i];
        sum += level;
        i++;
        iteration(L);
    }

}

//最小两个 Huffman internal roots sum  放到合适位置放进去
