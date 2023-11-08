package sample;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GrammarFrame {
	private JFrame grammarFrame1;
	private JLabel title;
	private JTextField grammarJTextField1;
	private JTextArea showGrammar;
	private JButton homeButton;
	private JButton one,two,three,four,five,six,seven,eight,nine,ten,eleven,twelve,thirteen,fourteen;
	private JPanel homePanel, chapter;
	private JScrollPane scrollBar;
	//ImageIcon iconGrammarJButton1;

	public GrammarFrame() {
		grammarFrame1 = new JFrame();
		grammarFrame1.setTitle("Engrave英文學習應用平台");
		//grammarFrame1.setSize(1000,625);
		grammarFrame1.setExtendedState(JFrame.MAXIMIZED_BOTH);
		grammarFrame1.setLocation(500, 100);
		grammarFrame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		grammarFrame1.setVisible(true);

		//標題
		title = new JLabel("Grammar", JLabel.CENTER);
		title.setFont(title.getFont().deriveFont(60f));
		grammarFrame1.add(title, BorderLayout.NORTH);
		homeButton = new JButton("回首頁");
		homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	grammarFrame1.dispose();
                new UI();
            }
        });
		homePanel = new JPanel();
		homePanel.add(homeButton);

	    //all grammar
	    showGrammar = new JTextArea();
	    showGrammar.setBorder(new EmptyBorder(5, 10, 0, 10));
		showGrammar.setEditable(false);
		showGrammar.setFont(new Font("TimesRoman", Font.PLAIN, 18));
		//showGrammar.setCaretPosition(0);
	    chapter = new JPanel(new GridLayout(15,1, 1, 1));
	    chapter.setBorder(new EmptyBorder(0, 5, 3, 8));
	    one = new JButton("五大句型");
	    one.setBackground(new Color(23, 174, 199));
		one.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showGrammar.setText("");
				ReadGrammar rg = new ReadGrammar("grammar/1.txt");
				String[] temp = rg.read();
				int num = rg.returnNum();
				for(int i=0; i<num; i++)
					showGrammar.append(temp[i]+"\n");
				showGrammar.setCaretPosition(0);
			}
		});
		two = new JButton("時態");
		two.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showGrammar.setText("");
				ReadGrammar rg = new ReadGrammar("grammar/2.txt");
				String[] temp = rg.read();
				int num = rg.returnNum();
				for(int i=0; i<num; i++)
					showGrammar.append(temp[i]+"\n");
				showGrammar.setCaretPosition(0);
			}
		});
		three = new JButton("被動語態");
		//three.setPreferredSize(new Dimension(256, 256));
		three.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showGrammar.setText("");
				ReadGrammar rg = new ReadGrammar("grammar/3.txt");
				String[] temp = rg.read();
				int num = rg.returnNum();
				for(int i=0; i<num; i++)
					showGrammar.append(temp[i]+"\n");
				showGrammar.setCaretPosition(0);
			}
		});
		four = new JButton("假設語氣");
		four.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showGrammar.setText("");
				ReadGrammar rg = new ReadGrammar("grammar/4.txt");
				String[] temp = rg.read();
				int num = rg.returnNum();
				for(int i=0; i<num; i++)
					showGrammar.append(temp[i]+"\n");
				showGrammar.setCaretPosition(0);
			}
		});
		five = new JButton("動名詞");
		five.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showGrammar.setText("");
				ReadGrammar rg = new ReadGrammar("grammar/5.txt");
				String[] temp = rg.read();
				int num = rg.returnNum();
				for(int i=0; i<num; i++)
					showGrammar.append(temp[i]+"\n");
				showGrammar.setCaretPosition(0);
			}
		});
		six = new JButton("不定詞");
		six.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showGrammar.setText("");
				ReadGrammar rg = new ReadGrammar("grammar/6.txt");
				String[] temp = rg.read();
				int num = rg.returnNum();
				for(int i=0; i<num; i++)
					showGrammar.append(temp[i]+"\n");
				showGrammar.setCaretPosition(0);
			}
		});
		seven = new JButton("分詞");
		seven.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showGrammar.setText("");
				ReadGrammar rg = new ReadGrammar("grammar/7.txt");
				String[] temp = rg.read();
				int num = rg.returnNum();
				for(int i=0; i<num; i++)
					showGrammar.append(temp[i]+"\n");
				showGrammar.setCaretPosition(0);
			}
		});
		eight = new JButton("助動詞");
		eight.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showGrammar.setText("");
				ReadGrammar rg = new ReadGrammar("grammar/8.txt");
				String[] temp = rg.read();
				int num = rg.returnNum();
				for(int i=0; i<num; i++)
					showGrammar.append(temp[i]+"\n");
				showGrammar.setCaretPosition(0);
			}
		});
		nine = new JButton("附加問句");
		nine.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showGrammar.setText("");
				ReadGrammar rg = new ReadGrammar("grammar/9.txt");
				String[] temp = rg.read();
				int num = rg.returnNum();
				for(int i=0; i<num; i++)
					showGrammar.append(temp[i]+"\n");
				showGrammar.setCaretPosition(0);
			}
		});
		ten = new JButton("副詞");
		ten.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showGrammar.setText("");
				ReadGrammar rg = new ReadGrammar("grammar/10.txt");
				String[] temp = rg.read();
				int num = rg.returnNum();
				for(int i=0; i<num; i++)
					showGrammar.append(temp[i]+"\n");
				showGrammar.setCaretPosition(0);
			}
		});
		eleven = new JButton("關係代名詞");
		eleven.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showGrammar.setText("");
				ReadGrammar rg = new ReadGrammar("grammar/11.txt");
				String[] temp = rg.read();
				int num = rg.returnNum();
				for(int i=0; i<num; i++)
					showGrammar.append(temp[i]+"\n");
				showGrammar.setCaretPosition(0);
			}
		});
		twelve = new JButton("連接詞");
		twelve.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showGrammar.setText("");
				ReadGrammar rg = new ReadGrammar("grammar/12.txt");
				String[] temp = rg.read();
				int num = rg.returnNum();
				for(int i=0; i<num; i++)
					showGrammar.append(temp[i]+"\n");
				showGrammar.setCaretPosition(0);
			}
		});
		thirteen = new JButton("介係詞");
		thirteen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showGrammar.setText("");
				ReadGrammar rg = new ReadGrammar("grammar/13.txt");
				String[] temp = rg.read();
				int num = rg.returnNum();
				for(int i=0; i<num; i++)
					showGrammar.append(temp[i]+"\n");
				showGrammar.setCaretPosition(0);
			}
		});
		fourteen = new JButton("冠詞");
		fourteen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showGrammar.setText("");
				ReadGrammar rg = new ReadGrammar("grammar/14.txt");
				String[] temp = rg.read();
				int num = rg.returnNum();
				for(int i=0; i<num; i++)
					showGrammar.append(temp[i]+"\n");
				showGrammar.setCaretPosition(0);
			}
		});

		scrollBar = new JScrollPane(showGrammar);
		chapter.add(homePanel);
		chapter.add(one);
		chapter.add(two);
		chapter.add(three);
		chapter.add(four);
		chapter.add(five);
		chapter.add(six);
		chapter.add(seven);
		chapter.add(eight);
		chapter.add(nine);
		chapter.add(ten);
		chapter.add(eleven);
		chapter.add(twelve);
		chapter.add(thirteen);
		chapter.add(fourteen);

		grammarFrame1.add(chapter, BorderLayout.WEST);
		grammarFrame1.add(scrollBar, BorderLayout.CENTER);
	}
}