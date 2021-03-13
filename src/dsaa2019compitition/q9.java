package dsaa2019compitition;
import java.util.*;
public class q9 {
    public static class Node{
        int key;
        int del;
        Node par;
        public Node(int key){
            this.key = key;
            this.del = 0;
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int anum = in.nextInt();
        int bnum = in.nextInt();
        Node []a = new Node[n];
        Node []b = new Node[n];
        Node []asort = new Node[n];
        Node []bsort = new Node[n];
        for(int i = 0;i<n;i++) a[i] = new Node(in.nextInt());
        for(int i = 0;i<n;i++) b[i] = new Node(in.nextInt());
        for(int i = 0;i<n;i++) {
            a[i].par = b[i];
            b[i].par = a[i];
        }
        quickSort(a,0,n-1);
        quickSort(b,0,n-1);
    }

    public static void quickSort(Node[]arr,int l,int r){

        if(l>=r){
            return;
        }
        else{Random ran = new Random();
            int i = ran.nextInt(r-l+1)+l;
            Node temp = arr[l];
            arr[l] = arr[i];
            arr[i] = temp;
            Node v = arr[l];
            int lt = l;
            int gt = r+1;
            i = l + 1;

            while (i<gt){
                if(arr[i].key<v.key){
                    temp = arr[lt+1];
                    arr[lt+1] = arr[i];
                    arr[i] = temp;
                    lt++;
                    i++;
                }else if(arr[i].key>v.key){
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
