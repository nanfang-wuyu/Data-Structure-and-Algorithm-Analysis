package demo1;

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
                Runtime.getRuntime().addShutdownHook(new Thread() {
                    public void run() {
                        try {
                            String restartCmd = "nohup java -jar xxx.jar";
                            Thread.sleep(10000);//等10秒，保证分身启动完成后，再关掉自己
                            //logger.debug("程序重启完成！");
                        } catch (Exception e) {
                            //logger.error("重启失败，原因：", e);
                        }
                    }
                });
                //logger.debug("程序准备重启！");
                System.exit(0);

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
