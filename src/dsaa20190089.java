import java.util.*;

public class dsaa20190089 {
    public static class Vertex{
        ArrayList<Path>edges=new ArrayList<>();
        ArrayList<Path>paths=new ArrayList<>();
        int key, color, tl, tr;
        long a, b;
        public Vertex(int key, long a, long b){
            this.key = key;
            this.a = a;
            this.b = b;
            this.color = 0;//whi
            this.tl = 0;
            this.tr = 0;
        }
    }
    public static class Path{
        Vertex target;
        int cnt;
        private Path(Vertex target){
            this.target = target;
            this.cnt = 0;
        }
    }

    static Vertex [] v, arr;
    static int n, m, top, time;
    static long bignum = (long) 1e9+7;
    //static int[][]ab;
    static int [][]cnt;
    static ArrayList<Integer>L;
    static Scanner in = new Scanner(System.in);

    public void input(){
        n = in.nextInt();//nodes
        m = in.nextInt();//edges
        v = new Vertex[n+1];
        arr = new Vertex[n+1];
        cnt = new int[n+1][n+1];
        for(int i = 1;i<n+1;i++){
            v[i] = new Vertex(i,in.nextLong(),in.nextLong());
        }
        for(int i = 1;i<m+1;i++){
            v[in.nextInt()].edges.add(new Path(v[in.nextInt()]));
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
        if(a.edges.size()>0) {
            Vertex b = a.edges.get(0).target;
            if(b.color == 2){
                matrixUpadate(a,b);
                a.edges.remove(0);
                DFS(a);
            }else if (b.color == 0){
                pushUpdate(b);
            }else {
                System.out.println("wrong");
            }
        }
        else popUpdate(a);
    }
    public void matrixUpadate(Vertex a, Vertex b){
        cnt[a.key][b.key]++;
        for(int i = 1;i<n+1;i++){
            cnt[a.key][i] += cnt[b.key][i];
        }
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
        v.color = 2;
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

    public long caculate(){
        long result = 0;
        for(int i = 1;i<n+1;i++){
            long temp = 0;
            for(int j = 1;j<n+1;j++){
                long c = (cnt[i][j]*v[j].b)%bignum;
                temp+=c;
            }
            temp%=bignum;
            temp=(v[i].a*temp)%bignum;
            result += temp;
        }
        result %= bignum;
        return result;
    }

    public void print(){
        System.out.println(caculate());
    }

    public static void main(String[] args) {
        int T = in.nextInt();
        for(int r = 0;r<T;r++) {
            dsaa20190089 a = new dsaa20190089();
            top = -1;
            time = 0;
            L = new ArrayList<>();
            a.input();
            a.build();
            a.print();
        }
    }
}

/*for(int i = 1;i<n+1;i++){
            for(int j = 1;j<n+1;j++){
                System.out.print(cnt[i][j]+" ");
            }
            System.out.println();
        }*/
