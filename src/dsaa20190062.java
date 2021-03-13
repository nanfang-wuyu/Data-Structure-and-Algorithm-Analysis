import java.util.*;
public class dsaa20190062 {

    static public class edge{
        int x;
        int y;

        public edge(int x, int y){
            this.x = x;
            this.y = y;
        }
    }


    static public class treeNode{
        int depth = -1;
        ArrayList<Integer>children = new ArrayList<>();
    }
    static ArrayList<edge>Edge;
    static treeNode[]list;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int r = 0;r<T;r++){
            int N = in.nextInt();
            Edge = new ArrayList<>();
            list = new treeNode[N+1];
            for(int i = 0;i<N-1;i++){
                Edge.add(new edge(in.nextInt(),in.nextInt()));
            }
            for(int i = 1;i<N+1;i++){
                list[i] = new treeNode();
            }
            list[1].depth = 0;
            findTree();
            finddepth(1);
            for(int i = 1;i<N+1;i++){
                System.out.print(list[i].depth+" ");
            }
            System.out.println();
        }
    }

    public  static void findTree() {
        for (int i = 0; i < Edge.size(); i++) {
            int x = Edge.get(i).x;
            int y = Edge.get(i).y;
            list[x].children.add(y);
            list[y].children.add(x);
        }
    }

    public static void finddepth(int root){
        for(int i = 0;i<list[root].children.size();i++){
            int child = list[root].children.get(i);
            if(list[child].depth==-1) {
                list[child].depth = list[root].depth+1;
                finddepth(child);
            }
        }
    }

}

   /*if(Edge.size()==0)return;
        for(int i = 0;i<Edge.size();i++){
            int x = Edge.get(i).x;
            int y = Edge.get(i).y;
            if(x==root){
                list[y] = new treeNode(list[root].depth+1);
                list[root].children.add(y);
                Edge.remove(i);i--;
            }
            else if(y==root){
                list[x] = new treeNode(list[root].depth+1);
                list[root].children.add(x);
                Edge.remove(i);i--;
            }
        }
        for(int i = 0;i<list[root].children.size();i++) findTree(list[root].children.get(i));*/

            /*treeNode[]list = new treeNode[100000];
            list[1] = new treeNode(1,0);
            for(int i = 0;i<N-1;i++) {
                int a = in.nextInt();
                int b = in.nextInt();
                finddepth(N,a,b);
            }*/


            //双向