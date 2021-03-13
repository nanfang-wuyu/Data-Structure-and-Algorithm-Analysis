import java.util.*;

public class BST {
    static public class treeNode{
        long key;
        treeNode leftChild;
        treeNode rightChild;
        treeNode parent;
        public treeNode(long key){this.key = key;}
    }
    static treeNode root;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //root = new
    }

    public long PredecessorQuery(treeNode root, long q){
        long p = -2147483648;
        treeNode u = root;
        while(u!=null){
            if(u.key==q){
                return q;
            }
            if(u.key<q){
                p = q;
                u = u.rightChild;
            }
            else u = u.leftChild;
        }
        return p;
    }

    public long SuccessorQuery(treeNode root, long q){
        long p = 2147483647;
        treeNode u = root;
        while(u!=null){
            if(u.key==q){
                return q;
            }
            if(u.key>q){
                p = q;
                u = u.leftChild;
            }
            else u = u.rightChild;
        }
        return p;
    }

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

    public void deleteNode(treeNode u){
        if(u.parent==null)root = null;
        if(u.parent.leftChild==u)u.leftChild=null;
        else u.rightChild = null;
    }

    public boolean ifLeafNode(treeNode u){
        if(u.leftChild==null&&u.rightChild==null)return true;
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

    public void BST_insertion(treeNode root, long key){
        treeNode Node = new treeNode(key);
        treeNode u = root;
        while(true){
            if(u.key>key) {
                if (u.leftChild == null) {
                    u.leftChild = Node;
                    Node.parent = u;
                    return;
                } else u = u.leftChild;
            }else {
                if(u.rightChild == null){
                    u.rightChild = Node;
                    Node.parent = u;
                    return;
                } else u = u.rightChild;
            }
        }
    }

    public void BST_deletion(treeNode root, long q){
        treeNode u = Successor_Query(root,q);//find aim
        if(ifLeafNode(u)){
            deleteNode(u);
            return;
        }//case 1
        if(u.rightChild!=null){
            treeNode v = Successor_Query(u.rightChild,u.key);
            u.key = v.key;
            if(ifLeafNode(v)){
                deleteNode(v);
            }//case 2.1
            else {
                replace(v,v.rightChild);
            }//case 2.2
        }//case 2
        else {
            replace(u,u.leftChild);
        }//case 3
    }


}
