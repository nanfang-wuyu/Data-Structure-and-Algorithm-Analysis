import java.util.*;

public class SplayTree {
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

    //基本操作

    //insert
    public treeNode insert(treeNode u, long key){

        treeNode newNode = new treeNode(key);
        if(u == null){
            u = new treeNode(key);
            return u;
        }//the tree is empty
        u = splay(u, key);
        if(key>u.key){
            newNode.leftChild = u;
            newNode.rightChild = u.rightChild;
            u.rightChild = null;
            u = newNode;
        }
        else if(key<u.key){
            newNode.rightChild = u;
            newNode.leftChild = u.leftChild;
            u.leftChild = null;
            u = newNode;
        }
        else {

        }
        return u;
    }
    //remove
    public treeNode remove(treeNode u, long key){
        u = splay(u, key);
        if(u.key!=key)return u;
        if(u.leftChild == null)u = u.rightChild;
        else {
            treeNode v = u.rightChild;
            u = u.leftChild;
            u = splay(u, key);
            u.rightChild = v;
        }
        return u;
    }
    //splay 自上而下
    public treeNode splay(treeNode u, long key){
        if(u == null)return null;

        treeNode header = null;
        treeNode Lmax = header;
        treeNode Rmin = header;

        while(true){
            if(key>u.key){
                if(u.rightChild==null)break;
                if(key>u.rightChild.key)u = rotateWithRightChild(u);
                Lmax.rightChild = u;
                Lmax = u;
                u = u.rightChild;
            }
            else if(key<u.key){
                if(u.leftChild==null)break;
                if(key<u.leftChild.key)u = rotateWithLeftChild(u);
                Rmin.leftChild = u;
                Rmin = u;
                u = u.leftChild;
            }
            else break;
        }

        Lmax.rightChild = u.leftChild;
        Rmin.leftChild = u.rightChild;
        u.leftChild = header.rightChild;
        u.rightChild = header.leftChild;

        return u;
    }
    //join
    public treeNode merge(treeNode u, treeNode v){
        if(u==null)return v;
        if(v==null)return u;
        u = splay(u, v.key);
        u.rightChild = v;
        return u;
    }
    //split
    public void split(treeNode u, long key){}
    //其他操作
    //findMin
    //findMax
    //boolean contains
    //makeEmpty
    public treeNode rotateWithLeftChild(treeNode u){
        treeNode v = u.leftChild;
        u.leftChild = v.rightChild;
        v.rightChild = u;
        return v;
    }

    public treeNode rotateWithRightChild(treeNode u){
        treeNode v = u.rightChild;
        u.rightChild = v.leftChild;
        v.leftChild = u;
        return v;
    }

    //rever *
    //pushup
    //pushdown


}
