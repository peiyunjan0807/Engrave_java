package sample;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PrivateVocabulary extends JFrame {
    public JPanel upPanel = new JPanel();
    public JButton jbSearch;
    public ImageIcon iconSearchButton;
    public JTextField jtfSearch;
    public JLabel lbSearch = new JLabel();
    public JTextArea jtaShow = new JTextArea();
    ArrayList<String> database;

    public PrivateVocabulary(){

        super("個人單字庫");

        String pathSearch = "pictures/search.jpg";
        iconSearchButton = new ImageIcon(pathSearch);
        jbSearch = new JButton(iconSearchButton);
        jtfSearch = new JTextField("",20);
        jtfSearch.setFont(new Font("TimesRoman",Font.PLAIN,25));
        lbSearch.setText("搜尋資料庫： ");
        jbSearch.setBackground(Color.white);
        lbSearch.setFont(new Font("Serif",Font.BOLD,20));
        upPanel.add(lbSearch,BorderLayout.WEST);
        upPanel.add(jtfSearch,BorderLayout.CENTER);
        upPanel.add(jbSearch,BorderLayout.EAST);
        add(upPanel,BorderLayout.NORTH);
        jtaShow.setText("\n");
        jtaShow.setFont(new Font("TimesRoman",Font.BOLD,25));
        jtaShow.setEditable(false);
        add(jtaShow,BorderLayout.CENTER);

        if(User.getLogin()){
            getDatabase();
        }

        jbSearch.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(VocabularyFrame.count>=20){
                    JOptionPane.showMessageDialog(null,"很抱歉，數量已達上限(20)，無法再新增了喔~");
                }else {
                    String dbName = jtfSearch.getText();
                    DbFile.getInfoByAccount(dbName);
                    if (DB.account != null) {
                        if (User.getLogin()) {
                            String account = User.account;
                            try {
                                new ShowDatabaseTable(account, dbName);
                            } catch (InterruptedException interruptedException) {
                                interruptedException.printStackTrace();
                            }
                        } else {
                            String inputPassword;
                            inputPassword = JOptionPane.showInputDialog("此為私人單字庫，請輸入密碼");
                            while (!DB.password.equals(inputPassword)) {
                                JOptionPane.showMessageDialog(null, "密碼錯誤!");
                                inputPassword = JOptionPane.showInputDialog("此為私人單字庫，請輸入密碼");
                            }
                            if (DB.password.equals(inputPassword)) {
                                JOptionPane.showMessageDialog(null, "密碼正確!");
                                String account = "";
                                for (int i = 0; i < dbName.length(); i++) {
                                    if (dbName.toCharArray()[i] != '\'') {
                                        account = account + dbName.toCharArray()[i];
                                    } else {
                                        break;
                                    }
                                }
                                try {
                                    new ShowDatabaseTable(account, dbName);
                                } catch (InterruptedException interruptedException) {
                                    interruptedException.printStackTrace();
                                }
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "查無此資料庫");
                    }

                    dispose();
                }
            }
        });

        //如果成功進入則呼叫PrintDataFromDatabase
        setSize(1000,625);
        GUIUtil.toCenter(this);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void getDatabase(){

        database = new ArrayList<>();
        DatabaseReference ref = FireBaseService.getDb()
                .getReference("/"+User.account);

        ref.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot zoneSnapshot: dataSnapshot.getChildren()) {
                    jtaShow.append(zoneSnapshot.getKey()+"\n");
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {}
        });
    }
}

