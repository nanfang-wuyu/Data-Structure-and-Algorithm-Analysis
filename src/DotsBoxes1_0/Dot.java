package DotsBoxes1_0;

public class Dot {
    private int x, y;
    private int size;
    private String dotColor;
    private int red;
    private int green;
    private int blue;

    public Dot(int x, int y, int size, int red, int green, int blue) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.red = red;
        this.green = green;
        this.blue = blue;
        //this.dotColor = dotColor;
    }

 /*   public void setRed(int red){
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
    public int getBlue(){return blue;}*/


    public void paint() {
        StdDraw.setPenColor(red,green,blue);
        StdDraw.filledCircle(x, y, size);
    }
    public void setDotColor(String dotColor){
        this.dotColor = dotColor;
    }

    public String getDotColor(){
        return dotColor;
    }
}