import java.util.*;

public class MinHeap {
    static public class treeNode{
        int key;
        treeNode leftChild;
        treeNode rightChild;
        treeNode parent;
        public treeNode(int key){this.key = key;}
    }
    public static void insert(ArrayList<treeNode>list, int item){
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
    public static int deleteMin(ArrayList<treeNode>list){
        treeNode root = list.get(1);
        treeNode rightmost = list.get(list.size()-1);
        int min = root.key;
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
    public static void swapkey(treeNode a, treeNode b){
        int temp = a.key;
        a.key = b.key;
        b.key = temp;
    }
    public static treeNode keySmallerNode(treeNode a, treeNode b){
        if(a.key<b.key)return a;
        else return b;
    }
}
