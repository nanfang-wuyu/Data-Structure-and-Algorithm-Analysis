public class BBST {
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
        if(u==null)return null;
        if(u.key>key) {
            u.leftChild = BBST_deletion(u.leftChild, key);
        }else if(u.key<key){
            u.rightChild = BBST_deletion(u.rightChild, key);
        }else {
            if(twoChildren(u)){
                u.key = Successor_Query(u.rightChild, u.key).key;//find the smallest node in right subtree
                u.rightChild = BBST_deletion(u.rightChild, u.key);
            }
            else {
                if(u.leftChild==null)u = u.rightChild;// right subtree or null
                else u = u.leftChild;//left subtree
            }
        }//equal
        return balance(u);
    }

    public boolean twoChildren(treeNode u){
        if(u.leftChild!=null&&u.rightChild!=null)return true;
        else return false;
    }
}
