import java.util.*;

public class dsaa20190041 {

    public static void main(String args[]){

        Scanner in = new Scanner(System.in);
            int n = in.nextInt();

            int front = 0;
            int rear = 0;
            int S[] = new int[n];
            for(int i = 0;i<n;i++) {
                String m = in.next();
                //System.out.println(m);
                if (m.equals("E")) {
                    int q = in.nextInt();
                    S[rear] = q;
                    rear++;
                } else if (m.equals("D")) {
                    front++;
                } else if (m.equals("A")) {
                    System.out.println(S[front]);
                }
            }
            for(int i = front;i<rear;i++){
                if(i!=rear-1)System.out.print(S[i]+" ");
                else System.out.print(S[i]);
            }
    }
}
