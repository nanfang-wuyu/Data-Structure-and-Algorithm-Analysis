import java.util.Scanner;
import java.util.ArrayList;
public class dsaa20190005 {

    public static void main(String[] args) {

        long y = 1L;
        long x = 1L;
        Scanner input = new Scanner(System.in);
        int casenumber = input.nextInt();
        input.nextLine();
        String [] s = new String[casenumber];
        int a[] = new int[30];
        //long b[] = new long[Math.toIntExact(100L)];
        ArrayList<Long> num = new ArrayList<Long>();
        ArrayList<Long> xn = new ArrayList<Long>();
        ArrayList<Long> yn = new ArrayList<Long>();
        int n = 0;
        int con[] = new int[a.length];
        long z = 1L;
        for(int i = 0;i<a.length;i++){a[i]=1;}
        for(long i = 1L;i<(long) Math.pow(2,31);i++){
            //System.out.println("i"+i+" "+"a[n]"+String.valueOf(a[n])+" "+"n"+String.valueOf(n)+" "+"y"+String.valueOf(y)+" "+"x"+String.valueOf(x));
            //System.out.println("a[n]"+String.valueOf(a[n]));
            a[n]++;

            if(n>0&&a[n]==5){
                n = n+1;
                /*for(;n<32;n++){
                    if(a[n]!=4&&a[n]!=5){
                    break;}
                }*/
                for (int j = 0; j < n ; j++) {
                    a[j] = 1;
                }
                /*num.remove(i);
                i--;*/
            continue;}

            num.add(z);
            xn.add(x);
            yn.add(y);
           // System.out.println("z"+z+" "+" "+"n"+String.valueOf(n)+" "+"y"+String.valueOf(y)+" "+"x"+String.valueOf(x));
            z++;
            if(con[n] == 0){y=y+(long) Math.pow(2,n);x=x-((long) Math.pow(2,n)-1);con[n]=1;}
            else if(con[n] == 1){x=x+1L;con[n]=2;}
            else if(con[n] == 2){y=y-(long) Math.pow(2,n);x=x-((long) Math.pow(2,n)-1);con[n]=0;}
            //else if(con[n] == 3){con[n]=0;/*num.remove(i);*/}



            if(n==0&&a[n]==4){
                n = n+1;}

            else if(n>0){for (int j = 0; j < n; j++) {
                a[j] = 1;
                n = 0;
                }
            }

                /*if (a[n] == 5) {
                    n = n+1;
                    if(n>0){
                    for (int j = 0; j < n + 1; j++) {
                        a[j] = 1;
                        n = 0;
                    }
                }else {n = n+1;}
            }*/
        }


        for(int i = 0;i<casenumber;i++){
            s[i] = input.nextLine();


        if("(".equals(s[i].charAt(0))){
            long y0 = (long) s[i].charAt(1);
            long x0 = (long) s[i].charAt(3);
            for(long m = 0;m<1000000000L;m++){
                for(long p = 0;p<1000000000L;p++){

                }
            }
            //s[i] =
        }else {
            long num0 = (long) s[i].charAt(0);

            s[i] = "("+yn.get((int) (num0-1L))+","+xn.get((int) (num0-1L))+")";

        }



        }
        for(int i = 0;i<casenumber;i++){
            System.out.println(s[i]);
        }

    }







    /*boolean down = false;
    boolean right = false;
    boolean up = false;*/

    /*public static void main(String[] args) {

        long x = 1;
        long y = 1;
        Scanner input = new Scanner(System.in);
        int casenumber = input.nextInt();

        ArrayList<Long> a = new ArrayList<>();
        ArrayList<Long> yn = new ArrayList<>();
        ArrayList<Long> xn = new ArrayList<>();

        //int num = 1;
        //dsaa20190005 d5 = new dsaa20190005();

        int con[] = new int[30];
        long an = 1L;
        a.add(an);
        yn.add(y);
        xn.add(x);
        System.out.println(an);
        System.out.println("y"+y);
        System.out.println("x"+x);
        an++;
        for(int m1 = 1;m1<31;m1++){
            for(int m2 = 0;m2<4;m2++){
                for(int m3 = 0;m3<4;m3++){
                    for(int m4 = 0;m4<4;m4++){
                        for(int m5 = 0; m5<4;m5++){
                            for(int m6 = 0; m5<4;m5++){
                                for(int m7 = 0; m5<4;m5++){
                                    for(int m8 = 0; m5<4;m5++){
                                        for(int m9 = 0; m5<4;m5++){
                                            for(int m10 = 0; m5<4;m5++){
                                                for(int m11 = 0; m5<4;m5++){
                                                    for(int m12 = 0; m5<4;m5++){
                                                        for(int m13 = 0; m5<4;m5++){
                                                            for(int m14 = 0; m5<4;m5++){
                                                                for(int m15 = 0; m5<4;m5++){
                                                                    for(int m16 = 0; m5<4;m5++){
                                                                        for(int m17 = 0; m5<4;m5++){
                                                                            for(int m18 = 0; m5<4;m5++){
                                                                                for(int m19 = 0; m5<4;m5++){
                                                                                    for(int m20 = 0; m5<4;m5++){
                                                                                        for(int m21 = 0; m5<4;m5++){
                                                                                            for(int m22 = 0; m5<4;m5++){
                                                                                                for(int m23 = 0; m5<4;m5++){
                                                                                                    for(int m24 = 0; m5<4;m5++){
                                                                                                        for(int m25 = 0; m5<4;m5++){
                                                                                                            for(int m26 = 0; m5<4;m5++){
                                                                                                                for(int m27 = 0; m5<4;m5++){
                                                                                                                    for(int m28 = 0; m5<4;m5++){
                                                                                                                        for(int m29 = 0; m5<4;m5++){
                                                                                                                            for(int m30 = 0; m5<4;m5++){
                                                                                                                                if(con[30] == 0){y=y+1;con[5]=1;}
                                                                                                                                else if(con[30] == 1){x=x+1;con[30]=2;}
                                                                                                                                else if(con[30] == 2){y=y-1;con[30]=3;}
                                                                                                                                else if(con[30] == 3){con[30]=0;break;}
                                                                                                                        }if(con[29] == 0){y=y+2;x=x-1;con[29]=1;}
                                                                                                                            else if(con[29] == 1){x=x+1;con[29]=2;}
                                                                                                                            else if(con[29] == 2){y=y-2;x=x-1;con[29]=3;}
                                                                                                                            else if(con[29] == 3){con[29]=0;break;}
                                                                                                                    }if(con[28] == 0){y=y+4;x=x-3;con[3]=1;}
                                                                                                                        else if(con[3] == 1){x=x+1;con[3]=2;}
                                                                                                                        else if(con[3] == 2){y=y-4;x=x-3;con[3]=3;}
                                                                                                                        else if(con[3] == 3){con[3]=0;x=1L;y=1L;break;}
                                                                                                                }if(con[27] == 0){y=y+8;x=x-7;con[3]=1;}
                                                                                                                    else if(con[3] == 1){x=x+1;con[3]=2;}
                                                                                                                    else if(con[3] == 2){y=y-8;x=x-7;con[3]=3;}
                                                                                                                    else if(con[3] == 3){con[3]=0;x=1L;y=1L;break;}
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }

                        }

                    }

                }
            }
       } }

        *//*for(long n = 1L;n<=(long) Math.pow(2,30);n=n*2){

            y = 1;
            x = 1;
            int pow = 0;
            for(long time = 0;time<(long) Math.pow(2,pow);time++){

                for(long m = an; m<=(long) Math.pow(10,18); m++) {

                    a.add(m);
                    if(con == 0){y=y+n;con=1;}
                    else if(con == 1){x=x+n;con=2;}
                    else if(con == 2){y=y-n;con=3;}
                    else if(con == 3){con=0;break;}
                }
            }
        }


*//*

    }



    public boolean way (boolean down, boolean right, boolean up){
        if(down){return right;}
        else if(right){return up;}
        else if(up){return down;}
        return true;
    }

    *//*public int xy (boolean way, int y, int x){
        if(way == down){y++;return y,x;}
        else if(way == right){x++;return x;}
        else return y--;
    }*//*

    *//*public void xy (boolean way, int y, int x){
        if(way == down){y++;}
        else if(way == right){x++;}
        else {y--;}
    }*//*

    public dsaa20190005(){

    }
*/}