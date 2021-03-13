import java.util.*;

public class dsaa20190063 {

    static Scanner in = new Scanner(System.in);
    static int index;
    public static void main(String[] args) {
        int T = in.nextInt();
        for(int r = 0;r<T;r++){
            index = 0;
            int N = in.nextInt();
            int[]pre_order = new int[N];
            int[]in_order = new int[N];
            for(int i = 0;i<N;i++)pre_order[i] = in.nextInt();
            for(int i = 0;i<N;i++)in_order[i] = in.nextInt();
            findpost_order(pre_order,in_order,0,N-1);
            System.out.println();
        }
    }

    public static void findpost_order(int []pre_order, int []in_order, int left, int right){

        if(left>right)return;
        int root = pre_order[index++];
        int i = searching(root,in_order);
        findpost_order(pre_order,in_order,left,i-1);
        findpost_order(pre_order,in_order,i+1,right);
        System.out.print(root+" ");


    }

    public static int searching(int root, int[]in_order) {
        for(int i = 0;i<in_order.length;i++){
            if(root==in_order[i])return i;
        }
        System.out.println("wrong");
        return -1;
    }
}
