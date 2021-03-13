import java.util.*;

public class dsaa20190087 {

    static public class treeNode {
        int key;
        treeNode leftChild;
        treeNode rightChild;
        treeNode parent;

        public treeNode(int key) {
            this.key = key;
        }
    }

    public static class Vertex {
        ArrayList<Path> edges  = new ArrayList<>();
        ArrayList<treeNode> list = new ArrayList<>();
        int key, color;
        Vertex parant;

        public Vertex(int key) {
            this.key = key;
            this.color = 0;
            this.parant = null;
        }
    }

    public static class Path {
        int pre;
        int target;
        long weight;
        long lastweight;
        int isEdge;

        public Path(int pre, int target, long weight, long lastweight, int isEdge) {
            this.pre = pre;
            this.target = target;
            this.weight = weight;
            this.lastweight = 0;
            this.isEdge = isEdge;
        }
    }

    static Vertex[] v, arr;
    static ArrayList<treeNode> R;
    static ArrayList<Path> P;
    static int n, m, q, maxq, top;
    static int[] Q;
    static long[] path;
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        dsaa20190087 a = new dsaa20190087();
        int T = in.nextInt();
        for(int r = 0;r<T;r++) {
            a.input();
            a.print();
        }
    }

    public void input() {
        n = in.nextInt();
        m = in.nextInt();
        q = in.nextInt();
        top = -1;
        v = new Vertex[n + 1];
        arr = new Vertex[n + 1];
        R = new ArrayList<>();
        P = new ArrayList<>();
        R.add(null);
        for (int i = 1; i < n + 1; i++) {
            v[i] = new Vertex(i);
            v[i].edges.add(null);
            v[i].list.add(null);
        }
        for (int i = 1; i < m + 1; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            long w = in.nextLong();
            v[a].edges.add(new Path(a, b, w,0, 1));
            //v[b].edges.add(new Path(b, a, w,0, 1));
            P.add(new Path(a, b, w, 0,1));
            insert(R, P, P.size()-1);
            //P.add(new Path(b, a, w, 0,1));
            //insert(R, P, P.size()-1);
            insert(v[a].list,v[a].edges,v[a].edges.size()-1);
            //insert(v[b].list,v[b].edges,v[b].edges.size()-1);
        }
        maxq = -1;
        Q = new int[q+1];
        for(int i = 1;i<q+1;i++){
            Q[i] = in.nextInt();
            if(Q[i]>maxq) maxq = Q[i];
        }
        path = new long[maxq+1];
        hunting();
    }

    public void hunting(){

        for(int i = 1;i<maxq+1;i++){
            Path p = P.get(deleteMin(R,P));//ABC
            path[i] = p.weight;
            //ABCD
            if(v[p.target].list.size()>1) {
                Path q = v[p.target].edges.get(deleteMin(v[p.target].list, v[p.target].edges));
                P.add(new Path(p.target, q.target, p.weight + q.weight, p.weight, 0));
                insert(R, P, P.size() - 1);
            }
            //ABD
            if(v[p.pre].list.size()>1&&p.isEdge==0) {
                Path t = v[p.pre].edges.get(deleteMin(v[p.pre].list,v[p.pre].edges));
                P.add(new Path(p.pre,t.target,p.lastweight+t.weight,p.lastweight,0 ));
                insert(R,P,P.size()-1);
            }
        }
    }

    public static void insert(ArrayList<treeNode> list, ArrayList<Path>edges, int item) {
        list.add(new treeNode(item));//step1
        treeNode u = list.get(list.size() - 1);
        if (list.size() - 1 != 1) {
            treeNode p = list.get((list.size() - 1) / 2);
            u.parent = p;
            if (p.leftChild == null) p.leftChild = u;
            else p.rightChild = u;
        }
        //step2
        while (true) {
            if (u.parent == null) return;//step3
            if (edges.get(u.key).weight > edges.get(u.parent.key).weight) return;//step4
            swapkey(u, u.parent);//step5.1
            u = u.parent;//step5.2
        }
    }
    public static int deleteMin(ArrayList<treeNode> list, ArrayList<Path>edges) {
        treeNode root = list.get(1);
        treeNode rightmost = list.get(list.size() - 1);
        int min = root.key;
        root.key = rightmost.key;//step1,2
        if (list.size() != 2) {
            if ((list.size() - 1) % 2 == 0) rightmost.parent.leftChild = null;
            else rightmost.parent.rightChild = null;
        }
        list.remove(list.size() - 1);//step3
        treeNode u = root;//step4
        while (true) {
            if (u.leftChild == null && u.rightChild == null) {
                return min;//step5
            }
            if (u.rightChild == null) {
                if (u == distSmallerNode(u, u.leftChild, edges)) return min;
            }
            if (u.rightChild != null) {
                if (u == distSmallerNode(u, u.leftChild, edges) &&
                        u == distSmallerNode(u, u.rightChild, edges)) return min;
            }
            treeNode v = u.leftChild;
            if (u.rightChild != null) v = distSmallerNode(u.leftChild, u.rightChild, edges);
            swapkey(u, v);
            u = v;//step7
        }
    }
    public static void swapkey(treeNode a, treeNode b) {
        int temp = a.key;
        a.key = b.key;
        b.key = temp;
    }
    public static treeNode distSmallerNode(treeNode a, treeNode b, ArrayList<Path>edges) {
        if (edges.get(a.key).weight < edges.get(b.key).weight) return a;
        else return b;
    }
    public void print() {
        for(int i = 1;i<q+1;i++){
            System.out.println(path[Q[i]]);
        }
    }
}
