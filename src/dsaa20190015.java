import java.util.Scanner;
public class dsaa20190015 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long x1 = in.nextLong();
        long y1 = in.nextLong();
        long x2 = in.nextLong();
        long y2 = in.nextLong();
        int N = in.nextInt();
        String S = in.next();
        long instance = Math.abs(y1-y2)+Math.abs(x1-x2);
        long x0 = x2;
        long y0 = y2;
        long xx = 0;
        long yy = 0;
        long decrease = 0;
        long turn = 0;
        //System.out.println(/*"D".equals*/(S.charAt(0))=='D');
        int j = 1;
        for (int i = 0; i < N; i++) {
            if ((S.charAt(i)) == 'U') {
                y2++;
            } else if ((S.charAt(i)) == 'D') {
                y2--;
            } else if ((S.charAt(i)) == 'L') {
                x2--;
            } else if ((S.charAt(i)) == 'R') {
                x2++;
            }//System.out.println(i+1+" "+Math.abs(y1-y2)+Math.abs(x1-x2));
            if (i + 1 + (j - 1) * N >= Math.abs(y1 - y2) + Math.abs(x1 - x2)) {
                System.out.println(i + 1 + (j - 1) * N);
                return;
            }

        }

        if(Math.abs(y1-y2)+Math.abs(x1-x2)>=N + instance){
            //System.out.println(j+" "+y1+" "+y2+" "+x1+" "+x2+" "+Math.abs(y1-y2)+Math.abs(x1-x2)+" "+N+" "+instance);
            System.out.println(-1);
            return;

        }
        xx = x2 - x0;
        yy = y2 - y0;

        decrease = (Math.abs(y1 - y0) + Math.abs(x1 - x0))-(Math.abs(y1 - y2) + Math.abs(x1 - x2))+N;
        //System.out.println(xx);

        turn = instance/decrease;
        //System.out.println(yy);

        x2 = x2 + xx * (turn-1);
        y2 = y2 + yy * (turn-1);
        //System.out.println(x2+" "+y2);
        for (j = (int) turn+1;j>0;j++){
            //System.out.println(j);
            for (int i = 0; i < N; i++) {
                if ((S.charAt(i)) == 'U') {
                    y2++;
                } else if ((S.charAt(i)) == 'D') {
                    y2--;
                } else if ((S.charAt(i)) == 'L') {
                    x2--;
                } else if ((S.charAt(i)) == 'R') {
                    x2++;
                }//System.out.println(i+1+" "+Math.abs(y1-y2)+Math.abs(x1-x2));
                if (i + 1 + (j - 1) * N >= Math.abs(y1 - y2) + Math.abs(x1 - x2)) {
                    System.out.println(i + 1 + (j - 1) * N);
                    return;
                }
            }

            if(Math.abs(y1-y2)+Math.abs(x1-x2)>=N + instance){
                //System.out.println(j+" "+y1+" "+y2+" "+x1+" "+x2+" "+Math.abs(y1-y2)+Math.abs(x1-x2)+" "+N+" "+instance);
                System.out.println(-1);
                return;

            }
        }
    }
}

