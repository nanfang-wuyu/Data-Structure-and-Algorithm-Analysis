import java.util.*;

public class dsaa20190075new {
    static public class treeNode{
        long key;
        int height;
        int nodeL;
        int nodeR;
        treeNode leftChild;
        treeNode rightChild;
        treeNode parent;
        public treeNode(long key){
            this.key = key;
            this.height = 0;
            this.nodeL = 1;
            this.nodeR = 1;
        }
    }
    static int N;
    static long key;
    public static void main(String[] args) {
        dsaa20190075new BBST = new dsaa20190075new();
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();//a的个数
        int k = in.nextInt();//窗口大小

        long a[] = new long[m];
        int n[] = new int[m-k+1];
        for(int i = 0;i<m;i++) a[i] = in.nextLong();
        for(int i = 0;i<m-k+1;i++) n[i] = in.nextInt();

        treeNode root = new treeNode(a[0]);

        for(int i = 1;i<k;i++) root = BBST.BBST_insertion(root, a[i]);
        System.out.println(BBST.findnth(root, n[0]).key);
        for(int i = 1;i<m-k+1;i++) {
            root = BBST.BBST_insertion(root, a[i+k-1]);
            root = BBST.BBST_deletion(root, a[i-1]);
            System.out.println(BBST.findnth(root, n[i]).key);
        }
    }

    public treeNode findnth(treeNode u, int n){
        if(u==null)return u;
        if(n>nodeLR(u.leftChild)){
            n = n-nodeLR(u.leftChild);
            u = findnth(u.rightChild,n);
        }else if(n<nodeLR(u.leftChild)){
            u = findnth(u.leftChild,n);
        }else return u;
        return u;
    }

    //BBST

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

    public treeNode balance(treeNode u){
        if(u==null)return u;
        if(height(u.leftChild)-height(u.rightChild)>1){
            if(height(u.leftChild.leftChild)>=height(u.leftChild.rightChild))
                u = rotateWithLeftChild(u);
            else u = doubleRotateWithLeftChild(u);
        }
        else if(height(u.rightChild)-height(u.leftChild)>1){
            if(height(u.rightChild.rightChild)>=height(u.rightChild.leftChild))
                u = rotateWithRightChild(u);
            else u = doubleRotateWithRightChild(u);
        }
        u.height = childMaxHight(u)+1;
        u.nodeL = nodeLR(u.leftChild);
        u.nodeR = nodeLR(u.rightChild);
        return u;
    }

    public int height(treeNode u){
        if(u==null)return -1;
        return u.height;
    }

    public int nodeLR(treeNode u){
        if(u==null)return 1;
        return u.nodeL+u.nodeR;
    }

    public int childMaxHight(treeNode u){
        int l = height(u.leftChild);
        int r = height(u.rightChild);
        if(l>r)return l;
        else return r;
    }

    public treeNode rotateWithLeftChild(treeNode u){
        treeNode v = u.leftChild;
        u.leftChild = v.rightChild;
        v.rightChild = u;
        u.height = childMaxHight(u)+1;
        v.height = childMaxHight(u)+1;
        u.nodeL = nodeLR(u.leftChild);
        u.nodeR = nodeLR(u.rightChild);
        v.nodeL = nodeLR(v.leftChild);
        v.nodeR = nodeLR(v.rightChild);
        return v;
    }

    public treeNode rotateWithRightChild(treeNode u){
        treeNode v = u.rightChild;
        u.rightChild = v.leftChild;
        v.leftChild = u;
        u.height = childMaxHight(u)+1;
        v.height = childMaxHight(u)+1;
        u.nodeL = nodeLR(u.leftChild);
        u.nodeR = nodeLR(u.rightChild);
        v.nodeL = nodeLR(v.leftChild);
        v.nodeR = nodeLR(v.rightChild);
        return v;
    }

    public treeNode doubleRotateWithLeftChild(treeNode u){
        u.leftChild = rotateWithRightChild(u.leftChild);
        u = rotateWithLeftChild(u);
        return u;
    }

    public treeNode doubleRotateWithRightChild(treeNode u){
        u.rightChild = rotateWithLeftChild(u.rightChild);
        u = rotateWithRightChild(u);
        return u;
    }

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
}
