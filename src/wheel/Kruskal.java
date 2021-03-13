package wheel;

import java.util.*;

public class Kruskal {




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
            s = new int[elements];
            for( int i:s) i=-1;
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
    public ArrayList <Edge> Kruskal(List<Edge> edges, int vertices){
        DisjSets ds = new DisjSets(vertices);
        PriorityQueue<Edge> pq = new PriorityQueue<>(edgeComparator);
        for(Edge e:edges) pq.add(e);
        ArrayList<Edge>mst = new ArrayList<>();
        while(mst.size()!=vertices-1){
            Edge e = pq.poll();
            int uSet = ds.find(e.u);
            int vSet = ds.find(e.v);
            if(uSet!=vSet) {
                ds.union(uSet,vSet);
                mst.add(e);
            }
        }
        return mst;
    }

    public static Comparator<Edge> edgeComparator = new Comparator<Edge>(){
        @Override
        public int compare(Edge e1, Edge e2) {
            return (int) (e1.weight-e2.weight);
        }
    };









}
