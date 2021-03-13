
import java.util.*;
public class q8new {
    static int sum,day,Money,income,gameNum,dayDown;
    static int [] price,cnt;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Money = in.nextInt();
        income = in.nextInt();
        gameNum = in.nextInt();
        dayDown = in.nextInt();
        price = new int[gameNum];
        cnt = new int[gameNum];
        int maxcnt = 0;
        if(dayDown!=0) {
            for (int i = 0; i < gameNum; i++) {
                price[i] = in.nextInt();
                sum += price[i];
                cnt[i] = price[i] / dayDown;
                if (price[i] % dayDown == 0) cnt[i]--;
                if (cnt[i] > maxcnt) maxcnt = cnt[i];
            }
        }else {
            for (int i = 0; i < gameNum; i++) {
                price[i] = in.nextInt();
                sum += price[i];
            }
            day = (sum-Money)/income-1;
            System.out.println(day+1+" evening");
            return;
        }
        day = halfsearching(maxcnt);
        if(day==maxcnt+1){
            int dgcnt = caculate(day);
            if(isEnoughEvening(day,dgcnt)) {
                if(isEnoughMorning(day,dgcnt)){
                    /*System.out.println(sum-dayDown*dgcnt*day);
                    System.out.println(Money+income*(day+1));
                    System.out.println(Money+income*day);*/
                    System.out.println(day+1 + " morning");
                    return;
                }else {
                    System.out.println(day+1 + " evening");
                    return;
                }
            }else {
                day = (sum-dayDown*dgcnt-Money)/income-1;
                System.out.println(day+1+" evening");
                return;
            }
        }
        else {
           int dgcnt = caculate(day);
            if(isEnoughMorning(day,dgcnt)){
                System.out.println(day+1 + " morning");
                return;
            }else {
                System.out.println(day+1 + " evening");
                return;
            }
        }
    }

    public static int halfsearching(int maxcnt){
        int mid = 0;
        int left = 0;
        int right = maxcnt;
        int dgcnt;
        while(left<=right) {
            mid = (left+right)/2;
            dgcnt = caculate(mid);
            if (isEnoughEvening(mid, dgcnt)) {
                right = mid-1;
            } else left = mid+1;
        }
        return left;
    }

    public static boolean isEnoughEvening(int day, int dgcnt){
        if(Money+income*(day+1)>=sum-dayDown*dgcnt) return true;
        return false;
    }//evening

    public static boolean isEnoughMorning(int day, int dgcnt){
        if(Money+income*day>=sum-dayDown*dgcnt) return true;
        return false;
    }//morning

    public static int caculate(int day){
        int dgcnt = 0;
        for(int i = 0;i<cnt.length;i++){
            if(cnt[i]<day+1) dgcnt+=cnt[i];
            else dgcnt+=day;
        }
        return dgcnt;
    }
}



