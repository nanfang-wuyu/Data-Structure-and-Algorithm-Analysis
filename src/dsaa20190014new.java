import java.util.Scanner;
import java.util.ArrayList;
public class dsaa20190014new {


    //ArrayList<Long> y = new ArrayList<Long>();

    public static void main(String[] args) {
        ArrayList<Long> x = new ArrayList<Long>();
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        long tar = in.nextLong();
        ArrayList<Long> positive = new ArrayList<Long>();
        ArrayList<Long> zero = new ArrayList<Long>();
        ArrayList<Long> negative = new ArrayList<Long>();
        long a[] = new long[length];
        int start = 0;
        for (int i = 0; i < length; i++) {
            a[i] = in.nextLong();
        }
        for (int i = 0; i < length; i++) {
            if (a[i] < 0) {
                negative.add(a[i]);
            } else {
                start = i;
                break;
            }
        }
        for (int i = start; i < length; i++) {
            if (a[i] == 0) {
                zero.add(a[i]);
            } else {
                start = i;
                break;
            }
        }
        for (int i = start; i < length; i++) {
            positive.add(a[i]);
        }





        if (tar > 0) {
            for (int i = 0; i < negative.size(); i++) {
                int left = i + 1;
                int right = negative.size() - 1;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (tar == negative.get(i) * negative.get(mid)) {
                        //System.out.println(" "+negative.get(i));
                        x.add(negative.get(i));
                        break;
                    } else if (negative.get(i) * negative.get(mid) < tar) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
            }
            for (int i = 0; i < positive.size(); i++) {
                int left = i + 1;
                int right = positive.size() - 1;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (tar == positive.get(i) * positive.get(mid)) {
                        x.add(positive.get(i));
                        break;
                    } else if (positive.get(i) * positive.get(mid) > tar) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
            }
        }

        if (tar < 0) {
            for (int i = 0; i < negative.size(); i++) {
                int left = 0;
                int right = positive.size() - 1;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (tar == negative.get(i) * positive.get(mid)) {
                        x.add(negative.get(i));
                        break;
                    } else if (negative.get(i) * positive.get(mid) < tar) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
            }
        }

        if (tar == 0) {
            if(zero.size()>0){
                for (int i = 0; i <negative.size();i++){
                    x.add(negative.get(i));
                }
                for (int i = 0; i <positive.size();i++){
                    x.add(positive.get(i));
                }
                if(zero.size() != 1){x.add(0L);}
            }else {System.out.println(0);return;}
        }

        /*for(int j = 0; j < x.size();j++){
            for(int k = j+1;k<x.size();k++){

                    if(x.get(k)*x.get(j) == tar){
                        x.remove(k);
                    }

            }
        }*/

        //long c = 0;
        System.out.println(x.stream().distinct().count());
        //x.stream().distinct().forEach(System.out::println);
        //System.out.println(x.size());

    }
}
  //clean out the same words to one






        /*if (tar > 0) {

            for (int i = 0; i < length; i++) {


                if (a[i] < 0) {
                    x.add(proNr(0, length - 1, i, tar, a[i], a));
                } else if (a[i] == 0) {

                } else *//*if(a[i]>0)*//* {
                    x.add(proNr(i, length - 1, i, tar, a[i], a));
                }
            }
        } else if (tar == 0) {
        } else {
            for (int i = 0; i < length; i++) {
                if (a[i] < 0) {
                    x.add(proNl(i, length - 1, i, tar, a[i], a));
                }
            }
        }*/

    /*public static long proNl(int left, int right,int i, long tar, long ai, long a[]){
        while(left<=right){
            int mid = (left + right)/2;
            if(tar == ai * a[mid]&&i<mid){
                return ai;
            }
            else if(){
                right = mid - 1;
            }else {left = mid + 1;}
        }return String.valueOf(dm-fm[right]);
    }

    public static long proNr(int left, int right,int i, long tar, long ai, long a[]){
        while(left<=right){
            int mid = (left + right)/2;
            if(tar == ai * a[mid]&&i<mid){
                return ai;
            }
            else if(dm<fm[mid]){
                right = mid - 1;
            }else {left = mid + 1;}
        }return String.valueOf(dm-fm[right]);
    }
}*/
/*public static String Neko(long dayMoney, long fishMoneyMin){
        if
    }*/
/*for(int j = 0;j<fish;j++){
                    if(dm[i] == dm[j]){System.out.println("Meow");break;}
                    else {int left = 1;int right = fish;

                    }
                    }*/