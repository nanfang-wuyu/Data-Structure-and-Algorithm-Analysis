//定义节点类
class Node{
    public int coef;//系数
    public int exp;//指数  
    public Node next=null;//下个节点  
    public Node(){
        coef=0;
        exp=0;
    }//空节点
    public Node(int coef,int exp){
        this.coef=coef;
        this.exp=exp;
    }//定义节点
}

//多项式类
class PolynList {
    //多项式相加
    public Node add(Node link1, Node link2) {
        Node pre=link1;
        Node qre=link2;
        Node p=pre.next;
        Node q=qre.next;
        Node result=p;
        while(p!=null && q!=null){
            if(p.exp<q.exp){
                pre=p;//指针
                p=p.next;//指针
                }else if(p.exp>q.exp){
                Node temp=q.next;
                pre.next=q;
                q.next=p;
                q=temp;//指针
            }//将q插入到pre和p中间
             else{
                p.coef=p.coef+q.coef;
                if(p.coef==0){
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
        return result;
    }

    //添加数据方法
    public Node insert(Node link,int coef,int exp) {//添加节点
        Node node=new Node(coef,exp);
        if(link==null){
            link.next=node;
        }else{
            Node temp=link;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=node;
        }
        return link;
    }

    //主方法
    public static void main(String[] args) {
        PolynList ts = new PolynList();
        Node link1=new Node();
        Node link2=new Node();
        //第一个多项式
        ts.insert(link1,4,0);
        ts.insert(link1,5,2);
        ts.insert(link1,4,8);
        ts.insert(link1,6,12);
        //第二个多项式
        ts.insert(link2,6,1);
        ts.insert(link2,6,3);
        ts.insert(link2,3,8);
        ts.insert(link2,4,15);
        ts.insert(link2,8,20);

        link1 = ts.add(link1, link2);

        while(link1!=null){
            if(link1.exp== 0)
                System.out.print(link1.coef);
            else
                System.out.print(link1.coef+"x^"+link1.exp);
            link1=link1.next;
            if(link1!=null)
                System.out.print("+");
        }
    }
}