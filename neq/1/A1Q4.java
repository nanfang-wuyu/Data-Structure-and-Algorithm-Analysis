public class A1Q4 {
    public static void main(String[] args){
        int n = Integer.parseInt (args[0]);
        int sum;
        int m;

        m=0;
        sum=0;

        for(m=0; m<=n;m++ ){
            sum+=m;
        }
            System.out.printf("%d",sum);



    }
}
