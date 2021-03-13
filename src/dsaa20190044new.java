//快读模板1：更快，但没有next()用于读字符串

import java.io.*;
import java.util.*;

public class dsaa20190044new {

    static boolean [] traverse;
    static int num;
    static ArrayList<Integer>a;
    static int toFindCurrent(int current, int size, int n){
        //int index = current;
        for (int i = current; i < size; i++) {
            traverse[a.get(i)]=true;
            if(a.get(i)==num){
                current = i;
                break;
            }
        }
        for(int i = num+1;i<=n;i++){
            if(traverse[i]==false){
                num = i;
                break;
            }
        }
        return current;
    }

    public static void main(String[] args) throws IOException {
        Reader in=new Reader();
        PrintWriter out=new PrintWriter(System.out);

        {

            int T = in.nextInt();
            for(int r = 0;r<T;r++){
                int n = in.nextInt();
                num = 1;
                traverse = new boolean[300100];
                a = new ArrayList<>();
                for(int i = 0;i<n;i++){
                    a.add(in.nextInt());
                }
                int current = 0;
                int top = -1;
                while(current!=a.size()){
                    current = toFindCurrent(current,a.size(),n);
                    if(top!=-1) {
                        while (a.get(top) < a.get(current)) {
                            System.out.print(a.get(top) + " ");
                            a.remove(top);
                            top--;
                            current--;
                            if (top == -1) break;
                        }
                    }
                    top = current-1;
                    System.out.print(a.get(current)+" ");
                    a.remove(current);
                }

                while (top != -1) {
                    System.out.print(a.get(top)+" ");
                    top--;
                }
                System.out.println();
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
