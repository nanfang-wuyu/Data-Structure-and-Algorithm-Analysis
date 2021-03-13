package dsaalab9;

import java.util.*;

public class lab9G {
    public static class Vertex{
        ArrayList<Integer>list = new ArrayList<>();
        int key;
        int color;
        public Vertex(int key){
            this.key = key;
            this.color = 0;
        }
    }

    static Vertex [] v, arr;
    static Scanner in = new Scanner(System.in);
    static int top, n, m, travel, ttry;
    static boolean isHc;
    public static void main(String[] args) {
        lab9G a = new lab9G();
        top = -1;
        a.input();
    }

    public void input(){
        n = in.nextInt();
        m = in.nextInt();
        v = new Vertex[n+1];
        arr = new Vertex[n+1];
        isHc = false;
        for(int i = 1;i<n+1;i++){
            v[i] = new Vertex(i);
        }
        for(int i = 1;i<m+1;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            v[a].list.add(b);
        }
        v[1].color = 1;
        travel=1;
        ttry = 0;
        push(v[1]);
        Hc(v[1]);
        if(isHc) {
            for(Vertex v:arr) System.out.print(v.key+" ");
        }
        else System.out.println("ovarB");
    }

    public void Hc(Vertex a) {
        if(a==null) return;
        boolean isLeaf = true;
        for(int i = 0;i<a.list.size();i++){
            Vertex b = v[a.list.get(i)];
            if(b.color==0) {
                isLeaf = false;
                b.color = 1;
                travel++;
                push(b);
                Hc(b);
                if(isHc||ttry>20) return;
                b.color = 0;
                travel--;
                pop();
            }
        }
        if(isLeaf) {
            ttry++;
            if (isIsHc(a)) {
                isHc = true;
                push(v[1]);
                return;
            }
        }
    }

    public boolean isIsHc(Vertex a){
        if(travel==n&&a.list.contains(1)) return true;
        return false;
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

