package demo1;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import javax.swing.*;
public class Face extends JFrame {
        int index;
        JLabel jl = new JLabel("你好啊~");
        JButton jb = new JButton("点击改变标签上的文字");
        public Face() {
            //设置界面的布局为边界布局
            this.setLayout(new BorderLayout());
            //设置标签文字的位置在 布局的中间
            this.add(jl, BorderLayout.CENTER);
            jl.setVerticalAlignment(SwingConstants.CENTER);
            jl.setHorizontalAlignment(SwingConstants.CENTER);
            //设置按钮在布局的南部
            this.add(jb, BorderLayout.SOUTH);
            jl.setLayout(null);
            jb.setBackground(Color.CYAN);
            jb.setSize(10,5);
            //设置窗口的位置和大小
            this.setBounds(350, 100, 400, 400);
            //设置窗口的关闭事件的响应，如果点击关闭按钮，那么就退出
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            //设置窗口的标题
            this.setTitle("窗口");
            //设置窗口是否可见
            this.setVisible(true);

            //为按钮注册事件响应,有了这句代码就能让按钮能够响应点击事件了
            jb.addActionListener(new MyActionListener());
        }
        public static void main(String[] args) {
            //实例化窗口对象
            new Face();
        }
        //实现动作Listener接口。实现里面的actionPerformed方法
        class MyActionListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                index++;
                jl.setText("你点击了"+index+"次按钮");
            }
        }

}

    /*public void initialize() {
        edges.add(new Edge(75, 70, 150, 10));
        edges.add(new Edge(75, 220, 150, 10));
        edges.add(new Edge(70, 75, 10, 150));
        edges.add(new Edge(220, 75, 10, 150));
        System.out.println("Choose the dotColor,please input red, green, blue:");
        Scanner in = new Scanner(System.in);
        int red = in.nextInt();
        int green = in.nextInt();
        int blue = in.nextInt();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                dots.add(new Dot(75 + 150 * i, 75 + 150 * j, 10, red, green, blue));
            }
        }
    }
*/

