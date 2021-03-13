import java.util.*;
public class testnew2 {

    static public class treeNode{
        int key;
        long size;
        treeNode leftChild;
        treeNode rightChild;
        treeNode parent;
        public treeNode(int key){this.key = key;}
    }
    public static class Path {
        int pre;
        int target;
        int tth;
        long weight;
        long lastweight;
        Path partEdge;

        public Path(int pre, int target, long weight, long lastweight, Path partEdge) {
            this.pre = pre;
            this.target = target;
            this.weight = weight;
            this.lastweight = lastweight;
            this.partEdge = partEdge;
        }
    }
    static ArrayList<treeNode> list;
    static long sum;
    public static void main(String[] args) {
        ArrayList<Integer> l = new ArrayList();
        l.add(-1);
        l.add(2);
        l.add(3);
        l.add(1);
        l.add(10);
        l.add(7);
        l.add(3);
        for(int i:l) System.out.println(i);
        quickSort(l,1,l.size()-1);
        for(int i:l) System.out.println(i);
    }

    public treeNode pushdown(treeNode u){
            treeNode temp = u.leftChild;
            u.leftChild = u.rightChild;
            u.rightChild = temp;
        return u;
    }

    public static void quickSort(ArrayList<Integer>sort,int l,int r){

        if(l>=r){
            return;
        }
        else{
            Random ran = new Random();
            int i = ran.nextInt(r-l+1)+l;
            int temp = sort.get(l);
            sort.set(l,sort.get(i));
            sort.set(i,temp);
            int v = sort.get(l);
            int lt = l;
            int gt = r+1;
            i = l + 1;

            while (i<gt){
                if(sort.get(i)<v){
                    temp = sort.get(lt+1);
                    sort.set(lt+1,sort.get(i));
                    sort.set(i,temp);
                    lt++;
                    i++;
                }else if(sort.get(i)>v){
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