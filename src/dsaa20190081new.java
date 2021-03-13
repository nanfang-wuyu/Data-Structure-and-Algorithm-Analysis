/*
import java.util.*;

public class dsaa20190081new {
    public class edge{
        int cnt = 0;
    }

    public class vertex{
        ArrayList<Integer> list = new ArrayList<>();
        edge [] edges;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int r = 0;r<T;r++) {
            int n = in.nextInt();
            int m = in.nextInt();
            vertex arr[] = new vertex[n+1];
            for(int i = 1;i<m+1;i++)arr[i].edges = new edge[n+1];
            for(int i = 1;i<m+1;i++) {
                int v = in.nextInt();
                int w = in.nextInt();
                arr[v].list.add(w);
                arr[v].edges[w].cnt++;
            }
            String s = "";
            for(int i = 1;i<n+1;i++){
                s +="0 ";
            }
            for(int i = 1;i<n+1;i++){
                for(int j = 0;j<arr[i].list.size();j++){
                    String p = String.valueOf(arr[i].edges[arr[i].list.get(j)].cnt);
                    s.replace(arr[i].list.get(j),arr[i].list.get(j)+1,p);
                    s.replace(3,7,p)
                }
            }
        }
    }
}
*/
