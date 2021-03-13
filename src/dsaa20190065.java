import java.util.*;
public class dsaa20190065 {

    static int red;
    static int blue;
    static int sum;
    static public class edge{
        int x;
        int y;

        public edge(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static public class treeNode{
        int color;
        int level = -1;
        int treered;
        int treeblue;
        ArrayList<Integer>children = new ArrayList<>();
        public treeNode(int color, int treered, int treeblue){
            this.color = color;
            this.treered = treered;
            this.treeblue = treeblue;
        }
    }
    static ArrayList<edge>Edge;
    static treeNode[]list;
    public  static void findTree() {
        for (int i = 0; i < Edge.size(); i++) {
            int x = Edge.get(i).x;
            int y = Edge.get(i).y;
            list[x].children.add(y);
            list[y].children.add(x);
        }
    }
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int r = 0;r<T;r++){

            int N = in.nextInt();
            red = 0;
            blue = 0;
            sum = 0;
            Edge = new ArrayList<>();
            list = new treeNode[N+1];

            for(int i = 0;i<N-1;i++){
                Edge.add(new edge(in.nextInt(),in.nextInt()));
            }
            for(int i = 1;i<N+1;i++){
                int color = in.nextInt();
                if(color==1){
                    red++;
                    list[i] = new treeNode(color,1,0);
                } else if(color==2){
                    blue++;
                    list[i] = new treeNode(color,0,1);
                } else list[i] = new treeNode(color,0 ,0);

            }list[1].level = 0;
            findTree();
            findcolor(1);
            System.out.println(sum);
        }
    }

    public static void findcolor(int root) {

        for(int i = 0;i<list[root].children.size();i++){
            int child = list[root].children.get(i);
            if(list[child].level==-1) {
                list[child].level = list[root].level + 1;
                findcolor(child);
                list[root].treered+=list[child].treered;
                list[root].treeblue+=list[child].treeblue;
                cut(list[child].treered,list[child].treeblue);
            }
        }//root = 0 special
    }

    public static boolean cut(int treered, int treeblue){
        if((treered==0&&treeblue==blue)||(treeblue==0&&treered==red)){
            sum++;
            return true;
        }
        return false;
    }
}
//root 有多少个1 2已知  然后判断每个子节点 有多少个1 2 然后和外面比较 red[2]+=red[3]