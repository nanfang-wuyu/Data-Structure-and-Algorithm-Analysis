package dsaalab9;

import java.util.*;

public class lab9F {

    static int verNum;
    static Vertex[] V;
    public static void main(String[] args){
        lab9F a = new lab9F();
        a.input();
    }
    public void input(){
        Scanner in = new Scanner(System.in);
        verNum = in.nextInt();
        V = new Vertex[verNum+1];
        List<Edge>edges = new ArrayList<>();
        for(int i = 1;i<verNum+1;i++){
            V[i] = new Vertex(
                    i,in.nextLong(),in.nextLong(),in.nextLong(), in.nextLong());
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
        long key;
        long x;
        long y;
        long r;
        long t;
        boolean known = false;
        public Vertex(long key, long x, long y, long r, long t){
            this.key = key;
            this.x = x;
            this.y = y;
            this.r = r;
            this.t = t;
        }
    }
    public class DisjSets{
        private int s[];
        public DisjSets(int elements){
            s = new int[elements+1];
            for(int i = 1;i<elements+1;i++) s[i]=-1;
        }
        public void union(int root1, int root2){
           if(aBoomb(root1,root2)){
               if(aBoomb(root2,root1)){
                   if(s[root1]<s[root2])
                   if(V[root1].t<V[root2].t) s[root2] = root1;
                   else s[root1] = root2;
               }else s[root2] = root1;
           }else if(aBoomb(root2,root1)){
               s[root1] = root2;
           }
        }
        public int find(int x){
            if(s[x]<0) return x;
            else return s[x] = find(s[x]);
        }
    }
    public long Kruskal(List<Edge> edges, int vertices){
        DisjSets ds = new DisjSets(vertices);
            for(int i = 1;i<verNum+1;i++) {
                for(int j = i+1;j<verNum+1;j++) {
                    if(aBoomb(i,j)){
                        if(aBoomb(j,i)) {
                            //if(ds.s[i]>0&&ds.s[j]>0)
                        }
                        //else
                    }else if(aBoomb(j,i)){
                    }
                    int uSet = i;
                    int vSet = j;
                    System.out.println(uSet+" "+vSet);
                    if (uSet != vSet) {
                        ds.union(uSet, vSet);
                    }
                }
            }
            long tsum = 0;
            for(int i = 1;i<verNum+1;i++){
                if(ds.s[i]<0) {
                    tsum+=V[i].t;
                    System.out.println(V[i].key);
                }
            }
            return tsum;
    }

    public boolean aBoomb(int a, int b){
        long x2 = (long) Math.pow((V[a].x-V[b].x),2);
        long y2 = (long) Math.pow((V[a].y-V[b].y),2);
        long ra2 = V[a].r*V[a].r;
        System.out.println(x2+" "+y2+" "+ra2);
        System.out.println(x2+y2<=ra2);
        if(x2+y2<=ra2) return true;
        return false;
    }










}
