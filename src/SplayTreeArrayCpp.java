import java.util.*;

public class SplayTreeArrayCpp {
    static public class treeNode{
        long key;
        long count;//重复个数 G题用不到
        long size;//节点数==区间
        long tag;
        treeNode leftChild;
        treeNode rightChild;
        treeNode parent;
        public treeNode(long key){
            this.key = key;
        }
    }
    static treeNode root;
    //基本操作

    static long N, inf, n, m, sign;

    public int LorR(treeNode u){
        if(u.parent==null)return 2;
        if(u.parent.rightChild==null)return 0;
        if(u.parent.rightChild==u)return 1;
        else return 0;
    }

    //splay 自下而上
    public treeNode splay(treeNode u, long key){
        if(u == null)return null;
        treeNode v = find(u, key);
        while(true){
            if(v.parent!=null)pushdown(v.parent.parent);
            pushdown(v.parent);
            pushdown(v);
            if(v.parent==null)break;
            else if(v.parent==u){
                if(LorR(v)==0){
                    v = zig(u);
                }else if(LorR(v)==1){
                    v = zag(u);
                }
            }
            else {
                if(LorR(v)==0){
                    if(LorR(v.parent)==0){
                        v = zig_zig(v.parent.parent);
                    }else {
                        v = zig_zag(v.parent.parent);
                    }
                }
                else {
                    if(LorR(v.parent)==1){
                        v = zag_zag(v.parent.parent);
                    }else {
                        v = zag_zig(v.parent.parent);
                    }
                }
            }
        }
        return v;
    }

    public treeNode find(treeNode u, long x) {
        int i = 0;
        while(true) {
            i++;
            u = pushdown(u);
            if(x <= size(u.leftChild)) {
                u = u.leftChild;
            } else {
                x = x - (size(u.leftChild) + 1);
                if(x==0) {
                    return u;
                }
                u = u.rightChild;
            }
        }
    }

    public long size(treeNode u){
        if(u==null)return 0;
        return u.size;
    }

    public treeNode pushup(treeNode u){
        if(u==null)return null;
        u.size = size(u.leftChild)+size(u.rightChild)+1;
        return u;
    }

    public treeNode pushdown(treeNode u){
        if(u!=null&&u.tag!=0){
            if(u.leftChild!=null)u.leftChild.tag^=1;
            if(u.rightChild!=null)u.rightChild.tag^=1;
            treeNode temp = u.leftChild;
            u.leftChild = u.rightChild;
            u.rightChild = temp;
            u.tag = 0;
        }
        return u;
    }

    public treeNode zig(treeNode u){
        treeNode v = u.leftChild;
        u.leftChild = v.rightChild;
        v.rightChild = u;
        if(u.parent!=null){
            v.parent = u.parent;
        }else v.parent = null;
        u.parent = v;
        if(u.leftChild!=null)u.leftChild.parent = u;
        u = pushup(u);
        v = pushup(v);
        return v;
    }

    public treeNode zag(treeNode u){
        treeNode v = u.rightChild;
        u.rightChild = v.leftChild;
        v.leftChild = u;
        if(u.parent!=null){
            v.parent = u.parent;
        }else v.parent = null;
        u.parent = v;
        if(u.rightChild!=null)u.rightChild.parent = u;
        u = pushup(u);
        v = pushup(v);
        return v;
    }

    public treeNode zag_zig(treeNode u){
        u.leftChild = zag(u.leftChild);
        u = zig(u);
        return u;
    }

    public treeNode zig_zag(treeNode u){
        u.rightChild = zig(u.rightChild);
        u = zag(u);
        return u;
    }

    public treeNode zig_zig(treeNode u){
        u = zig(u);
        u = zig(u);
        return u;
    }

    public treeNode zag_zag(treeNode u){
        u = zag(u);
        u = zag(u);
        return u;
    }

    public treeNode reverse(long x, long y, treeNode u){
        long L;
        long R;
        treeNode l;
        treeNode r;
        if(x!=1&&y==n){
            L = x-1;
            R = n;
            l = splay(u, L);
            l.rightChild.tag ^= 1;
            return l;
        }
        else if(x==1&&y!=n){
            L = 1;
            R = y+1;
            r = splay(u, R);
            r.leftChild.tag ^= 1;
            return r;
        }
        else if(x==1&&y==n){
            u.tag ^= 1;
            return u;
        }
        else {
            L = x-1;
            R = y+1;
            l = splay(u, L);
            r = splay(l.rightChild, R);
            l.rightChild = r;
            r.leftChild.tag ^= 1;
            return l;
        }
    }

    public treeNode bulid(long l, long r){
        if(l>r)return null;
        long mid = (l+r)/2;
        treeNode u = new treeNode(mid);
        u.leftChild = bulid(l,mid-1);
        u.rightChild = bulid(mid+1,r);
        if(u.leftChild!=null)u.leftChild.parent = u;
        if(u.rightChild!=null)u.rightChild.parent = u;
        u = pushup(u);
        return u;
    }//线段树建树

    public void printOut(treeNode u){
        pushdown(u);
        if(u.leftChild!=null){
            printOut(u.leftChild);
        }
        System.out.print(u.key+" ");
        if(u.rightChild!=null){
            printOut(u.rightChild);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextLong();
        m = in.nextLong();
        SplayTreeArrayCpp a = new SplayTreeArrayCpp();
        treeNode u = a.bulid(1,n);
        for(long i = 0;i<m;i++){
            u = a.reverse(in.nextLong(),in.nextLong(),u);
        }
        a.printOut(u);
    }
}

