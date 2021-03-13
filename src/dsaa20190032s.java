import java.util.Scanner;

public class dsaa20190032s {

    static class Node{
        int num;
        Node next;
        Node prev;

        public Node(){
            num = 0;
        }
        public Node(int num){
            this.num = num;
        }
    }

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        dsaa20190032s dsaa  =  new dsaa20190032s();
        int T = in.nextInt();
        for(int i = 0;i<T;i++ ){
            Node []list = new Node[in.nextInt()];
            int M = in.nextInt();
            if (list.length == 1){System.out.print(in.nextInt());}else {
                Node head = new Node();
                Node tail = head;
                for (int j = 0; j < list.length; j++) {
                    int num = in.nextInt();
                    list[num] = new Node(num);
                    tail.next = list[num];
                    list[num].prev = tail;
                    tail = tail.next;
                }
                head.next.prev = null;
                head = head.next;
                for (int j = 0; j < M; j++) {
                    int x1 = in.nextInt();
                    int y1 = in.nextInt();
                    int x2 = in.nextInt();
                    int y2 = in.nextInt();
                    //System.out.print(x1+" "+y1+" "+x2+" "+y2);
                    Node temp = list[y1].next;
                    if (list[y2].next != null) {
                        list[y2].next.prev = list[y1];
                        list[y1].next = list[y2].next;
                        list[y2].next = temp;
                        temp.prev = list[y2];
                    } else {
                        //list[y2].next.prev = list[y1];
                        list[y1].next = null;
                        list[y2].next = temp;
                        temp.prev = list[y2];
                    }
                    temp = list[x1].prev;
                    if (list[x1].prev != null) {
                        list[x2].prev.next = list[x1];
                        list[x1].prev = list[x2].prev;
                        list[x2].prev = temp;
                        temp.next = list[x2];
                    } else {
                        list[x2].prev.next = list[x1];
                        list[x1].prev = list[x2].prev;
                        list[x2].prev = null;
                        head = list[x2];//temp.next = list[x2];
                    }
                }
                Node temp = head;
                do {
                    if (temp.next != null) {
                        System.out.print(temp.num+" ");
                    } else {
                        System.out.println(temp.num);
                    }
                    temp = temp.next;
                } while (temp != null);
            }
        }
    }
}
/*x1 = dsaa.find(x1,list);
                y1 = dsaa.find(y1,list);
                x2 = dsaa.find(x2,list);
                y2 = dsaa.find(y2,list);*/
/* public int find(int n,Node[]list){
        for(int i = 0;i<list.length;i++){
            if(list[i].num==n){
                return i;
            }
        }
        return 0;
    }*/