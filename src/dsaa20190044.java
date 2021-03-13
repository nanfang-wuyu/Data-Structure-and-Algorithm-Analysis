import java.util.*;

public class dsaa20190044 {

    static int top = -1;
    static int[] S = new int[300000];
    static int[] a;
    static boolean [] traverse;
    static int num;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int r = 0;r<T;r++){
            num = 1;
            traverse = new boolean[300100];
            int n = in.nextInt();
            a = new int[n];
            for(int i = 0;i<n;i++){
                a[i] = in.nextInt();
            }

            int current = 0;
            int front = 0;
            traverse[a[1]]=true;
            if(a[0]==1){
                System.out.print(1+" ");
                front = 1;
                num = 2;
            }
            while(current!=n-1) {
                current = toFindCurrent(current, n);
                if(top!=-1) {
                    while (S[top] < a[current]) {
                        System.out.print(pop() + " ");
                        if (top == -1) break;
                    }
                }
                    System.out.print(a[current]+" ");
                    for (int i = front; i < current; i++) push(a[i]);
                    front = current + 1;

            }

            if(top!=-1) {
                while (top != 0) {
                    System.out.print(pop()+" ");
                }
                System.out.print(pop()+" ");
            }
            System.out.println();
        }
    }

    static int toFindCurrent(int current, int n){
        int index = current + 1;
        for (int i = current + 1; i < n; i++) {
            traverse[a[i]]=true;
            if(a[i]==num){
                index = i;
                break;
            }
        }
        for(int i = num+1;i<=n;i++){
            if(traverse[i]==false) {
                num = i;
                break;
            }
        }
        return index;
    }

    static int pop(){
        top--;
        return S[top+1];
    }
    static void push(int p){
        top++;
        S[top] = p;
    }
}