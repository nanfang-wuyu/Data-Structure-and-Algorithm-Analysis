public class dsaahash {


    static long b = 100000007;


    public static void main(String[] args) {



    }


    public static void hash(String C, String T){
        char [] c = C.toCharArray();
        char [] t = T.toCharArray();
        int m = C.length();//prefix length
        long Chash = 0;
        long Thash = 0;
        long q = (long) Math.pow(b,m);//or use for()
        for(int i = 0;i<m;i++) Chash = Chash * b + c[i];
        for(int i = 0;i<m;i++) Thash = Thash * b + t[i];
        for(int i = 0;i<m;i++){
            if(Chash == Thash)return;
            else Thash = Thash*b-c[i]*q+c[m+i];
        }


    }

}
