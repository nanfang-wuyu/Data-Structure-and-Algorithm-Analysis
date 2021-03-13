package demo1;

import javax.swing.*;

public class MainJpanel extends JPanel {
    //声明全局的begin对象
    Begin begin;
    //声明玩家对象
    public Player player = new Player();
    //声明一个图片对象
    //ImageIcon img = player.player4;

    //面板加载方法
    public void init(Begin begin) {
        this.begin = begin;
        //设置玩家出现的初始位置
        player.x = 200;
        player.y = 10;
        //给面板添加监听器
       /* KeyClick kc = new KeyClick();
        begin.addKeyListener(kc);
        //启用刷新面板线程
        Rethread rt = new Rethread(this);
        rt.start();*/

    }
}

