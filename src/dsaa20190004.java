import java.util.Scanner;
import java.util.ArrayList;
public class dsaa20190004 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int casenumber = input.nextInt();
        input.nextLine();
        String up[] = new String[casenumber];
        long num = 0;
        for(int i = 0;i<casenumber;i++) {
            up[i] = input.nextLine();
        }
        for(int i = 0;i<casenumber;i++) {
            //up[i] = input.nextLine();
            int strl = up[i].length();
            //System.out.println("strl"+strl);
            if (strl == 1) {
                num = 1;
                int q = 1;
                int m4 = q;
                for(int i4 = 1;i4<=10;i4++){
                    if(q<=Integer.parseInt(up[i])) {
                        num++;
                        q = m4 + 1 * i4;
                    }
                }
                System.out.println(num);
            } else if (strl == 2) {
                num = 10;
                int q = 11;
                int m4 = q;
                for(int i4 = 1;i4<=10;i4++){
                    if(q<=Integer.parseInt(up[i])) {
                        num++;
                        q = m4 + 11 * i4;
                    }
                }
                System.out.println(num);
            } else if (strl == 3) {
                num = 9+10;
                int q = 101;
                int m3 = q;
                int m4 = q;
                for(int i3 = 1;i3<=10;i3++){
                    for(int i4 = 1;i4<=10;i4++){
                        if(q<=Integer.parseInt(up[i])) {
                            num++;
                            q = m4 + 10 * i4;
                        }
                    }
                    q = m3 + 101*i3 ;
                    m4 = q;
                }
                System.out.println(num);
            }else if (strl == 4) {
                num = 90+9+10;
                int q = 1001;
                int m3 = q;
                int m4 = q;
                for(int i3 = 1;i3<=10;i3++){
                    for(int i4 = 1;i4<=10;i4++){
                        if(q<=Integer.parseInt(up[i])) {
                            num++;
                            q = m4 + 110 * i4;
                        }
                    }
                    q = m3 + 1001*i3 ;
                    m4 = q;
                }
                System.out.println(num);
            } else if (strl == 5) {
                num = 90+90+9+10;
                int q = 10001;
                int m = q;
                int n = q;
                int z = q;
                for(int i1 = 1;i1<=10;i1++){
                    for(int i2 = 1;i2<=10;i2++){
                        for(int i3 = 1;i3<=10;i3++){
                            if(q<=Integer.parseInt(up[i])) {
                                //System.out.println(q);
                                num++;
                                q = m + 100 * i3;
                            }
                        }
                        q = n + 1010*i2 ;
                        m = q;
                        //System.out.println("2"+q);
                    }
                    q = z + 10001*i1 ;
                    n = q;
                    m = q;
                    //System.out.println("1"+q);
                }System.out.println(num);


            } else if (strl == 6) {
                num = 900+90+90+9+10;
                int q = 100001;
                int m2 = q;
                int m3 = q;
                int m4 = q;

                    for(int i2 = 1;i2<=10;i2++){
                        for(int i3 = 1;i3<=10;i3++){
                            for(int i4 = 1;i4<=10;i4++){
                                if(q<=Integer.parseInt(up[i])) {
                                    //System.out.println(q);
                                    num++;
                                    q = m4 + 1100 * i4;
                                }
                            }
                            q = m3 + 10010*i3 ;
                            m4 = q;
                        }
                        q = m2 + 100001*i2 ;
                        m3 = q;
                        m4 = q;
                        //System.out.println("2"+q);
                    }

                    //System.out.println("1"+q);
                System.out.println(num);
            } else if (strl == 7) {
                num = 900+900+90+90+9+10;
                int q = 1000001;
                int m1 = q;
                int m2 = q;
                int m3 = q;
                int m4 = q;
                for(int i1 = 1;i1<=10;i1++){
                    for(int i2 = 1;i2<=10;i2++){
                        for(int i3 = 1;i3<=10;i3++){
                            for(int i4 = 1;i4<=10;i4++){
                                if(q<=Integer.parseInt(up[i])) {
                                    //System.out.println(q);
                                    num++;
                                    q = m4 + 1000 * i4;
                                }
                            }
                            q = m3 + 10100*i3 ;
                            m4 = q;
                        }
                        q = m2 + 100010*i2 ;
                        m3 = q;
                        m4 = q;
                        //System.out.println("2"+q);
                    }
                    q = m1 + 1000001*i1 ;
                    m2 = q;
                    m3 = q;
                    m4 = q;

                    //System.out.println("1"+q);
                }System.out.println(num);
            } else if (strl == 8) {
                num = 9000+900+900+90+90+9+10;
                int q = 10000001;
                int m1 = q;
                int m2 = q;
                int m3 = q;
                int m4 = q;
                int m5 = q;
                for(int i1 = 1;i1<=10;i1++){
                    for(int i2 = 1;i2<=10;i2++){
                        for(int i3 = 1;i3<=10;i3++){
                            for(int i4 = 1;i4<=10;i4++){
                                if(q<=Integer.parseInt(up[i])) {
                                    //System.out.println(q);
                                    num++;
                                    q = m4 + 11000 * i4;
                                }
                            }
                            q = m3 + 100100*i3 ;
                            m4 = q;
                        }
                        q = m2 + 1000010*i2 ;
                        m3 = q;
                        m4 = q;
                        //System.out.println("2"+q);
                    }
                    q = m1 + 10000001*i1 ;
                    m2 = q;
                    m3 = q;
                    m4 = q;

                    //System.out.println("1"+q);
                }System.out.println(num);
            } else if (strl == 9) {
                num = 9000+9000+900+900+90+90+9+10;
                int q = 100000001;
                int m1 = q;
                int m2 = q;
                int m3 = q;
                int m4 = q;
                int m5 = q;
                for(int i1 = 1;i1<=10;i1++){
                    for(int i2 = 1;i2<=10;i2++){
                        for(int i3 = 1;i3<=10;i3++){
                            for(int i4 = 1;i4<=10;i4++){
                                for(int i5 = 1;i5<=10;i5++){
                                    if(q<=Integer.parseInt(up[i])) {
                                        //System.out.println(q);
                                        num++;
                                        q = m5 + 10000 * i5;
                                    }

                                }
                                q = m4 + 101000 * i4;
                                m5 = q;
                            }
                            q = m3 + 1000100*i3 ;
                            m4 = q;
                            m5 = q;
                        }
                        q = m2 + 10000010*i2 ;
                        m3 = q;
                        m4 = q;
                        m5 = q;
                        //System.out.println("2"+q);
                    }
                    q = m1 + 100000001*i1 ;
                    m2 = q;
                    m3 = q;
                    m4 = q;
                    m5 = q;

                    //System.out.println("1"+q);
                }System.out.println(num);
            } else if (strl == 10) {
                num = 90000+9000+9000+900+900+90+90+9+10;
                long q = 1000000001l;
                long m1 = q;
                long m2 = q;
                long m3 = q;
                long m4 = q;
                long m5 = q;//System.out.println((m5+Long.valueOf(110000));
                for(int i1 = 1;i1<=10;i1++){
                    for(int i2 = 1;i2<=10;i2++){
                        for(int i3 = 1;i3<=10;i3++){
                            for(int i4 = 1;i4<=10;i4++){
                                for(int i5 = 1;i5<=10;i5++){
                                    if(q<=Long.parseLong(up[i])) {
                                        num++;
                                        q = m5 + 110000l * i5;
                                    }

                                }
                                q = m4 + 1001000l * i4;
                                m5 = q;
                            }
                            q = m3 + 10000100l*i3 ;
                            m4 = q;
                            m5 = q;
                        }
                        q = m2 + 100000010l*i2 ;
                        m3 = q;
                        m4 = q;
                        m5 = q;
                        //System.out.println("2"+q);
                    }
                    q = m1 + 1000000001l*i1 ;
                    m2 = q;
                    m3 = q;
                    m4 = q;
                    m5 = q;

                    //System.out.println("1"+q);
                }System.out.println(num);
            } else if (strl == 11) {
                num = 90000+90000+9000+9000+900+900+90+90+9+10;
                long q = 10000000001L;
                long m1 = q;
                long m2 = q;
                long m3 = q;
                long m4 = q;
                long m5 = q;
                long m6 = q;
                for(int i1 = 1;i1<=10;i1++){
                    for(int i2 = 1;i2<=10;i2++){
                        for(int i3 = 1;i3<=10;i3++){
                            for(int i4 = 1;i4<=10;i4++){
                                for(int i5 = 1;i5<=10;i5++){
                                    for(int i6 = 1;i6<=10;i6++) {
                                        if (q <= Long.parseLong(up[i])) {
                                            num++;
                                            q = m6 + 100000L * i6;
                                        }
                                    }
                                    q = m5 + 1010000L * i5;
                                    m6 = q;
                                }
                                q = m4 + 10001000L * i4;
                                m5 = q;
                                m6 = q;
                            }
                            q = m3 + 100000100L*i3 ;
                            m4 = q;
                            m5 = q;
                            m6 = q;
                        }
                        q = m2 + 1000000010L*i2 ;
                        m3 = q;
                        m4 = q;
                        m5 = q;
                        m6 = q;

                        //System.out.println("2"+q);
                    }
                    q = m1 + 10000000001L*i1 ;
                    m2 = q;
                    m3 = q;
                    m4 = q;
                    m5 = q;
                    m6 = q;

                    //System.out.println("1"+q);
                }System.out.println(num);
            } else if (strl == 12) {
                num = 900000+90000+90000+9000+9000+900+900+90+90+9+10;
                System.out.println(num);
            } /*else if (strl == 13) {
                num = 900000+900000+90000+90000+9000+9000+900+900+90+90+9+10;
            }*/


        }
    }
}

  /*for(int i = 0;i<casenumber;i++){
        int d = 0;
        ArrayList<String> b = new ArrayList<String>();

        *//*String b[] = new String[a[i]+1];*//*

        for(int j = 0;j<=a[i];j++){
        b.add(String.valueOf(j));
        //System.out.print(b[j]);
        int c[] = new int[b.get(j).length()];
        for(int k = 0;k<b.get(j).length();k++){
        c[k] =Integer.parseInt(String.valueOf(b.get(j)).substring(k,k+1));
        }
        boolean hui = true;
        for(int k = 0;k<c.length;k++){
        if(c[k]!=c[c.length-k-1]){
        hui = false;
        }
        }
        if(hui){d++;}

        }
        System.out.println(d);



        }*/
