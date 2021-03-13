package demo1;

import java.awt.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PVE33 {
    //    private List<Edge> edges = new ArrayList<>();
//    private List<Dot> dots = new ArrayList<>();
    static int time = 0;
    private ArrayList<Edge> edges = new ArrayList<>();//.edges
    private ArrayList<Dot> dots = new ArrayList<>();//.dots
    private Color currentColor = Color.RED;//.1st.red & 2nd.blue
    int[] edgeList = new int[12];
    int redScore = 0;
    int blueScore = 0;
    boolean gamefinish = false;

    public PVE33(int canvasWidth, int canvasHeight) { //.canvas:a piece of cloth
        StdDraw.setCanvasSize(canvasWidth, canvasHeight);
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 1200);
        StdDraw.setYscale(0, 1000);//.to achieve symmetric DotsBoxes: setXscale & setYscale(0,4i)
        initialize();
    }


    public void initialize() {
        System.out.println("Choose the dotColor,please input red, green, blue:");
        Scanner in = new Scanner(System.in);
        int red = in.nextInt();
        int green = in.nextInt();
        int blue = in.nextInt();
        for(int i =0;i <= 1;i++){
            for(int j =0;j <= 2;j++){
                edges.add(new Edge(75+150*i,70+150*j,150,10));
            }
        }
        for(int i = 0;i <= 2;i++){
            for (int j = 0;j <= 1;j++){
                edges.add(new Edge(70+150*i,75+150*j,10,150));
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                dots.add(new Dot(75 + 150 * i, 75 + 150 * j, 15,red,green,blue));
            }
        }

        for (int i = 0; i < 12; i++) {
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
        for (int i = 0; i < edges.size(); i++) {  //Edge edge : edges)
            if (edges.get(i).isFree())
            { //.whether this edge has been pressed
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
                            if (i % 3 == 0) {
                                int t = i / 3;
                                if (edgeList[i + 1] != 0 && edgeList[i + 6 - t] != 0 && edgeList[i + 8 - t] != 0) {
                                    if (edges.get(i).time > edges.get(i + 1).time && edges.get(i).time > edges.get(i + 6 - t).time && edges.get(i).time > edges.get(i + 8 - t).time) {
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
                            if(i % 3 == 2){
                                int t = (int) Math.floor(i / 3);
                                if (edgeList[i - 1] != 0 && edgeList[i + 5 - t] != 0 && edgeList[i + 7 - t] != 0) {
                                    if (edges.get(i).time > edges.get(i - 1).time && edges.get(i).time > edges.get(i + 5 - t).time && edges.get(i).time > edges.get(i + 7 - t).time) {
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
                            if(i % 3 == 1) {
                                int t = (int) Math.floor(i / 3);
                                if (edgeList[i + 1] != 0 && edgeList[i + 6 - t] != 0 && edgeList[i + 8 - t] != 0) {
                                    if (edges.get(i).time > edges.get(i + 1).time && edges.get(i).time > edges.get(i + 6 - t).time && edges.get(i).time > edges.get(i + 8 - t).time) {
                                        jia = true;
                                        if (edgeList[i] == 1) {
                                            redScore++;E = false;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                                if (edgeList[i - 1] != 0 && edgeList[i + 5 - t] != 0 && edgeList[i + 7 - t] != 0) {
                                    if (edges.get(i).time > edges.get(i - 1).time && edges.get(i).time > edges.get(i + 5 - t).time && edges.get(i).time > edges.get(i + 7 - t).time) {
                                        jia = true;
                                        if (edgeList[i] == 1) {
                                            redScore++;E = false;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                            }
                        }
                        else if(i < edges.size()){
                            if (i <= 7) {
                                if (edgeList[i - 6] != 0 && edgeList[i - 5] != 0 && edgeList[i + 2] != 0) {
                                    if (edges.get(i).time > edges.get(i - 6).time && edges.get(i).time > edges.get(i - 5).time && edges.get(i).time > edges.get(i + 2).time) {
                                        jia = true;
                                        if (edgeList[i] == 1) {
                                            redScore++;E = false;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                            }
                            if(i <= 11 && i > 9){
                                if (edgeList[i - 7] != 0 && edgeList[i - 6] != 0 && edgeList[i - 2] != 0) {
                                    if (edges.get(i).time > edges.get(i - 7).time && edges.get(i).time > edges.get(i - 6).time && edges.get(i).time > edges.get(i - 2).time) {
                                        jia = true;
                                        if (edgeList[i] == 1) {
                                            redScore++;E = false;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                            }
                            if(i <= 9 && i > 7){
                                int t = (int)Math.floor((i-6)/2);
                                if (edgeList[i - 6 + t] != 0 && edgeList[i - 5 + t] != 0 && edgeList[i + 2] != 0) {
                                    if (edges.get(i).time > edges.get(i - 6 + t).time && edges.get(i).time > edges.get(i - 5 + t).time && edges.get(i).time > edges.get(i + 2).time) {
                                        jia = true;
                                        if (edgeList[i] == 1) {
                                            redScore++;E = false;
                                        }
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                        }
                                    }
                                }
                                if (edgeList[i - 8 + t] != 0 && edgeList[i - 9 + t] != 0 && edgeList[i - 2] != 0) {
                                    if (edges.get(i).time > edges.get(i - 8 + t).time && edges.get(i).time > edges.get(i - 9 + t).time && edges.get(i).time > edges.get(i - 2).time) {
                                        jia = true;
                                        if (edgeList[i] == 1) {
                                            redScore++;E = false;
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

            int i = j.nextInt(12);
            do{i = j.nextInt(12);}while (!edges.get(i).isFree());

            if (edges.get(i).isFree()) { //.whether this edge has been pressed
                if (!foundEdge) {
                    edges.get(i).setColor(currentColor);
                    edges.get(i).setVisible(true);


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
                        if (i % 3 == 0) {
                            int t = i / 3;
                            if (edgeList[i + 1] != 0 && edgeList[i + 6 - t] != 0 && edgeList[i + 8 - t] != 0) {
                                if (edges.get(i).time > edges.get(i + 1).time && edges.get(i).time > edges.get(i + 6 - t).time && edges.get(i).time > edges.get(i + 8 - t).time) {
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
                        if (i % 3 == 2) {
                            int t = (int) Math.floor(i / 3);
                            if (edgeList[i - 1] != 0 && edgeList[i + 5 - t] != 0 && edgeList[i + 7 - t] != 0) {
                                if (edges.get(i).time > edges.get(i - 1).time && edges.get(i).time > edges.get(i + 5 - t).time && edges.get(i).time > edges.get(i + 7 - t).time) {
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
                        if (i % 3 == 1) {
                            int t = (int) Math.floor(i / 3);
                            if (edgeList[i + 1] != 0 && edgeList[i + 6 - t] != 0 && edgeList[i + 8 - t] != 0) {
                                if (edges.get(i).time > edges.get(i + 1).time && edges.get(i).time > edges.get(i + 6 - t).time && edges.get(i).time > edges.get(i + 8 - t).time) {
                                    jia = true;
                                    if (edgeList[i] == 1) {
                                        redScore++;
                                        if (edgeList[i] == 2) {
                                            blueScore++;
                                            P = false;
                                        }
                                    }
                                }
                                if (edgeList[i - 1] != 0 && edgeList[i + 5 - t] != 0 && edgeList[i + 7 - t] != 0) {
                                    if (edges.get(i).time > edges.get(i - 1).time && edges.get(i).time > edges.get(i + 5 - t).time && edges.get(i).time > edges.get(i + 7 - t).time) {
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
                    }else if (i < edges.size()) {
                            if (i <= 7) {
                                if (edgeList[i - 6] != 0 && edgeList[i - 5] != 0 && edgeList[i + 2] != 0) {
                                    if (edges.get(i).time > edges.get(i - 6).time && edges.get(i).time > edges.get(i - 5).time && edges.get(i).time > edges.get(i + 2).time) {
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
                            if (i <= 11 && i > 9) {
                                if (edgeList[i - 7] != 0 && edgeList[i - 6] != 0 && edgeList[i - 2] != 0) {
                                    if (edges.get(i).time > edges.get(i - 7).time && edges.get(i).time > edges.get(i - 6).time && edges.get(i).time > edges.get(i - 2).time) {
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
                            if (i <= 9 && i > 7) {
                                int t = (int) Math.floor((i - 6) / 2);
                                if (edgeList[i - 6 + t] != 0 && edgeList[i - 5 + t] != 0 && edgeList[i + 2] != 0) {
                                    if (edges.get(i).time > edges.get(i - 6 + t).time && edges.get(i).time > edges.get(i - 5 + t).time && edges.get(i).time > edges.get(i + 2).time) {
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
                                if (edgeList[i - 8 + t] != 0 && edgeList[i - 9 + t] != 0 && edgeList[i - 2] != 0) {
                                    if (edges.get(i).time > edges.get(i - 8 + t).time && edges.get(i).time > edges.get(i - 9 + t).time && edges.get(i).time > edges.get(i - 2).time) {
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
                        if (jia == true) {
                            currentColor = (currentColor == Color.RED) ? Color.BLUE : Color.RED;
                        }
                        foundEdge = true; // Avoid multiple selections.
                    } else {
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
                if (i % 3 == 0) {
                    int t = i / 3;
                    if (edgeList[i + 1] != 0 && edgeList[i + 6 - t] != 0 && edgeList[i + 8 - t] != 0) {
                        if (edges.get(i).time > edges.get(i + 1).time && edges.get(i).time > edges.get(i + 6 - t).time && edges.get(i).time > edges.get(i + 8 - t).time) {
                            if (edgeList[i] == 1) {
                                StdDraw.text(150 + 150 * t, 150, "RED");
                            }
                            if (edgeList[i] == 2) {
                                StdDraw.text(150 + 150 * t, 150, "BLUE");
                            }
                        }
                    }
                }
                if(i % 3 == 2){
                    int t = (int) Math.floor(i / 3);
                    if (edgeList[i - 1] != 0 && edgeList[i + 5 - t] != 0 && edgeList[i + 7 - t] != 0) {
                        if (edges.get(i).time > edges.get(i - 1).time && edges.get(i).time > edges.get(i + 5 - t).time && edges.get(i).time > edges.get(i + 7 - t).time) {
                            if (edgeList[i] == 1) {
                                StdDraw.text(150 + 150 * t, 300, "RED");
                            }
                            if (edgeList[i] == 2) {
                                StdDraw.text(150 + 150 * t, 300, "BLUE");
                            }
                        }
                    }
                }
                if(i % 3 == 1) {
                    int t = (int) Math.floor(i / 3);
                    if (edgeList[i + 1] != 0 && edgeList[i + 6 - t] != 0 && edgeList[i + 8 - t] != 0) {
                        if (edges.get(i).time > edges.get(i + 1).time && edges.get(i).time > edges.get(i + 6 - t).time && edges.get(i).time > edges.get(i + 8 - t).time) {
                            if (edgeList[i] == 1) {
                                StdDraw.text(150 + 150 * t, 150+150*(i % 3), "RED");
                            }
                            if (edgeList[i] == 2) {
                                StdDraw.text(150 + 150 * t, 150+150*(i % 3), "BLUE");
                            }
                        }
                    }
                    if (edgeList[i - 1] != 0 && edgeList[i + 5 - t] != 0 && edgeList[i + 7 - t] != 0) {
                        if (edges.get(i).time > edges.get(i - 1).time && edges.get(i).time > edges.get(i + 5 - t).time && edges.get(i).time > edges.get(i + 7 - t).time) {
                            if (edgeList[i] == 1) {
                                StdDraw.text(150 + 150 * t, 150+150*(i % 3 - 1), "RED");
                            }
                            if (edgeList[i] == 2) {
                                StdDraw.text(150 + 150 * t, 150+150*(i % 3 - 1), "BLUE");
                            }
                        }
                    }
                }
            }
        }
        for (int i = edges.size() / 2; i < edges.size(); i++) {
            if (edgeList[i] != 0) {
                if (i <= 7) {
                    if (edgeList[i - 6] != 0 && edgeList[i - 5] != 0 && edgeList[i + 2] != 0) {
                        if (edges.get(i).time > edges.get(i - 6).time && edges.get(i).time > edges.get(i - 5).time && edges.get(i).time > edges.get(i + 2).time) {
                            if (edgeList[i] == 1) {
                                StdDraw.text(150, 150 + 150 * (i - edges.size() / 2), "RED");
                            }
                            if (edgeList[i] == 2) {
                                StdDraw.text(150, 150 + 150 * (i - edges.size() / 2), "BLUE");
                            }
                        }
                    }
                }
                if(i <= 11 && i > 9){
                    if (edgeList[i - 7] != 0 && edgeList[i - 6] != 0 && edgeList[i - 2] != 0) {
                        if (edges.get(i).time > edges.get(i - 7).time && edges.get(i).time > edges.get(i - 6).time && edges.get(i).time > edges.get(i - 2).time) {
                            if (edgeList[i] == 1) {
                                StdDraw.text(300, 150 + 150 * (i - 4 - edges.size() / 2), "RED");
                            }
                            if (edgeList[i] == 2) {
                                StdDraw.text(300, 150 + 150 * (i - 4 - edges.size() / 2), "BLUE");
                            }
                        }
                    }
                }
                if(i <= 9 && i > 7){
                    int t = (int)Math.floor((i-6)/2);
                    if (edgeList[i - 6 + t] != 0 && edgeList[i - 5 + t] != 0 && edgeList[i + 2] != 0) {
                        if (edges.get(i).time > edges.get(i - 6 + t).time && edges.get(i).time > edges.get(i - 5 + t).time && edges.get(i).time > edges.get(i + 2).time) {
                            if (edgeList[i] == 1) {
                                StdDraw.text(150 + 150*t, 150 + 150 * (i - 2*t - edges.size() / 2), "RED");
                            }
                            if (edgeList[i] == 2) {
                                StdDraw.text(150 + 150*t, 150 + 150 * (i - 2*t - edges.size() / 2), "BLUE");
                            }
                        }
                    }
                    if (edgeList[i - 8 + t] != 0 && edgeList[i - 9 + t] != 0 && edgeList[i - 2] != 0) {
                        if (edges.get(i).time > edges.get(i - 8 + t).time && edges.get(i).time > edges.get(i - 9 + t).time && edges.get(i).time > edges.get(i - 2).time) {
                            if (edgeList[i] == 1) {
                                StdDraw.text(150 + 150*(t-1), 150 + 150 * (i - 2*t - edges.size() / 2), "RED");
                            }
                            if (edgeList[i] == 2) {
                                StdDraw.text(150 + 150*(t-1), 150 + 150 * (i - 2*t - edges.size() / 2), "BLUE");
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
        PVE33 game = new PVE33(800, 800);

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
        PVE33 game = new PVE33(700, 700);
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

