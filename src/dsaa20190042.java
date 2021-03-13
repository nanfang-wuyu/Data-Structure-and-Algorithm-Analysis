import java.util.*;

public class dsaa20190042 {

    public static void main(String args[]){

        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int r = 0;r<T;r++){
            int n = in.nextInt();
            if(n%2==1){
                String p = in.next();
                System.out.println("NO");
                continue;
            }
            int top = -1;
            char m[] = new char[n];
            String p = in.next();
            boolean print = false;
            for(int i = 0;i<n;i++){

                if(p.charAt(i)=='('||p.charAt(i)=='['||p.charAt(i)=='{'){
                    top++;
                    //System.out.println(top);
                    m[top] = p.charAt(i);
                }
                else if(top!=-1){
                    if((p.charAt(i)==')'&&m[top]=='(')||(p.charAt(i)==']'&&m[top]=='[')||(p.charAt(i)=='}'&&m[top]=='{')){
                        top--;
                    }else {
                        System.out.println("NO");
                        print = true;
                        break;
                    }
                }
                else {
                    System.out.println("NO");
                    print = true;
                    break;
                }
            }if(!print){
            if(top==-1){System.out.println("YES");}
            else System.out.println("NO");
            }
        }
    }
}
