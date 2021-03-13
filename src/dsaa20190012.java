import java.util.Scanner;
public class dsaa20190012 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int day = in.nextInt();
        int fish = in.nextInt();
        long dm[] = new long[day];
        for(int i = 0;i<day;i++){dm[i] = in.nextInt();}
        long fm[] = new long[fish];
        for(int i = 0;i<fish;i++){fm[i] = in.nextInt();}
        for(int i = 0;i<day;i++){
            if(dm[i]<fm[0]){System.out.println(dm[i]);}
            else System.out.println(buyFish(0,fish-1,dm[i],fm));
                }
        }


    public static String buyFish(int left, int right, long dm, long fm[]){
        while(left<=right){
            int mid = (left + right)/2;
            if(dm == fm[mid]){
                return "Meow";
            }
            else if(dm<fm[mid]){
                right = mid - 1;
            }else {left = mid + 1;}
        }return String.valueOf(dm-fm[right]);
    }
}
/*public static String Neko(long dayMoney, long fishMoneyMin){
        if
    }*/
/*for(int j = 0;j<fish;j++){
                    if(dm[i] == dm[j]){System.out.println("Meow");break;}
                    else {int left = 1;int right = fish;

                    }
                    }*/