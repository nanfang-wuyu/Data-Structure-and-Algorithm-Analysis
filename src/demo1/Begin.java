package demo1;

import javax.swing.*;
import java.awt.Container;
import java.awt.*;
import javax.swing.SwingConstants;

public class Begin extends JFrame {

    public void init(){
        //JFrame init = new JFrame("Pencil & Paper");
        this.setTitle("Pencil & Paper");
        this.setSize(500,500);
        //this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //this.setLocationRelativeTo(null);
        MainJpanel mainJpanel = new MainJpanel();

        mainJpanel.init(this);
        mainJpanel.setBounds(50, 50, 400, 400);
        this.add(mainJpanel);
        this.setVisible(true);
        JLabel jl = new JLabel("Welcome to the game!");
        jl.setHorizontalAlignment(SwingConstants.CENTER);
        jl.setVerticalAlignment(SwingConstants.CENTER);
        Container container = this.getContentPane();
        container.add(jl);
        container.setBackground(Color.BLUE);


    }

        public static void main(String args[]){

        new Begin().init();

    }

}




