import java.util.*;

public class Fibonacci {

    static long [] Fib = new long[1000005];
    static long [] ans = new long[1000005];
    static long N;
    static long K;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        for(int r = 0;r<100;r++) {
            N = in.nextLong();
            K = in.nextInt();
            int circle = 0;
            int index = 0;
            Fib[1] = 1L;
            Fib[2] = 1L;

            for (int i = 3; i < Fib.length; i++) {
                Fib[i] = Fib[i - 1] + Fib[i - 2];
            }
            for (int i = 1; i < K; i++) {
                ans[i] = Fib[i] % N;
                if (ans[i] == 1 && ans[i - 1] == 1 && i != 2) {
                    circle = i - 2;
                    index = i + 1;
                    break;
                }
            }
            for (int i = index; i < K; i++) {
                ans[i] = ans[i - circle];
            }
            for (int i = 1; i < K; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
            for (int i = 1; i < K; i++) System.out.print(Fib[i] % N + " ");
        }
    }

    public static long caculateF(int i, long N){
        if(i<3)return Fib[i]%N;
        long q = caculateF(i-1,N)%N+caculateF(i-2,N)%N;
        return q%N;
    }
}
