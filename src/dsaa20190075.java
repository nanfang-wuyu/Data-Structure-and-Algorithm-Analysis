import java.util.*;

public class dsaa20190075 {
    static public class treeNode{
        long key;
        int height;
        treeNode leftChild;
        treeNode rightChild;
        treeNode parent;
        public treeNode(long key){
            this.key = key;
            this.height = 0;
        }
    }
    static treeNode root;
    static int N;
    static long key;
    public static void main(String[] args) {
        dsaa20190075 BBST = new dsaa20190075();
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();//a的个数
        int k = in.nextInt();//窗口大小

        long a[] = new long[m];
        int n[] = new int[m-k+1];
        for(int i = 0;i<m;i++) a[i] = in.nextLong();
        for(int i = 0;i<m-k+1;i++) n[i] = in.nextInt();

        root = new treeNode(a[0]);
        N = 0;

        for(int i = 1;i<k;i++) BBST.BBST_insertion(root, a[i]);
        BBST.nthelement(root, n[0]);
        System.out.println(key);
        for(int i = 1;i<m-k+1;i++) {
            N = 0;
            BBST.BBST_insertion(root, a[i+k-1]);
            BBST.BBST_deletion(root, a[i-1]);
            BBST.nthelement(root, n[i]);
            System.out.println(key);
        }
    }

    public void nthelement(treeNode Node, int n){
        if(Node.leftChild!=null){
            nthelement(Node.leftChild,n);
        }
        N++;
        if(N==n){
            key = Node.key;
            return;
        }
        if(Node.rightChild!=null){
            nthelement(Node.rightChild,n);
        }
    }

    //BBST

    public treeNode Predecessor_Query(treeNode root, long q){
        treeNode v = null;
        treeNode u = root;
        while(u!=null){
            if(u.key==q){
                return u;
            }
            if(u.key<q){
                v = u;
                u = u.rightChild;
            }
            else u = u.leftChild;
        }
        return v;
    }

    public treeNode Successor_Query(treeNode root, long q){
        treeNode v = null;
        treeNode u = root;
        while(u!=null){
            if(u.key==q){
                return u;
            }
            if(u.key>q){
                v = u;
                u = u.leftChild;
            }
            else u = u.rightChild;
        }
        return v;
    }

    public treeNode balance(treeNode u){return u;}

    public void rotateWithLeftChild(){}

    public void rotateWithRightChild(){}

    public void doubleRotateWithLeftChild(){}

    public void doubleRotateWithRightChild(){}

    public treeNode BBST_insertion(treeNode u, long key){
        if(u==null)return new treeNode(key);
        if(u.key>key) {
            u.leftChild = BBST_insertion(u.leftChild, key);
        }else {
            u.rightChild = BBST_insertion(u.rightChild, key);
        }
        return balance(u);

    }

    public treeNode BBST_deletion(treeNode u, long key){
        if(u==null)return u;
        if(u.key>key) {
            u.leftChild = BBST_deletion(u.leftChild, key);
        }else if(u.key<key){
            u.rightChild = BBST_deletion(u.rightChild, key);
        }else {
            if(twoChildren(u)){
                u.key = Successor_Query(u.rightChild, u.key).key;
                u.rightChild = BBST_deletion(u.rightChild, u.key);
            }
            else {
                if(u.leftChild==null)u = u.rightChild;
                else u = u.leftChild;
            }
        }//equal
        return balance(u);
    }

    public boolean twoChildren(treeNode u){
        if(u.leftChild!=null&&u.rightChild!=null)return true;
        else return false;
    }

    public void replace(treeNode u, treeNode child){
        if(u.parent==null){
            child.parent = null;
            root = child;
            return;
        }
        if(u.parent.rightChild==u){
            u.parent.rightChild = child;
            child.parent = u.parent;
        }
        else {
            u.parent.leftChild = child;
            child.parent = u.parent;
        }
    }
}
