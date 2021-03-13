package dsaalab8;

import java.util.*;


public class lab8Fnew {
    public static class Vertex{
        ArrayList<Integer>list = new ArrayList<>();
        ArrayList<Integer>child = new ArrayList<>();
        int key, a, b, c, color, tl, tr, isBase, subHeight;
        public Vertex(int key, int a, int b, int c){
            this.key = key;
            this.a = a;
            this.b = b;
            this.c = c;
            this.color = 0;//whi
            this.tl = 0;
            this.tr = 0;
            this.isBase = 1;
            this.subHeight = c;
        }
    }
    static Vertex [] v, arr;
    static int n, top, time, maxHight;
    static ArrayList<Integer>root;
    static Scanner in = new Scanner(System.in);

    public void input(){
        n = in.nextInt();
        v = new Vertex[n+1];
        arr = new Vertex[n+1];
        for(int i = 1;i<n+1;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            v[i] = new Vertex(i,a,b,c);
        }
        for(int i = 1;i<n+1;i++){
            for(int j = 1;j<n+1;j++){
                if(judge(v[i], v[j])){
                    v[i].list.add(j);
                    v[j].isBase = 0;
                }
            }
        }
        for(int i = 1;i<n+1;i++){
            if(v[i].isBase==1) root.add(i);
        }
        build();
    }
    public void build(){
        for(int i:root) {
            v[i].color = 1;
            DFS(v[i]);
            int rootHeight = v[i].subHeight;
            if(rootHeight>maxHight) maxHight = rootHeight;
        }
    }
    public void DFS(Vertex a) {
            for(int i = 0;i<a.list.size();i++)
            {
                Vertex b = v[a.list.get(i)];
                if (b.color == 0) {
                    b.color = 1;
                    DFS(b);
                    if (a.c+b.subHeight>a.subHeight) a.subHeight = a.c + b.subHeight;
                }
                else {
                    if (a.c+b.subHeight>a.subHeight) a.subHeight = a.c + b.subHeight;
                }
            }
    }

    public boolean judge(Vertex a, Vertex b){
        if((a.a>b.a&&a.b>b.b)||(a.a>b.b&&a.b>b.a)) return true;
        return false;
    }

    public static void main(String[] args) {
        int T = in.nextInt();
        for(int r = 0;r<T;r++) {
            lab8Fnew a = new lab8Fnew();
            root = new ArrayList<>();
            top = -1;
            time = 0;
            maxHight = 0;
            a.input();
            a.print();
        }
    }
    public void print(){
        System.out.println(maxHight);
    }

}
