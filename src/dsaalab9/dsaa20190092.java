package dsaalab9;

import java.util.*;

public class dsaa20190092 {

    static public class treeNode{
        int key;
        treeNode leftChild;
        treeNode rightChild;
        treeNode parent;
        public treeNode(int key){this.key = key;}
    }

    public static class Vertex{
        ArrayList<Edge>list = new ArrayList<>();
        int key,color,dist;
        Vertex parant;
        public Vertex(int key, int dist){
            this.key = key;
            this.color = 0;
            this.dist = max;
            this.parant = null;
        }
    }

    public static class Edge{
        int target,weight;
        public Edge(int target, int weight){
            this.target = target;
            this.weight = weight;
        }
    }

    static ArrayList<treeNode>U;
    static Vertex[] v;
    static int n, m;
    static int max = 2147483647;
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        dsaa20190092 a = new dsaa20190092();
        a.input();
        a.print();
    }
    public void input(){
        U = new ArrayList<>();
        U.add(new treeNode(-1));
        n = in.nextInt();
        m = in.nextInt();
        v = new Vertex[n+1];
        for(int i = 1;i<n+1;i++){
            v[i] = new Vertex(i,max);
        }
        for(int i = 1;i<m+1;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int w = in.nextInt();
            v[a].list.add(new Edge(b,w));
            v[b].list.add(new Edge(a,w));
        }
        Prim();
    }
    public void Prim(){
        v[1].color = 1;
        v[1].dist = 0;
        insert(U,1);
        int min = 1;
        for(int j = 1;j<n+1;j++) {
            for (int i = 0; i < v[min].list.size(); i++) {
                int t = v[min].list.get(i).target;
                if(v[t].color==0) updatePrimDist(min, t, v[min].list.get(i).weight);
            }
            if(U.size()>1) {
                do {
                    min = deleteMin(U);
                } while (v[min].color == 1&&U.size()>1);
                v[min].color = 1;
            }else return;
        }
    }
    public void updatePrimDist(int u, int t, int weight){
        if(v[t].dist > weight) {
            v[t].dist = weight;
            insert(U,t);
            v[t].parant = v[u];
        }
    }
    public void print(){
        int sum = 0;
        for(int i = 1;i<n+1;i++){
            sum+=v[i].dist;
          /*  System.out.print(v[i].dist);
            if(v[i].parant!=null) System.out.println(" " + v[i].parant.key);*/
        }
        System.out.println(sum);
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
            if (v[u.key].dist > v[u.parent.key].dist) return;//step4
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
                if(u == distSmallerNode(u,u.leftChild))return min;
            }
            if (u.rightChild != null){
                if(u == distSmallerNode(u,u.leftChild) &&
                        u == distSmallerNode(u,u.rightChild))return min;
            }
            treeNode v = u.leftChild;
            if(u.rightChild!=null)v = distSmallerNode(u.leftChild,u.rightChild);
            swapkey(u,v);
            u = v;//step7
        }
    }
    public static void swapkey(treeNode a, treeNode b){
        int temp = a.key;
        a.key = b.key;
        b.key = temp;
    }
    public static treeNode distSmallerNode(treeNode a, treeNode b){
        if(v[a.key].dist<v[b.key].dist)return a;
        else return b;
    }
}
