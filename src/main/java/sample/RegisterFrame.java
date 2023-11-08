package sample;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegisterFrame extends JFrame implements ActionListener{
    private JLabel lbAccount=new JLabel("請輸入帳號");
    private JTextField tfAccount;
    private JLabel lbPassword=new JLabel("請輸入密碼");
    private JPasswordField pfPassword;
    private JLabel lbPassword2=new JLabel("再次輸入密碼");
    private JPasswordField pfPassword2;
    private JButton btRegister=new JButton("註冊");
    private JButton btLogin=new JButton("登錄");
    private JButton btExit=new JButton("退出");
    private JPanel jp1,jp2,jp3,jp4;

    public RegisterFrame() {
        super("註冊");
        this.setLayout(new FlowLayout());
        tfAccount=new JTextField(20);
        pfPassword=new JPasswordField(20);
        pfPassword2=new JPasswordField(20);
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();
        jp1.add(lbAccount);
        jp1.add(tfAccount);
        jp2.add(lbPassword);
        jp2.add(pfPassword);
        jp3.add(lbPassword2);
        jp3.add(pfPassword2);
        jp4.add(btRegister);
        jp4.add(btLogin);
        jp4.add(btExit);
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.add(jp4);

        this.setSize(500,220);
        this.setLayout(new GridLayout(4,1));
        GUIUtil.toCenter(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setVisible(true);
        btLogin.addActionListener(this);
        btRegister.addActionListener(this);
        btExit.addActionListener(this);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()==btRegister) {
            String account1=new String(tfAccount.getText());
            String password1=new String(pfPassword.getPassword());
            String password2=new String(pfPassword2.getPassword());
            if(account1.length()== 0 || password1.length()== 0) {
                JOptionPane.showMessageDialog(this,"帳號密碼不可為空");
                return;
            }
            if(!password1.equals(password2)) {
                JOptionPane.showMessageDialog(this,"兩個密碼不相同");
                return;
            }
            String account=tfAccount.getText();
            File.getInfoByAccount(account);
            if(User.account!=null) {
                JOptionPane.showMessageDialog(this,"用戶已經註冊");
                return;
            }
            File.updateCustomer(account,password1);
            JOptionPane.showMessageDialog(this,"註冊成功");
        }
        else if(e.getSource()==btLogin) {
            this.dispose();
            new LoginFrame();
        }
        else {
            this.dispose();
            new LoginFrame();
            //System.exit(0);
        }
    }
}

