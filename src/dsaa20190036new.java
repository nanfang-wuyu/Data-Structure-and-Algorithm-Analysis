import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class dsaa20190036new {

    static class Node{
        int num;
        int index;
        Node next;
        Node prev;

        public Node(){
            num = 0;
            index = 0;
        }
        public Node(int num, int index){
            this.num = num;
            this.index = index;
        }
    }

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Node>list = new ArrayList<>();
        for(int i = 0;i<n;i++)list.add(new Node(in.nextInt(),i));
        ArrayList<Node>sort = list;
        quickSort(sort,0,n-1);
        for(int i = 0;i<n;i++)System.out.print(sort.get(i).num);
    }

    public static void quickSort(ArrayList<Node>sort,int l,int r){

        if(l>=r){
            return;
        }
        else{
            Random ran = new Random();
            int i = ran.nextInt(r-l+1)+l;
            Node temp = sort.get(l);
            sort.set(l,sort.get(i));
            sort.set(i,temp);
            Node v = sort.get(l);
            int lt = l;
            int gt = r+1;
            i = l + 1;

            while (i<gt){
                if(sort.get(i).num<v.num){
                    temp = sort.get(lt+1);
                    sort.set(lt+1,sort.get(i));
                    sort.set(i,temp);
                    lt++;
                    i++;
                }else if(sort.get(i).num>v.num){
                    temp = sort.get(gt-1);
                    sort.set(gt-1,sort.get(i));
                    sort.set(i,temp);
                    gt--;
                }else {i++;}
            }
            temp = sort.get(l);
            sort.set(l,sort.get(lt));
            sort.set(lt,temp);
            lt--;
            quickSort(sort,l,lt);
            quickSort(sort,gt,r);
            //System.out.println(arr[k]);
        }
    }
}