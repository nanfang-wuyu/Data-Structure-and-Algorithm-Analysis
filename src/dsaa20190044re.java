import java.util.*;

public class dsaa20190044re {
    static boolean [] traverse;
    static int num;
    static ArrayList<Integer>a;
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int r = 0;r<T;r++){
            int n = in.nextInt();
            num = 1;
            traverse = new boolean[300100];
            a = new ArrayList<>();
            for(int i = 0;i<n;i++){
                a.add(in.nextInt());
            }
            int current = 0;
            int top = -1;
            while(current!=a.size()){
                current = toFindCurrent(current,a.size(),n);
                if(top!=-1) {
                    while (a.get(top) < a.get(current)) {
                        System.out.print(a.get(top) + " ");
                        a.remove(top);
                        top--;
                        current--;
                        if (top == -1) break;
                    }
                }
                top = current-1;
                System.out.print(a.get(current)+" ");
                a.remove(current);
            }

                while (top != -1) {
                    System.out.print(a.get(top)+" ");
                    top--;
                }
            System.out.println();
        }
    }
    static int toFindCurrent(int current, int size, int n){
        //int index = current;
        for (int i = current; i < size; i++) {
            traverse[a.get(i)]=true;
            if(a.get(i)==num){
                current = i;
                break;
            }
        }
        for(int i = num+1;i<=n;i++){
            if(traverse[i]==false){
                num = i;
                break;
            }
        }
        return current;
    }
}