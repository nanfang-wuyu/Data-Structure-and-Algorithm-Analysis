import java.util.*;


public class dsaa20190085 {
    static public class treeNode{
        int key;
        treeNode leftChild;
        treeNode rightChild;
        treeNode parent;
        public treeNode(int key){this.key = key;}
    }
    public static class Vertex{
        ArrayList<treeNode>list = new ArrayList<>();
        ArrayList<Integer>child = new ArrayList<>();
        int key, color, tl, tr;
        public Vertex(int key){
            this.key = key;
            this.color = 0;//whi
            this.tl = 0;
            this.tr = 0;
        }
    }
    static Vertex [] v, arr;
    static int n, m, top, time;
    static ArrayList<Integer>L;
    static Scanner in = new Scanner(System.in);

    public void input(){
        n = in.nextInt();
        m = in.nextInt();
        v = new Vertex[n+1];
        arr = new Vertex[n+1];
        for(int i = 1;i<n+1;i++){
            v[i] = new Vertex(i);
            v[i].list.add(new treeNode(-1));
        }
        for(int i = 1;i<m+1;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            insert(v[b].list,a);
        }
    }
    public void build(){
        for(int i = 1;i<n+1;i++) {
            if(v[i].color==0) {
                pushUpdate(v[i]);
                DFS(v[i]);
            }
        }
    }
    public void DFS(Vertex u) {
        Vertex a = u;
        while (top != -1) {
            if (a.list.size() > 1) {
                Vertex b = v[a.list.get(1).key];
                deleteMin(a.list);
                if (b.color == 0) {
                    a.child.add(b.key);
                    pushUpdate(b);
                    a = b;
                }
            } else {
                popUpdate(a);
                if(top!=-1)a = arr[top];
            }
        }
    }
    public void pushUpdate(Vertex v){
        push(v);
        v.color = 1;
        time++;
        v.tl = time;
    }
    public void popUpdate(Vertex v){
        pop();
        time++;
        v.tr = time;
        L.add(v.key);
    }
    public void push(Vertex item){
        if(top<arr.length) {
            top++;
            arr[top] = item;
        }
    }
    public Vertex pop(){
        top--;
        return arr[top+1];
    }
    public static void main(String[] args) {
        int T = in.nextInt();
        for(int r = 0;r<T;r++) {
            dsaa20190085 a = new dsaa20190085();
            top = -1;
            time = 0;
            L = new ArrayList<>();
            a.input();
            a.build();
            a.print();
        }
    }
    public void print(){
        for(int i = 0;i<L.size();i++){
            System.out.print(L.get(i)+" ");
        }
        System.out.println();
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
    public static long deleteMin(ArrayList<treeNode>list){
        treeNode root = list.get(1);
        treeNode rightmost = list.get(list.size()-1);
        long min = root.key;
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

