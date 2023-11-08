package sample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
public class LoginFrame extends JFrame{
	private JFrame jf1;
	private JPanel jp1,jp2,jp3,jp4,jp5,imagePanel,Jpanel1;
	private JTextField jtf1;
	private JPasswordField jpf1;
	private JLabel jlb1,jlb2,JLabel1;
	private JButton jb1,jb2,jb3;
	ImageIcon background;

    public LoginFrame(){
    	jf1 = new JFrame();
        jlb1 = new JLabel("帳號：");
        jtf1 = new JTextField(20);
        jlb2 = new JLabel("密碼：");
        jpf1 = new JPasswordField(20);
        jb1 = new JButton("登入");
        jb2 = new JButton("註冊");
        jb3 = new JButton("訪客登入");

        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if(jtf1.getText().trim().length()==0||new String(jpf1.getPassword()).trim().length()==0){   
                    JOptionPane.showMessageDialog(jf1,"帳號密碼不可為空");
                }
                String account = jtf1.getText();
                String password = new String(jpf1.getPassword());
                File.getInfoByAccount(account);
                if(jtf1.getText().trim().length()!=0 && new String(jpf1.getPassword()).trim().length()!=0) {
                	if(User.account==null) {
                    	JOptionPane.showMessageDialog(jf1, "尚未註冊"); 
                    	return; 
                	}
                    else if(!User.password.equals(password)) {
                    	JOptionPane.showMessageDialog(jf1, "帳號或密碼錯誤"); 
                    	return; 
                    }
                    else{
                        JOptionPane.showMessageDialog(jf1, "登入成功");
                        User.setLogin(true);
                        new UI();
                        jf1.dispose();
                    }
                }  
          }
        });
        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	jf1.dispose();
                new RegisterFrame();
            }
        });

        jb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jf1.dispose();
                new UI();
            }
        });
        

        String path = "pictures/Engrave2.jpg";
        background = new ImageIcon(path);       // 背景圖片
	    Jpanel1 = new JPanel(); 
	    JLabel1 = new JLabel(background);
	    Jpanel1.add(JLabel1);
	    Jpanel1.setOpaque(false);
      
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();
        jp5 = new JPanel();
        jf1.setLayout(new GridLayout(2,1));
        jf1.add(Jpanel1);
        jf1.add(jp4);
        jp4.add(jp1);
        jp4.add(jp2);
        jp4.add(jp3);
        jp1.add(jlb1);
        jp1.add(jtf1);
        jp2.add(jlb2);
        jp2.add(jpf1);
        jp3.add(jb1);
        jp3.add(jb2);
        jp3.add(jb3);
        jp4.setLayout(new GridLayout(5,1));
        jp1.setBackground(Color.white);
        jp2.setBackground(Color.white);
        jp3.setBackground(Color.white);
        jp4.setBackground(Color.white);
        jf1.setBackground(Color.white);
        JLabel1.setBackground(Color.white);
        Jpanel1.setBackground(Color.white);


        jf1.setTitle("Engrave英文學習應用平台");
        jf1.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //jf1.setSize(1000,625);
        GUIUtil.toCenter(jf1);
        //jf1.setLocation(500, 100);
        jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf1.setVisible(true);
    }

    public static void main(String[] args) {
    	LoginFrame login = new LoginFrame();
    }


}