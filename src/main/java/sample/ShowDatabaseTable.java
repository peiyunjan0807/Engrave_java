package sample;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ShowDatabaseTable extends JFrame {

    private static final String[] COLUME_NAMES = { "單字", "詞性", "中文解釋", "英文解釋" };

    private JTable playersTable;
    private JScrollPane tableWithScrollBar;

    private JPanel recordPanel;
    private JButton showButton;
    private JButton leaveButton;

    public String[][] data;

    public static String account,dbName;

    public String password;

    public ArrayList<Word> list;

    int countHere = 0;
    int over = 0; //0: 是, 1: 否

    public ShowDatabaseTable(String account, String dbName) throws InterruptedException {
        super(dbName);
        this.account = account;
        this.dbName = dbName;

        DatabaseReference ref = FireBaseService.getDb().getReference("/"+account+"/"+dbName);
        list= new ArrayList<>();
        ref.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Object document = dataSnapshot.getValue();
                String word="";
                String partOfSpeech="";
                String chineseDefinition="";
                String englishDefinition="";
                String temp="";
                boolean start=false;
                int count=0;

                for(int i=0;i<document.toString().length();i++){
                    if((start) && (document.toString().toCharArray()[i]!=',') && (document.toString().toCharArray()[i]!='}')){
                        temp=temp+document.toString().toCharArray()[i];
                    }
                    if(document.toString().toCharArray()[i]=='='){
                        start = true;
                    }
                    if((document.toString().toCharArray()[i]==',') || (document.toString().toCharArray()[i]=='}')){
                        start=false;
                        if(count==0){
                            chineseDefinition=temp;
                        }else if(count==1){
                            partOfSpeech=temp;
                        }else if(count==2){
                            englishDefinition=temp;
                        }else if(count==3){
                            word=temp;
                        }
                        count=count+1;
                        if(count==4){
                            list.add(new Word(word,partOfSpeech,chineseDefinition,englishDefinition));
                            count=-1;
                        }
                        temp="";
                    }
                }

                addToTable();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {}
        });

        recordPanel = new JPanel();
        recordPanel.setLayout(new GridLayout(1, 2)); //1列2行(按鈕並排)
        showButton = new JButton("新增");
        leaveButton = new JButton("離開");

        showButton.setFont(new Font("Serif", Font.BOLD, 20));
        leaveButton.setFont(new Font("Serif", Font.BOLD, 20));

        showButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    showResult();
                }catch(Exception exception){
                    System.out.println(exception.getMessage());
                }
            }
        });
        leaveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        recordPanel.add(showButton); //加入按紐
        recordPanel.add(leaveButton); //加入按紐

        add(recordPanel, BorderLayout.SOUTH); //recordPanel版面設置BorderLayout.SOUTH，並加到視窗上，

        setSize(1000,625);
        GUIUtil.toCenter(this);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void addToTable(){
        //try {
            try{
                data = convertArrayList2Array(list);
            }catch(Exception exception){
                JOptionPane.showMessageDialog(this,"很抱歉，此資料庫為空");
            }
            playersTable = new JTable(data, COLUME_NAMES); //建立表格，表格的欄位為COLUME_NAMES陣列裡的字串
            playersTable.setFont(new Font("Serif", Font.BOLD, 16));
            playersTable.setForeground(new Color(102, 156, 177));
            playersTable.setBackground(new Color(220, 255, 223));
            tableWithScrollBar = new JScrollPane(playersTable); //幫表格放在可滾動的面板上
            playersTable.setRowHeight(30);
            TableColumn column = playersTable.getColumnModel().getColumn(3);
            column.setPreferredWidth(300);
            add(tableWithScrollBar, BorderLayout.CENTER); //加到視窗內，放在BorderLayout.CENTER的位置
            validate();
        //}catch(Exception e){
        //    JOptionPane.showMessageDialog(this,"尚未輸入資料喔!");
        //}
    }

    public void showResult(){
        String word = "";
        String partOfSpeech = "";
        String chineseDefinition = "";
        String englishDefinition = "";

        try {
            if (VocabularyFrame.count >= 20) {
                JOptionPane.showMessageDialog(this, "很抱歉，數量已達上限(20)，無法再新增了喔~");
            } else {
                int row = playersTable.getSelectedRow();
                for (int j = 0; j < 4; j++) {
                    Object tempWord = playersTable.getModel().getValueAt(row, j);
                    if (j == 0) {
                        word = tempWord.toString();
                        VocabularyFrame.jtaShowChoice.append(tempWord.toString());
                    } else {
                        if (j == 1) {
                            partOfSpeech = tempWord.toString();
                        } else if (j == 2) {
                            chineseDefinition = tempWord.toString();
                        } else if (j == 3) {
                            englishDefinition = tempWord.toString();
                        }
                        VocabularyFrame.jtaShowChoice.append(" "+tempWord.toString());
                    }
                }
                Word tempWord = new Word(word, partOfSpeech, chineseDefinition, englishDefinition);
                VocabularyFrame.cardData.add(tempWord);
                VocabularyFrame.count = VocabularyFrame.count + 1;
                VocabularyFrame.jtaShowChoice.append("\n");
                VocabularyFrame.jlNumber.setText("          已選 " + VocabularyFrame.count + " 個，上限 20 個          ");
            }
        }catch(Exception exception){
            JOptionPane.showMessageDialog(this,"很抱歉，您尚未選取單字");
        }
    }


    public static String[][] convertArrayList2Array(ArrayList<Word> list) { //把list轉成字串陣列(二維)
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
}
