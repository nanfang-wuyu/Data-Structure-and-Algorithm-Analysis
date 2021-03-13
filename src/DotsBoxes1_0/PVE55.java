package DotsBoxes1_0;

import demo1.Dot;
import demo1.Edge;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class PVE55 {
    //    private List<Edge> edges = new ArrayList<>();
//    private List<Dot> dots = new ArrayList<>();
    static int time = 0;
    private ArrayList<Edge> edges = new ArrayList<>();//.edges
    private ArrayList<Dot> dots = new ArrayList<>();//.dots
    private Color currentColor = Color.RED;//.1st.red & 2nd.blue
    int[] edgeList = new int[40];
    int redScore = 0;
    int blueScore = 0;
    boolean gamefinish = false;

    public PVE55(int canvasWidth, int canvasHeight) { //.canvas:a piece of cloth
        StdDraw.setCanvasSize(canvasWidth, canvasHeight);
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 1200);
        StdDraw.setYscale(0, 1000);//.to achieve symmetric DotsBoxes: setXscale & setYscale(0,4i)
        initialize();
    }


    public void initialize() {
        for(int i =0;i <= 3;i++){
            for(int j =0;j <= 4;j++){
                edges.add(new Edge(75+150*i,70+150*j,150,10));
            }
        }
        for(int i = 0;i <= 4;i++){
            for (int j = 0;j <= 3;j++){
                edges.add(new Edge(70+150*i,75+150*j,10,150));
            }
        }
        System.out.println("Choose the dotColor,please input red, green, blue:");
        Scanner in = new Scanner(System.in);
        int red = in.nextInt();
        int green = in.nextInt();
        int blue = in.nextInt();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dots.add(new Dot(75 + 150 * i, 75 + 150 * j, 15,red,green,blue));
            }
        }

        for (int i = 0; i < 40; i++) {
            edgeList[i] = 0;
        }
    }

    public void update() {
        boolean E = true;
        boolean jia = false;
        boolean up = false;
        boolean foundEdge = false;
        Point mousePoint = new Point((int) StdDraw.mouseX(), (int) StdDraw.mouseY());
        boolean isMousePressed = StdDraw.isMousePressed();
        //.?
        for (int i = 0; i < edges.size(); i++) {  //Edge edge : edges)
            if (edges.get(i).isFree()) { //.whether this edge has been pressed
                if (!foundEdge && edges.get(i).getBounds().contains(mousePoint)) {
                    edges.get(i).setColor(currentColor);
                    edges.get(i).setVisible(true);

                    if (isMousePressed) {
                        up = true;
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
                            if (i % 5 == 0) {
                                int t = i / 5;
                                if (edgeList[i + 1] != 0 && edgeList[i + 20 - t] != 0 && edgeList[i + 24 - t] != 0) {
                                    if (edges.get(i).time > edges.get(i + 1).time && edges.get(i).time > edges.get(i + 20 - t).time && edges.get(i).time > edges.get(i + 24 - t).time) {
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
                            if(i % 5 == 4){
                                int t = (int) Math.floor(i / 5);
                                if (edgeList[i - 1] != 0 && edgeList[i + 19 - t] != 0 && edgeList[i + 23 - t] != 0) {
                                    if (edges.get(i).time > edges.get(i - 1).time && edges.get(i).time > edges.get(i + 19 - t).time && edges.get(i).time > edges.get(i + 23 - t).time) {
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
                            if(i % 5 == 1 || i % 5 ==2 || i % 5 == 3) {
                                int t = (int) Math.floor(i / 5);
                                if (edgeList[i + 1] != 0 && edgeList[i + 20 - t] != 0 && edgeList[i + 24 - t] != 0) {
                                    if (edges.get(i).time > edges.get(i + 1).time && edges.get(i).time > edges.get(i + 20 - t).time && edges.get(i).time > edges.get(i + 24 - t).time) {
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
                                if (edgeList[i - 1] != 0 && edgeList[i + 19 - t] != 0 && edgeList[i + 23 - t] != 0) {
                                    if (edges.get(i).time > edges.get(i - 1).time && edges.get(i).time > edges.get(i + 19 - t).time && edges.get(i).time > edges.get(i + 23 - t).time) {
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
                        }else if (i < edges.size()) {
                            if (i <= 23) {
                                if (edgeList[i - 20] != 0 && edgeList[i - 19] != 0 && edgeList[i + 4] != 0) {
                                    if (edges.get(i).time > edges.get(i - 20).time && edges.get(i).time > edges.get(i - 19).time && edges.get(i).time > edges.get(i + 4).time) {
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
                            if(i <= 39 && i > 35){
                                if (edgeList[i - 21] != 0 && edgeList[i - 20] != 0 && edgeList[i - 4] != 0) {
                                    if (edges.get(i).time > edges.get(i - 21).time && edges.get(i).time > edges.get(i - 20).time && edges.get(i).time > edges.get(i - 4).time) {
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
                            if(i <= 35 && i > 23){
                                int t = (int)Math.floor((i-20)/4);
                                if (edgeList[i - 20 + t] != 0 && edgeList[i - 19 + t] != 0 && edgeList[i + 4] != 0) {
                                    if (edges.get(i).time > edges.get(i - 20 + t).time && edges.get(i).time > edges.get(i -19 + t).time && edges.get(i).time > edges.get(i + 4).time) {
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
                                if (edgeList[i - 25 + t] != 0 && edgeList[i - 24 + t] != 0 && edgeList[i - 4] != 0) {
                                    if (edges.get(i).time > edges.get(i - 25 + t).time && edges.get(i).time > edges.get(i - 24 + t).time && edges.get(i).time > edges.get(i - 4).time) {
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

            int i = j.nextInt(40);
            do{i = j.nextInt(40);}while (!edges.get(i).isFree());

            if (edges.get(i).isFree()) { //.whether this edge has been pressed
                if (!foundEdge) {
                    edges.get(i).setColor(currentColor);
                    edges.get(i).setVisible(true);

                    {
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
                            if (i % 5 == 0) {
                                int t = i / 5;
                                if (edgeList[i + 1] != 0 && edgeList[i + 20 - t] != 0 && edgeList[i + 24 - t] != 0) {
                                    if (edges.get(i).time > edges.get(i + 1).time && edges.get(i).time > edges.get(i + 20 - t).time && edges.get(i).time > edges.get(i + 24 - t).time) {
                                        jia = true;
                                        if (edgeList[i] == 1) {
                                            redScore++;P = false;

                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                            }
                            if(i % 5 == 4){
                                int t = (int) Math.floor(i / 5);
                                if (edgeList[i - 1] != 0 && edgeList[i + 19 - t] != 0 && edgeList[i + 23 - t] != 0) {
                                    if (edges.get(i).time > edges.get(i - 1).time && edges.get(i).time > edges.get(i + 19 - t).time && edges.get(i).time > edges.get(i + 23 - t).time) {
                                        jia = true;
                                        if (edgeList[i] == 1) {
                                            redScore++;P = false;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                            }
                            if(i % 5 == 1 || i % 5 ==2 || i % 5 == 3) {
                                int t = (int) Math.floor(i / 5);
                                if (edgeList[i + 1] != 0 && edgeList[i + 20 - t] != 0 && edgeList[i + 24 - t] != 0) {
                                    if (edges.get(i).time > edges.get(i + 1).time && edges.get(i).time > edges.get(i + 20 - t).time && edges.get(i).time > edges.get(i + 24 - t).time) {
                                        jia = true;
                                        if (edgeList[i] == 1) {
                                            redScore++;P = false;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                                if (edgeList[i - 1] != 0 && edgeList[i + 19 - t] != 0 && edgeList[i + 23 - t] != 0) {
                                    if (edges.get(i).time > edges.get(i - 1).time && edges.get(i).time > edges.get(i + 19 - t).time && edges.get(i).time > edges.get(i + 23 - t).time) {
                                        jia = true;
                                        if (edgeList[i] == 1) {
                                            redScore++;P = false;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                            }
                        }else if (i < edges.size()) {
                            if (i <= 23) {
                                if (edgeList[i - 20] != 0 && edgeList[i - 19] != 0 && edgeList[i + 4] != 0) {
                                    if (edges.get(i).time > edges.get(i - 20).time && edges.get(i).time > edges.get(i - 19).time && edges.get(i).time > edges.get(i + 4).time) {
                                        jia = true;
                                        if (edgeList[i] == 1) {
                                            redScore++;P = false;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                            }
                            if(i <= 39 && i > 35){
                                if (edgeList[i - 21] != 0 && edgeList[i - 20] != 0 && edgeList[i - 4] != 0) {
                                    if (edges.get(i).time > edges.get(i - 21).time && edges.get(i).time > edges.get(i - 20).time && edges.get(i).time > edges.get(i - 4).time) {
                                        jia = true;
                                        if (edgeList[i] == 1) {
                                            redScore++;P = false;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                            }
                            if(i <= 35 && i > 23){
                                int t = (int)Math.floor((i-20)/4);
                                if (edgeList[i - 20 + t] != 0 && edgeList[i - 19 + t] != 0 && edgeList[i + 4] != 0) {
                                    if (edges.get(i).time > edges.get(i - 20 + t).time && edges.get(i).time > edges.get(i -19 + t).time && edges.get(i).time > edges.get(i + 4).time) {
                                        jia = true;
                                        if (edgeList[i] == 1) {
                                            redScore++;P = false;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                                if (edgeList[i - 25 + t] != 0 && edgeList[i - 24 + t] != 0 && edgeList[i - 4] != 0) {
                                    if (edges.get(i).time > edges.get(i - 25 + t).time && edges.get(i).time > edges.get(i - 24 + t).time && edges.get(i).time > edges.get(i - 4).time) {
                                        jia = true;
                                        if (edgeList[i] == 1) {
                                            redScore++;P = false;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                            }
                        }
                        if(jia == true){currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;}
                        foundEdge = true;
                    }
                }else{
                    edges.get(i).setVisible(false);
                }
            }
            boolean finish = true;
            for (int n = 0; n < edges.size(); n++){
                if (edges.get(n).isFree()) {finish = false;}}

            if(P == false&&finish == false){update2();
            }
        }
    }

    public void paint() {
        StdDraw.clear();//.to initialize the canvas
        StdDraw.setFont(new Font("times new Roman", Font.ITALIC, 30));
        // Paint edges first, so dots will be on the top layer.
        StdDraw.text(225, 800, "Play Dots and Boxes!");
        String text = (currentColor == Color.RED) ? "Red player's turn" : "Blue player's turn";
        StdDraw.text(900, 400, text);
        StdDraw.text(950, 700, "Score(Novice)");
        StdDraw.text(800, 625, "Red:");
        StdDraw.text(800, 550, "Blue:");
        StdDraw.text(950, 625, String.valueOf(redScore));
        StdDraw.text(950, 550, String.valueOf(blueScore));

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
                if (i % 5 == 0) {
                    int t = i / 5;
                    if (edgeList[i + 1] != 0 && edgeList[i + 20 - t] != 0 && edgeList[i + 24 - t] != 0) {
                        if (edges.get(i).time > edges.get(i + 1).time && edges.get(i).time > edges.get(i + 20 - t).time && edges.get(i).time > edges.get(i + 24 - t).time) {
                            if (edgeList[i] == 1) {
                                StdDraw.text(150 + 150 * t, 150, "RED");
                            }
                            if (edgeList[i] == 2) {
                                StdDraw.text(150 + 150 * t, 150, "BLUE");
                            }
                        }
                    }
                }
                if(i % 5 == 4){
                    int t = (int) Math.floor(i / 5);
                    if (edgeList[i - 1] != 0 && edgeList[i + 19 - t] != 0 && edgeList[i + 23 - t] != 0) {
                        if (edges.get(i).time > edges.get(i - 1).time && edges.get(i).time > edges.get(i + 19 - t).time && edges.get(i).time > edges.get(i + 23 - t).time) {
                            if (edgeList[i] == 1) {
                                StdDraw.text(150 + 150 * t, 600, "RED");
                            }
                            if (edgeList[i] == 2) {
                                StdDraw.text(150 + 150 * t, 600, "BLUE");
                            }
                        }
                    }
                }
                if(i % 5 == 1 || i % 5 ==2 || i % 5 == 3) {
                    int t = (int) Math.floor(i / 5);
                    if (edgeList[i + 1] != 0 && edgeList[i + 20 - t] != 0 && edgeList[i + 24 - t] != 0) {
                        if (edges.get(i).time > edges.get(i + 1).time && edges.get(i).time > edges.get(i + 20 - t).time && edges.get(i).time > edges.get(i + 24 - t).time) {
                            if (edgeList[i] == 1) {
                                StdDraw.text(150 + 150 * t, 150+150*(i % 5), "RED");
                            }
                            if (edgeList[i] == 2) {
                                StdDraw.text(150 + 150 * t, 150+150*(i % 5), "BLUE");
                            }
                        }
                    }
                    if (edgeList[i - 1] != 0 && edgeList[i + 19 - t] != 0 && edgeList[i + 23 - t] != 0) {
                        if (edges.get(i).time > edges.get(i - 1).time && edges.get(i).time > edges.get(i + 19 - t).time && edges.get(i).time > edges.get(i + 23 - t).time) {
                            if (edgeList[i] == 1) {
                                StdDraw.text(150 + 150 * t, 150+150*(i % 5 - 1), "RED");
                            }
                            if (edgeList[i] == 2) {
                                StdDraw.text(150 + 150 * t, 150+150*(i % 5 - 1), "BLUE");
                            }
                        }
                    }
                }
            }
        }
        for (int i = edges.size() / 2; i < edges.size(); i++) {
            if (edgeList[i] != 0) {
                if (i <= 23) {
                    if (edgeList[i - 20] != 0 && edgeList[i - 19] != 0 && edgeList[i + 4] != 0) {
                        if (edges.get(i).time > edges.get(i - 20).time && edges.get(i).time > edges.get(i - 19).time && edges.get(i).time > edges.get(i + 4).time) {
                            if (edgeList[i] == 1) {
                                StdDraw.text(150, 150 + 150 * (i - edges.size() / 2), "RED");
                            }
                            if (edgeList[i] == 2) {
                                StdDraw.text(150, 150 + 150 * (i - edges.size() / 2), "BLUE");
                            }
                        }
                    }
                }
                if(i <= 39 && i > 35){
                    if (edgeList[i - 21] != 0 && edgeList[i - 20] != 0 && edgeList[i - 4] != 0) {
                        if (edges.get(i).time > edges.get(i - 21).time && edges.get(i).time > edges.get(i - 20).time && edges.get(i).time > edges.get(i - 4).time) {
                            if (edgeList[i] == 1) {
                                StdDraw.text(600, 150 + 150 * (i - 16 - edges.size() / 2), "RED");
                            }
                            if (edgeList[i] == 2) {
                                StdDraw.text(600, 150 + 150 * (i - 16 - edges.size() / 2), "BLUE");
                            }
                        }
                    }
                }
                if(i <= 35 && i > 23){
                    int t = (int)Math.floor((i-20)/4);
                    if (edgeList[i - 20 + t] != 0 && edgeList[i - 19 + t] != 0 && edgeList[i + 4] != 0) {
                        if (edges.get(i).time > edges.get(i - 20 + t).time && edges.get(i).time > edges.get(i -19 + t).time && edges.get(i).time > edges.get(i + 4).time) {
                            if (edgeList[i] == 1) {
                                StdDraw.text(150 + 150*t, 150 + 150 * (i - 4*t - edges.size() / 2), "RED");
                            }
                            if (edgeList[i] == 2) {
                                StdDraw.text(150 + 150*t, 150 + 150 * (i - 4*t - edges.size() / 2), "BLUE");
                            }
                        }
                    }
                    if (edgeList[i - 25 + t] != 0 && edgeList[i - 24 + t] != 0 && edgeList[i - 4] != 0) {
                        if (edges.get(i).time > edges.get(i - 25 + t).time && edges.get(i).time > edges.get(i - 24 + t).time && edges.get(i).time > edges.get(i - 4).time) {
                            if (edgeList[i] == 1) {
                                StdDraw.text(150 + 150*(t-1), 150 + 150 * (i - 4*t - edges.size() / 2), "RED");
                            }
                            if (edgeList[i] == 2) {
                                StdDraw.text(150 + 150*(t-1), 150 + 150 * (i - 4*t - edges.size() / 2), "BLUE");
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
                StdDraw.text(300, 725, "Game over, no winner");
            } else if (redScore > blueScore) {
                StdDraw.text(300, 725, "Game over, Red player is winner!");
            } else if (redScore < blueScore) {
                StdDraw.text(300, 725, "Game over, Blue player is winner!");
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
        PVE55 game = new PVE55(800, 800);

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
        PVE55 game = new PVE55(700, 700);
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

