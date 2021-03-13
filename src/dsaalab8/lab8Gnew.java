package dsaalab8;

import java.util.*;

public class lab8Gnew {

    public static class Vertex {
        ArrayList<Path> edges  = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
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
        int tth;
        long weight;
        long lastweight;
        Path partEdge;

        public Path(int pre, int target, long weight, long lastweight, Path partEdge) {
            this.pre = pre;
            this.target = target;
            this.weight = weight;
            this.lastweight = lastweight;
            this.partEdge = partEdge;
        }
    }

    static Vertex[] v;
    static PriorityQueue<Path> P;
    static int n, m, q, maxq;
    static int[] Q;
    static long[] path;
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int T = in.nextInt();
        for(int r = 0;r<T;r++) {
            lab8Gnew a = new lab8Gnew();
            a.input();
            a.print();
        }
    }

    public static Comparator<Path> pathComparator = new Comparator<Path>(){
        @Override
        public int compare(Path p1, Path p2) {
            return (int) (p1.weight-p2.weight);
        }
    };

    public void input() {
        n = in.nextInt();
        m = in.nextInt();
        q = in.nextInt();
        v = new Vertex[n + 1];
        P = new PriorityQueue<>(pathComparator);
        for (int i = 1; i < n + 1; i++) {
            v[i] = new Vertex(i);
            v[i].edges.add(null);
            v[i].list.add(null);
        }
        for (int i = 1; i < m + 1; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            long w = in.nextLong();
            v[a].list.add(b);
            v[a].edges.add(new Path(a, b, w,0, null));
        }
        for(int i = 1;i<n+1;i++){
            quickSort(v[i].edges,1,v[i].edges.size()-1);
            if(v[i].edges.size()>1) {
                v[i].edges.get(1).tth = 1;
                P.add(v[i].edges.get(1));
            }
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
            Path p = P.poll();//ABC
            path[i] = p.weight;
            //ABCD
            if(v[p.target].list.size()>1) {
                Path q = v[p.target].edges.get(1);
                q.tth = 1;
                P.add(new Path(p.target, q.target,  p.weight + q.weight, p.weight, q));
            }
            //ABD
            int tth = 1;
            if(p.partEdge!=null) tth = p.partEdge.tth;
            if(v[p.pre].list.size()>1+tth) {
                Path t = v[p.pre].edges.get(tth+1);
                t.tth = tth+1;
                P.add(new Path(p.pre,t.target,p.lastweight+t.weight,p.lastweight,t ));
            }
        }
    }

    public void print() {
        for(int i = 1;i<q+1;i++){
            System.out.println(path[Q[i]]);
        }
    }

    public static void quickSort(ArrayList<Path>sort,int l,int r){

        if(l>=r){
            return;
        }
        else{
            Random ran = new Random();
            int i = ran.nextInt(r-l+1)+l;
            Path temp = sort.get(l);
            sort.set(l,sort.get(i));
            sort.set(i,temp);
            Path v = sort.get(l);
            int lt = l;
            int gt = r+1;
            i = l + 1;

            while (i<gt){
                if(sort.get(i).weight<v.weight){
                    temp = sort.get(lt+1);
                    sort.set(lt+1,sort.get(i));
                    sort.set(i,temp);
                    lt++;
                    i++;
                }else if(sort.get(i).weight>v.weight){
                    temp = sort.get(gt-1);
                    sort.set(gt-1,sort.get(i));
                    sort.set(i,temp);
                    gt--;
                }else {i++;}
            }
            temp = sort.get(l);
            sort.set(l,sort.get(lt));
            sort.set(lt,temp);
            lt--;
            quickSort(sort,l,lt);
            quickSort(sort,gt,r);
        }
    }
}
