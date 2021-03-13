import java.util.*;


public class dsaa20190084 {
    public static class Vertex{
        ArrayList<Integer>list = new ArrayList<>();
        int key;
        int color;
        int tower;
        public Vertex(int key){
            this.key = key;
            this.color = 0;//whi
            this.tower = 0;
        }
    }

    static Vertex [] v, arr;
    static Scanner in = new Scanner(System.in);
    static Vertex root;
    static int front, rear, n, m, ts;
    public static void main(String[] args) {
        int T = in.nextInt();
        for(int r = 0;r<T;r++) {
            dsaa20190084 a = new dsaa20190084();
            front = 0;
            rear = 0;
            ts = 0;
            a.input();
            if(ts<n-ts) {
                System.out.println(ts);
                for(int i = 0;i<n;i++)
                    if(arr[i].tower==1)System.out.print(arr[i].key+" ");
            }
            else {
                System.out.println(n-ts);
                for(int i = 0;i<n;i++)
                    if(arr[i].tower==0)System.out.print(arr[i].key+" ");
            }
        }
    }

    public void input(){
        n = in.nextInt();
        m = in.nextInt();
        v = new Vertex[n+1];
        arr = new Vertex[n+1];
        for(int i = 1;i<n+1;i++){
            v[i] = new Vertex(i);
        }
        for(int i = 1;i<m+1;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            v[a].list.add(b);
            v[b].list.add(a);//both sides
        }
        enqueue(v[1]);
        v[1].color = 1;
        BFS(dequeue());
    }

    public void BFS(Vertex a) {
        for(int i = 0;i<a.list.size();i++){
            Vertex b = v[a.list.get(i)];
            if(b.color==0) {
                b.color = 1;
                if(a.tower==0) {
                    b.tower = 1;
                    ts++;
                }
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
}
