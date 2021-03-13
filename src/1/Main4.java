public class Main4 {
    public static void main(String[] args){
        int x=1;
        int y=1;
        while (x<=9){
            x=1;
            while(x<=y){
                int answer;
                answer=x*y;


         System.out.printf("%d * %d = %-5d",x,y,x*y);
        x=x+1;
            }
            System.out.println();
            y=y+1;

        }
    }
}