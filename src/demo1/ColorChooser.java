package demo1;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ColorChooser {
    private int red;
    private int green;
    private int blue;
    //ArrayList <Integer> list = new ArrayList<>();
    public ColorChooser(int red, int green, int blue){
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public static int[] run() throws Exception {
        JFrame jf = new JFrame();
        Color color = JColorChooser.showDialog(jf, "DotColor", null);
        if (color == null) {
            return new int[]{0,0,0};
        }
        int red = color.getRed();
        int green = color.getGreen();
        int blue = color.getBlue();
        int[] a = {red,green,blue};
        return a;
    }

    public void setRed(int red){
        this.red = red;
    }

    public void setGreen(int green){
        this.green = green;
    }

    public void setBlue(int blue){
        this.blue = blue;
    }

    public int getRed(){return red;}
    public int getGreen(){return green;}
    public int getBlue(){return blue;}
}
