import java.util.Scanner;
public class dsaa20190031new3 {
    public static class Node {
        int coe;//系数
        int exp;//指数
        Node next;
        //Node prev;

        public Node() {
            coe = 0;
            exp = 0;
        }

        public Node(int coe, int exp) {
            this.coe = coe;
            this.exp = exp;
        }
    }

        public Node insert(Node head,Node tail, int coe, int exp) {//添加节点
            Node node=new Node(coe,exp);
            tail.next = node;
            tail = node;
            return tail;
        }
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int T = in.nextInt();
            for(int t = 0; t<T;t++) {
                dsaa20190031new3 link = new dsaa20190031new3();
                int n = in.nextInt();
                Node head = new Node(in.nextInt(), in.nextInt());
                Node tail = head;
                for(int i = 1;i<n;i++) {
                    tail = link.insert(head, tail, in.nextInt(), in.nextInt());
                }
                int m = in.nextInt();
                Node temp = head;
                Node tempre = new Node();
                tempre.next = temp;
                for(int i = 0;i<m;i++) {
                    int coe = in.nextInt();
                    int exp = in.nextInt();
                    while (exp > temp.exp&&temp != tail) {
                        temp = temp.next;
                        tempre = tempre.next;
                    }
                    if(exp > temp.exp&&temp == tail){
                        temp.next = new Node(coe, exp);
                        tail = temp.next;
                        temp = tail;
                        tempre = tempre.next;
                    }
                    else if (exp < temp.exp) {
                        if (temp != head) {
                            Node a = new Node(coe, exp);
                            tempre.next = a;
                            a.next = temp;
                            tempre = a;//测试丢失
                        } else {
                            Node a = new Node(coe, exp);
                            a.next = temp;
                            tempre = a;
                            head = a;
                        }
                    } else {
                        temp.coe += coe;
                    }
                }

                int x = in.nextInt();
                int y[] = new int[x];
                int coe[] = new int[x];
                for(int i = 0;i<x;i++)y[i] = in.nextInt();
                temp = head;
                for(int i = 0;i<x;i++) {
                    if(temp.exp == y[i]){coe[i] = temp.coe;}
                    else if(temp.exp<y[i]){
                        if(temp == tail){coe[i]=0;break;}
                        else {temp = temp.next;i--;}
                    } else {coe[i]=0;}
                }
                link.print(x,coe);
            }
        }
        public void print(int x,int[]coe){
            for(int i = 0;i<x;i++) {
                if(i!=x-1){System.out.print(coe[i]+" ");}
                else System.out.printf("%d\n",coe[i]);
            }
        }

}


 /*public void add(Node temp, Node head, Node tail, int coe, int exp) {

            if(exp>temp.exp){
                if(temp!=tail){
                    temp = temp.next;
                    add(temp,head, tail, coe, exp);
                }else {
                    temp.next = new Node(coe,exp);
                    tail = temp.next;
                    temp = tail;
                }
            }
            else if(exp<temp.exp){
                if(temp.prev!=null){
                    Node a = new Node(coe,exp);
                    temp.prev.next = a;
                    a.next = temp;
                    //测试丢失
                }else temp.prev = new Node(coe,exp);
            }
            else if(exp==temp.exp){temp.exp+=exp;}
            //System.out.println(temp.exp);
        }*/
