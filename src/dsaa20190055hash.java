import java.util.*;

public class dsaa20190055hash {

    static long b = 100000007;
    static Scanner in = new Scanner(System.in);
    static String S1;
    static String S2;
    static char[] c;
    static char[] t;

    public static void main(String[] args) {

        S1 = in.next();
        S2 = in.next();
        int l1 = S1.length();
        int l2 = S2.length();
        if (l1 > l2) {
            String temp = S2;
            S2 = S1;
            S1 = temp;
        }//to make S1 shorter
        c = S1.toCharArray();
        t = S2.toCharArray();
        int n = half_cutting();
        System.out.println(n);

    }

    public static int half_cutting(){
        int mid = 0;
        int left = 0;
        int right = S1.length()-1;
        while (left <= right) {
            mid = (left + right) / 2;
            //System.out.println("mid"+mid);System.out.println("left"+left);System.out.println("right"+right);
            if (hash(mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
                if(right==left-1)mid--;
            }//System.out.println("mid"+mid);System.out.println("left"+left);System.out.println("right"+right);
        }
        return mid+1;
    }

    public static boolean hash(int mid){
        String T = S2;
        int m = mid+1;//prefix length
        int n = T.length();
        long q = 1;
        for(int i = 0;i<m;i++) q *= b;

        long Thash = 0;
        for(int i = 0;i<m;i++) Thash = Thash * b + t[i];
        long []Thasharray = new long[n+1-m];
        Thasharray[0] = Thash;
        for(int i = 1;i+m<n+1;i++){
            Thasharray[i] = Thasharray[i-1]*b-t[i-1]*q+t[m+i-1];
        }
        quickSort(Thasharray,0,n-m);

        char [] s1 = S1.toCharArray();
        int l1 = S1.length();
        long Chash = 0;
        for(int i = 0;i<m;i++) Chash = Chash * b + c[i];
        long []Chasharray = new long[l1+1-m];
        Chasharray[0] = Chash;
        if(half_searching(0, n - m, Chasharray[0], Thasharray))return true;
        for(int i = 1;i+m<l1+1;i++){
            Chasharray[i] = Chasharray[i-1]*b-c[i-1]*q+c[m+i-1];
            if(half_searching(0, n - m, Chasharray[i], Thasharray))return true;
        }
        return false;
    }

    public static boolean half_searching(int left, int right, long Chash, long[] Thasharray){

        int mid = 0;
        while(left<=right){
            mid = (left + right)/2;
            //System.out.println(Thasharray[mid]+"mid"+mid);
            if(Chash == Thasharray[mid])return true;
            else if(Chash<Thasharray[mid])right = mid - 1;
            else left = mid + 1;
        }return false;
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
/* public static boolean hashline(int mid) {
        for(int i = 0;mid+i<S1.length();i++){
            if(hash(S1.substring(i,mid+i+1))){
                return true;
            }
        }return false;
    }*/