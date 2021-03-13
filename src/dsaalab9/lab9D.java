package dsaalab9;

import java.util.*;

public class lab9D {

    static int verNum, edgesNum;
    static Vertex[] V;
    public static void main(String[] args){
        lab9D a = new lab9D();
        a.input();
    }
    public void input(){
        Scanner in = new Scanner(System.in);
        int row = in.nextInt();
        int col = in.nextInt();
        verNum = row*col;
        edgesNum = (row-1)*col+(col-1)*row;
        V = new Vertex[verNum+1];
        List<Edge>edges = new ArrayList<>();
        for(int i = 1;i<verNum+1;i++)
            V[i] = new Vertex(i,in.nextInt());
        for(int i = 0;i<row;i++){
            for(int j = 1;j<col;j++){
                int e1 = i*col+j;
                int e2 = e1+1;
                edges.add(new Edge(e1,e2,V[e1].coe*V[e2].coe));
            }
        }
        for(int i = 0;i<row-1;i++){
            for(int j = 1;j<col+1;j++){
                int e1 = i*col+j;
                int e2 = e1+col;
                edges.add(new Edge(e1,e2,V[e1].coe*V[e2].coe));
            }
        }
        System.out.println(Kruskal(edges, verNum));
    }
    public class Edge{
        int u;
        int v;
        long weight;
        public Edge(int u, int v, long weight){
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }
    public class Vertex{
        int key;
        int coe;
        boolean known = false;
        public Vertex(int key, int coe){
            this.key = key;
            this.coe = coe;
        }
    }
    public class DisjSets{
        private int s[];
        public DisjSets(int elements){
            s = new int[elements+1];
            for(int i = 1;i<elements+1;i++) s[i]=-1;
        }
        public void union(int root1, int root2){
            if(s[root1]<s[root2]){
                s[root2] = root1;
            }else if(s[root1]==s[root2]){
                s[root1]--;
                s[root2] = root1;
            }else s[root1] = root2;
        }
        public int find(int x){
            if(s[x]<0) return x;
            else return s[x] = find(s[x]);
        }
    }
    public long Kruskal(List<Edge> edges, int vertices){
        DisjSets ds = new DisjSets(vertices);
        PriorityQueue<Edge> pq = new PriorityQueue<>(edgeComparatorRe);//maxi
        for(Edge e:edges) pq.add(e);
        int cnt = 0;
        long sum = 0;
        while(cnt!=vertices-1){
            Edge e = pq.poll();
            int uSet = ds.find(e.u);
            int vSet = ds.find(e.v);
            if(uSet!=vSet) {
                ds.union(uSet,vSet);
                sum+=e.weight;
                cnt++;
            }
        }
        return sum;
    }

    public static Comparator<Edge> edgeComparatorRe = new Comparator<Edge>(){
        @Override
        public int compare(Edge e1, Edge e2) {
            return (int) (e2.weight-e1.weight);
        }
    };










}
