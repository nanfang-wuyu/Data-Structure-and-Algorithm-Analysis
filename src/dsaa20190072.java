import java.util.*;

public class dsaa20190072 {

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
    static int []parent;
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int r = 1;r<T+1;r++){
            int n = in.nextInt();//node number
            list = new treeNode[n+1];
            parent = new int[n+1];
            boolean isBinary = true;
            for(int i = 1;i<n+1;i++){
                list[i] = new treeNode(in.nextInt());
            }
            for(int i = 1;i<n;i++){
                int par = in.nextInt();
                int child = in.nextInt();
                if(list[par].leftChild==null) {
                    list[par].leftChild=list[child];
                    parent[child] = child;
                }
                else if(list[par].rightChild==null) {
                    list[par].rightChild=list[child];
                    parent[child] = child;
                }
                else isBinary = false;
            }
            if(!isBinary){
                System.out.println("Case #"+r+": NO");
                continue;
            }
            int p = -1;
            for(int i = 1;i<n+1;i++){
                if(parent[i]==0){
                    p=i;
                    break;
                }
            }
            if(isComplete(list[p],1)&&(isSmallHeap(list[p])||isBigHeap(list[p]))) System.out.println("Case #"+r+": YES");
            /*if(isComplete(list[p],1)) System.out.println("Complete");
            if(isSmallHeap(list[p])) System.out.println("SmallHeap");
            if(isBigHeap(list[p])) System.out.println("BigHeap");*/
            else System.out.println("Case #"+r+": NO");
        }
    }

    public static boolean isComplete(treeNode root, int i){
        if(i>list.length-1)return false;
        if(root.leftChild!=null){
            if(!isComplete(root.leftChild,i*2))return false;
        }
        if(root.rightChild!=null){
            if(!isComplete(root.rightChild,i*2+1))return false;
        }
        return true;
    }

    public static boolean isSmallHeap(treeNode root){
        if(root.leftChild!=null){
            if(root.key>root.leftChild.key)return false;
            if(!isSmallHeap(root.leftChild))return false;
        }
        if(root.rightChild!=null){
            if(root.key>root.rightChild.key)return false;
            if(!isSmallHeap(root.rightChild))return false;
        }
        return true;
    }

    public static boolean isBigHeap(treeNode root){
        if(root.leftChild!=null){
            if(root.key<root.leftChild.key)return false;
            if(!isBigHeap(root.leftChild))return false;
        }
        if(root.rightChild!=null){
            if(root.key<root.rightChild.key)return false;
            if(!isBigHeap(root.rightChild))return false;
        }
        return true;
    }
}
