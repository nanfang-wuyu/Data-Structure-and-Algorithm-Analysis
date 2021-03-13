import java.util.*;


public class dsaa20190083 {
    public static class Vertex{
        ArrayList<Integer>list = new ArrayList<>();
        int key;
        int color;
        int height;
        public Vertex(int key){
            this.key = key;
            this.color = 0;//whi
            this.height = 0;
        }
    }

    static Vertex [] v, arr;
    static Scanner in = new Scanner(System.in);
    static Vertex root;
    static int front, rear, city, n, m, min;
    public static void main(String[] args) {
        dsaa20190083 a = new dsaa20190083();

            front = 0;
            rear = 0;
            city = 0;
            min = -1;
            a.input();
            System.out.println(min);

    }

    public void input(){
        n = in.nextInt();
        m = in.nextInt();
        city = n+1;
        v = new Vertex[n+m+1];
        arr = new Vertex[n+m+1];
        for(int i = 1;i<n+m+1;i++){
            v[i] = new Vertex(i);
        }
        for(int i = 1;i<m+1;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int w = in.nextInt();
            if(w==1)v[a].list.add(b);
            else {
                v[a].list.add(city);
                v[city].list.add(b);
                city++;
            }
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
                b.height = a.height+1;
                enqueue(b);
            }
            if(b.key==v[n].key){
                if(min==-1||min>b.height){
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
