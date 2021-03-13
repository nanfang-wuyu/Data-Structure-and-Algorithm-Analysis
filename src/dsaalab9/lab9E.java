package dsaalab9;

import java.util.*;


public class lab9E {

    static public class treeNode{
        int key;
        treeNode leftChild;
        treeNode rightChild;
        treeNode parent;
        public treeNode(int key){this.key = key;}
    }

    public static class Vertex{
        ArrayList<Edge>list = new ArrayList<>();
        int key,color;
        long dist[];
        Vertex parant;
        public Vertex(int key, long dist){
            this.key = key;
            this.color = 0;
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

    public static void insert(ArrayList<treeNode>list, int item, int r){
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
            if (v[u.key].dist[r] > v[u.parent.key].dist[r]) return;//step4
            swapkey(u, u.parent);//step5.1
            u = u.parent;//step5.2
        }
    }
    public static int deleteMin(ArrayList<treeNode>list, int r){
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
                if(u == distSmallerNode(u,u.leftChild,r))return min;
            }
            if (u.rightChild != null){
                if(u == distSmallerNode(u,u.leftChild,r) &&
                        u == distSmallerNode(u,u.rightChild,r))return min;
            }
            treeNode v = u.leftChild;
            if(u.rightChild!=null)v = distSmallerNode(u.leftChild,u.rightChild,r);
            swapkey(u,v);
            u = v;//step7
        }
    }
    public static void swapkey(treeNode a, treeNode b){
        int temp = a.key;
        a.key = b.key;
        b.key = temp;
    }
    public static treeNode distSmallerNode(treeNode a, treeNode b, int r){
        if(v[a.key].dist[r]<v[b.key].dist[r])return a;
        else return b;
    }

    static ArrayList<treeNode>U;
    static Vertex[] v;
    static int n, m, p, k, start, target;
    static long max = (long) 5e10+1;
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        lab9E a = new lab9E();
        a.input();
        a.print();
    }

    public void input(){


        n = in.nextInt();
        m = in.nextInt();
        p = in.nextInt();
        k = in.nextInt();

        v = new Vertex[n+1];
        for(int i = 1;i<n+1;i++){
            v[i] = new Vertex(i,max);
            v[i].dist = new long[k+1];
            for(int j = 0;j<k+1;j++) v[i].dist[j] = max;
        }
        for(int i = 1;i<m+1;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int w = in.nextInt();
            v[a].list.add(new Edge(b,w));
        }
        for(int i = 1;i<p+1;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int w = 0;
            v[a].list.add(new Edge(b,w));
        }
        start = in.nextInt();
        target = in.nextInt();
        for(int r = 0;r<k+1;r++) {
            U = new ArrayList<>();
            U.add(new treeNode(-1));
            for(int c = 1;c<n+1;c++ ) v[c].color = 0;
            v[start].color = 1;
            v[start].dist[r] = 0;
            insert(U, start,r);
            Dijkstra(start, r);
        }
    }
    public void Dijkstra(int start, int r){
        int min = start;
        for(int j = 1;j<n+1;j++) {
            for (int i = 0; i < v[min].list.size(); i++) {
                int t = v[min].list.get(i).target;
                updateDist(min, t, v[min].list.get(i).weight, r);
            }
            if(U.size()>1) {
                do {
                    min = deleteMin(U,r);
                } while (v[min].color == 1&&U.size()>1);
                v[min].color = 1;
            }else return;
        }
    }

    public void updateDist(int u, int t, int weight, int r){
        if(r == 0) {
            if (weight != 0) {
                if (v[t].dist[r] > v[u].dist[r] + weight) {
                    v[t].dist[r] = v[u].dist[r] + weight;
                    insert(U, t,r);
                }
            }
        }else {
            if (weight != 0) {
                if (v[t].dist[r] > v[u].dist[r] + weight) {
                    v[t].dist[r] = v[u].dist[r] + weight;
                    insert(U, t,r);
                }
            }else {
                if (v[t].dist[r] > v[u].dist[r-1] + weight) {
                    v[t].dist[r] = v[u].dist[r-1] + weight;
                    insert(U, t,r);
                }
            }
        }
    }

    public void print(){
        if(v[target].dist[k]!=max)System.out.println(v[target].dist[k]);
        else System.out.println(-1);
    }
}