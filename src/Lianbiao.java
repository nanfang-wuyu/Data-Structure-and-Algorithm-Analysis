import org.w3c.dom.Node;

import java.util.Scanner;
public class Lianbiao {

    static class Node{

        int coe;//系数
        int exp;//指数
        Node next;




        public Node(int coe,int exp) {
            this.coe = coe;
            this.exp = exp;
        }
    }

    public static void main(String[] args){




        Node head = null;
        Node tail = null;
        Node a = new Node(1,1);
        head = a;
        tail = a;
        Node b = new Node(2,2);
        tail.next = b;
        tail = b;
        Node c = new Node(3,3);
        c.next = head.next;
        head.next = c;//插入c

        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int n = in.nextInt();
        long current = 0;
        //Node head = new Node();
        int m = in.nextInt();


    }


}
