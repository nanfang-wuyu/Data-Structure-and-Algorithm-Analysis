package dsaa2019compitition;
import java.util.*;
public class q8 {
    static int sum,day,stay;
    static ArrayList<Integer>price;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Money = in.nextInt();
        int income = in.nextInt();
        int gameNum = in.nextInt();
        int dayDown = in.nextInt();
        stay = 0;
        day = 1;
        sum = stay;
        //int [] price = new int[gameNum];
        price = new ArrayList<>();
        for(int i = 0;i<gameNum;i++) {
            int p = in.nextInt();
            price.add(p);
            sum+=p;
        }

        while (true) {
            if (day != 1) {
                sum = stay;
                if(price.size()==0) {
                    System.out.println(day + " evening");
                    return;
                }
                updatePrice(dayDown);
            }//morning p1
            if (Money >= sum) {
                System.out.println(day + " morning");
                return;
            }//morning p2
            Money += income;
            if (Money >= sum) {
                System.out.println(day + " evening");
                return;
            }//evening
            day++;
        }
    }

    public static void updatePrice(int dayDown){
        for (int i = 0; i < price.size(); i++) {
            if (price.get(i) <= dayDown) {
                stay += price.get(i);
                sum += price.remove(i);
                i--;
            } else {
                int p = price.get(i);
                price.set(i, p - dayDown);
                sum += price.get(i);
            }
        }
    }
}



