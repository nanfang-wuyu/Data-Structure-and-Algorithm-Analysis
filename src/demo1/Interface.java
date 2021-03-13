package demo1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Interface extends JFrame {
    public Interface(){

    }

    public void Interface() {

        JFrame CK = new JFrame();//新建窗口
        CK.setLayout(null);//设为空


        JButton Start = new JButton("开始游戏");
        JButton Sets = new JButton("设定");
        JLabel Headline = new JLabel("DotsBoxeswo");

        CK.setBounds(400, 150, 400, 400);
        Start.setBounds(150, 40, 100, 50);
        Sets.setBounds(150, 100, 100, 50);
        Headline.setBounds(150, 5, 100, 50);

        CK.add(Start);
        CK.add(Sets);
        CK.add(Headline);


        //CK.setBackground(Color.BLUE);
        CK.setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Start.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"什么都没选就想开始游戏？给我回去！","你在做梦",JOptionPane.WARNING_MESSAGE);
            }
        });

        Sets.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.exit(0);
                //setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
                // Interface a = new Interface();
                CK.setVisible(false);
                JFrame CK2 = new JFrame();
                CK2.setVisible(true);
                setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

                CK2.setLayout(null);//设为空

                CK2.setBounds(400, 150, 400, 400);

                JLabel size = new JLabel("请选择游戏大小");
                size.setBounds(100, 35, 200, 100);
                size.setHorizontalAlignment(SwingConstants.CENTER);
                CK2.add(size);

                /*JButton next = new JButton("下一步");
                next.setBounds(260, 300, 80, 30);
                CK2.add(next);*/
                JButton last = new JButton(("上一步"));
                last.setBounds(60, 300, 80, 30);
                CK2.add(last);


                JRadioButton left = new JRadioButton("3 * 3");
                JRadioButton middle = new JRadioButton("4 * 4");
                JRadioButton right = new JRadioButton("5 * 5");

                left.setBounds(150, 120, 100, 30);
                middle.setBounds(150, 160, 100, 30);
                right.setBounds(150, 200, 100, 30);

                Font f = new Font("FZkai-Z03S", Font.ITALIC, 20);
                left.setFont(f);
                middle.setFont(f);
                right.setFont(f);
                size.setFont(f);
                // Headline.setFont(f);

                CK2.add(left);
                CK2.add(middle);
                CK2.add(right);

                ButtonGroup group = new ButtonGroup();//按钮组
                group.add(left);//把按钮放在按钮组中
                group.add(middle);
                group.add(right);
                //left.setSelected(true);
                left.addActionListener(new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {{

                        CK2.setVisible(false);
                        JFrame CK3 = new JFrame();
                        CK3.setVisible(true);
                        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

                        CK3.setLayout(null);//设为空

                        CK3.setBounds(400, 150, 400, 400);

                        JLabel size = new JLabel("请选择玩法");
                        size.setBounds(100, 35, 200, 100);
                        size.setHorizontalAlignment(SwingConstants.CENTER);
                        CK3.add(size);

                        JButton back = new JButton("返回首页");
                        JButton last = new JButton(("上一步"));
                        back.setBounds(250, 300, 100, 30);
                        last.setBounds(60, 300, 80, 30);
                        CK3.add(back);
                        CK3.add(last);

                        JButton PVP = new JButton("人与人");
                        JButton PVE = new JButton("人与电脑");
                        JButton EVE = new JButton("电脑与电脑");

                        PVP.setBounds(150, 120, 100, 35);
                        PVE.setBounds(150, 160, 100, 35);
                        EVE.setBounds(150, 200, 100, 35);

                        CK3.add(PVP);
                        CK3.add(PVE);
                        CK3.add(EVE);

                        last.addActionListener(new AbstractAction() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                CK3.setVisible(false);
                                CK2.setVisible(true);
                                CK3.dispose();
                            }
                        });
                        back.addActionListener(new AbstractAction() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                CK3.setVisible(false);
                                CK.setVisible(true);
                                CK3.dispose();
                            }
                        });
                        PVP.addActionListener(new AbstractAction() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                int size=4;
                                new Thread(()-> PVP33.run(size)).start();
                                CK3.setVisible(false);
                            }
                        });
                        PVE.addActionListener(new AbstractAction() {
                            @Override
                            public void actionPerformed(ActionEvent e) {{
                                CK3.setVisible(false);
                                JFrame CK4 = new JFrame();
                                CK4.setVisible(true);
                                setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

                                CK4.setLayout(null);//设为空

                                CK4.setBounds(400, 150, 400, 400);

                                JLabel first = new JLabel("请选择先后手");
                                first.setBounds(100, 35, 200, 100);
                                first.setHorizontalAlignment(SwingConstants.CENTER);
                                CK4.add(first);

                                JButton back = new JButton("返回首页");
                                JButton last = new JButton(("上一步"));
                                back.setBounds(250, 300, 100, 30);
                                last.setBounds(60, 300, 80, 30);
                                CK4.add(back);
                                CK4.add(last);

                                JButton offensive = new JButton("offensive");
                                JButton defensive = new JButton("defensive");

                                offensive.setBounds(150, 120, 100, 35);
                                defensive.setBounds(150, 160, 100, 35);

                                CK4.add(offensive);
                                CK4.add(defensive);

                                last.addActionListener(new AbstractAction() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        CK4.setVisible(false);
                                        CK3.setVisible(true);
                                        CK4.dispose();
                                    }
                                });
                                offensive.addActionListener(new AbstractAction() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        int size=4;
                                        new Thread(()-> PVE33.run(size)).start();
                                        CK4.setVisible(false);
                                    }
                                });
                                defensive.addActionListener(new AbstractAction() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        int size=4;
                                        new Thread(()-> PVE330.run(size)).start();
                                        CK4.setVisible(false);
                                    }
                                });
                                back.addActionListener(new AbstractAction() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        CK4.setVisible(false);
                                        CK.setVisible(true);
                                        CK4.dispose();
                                    }
                                });
                            }}
                        });
                        EVE.addActionListener(new AbstractAction() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                int size=4;
                                new Thread(()-> EVE33.run(size)).start();
                                CK3.setVisible(false);
                            }
                        });
                    }}
                });
                middle.addActionListener(new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {{

                        CK2.setVisible(false);
                        JFrame CK3 = new JFrame();
                        CK3.setVisible(true);
                        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

                        CK3.setLayout(null);//设为空

                        CK3.setBounds(400, 150, 400, 400);

                        JLabel size = new JLabel("请选择玩法");
                        size.setBounds(100, 35, 200, 100);
                        size.setHorizontalAlignment(SwingConstants.CENTER);
                        CK3.add(size);

                        JButton back = new JButton("返回首页");
                        JButton last = new JButton(("上一步"));
                        back.setBounds(250, 300, 100, 30);
                        last.setBounds(60, 300, 80, 30);
                        CK3.add(back);
                        CK3.add(last);

                        JButton PVP = new JButton("人与人");
                        JButton PVE = new JButton("人与电脑");
                        JButton EVE = new JButton("电脑与电脑");

                        PVP.setBounds(150, 120, 100, 35);
                        PVE.setBounds(150, 160, 100, 35);
                        EVE.setBounds(150, 200, 100, 35);

                        CK3.add(PVP);
                        CK3.add(PVE);
                        CK3.add(EVE);

                        last.addActionListener(new AbstractAction() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                CK3.setVisible(false);
                                CK2.setVisible(true);
                                CK3.dispose();
                            }
                        });
                        back.addActionListener(new AbstractAction() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                CK3.setVisible(false);
                                CK.setVisible(true);
                                CK3.dispose();
                            }
                        });
                        PVP.addActionListener(new AbstractAction() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                int size=4;
                                new Thread(()-> PVP44.run(size)).start();
                                CK3.setVisible(false);
                            }
                        });
                        PVE.addActionListener(new AbstractAction() {
                            @Override
                            public void actionPerformed(ActionEvent e) {{
                                CK3.setVisible(false);
                                JFrame CK4 = new JFrame();
                                CK4.setVisible(true);
                                setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

                                CK4.setLayout(null);//设为空

                                CK4.setBounds(400, 150, 400, 400);

                                JLabel first = new JLabel("请选择先后手");
                                first.setBounds(100, 35, 200, 100);
                                first.setHorizontalAlignment(SwingConstants.CENTER);
                                CK4.add(first);

                                JButton back = new JButton("返回首页");
                                JButton last = new JButton(("上一步"));
                                back.setBounds(250, 300, 100, 30);
                                last.setBounds(60, 300, 80, 30);
                                CK4.add(back);
                                CK4.add(last);

                                JButton offensive = new JButton("offensive");
                                JButton defensive = new JButton("defensive");

                                offensive.setBounds(150, 120, 100, 35);
                                defensive.setBounds(150, 160, 100, 35);

                                CK4.add(offensive);
                                CK4.add(defensive);

                                last.addActionListener(new AbstractAction() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        CK4.setVisible(false);
                                        CK3.setVisible(true);
                                        CK4.dispose();
                                    }
                                });
                                offensive.addActionListener(new AbstractAction() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        int size=4;
                                        new Thread(()-> PVE44.run(size)).start();
                                        CK4.setVisible(false);
                                    }
                                });
                                defensive.addActionListener(new AbstractAction() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        int size=4;
                                        new Thread(()-> PVE440.run(size)).start();
                                        CK4.setVisible(false);
                                    }
                                });
                                back.addActionListener(new AbstractAction() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        CK4.setVisible(false);
                                        CK.setVisible(true);
                                        CK4.dispose();
                                    }
                                });
                            }}
                        });
                        EVE.addActionListener(new AbstractAction() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                int size=4;
                                new Thread(()-> EVE44.run(size)).start();
                                CK3.setVisible(false);
                            }
                        });
                    }}
                });
                right.addActionListener(new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {{

                        CK2.setVisible(false);
                        JFrame CK3 = new JFrame();
                        CK3.setVisible(true);
                        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

                        CK3.setLayout(null);//设为空

                        CK3.setBounds(400, 150, 400, 400);

                        JLabel size = new JLabel("请选择玩法");
                        size.setBounds(100, 35, 200, 100);
                        size.setHorizontalAlignment(SwingConstants.CENTER);
                        CK3.add(size);

                        JButton back = new JButton("返回首页");
                        JButton last = new JButton(("上一步"));
                        back.setBounds(250, 300, 100, 30);
                        last.setBounds(60, 300, 80, 30);
                        CK3.add(back);
                        CK3.add(last);

                        JButton PVP = new JButton("人与人");
                        JButton PVE = new JButton("人与电脑");
                        JButton EVE = new JButton("电脑与电脑");

                        PVP.setBounds(150, 120, 100, 35);
                        PVE.setBounds(150, 160, 100, 35);
                        EVE.setBounds(150, 200, 100, 35);

                        CK3.add(PVP);
                        CK3.add(PVE);
                        CK3.add(EVE);

                        last.addActionListener(new AbstractAction() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                CK3.setVisible(false);
                                CK2.setVisible(true);
                                CK3.dispose();
                            }
                        });
                        back.addActionListener(new AbstractAction() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                CK3.setVisible(false);
                                CK.setVisible(true);
                                CK3.dispose();
                            }
                        });
                        PVP.addActionListener(new AbstractAction() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                int size=4;
                                new Thread(()-> PVP55.run(size)).start();
                                CK3.setVisible(false);
                            }
                        });
                        PVE.addActionListener(new AbstractAction() {
                            @Override
                            public void actionPerformed(ActionEvent e) {{
                                CK3.setVisible(false);
                                JFrame CK4 = new JFrame();
                                CK4.setVisible(true);
                                setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

                                CK4.setLayout(null);//设为空

                                CK4.setBounds(400, 150, 400, 400);

                                JLabel first = new JLabel("请选择先后手");
                                first.setBounds(100, 35, 200, 100);
                                first.setHorizontalAlignment(SwingConstants.CENTER);
                                CK4.add(first);

                                JButton back = new JButton("返回首页");
                                JButton last = new JButton(("上一步"));
                                back.setBounds(250, 300, 100, 30);
                                last.setBounds(60, 300, 80, 30);
                                CK4.add(back);
                                CK4.add(last);

                                JButton offensive = new JButton("offensive");
                                JButton defensive = new JButton("defensive");

                                offensive.setBounds(150, 120, 100, 35);
                                defensive.setBounds(150, 160, 100, 35);

                                CK4.add(offensive);
                                CK4.add(defensive);

                                last.addActionListener(new AbstractAction() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        CK4.setVisible(false);
                                        CK3.setVisible(true);
                                        CK4.dispose();
                                    }
                                });
                                offensive.addActionListener(new AbstractAction() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        int size=4;
                                        new Thread(()-> PVE55.run(size)).start();
                                        CK4.setVisible(false);
                                    }
                                });
                                defensive.addActionListener(new AbstractAction() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        int size=4;
                                        new Thread(()-> PVE550.run(size)).start();
                                        CK4.setVisible(false);
                                    }
                                });
                                back.addActionListener(new AbstractAction() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        CK4.setVisible(false);
                                        CK.setVisible(true);
                                        CK4.dispose();
                                    }
                                });
                            }}
                        });
                        EVE.addActionListener(new AbstractAction() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                int size=4;
                                new Thread(()-> EVE55.run(size)).start();
                                CK3.setVisible(false);
                            }
                        });
                    }}
                });

                last.addActionListener(new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        CK2.setVisible(false);
                        CK.setVisible(true);
                        CK2.dispose();
                    }
                });

                /*next.addActionListener(new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {


                    }
                });*/

            }


        });



    }

    public static void main(String[] args) {
        new Interface().Interface();
    }
}















        /*this.setTitle("Pencil & Paper");
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
        container.setBackground(Color.BLUE);*/




