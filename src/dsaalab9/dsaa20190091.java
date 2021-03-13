package dsaalab9;

import java.util.*;


public class dsaa20190091 {
    public static class Vertex{
        ArrayList<Edge>list = new ArrayList<>();
        int key;
        int color;
        int height;
        public Vertex(int key){
            this.key = key;
            this.color = 0;//whi
            this.height = 0;
        }
    }

    public static class Edge{
        int target;
        int weight;
        public Edge(int target, int weight){
            this.target = target;
            this.weight = weight;
        }
    }

    static Vertex [] v, arr;
    static Scanner in = new Scanner(System.in);
    static Vertex root;
    static int front, rear, n, m, min, S, T;
    public static void main(String[] args) {
        dsaa20190091 a = new dsaa20190091();

        front = 0;
        rear = 0;
        min = -1;
        a.input();
        System.out.println(min);

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
            int w = in.nextInt();
            v[a].list.add(new Edge(b,w));
            v[b].list.add(new Edge(a,w));
        }
        S = in.nextInt();
        T = in.nextInt();
        enqueue(v[S]);
        v[S].color = 1;
        BFS(dequeue());
    }

    public void BFS(Vertex a) {
        for(int i = 0;i<a.list.size();i++){
            Vertex b = v[a.list.get(i).target];
            int h = a.height+a.list.get(i).weight;
            if(b.color==0) {
                b.color = 1;
                b.height = h;
                enqueue(b);
            }
            if(b.key==v[T].key){
                if(h<=b.height){
                    b.height = h;
                    min = b.height;
                }
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
