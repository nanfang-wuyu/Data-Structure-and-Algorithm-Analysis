import java.lang.reflect.Array;
import java.util.*;

public class dsaa20190046 {
    static class Node{

        int index;
        int number;
        int x;
        int y;
        boolean column;
        boolean row;

        public Node(int index, int number, int x, int y){
            this.index = index;
            this.number = number;
            this.x = x;
            this.y = y;
            this.column = false;
            this.row = false;
        }

    }
    static int[] b;
    static int[] c;
    static Node [] list;
    static Node [] site;
    static Scanner in = new Scanner(System.in);
    static int N;
    static int M;

    public static void main(String[] args) {


        int T = in.nextInt();
        for(int r = 0;r<T;r++){

            N = in.nextInt();
            M = in.nextInt();
            list = new Node[N*N];
            traverse();
            site = Arrays.copyOf(list,list.length);
            quickSort(list,0,list.length-1);

            /*for(int i = 0;i<list.length;i++){
                System.out.print(list[i].number);
            }
            System.out.println();
            for(int i = 0;i<site.length;i++){
                System.out.print(site[i].number);
            }*/

        }


    }

    static void traverse(){
        int i = 0;
        for(int y = 0;y<N;y++){
            for(int x = 0;x<N;x++) {
                list[i]= new Node(i,in.nextInt(),x,y);
                i++;
            }
        }
    }

    public static void quickSort(Node[]arr,int l,int r){

        if(l>=r){
            return;
        }
        else{Random ran = new Random();
            int i = ran.nextInt(r-l+1)+l;//0~bound-1
            Node temp = arr[l];
            arr[l] = arr[i];
            arr[i] = temp;
            int v = arr[l].number;
            int lt = l;
            int gt = r+1;
            i = l + 1;

            while (i<gt){
                if(arr[i].number<v){
                    temp = arr[lt+1];
                    arr[lt+1] = arr[i];
                    arr[i] = temp;
                    lt++;
                    i++;
                }else if(arr[i].number>v){
                    temp = arr[gt-1];
                    arr[gt-1] = arr[i];
                    arr[i] = temp;
                    gt--;
                }else {i++;}
            }
            temp = arr[l];
            arr[l] = arr[lt];
            arr[lt] = temp;
            lt--;
            quickSort(arr,l,lt);
            quickSort(arr,gt,r);
            //System.out.println(arr[k]);
        }
    }

    static void findMatrixFromColumn(){
        System.out.println();
        for(int i = list.length-1;i>-1;i--){
            columnThis(i);
        }
    }

    static void columnThis(int i){
        int x = list[i].x;
        int length = elementDown(i)-elementUp(i)+1;
        columnRight(i,length);
        columnLeft(i,length);
    }

    static void columnRight(int i, int length){
        //int index = list[i].index;
        //int Y = site[index].y;
        int x = list[i].x;
        for(int m = x+1;m<N;m++){
            int newLength = elementDown(i)-elementUp(i)+1;
            if(newLength<length){}

        }
    }
    static void columnLeft(int i, int length){}

    static int elementUp(int i){
        int y = list[i].y;
        for(int n = y;n>-1;n--){
            int index = list[i].index;
            int newIndex = index-(y-n)*N;
            site[newIndex].column = true;
            if(site[index].number-site[newIndex].number>M){
                site[newIndex].column = false;
                return n;
            }
        }
        return 0;
    }
    static int elementDown(int i){
        int y = list[i].y;
        for(int n = y;n<N;n++){
            int index = list[i].index;
            int newIndex = index-(y-n)*N;//相同
            site[newIndex].column = true;
            if(site[index].number-site[newIndex].number>M){
                site[newIndex].column = false;
                return n;
            }
        }
        return N-1;
    }

    static void findMatrixFromRow(){}
    static void rowUp(){}
    static void rowDown(){}
    static void elementRight(){}
    static void elementLeft(){}
}
