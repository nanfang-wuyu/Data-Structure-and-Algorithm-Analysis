import java.util.*;

public class dsaa20190064new {

    static ArrayList<Long>l;
    static long sum;
    static int mid;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int r = 0;r<T;r++) {
            int N = in.nextInt();
            if(N==1) {
                System.out.println(in.nextInt());
                continue;
            }
            l = new ArrayList<>();
            mid = 0;
            for(int i = 0;i<N;i++)l.add(in.nextLong());
            quickSort(l,0,l.size()-1);
            sum = 0;
            caculate();
            System.out.println(sum);
        }
    }

    public static void caculate(){
        if(l.size()==1)return;
        long m = l.get(0)+l.get(1);
        sum+=m;
        int i;
        for(i = 0;i<l.size();i++){
            if(l.get(i)>=m){
                break;
            }
        }
        //half_searching(0,l.size()-1,m);
        l.add(i,m);
        l.remove(0);
        l.remove(0);
        caculate();
    }

    public static void quickSort(ArrayList<Long>sort,int l,int r){

        if(l>=r){
            return;
        }
        else{
            Random ran = new Random();
            int i = ran.nextInt(r-l+1)+l;
            long temp = sort.get(l);
            sort.set(l,sort.get(i));
            sort.set(i,temp);
            long v = sort.get(l);
            int lt = l;
            int gt = r+1;
            i = l + 1;

            while (i<gt){
                if(sort.get(i)<v){
                    temp = sort.get(lt+1);
                    sort.set(lt+1,sort.get(i));
                    sort.set(i,temp);
                    lt++;
                    i++;
                }else if(sort.get(i)>v){
                    temp = sort.get(gt-1);
                    sort.set(gt-1,sort.get(i));
                    sort.set(i,temp);
                    gt--;
                }else {i++;}
            }
            temp = sort.get(l);
            sort.set(l,sort.get(lt));
            sort.set(lt,temp);
            lt--;
            quickSort(sort,l,lt);
            quickSort(sort,gt,r);
        }
    }
}
/*public static void half_searching(int left, int right, long m){
        if(left>right)return;
        mid = (left+right)/2;
        if(l.get(mid)==m)return;
        else if(l.get(mid)>m)right = mid-1;
        else left = mid+1;
        half_searching(left,right,m);
    }*/

//最小两个 Huffman internal roots sum  放到合适位置放进去
/*
import java.util.*;

public class dsaa20190064new {

    static ArrayList<Long>l;
    static int mid;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int r = 0;r<T;r++) {
            int N = in.nextInt();
            l = new ArrayList<>();
            mid = 0;
            for(int i = 0;i<N;i++)l.add(in.nextLong());
            quickSort(l,0,l.size()-1);
            for(int i = 0;i<l.size();i++){
                if(l.get(i)==0){
                    l.remove(i);
                    i--;
                }
            }
            if(l.size()<=1){
                System.out.println(0);
                continue;
            }
            caculate();
            System.out.println(l.get(0));
        }
    }

    public static void caculate(){
        if(l.size()==1)return;
        long m = l.get(0)+l.get(1);
        //System.out.println(m);
        half_searching(0,l.size()-1,m);
        l.add(mid+1,m);
        l.remove(0);
        l.remove(0);
        caculate();
    }

    public static void quickSort(ArrayList<Long>sort,int l,int r){

        if(l>=r){
            return;
        }
        else{
            Random ran = new Random();
            int i = ran.nextInt(r-l+1)+l;
            long temp = sort.get(l);
            sort.set(l,sort.get(i));
            sort.set(i,temp);
            long v = sort.get(l);
            int lt = l;
            int gt = r+1;
            i = l + 1;

            while (i<gt){
                if(sort.get(i)<v){
                    temp = sort.get(lt+1);
                    sort.set(lt+1,sort.get(i));
                    sort.set(i,temp);
                    lt++;
                    i++;
                }else if(sort.get(i)>v){
                    temp = sort.get(gt-1);
                    sort.set(gt-1,sort.get(i));
                    sort.set(i,temp);
                    gt--;
                }else {i++;}
            }
            temp = sort.get(l);
            sort.set(l,sort.get(lt));
            sort.set(lt,temp);
            lt--;
            quickSort(sort,l,lt);
            quickSort(sort,gt,r);
        }
    }

    public static void half_searching(int left, int right, long m){
        if(left>right)return;
        mid = (left+right)/2;
        if(l.get(mid)==m)return;
        else if(l.get(mid)>m)right = mid-1;
        else left = mid+1;
        half_searching(left,right,m);
    }
}

//最小两个 Huffman internal roots sum  放到合适位置放进去
*/
