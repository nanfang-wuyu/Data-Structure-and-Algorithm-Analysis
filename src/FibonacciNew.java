import java.util.*;

public class FibonacciNew {

    static long [] ans = new long[1000005];
    static long N;
    static long K;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        for(int r = 0;r<100;r++) {
            N = in.nextLong();
            K = in.nextInt();
            ans[1] = 1%N;
            ans[2] = 1%N;
            for (int i = 3; i < 2*K+1; i++) {
                ans[i] = (ans[i-2]+ans[i-1])%N;
            }
            for (int i = 1; i < 2*K+1; i++)
                System.out.print(ans[i]+1 + " ");
            /*for (int i = 3; i < Fib.length; i++) {
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
            for (int i = 1; i < K; i++) System.out.print(Fib[i] % N + " ");*/
        }
    }

}
