package demo2;

import demo1.DotsBoxes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Mainly  extends JFrame{
    public Mainly(){
        setBounds(100,100,700,700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container c=getContentPane();
        c.setLayout(new GridLayout(3,2));

        JLabel jl = new JLabel("DotsBoxes");
        jl.setSize(100,100);
        c.add(jl);

        JRadioButton left=new JRadioButton("3 * 3");
        JRadioButton middle=new JRadioButton("4 * 4");
        JRadioButton right=new JRadioButton("5 * 5");
        Font f = new Font("times new Roman",Font.ITALIC,30);
        left.setFont(f);
        middle.setFont(f);
        right.setFont(f);
        jl.setFont(f);
        c.add(left);
        c.add(middle);
        c.add(right);
        ButtonGroup group=new ButtonGroup();//按钮组
        group.add(left);//把按钮放在按钮组中
        group.add(middle);
        group.add(right);
        left.setSelected(true);
        JButton bun=new JButton("New Game");
        bun.setFont(f);
        bun.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                group.clearSelection();//按钮组选项清空

                int size=4;
               // new Thread(()-> DotsBoxes.run(size)).start();
            }
        });
       // c.add(bun);



        JFrame CK = new JFrame();
        CK.setLayout(null);
        CK.setBounds(100,100,400,400);
        CK.setBackground(Color.CYAN);
        CK.add(bun);
        bun.setBounds(300,300,40,40);
        CK.setVisible(true);
        setVisible(true);
    }

        public static void main(String[] args) {
            new Mainly();
            // write your code here
        }
    }
