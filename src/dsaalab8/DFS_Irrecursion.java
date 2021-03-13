package dsaalab8;
import java.util.*;
public class DFS_Irrecursion {
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
    static ArrayList<Integer>L;
    static int[][] circledges;
    static int verNum, edgesNum, top, time, cirNum;
    static Scanner in = new Scanner(System.in);

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
}
