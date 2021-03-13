import java.util.Random;
import java.util.Scanner;
public class dsaa20190031new {

    static class Node{

        int coe;//系数
        int exp;//指数
        Node next;

        public Node(int coe,int exp) {
            this.coe = coe;
            this.exp = exp;
        }
    }

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        Random random = new Random();
        int T = in.nextInt();
        for(int c=0;c<T;c++){
            int n = in.nextInt();
            Node[] list = new Node[2000];
            list [0] = new Node(in.nextInt(),in.nextInt());
            for(int i = 1;i<n;i++){
                list [i] = new Node(in.nextInt(),in.nextInt());
                list [i-1].next = list[i];
            }
            int m = in.nextInt();
            for(int i = n;i<n+m;i++){
                list [i] = new Node(in.nextInt(),in.nextInt());
                list [i-1].next = list[i];
            }
            int x = in.nextInt();
            int p[] = new int[x];
            int q[] = new int[x];
            for(int i = 0;i<x;i++){q[i] = in.nextInt();}
            for(int j = 0;j<n+m;j++){
                for(int i = 0;i<x;i++){
                    if(list[j].exp==q[i]){
                        p[i] += list[j].coe;
                        break;
                    }
                }
            }
            for(int i = 0;i<x;i++) {
                if(i!=x-1){System.out.print(p[i]+" ");}
                else System.out.printf("%d\n",p[i]);
            }


        }
    }


}
             