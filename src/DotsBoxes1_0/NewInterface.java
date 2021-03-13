package DotsBoxes1_0;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class NewInterface extends JFrame {
    public NewInterface(){

    }


    public void choose() {

        JFrame CK = new JFrame();//新建窗口
        CK.setLayout(null);//设为空


        JButton BackToMainMenu = new JButton("BackToMenu");
        JButton Exit = new JButton("Exit");
        JLabel Choose = new JLabel("Choose");

        CK.setBounds(400, 150, 150, 200);
        BackToMainMenu.setBounds(50, 60, 120, 30);
        Exit.setBounds(50, 90, 120, 30);
        Choose.setBounds(80, 5, 100, 30);

        CK.add(BackToMainMenu);
        CK.add(Exit);
        CK.add(Choose);

        CK.setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        BackToMainMenu.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Interface().Interface();
                CK.dispose();


            }
        });
        Exit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
               CK.dispose();
               System.exit(0);
            }
        });

    }

    public static void main(String[] args){
        new NewInterface().choose();
    }
    public static void run(){
        NewInterface a = new NewInterface();
        a.choose();
    }

}
