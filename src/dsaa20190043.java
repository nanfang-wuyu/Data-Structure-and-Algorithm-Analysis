import java.util.*;

public class dsaa20190043 {

    int size;
    int front;
    int rear;
    long[] S;

    public static void main(String args[]){

        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        long S[] = new long[2000100];
        dsaa20190043 q = new dsaa20190043(S);
        long max = 0;
        long k = 0;
        for(int i = 0;i<m;i++){
            long p = in.nextLong();
            if(p==-1)break;
            q.enQueue(p);
            if(p>max)max = p;
        }
        k^=max;
        for(int i = m;;i++) {
            long p = in.nextLong();
            if(p==-1)break;
            if(q.ifFindMax(max)){
                max = q.findMax();
                System.out.println(max+"max");
            }
            q.deQueue();
            q.enQueue(p);
            if(p>max)max = p;
            k^=max;

        }
        System.out.println(k);
    }


        public dsaa20190043(long[]S){
            this.S = S;
            front = 0;
            rear = 0;
        }

        public void enQueue(long item){
            if(rear<S.length){
                S[rear] = item;
                rear++;
            }
        }

        public void deQueue(){
            if(front<rear)front++;
        }

        long front(){
            return S[front];
        }

        boolean ifFindMax(long max){
            //System.out.println("S[rear]"+S[rear]);
            if(front()==max){
                return true;
            }return false;
        }

        long findMax(){

            long max = -1;
            for(int i = front+1;i<rear;i++){
                System.out.println(S[i]);
                if(S[i]>max)max = S[i];
            }return max;
        }

}
