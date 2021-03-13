package dsaalab9;

import java.util.*;

public class lab9B {

    static int verNum, edgesNum;
    static Vertex[] V;
    public static void main(String[] args){
        lab9B a = new lab9B();
        a.input();
    }
    public void input(){
        Scanner in = new Scanner(System.in);
        verNum = in.nextInt();
        edgesNum = in.nextInt();
        V = new Vertex[verNum+1];
        PriorityQueue<Edge> pq = new PriorityQueue<>(edgeComparator);
        for(int i = 1;i<verNum+1;i++)
            V[i] = new Vertex(i);
        for(int i = 1;i<edgesNum+1;i++)
            pq.add(new Edge(in.nextInt(),in.nextInt(),in.nextInt()));
        System.out.println(Kruskal(pq, verNum));
    }
    public class Edge{
        int u;
        int v;
        int weight;
        public Edge(int u, int v, int weight){
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }
    public class Vertex{
        int key;
        boolean known = false;
        public Vertex(int key){
            this.key = key;
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

    public int Kruskal(PriorityQueue<Edge>pq, int vertices){
        DisjSets ds = new DisjSets(vertices);
        int cnt = 0;
        int sum = 0;
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

    public static Comparator<Edge> edgeComparator = new Comparator<Edge>(){
        @Override
        public int compare(Edge e1, Edge e2) {
            return (int) (e1.weight-e2.weight);
        }
    };










}
