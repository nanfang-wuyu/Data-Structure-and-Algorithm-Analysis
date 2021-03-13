import java.util.*;

public class dsaa20190073 {

    static public class treeNode{
        long key;
        treeNode leftChild;
        treeNode rightChild;
        treeNode parent;
        public treeNode(long key){this.key = key;}
    }
    static ArrayList<treeNode> list;
    static long sum;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int r = 0;r<T;r++){
            int n = in.nextInt();
            list = new ArrayList<>();
            sum = 0;
            list.add(new treeNode(-1));
            for(int i = 1;i<n+1;i++){
                insert(in.nextLong());
            }
            for(int i = 1;i<n;i++){
                backtoStick();
            }
            System.out.println(sum);
        }
    }

    public static void insert(long item){
        list.add(new treeNode(item));//step1
        treeNode u = list.get(list.size()-1);
        if(list.size()-1!=1){
            treeNode p = list.get((list.size()-1)/2);
            u.parent = p;
            if(p.leftChild==null) p.leftChild = u;
            else p.rightChild = u;
        }
        //step2
        while(true) {
            if (u.parent==null) return;//step3
            if (u.key > u.parent.key) return;//step4
            swapkey(u, u.parent);//step5.1
            u = u.parent;//step5.2
        }
    }

    public static long deleteMin(){
        treeNode root = list.get(1);
        treeNode rightmost = list.get(list.size()-1);
        long min = root.key;
        root.key = rightmost.key;//step1,2
        if(list.size()!=2) {
            if ((list.size() - 1) % 2 == 0) rightmost.parent.leftChild = null;
            else rightmost.parent.rightChild = null;
        }
        list.remove(list.size()-1);//step3
        treeNode u = root;//step4
        while(true) {
            if (u.leftChild == null && u.rightChild == null){
                return min;//step5
            }
            if (u.rightChild == null){
                if(u == keySmallerNode(u,u.leftChild))return min;
            }
            if (u.rightChild != null){
                if(u == keySmallerNode(u,u.leftChild) &&
                        u == keySmallerNode(u,u.rightChild))return min;
            }
            treeNode v = u.leftChild;
            if(u.rightChild!=null)v = keySmallerNode(u.leftChild,u.rightChild);
            swapkey(u,v);
            u = v;//step7
        }
    }

    public static void backtoStick() {
        long a = deleteMin();
        long b = deleteMin();
        long m = a+b;
        sum += m;
        insert(m);
    }

    public static void swapkey(treeNode a, treeNode b){
        long temp = a.key;
        a.key = b.key;
        b.key = temp;
    }

    public static treeNode keySmallerNode(treeNode a, treeNode b){
        if(a.key<b.key)return a;
        else return b;
    }
}
