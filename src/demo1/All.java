package demo1;

import java.awt.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class All extends JFrame{
    //    private List<Edge> edges = new ArrayList<>();
//    private List<Dot> dots = new ArrayList<>();
    static int time = 0;
    private ArrayList<Edge> edges = new ArrayList<>();//.edges
    private ArrayList<Dot> dots = new ArrayList<>();//.dots
    private Color currentColor = Color.RED;//.1st.red & 2nd.blue
    int[] edgeList = new int[24];
    int redScore = 0;
    int blueScore = 0;
    int gamesize = 0;
    String style = "";

    public All(){

    }

    public void newgame(int canvasWidth, int canvasHeight) { //.canvas:a piece of cloth
        StdDraw.setCanvasSize(canvasWidth, canvasHeight);
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 1000);
        StdDraw.setYscale(0, 900);//.to achieve symmetric DotsBoxes: setXscale & setYscale(0,4i)
       /* System.out.printf("Please choose size of board: 3 * 3 squares , 4 * 4 squares , 5 * 5 squares\n");
        System.out.printf("Size of board: ");
        Scanner input = new Scanner(System.in);*/
        if(gamesize == 33){initialize3();}
        else if(gamesize == 44){initialize4();}
        else if(gamesize == 55){initialize5();}
        else System.out.println("Wrong");

    }


    public void initialize3() {
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
        Scanner in = new Scanner(System.in);int red = in.nextInt();
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
    public void initialize4() {
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
        Scanner in = new Scanner(System.in);int red = in.nextInt();
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
        if(style == "PVP"){PVP44();}
    }
    public void initialize5() {
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
        Scanner in = new Scanner(System.in);int red = in.nextInt();
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

    public void update3PVP() {
        Point mousePoint = new Point((int) StdDraw.mouseX(), (int) StdDraw.mouseY());
        boolean isMousePressed = StdDraw.isMousePressed();
        boolean foundEdge = false;//.?
        for (int i = 0; i < edges.size(); i++) {  //Edge edge : edges)
            if (edges.get(i).isFree()) { //.whether this edge has been pressed
                if (!foundEdge && edges.get(i).getBounds().contains(mousePoint)) {
                    edges.get(i).setColor(currentColor);
                    edges.get(i).setVisible(true);

                    if (isMousePressed) {
                        currentColor = currentColor == Color.RED ? Color.BLUE : Color.RED;//.exchange colour
                        edges.get(i).setFree(false);
                        edges.get(i).time = time;
                        time++;
                        if (currentColor == Color.BLUE) {//.this is red
                            edgeList[i] = 1;
                        }
                        if (currentColor == Color.RED) {//.this is blue
                            edgeList[i] = 2;
                        }
                        if (i < edges.size() / 2) {
                            if (i % 4 == 0) {
                                int t = i / 4;
                                if (edgeList[i + 1] != 0 && edgeList[i + 12 - t] != 0 && edgeList[i + 15 - t] != 0) {
                                    if (edges.get(i).time > edges.get(i + 1).time && edges.get(i).time > edges.get(i + 12 - t).time && edges.get(i).time > edges.get(i + 15 - t).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
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
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                                if (edgeList[i - 1] != 0 && edgeList[i + 11 - t] != 0 && edgeList[i + 14 - t] != 0) {
                                    if (edges.get(i).time > edges.get(i - 1).time && edges.get(i).time > edges.get(i + 11 - t).time && edges.get(i).time > edges.get(i + 14 - t).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
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
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                                if (edgeList[i - 1] != 0 && edgeList[i + 11 - t] != 0 && edgeList[i + 14 - t] != 0) {
                                    if (edges.get(i).time > edges.get(i - 1).time && edges.get(i).time > edges.get(i + 11 - t).time && edges.get(i).time > edges.get(i + 14 - t).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
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
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                            }
                        } else if (i < edges.size()) {
                            if (i <= 14) {
                                if (edgeList[i - 12] != 0 && edgeList[i - 11] != 0 && edgeList[i + 3] != 0) {
                                    if (edges.get(i).time > edges.get(i - 12).time && edges.get(i).time > edges.get(i - 11).time && edges.get(i).time > edges.get(i + 3).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                            } else if (i <= 17) {//.find sequence??
                                if (edgeList[i - 12 + 1] != 0 && edgeList[i - 11 + 1] != 0 && edgeList[i + 3] != 0) {
                                    if (edges.get(i).time > edges.get(i - 12 + 1).time && edges.get(i).time > edges.get(i - 11 + 1).time && edges.get(i).time > edges.get(i + 3).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                                if (edgeList[i - 15] != 0 && edgeList[i - 14] != 0 && edgeList[i - 3] != 0) {
                                    if (edges.get(i).time > edges.get(i - 15).time && edges.get(i).time > edges.get(i - 14).time && edges.get(i).time > edges.get(i - 3).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                            } else if (i <= 20) {
                                if (edgeList[i - 10] != 0 && edgeList[i - 9] != 0 && edgeList[i + 3] != 0) {
                                    if (edges.get(i).time > edges.get(i - 10).time && edges.get(i).time > edges.get(i - 9).time && edges.get(i).time > edges.get(i + 3).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                                if (edgeList[i - 14] != 0 && edgeList[i - 13] != 0 && edgeList[i - 3] != 0) {
                                    if (edges.get(i).time > edges.get(i - 14).time && edges.get(i).time > edges.get(i - 13).time && edges.get(i).time > edges.get(i - 3).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                            } else if (i <= 23) {
                                if (edgeList[i - 13] != 0 && edgeList[i - 12] != 0 && edgeList[i - 3] != 0) {
                                    if (edges.get(i).time > edges.get(i - 13).time && edges.get(i).time > edges.get(i - 12).time && edges.get(i).time > edges.get(i - 3).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    foundEdge = true; // Avoid multiple selections.
                } else {
                    edges.get(i).setVisible(false);
                }
            }
        }
    }
    public void update4PVP() {
        Point mousePoint = new Point((int) StdDraw.mouseX(), (int) StdDraw.mouseY());
        boolean isMousePressed = StdDraw.isMousePressed();
        boolean foundEdge = false;//.?
        for (int i = 0; i < edges.size(); i++) {  //Edge edge : edges)
            if (edges.get(i).isFree()) { //.whether this edge has been pressed
                if (!foundEdge && edges.get(i).getBounds().contains(mousePoint)) {
                    edges.get(i).setColor(currentColor);
                    edges.get(i).setVisible(true);

                    if (isMousePressed) {
                        currentColor = currentColor == Color.RED ? Color.BLUE : Color.RED;//.exchange colour
                        edges.get(i).setFree(false);
                        edges.get(i).time = time;
                        time++;
                        if (currentColor == Color.BLUE) {//.this is red
                            edgeList[i] = 1;
                        }
                        if (currentColor == Color.RED) {//.this is blue
                            edgeList[i] = 2;
                        }
                        if (i < edges.size() / 2) {
                            if (i % 4 == 0) {
                                int t = i / 4;
                                if (edgeList[i + 1] != 0 && edgeList[i + 12 - t] != 0 && edgeList[i + 15 - t] != 0) {
                                    if (edges.get(i).time > edges.get(i + 1).time && edges.get(i).time > edges.get(i + 12 - t).time && edges.get(i).time > edges.get(i + 15 - t).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
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
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                                if (edgeList[i - 1] != 0 && edgeList[i + 11 - t] != 0 && edgeList[i + 14 - t] != 0) {
                                    if (edges.get(i).time > edges.get(i - 1).time && edges.get(i).time > edges.get(i + 11 - t).time && edges.get(i).time > edges.get(i + 14 - t).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
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
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                                if (edgeList[i - 1] != 0 && edgeList[i + 11 - t] != 0 && edgeList[i + 14 - t] != 0) {
                                    if (edges.get(i).time > edges.get(i - 1).time && edges.get(i).time > edges.get(i + 11 - t).time && edges.get(i).time > edges.get(i + 14 - t).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
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
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                            }
                        } else if (i < edges.size()) {
                            if (i <= 14) {
                                if (edgeList[i - 12] != 0 && edgeList[i - 11] != 0 && edgeList[i + 3] != 0) {
                                    if (edges.get(i).time > edges.get(i - 12).time && edges.get(i).time > edges.get(i - 11).time && edges.get(i).time > edges.get(i + 3).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                            } else if (i <= 17) {//.find sequence??
                                if (edgeList[i - 12 + 1] != 0 && edgeList[i - 11 + 1] != 0 && edgeList[i + 3] != 0) {
                                    if (edges.get(i).time > edges.get(i - 12 + 1).time && edges.get(i).time > edges.get(i - 11 + 1).time && edges.get(i).time > edges.get(i + 3).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                                if (edgeList[i - 15] != 0 && edgeList[i - 14] != 0 && edgeList[i - 3] != 0) {
                                    if (edges.get(i).time > edges.get(i - 15).time && edges.get(i).time > edges.get(i - 14).time && edges.get(i).time > edges.get(i - 3).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                            } else if (i <= 20) {
                                if (edgeList[i - 10] != 0 && edgeList[i - 9] != 0 && edgeList[i + 3] != 0) {
                                    if (edges.get(i).time > edges.get(i - 10).time && edges.get(i).time > edges.get(i - 9).time && edges.get(i).time > edges.get(i + 3).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                                if (edgeList[i - 14] != 0 && edgeList[i - 13] != 0 && edgeList[i - 3] != 0) {
                                    if (edges.get(i).time > edges.get(i - 14).time && edges.get(i).time > edges.get(i - 13).time && edges.get(i).time > edges.get(i - 3).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                            } else if (i <= 23) {
                                if (edgeList[i - 13] != 0 && edgeList[i - 12] != 0 && edgeList[i - 3] != 0) {
                                    if (edges.get(i).time > edges.get(i - 13).time && edges.get(i).time > edges.get(i - 12).time && edges.get(i).time > edges.get(i - 3).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    foundEdge = true; // Avoid multiple selections.
                } else {
                    edges.get(i).setVisible(false);
                }
            }
        }
    }
    public void update5PVP() {
        Point mousePoint = new Point((int) StdDraw.mouseX(), (int) StdDraw.mouseY());
        boolean isMousePressed = StdDraw.isMousePressed();
        boolean foundEdge = false;//.?
        for (int i = 0; i < edges.size(); i++) {  //Edge edge : edges)
            if (edges.get(i).isFree()) { //.whether this edge has been pressed
                if (!foundEdge && edges.get(i).getBounds().contains(mousePoint)) {
                    edges.get(i).setColor(currentColor);
                    edges.get(i).setVisible(true);

                    if (isMousePressed) {
                        currentColor = currentColor == Color.RED ? Color.BLUE : Color.RED;//.exchange colour
                        edges.get(i).setFree(false);
                        edges.get(i).time = time;
                        time++;
                        if (currentColor == Color.BLUE) {//.this is red
                            edgeList[i] = 1;
                        }
                        if (currentColor == Color.RED) {//.this is blue
                            edgeList[i] = 2;
                        }
                        if (i < edges.size() / 2) {
                            if (i % 4 == 0) {
                                int t = i / 4;
                                if (edgeList[i + 1] != 0 && edgeList[i + 12 - t] != 0 && edgeList[i + 15 - t] != 0) {
                                    if (edges.get(i).time > edges.get(i + 1).time && edges.get(i).time > edges.get(i + 12 - t).time && edges.get(i).time > edges.get(i + 15 - t).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
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
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                                if (edgeList[i - 1] != 0 && edgeList[i + 11 - t] != 0 && edgeList[i + 14 - t] != 0) {
                                    if (edges.get(i).time > edges.get(i - 1).time && edges.get(i).time > edges.get(i + 11 - t).time && edges.get(i).time > edges.get(i + 14 - t).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
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
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                                if (edgeList[i - 1] != 0 && edgeList[i + 11 - t] != 0 && edgeList[i + 14 - t] != 0) {
                                    if (edges.get(i).time > edges.get(i - 1).time && edges.get(i).time > edges.get(i + 11 - t).time && edges.get(i).time > edges.get(i + 14 - t).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
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
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                            }
                        } else if (i < edges.size()) {
                            if (i <= 14) {
                                if (edgeList[i - 12] != 0 && edgeList[i - 11] != 0 && edgeList[i + 3] != 0) {
                                    if (edges.get(i).time > edges.get(i - 12).time && edges.get(i).time > edges.get(i - 11).time && edges.get(i).time > edges.get(i + 3).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                            } else if (i <= 17) {//.find sequence??
                                if (edgeList[i - 12 + 1] != 0 && edgeList[i - 11 + 1] != 0 && edgeList[i + 3] != 0) {
                                    if (edges.get(i).time > edges.get(i - 12 + 1).time && edges.get(i).time > edges.get(i - 11 + 1).time && edges.get(i).time > edges.get(i + 3).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                                if (edgeList[i - 15] != 0 && edgeList[i - 14] != 0 && edgeList[i - 3] != 0) {
                                    if (edges.get(i).time > edges.get(i - 15).time && edges.get(i).time > edges.get(i - 14).time && edges.get(i).time > edges.get(i - 3).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                            } else if (i <= 20) {
                                if (edgeList[i - 10] != 0 && edgeList[i - 9] != 0 && edgeList[i + 3] != 0) {
                                    if (edges.get(i).time > edges.get(i - 10).time && edges.get(i).time > edges.get(i - 9).time && edges.get(i).time > edges.get(i + 3).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                                if (edgeList[i - 14] != 0 && edgeList[i - 13] != 0 && edgeList[i - 3] != 0) {
                                    if (edges.get(i).time > edges.get(i - 14).time && edges.get(i).time > edges.get(i - 13).time && edges.get(i).time > edges.get(i - 3).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                            } else if (i <= 23) {
                                if (edgeList[i - 13] != 0 && edgeList[i - 12] != 0 && edgeList[i - 3] != 0) {
                                    if (edges.get(i).time > edges.get(i - 13).time && edges.get(i).time > edges.get(i - 12).time && edges.get(i).time > edges.get(i - 3).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    foundEdge = true; // Avoid multiple selections.
                } else {
                    edges.get(i).setVisible(false);
                }
            }
        }
    }

    public void update3PVE() {
        Point mousePoint = new Point((int) StdDraw.mouseX(), (int) StdDraw.mouseY());
        boolean isMousePressed = StdDraw.isMousePressed();
        boolean foundEdge = false;//.?
        for (int i = 0; i < edges.size(); i++) {  //Edge edge : edges)
            if (edges.get(i).isFree()) { //.whether this edge has been pressed
                if (!foundEdge && edges.get(i).getBounds().contains(mousePoint)) {
                    edges.get(i).setColor(currentColor);
                    edges.get(i).setVisible(true);

                    if (isMousePressed) {
                        currentColor = currentColor == Color.RED ? Color.BLUE : Color.RED;//.exchange colour
                        edges.get(i).setFree(false);
                        edges.get(i).time = time;
                        time++;
                        if (currentColor == Color.BLUE) {//.this is red
                            edgeList[i] = 1;
                        }
                        if (currentColor == Color.RED) {//.this is blue
                            edgeList[i] = 2;
                        }
                        if (i < edges.size() / 2) {
                            if (i % 4 == 0) {
                                int t = i / 4;
                                if (edgeList[i + 1] != 0 && edgeList[i + 12 - t] != 0 && edgeList[i + 15 - t] != 0) {
                                    if (edges.get(i).time > edges.get(i + 1).time && edges.get(i).time > edges.get(i + 12 - t).time && edges.get(i).time > edges.get(i + 15 - t).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
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
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                                if (edgeList[i - 1] != 0 && edgeList[i + 11 - t] != 0 && edgeList[i + 14 - t] != 0) {
                                    if (edges.get(i).time > edges.get(i - 1).time && edges.get(i).time > edges.get(i + 11 - t).time && edges.get(i).time > edges.get(i + 14 - t).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
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
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                                if (edgeList[i - 1] != 0 && edgeList[i + 11 - t] != 0 && edgeList[i + 14 - t] != 0) {
                                    if (edges.get(i).time > edges.get(i - 1).time && edges.get(i).time > edges.get(i + 11 - t).time && edges.get(i).time > edges.get(i + 14 - t).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
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
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                            }
                        } else if (i < edges.size()) {
                            if (i <= 14) {
                                if (edgeList[i - 12] != 0 && edgeList[i - 11] != 0 && edgeList[i + 3] != 0) {
                                    if (edges.get(i).time > edges.get(i - 12).time && edges.get(i).time > edges.get(i - 11).time && edges.get(i).time > edges.get(i + 3).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                            } else if (i <= 17) {//.find sequence??
                                if (edgeList[i - 12 + 1] != 0 && edgeList[i - 11 + 1] != 0 && edgeList[i + 3] != 0) {
                                    if (edges.get(i).time > edges.get(i - 12 + 1).time && edges.get(i).time > edges.get(i - 11 + 1).time && edges.get(i).time > edges.get(i + 3).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                                if (edgeList[i - 15] != 0 && edgeList[i - 14] != 0 && edgeList[i - 3] != 0) {
                                    if (edges.get(i).time > edges.get(i - 15).time && edges.get(i).time > edges.get(i - 14).time && edges.get(i).time > edges.get(i - 3).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                            } else if (i <= 20) {
                                if (edgeList[i - 10] != 0 && edgeList[i - 9] != 0 && edgeList[i + 3] != 0) {
                                    if (edges.get(i).time > edges.get(i - 10).time && edges.get(i).time > edges.get(i - 9).time && edges.get(i).time > edges.get(i + 3).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                                if (edgeList[i - 14] != 0 && edgeList[i - 13] != 0 && edgeList[i - 3] != 0) {
                                    if (edges.get(i).time > edges.get(i - 14).time && edges.get(i).time > edges.get(i - 13).time && edges.get(i).time > edges.get(i - 3).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                            } else if (i <= 23) {
                                if (edgeList[i - 13] != 0 && edgeList[i - 12] != 0 && edgeList[i - 3] != 0) {
                                    if (edges.get(i).time > edges.get(i - 13).time && edges.get(i).time > edges.get(i - 12).time && edges.get(i).time > edges.get(i - 3).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    foundEdge = true; // Avoid multiple selections.
                } else {
                    edges.get(i).setVisible(false);
                }
            }
        }
    }
    public void update4PVE() {
        Point mousePoint = new Point((int) StdDraw.mouseX(), (int) StdDraw.mouseY());
        boolean isMousePressed = StdDraw.isMousePressed();
        boolean foundEdge = false;//.?
        for (int i = 0; i < edges.size(); i++) {  //Edge edge : edges)
            if (edges.get(i).isFree()) { //.whether this edge has been pressed
                if (!foundEdge && edges.get(i).getBounds().contains(mousePoint)) {
                    edges.get(i).setColor(currentColor);
                    edges.get(i).setVisible(true);

                    if (isMousePressed) {
                        currentColor = currentColor == Color.RED ? Color.BLUE : Color.RED;//.exchange colour
                        edges.get(i).setFree(false);
                        edges.get(i).time = time;
                        time++;
                        if (currentColor == Color.BLUE) {//.this is red
                            edgeList[i] = 1;
                        }
                        if (currentColor == Color.RED) {//.this is blue
                            edgeList[i] = 2;
                        }
                        if (i < edges.size() / 2) {
                            if (i % 4 == 0) {
                                int t = i / 4;
                                if (edgeList[i + 1] != 0 && edgeList[i + 12 - t] != 0 && edgeList[i + 15 - t] != 0) {
                                    if (edges.get(i).time > edges.get(i + 1).time && edges.get(i).time > edges.get(i + 12 - t).time && edges.get(i).time > edges.get(i + 15 - t).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
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
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                                if (edgeList[i - 1] != 0 && edgeList[i + 11 - t] != 0 && edgeList[i + 14 - t] != 0) {
                                    if (edges.get(i).time > edges.get(i - 1).time && edges.get(i).time > edges.get(i + 11 - t).time && edges.get(i).time > edges.get(i + 14 - t).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
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
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                                if (edgeList[i - 1] != 0 && edgeList[i + 11 - t] != 0 && edgeList[i + 14 - t] != 0) {
                                    if (edges.get(i).time > edges.get(i - 1).time && edges.get(i).time > edges.get(i + 11 - t).time && edges.get(i).time > edges.get(i + 14 - t).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
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
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                            }
                        } else if (i < edges.size()) {
                            if (i <= 14) {
                                if (edgeList[i - 12] != 0 && edgeList[i - 11] != 0 && edgeList[i + 3] != 0) {
                                    if (edges.get(i).time > edges.get(i - 12).time && edges.get(i).time > edges.get(i - 11).time && edges.get(i).time > edges.get(i + 3).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                            } else if (i <= 17) {//.find sequence??
                                if (edgeList[i - 12 + 1] != 0 && edgeList[i - 11 + 1] != 0 && edgeList[i + 3] != 0) {
                                    if (edges.get(i).time > edges.get(i - 12 + 1).time && edges.get(i).time > edges.get(i - 11 + 1).time && edges.get(i).time > edges.get(i + 3).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                                if (edgeList[i - 15] != 0 && edgeList[i - 14] != 0 && edgeList[i - 3] != 0) {
                                    if (edges.get(i).time > edges.get(i - 15).time && edges.get(i).time > edges.get(i - 14).time && edges.get(i).time > edges.get(i - 3).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                            } else if (i <= 20) {
                                if (edgeList[i - 10] != 0 && edgeList[i - 9] != 0 && edgeList[i + 3] != 0) {
                                    if (edges.get(i).time > edges.get(i - 10).time && edges.get(i).time > edges.get(i - 9).time && edges.get(i).time > edges.get(i + 3).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                                if (edgeList[i - 14] != 0 && edgeList[i - 13] != 0 && edgeList[i - 3] != 0) {
                                    if (edges.get(i).time > edges.get(i - 14).time && edges.get(i).time > edges.get(i - 13).time && edges.get(i).time > edges.get(i - 3).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                            } else if (i <= 23) {
                                if (edgeList[i - 13] != 0 && edgeList[i - 12] != 0 && edgeList[i - 3] != 0) {
                                    if (edges.get(i).time > edges.get(i - 13).time && edges.get(i).time > edges.get(i - 12).time && edges.get(i).time > edges.get(i - 3).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    foundEdge = true; // Avoid multiple selections.
                } else {
                    edges.get(i).setVisible(false);
                }
            }
        }
    }
    public void update5PVE() {
        Point mousePoint = new Point((int) StdDraw.mouseX(), (int) StdDraw.mouseY());
        boolean isMousePressed = StdDraw.isMousePressed();
        boolean foundEdge = false;//.?
        for (int i = 0; i < edges.size(); i++) {  //Edge edge : edges)
            if (edges.get(i).isFree()) { //.whether this edge has been pressed
                if (!foundEdge && edges.get(i).getBounds().contains(mousePoint)) {
                    edges.get(i).setColor(currentColor);
                    edges.get(i).setVisible(true);

                    if (isMousePressed) {
                        currentColor = currentColor == Color.RED ? Color.BLUE : Color.RED;//.exchange colour
                        edges.get(i).setFree(false);
                        edges.get(i).time = time;
                        time++;
                        if (currentColor == Color.BLUE) {//.this is red
                            edgeList[i] = 1;
                        }
                        if (currentColor == Color.RED) {//.this is blue
                            edgeList[i] = 2;
                        }
                        if (i < edges.size() / 2) {
                            if (i % 4 == 0) {
                                int t = i / 4;
                                if (edgeList[i + 1] != 0 && edgeList[i + 12 - t] != 0 && edgeList[i + 15 - t] != 0) {
                                    if (edges.get(i).time > edges.get(i + 1).time && edges.get(i).time > edges.get(i + 12 - t).time && edges.get(i).time > edges.get(i + 15 - t).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
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
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                                if (edgeList[i - 1] != 0 && edgeList[i + 11 - t] != 0 && edgeList[i + 14 - t] != 0) {
                                    if (edges.get(i).time > edges.get(i - 1).time && edges.get(i).time > edges.get(i + 11 - t).time && edges.get(i).time > edges.get(i + 14 - t).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
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
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                                if (edgeList[i - 1] != 0 && edgeList[i + 11 - t] != 0 && edgeList[i + 14 - t] != 0) {
                                    if (edges.get(i).time > edges.get(i - 1).time && edges.get(i).time > edges.get(i + 11 - t).time && edges.get(i).time > edges.get(i + 14 - t).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
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
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                            }
                        } else if (i < edges.size()) {
                            if (i <= 14) {
                                if (edgeList[i - 12] != 0 && edgeList[i - 11] != 0 && edgeList[i + 3] != 0) {
                                    if (edges.get(i).time > edges.get(i - 12).time && edges.get(i).time > edges.get(i - 11).time && edges.get(i).time > edges.get(i + 3).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                            } else if (i <= 17) {//.find sequence??
                                if (edgeList[i - 12 + 1] != 0 && edgeList[i - 11 + 1] != 0 && edgeList[i + 3] != 0) {
                                    if (edges.get(i).time > edges.get(i - 12 + 1).time && edges.get(i).time > edges.get(i - 11 + 1).time && edges.get(i).time > edges.get(i + 3).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                                if (edgeList[i - 15] != 0 && edgeList[i - 14] != 0 && edgeList[i - 3] != 0) {
                                    if (edges.get(i).time > edges.get(i - 15).time && edges.get(i).time > edges.get(i - 14).time && edges.get(i).time > edges.get(i - 3).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                            } else if (i <= 20) {
                                if (edgeList[i - 10] != 0 && edgeList[i - 9] != 0 && edgeList[i + 3] != 0) {
                                    if (edges.get(i).time > edges.get(i - 10).time && edges.get(i).time > edges.get(i - 9).time && edges.get(i).time > edges.get(i + 3).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                                if (edgeList[i - 14] != 0 && edgeList[i - 13] != 0 && edgeList[i - 3] != 0) {
                                    if (edges.get(i).time > edges.get(i - 14).time && edges.get(i).time > edges.get(i - 13).time && edges.get(i).time > edges.get(i - 3).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                            } else if (i <= 23) {
                                if (edgeList[i - 13] != 0 && edgeList[i - 12] != 0 && edgeList[i - 3] != 0) {
                                    if (edges.get(i).time > edges.get(i - 13).time && edges.get(i).time > edges.get(i - 12).time && edges.get(i).time > edges.get(i - 3).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    foundEdge = true; // Avoid multiple selections.
                } else {
                    edges.get(i).setVisible(false);
                }
            }
        }
    }

    public void update3EVE() {
        Point mousePoint = new Point((int) StdDraw.mouseX(), (int) StdDraw.mouseY());
        boolean isMousePressed = StdDraw.isMousePressed();
        boolean foundEdge = false;//.?
        for (int i = 0; i < edges.size(); i++) {  //Edge edge : edges)
            if (edges.get(i).isFree()) { //.whether this edge has been pressed
                if (!foundEdge && edges.get(i).getBounds().contains(mousePoint)) {
                    edges.get(i).setColor(currentColor);
                    edges.get(i).setVisible(true);

                    if (isMousePressed) {
                        currentColor = currentColor == Color.RED ? Color.BLUE : Color.RED;//.exchange colour
                        edges.get(i).setFree(false);
                        edges.get(i).time = time;
                        time++;
                        if (currentColor == Color.BLUE) {//.this is red
                            edgeList[i] = 1;
                        }
                        if (currentColor == Color.RED) {//.this is blue
                            edgeList[i] = 2;
                        }
                        if (i < edges.size() / 2) {
                            if (i % 4 == 0) {
                                int t = i / 4;
                                if (edgeList[i + 1] != 0 && edgeList[i + 12 - t] != 0 && edgeList[i + 15 - t] != 0) {
                                    if (edges.get(i).time > edges.get(i + 1).time && edges.get(i).time > edges.get(i + 12 - t).time && edges.get(i).time > edges.get(i + 15 - t).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
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
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                                if (edgeList[i - 1] != 0 && edgeList[i + 11 - t] != 0 && edgeList[i + 14 - t] != 0) {
                                    if (edges.get(i).time > edges.get(i - 1).time && edges.get(i).time > edges.get(i + 11 - t).time && edges.get(i).time > edges.get(i + 14 - t).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
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
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                                if (edgeList[i - 1] != 0 && edgeList[i + 11 - t] != 0 && edgeList[i + 14 - t] != 0) {
                                    if (edges.get(i).time > edges.get(i - 1).time && edges.get(i).time > edges.get(i + 11 - t).time && edges.get(i).time > edges.get(i + 14 - t).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
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
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                            }
                        } else if (i < edges.size()) {
                            if (i <= 14) {
                                if (edgeList[i - 12] != 0 && edgeList[i - 11] != 0 && edgeList[i + 3] != 0) {
                                    if (edges.get(i).time > edges.get(i - 12).time && edges.get(i).time > edges.get(i - 11).time && edges.get(i).time > edges.get(i + 3).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                            } else if (i <= 17) {//.find sequence??
                                if (edgeList[i - 12 + 1] != 0 && edgeList[i - 11 + 1] != 0 && edgeList[i + 3] != 0) {
                                    if (edges.get(i).time > edges.get(i - 12 + 1).time && edges.get(i).time > edges.get(i - 11 + 1).time && edges.get(i).time > edges.get(i + 3).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                                if (edgeList[i - 15] != 0 && edgeList[i - 14] != 0 && edgeList[i - 3] != 0) {
                                    if (edges.get(i).time > edges.get(i - 15).time && edges.get(i).time > edges.get(i - 14).time && edges.get(i).time > edges.get(i - 3).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                            } else if (i <= 20) {
                                if (edgeList[i - 10] != 0 && edgeList[i - 9] != 0 && edgeList[i + 3] != 0) {
                                    if (edges.get(i).time > edges.get(i - 10).time && edges.get(i).time > edges.get(i - 9).time && edges.get(i).time > edges.get(i + 3).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                                if (edgeList[i - 14] != 0 && edgeList[i - 13] != 0 && edgeList[i - 3] != 0) {
                                    if (edges.get(i).time > edges.get(i - 14).time && edges.get(i).time > edges.get(i - 13).time && edges.get(i).time > edges.get(i - 3).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                            } else if (i <= 23) {
                                if (edgeList[i - 13] != 0 && edgeList[i - 12] != 0 && edgeList[i - 3] != 0) {
                                    if (edges.get(i).time > edges.get(i - 13).time && edges.get(i).time > edges.get(i - 12).time && edges.get(i).time > edges.get(i - 3).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    foundEdge = true; // Avoid multiple selections.
                } else {
                    edges.get(i).setVisible(false);
                }
            }
        }
    }
    public void update4EVE() {
        Random j = new Random();

        boolean foundEdge = false;//.?

        boolean second = false;
        boolean third = false;
        boolean forth = false;
        int i = 0;
        i = j.nextInt(24);
//        for (int i = 0; i < edges.size(); i++) {  //Edge edge : edges)
        if (edges.get(i).isFree()) { //.whether this edge has been pressed
            if (!foundEdge) {
                edges.get(i).setColor(currentColor);
                edges.get(i).setVisible(true);
                try{Thread.sleep(1000);}catch (InterruptedException e) {
                    e.printStackTrace();
                }


                currentColor = currentColor == Color.RED ? Color.BLUE : Color.RED;//.exchange colour
                edges.get(i).setFree(false);
                edges.get(i).time = time;
                time++;
                if (currentColor == Color.BLUE) {//.this is red
                    edgeList[i] = 1;
                }
                if (currentColor == Color.RED) {//.this is blue
                    edgeList[i] = 2;
                }
                if (i < edges.size() / 2) {
                    if (i % 4 == 0) {
                        int t = i / 4;
                        if (edgeList[i + 1] != 0 && edgeList[i + 12 - t] != 0 && edgeList[i + 15 - t] != 0) {
                            if (edges.get(i).time > edges.get(i + 1).time && edges.get(i).time > edges.get(i + 12 - t).time && edges.get(i).time > edges.get(i + 15 - t).time) {
                                currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                if (edgeList[i] == 1) {
                                    redScore++;
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
                                currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                if (edgeList[i] == 1) {
                                    redScore++;
                                }
                                if (edgeList[i] == 2) {
                                    blueScore++;
                                }
                            }
                        }
                        if (edgeList[i - 1] != 0 && edgeList[i + 11 - t] != 0 && edgeList[i + 14 - t] != 0) {
                            if (edges.get(i).time > edges.get(i - 1).time && edges.get(i).time > edges.get(i + 11 - t).time && edges.get(i).time > edges.get(i + 14 - t).time) {
                                currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                if (edgeList[i] == 1) {
                                    redScore++;
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
                                currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                if (edgeList[i] == 1) {
                                    redScore++;
                                }
                                if (edgeList[i] == 2) {
                                    blueScore++;
                                }
                            }
                        }
                        if (edgeList[i - 1] != 0 && edgeList[i + 11 - t] != 0 && edgeList[i + 14 - t] != 0) {
                            if (edges.get(i).time > edges.get(i - 1).time && edges.get(i).time > edges.get(i + 11 - t).time && edges.get(i).time > edges.get(i + 14 - t).time) {
                                currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                if (edgeList[i] == 1) {
                                    redScore++;
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
                                currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                if (edgeList[i] == 1) {
                                    redScore++;
                                }
                                if (edgeList[i] == 2) {
                                    blueScore++;
                                }
                            }
                        }
                    }
                } else if (i < edges.size()) {
                    if (i <= 14) {
                        if (edgeList[i - 12] != 0 && edgeList[i - 11] != 0 && edgeList[i + 3] != 0) {
                            if (edges.get(i).time > edges.get(i - 12).time && edges.get(i).time > edges.get(i - 11).time && edges.get(i).time > edges.get(i + 3).time) {
                                currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                if (edgeList[i] == 1) {
                                    redScore++;
                                }
                                if (edgeList[i] == 2) {
                                    blueScore++;
                                }
                            }
                        }
                    } else if (i <= 17) {//.find sequence??
                        if (edgeList[i - 12 + 1] != 0 && edgeList[i - 11 + 1] != 0 && edgeList[i + 3] != 0) {
                            if (edges.get(i).time > edges.get(i - 12 + 1).time && edges.get(i).time > edges.get(i - 11 + 1).time && edges.get(i).time > edges.get(i + 3).time) {
                                currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                if (edgeList[i] == 1) {
                                    redScore++;
                                }
                                if (edgeList[i] == 2) {
                                    blueScore++;
                                }
                            }
                        }
                        if (edgeList[i - 15] != 0 && edgeList[i - 14] != 0 && edgeList[i - 3] != 0) {
                            if (edges.get(i).time > edges.get(i - 15).time && edges.get(i).time > edges.get(i - 14).time && edges.get(i).time > edges.get(i - 3).time) {
                                currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                if (edgeList[i] == 1) {
                                    redScore++;
                                }
                                if (edgeList[i] == 2) {
                                    blueScore++;
                                }
                            }
                        }
                    } else if (i <= 20) {
                        if (edgeList[i - 10] != 0 && edgeList[i - 9] != 0 && edgeList[i + 3] != 0) {
                            if (edges.get(i).time > edges.get(i - 10).time && edges.get(i).time > edges.get(i - 9).time && edges.get(i).time > edges.get(i + 3).time) {
                                currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                if (edgeList[i] == 1) {
                                    redScore++;
                                }
                                if (edgeList[i] == 2) {
                                    blueScore++;
                                }
                            }
                        }
                        if (edgeList[i - 14] != 0 && edgeList[i - 13] != 0 && edgeList[i - 3] != 0) {
                            if (edges.get(i).time > edges.get(i - 14).time && edges.get(i).time > edges.get(i - 13).time && edges.get(i).time > edges.get(i - 3).time) {
                                currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                if (edgeList[i] == 1) {
                                    redScore++;
                                }
                                if (edgeList[i] == 2) {
                                    blueScore++;
                                }
                            }
                        }
                    } else if (i <= 23) {
                        if (edgeList[i - 13] != 0 && edgeList[i - 12] != 0 && edgeList[i - 3] != 0) {
                            if (edges.get(i).time > edges.get(i - 13).time && edges.get(i).time > edges.get(i - 12).time && edges.get(i).time > edges.get(i - 3).time) {
                                currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                if (edgeList[i] == 1) {
                                    redScore++;
                                }
                                if (edgeList[i] == 2) {
                                    blueScore++;
                                }
                            }
                        }
                    }
                }

                foundEdge = true; // Avoid multiple selections.
            } else {
                edges.get(i).setVisible(false);
            }
        }

    }
    public void update5EVE() {
        Point mousePoint = new Point((int) StdDraw.mouseX(), (int) StdDraw.mouseY());
        boolean isMousePressed = StdDraw.isMousePressed();
        boolean foundEdge = false;//.?
        for (int i = 0; i < edges.size(); i++) {  //Edge edge : edges)
            if (edges.get(i).isFree()) { //.whether this edge has been pressed
                if (!foundEdge && edges.get(i).getBounds().contains(mousePoint)) {
                    edges.get(i).setColor(currentColor);
                    edges.get(i).setVisible(true);

                    if (isMousePressed) {
                        currentColor = currentColor == Color.RED ? Color.BLUE : Color.RED;//.exchange colour
                        edges.get(i).setFree(false);
                        edges.get(i).time = time;
                        time++;
                        if (currentColor == Color.BLUE) {//.this is red
                            edgeList[i] = 1;
                        }
                        if (currentColor == Color.RED) {//.this is blue
                            edgeList[i] = 2;
                        }
                        if (i < edges.size() / 2) {
                            if (i % 4 == 0) {
                                int t = i / 4;
                                if (edgeList[i + 1] != 0 && edgeList[i + 12 - t] != 0 && edgeList[i + 15 - t] != 0) {
                                    if (edges.get(i).time > edges.get(i + 1).time && edges.get(i).time > edges.get(i + 12 - t).time && edges.get(i).time > edges.get(i + 15 - t).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
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
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                                if (edgeList[i - 1] != 0 && edgeList[i + 11 - t] != 0 && edgeList[i + 14 - t] != 0) {
                                    if (edges.get(i).time > edges.get(i - 1).time && edges.get(i).time > edges.get(i + 11 - t).time && edges.get(i).time > edges.get(i + 14 - t).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
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
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                                if (edgeList[i - 1] != 0 && edgeList[i + 11 - t] != 0 && edgeList[i + 14 - t] != 0) {
                                    if (edges.get(i).time > edges.get(i - 1).time && edges.get(i).time > edges.get(i + 11 - t).time && edges.get(i).time > edges.get(i + 14 - t).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
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
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                            }
                        } else if (i < edges.size()) {
                            if (i <= 14) {
                                if (edgeList[i - 12] != 0 && edgeList[i - 11] != 0 && edgeList[i + 3] != 0) {
                                    if (edges.get(i).time > edges.get(i - 12).time && edges.get(i).time > edges.get(i - 11).time && edges.get(i).time > edges.get(i + 3).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                            } else if (i <= 17) {//.find sequence??
                                if (edgeList[i - 12 + 1] != 0 && edgeList[i - 11 + 1] != 0 && edgeList[i + 3] != 0) {
                                    if (edges.get(i).time > edges.get(i - 12 + 1).time && edges.get(i).time > edges.get(i - 11 + 1).time && edges.get(i).time > edges.get(i + 3).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                                if (edgeList[i - 15] != 0 && edgeList[i - 14] != 0 && edgeList[i - 3] != 0) {
                                    if (edges.get(i).time > edges.get(i - 15).time && edges.get(i).time > edges.get(i - 14).time && edges.get(i).time > edges.get(i - 3).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                            } else if (i <= 20) {
                                if (edgeList[i - 10] != 0 && edgeList[i - 9] != 0 && edgeList[i + 3] != 0) {
                                    if (edges.get(i).time > edges.get(i - 10).time && edges.get(i).time > edges.get(i - 9).time && edges.get(i).time > edges.get(i + 3).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                                if (edgeList[i - 14] != 0 && edgeList[i - 13] != 0 && edgeList[i - 3] != 0) {
                                    if (edges.get(i).time > edges.get(i - 14).time && edges.get(i).time > edges.get(i - 13).time && edges.get(i).time > edges.get(i - 3).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                            } else if (i <= 23) {
                                if (edgeList[i - 13] != 0 && edgeList[i - 12] != 0 && edgeList[i - 3] != 0) {
                                    if (edges.get(i).time > edges.get(i - 13).time && edges.get(i).time > edges.get(i - 12).time && edges.get(i).time > edges.get(i - 3).time) {
                                        currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                                        if (edgeList[i] == 1) {
                                            redScore++;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    foundEdge = true; // Avoid multiple selections.
                } else {
                    edges.get(i).setVisible(false);
                }
            }
        }
    }

    public void paint3PVP() {
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
        }
        StdDraw.show();
    }
    public void paint4PVP() {
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
        }
        StdDraw.show();
    }
    public void paint5PVP() {
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
        }
        StdDraw.show();
    }

    public void paint3PVE() {
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
        }
        StdDraw.show();
    }
    public void paint4PVE() {
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
        }
        StdDraw.show();
    }
    public void paint5PVE() {
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
        }
        StdDraw.show();
    }

    public void paint3EVE() {
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
        }
        StdDraw.show();
    }
    public void paint4EVE() {
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
        }
        StdDraw.show();
    }
    public void paint5EVE() {
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
        }
        StdDraw.show();
    }



    public void jiemian() {

        JFrame CK = new JFrame();//新建窗口
        CK.setLayout(null);//设为空


        JButton Start = new JButton("开始游戏");
        JButton Sets = new JButton("设定");
        JLabel Headline = new JLabel("DotsBoxeswo");

        CK.setBounds(400, 150, 400, 400);
        Start.setBounds(150, 40, 100, 50);
        Sets.setBounds(150, 100, 100, 50);
        Headline.setBounds(150, 5, 100, 50);

        CK.add(Start);
        CK.add(Sets);
        CK.add(Headline);


        //CK.setBackground(Color.BLUE);
        CK.setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Start.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        Sets.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.exit(0);
                //setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
                // Interface a = new Interface();
                CK.setVisible(false);
                JFrame CK2 = new JFrame();
                CK2.setVisible(true);
                setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

                CK2.setLayout(null);//设为空

                CK2.setBounds(400, 150, 400, 400);

                JLabel size = new JLabel("请选择游戏大小");
                size.setBounds(100, 35, 200, 100);
                size.setHorizontalAlignment(SwingConstants.CENTER);
                CK2.add(size);

                /*JButton next = new JButton("下一步");
                next.setBounds(260, 300, 80, 30);
                CK2.add(next);*/
                JButton last = new JButton(("上一步"));
                last.setBounds(60, 300, 80, 30);
                CK2.add(last);


                JRadioButton left = new JRadioButton("3 * 3");
                JRadioButton middle = new JRadioButton("4 * 4");
                JRadioButton right = new JRadioButton("5 * 5");

                left.setBounds(150, 120, 100, 30);
                middle.setBounds(150, 160, 100, 30);
                right.setBounds(150, 200, 100, 30);

                Font f = new Font("FZkai-Z03S", Font.ITALIC, 20);
                left.setFont(f);
                middle.setFont(f);
                right.setFont(f);
                size.setFont(f);
                // Headline.setFont(f);

                CK2.add(left);
                CK2.add(middle);
                CK2.add(right);

                ButtonGroup group = new ButtonGroup();//按钮组
                group.add(left);//把按钮放在按钮组中
                group.add(middle);
                group.add(right);
                //left.setSelected(true);
                left.addActionListener(new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {{
                        gamesize = 33;
                            CK2.setVisible(false);
                            JFrame CK3 = new JFrame();
                            CK3.setVisible(true);
                            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

                            CK3.setLayout(null);//设为空

                            CK3.setBounds(400, 150, 400, 400);

                            JLabel size = new JLabel("请选择玩法");
                            size.setBounds(100, 35, 200, 100);
                            size.setHorizontalAlignment(SwingConstants.CENTER);
                            CK3.add(size);

                            JButton back = new JButton("返回首页");
                            JButton last = new JButton(("上一步"));
                            back.setBounds(250, 300, 100, 30);
                            last.setBounds(60, 300, 80, 30);
                            CK3.add(back);
                            CK3.add(last);

                            JButton PVP = new JButton("人与人");
                            JButton PVE = new JButton("人与电脑");
                            JButton EVE = new JButton("电脑与电脑");

                            PVP.setBounds(150, 120, 100, 35);
                            PVE.setBounds(150, 160, 100, 35);
                            EVE.setBounds(150, 200, 100, 35);

                            CK3.add(PVP);
                            CK3.add(PVE);
                            CK3.add(EVE);

                            last.addActionListener(new AbstractAction() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    CK3.setVisible(false);
                                    CK2.setVisible(true);
                                    CK3.dispose();
                                }
                            });
                            back.addActionListener(new AbstractAction() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    CK3.setVisible(false);
                                    CK.setVisible(true);
                                    CK3.dispose();
                                }
                            });
                            PVP.addActionListener(new AbstractAction() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    int size=4;
                                    new Thread(()-> PVP33.run(size)).start();
                                }
                            });
                            PVE.addActionListener(new AbstractAction() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    int size=4;
                                    new Thread(()-> PVE33.run(size)).start();
                                }
                            });
                            EVE.addActionListener(new AbstractAction() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    int size=4;
                                    new Thread(()-> EVE33.run(size)).start();
                                }
                            });
                        }}
                });
                middle.addActionListener(new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {{
                        gamesize =44;
                        CK2.setVisible(false);
                        JFrame CK3 = new JFrame();
                        CK3.setVisible(true);
                        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

                        CK3.setLayout(null);//设为空

                        CK3.setBounds(400, 150, 400, 400);

                        JLabel size = new JLabel("请选择玩法");
                        size.setBounds(100, 35, 200, 100);
                        size.setHorizontalAlignment(SwingConstants.CENTER);
                        CK3.add(size);

                        JButton back = new JButton("返回首页");
                        JButton last = new JButton(("上一步"));
                        back.setBounds(250, 300, 100, 30);
                        last.setBounds(60, 300, 80, 30);
                        CK3.add(back);
                        CK3.add(last);

                        JButton PVP = new JButton("人与人");
                        JButton PVE = new JButton("人与电脑");
                        JButton EVE = new JButton("电脑与电脑");

                        PVP.setBounds(150, 120, 100, 35);
                        PVE.setBounds(150, 160, 100, 35);
                        EVE.setBounds(150, 200, 100, 35);

                        CK3.add(PVP);
                        CK3.add(PVE);
                        CK3.add(EVE);

                        last.addActionListener(new AbstractAction() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                CK3.setVisible(false);
                                CK2.setVisible(true);
                                CK3.dispose();
                            }
                        });
                        back.addActionListener(new AbstractAction() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                CK3.setVisible(false);
                                CK.setVisible(true);
                                CK3.dispose();
                            }
                        });
                        PVP.addActionListener(new AbstractAction() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                int size=4;
                                new Thread(()-> PVP44.run(size)).start();
                            }
                        });
                        PVE.addActionListener(new AbstractAction() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                int size=4;
                                new Thread(()-> PVE44.run(size)).start();
                            }
                        });
                        EVE.addActionListener(new AbstractAction() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                int size=4;
                                new Thread(()-> EVE44.run(size)).start();
                            }
                        });
                    }}
                });
                right.addActionListener(new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {{
                        gamesize = 55;
                        CK2.setVisible(false);
                        JFrame CK3 = new JFrame();
                        CK3.setVisible(true);
                        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

                        CK3.setLayout(null);//设为空

                        CK3.setBounds(400, 150, 400, 400);

                        JLabel size = new JLabel("请选择玩法");
                        size.setBounds(100, 35, 200, 100);
                        size.setHorizontalAlignment(SwingConstants.CENTER);
                        CK3.add(size);

                        JButton back = new JButton("返回首页");
                        JButton last = new JButton(("上一步"));
                        back.setBounds(250, 300, 100, 30);
                        last.setBounds(60, 300, 80, 30);
                        CK3.add(back);
                        CK3.add(last);

                        JButton PVP = new JButton("人与人");
                        JButton PVE = new JButton("人与电脑");
                        JButton EVE = new JButton("电脑与电脑");

                        PVP.setBounds(150, 120, 100, 35);
                        PVE.setBounds(150, 160, 100, 35);
                        EVE.setBounds(150, 200, 100, 35);

                        CK3.add(PVP);
                        CK3.add(PVE);
                        CK3.add(EVE);

                        last.addActionListener(new AbstractAction() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                CK3.setVisible(false);
                                CK2.setVisible(true);
                                CK3.dispose();
                            }
                        });
                        back.addActionListener(new AbstractAction() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                CK3.setVisible(false);
                                CK.setVisible(true);
                                CK3.dispose();
                            }
                        });
                        PVP.addActionListener(new AbstractAction() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                int size=4;
                                new Thread(()-> PVP55.run(size)).start();
                            }
                        });
                        PVE.addActionListener(new AbstractAction() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                int size=4;
                                new Thread(()-> PVE55.run(size)).start();
                            }
                        });
                        EVE.addActionListener(new AbstractAction() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                int size=4;
                                new Thread(()-> EVE55.run(size)).start();
                            }
                        });
                    }}
                });

                last.addActionListener(new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        CK2.setVisible(false);
                        CK.setVisible(true);
                        CK2.dispose();
                    }
                });

                /*next.addActionListener(new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {


                    }
                });*/

            }


        });



    }

    public static void main(String[] args) {
       All a = new All();
       a.jiemian();
    }

    public void PVP33(){
        All game = new All();

        while (true) {
            game.update3PVP();
            game.paint3PVP();//.start to draw
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();//.if bugging,it shows reasons,instead of stopping.
            }
        }
    }
    public void PVP44(){

        while (true) {
            update4PVP();
            paint4PVP();//.start to draw
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();//.if bugging,it shows reasons,instead of stopping.
            }
        }}
    public void PVP55(){All game = new All();

        while (true) {
            game.update5PVP();
            game.paint5PVP();//.start to draw
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();//.if bugging,it shows reasons,instead of stopping.
            }
        }}

    public void PVE33(){All game = new All();

        while (true) {
            game.update3PVE();
            game.paint3PVE();//.start to draw
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();//.if bugging,it shows reasons,instead of stopping.
            }
        }}
    public void PVE44(){All game = new All();

        while (true) {
            game.update4PVE();
            game.paint4PVE();//.start to draw
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();//.if bugging,it shows reasons,instead of stopping.
            }
        }}
    public void PVE55(){All game = new All();

        while (true) {
            game.update5PVE();
            game.paint5PVE();//.start to draw
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();//.if bugging,it shows reasons,instead of stopping.
            }
        }}

    public void EVE33(){
        All game = new All();

        while (true) {
            game.update3EVE();
            game.paint3EVE();//.start to draw
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();//.if bugging,it shows reasons,instead of stopping.
            }
        }
    }
    public void EVE44(){ All game = new All();

        while (true) {
            game.update4EVE();
            game.paint4EVE();//.start to draw
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();//.if bugging,it shows reasons,instead of stopping.
            }
        }}
    public void EVE55(){ All game = new All();

        while (true) {
            game.update5EVE();
            game.paint5EVE();//.start to draw
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();//.if bugging,it shows reasons,instead of stopping.
            }
        }}

    /*public static void run(int size) {
        All game = new All(700, 700);
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
    }*/
}
