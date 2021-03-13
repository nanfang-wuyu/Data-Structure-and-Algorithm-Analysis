package dsaalab9;
import java.lang.reflect.Array;
import java.util.*;
public class Dijkstra {
    public static class Vertex{
        ArrayList<Edge>list = new ArrayList<>();
        int key;
        int color;
        int dist;
        Vertex parent;
        public Vertex(int key){
            this.key = key;
            this.color = 0;//whi
            this.dist = -1;
            this.parent = null;
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

    public void Dijkstra(Vertex S){
        S.dist = 0;
        int min = -1;
        for(int i = 0;i<S.list.size();i++){
            Vertex T = v[S.list.get(i).target];
            if(T.color==0) min = updateDist(S,T,S.list.get(i).weight,min);
        }
        if(min != -1){
            v[min].color = 1;
            Dijkstra(v[min]);
        }
    }

    public int updateDist(Vertex S, Vertex T, int weight, int min){
        if(T.dist>S.dist+weight||T.dist == -1) {
            T.dist = S.dist+weight;
            T.parent = S;
        }
        if(min==-1){
            return T.key;
        }else if(T.dist<v[min].dist){
            return T.key;
        }
        return min;
    }
}
