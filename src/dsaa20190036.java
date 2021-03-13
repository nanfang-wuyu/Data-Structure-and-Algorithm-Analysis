import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class dsaa20190036 {

    static class Node{
        int num;
        int index;
        Node next;
        Node prev;

        public Node(){

        }
        public Node(int num, int index){
            this.num = num;
            this.index = index;
        }
    }

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Node []list = new Node[n];
        Node head = new Node(in.nextInt(),0);
        Node tail = head;
        list[0] = head;
        for(int i = 1;i<n;i++){
            list[i] = new Node(in.nextInt(),i);
        }
        Node []sort = list;
        for(int i = 1;i<n;i++){
            tail.next = list[i];
            list[i].prev = tail;
            tail = list[i];
        }
        quickSort(sort,0,n-1);
    }

    public static void quickSort(Node[]arr,int l,int r){

        if(l>=r){
            return;
        }
        else{
            Random ran = new Random();
            int i = ran.nextInt(r-l+1)+l;
            Node temp = arr[l];
            arr[l] = arr[i];
            arr[i] = temp;
            Node v = arr[l];
            int lt = l;
            int gt = r+1;
            i = l + 1;

            while (i<gt){
                if(arr[i].num<v.num){
                    temp = arr[lt+1];
                    arr[lt+1] = arr[i];
                    arr[i] = temp;
                    lt++;
                    i++;
                }else if(arr[i].num>v.num){
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