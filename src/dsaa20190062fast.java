//快读模板1：更快，但没有next()用于读字符串

import java.io.*;
import java.util.*;

public class dsaa20190062fast {

    static public class edge{
        int x;
        int y;

        public edge(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static public class treeNode{
        int depth;
        ArrayList<Integer>children = new ArrayList<>();
        public treeNode(int depth){
            this.depth = depth;
        }
    }
    static ArrayList<edge>Edge;
    static treeNode[]list;
    public  static void findTree(int root){
        if(Edge.size()==0)return;
        for(int i = 0;i<Edge.size();i++){
            if(Edge.get(i).x==root){
                list[Edge.get(i).y] = new treeNode(list[root].depth+1);
                list[root].children.add(Edge.get(i).y);
                Edge.remove(i);i--;
            }
            else if(Edge.get(i).y==root){
                list[Edge.get(i).x] = new treeNode(list[root].depth+1);
                list[root].children.add(Edge.get(i).x);
                Edge.remove(i);i--;
            }
        }
        for(int i = 0;i<list[root].children.size();i++) findTree(list[root].children.get(i));
    }

    public static void main(String[] args) throws IOException {
        Reader in=new Reader();
        PrintWriter out=new PrintWriter(System.out);

         {
            int T = in.nextInt();
            for(int r = 0;r<T;r++){
                int N = in.nextInt();
                Edge = new ArrayList<>();
                list = new treeNode[N+1];
                list[1] = new treeNode(0);
                for(int i = 0;i<N-1;i++){
                    Edge.add(new edge(in.nextInt(),in.nextInt()));
                }
                findTree(1);
                for(int i = 1;i<N+1;i++){
                    out.print(list[i].depth+" ");
                }
            }
        }

        out.close();
    }


    static class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.')
            {
                while ((c = read()) >= '0' && c <= '9')
                {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }

}
