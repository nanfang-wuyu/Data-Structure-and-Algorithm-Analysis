package DotsBoxes1_0;

import demo1.Dot;
import demo1.Edge;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class PVE440 {
    //    private List<Edge> edges = new ArrayList<>();
//    private List<Dot> dots = new ArrayList<>();
    static int time = 0;
    private ArrayList<Edge> edges = new ArrayList<>();//.edges
    private ArrayList<Dot> dots = new ArrayList<>();//.dots
    private Color currentColor = Color.RED;//.1st.red & 2nd.blue
    int[] edgeList = new int[24];
    int redScore = 0;
    int blueScore = 0;
    boolean start = true;
    boolean gamefinish = false;


    public PVE440(int canvasWidth, int canvasHeight) { //.canvas:a piece of cloth
        StdDraw.setCanvasSize(canvasWidth, canvasHeight);
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 1000);
        StdDraw.setYscale(0, 900);//.to achieve symmetric DotsBoxes: setXscale & setYscale(0,4i)
       /* System.out.printf("Please choose size of board: 3 * 3 squares , 4 * 4 squares , 5 * 5 squares\n");
        System.out.printf("Size of board: ");
        Scanner input = new Scanner(System.in);*/
        initialize();
    }


    public void initialize() {
        edges.add(new Edge(75, 70, 150, 10));//h11   0
        edges.add(new Edge(75, 220, 150, 10));//h12  1
        edges.add(new Edge(75, 370, 150, 10));//h13     2
        edges.add(new Edge(75, 520, 150, 10));//h14     3
        edges.add(new Edge(225, 70, 150, 10));//h21  4
        edges.add(new Edge(225, 220, 150, 10));//h22 5
        edges.add(new Edge(225, 370, 150, 10));//h23    6
        edges.add(new Edge(225, 520, 150, 10));//h24    7
        edges.add(new Edge(375, 70, 150, 10));//h31  8
        edges.add(new Edge(375, 220, 150, 10));//h32 9
        edges.add(new Edge(375, 370, 150, 10));//h33    10
        edges.add(new Edge(375, 520, 150, 10));//h34    11
        edges.add(new Edge(70, 75, 10, 150));//v11   12
        edges.add(new Edge(70, 225, 10, 150));//v12  13
        edges.add(new Edge(70, 375, 10, 150));//v13  14
        edges.add(new Edge(220, 75, 10, 150));//v21  15
        edges.add(new Edge(220, 225, 10, 150));//v22    16
        edges.add(new Edge(220, 375, 10, 150));//v23    17
        edges.add(new Edge(370, 75, 10, 150));//v31  18
        edges.add(new Edge(370, 225, 10, 150));//v32    19
        edges.add(new Edge(370, 375, 10, 150));//v33    20
        edges.add(new Edge(520, 75, 10, 150));//v41  21
        edges.add(new Edge(520, 225, 10, 150));//v42    22
        edges.add(new Edge(520, 375, 10, 150));//v43    23
        System.out.println("Choose the dotColor,please input red, green, blue:");
        Scanner in = new Scanner(System.in);
        int red = in.nextInt();
        int green = in.nextInt();
        int blue = in.nextInt();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                dots.add(new Dot(75 + 150 * i, 75 + 150 * j, 15,red, green, blue));
            }
        }

        for (int i = 0; i < 24; i++) {
            edgeList[i] = 0;
        }
    }

    public void update() {
        if(start == true){start = false;update3();}
        boolean E = true;
        boolean jia = false;
        boolean up = false;
        boolean foundEdge = false;
        Point mousePoint = new Point((int) StdDraw.mouseX(), (int) StdDraw.mouseY());
        boolean isMousePressed = StdDraw.isMousePressed();
        //.?
        for (int i = 0;i < edges.size();i++){  //Edge edge : edges)
            if (edges.get(i).isFree())
            { //.whether this edge has been pressed
                if (!foundEdge && edges.get(i).getBounds().contains(mousePoint)) {
                    edges.get(i).setColor(currentColor);
                    edges.get(i).setVisible(true);
                    if (isMousePressed) {
                        up = true;
                        currentColor = currentColor == Color.RED ? Color.BLUE : Color.RED;//.exchange colour
                        edges.get(i).setFree(false);
                        edges.get(i).time=time;
                        time++;
                        if(currentColor == Color.BLUE){//.this is red
                            edgeList[i] = 1;
                        }
                        if(currentColor == Color.RED){//.this is blue
                            edgeList[i] = 2;
                        }
                        if (i < edges.size() / 2) {
                            if (i % 4 == 0) {
                                int t = i / 4;
                                if (edgeList[i + 1] != 0 && edgeList[i + 12 - t] != 0 && edgeList[i + 15 - t] != 0) {
                                    if (edges.get(i).time > edges.get(i + 1).time && edges.get(i).time > edges.get(i + 12 - t).time && edges.get(i).time > edges.get(i + 15 - t).time) {
                                        jia = true;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                            E = false;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                            }
                            if (i % 4 == 1) {
                                int t = (int) Math.floor(i / 4);
                                if (edgeList[i + 1] != 0 && edgeList[i + 12 - t] != 0 && edgeList[i + 15 - t] != 0) {
                                    if (edges.get(i).time > edges.get(i + 1).time && edges.get(i).time > edges.get(i + 12 - t).time && edges.get(i).time > edges.get(i + 15 - t).time) {
                                        jia = true;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                            E = false;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                                if (edgeList[i - 1] != 0 && edgeList[i + 11 - t] != 0 && edgeList[i + 14 - t] != 0) {
                                    if (edges.get(i).time > edges.get(i - 1).time && edges.get(i).time > edges.get(i + 11 - t).time && edges.get(i).time > edges.get(i + 14 - t).time) {
                                        jia = true;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                            E = false;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                            }
                            if (i % 4 == 2) {
                                int t = (int) Math.floor(i / 4);
                                if (edgeList[i + 1] != 0 && edgeList[i + 12 - t] != 0 && edgeList[i + 15 - t] != 0) {
                                    if (edges.get(i).time > edges.get(i + 1).time && edges.get(i).time > edges.get(i + 12 - t).time && edges.get(i).time > edges.get(i + 15 - t).time) {
                                        jia = true;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                            E = false;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                                if (edgeList[i - 1] != 0 && edgeList[i + 11 - t] != 0 && edgeList[i + 14 - t] != 0) {
                                    if (edges.get(i).time > edges.get(i - 1).time && edges.get(i).time > edges.get(i + 11 - t).time && edges.get(i).time > edges.get(i + 14 - t).time) {
                                        jia = true;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                            E = false;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                            }
                            if (i % 4 == 3) {
                                int t = (int) Math.floor(i / 4);
                                if (edgeList[i - 1] != 0 && edgeList[i + 11 - t] != 0 && edgeList[i + 14 - t] != 0) {
                                    if (edges.get(i).time > edges.get(i - 1).time && edges.get(i).time > edges.get(i + 11 - t).time && edges.get(i).time > edges.get(i + 14 - t).time) {
                                        jia = true;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                            E = false;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                            }
                        } else if (i < edges.size())
                        {
                            if (i <= 14) {
                                if (edgeList[i - 12] != 0 && edgeList[i - 11] != 0 && edgeList[i + 3] != 0) {
                                    if (edges.get(i).time > edges.get(i - 12).time && edges.get(i).time > edges.get(i - 11).time && edges.get(i).time > edges.get(i + 3).time) {
                                        jia = true;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                            E = false;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                            } else if (i <= 17) {//.find sequence??
                                if (edgeList[i - 12 + 1] != 0 && edgeList[i - 11 + 1] != 0 && edgeList[i + 3] != 0) {
                                    if (edges.get(i).time > edges.get(i - 12 + 1).time && edges.get(i).time > edges.get(i - 11 + 1).time && edges.get(i).time > edges.get(i + 3).time) {
                                        jia = true;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                            E = false;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                                if (edgeList[i - 15] != 0 && edgeList[i - 14] != 0 && edgeList[i - 3] != 0) {
                                    if (edges.get(i).time > edges.get(i - 15).time && edges.get(i).time > edges.get(i - 14).time && edges.get(i).time > edges.get(i - 3).time) {
                                        jia = true;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                            E = false;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                            } else if (i <= 20) {
                                if (edgeList[i - 10] != 0 && edgeList[i - 9] != 0 && edgeList[i + 3] != 0) {
                                    if (edges.get(i).time > edges.get(i - 10).time && edges.get(i).time > edges.get(i - 9).time && edges.get(i).time > edges.get(i + 3).time) {
                                        jia = true;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                            E = false;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                                if (edgeList[i - 14] != 0 && edgeList[i - 13] != 0 && edgeList[i - 3] != 0) {
                                    if (edges.get(i).time > edges.get(i - 14).time && edges.get(i).time > edges.get(i - 13).time && edges.get(i).time > edges.get(i - 3).time) {
                                        jia = true;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                            E = false;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                            } else if (i <= 23) {
                                if (edgeList[i - 13] != 0 && edgeList[i - 12] != 0 && edgeList[i - 3] != 0) {
                                    if (edges.get(i).time > edges.get(i - 13).time && edges.get(i).time > edges.get(i - 12).time && edges.get(i).time > edges.get(i - 3).time) {
                                        jia = true;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                            E = false;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                            }
                        }
                        if(jia == true){currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;}
                    }
                    foundEdge = true; // Avoid multiple selections.
                } else {
                    edges.get(i).setVisible(false);
                }
            }

        }
        StdDraw.show();
        boolean finish = true;
        for (int n = 0; n < edges.size(); n++){
            if (edges.get(n).isFree()) {finish = false;}}
        if(E == false&& finish == false){
            update();
        }else if (isMousePressed&&up == true&&E == true){
            update2();
        }
    }

    public void update2(){
        {  try{Thread.sleep(400);}catch (InterruptedException e) {
            e.printStackTrace();
        }

            boolean P = true;
            boolean jia = false;

            //System.out.println("false");
            Random j = new Random();
            boolean foundEdge = false;

            int i = j.nextInt(24);
            do{i = j.nextInt(24);}while (!edges.get(i).isFree());

            if (edges.get(i).isFree()) { //.whether this edge has been pressed
                if (!foundEdge) {
                    edges.get(i).setColor(currentColor);
                    edges.get(i).setVisible(true);



                    currentColor = currentColor == Color.RED ? Color.BLUE : Color.RED;//.exchange colour
                    edges.get(i).setFree(false);
                    edges.get(i).time=time;
                    time++;
                    if(currentColor == Color.BLUE){//.this is red
                        edgeList[i] = 1;
                    }
                    if(currentColor == Color.RED){//.this is blue
                        edgeList[i] = 2;
                    }
                    if (i < edges.size() / 2) {
                        if (i % 4 == 0) {
                            int t = i / 4;
                            if (edgeList[i + 1] != 0 && edgeList[i + 12 - t] != 0 && edgeList[i + 15 - t] != 0) {
                                if (edges.get(i).time > edges.get(i + 1).time && edges.get(i).time > edges.get(i + 12 - t).time && edges.get(i).time > edges.get(i + 15 - t).time) {
                                    jia = true;
                                    if (edgeList[i] == 1) {
                                        redScore++;
                                    }
                                    if (edgeList[i] == 2) {
                                        blueScore++;
                                        P = false;
                                    }
                                }
                            }
                        }
                        if (i % 4 == 1) {
                            int t = (int) Math.floor(i / 4);
                            if (edgeList[i + 1] != 0 && edgeList[i + 12 - t] != 0 && edgeList[i + 15 - t] != 0) {
                                if (edges.get(i).time > edges.get(i + 1).time && edges.get(i).time > edges.get(i + 12 - t).time && edges.get(i).time > edges.get(i + 15 - t).time) {
                                    jia = true;
                                    if (edgeList[i] == 1) {
                                        redScore++;
                                    }
                                    if (edgeList[i] == 2) {
                                        blueScore++;
                                        P = false;
                                    }
                                }
                            }
                            if (edgeList[i - 1] != 0 && edgeList[i + 11 - t] != 0 && edgeList[i + 14 - t] != 0) {
                                if (edges.get(i).time > edges.get(i - 1).time && edges.get(i).time > edges.get(i + 11 - t).time && edges.get(i).time > edges.get(i + 14 - t).time) {
                                    jia = true;
                                    if (edgeList[i] == 1) {
                                        redScore++;
                                    }
                                    if (edgeList[i] == 2) {
                                        blueScore++;
                                        P = false;
                                    }
                                }
                            }
                        }
                        if (i % 4 == 2) {
                            int t = (int) Math.floor(i / 4);
                            if (edgeList[i + 1] != 0 && edgeList[i + 12 - t] != 0 && edgeList[i + 15 - t] != 0) {
                                if (edges.get(i).time > edges.get(i + 1).time && edges.get(i).time > edges.get(i + 12 - t).time && edges.get(i).time > edges.get(i + 15 - t).time) {
                                    jia = true;
                                    if (edgeList[i] == 1) {
                                        redScore++;
                                    }
                                    if (edgeList[i] == 2) {
                                        blueScore++;
                                        P = false;
                                    }
                                }
                            }
                            if (edgeList[i - 1] != 0 && edgeList[i + 11 - t] != 0 && edgeList[i + 14 - t] != 0) {
                                if (edges.get(i).time > edges.get(i - 1).time && edges.get(i).time > edges.get(i + 11 - t).time && edges.get(i).time > edges.get(i + 14 - t).time) {
                                    jia = true;
                                    if (edgeList[i] == 1) {
                                        redScore++;
                                    }
                                    if (edgeList[i] == 2) {
                                        blueScore++;
                                        P = false;
                                    }
                                }
                            }
                        }
                        if (i % 4 == 3) {
                            int t = (int) Math.floor(i / 4);
                            if (edgeList[i - 1] != 0 && edgeList[i + 11 - t] != 0 && edgeList[i + 14 - t] != 0) {
                                if (edges.get(i).time > edges.get(i - 1).time && edges.get(i).time > edges.get(i + 11 - t).time && edges.get(i).time > edges.get(i + 14 - t).time) {
                                    jia = true;
                                    if (edgeList[i] == 1) {
                                        redScore++;
                                    }
                                    if (edgeList[i] == 2) {
                                        blueScore++;
                                        P = false;
                                    }
                                }
                            }
                        }
                    } else if (i < edges.size()) {
                        if (i <= 14) {
                            if (edgeList[i - 12] != 0 && edgeList[i - 11] != 0 && edgeList[i + 3] != 0) {
                                if (edges.get(i).time > edges.get(i - 12).time && edges.get(i).time > edges.get(i - 11).time && edges.get(i).time > edges.get(i + 3).time) {
                                    jia = true;
                                    if (edgeList[i] == 1) {
                                        redScore++;
                                    }
                                    if (edgeList[i] == 2) {
                                        blueScore++;
                                        P = false;
                                    }
                                }
                            }
                        } else if (i <= 17) {//.find sequence??
                            if (edgeList[i - 12 + 1] != 0 && edgeList[i - 11 + 1] != 0 && edgeList[i + 3] != 0) {
                                if (edges.get(i).time > edges.get(i - 12 + 1).time && edges.get(i).time > edges.get(i - 11 + 1).time && edges.get(i).time > edges.get(i + 3).time) {
                                    jia = true;
                                    if (edgeList[i] == 1) {
                                        redScore++;
                                    }
                                    if (edgeList[i] == 2) {
                                        blueScore++;
                                        P = false;
                                    }
                                }
                            }
                            if (edgeList[i - 15] != 0 && edgeList[i - 14] != 0 && edgeList[i - 3] != 0) {
                                if (edges.get(i).time > edges.get(i - 15).time && edges.get(i).time > edges.get(i - 14).time && edges.get(i).time > edges.get(i - 3).time) {
                                    jia = true;
                                    if (edgeList[i] == 1) {
                                        redScore++;
                                    }
                                    if (edgeList[i] == 2) {
                                        blueScore++;
                                        P = false;
                                    }
                                }
                            }
                        } else if (i <= 20) {
                            if (edgeList[i - 10] != 0 && edgeList[i - 9] != 0 && edgeList[i + 3] != 0) {
                                if (edges.get(i).time > edges.get(i - 10).time && edges.get(i).time > edges.get(i - 9).time && edges.get(i).time > edges.get(i + 3).time) {
                                    jia = true;
                                    if (edgeList[i] == 1) {
                                        redScore++;
                                    }
                                    if (edgeList[i] == 2) {
                                        blueScore++;
                                        P = false;
                                    }
                                }
                            }
                            if (edgeList[i - 14] != 0 && edgeList[i - 13] != 0 && edgeList[i - 3] != 0) {
                                if (edges.get(i).time > edges.get(i - 14).time && edges.get(i).time > edges.get(i - 13).time && edges.get(i).time > edges.get(i - 3).time) {
                                    jia = true;
                                    if (edgeList[i] == 1) {
                                        redScore++;
                                    }
                                    if (edgeList[i] == 2) {
                                        blueScore++;
                                        P = false;
                                    }
                                }
                            }
                        } else if (i <= 23) {
                            if (edgeList[i - 13] != 0 && edgeList[i - 12] != 0 && edgeList[i - 3] != 0) {
                                if (edges.get(i).time > edges.get(i - 13).time && edges.get(i).time > edges.get(i - 12).time && edges.get(i).time > edges.get(i - 3).time) {
                                    jia = true;
                                    if (edgeList[i] == 1) {
                                        redScore++;
                                    }
                                    if (edgeList[i] == 2) {
                                        blueScore++;
                                        P = false;
                                    }
                                }
                            }
                        }
                    }
                    if(jia == true){currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;}
                    foundEdge = true; // Avoid multiple selections.
                } else {
                    edges.get(i).setVisible(false);
                }
            }

            StdDraw.show();
            boolean finish = true;
            for (int n = 0; n < edges.size(); n++){
                if (edges.get(n).isFree()) {finish = false;}}

            if(P == false&&finish == false){update2();
            }
        }
    }

    public void update3(){
        {  try{Thread.sleep(400);}catch (InterruptedException e) {
            e.printStackTrace();
        }

            boolean P = true;
            boolean jia = false;

            //System.out.println("false");
            Random j = new Random();
            boolean foundEdge = false;

            int i = j.nextInt(24);
            do{i = j.nextInt(24);}while (!edges.get(i).isFree());

            if (edges.get(i).isFree()) { //.whether this edge has been pressed
                if (!foundEdge) {
                    edges.get(i).setColor(currentColor);
                    edges.get(i).setVisible(true);



                    currentColor = currentColor == Color.RED ? Color.BLUE : Color.RED;//.exchange colour
                    edges.get(i).setFree(false);
                    edges.get(i).time=time;
                    time++;
                    if(currentColor == Color.BLUE){//.this is red
                        edgeList[i] = 1;
                    }
                    if(currentColor == Color.RED){//.this is blue
                        edgeList[i] = 2;
                    }
                    if (i < edges.size() / 2) {
                        if (i % 4 == 0) {
                            int t = i / 4;
                            if (edgeList[i + 1] != 0 && edgeList[i + 12 - t] != 0 && edgeList[i + 15 - t] != 0) {
                                if (edges.get(i).time > edges.get(i + 1).time && edges.get(i).time > edges.get(i + 12 - t).time && edges.get(i).time > edges.get(i + 15 - t).time) {
                                    jia = true;
                                    if (edgeList[i] == 1) {
                                        redScore++;
                                    }
                                    if (edgeList[i] == 2) {
                                        blueScore++;
                                        P = false;
                                    }
                                }
                            }
                        }
                        if (i % 4 == 1) {
                            int t = (int) Math.floor(i / 4);
                            if (edgeList[i + 1] != 0 && edgeList[i + 12 - t] != 0 && edgeList[i + 15 - t] != 0) {
                                if (edges.get(i).time > edges.get(i + 1).time && edges.get(i).time > edges.get(i + 12 - t).time && edges.get(i).time > edges.get(i + 15 - t).time) {
                                    jia = true;
                                    if (edgeList[i] == 1) {
                                        redScore++;
                                    }
                                    if (edgeList[i] == 2) {
                                        blueScore++;
                                        P = false;
                                    }
                                }
                            }
                            if (edgeList[i - 1] != 0 && edgeList[i + 11 - t] != 0 && edgeList[i + 14 - t] != 0) {
                                if (edges.get(i).time > edges.get(i - 1).time && edges.get(i).time > edges.get(i + 11 - t).time && edges.get(i).time > edges.get(i + 14 - t).time) {
                                    jia = true;
                                    if (edgeList[i] == 1) {
                                        redScore++;
                                    }
                                    if (edgeList[i] == 2) {
                                        blueScore++;
                                        P = false;
                                    }
                                }
                            }
                        }
                        if (i % 4 == 2) {
                            int t = (int) Math.floor(i / 4);
                            if (edgeList[i + 1] != 0 && edgeList[i + 12 - t] != 0 && edgeList[i + 15 - t] != 0) {
                                if (edges.get(i).time > edges.get(i + 1).time && edges.get(i).time > edges.get(i + 12 - t).time && edges.get(i).time > edges.get(i + 15 - t).time) {
                                    jia = true;
                                    if (edgeList[i] == 1) {
                                        redScore++;
                                    }
                                    if (edgeList[i] == 2) {
                                        blueScore++;
                                        P = false;
                                    }
                                }
                            }
                            if (edgeList[i - 1] != 0 && edgeList[i + 11 - t] != 0 && edgeList[i + 14 - t] != 0) {
                                if (edges.get(i).time > edges.get(i - 1).time && edges.get(i).time > edges.get(i + 11 - t).time && edges.get(i).time > edges.get(i + 14 - t).time) {
                                    jia = true;
                                    if (edgeList[i] == 1) {
                                        redScore++;
                                    }
                                    if (edgeList[i] == 2) {
                                        blueScore++;
                                        P = false;
                                    }
                                }
                            }
                        }
                        if (i % 4 == 3) {
                            int t = (int) Math.floor(i / 4);
                            if (edgeList[i - 1] != 0 && edgeList[i + 11 - t] != 0 && edgeList[i + 14 - t] != 0) {
                                if (edges.get(i).time > edges.get(i - 1).time && edges.get(i).time > edges.get(i + 11 - t).time && edges.get(i).time > edges.get(i + 14 - t).time) {
                                    jia = true;
                                    if (edgeList[i] == 1) {
                                        redScore++;
                                    }
                                    if (edgeList[i] == 2) {
                                        blueScore++;
                                        P = false;
                                    }
                                }
                            }
                        }
                    } else if (i < edges.size()) {
                        if (i <= 14) {
                            if (edgeList[i - 12] != 0 && edgeList[i - 11] != 0 && edgeList[i + 3] != 0) {
                                if (edges.get(i).time > edges.get(i - 12).time && edges.get(i).time > edges.get(i - 11).time && edges.get(i).time > edges.get(i + 3).time) {
                                    jia = true;
                                    if (edgeList[i] == 1) {
                                        redScore++;
                                    }
                                    if (edgeList[i] == 2) {
                                        blueScore++;
                                        P = false;
                                    }
                                }
                            }
                        } else if (i <= 17) {//.find sequence??
                            if (edgeList[i - 12 + 1] != 0 && edgeList[i - 11 + 1] != 0 && edgeList[i + 3] != 0) {
                                if (edges.get(i).time > edges.get(i - 12 + 1).time && edges.get(i).time > edges.get(i - 11 + 1).time && edges.get(i).time > edges.get(i + 3).time) {
                                    jia = true;
                                    if (edgeList[i] == 1) {
                                        redScore++;
                                    }
                                    if (edgeList[i] == 2) {
                                        blueScore++;
                                        P = false;
                                    }
                                }
                            }
                            if (edgeList[i - 15] != 0 && edgeList[i - 14] != 0 && edgeList[i - 3] != 0) {
                                if (edges.get(i).time > edges.get(i - 15).time && edges.get(i).time > edges.get(i - 14).time && edges.get(i).time > edges.get(i - 3).time) {
                                    jia = true;
                                    if (edgeList[i] == 1) {
                                        redScore++;
                                    }
                                    if (edgeList[i] == 2) {
                                        blueScore++;
                                        P = false;
                                    }
                                }
                            }
                        } else if (i <= 20) {
                            if (edgeList[i - 10] != 0 && edgeList[i - 9] != 0 && edgeList[i + 3] != 0) {
                                if (edges.get(i).time > edges.get(i - 10).time && edges.get(i).time > edges.get(i - 9).time && edges.get(i).time > edges.get(i + 3).time) {
                                    jia = true;
                                    if (edgeList[i] == 1) {
                                        redScore++;
                                    }
                                    if (edgeList[i] == 2) {
                                        blueScore++;
                                        P = false;
                                    }
                                }
                            }
                            if (edgeList[i - 14] != 0 && edgeList[i - 13] != 0 && edgeList[i - 3] != 0) {
                                if (edges.get(i).time > edges.get(i - 14).time && edges.get(i).time > edges.get(i - 13).time && edges.get(i).time > edges.get(i - 3).time) {
                                    jia = true;
                                    if (edgeList[i] == 1) {
                                        redScore++;
                                    }
                                    if (edgeList[i] == 2) {
                                        blueScore++;
                                        P = false;
                                    }
                                }
                            }
                        } else if (i <= 23) {
                            if (edgeList[i - 13] != 0 && edgeList[i - 12] != 0 && edgeList[i - 3] != 0) {
                                if (edges.get(i).time > edges.get(i - 13).time && edges.get(i).time > edges.get(i - 12).time && edges.get(i).time > edges.get(i - 3).time) {
                                    jia = true;
                                    if (edgeList[i] == 1) {
                                        redScore++;
                                    }
                                    if (edgeList[i] == 2) {
                                        blueScore++;
                                        P = false;
                                    }
                                }
                            }
                        }
                    }
                    if(jia == true){currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;}
                    foundEdge = true; // Avoid multiple selections.
                } else {
                    edges.get(i).setVisible(false);
                }
            }

        }
    }

    public void paint() {
        StdDraw.clear();//.to initialize the canvas
        StdDraw.setFont(new Font("times new Roman", Font.ITALIC, 30));
        // Paint edges first, so dots will be on the top layer.
        StdDraw.text(225, 700, "Play Dots and Boxes!");
        String text = (currentColor == Color.RED) ? "Red player's turn" : "Blue player's turn";
        StdDraw.text(800, 400, text);
        StdDraw.text(850, 700, "Score(Novice)");
        StdDraw.text(700, 625, "Red:");
        StdDraw.text(700, 550, "Blue:");
        StdDraw.text(850, 625, String.valueOf(redScore));
        StdDraw.text(850, 550, String.valueOf(blueScore));

        for (Edge edge : edges) {
            edge.paint();
        }
        for (Dot dot : dots) {
            dot.paint();
        }
//      edges.forEach(Edge::paint);
//      dots.forEach(Dot::paint);
        for (int i = 0; i < edges.size() / 2; i++) {
            if (edgeList[i] != 0) {
                if (i % 4 == 0) {
                    int t = i / 4;
                    if (edgeList[i + 1] != 0 && edgeList[i + 12 - t] != 0 && edgeList[i + 15 - t] != 0) {
                        if (edges.get(i).time > edges.get(i + 1).time && edges.get(i).time > edges.get(i + 12 - t).time && edges.get(i).time > edges.get(i + 15 - t).time) {
                            if (edgeList[i] == 1) {
                                StdDraw.text(150 + 150 * t, 150, "RED");

                            }
                            if (edgeList[i] == 2) {
                                StdDraw.text(150 + 150 * t, 150, "BLUE");

                            }
                        }
                    }
                }
                if (i % 4 == 1) {
                    int t = (int) Math.floor(i / 4);
                    if (edgeList[i + 1] != 0 && edgeList[i + 12 - t] != 0 && edgeList[i + 15 - t] != 0) {
                        if (edges.get(i).time > edges.get(i + 1).time && edges.get(i).time > edges.get(i + 12 - t).time && edges.get(i).time > edges.get(i + 15 - t).time) {
                            if (edgeList[i] == 1) {
                                StdDraw.text(150 + 150 * t, 300, "RED");

                            }
                            if (edgeList[i] == 2) {
                                StdDraw.text(150 + 150 * t, 300, "BLUE");

                            }
                        }
                    }
                    if (edgeList[i - 1] != 0 && edgeList[i + 11 - t] != 0 && edgeList[i + 14 - t] != 0) {
                        if (edges.get(i).time > edges.get(i - 1).time && edges.get(i).time > edges.get(i + 11 - t).time && edges.get(i).time > edges.get(i + 14 - t).time) {
                            if (edgeList[i] == 1) {
                                StdDraw.text(150 + 150 * t, 150, "RED");

                            }
                            if (edgeList[i] == 2) {
                                StdDraw.text(150 + 150 * t, 150, "BLUE");

                            }
                        }
                    }
                }
                if (i % 4 == 2) {
                    int t = (int) Math.floor(i / 4);
                    if (edgeList[i + 1] != 0 && edgeList[i + 12 - t] != 0 && edgeList[i + 15 - t] != 0) {
                        if (edges.get(i).time > edges.get(i + 1).time && edges.get(i).time > edges.get(i + 12 - t).time && edges.get(i).time > edges.get(i + 15 - t).time) {
                            if (edgeList[i] == 1) {
                                StdDraw.text(150 + 150 * t, 450, "RED");

                            }
                            if (edgeList[i] == 2) {
                                StdDraw.text(150 + 150 * t, 450, "BLUE");

                            }
                        }
                    }
                    if (edgeList[i - 1] != 0 && edgeList[i + 11 - t] != 0 && edgeList[i + 14 - t] != 0) {
                        if (edges.get(i).time > edges.get(i - 1).time && edges.get(i).time > edges.get(i + 11 - t).time && edges.get(i).time > edges.get(i + 14 - t).time) {
                            if (edgeList[i] == 1) {
                                StdDraw.text(150 + 150 * t, 300, "RED");

                            }
                            if (edgeList[i] == 2) {
                                StdDraw.text(150 + 150 * t, 300, "BLUE");

                            }
                        }
                    }
                }
                if (i % 4 == 3) {
                    int t = (int) Math.floor(i / 4);
                    if (edgeList[i - 1] != 0 && edgeList[i + 11 - t] != 0 && edgeList[i + 14 - t] != 0) {
                        if (edges.get(i).time > edges.get(i - 1).time && edges.get(i).time > edges.get(i + 11 - t).time && edges.get(i).time > edges.get(i + 14 - t).time) {
                            if (edgeList[i] == 1) {
                                StdDraw.text(150 + 150 * t, 450, "RED");

                            }
                            if (edgeList[i] == 2) {
                                StdDraw.text(150 + 150 * t, 450, "BLUE");

                            }
                        }
                    }
                }
            }
        }
        for (int i = edges.size() / 2; i < edges.size(); i++) {
            if (edgeList[i] != 0) {
                if (i <= 14) {
                    if (edgeList[i - 12] != 0 && edgeList[i - 11] != 0 && edgeList[i + 3] != 0) {
                        if (edges.get(i).time > edges.get(i - 12).time && edges.get(i).time > edges.get(i - 11).time && edges.get(i).time > edges.get(i + 3).time) {
                            if (edgeList[i] == 1) {
                                StdDraw.text(150, 150 + 150 * (i - edges.size() / 2), "RED");

                            }
                            if (edgeList[i] == 2) {
                                StdDraw.text(150, 150 + 150 * (i - edges.size() / 2), "BLUE");

                            }
                        }
                    }
                } else if (i <= 17) {//.find sequence??
                    if (edgeList[i - 12 + 1] != 0 && edgeList[i - 11 + 1] != 0 && edgeList[i + 3] != 0) {
                        if (edges.get(i).time > edges.get(i - 12 + 1).time && edges.get(i).time > edges.get(i - 11 + 1).time && edges.get(i).time > edges.get(i + 3).time) {
                            if (edgeList[i] == 1) {
                                StdDraw.text(300, 150 + 150 * (i - 3 - edges.size() / 2), "RED");

                            }
                            if (edgeList[i] == 2) {
                                StdDraw.text(300, 150 + 150 * (i - 3 - edges.size() / 2), "BLUE");

                            }
                        }
                    }
                    if (edgeList[i - 15] != 0 && edgeList[i - 14] != 0 && edgeList[i - 3] != 0) {
                        if (edges.get(i).time > edges.get(i - 15).time && edges.get(i).time > edges.get(i - 14).time && edges.get(i).time > edges.get(i - 3).time) {
                            if (edgeList[i] == 1) {
                                StdDraw.text(150, 150 + 150 * (i - 3 - edges.size() / 2), "RED");

                            }
                            if (edgeList[i] == 2) {
                                StdDraw.text(150, 150 + 150 * (i - 3 - edges.size() / 2), "BLUE");

                            }
                        }
                    }
                } else if (i <= 20) {
                    if (edgeList[i - 10] != 0 && edgeList[i - 9] != 0 && edgeList[i + 3] != 0) {
                        if (edges.get(i).time > edges.get(i - 10).time && edges.get(i).time > edges.get(i - 9).time && edges.get(i).time > edges.get(i + 3).time) {
                            if (edgeList[i] == 1) {
                                StdDraw.text(450, 150 + 150 * (i - 6 - edges.size() / 2), "RED");

                            }
                            if (edgeList[i] == 2) {
                                StdDraw.text(450, 150 + 150 * (i - 6 - edges.size() / 2), "BLUE");

                            }
                        }
                    }
                    if (edgeList[i - 14] != 0 && edgeList[i - 13] != 0 && edgeList[i - 3] != 0) {
                        if (edges.get(i).time > edges.get(i - 14).time && edges.get(i).time > edges.get(i - 13).time && edges.get(i).time > edges.get(i - 3).time) {
                            if (edgeList[i] == 1) {
                                StdDraw.text(300, 150 + 150 * (i - 6 - edges.size() / 2), "RED");

                            }
                            if (edgeList[i] == 2) {
                                StdDraw.text(300, 150 + 150 * (i - 6 - edges.size() / 2), "BLUE");

                            }
                        }
                    }
                } else if (i <= 23) {
                    if (edgeList[i - 13] != 0 && edgeList[i - 12] != 0 && edgeList[i - 3] != 0) {
                        if (edges.get(i).time > edges.get(i - 13).time && edges.get(i).time > edges.get(i - 12).time && edges.get(i).time > edges.get(i - 3).time) {
                            if (edgeList[i] == 1) {
                                StdDraw.text(450, 150 + 150 * (i - 9 - edges.size() / 2), "RED");

                            }
                            if (edgeList[i] == 2) {
                                StdDraw.text(450, 150 + 150 * (i - 9 - edges.size() / 2), "BLUE");

                            }
                        }
                    }
                }
            }
        }
        int counter = 0;
        for (int i = 0; i < edges.size(); i++) {
            if (edgeList[i] != 0) {
                counter++;
            }
        }
        if (counter == edges.size()) {
            if (redScore == blueScore) {
                StdDraw.text(300, 625, "Game over, no winner");
            } else if (redScore > blueScore) {
                StdDraw.text(300, 625, "Game over, Red player is winner!");
            } else if (redScore < blueScore) {
                StdDraw.text(300, 625, "Game over, Blue player is winner!");
            }
            StdDraw.show();
            try{Thread.sleep(400);}catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(gamefinish == false){
                new Thread(()-> NewInterface.run()).start();
                gamefinish = true;
            }
        }
        StdDraw.show();
    }

    public static void main(String[] args) {
        PVE440 game = new PVE440(700, 700);

        while (true) {
            game.update();
            game.paint();//.start to draw
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();//.if bugging,it shows reasons,instead of stopping.
            }
        }
    }

    public static void run(int size) {
        PVE440 game = new PVE440(700, 700);
        size = 4;

        while (true) {
            game.update();
            game.paint();//.start to draw
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();//.if bugging,it shows reasons,instead of stopping.
            }
        }
    }
}
