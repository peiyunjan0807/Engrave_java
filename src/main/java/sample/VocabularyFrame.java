package sample;

import jxl.read.biff.BiffException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class VocabularyFrame {
    private JFrame vocabularyFrame1;
    private JTextField vocabularyJTextField1;
    private JButton vocabularyJButton1,vocabularyJButton2;
    private JPanel vocabularyJPanel1,vocabularyJPanel2,vocabularyJPanel3,vocabularyJPanelChoice;
    public static JComboBox jcbChoice = new JComboBox();
    private JLabel jlbChoice;
    private JPanel leftPanel1,upPanel1,centerPanel,downPanel1,rightPanel1;
    private JButton jbtOK = new JButton(" 開 始 ");
    public static JLabel jlNumber = new JLabel();
    public static JTextArea jtaShowChoice = new JTextArea();
    public static int count;
    public static ArrayList<Word> cardData = new ArrayList<>();
    public JRadioButton jrb1 = new JRadioButton();
    public JRadioButton jrb2 = new JRadioButton();
    public ButtonGroup btg1 = new ButtonGroup();

    ImageIcon iconVocabularyJButton1;
    public VocabularyFrame() {
        vocabularyFrame1 = new JFrame();
        count = 0;
        cardData = new ArrayList<>();
        vocabularyJButton2 = new JButton("回首頁");
        vocabularyJButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vocabularyFrame1.dispose();
                new UI();
            }
        });


        vocabularyJPanel1 =new JPanel(new GridLayout(1,1));
        vocabularyJPanel1.setBackground(Color.lightGray);
        vocabularyFrame1.add(vocabularyJPanel1,BorderLayout.WEST);
        vocabularyJButton2.setBackground(Color.lightGray);
        vocabularyJPanel1.add(vocabularyJButton2);//回首頁

        leftPanel1 = new JPanel();
        leftPanel1.setBackground(Color.lightGray);
        upPanel1 = new JPanel();
        upPanel1.setBackground(Color.lightGray);
        centerPanel = new JPanel(new BorderLayout());
        downPanel1 = new JPanel();
        downPanel1.setBackground(Color.lightGray);
        rightPanel1 = new JPanel();
        rightPanel1.setBackground(Color.lightGray);

        centerPanel.add(upPanel1,BorderLayout.NORTH);
        jtaShowChoice.setText("");
        jtaShowChoice.setFont(new Font("TimesRoman",Font.BOLD,15));
        jtaShowChoice.setEditable(false);
        centerPanel.add(new JScrollPane(jtaShowChoice),BorderLayout.CENTER);
        centerPanel.add(downPanel1,BorderLayout.SOUTH);

        vocabularyJPanelChoice = new JPanel(new BorderLayout());
        vocabularyJPanelChoice.setBackground(Color.lightGray);

        vocabularyJPanel3 = new JPanel(new BorderLayout());
        vocabularyJPanel3.setBackground(Color.lightGray);

        jlbChoice = new JLabel("選擇單字來源: ");
        jlbChoice.setFont(new Font("TimesRoman",Font.BOLD,30));

        jcbChoice = new JComboBox();
        jcbChoice.addItem("---------請選擇---------");
        jcbChoice.addItem("預設單字庫");
        jcbChoice.addItem("個人單字庫");
        jcbChoice.addItem("建立新單字庫-訪客");
        jcbChoice.addItem("建立新單字庫-會員");
        jcbChoice.setFont(new Font("TimesRoman",Font.BOLD,30));
        vocabularyJPanelChoice.add(jlbChoice,BorderLayout.WEST);
        vocabularyJPanelChoice.add(jcbChoice,BorderLayout.CENTER);

        jlNumber.setText("          已選 0 個，上限 20 個          ");
        jlNumber.setFont(new Font("TimesRoman",Font.PLAIN,25));
        jbtOK.setFont(new Font("TimesRoman",Font.BOLD,30));

        jrb1.setText("正面顯示單字");
        jrb2.setText("正面顯示詞性、解釋");
        jrb1.setFont(new Font("TimesRoman",Font.PLAIN,15));
        jrb2.setFont(new Font("TimesRoman",Font.PLAIN,15));
        jrb1.setSelected(true);
        jrb2.setSelected(false);
        btg1.add(jrb1);
        btg1.add(jrb2);

        jrb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JRadioButton temp = (JRadioButton) e.getSource();
                if(temp.isSelected()){
                    CardFrame.style = true;
                }
            }
        });

        jrb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JRadioButton temp = (JRadioButton) e.getSource();
                if(temp.isSelected()){
                    CardFrame.style = false;
                }
            }
        });

        jbtOK.setForeground(new Color(255,253,218));
        jbtOK.setBackground(new Color(35,129,189));
        upPanel1.add(vocabularyJPanelChoice,BorderLayout.NORTH);
        downPanel1.add(jbtOK,BorderLayout.WEST);
        downPanel1.add(jlNumber,BorderLayout.CENTER);
        downPanel1.add(jrb1,BorderLayout.EAST);
        downPanel1.add(jrb2,BorderLayout.EAST);

        jcbChoice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox comboBox = (JComboBox) e.getSource();

                Object selected = comboBox.getSelectedItem();
                if(selected == "預設單字庫"){
                    try {
                        new InitialTable();
                    } catch (BiffException biffException) {
                        biffException.printStackTrace();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }else if(selected == "個人單字庫"){
                    new PrivateVocabulary();
                }else if(selected == "建立新單字庫-訪客"){
                    if(!User.getLogin()){
                        JOptionPane.showMessageDialog(null,"此為建立新單字庫-訪客模式，所建立之單字清單不會留存","注意!",JOptionPane.WARNING_MESSAGE);
                    }
                    String userAccount = "Visitor";
                    String dbName = JOptionPane.showInputDialog("請為單字庫命名");
                    try {
                        new AddInVisitor(userAccount,dbName);
                    } catch (BiffException biffException) {
                        biffException.printStackTrace();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }else if(selected == "建立新單字庫-會員"){
                    if(!User.getLogin()){
                        JOptionPane.showMessageDialog(null,"很抱歉，此為會員專屬之功能，如需使用請登入，謝謝!");
                    }else {
                        String userAccount, dbName, password;
                        userAccount = User.account;
                        dbName = JOptionPane.showInputDialog("請為單字庫命名");
                        String name = userAccount + "'s_" + dbName;
                        DbFile.getInfoByAccount(name);
                        while((DB.account!=null) || (dbName.length() == 0)) {
                            DB.account=null;
                            JOptionPane.showMessageDialog(null,"單字庫名稱為空或已經存在");
                            dbName = JOptionPane.showInputDialog("請為單字庫命名");
                            name = userAccount + "'s_" + dbName;
                            DbFile.getInfoByAccount(name);
                        }
                        password = JOptionPane.showInputDialog("請為單字庫設定密碼");
                        while(password.length()== 0) {
                            JOptionPane.showMessageDialog(null,"密碼不可為空");
                            password = JOptionPane.showInputDialog("請為單字庫設定密碼");
                        }
                        DbFile.updateCustomer(name,password);
                        try {
                            new AddInUser(userAccount, dbName);
                        } catch (BiffException biffException) {
                            biffException.printStackTrace();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    }
                }
                comboBox.setSelectedItem("---------請選擇---------");
            }
        });
        vocabularyJPanel3.add(leftPanel1,BorderLayout.WEST);
        //vocabularyJPanel3.add(leftPanel2);
        vocabularyJPanel3.add(centerPanel,BorderLayout.CENTER);
        //vocabularyJPanel3.add(rightPanel1);
        vocabularyJPanel3.add(rightPanel1,BorderLayout.EAST);

        vocabularyFrame1.add(vocabularyJPanel3,BorderLayout.CENTER);

        jbtOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (e.getSource() == jbtOK) {
                        if(VocabularyFrame.count==0){
                            throw new Exception("null");
                        }
                        new CardFrame();
                    }
                }catch(Exception exception){
                    JOptionPane.showMessageDialog(null,"尚未選擇單字喔!");
                }
                VocabularyFrame.count=0;
                VocabularyFrame.jlNumber.setText("          已選 " + VocabularyFrame.count + " 個，上限 20 個          ");
                jtaShowChoice.setText("");
            }
        });

        vocabularyFrame1.setTitle("Engrave英文學習應用平台");
        vocabularyFrame1.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //vocabularyFrame1.setSize(1000,625);
        //vocabularyFrame1.setLocation(500, 100);
        GUIUtil.toCenter(vocabularyFrame1);
        vocabularyFrame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vocabularyFrame1.setVisible(true);
    }
}

