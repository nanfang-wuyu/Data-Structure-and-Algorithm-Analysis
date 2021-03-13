import java.util.*;


public class dsaa20190086 {
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
    static int n, top, time, maxHight, nowHight, subHeight;
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
        for(int i = 0;i<root.size();i++) {
            nowHight = 0;
            subHeight = 0;
            int index = root.get(i);
            pushUpdate(v[index]);
            DFS(v[index]);
        }
    }
    public void DFS(Vertex u) {
        Vertex a = u;
        while(top!=-1) {
            System.out.println("nowHeight"+nowHight+" subHeight"+subHeight+" maxHeight"+maxHight);
            System.out.println(a.key);
            if (a.list.size() > 0) {
                Vertex b = v[a.list.get(0)];
                System.out.println(b.key+" b.subHeight"+b.subHeight);
                a.list.remove(0);
                if (b.color == 0) {
                    a.child.add(b.key);
                    if (a.subHeight < a.c + subHeight) a.subHeight = a.c + subHeight;
                    pushUpdate(b);
                    a = b;
                }
                else if(b.color == 2){
                    if(a.subHeight<a.c+b.subHeight) a.subHeight = a.c+b.subHeight;
                    if (nowHight + b.subHeight > maxHight) maxHight = nowHight + b.subHeight;

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
        nowHight += v.c;
        subHeight = 0;
        if(nowHight>maxHight) maxHight = nowHight;
    }
    public void popUpdate(Vertex v){
        pop();
        v.color = 2;
        time++;
        v.tr = time;
        nowHight -= v.c;
        subHeight += v.c;
        if(v.subHeight<subHeight) v.subHeight = subHeight;
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
    public boolean judge(Vertex a, Vertex b){
        if((a.a>b.a&&a.b>b.b)||(a.a>b.b&&a.b>b.a)) return true;
        return false;
    }

    public static void main(String[] args) {
        int T = in.nextInt();
        for(int r = 0;r<T;r++) {
            dsaa20190086 a = new dsaa20190086();
            root = new ArrayList<>();
            top = -1;
            time = 0;
            maxHight = 0;
            nowHight = 0;
            subHeight = 0;
            a.input();
            a.print();
        }
    }
    public void print(){
        System.out.println(maxHight);
    }

}
