package dsaa2019compitition;
/*
import java.util.*;
public class q3 {
    public static class Node{
        String str;
        char[] c;
        public Node(String str){
            this.str = str;
            this.c = str.toCharArray();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int m = in.nextInt();
        int p = N-m+1;
        Node list[] = new Node[p];
        for(int i = 0;i<p;i++){
            list[i] = new Node(in.next());
        }
        char[]ans = new char[N];
    }
}
*/

import java.util.*;
public class q3 {
    public static class Node{
        String str;
        char[] c;
        public Node(String str){
            this.str = str;
            this.c = str.toCharArray();
        }
    }

    public static class charNode{
        char key;
        int cnt;
        public charNode(char key){
            this.key = key;
            this.cnt = 1;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int p = N-M+1;
        Node list[] = new Node[p];
        for(int i = 0;i<p;i++){
            list[i] = new Node(in.next());
        }
        char[]ans = new char[N];
        for(int i = 0;i<N;i++){
            boolean find = false;
            ArrayList<charNode>l = new ArrayList<>();
            for(int j = 0;j<p;j++) {
                charNode a = new charNode(list[j].c[i]);
                boolean exsit = false;
                for(int k = 0;k<l.size();k++){
                    if(a.key==l.get(k).key) {
                        l.get(k).cnt++;
                        exsit = true;
                        if(l.get(k).cnt>M){
                            find = true;
                            ans[i] = l.get(k).key;
                        }
                        break;
                    }
                }
                if(find) break;
                if(!exsit)l.add(a);
            }
        }
        print(ans);
    }

    public static void print(char[] ans){
        for(int i = 0;i<ans.length;i++)
            System.out.print(ans[i]);
    }
}
