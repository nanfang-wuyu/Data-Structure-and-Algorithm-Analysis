package dsaalab9;

import java.util.*;


public class dsaa20190093 {
    public static class Vertex{
        ArrayList<Integer>list = new ArrayList<>();
        ArrayList<Integer>child = new ArrayList<>();
        int key, color, tl, tr;
        public Vertex(int key){
            this.key = key;
            this.color = 0;//whi
            this.tl = 0;
            this.tr = 0;
        }
    }
    static Vertex [] v, arr, v2;
    static int n, m, top, time;
    static ArrayList<Integer>L;
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {


            dsaa20190093 a = new dsaa20190093();
            top = -1;
            time = 0;
            L = new ArrayList<>();
            a.input();
            if(a.build1()&&a.build2()){
                System.out.println("Bravo");
            }else System.out.println("ovarB");

    }

    public void input(){
        n = in.nextInt();
        m = in.nextInt();
        v = new Vertex[n+1];
        arr = new Vertex[n+1];
        v2 = new Vertex[n+1];
        for(int i = 1;i<n+1;i++){
            v[i] = new Vertex(i);
            v2[i] = new Vertex(i);
        }
        for(int i = 0;i<m;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            v[a].list.add(b);
            v2[b].list.add(a);
        }
    }

    public boolean build1(){
        pushUpdate(v[1]);
        DFS(v[1],v);
        for(int i = 1;i<n+1;i++) {
            if(v[i].color==0){
                return false;
            }
        }
        return true;
    }

    public boolean build2(){
        pushUpdate(v2[L.get(L.size()-1)]);
        DFS(v2[L.get(L.size()-1)],v2);
        for(int i = 1;i<n+1;i++) {
            if(v2[i].color==0) {
                return false;
            }
        }
        return true;
    }

    public void DFS(Vertex u, Vertex[] V) {
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

