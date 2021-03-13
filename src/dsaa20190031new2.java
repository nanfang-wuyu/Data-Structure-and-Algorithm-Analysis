import java.util.Scanner;
public class dsaa20190031new2 {

    static class Node{

        int coe;//系数
        int exp;//指数
        Node next;

        public Node(){
            coe = 0;
            exp = 0;
        }

        public Node(int coe,int exp) {
            this.coe = coe;
            this.exp = exp;
        }
    }

    //多项式类
    static class dsaa {
        //多项式相加
        public void add(Node link1, Node link2) {
            Node pre=link1;
            Node qre=link2;
            Node p=pre.next;
            Node q=qre.next;
            while(p!=null && q!=null){
                if(p.exp<q.exp){
                    pre=p;//指针
                    p=p.next;//指针
                }else if(p.exp>q.exp){
                    Node temp=q.next;
                    pre.next=q;
                    q.next=p;
                    q=temp;//指针
                    pre = pre.next;//指针
                }//将q插入到pre和p中间
                else{
                    p.coe=p.coe+q.coe;
                    if(p.coe==0){
                        pre.next=p.next;
                        p=pre.next;//删除
                    }else{
                        pre=p;//指针
                        p=p.next;//指针
                    }
                    qre.next=q.next;//指针
                    q=qre.next;//指针
                }//如果相等
            }//p或q一个为空则停止循环
            if(q!=null){
                pre.next=q;
            }//q比p长，将q接在p后面
        }

        //添加数据方法
        public void insert(Node link, int coe, int exp) {//添加节点
            Node node=new Node(coe,exp);
            Node temp=link;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=node;
        }

        //主方法
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);

            int T = in.nextInt();
            for(int t = 0; t<T;t++) {
                dsaa ts = new dsaa();
                Node link1 = new Node();
                Node link2 = new Node();//0,0不为null
                //第一个多项式
                int n = in.nextInt();
                for(int i = 0;i<n;i++) ts.insert(link1, in.nextInt(), in.nextInt());
                //第二个多项式
                int m = in.nextInt();
                for(int i = 0;i<m;i++) ts.insert(link2, in.nextInt(), in.nextInt());


                ts.add(link1, link2);
                Node temp = link1.next;


                int x = in.nextInt();
                int y[] = new int[x];
                int coe[] = new int[x];
                for(int i = 0;i<x;i++)y[i] = in.nextInt();
                for(int i = 0;i<x;i++){
                    while (temp!=null)
                    {
                        if(temp.exp == y[i]){
                        coe[i] = temp.coe;

                        }temp = temp.next;
                    }temp = link1.next;
                }//不能过修改 删掉已经用过节点 结束后面循环
                ts.print(x,coe);
                //in.nextLine();
            }
        }

        public void print(int x,int[]coe){
            for(int i = 0;i<x;i++) {
                if(i!=x-1){System.out.print(coe[i]+" ");}
                else System.out.printf("%d\n",coe[i]);
            }
        }
    }
}