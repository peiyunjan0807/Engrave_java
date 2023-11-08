package sample;

import com.google.firebase.database.DatabaseReference;
import jxl.read.biff.BiffException;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class AddInUser extends JFrame{
    private static final String[] COLUME_NAMES = { "單字", "詞性", "中文解釋", "英文解釋" };

    private JTable playersTable;
    private JScrollPane tableWithScrollBar;

    private JPanel recordPanel;
    private JButton showButton;
    private JButton addButton;

    public String[][] data;

    public String userAccount;
    public String dbName;

    int countHere = 0;
    int over = 0; //0: 是, 1: 否

    public static String word;
    public static String partOfSpeech;
    public static String chineseDefinition;
    public static String englishDefinition;

    // Constructor
    public AddInUser(String account, String name) throws BiffException, IOException { //視窗介面設定
        super("Create " + account + "'s " + name);

        userAccount = account;
        dbName = name;

        word= "";
        partOfSpeech = "";
        chineseDefinition = "";
        englishDefinition = "";

        recordPanel = new JPanel();
        recordPanel.setLayout(new GridLayout(1, 2)); //1列2行(按鈕並排)
        showButton = new JButton("顯示單字清單");
        addButton = new JButton("新增");

        showButton.setFont(new Font("Serif", Font.BOLD, 20));
        addButton.setFont(new Font("Serif", Font.BOLD, 20));

        MyEventHandler handler = new MyEventHandler();

        showButton.addActionListener(handler);
        addButton.addActionListener(handler);

        recordPanel.add(showButton); //加入按紐
        recordPanel.add(addButton); //加入按紐

        add(recordPanel, BorderLayout.SOUTH); //recordPanel版面設置BorderLayout.SOUTH，並加到視窗上，

        setSize(1000,625);
        GUIUtil.toCenter(this);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        addPlayer();
    }

    private void addPlayer() throws BiffException, IOException {

        ArrayList<Word> wordArrayList= new ArrayList<>();
        while(over == 0) {
            countHere = countHere + 1;
            while(word.length()==0) {
                word = JOptionPane.showInputDialog(this, "請輸入單字");
                if(word.length()==0){
                    JOptionPane.showMessageDialog(this,"單字不可為空");
                }
            }
            String[] options = {"查詢線上字典","手動輸入"};
            int way = JOptionPane.showOptionDialog(this,"請選擇進行方式","請選擇",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,"查詢線上字典");
            if(way == JOptionPane.YES_OPTION) {
                FindFromWebsite.word = word;
                new FindFromWebsite();
                partOfSpeech = FindFromWebsite.partOfSpeech;
                chineseDefinition = FindFromWebsite.chineseDefinition;
                englishDefinition = FindFromWebsite.englishDefinition;
            }else {
                partOfSpeech = JOptionPane.showInputDialog(this, "請輸入詞性");
                chineseDefinition = JOptionPane.showInputDialog(this, "請輸入中文解釋");
                englishDefinition = JOptionPane.showInputDialog(this, "請輸入英文解釋");
            }
            word = FindFromWebsite.word;
            Word tempWord = new Word(word,partOfSpeech,chineseDefinition,englishDefinition);
            wordArrayList.add(tempWord);
            word = "";
            partOfSpeech = "";
            chineseDefinition = "";
            englishDefinition = "";
            over = JOptionPane.showConfirmDialog(this,"是否繼續新增?");
            if((over == 1) || (countHere == 20)){
                if(countHere == 20){
                    over = 1;
                    JOptionPane.showMessageDialog(this,"很抱歉，數量已達上限(20)，無法再新增了喔~");
                }
                JOptionPane.showMessageDialog(this,"欲顯示以上新增之單字，請按\"顯示單字清單\"按鈕\n若確定新增以上單字，請按\"新增\"按鈕");
            }
        }
        data = convertArrayList2Array(wordArrayList);
    }

    public void addToTable(){
        try {
            playersTable = new JTable(data, COLUME_NAMES); //建立表格，表格的欄位為COLUME_NAMES陣列裡的字串
            playersTable.setFont(new Font("Serif", Font.BOLD, 16));
            playersTable.setForeground(new Color(102, 156, 177));
            playersTable.setBackground(new Color(220, 255, 223));
            tableWithScrollBar = new JScrollPane(playersTable); //幫表格放在可滾動的面板上
            playersTable.setEnabled(false);
            playersTable.setRowHeight(30);
            TableColumn column = playersTable.getColumnModel().getColumn(3);
            column.setPreferredWidth(300);
            add(tableWithScrollBar, BorderLayout.CENTER); //加到視窗內，放在BorderLayout.CENTER的位置
            SwingUtilities.updateComponentTreeUI(this);
        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(this,"尚未輸入資料喔!");
        }
    }

    private class MyEventHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == showButton) {
                addToTable();
            } else if (e.getSource() == addButton) {
                try {
                    putIntoDatabase(userAccount, dbName);
                    JOptionPane.showMessageDialog(null, "成功新增至資料庫!");
                }catch(Exception exception){
                    JOptionPane.showMessageDialog(null,"尚未輸入資料，無法新增至資料庫!");
                }
                dispose();
            }
        }
    }

    public String[][] convertArrayList2Array(ArrayList<Word> list) { //把list轉成字串陣列(二維)
        int size = list.size();
        String[][] listArray = new String[size][];

        for (int i = 0; i < size; i++) {
            String[] record = new String[4];
            Word account = list.get(i);

            record[0] = account.getWord(); //[0]存名字
            record[1] = account.getPartOfSpeech(); //[1]存姓氏
            record[2] = account.getChineseDefinition();
            record[3] = account.getEnglishDefinition();

            listArray[i] = record;
        }

        return listArray; //回傳字串二維陣列
    }

    public void putIntoDatabase(String account, String name/*, String password, boolean login*/){

        int row = playersTable.getRowCount();
        ArrayList<Word> wordArrayList = new ArrayList<>();
        Word tempWord;
        String vocabulary;
        String partOfSpeech;
        String chineseDefinition;
        String englishDefinition;
        for (int i = 0; i < row; i++) {
            vocabulary = (playersTable.getModel().getValueAt(i, 0)).toString();
            partOfSpeech = (playersTable.getModel().getValueAt(i, 1)).toString();
            chineseDefinition = (playersTable.getModel().getValueAt(i, 2)).toString();
            englishDefinition = (playersTable.getModel().getValueAt(i, 3)).toString();
            tempWord = new Word(vocabulary, partOfSpeech, chineseDefinition, englishDefinition);
            wordArrayList.add(tempWord);
        }

        DatabaseReference ref = FireBaseService.getDb().getReference("/"+userAccount);
        ref.child(userAccount+"'s_"+dbName).setValueAsync(wordArrayList);
    }
}
