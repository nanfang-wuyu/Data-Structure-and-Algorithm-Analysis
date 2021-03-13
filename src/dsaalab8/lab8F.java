package dsaalab8;
import java.util.*;
public class lab8F {
    public static void main(String[] args){
        int T = in.nextInt();
        for(int r = 0;r<T;r++) {
            lab8F a = new lab8F();
            root = new ArrayList<>();
            top = -1;
            time = 0;
            a.input();
            a.print();
        }
    }
    public void print(){
        System.out.println(mH);
    }
    public static class Vertex{
        ArrayList<Integer>list = new ArrayList<>();
        ArrayList<Integer>child = new ArrayList<>();
        Vertex parent;
        int key, a, b, c, color, tl, tr, isBase, dist;
        public Vertex(int key, int a, int b, int c){
            this.key = key;
            this.a = a;
            this.b = b;
            this.c = c;
            this.color = 0;//whi
            this.tl = 0;
            this.tr = 0;
            this.isBase = 1;
            this.dist = -1;
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
    static Vertex [] V;
    static List<Edge>edges;
    //static PriorityQueue<Vertex> pq;
    static ArrayList<Integer>L, root,m;
    static int verNum, edgesNum, top, time,mH;
    static Scanner in = new Scanner(System.in);
    public void input(){
        verNum = in.nextInt();
        V = new Vertex[verNum+1];
        m = new ArrayList<>();
        mH = -1;
        //pq = new PriorityQueue<>(vertexComparator);
        for(int i = 1;i<verNum+1;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            V[i] = new Vertex(i,a,b,c);
        }
        for(int i = 1;i<verNum+1;i++){
            for(int j = 1;j<verNum+1;j++){
                if(judge(V[i], V[j])){
                    V[i].list.add(j);
                    V[j].isBase = 0;
                }
            }
        }
        for(int i = 1;i<verNum+1;i++){
            if(V[i].isBase==1) root.add(i);
        }
        build();
    }
    public void build(){
        for(int i = 0;i<root.size();i++) {
            int index = root.get(i);
            PriorityQueue<Vertex>pq = new PriorityQueue<>(vertexComparator);
            int nH = Dijkstra(index,pq);
            if(nH>mH) mH = nH;
        }
    }
    public boolean judge(Vertex a, Vertex b){
        if((a.a>b.a&&a.b>b.b)||(a.a>b.b&&a.b>b.a)) return true;
        return false;
    }
    public int Dijkstra(int start, PriorityQueue<Vertex>pq){
        V[start].color = 1;
        V[start].dist = V[start].c;
        pq.add(V[start]);
        int maxHeight = V[start].dist;
        int u = start;
        for(int j = 1;j<verNum+1;j++) {
            for (int i = 0; i < V[u].list.size(); i++) {
                int t = V[u].list.get(i);
                System.out.println(u+" "+t);
                maxHeight = updateDist(u, t, V[t].c,pq,maxHeight);
                System.out.println("mH"+maxHeight);
            }
            if(pq.size()>0) {
                do {
                    u = pq.poll().key;
                } while (V[u].color == 1&&pq.size()>0);
                V[u].color = 1;
            }else return maxHeight;
        }return maxHeight;
    }
    public int updateDist(int u, int t, int weight, PriorityQueue<Vertex>pq, int maxHeight){
        if(V[t].dist<V[u].dist+weight) {
            V[t].dist = V[u].dist + weight;
            pq.add(V[t]);
            if(V[t].dist>maxHeight) maxHeight = V[t].dist;
        }return maxHeight;
    }
    public static Comparator<Vertex> vertexComparator = new Comparator<Vertex>(){
        @Override
        public int compare(Vertex v1, Vertex v2) {
            return (int) (v2.c-v1.c);
        }
    };
}
