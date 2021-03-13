import java.util.ArrayList;
import java.util.Scanner;

public class dsaa20190034 {

    static class Node{
        int num;
        int index = 0;
        Node next;
        Node prev;

        public Node(){
            num = 0;
            index = 0;
        }
        public Node(int num, int index){
            this.num = num;
            this.index = index;
        }
    }

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int r = 0;r<T;r++){
            ArrayList<Node>list = new ArrayList<>();
            int n = in.nextInt();
            int m = in.nextInt();
            Node head = new Node(in.nextInt(),1);
            Node tail = head;
            list.add(null);
            list.add(head);
            for(int i = 2;i<n+1;i++){
                list.add(new Node(in.nextInt(),i));
            }
            int exsit = n;
            int b = 0;//余数
            int t = 1;//上一个淘汰的人index
            while(exsit!=1){
                b = m % exsit;
                if(b==0){b=exsit;}
                if(t-1+b<=list.size()-1){t = t-1+b;}
                else {t = t-list.size()+b;}
                m = list.get(t).num;
                exsit--;
                list.remove(t);
            }
            System.out.println(list.get(1).index);
        }
    }
}

    /*Node []list = new Node[n+1];
    Node head = new Node(in.nextInt());
    Node tail = head;
        list[1] = head;
                for(int i = 2;i<n+1;i++){
        list[i] = new Node(in.nextInt());
        list[i-1].next = list[i];
        list[i].prev = list[i-1];
        }
        list[n].next = list[1];
        list[1].prev =list[n] ;
        int exsit = n;
        int b = 0;//余数
        int t = 0;//上一个淘汰的人index
        //第一圈
        b = (m+t) % exsit;
        exsit--;
        list[b+t]*/