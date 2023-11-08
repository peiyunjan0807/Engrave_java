package sample;

import jxl.read.biff.BiffException;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

public class InitialTable extends JFrame {
    private static final String[] COLUME_NAMES = { "單字", "詞性", "中文解釋", "英文解釋" };

    private JTable playersTable;
    private JScrollPane tableWithScrollBar;

    private JPanel recordPanel;
    private JButton addButton;
    private JButton leaveButton;

    // Constructor
    public InitialTable() throws BiffException, IOException { //視窗介面設定

        super("Initial Vocabulary");

        recordPanel = new JPanel();
        recordPanel.setLayout(new GridLayout(1, 2)); //1列2行(按鈕並排)
        addButton = new JButton("加入清單");
        leaveButton = new JButton("離開");

        MyEventHandler handler = new MyEventHandler();

        addButton.addActionListener(handler);
        leaveButton.addActionListener(handler);

        recordPanel.add(addButton); //加入按紐
        recordPanel.add(leaveButton); //加入按紐

        add(recordPanel, BorderLayout.SOUTH); //recordPanel版面設置BorderLayout.SOUTH，並加到視窗上，

        fillData();

        setSize(1000,625);
        GUIUtil.toCenter(this);
        setVisible(true);
    }

    public String[][] readAllPlayers() throws BiffException, IOException {
        ArrayList<Word> list = readRecords(); //得到list
        String[][] listArray = convertArrayList2Array(list); //再把list轉成字串陣列(二維)

        return listArray;
    }

    private void addToList() throws BiffException, IOException {
        String word = "";
        String partOfSpeech = "";
        String chineseDefinition = "";
        String englishDefinition = "";
        if(VocabularyFrame.count>=20){
            JOptionPane.showMessageDialog(this,"很抱歉，數量已達上限(20)，無法再新增了喔~");
        }else {
            int row = playersTable.getSelectedRow();
            for (int i = 0; i < 4; i++) {
                Object tempWord = playersTable.getModel().getValueAt(row, i);
                if (i == 0) {
                    word = tempWord.toString();
                    VocabularyFrame.jtaShowChoice.append(tempWord.toString());
                } else {
                    if (i == 1) {
                        partOfSpeech = tempWord.toString();
                    } else if (i == 2) {
                        chineseDefinition = tempWord.toString();
                    } else if (i == 3) {
                        englishDefinition = tempWord.toString();
                    }
                    VocabularyFrame.jtaShowChoice.append(" "+tempWord.toString());
                }
            }
            Word tempWord = new Word(word, partOfSpeech, chineseDefinition, englishDefinition);
            VocabularyFrame.cardData.add(tempWord);
            VocabularyFrame.count = VocabularyFrame.count + 1;
            VocabularyFrame.jtaShowChoice.append("\n");
            VocabularyFrame.jlNumber.setText("          已選 "+VocabularyFrame.count+" 個，上限 20 個          ");
        }
    }

    private void fillData() throws BiffException, IOException {

        String[][] data = readAllPlayers();
        playersTable = new JTable(data, COLUME_NAMES); //建立表格，表格的欄位為COLUME_NAMES陣列裡的字串
        playersTable.setFont(new Font("Serif",Font.BOLD,16));
        playersTable.setForeground(new Color(102, 156, 177));
        playersTable.setBackground(new Color(220, 255, 223));
        tableWithScrollBar = new JScrollPane(playersTable); //幫表格放在可滾動的面板上
        playersTable.setRowHeight (30);
        TableColumn column = playersTable.getColumnModel().getColumn(3);
        column.setPreferredWidth(300);
        add(tableWithScrollBar, BorderLayout.CENTER); //加到視窗內，放在BorderLayout.CENTER的位置
    }

    private class MyEventHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == addButton) {
                try {
                    addToList();
                } catch (BiffException biffException) {
                    biffException.printStackTrace();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (ArrayIndexOutOfBoundsException exception){
                    JOptionPane.showMessageDialog(null,"很抱歉，您尚未選擇資料");
                }
            } else if (e.getSource() == leaveButton) {
                dispose();
            }
        }
    }

    public ArrayList<Word> readRecords() throws BiffException, IOException {
        ArrayList<Word> list = new ArrayList<Word>();

        //System.out.printf("%-12s%-12s%10s%n", "First Name", "Last Name", "Balance");

        InitialDataReadFromExcel id = new InitialDataReadFromExcel();
        String data[][][];
        int sheetWordNum[] = id.getSheetWordNum();
        data = id.getData();

        String tempWord="",tempPartOfSpeech="",tempChinese="",tempEnglish="";
        for(int i=0;i<26;i++){
            for(int j=1;j<=sheetWordNum[i];j++){
                tempWord = data[i][j][1];
                tempPartOfSpeech = data[i][j][2];
                tempChinese = data[i][j][3];
                tempEnglish = data[i][j][4];
                Word tempVoc = new Word(tempWord,tempPartOfSpeech,tempChinese,tempEnglish);
                list.add(tempVoc);
            }
        }

        return list; //回傳清單
    } // end method readRecords

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
}
