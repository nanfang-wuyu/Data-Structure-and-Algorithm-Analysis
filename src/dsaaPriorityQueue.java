import java.util.*;

public class dsaaPriorityQueue {

    public static class Vertex{
        ArrayList<Integer>list = new ArrayList<>();
        ArrayList<Integer>child = new ArrayList<>();
        int key, color, tl, tr;
        public Vertex(int key){
            this.key = key;
            this.color = 0;//whi
            this.tl = 0;
            this.tr = 0;
        }
    }

    static Vertex [] v;
    static int front, rear;//start from 1;
    static int[]M,dist;//start from 1;

    public void insert(int[] M, int item){
        int rm = rear;
        M[rm] = item;
        rear++;
        while(true){
            if(rm==front) return;
            if(dist[M[rm/2]]>dist[M[rm]])return;
            int temp = M[rm];
            M[rm] = M[rm/2];
            M[rm/2] = temp;
            rm = rm/2;
        }
    }

    public void deleteMin(int[] M){
        int rm = rear-1;
        M[1] = M[rm];
        rear--;
        rm = 1;
        while (true){
            if(rm*2<rear){
                if(rm*2+1<rear) {
                    if (dist[M[rm]] > dist[M[rm * 2]]&&dist[M[rm]]>dist[M[rm*2+1]]) {
                        int c = keySmallerDist(rm*2,rm*2+1);
                        swap(M,rm,c);
                        rm = c;
                    }else if(dist[M[rm*2]] == keySmallerDist(rm*2,rm*2+1)){
                        swap(M,rm,rm*2);
                        rm = rm * 2;
                    }else {
                        swap(M,rm,rm*2+1);
                        rm = rm * 2+1;
                    }
                }//both left and right exist;
                else if (dist[M[rm]] > dist[M[rm * 2]]) {
                    swap(M,rm,rm*2);
                    rm = rm * 2;
                    return;
                }//left exist but right not;
            }else return;//both not exist;
        }
    }

    public static int keySmallerDist(int a, int b) {
        if(dist[M[a]]<dist[M[b]])return a;
        else return b;
    }

    public void swap(int[]M, int a, int b){
        int temp = M[a];
        M[a] = M[b];
        M[b] = temp;
    }
}
