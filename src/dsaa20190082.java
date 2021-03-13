import java.util.*;


public class dsaa20190082 {
    public static class Vertex{
        ArrayList<Integer>list = new ArrayList<>();
        int x;
        int y;
        int s;
        int key;
        int color;
        public Vertex(int x, int y, int s, int key){
            this.x = x;
            this.y = y;
            this.s = s;
            this.key = key;
            this.color = 0;//whi
        }
    }

    static Vertex [] v, arr;
    static Scanner in = new Scanner(System.in);
    static Vertex root;
    static int front, rear, K;
    static boolean isBlocked;
    public static void main(String[] args) {
        dsaa20190082 a = new dsaa20190082();
        int T = in.nextInt();
        for(int r = 0;r<T;r++) {
            front = 0;
            rear = 0;
            isBlocked = false;
            a.input();
            if(isBlocked) System.out.println("No");
            else System.out.println("Yes");
        }
    }

    public void input(){
        int m = in.nextInt();
        int n = in.nextInt();
        K = in.nextInt();//monster number
        v = new Vertex[K+2];
        arr = new Vertex[K+2];
        v[0] = new Vertex(0,n,0,0);
        v[K+1] = new Vertex(m,0,0,K+1);
        for(int i = 1;i<K+1;i++){
            int x = in.nextInt();
            int y = in.nextInt();
            int s = in.nextInt();
            v[i] = new Vertex(x, y, s, i);
        }
        construct(m,n,K);
    }

    public void construct(int m, int n, int K){
        for(int i = 1;i<K+1;i++){
            if(v[i].s>=v[i].x||v[i].s>=(n-v[i].y)){
                v[0].list.add(i);
            }//ld
            if(v[i].s>=(m-v[i].x)||v[i].s>=v[i].y){
                v[i].list.add(K+1);
            }//ru
            for(int j = i+1;j<K+1;j++){
                if(isObstructive(v[i],v[j])){
                    v[i].list.add(j);
                    v[j].list.add(i);
                }
            }
        }//construct
        enqueue(v[0]);
        v[1].color = 1;
        BFS(dequeue());
    }

    public void BFS(Vertex a) {
        for(int i = 0;i<a.list.size();i++){
            Vertex b = v[a.list.get(i)];
            if(b.key==v[K+1].key){
                isBlocked = true;
                return;
            }
            if(b.color==0) {
                b.color = 1;
                enqueue(b);
            }
        }
        if(front==rear)return;
        BFS(dequeue());
    }

    public void enqueue(Vertex item){
        if(rear<arr.length){
            arr[rear] = item;
            rear++;
        }
    }

    public Vertex dequeue(){
        if(front<rear) front++;
        return arr[front-1];
    }

    public boolean isObstructive(Vertex a, Vertex b){
        double dis = Math.pow((a.x-b.x),2)+Math.pow((a.y-b.y),2);
        double att = Math.pow((a.s+b.s),2);
        if(att>=dis)return true;
        return false;
    }
}
