import java.util.ArrayList;
import java.util.Scanner;

public class dsaa20190033 {

    static class Node{
        char m;
        Node next;
        Node prev;

        public Node(){
            this.m = '0';
        }
        public Node(char m){
            this.m = m;
        }
    }

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int r = 0;r<T;r++){
            int n = in.nextInt();
            dsaa20190033 dsaa = new dsaa20190033();
            String line = in.next();
            Node head = new Node();
            Node eol = new Node();
            head.next = eol;
            eol.prev = head;
            Node pointer = eol;
            char m = ' ';
            for(int i = 0;i<n;i++) {
                m = line.charAt(i);
                if(m=='r'){
                    if(i==n-1)continue;
                    i++;
                    m = line.charAt(i);
                    if(pointer!=eol) pointer.m = m;
                    else {
                        Node q = new Node(m);
                        pointer.prev.next = q;
                        q.prev = pointer.prev;
                        pointer.prev = q;
                        q.next = pointer;
                        pointer = q;
                    }
                }
                else if(m=='I'){
                    pointer = head.next;
                }
                else if(m=='H'){
                    if(pointer == head.next){continue;}
                    pointer = pointer.prev;
                }
                else if(m=='L'){
                    if(pointer == eol){continue;}
                    pointer = pointer.next;
                }
                else if(m=='x'){
                    if(pointer == eol){continue;}
                    pointer.prev.next = pointer.next;
                    pointer.next.prev = pointer.prev;
                    pointer = pointer.next;
                }
                else {
                    Node q = new Node(m);
                    pointer.prev.next = q;
                    q.prev = pointer.prev;
                    pointer.prev = q;
                    q.next = pointer;
                }
            }
            pointer = head.next;
            if(pointer==eol)System.out.println();
            while (pointer!=eol){
               if(pointer!=eol.prev||r==T-1)System.out.print(pointer.m);
               else {System.out.println(pointer.m);}
               pointer = pointer.next;
            }
        }
    }
}