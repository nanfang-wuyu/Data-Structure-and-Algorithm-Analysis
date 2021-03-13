import java.util.*;

public class dsaa20190076 {
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
    static long sum;
    public static void main(String[] args) {
        dsaa20190076 BBST = new dsaa20190076();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        treeNode rootP = null;
        treeNode rootA = null;
        sum = 0;
        for(int i = 0;i<n;i++){
            long type = in.nextLong();
            long value = in.nextLong();
            if(type==0){
                if(rootA==null) rootP = BBST.BBST_insertion(rootP,value);
                else rootA = BBST.matchPA(value,rootA);
            }
            else {
                if(rootP==null) rootA = BBST.BBST_insertion(rootA,value);
                else rootP = BBST.matchPA(value,rootP);
            }
        }
        System.out.println(sum);
    }

    public treeNode matchPA(long value, treeNode root){
            treeNode Pre = Predecessor_Query(root, value);
            treeNode Suc = Successor_Query(root, value);
            long key;
            long m;
            if(Pre!=null&&Suc!=null){
                long key1 = Pre.key;
                long key2 = Suc.key;
                long abs1 = Math.abs(key1-value);
                long abs2 = Math.abs(key2-value);
                key = (abs2<abs1)?key2:key1;
            }
            else key = (Pre == null)?Suc.key:Pre.key;
            m = Math.abs(key-value);
            sum += m;
            return BBST_deletion(root, key);
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
        return u;
    }

    public int height(treeNode u){
        if(u==null)return -1;
        return u.height;
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
        return v;
    }

    public treeNode rotateWithRightChild(treeNode u){
        treeNode v = u.rightChild;
        u.rightChild = v.leftChild;
        v.leftChild = u;
        u.height = childMaxHight(u)+1;
        v.height = childMaxHight(u)+1;
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
