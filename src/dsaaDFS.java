import java.util.*;


public class dsaaDFS {
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
    static Vertex [] v, arr;
    static int n, m, top, time;
    static ArrayList<Integer>L;
    static Scanner in = new Scanner(System.in);

    public void input(){
        n = in.nextInt();
        m = in.nextInt();
        v = new Vertex[n+1];
        arr = new Vertex[n+1];
        for(int i = 1;i<n+1;i++){
            v[i] = new Vertex(i);
        }
        for(int i = 0;i<m;i++){
            v[in.nextInt()].list.add(in.nextInt());
        }
    }
    public void build(){
        for(int i = 1;i<v.length;i++) {
            if(v[i].color==0) {
                pushUpdate(v[i]);
                DFS(v[i]);
            }
        }
    }
    public void DFS(Vertex a) {
        if(top==-1)return;
        if(a.list.size()>0) {
            Vertex b = v[a.list.get(0)];
            a.list.remove(0);
            if (b.color == 0){
                a.child.add(b.key);
                pushUpdate(b);
            }else DFS(a);
        }
        else popUpdate(a);
    }
    public void pushUpdate(Vertex v){
        push(v);
        v.color = 1;
        time++;
        v.tl = time;
        L.add(v.key);
        DFS(v);
    }
    public void popUpdate(Vertex v){
        pop();
        time++;
        v.tr = time;
        if(top!=-1)DFS(arr[top]);
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
    public boolean isAcyclic(){
        for(int i = 1;i<v.length;i++){
            for(int j = i+1;j<v.length;j++){
                if((v[i].tl<v[j].tl&&v[i].tr<v[j].tr)||(v[j].tl<v[i].tl&&v[j].tr<v[i].tr))
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int T = in.nextInt();
        for(int r = 0;r<T;r++) {
            dsaaDFS a = new dsaaDFS();
            top = -1;
            time = 0;
            L = new ArrayList<>();
            a.input();
            a.build();
            a.print();
        }
    }
    public void print(){

    }

}
