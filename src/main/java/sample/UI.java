package sample;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI extends JFrame{
    private JFrame JFrame1;
    private JPanel JPanel1,JPanel2;
    private JButton JButton1,JButton2,JButton3,JButton4,JButton5;
    public ImageIcon iconButton5,iconButton6,iconButton7,iconButton8,iconButton9,iconButton10;
    public JLabel jlb1;

    public UI() {
        JFrame1 = new JFrame();
        String pathCard = "pictures/flashcard.png";
        String pathCloze = "pictures/cloze.png";
        String pathGrammar = "pictures/grammar.png";
        String pathListening = "pictures/listening.png";
        String pathUser = "pictures/user.png";
        String pathVisitor = "pictures/visitor.png";
        //JButton1 = new JButton("登入");JButton1.setForeground(Color.red);JButton1.setOpaque(false);
        iconButton5 = new ImageIcon(pathUser);
        iconButton6 = new ImageIcon(pathVisitor);
        iconButton7 = new ImageIcon(pathCard);
        iconButton8 = new ImageIcon(pathCloze);
        iconButton9 = new ImageIcon(pathGrammar);
        iconButton10 = new ImageIcon(pathListening);

        if(User.getLogin()==true){
            JButton1 = new JButton(iconButton5);
            JButton1.setToolTipText("使用者狀態：已登入 按此按鈕登出並切換帳號");
        }else{
            JButton1 = new JButton(iconButton6);
            JButton1.setToolTipText("使用者狀態：訪客 按此按鈕登入您的帳號");
        }
        jlb1 = new JLabel("  選單  ",JLabel.CENTER);
        jlb1.setFont(new Font("Serif",Font.BOLD,25));
        JButton2 = new JButton(iconButton7);
        JButton2.setToolTipText("透過單字卡自我練習，單字一定能越背越多 !");
        JButton3 = new JButton(iconButton8);
        JButton3.setToolTipText("克漏字 ! 趕快來檢視自己的程度如何吧 ~");
        JButton4 = new JButton(iconButton9);
        JButton4.setToolTipText("還搞不清楚英文文法怎麼用嗎 ? 最詳細的文法整理在這裡 !");
        JButton5 = new JButton(iconButton10);
        JButton5.setToolTipText("想訓練英文聽力又不知從何下手 ? 試著從聽英文歌開始訓練吧 !");
        JButton1.setBackground(new Color(227,222,243));
        JButton2.setBackground(new Color(238,245,209));
        JButton3.setBackground(new Color(188,224,245));
        JButton4.setBackground(new Color(255,236,213));
        JButton5.setBackground(new Color(244,209,252));

        JButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame1.dispose();
                User.setLogin(false);
                User.account=null;
                new LoginFrame();
            }
        });
        JButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame1.dispose();
                new VocabularyFrame();
            }
        });
        JButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame1.dispose();
                new ClozeFrame();
            }
        });
        JButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame1.dispose();
                new GrammarFrame();
            }
        });
        JButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame1.dispose();
                new ListenFrame();
            }
        });

        GridLayout gd1 = new GridLayout(2,2);

        JPanel1 =new JPanel(new GridLayout(1,2));
        JFrame1.add(JPanel1,BorderLayout.WEST);
        JPanel1.add(JButton1);
        JPanel1.add(jlb1);

        JPanel2 =new JPanel();
        JFrame1.add(JPanel2,BorderLayout.CENTER);
        JPanel2.add(JButton2);
        JPanel2.add(JButton3);
        JPanel2.add(JButton4);
        JPanel2.add(JButton5);
        JPanel2.setLayout(gd1);

        JFrame1.setTitle("Engrave英文學習應用平台");
        //JFrame1.setSize(1000,625);
        JFrame1.setExtendedState(JFrame.MAXIMIZED_BOTH);
        GUIUtil.toCenter(JFrame1);
        JFrame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFrame1.setVisible(true);

    }
}

