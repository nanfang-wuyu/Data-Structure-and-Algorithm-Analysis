import java.util.*;

public class dsaa20190071new {

    static public class treeNode{
        int key;
        treeNode leftChild;
        treeNode rightChild;
        //treeNode parent;


        public treeNode(int key, treeNode left, treeNode right){
            this.key = key;
            this.leftChild = left;
            this.rightChild = right;
        }

        public treeNode(int key){this.key = key;}

    }
    static treeNode[] list;
    static treeNode[] queue;
    static boolean lastlevel;
    static int front;
    static int rear;
    static int []parent;
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int r = 0;r<T;r++){
            int n = in.nextInt();//node number
            list = new treeNode[n+1];
            queue = new treeNode[n+1];
            front = 1;
            rear = 1;
            parent = new int[n+1];
            for(int i = 1;i<n+1;i++){
                list[i] = new treeNode(i);
            }
            for(int i = 1;i<n+1;i++){
                int a = in.nextInt();
                int b = in.nextInt();
                if(a!=0){
                    list[i].leftChild = list[a];
                    parent[a]=i;
                }
                if(b!=0){
                    list[i].rightChild = list[b];
                    parent[b]=i;
                }
            }
            int p = -1;
            for(int i = 1;i<n+1;i++){
                if(parent[i]==0){
                    p=i;
                    break;
                }
            }
            if(parent_child(list[p],1)) System.out.println("Yes");
            else System.out.println("No");
        }
    }

    public static boolean parent_child(treeNode root, int i){
        if(i>list.length-1)return false;
        if(root.leftChild!=null){
            if(!parent_child(root.leftChild,i*2))return false;
        }
        if(root.rightChild!=null){
            if(!parent_child(root.rightChild,i*2+1))return false;
        }
        return true;
    }
}
