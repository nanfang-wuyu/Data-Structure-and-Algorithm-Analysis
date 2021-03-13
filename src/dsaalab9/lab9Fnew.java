package dsaalab9;

import java.lang.reflect.Array;
import java.util.*;

public class lab9Fnew {

    static int verNum,top;
    static Vertex[] V,Vr,arr;
    static ArrayList<Integer>L,Lr,root;
    public static void main(String[] args){
        lab9Fnew a = new lab9Fnew();
        top = -1;
        a.input();
    }
    public void input(){
        Scanner in = new Scanner(System.in);
        verNum = in.nextInt();
        V = new Vertex[verNum+1];
        Vr = new Vertex[verNum+1];
        L = new ArrayList<>();
        Lr = new ArrayList<>();
        root = new ArrayList<>();
        for(int i = 1;i<verNum+1;i++){
            long a = in.nextLong();
            long b = in.nextLong();
            long r = in.nextLong();
            long t = in.nextLong();
            V[i] = new Vertex(i,a,b,r,t);
            Vr[i] = new Vertex(i,a,b,r,t);
        }
        for(int i = 1;i<verNum+1;i++){
            for(int j = 1;j<verNum+1;j++){
                if(j!=i)
                if(aBoomb(i,j)){
                    V[i].list.add(j);
                    V[i].neibr.add(j);
                    V[j].listR.add(i);
                    V[j].in_degree++;
                    Vr[j].list.add(i);
                }
            }
        }
        buildR();
        build();
        int t_cost = 0;
        for(int i = 1;i<verNum+1;i++){
            if(V[i].in_degree==0) {
                t_cost += V[i].t;
            }
        }
        System.out.println(t_cost);
    }

    public void buildR(){
        top = -1;
        arr = new Vertex[verNum+1];
        for(int i = 1;i<verNum+1;i++) {
            if(Vr[i].color==0) {
                pushUpdate(Vr[i]);
                DFS(Vr[i],Vr,Lr,false);
            }
        }
    }

    public void build(){
        top = -1;
        arr = new Vertex[verNum+1];
        for(int i = 1;i<verNum+1;i++) {
            Vertex u = V[Lr.remove(Lr.size()-1)];
            if(u.color==0) {
                L = new ArrayList<>();
                pushUpdate(u);
                DFS(u,V, L,true);
            }
        }
    }

    public void DFS(Vertex u, Vertex[] V, ArrayList<Integer>L, boolean ifmerge) {
        Vertex a = u;
        while (top != -1) {
            if (a.list.size() > 0) {
                Vertex b = V[a.list.get(0)];
                a.list.remove(0);
                if (b.color == 0) {
                    a.child.add(b.key);
                    pushUpdate(b);
                    a = b;
                }
            } else {
                popUpdate(a,L);
                if(top!=-1)a = arr[top];
            }
        }
        if(ifmerge) merge(L);
    }

    public void merge(ArrayList<Integer>L){
        long tmin = 10001;
        int index = -1;
        for(int i:L){
            if(V[i].t<tmin) {
                tmin = V[i].t;
                index = i;
            }
        }
        boolean indZero = true;
        for(int i : L) {
            for(int parent : V[i].listR){
                if(!L.contains(parent)) indZero = false;
            }
        }
        if(indZero) V[index].in_degree = 0;
    }

    public void pushUpdate(Vertex v){
        push(v);
        v.color = 1;
    }
    public void popUpdate(Vertex v, ArrayList<Integer>L){
        pop();
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
    public class Vertex{
        int key;
        long x;
        long y;
        long r;
        long t;
        int color = 0;
        int in_degree = 0;
        ArrayList<Integer>list = new ArrayList<>();
        ArrayList<Integer>neibr = new ArrayList<>();
        ArrayList<Integer>listR = new ArrayList<>();
        ArrayList<Integer>child = new ArrayList<>();
        public Vertex(int key, long x, long y, long r, long t){
            this.key = key;
            this.x = x;
            this.y = y;
            this.r = r;
            this.t = t;
        }
    }

    public boolean aBoomb(int a, int b){
        long x2 = (long) Math.pow((V[a].x-V[b].x),2);
        long y2 = (long) Math.pow((V[a].y-V[b].y),2);
        long ra2 = V[a].r*V[a].r;
        /*System.out.println(a+" "+b+" "+x2+" "+y2+" "+ra2);*/
        if(x2+y2<=ra2) return true;
        return false;
    }










}
