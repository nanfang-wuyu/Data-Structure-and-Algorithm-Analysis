package dsaalab8;

import java.util.*;


public class lab8H {
    public static class Vertex{
        ArrayList<Integer>list = new ArrayList<>();
        int key, color, tl, tr;
        Vertex parent;
        public Vertex(int key){
            this.key = key;
            this.color = 0;
            this.tl = 0;
            this.tr = 0;
            this.parent = null;
        }
    }
    public class Edge{
        int u;
        int v;
        public Edge(int u, int v){
            this.u = u;
            this.v = v;
        }
    }
    static Vertex [] V, arr;
    static List<Edge>edges;
    static int[][] circledges;
    static int verNum, edgesNum, top, time, cirNum;
    static boolean magic;
    static Scanner in = new Scanner(System.in);

    public void input(){
        verNum = in.nextInt();
        edgesNum = in.nextInt();
        cirNum = 0;
        magic = true;
        V = new Vertex[verNum+1];
        arr = new Vertex[verNum+1];
        edges = new ArrayList<>();
        circledges = new int[verNum+1][verNum+1];
        for(int i = 1;i<verNum+1;i++){
            V[i] = new Vertex(i);
        }
        for(int i = 1;i<edgesNum+1;i++){
            int u = in.nextInt();
            int v = in.nextInt();
            V[u].list.add(v);
            edges.add(new Edge(u,v));
        }
    }
    public void build(){
        for(int i = 1;i<verNum+1;i++) {
            if(V[i].color==0) {
                pushUpdate(V[i]);
                DFS(V[i]);
            }
        }
    }
    public void DFS(Vertex u) {
        Vertex a = u;
        while (top != -1) {
            if (a.list.size() > 0) {
                Vertex b = V[a.list.remove(0)];
                if (b.color == 0) {
                    b.parent = a;
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
    public boolean isAcyclic(){
        boolean isAcyclic = true;
        for(int i = 0;i<edgesNum;i++){
            Edge e = edges.get(i);
            int u = e.u;
            int v = e.v;
            if(V[u].tl>V[v].tl&&V[u].tr<V[v].tr){
                isAcyclic = false;
                if(!findCircle(e)) {
                    magic = false;
                    return isAcyclic;
                }
            }
        }return isAcyclic;
    }

    public boolean findCircle(Edge e){
        cirNum++;
        boolean haveSame = false;
        int v = e.v;
        int u = e.u;
        if(circledges[u][v]==cirNum-1) {
            circledges[u][v]++;
            haveSame = true;
        }
        while(u!=v){
            int u0 = V[u].parent.key;
            int v0 = u;
            if(circledges[u0][v0]==cirNum-1) {
                circledges[u0][v0]++;
                haveSame = true;
            }
            u = u0;
        }
       return haveSame;
    }

    public static void main(String[] args) {
        int T = in.nextInt();
        for(int r = 0;r<T;r++) {
            lab8H a = new lab8H();
            top = -1;
            time = 0;
            a.input();
            System.out.println(V[1].list.size());
            a.build();
            for(int i = 1;i<verNum+1;i++){
                System.out.println("I"+i+" "+"tl"+V[i].tl+" "+"tr"+V[i].tr);
            }
            a.isAcyclic();
            a.print();
        }
    }
    public void print(){
        if(magic) System.out.println("Yes");
        else System.out.println("No");
    }

}
/*4 6
1 2
2 3
3 1
1 3
3 4
4 1*/