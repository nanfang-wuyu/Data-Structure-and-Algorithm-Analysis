package demo1;

import java.awt.*;
import java.util.Scanner;
import java.awt.*;

public class ButtonS {
    private int x, y;
    private int halfLength;
    //private String squareColor;
    private int red;
    private int green;
    private int blue;
    private Color squareColor;

    public ButtonS(int x, int y, int halfLength,Color squareColor) {
        this.x = x;
        this.y = y;
        this.halfLength = halfLength;
        this.squareColor = squareColor;
        /*this.red = red;
        this.green = green;
        this.blue = blue;*/
        //this.dotColor = dotColor;
    }

    public void paint() {
        StdDraw.setPenColor(squareColor);
        StdDraw.filledSquare(x, y,halfLength);
    }
    public void setSquareColor(Color squareColor){
        this.squareColor = squareColor;
    }

    public Color getDotColor(){
        return squareColor;
    }
    public Rectangle getBounds() {
        return new Rectangle(x, y, halfLength,halfLength);
    }

    public void IN(){
        new NewInterface().choose();
    }
    /*public void setSquareColor(String squareColor){
        this.squareColor = squareColor;
    }

    public String getDotColor(){
        return squareColor;
    }*/
}