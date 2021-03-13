import java.util.*;

public class dsaa20190071 {

    static public class treeNode{
        int key;
        treeNode leftChild;
        treeNode rightChild;
        treeNode parent;


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
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int r = 0;r<T;r++){
            int n = in.nextInt();//node number
            list = new treeNode[n+1];
            queue = new treeNode[n+1];
            lastlevel = false;
            front = 1;
            rear = 1;
            for(int i = 1;i<n+1;i++){
                list[i] = new treeNode(i);
            }
            for(int i = 1;i<n+1;i++){
                int a = in.nextInt();
                int b = in.nextInt();
                if(a!=0){
                    list[i].leftChild = list[a];
                    list[a].parent = list[i];
                }
                if(b!=0){
                    list[i].rightChild = list[b];
                    list[b].parent = list[i];
                }
            }
            int p = 1;
            while(list[p].parent!=null){
                p = list[p].parent.key;
            }
            enqueue(list[p]);
            if(levelorder(list[p],null,null)) System.out.println("Yes");;
        }
    }

    public static void enqueue(treeNode Node){
        if(rear<queue.length) {
            queue[rear] = Node;
            rear++;
        }
    }
    public static void dequeue() {
        if(front<rear) front++;
    }
    public static treeNode getFront(){return queue[front];}

    public static boolean levelorder(treeNode root, treeNode leftChild, treeNode rightChild) {
        while(front!=rear) {
            root = getFront();
            dequeue();
            if (inComplete(root)) {
                System.out.println("No");
                return false;
            }
            if(root.leftChild==null||root.rightChild==null){
                lastlevel = true;
            }
            if (root.leftChild != null) {
                enqueue(root.leftChild);
            }
            if (root.rightChild != null) {
                enqueue(root.rightChild);
            }
        }
        return true;
    }

    public static boolean inComplete(treeNode root){
        if(root.leftChild==null&&root.rightChild!=null) {
            //System.out.println("case1");
            return true;
        }
        if(lastlevel&&(root.leftChild!=null||root.rightChild!=null)) {
            //System.out.println("case2");
            return true;
        }
        return false;
    }
}
