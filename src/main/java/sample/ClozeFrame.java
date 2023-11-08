package sample;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClozeFrame {
	private JFrame clozeFrame1;
	private JButton clozeJButton1,clozeJButton2,AJButton,AJButtonA_a,AJButtonA_b,AJButtonA_c,AJButtonA_d,AJButtonA_b1,AJButtonA_b2,AJButtonA_b3,AJButtonA_b4;
	private JButton AJButtonA_c1,AJButtonA_c2,AJButtonA_c3,AJButtonA_c4,AJButtonA_d1,AJButtonA_d2,AJButtonA_d3,AJButtonA_d4,clozeJButton3,clozeJButton4;
	private JButton BJButtonA_a,BJButtonA_b,BJButtonA_c,BJButtonA_d,BJButtonA_b1,BJButtonA_b2,BJButtonA_b3,BJButtonA_b4;
	private JButton BJButtonA_c1,BJButtonA_c2,BJButtonA_c3,BJButtonA_c4,BJButtonA_d1,BJButtonA_d2,BJButtonA_d3,BJButtonA_d4;
	private JButton CJButtonA_a,CJButtonA_b,CJButtonA_c,CJButtonA_d,CJButtonA_b1,CJButtonA_b2,CJButtonA_b3,CJButtonA_b4;
	private JButton CJButtonA_c1,CJButtonA_c2,CJButtonA_c3,CJButtonA_c4,CJButtonA_d1,CJButtonA_d2,CJButtonA_d3,CJButtonA_d4;
	private JButton DJButtonA_a,DJButtonA_b,DJButtonA_c,DJButtonA_d,DJButtonA_b1,DJButtonA_b2,DJButtonA_b3,DJButtonA_b4;
	private JButton DJButtonA_c1,DJButtonA_c2,DJButtonA_c3,DJButtonA_c4,DJButtonA_d1,DJButtonA_d2,DJButtonA_d3,DJButtonA_d4;
	private JButton AJButton1, AJButton2, AJButton3;
	private JPanel clozeJPanel1,clozeJPanel2,AJPanel,AJPanel2,AJPanel3,AJPanel4,AJPanel5,AJPanel6,centerJPanel,centerJPanelA;
	private JPanel BJPanel2,BJPanel3,BJPanel4,BJPanel5,BJPanel6,centerJPanelB;
	private JPanel CJPanel2,CJPanel3,CJPanel4,CJPanel5,CJPanel6,centerJPanelC;
	private JPanel DJPanel2,DJPanel3,DJPanel4,DJPanel5,DJPanel6,centerJPanelD;
	private JPanel topic1, topic2, topic3, topic4, answer1, answer2, answer3, answer4;
	private JLabel AJLabel1,AJLabel2,AJLabel3,AJLabel4,AJLabel5,AJLabel7,AJLabel6,AJLabel8,AJLabel9,AJLabel10,AJLabel11,title;
	private JLabel BJLabel1,BJLabel2,BJLabel3,BJLabel4,BJLabel5,BJLabel7,BJLabel6,BJLabel8,BJLabel9,BJLabel10,BJLabel11;
	private JLabel CJLabel1,CJLabel2,CJLabel3,CJLabel4,CJLabel5,CJLabel7,CJLabel6,CJLabel8,CJLabel9,CJLabel10,CJLabel11;
	private JLabel DJLabel1,DJLabel2,DJLabel3,DJLabel4,DJLabel5,DJLabel7,DJLabel6,DJLabel8,DJLabel9,DJLabel10,DJLabel11;
	private JLabel emptyLabelA1, emptyLabelA2, emptyLabelA3, emptyLabelA4;
	private JLabel emptyLabelB1, emptyLabelB2, emptyLabelB3, emptyLabelB4;
	private JLabel emptyLabelC1, emptyLabelC2, emptyLabelC3, emptyLabelC4;
	private JLabel emptyLabelD1, emptyLabelD2, emptyLabelD3, emptyLabelD4;
	ImageIcon iconClozeJButton1,iconClozeJButton2,iconClozeJButton3,iconClozeJButton4;

	public ClozeFrame() {
		clozeFrame1 = new JFrame();
		clozeFrame1.setBackground(Color.white);
		title = new JLabel("Cloze", JLabel.CENTER);
		title.setFont(title.getFont().deriveFont(60f));

		String pathClozeB = "pictures/clozeB.jpg";
		String pathClozeA = "pictures/clozeA.jpg";
		String pathClozeC = "pictures/clozeC.jpg";
		String pathClozeD = "pictures/clozeD.jpg";
		iconClozeJButton1	= new ImageIcon(pathClozeB);
		iconClozeJButton2   = new ImageIcon(pathClozeA);
		iconClozeJButton3   = new ImageIcon(pathClozeC);
		iconClozeJButton4   = new ImageIcon(pathClozeD);
		clozeJButton2 = new JButton("回首頁");
		clozeJButton2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new UI();
				clozeFrame1.dispose();
			}
		});
		clozeJButton3 = new JButton("題目");

		GridLayout gdButton = new GridLayout(12,1, 5, 5);
		clozeJPanel1 = new JPanel();
		clozeFrame1.add(clozeJPanel1,BorderLayout.WEST);
		clozeJPanel1.add(clozeJButton2);//回首頁
		clozeJPanel1.add(clozeJButton3);//上一頁
		clozeJPanel1.setLayout(gdButton);
		clozeJPanel1.setBackground(Color.white);
		clozeJPanel1.setBorder(new EmptyBorder(0, 10, 0, 0));

		clozeJPanel2 = new JPanel();
		clozeFrame1.add(clozeJPanel2,BorderLayout.NORTH);
		clozeJPanel2.add(title);
		clozeJPanel2.setBackground(Color.white);

		GridLayout AButton = new GridLayout(2,2);
		centerJPanel = new JPanel();
		clozeFrame1.add(centerJPanel,BorderLayout.CENTER);
		centerJPanel.setLayout(new GridLayout(1,1));
		AJButton = new JButton(iconClozeJButton2);
		AJButton1 = new JButton(iconClozeJButton1);
		AJButton2 = new JButton(iconClozeJButton3);
		AJButton3 = new JButton(iconClozeJButton4);
		AJPanel = new JPanel();
		AJPanel.add(AJButton);
		AJPanel.add(AJButton1);
		AJPanel.add(AJButton2);
		AJPanel.add(AJButton3);
		AJPanel.setLayout(AButton);
		AJPanel.setBackground(Color.white);
		AJPanel.setBorder(new EmptyBorder(0, 20, 20, 20));
		centerJPanel.add(AJPanel,BorderLayout.CENTER);
		centerJPanel.setBackground(Color.white);

		clozeJButton3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				centerJPanel.removeAll();
				centerJPanel.add(AJPanel,BorderLayout.CENTER);
				centerJPanel.revalidate();
				centerJPanel.repaint();
			}
		});

		//第一題
		topic1 = new JPanel();
		GridLayout gd = new GridLayout(7,1);
		AJLabel1 = new JLabel("A.");
		AJLabel2 = new JLabel("		Since the earliest of times, people have considered the pearl to be one of nature's most beautiful creations.\n ");
		AJLabel3 = new JLabel("		To the oyster, however, it is not valuable __a__ the pearl is actually a disease of that mollusk.\n ");
		AJLabel4 = new JLabel("		It begins when a tiny piece of sand finds its way into the oyster's shell, __b__ it soon starts to irritate the flesh.\n ");
		AJLabel5 = new JLabel("		 __c__self-protection, the oyster covers the irritant with a calcium-based substance called nacre.\n ");
		AJLabel6 = new JLabel("		But the presence of a __d__ body inside the shell continues to annoy the oyster.\n ");
		AJLabel7 = new JLabel("		The mollusk responds by adding thicker coats of nacre, resulting in a pearl.\n");
		AJLabel1.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		AJLabel2.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		AJLabel3.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		AJLabel4.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		AJLabel5.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		AJLabel6.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		AJLabel7.setFont(new Font("TimesRoman", Font.PLAIN, 20));

		AJPanel2 = new JPanel();
		AJPanel2.add(AJLabel1);
		AJPanel2.add(AJLabel2);
		AJPanel2.add(AJLabel3);
		AJPanel2.add(AJLabel4);
		AJPanel2.add(AJLabel5);
		AJPanel2.add(AJLabel6);
		AJPanel2.add(AJLabel7);
		AJPanel2.setLayout(gd);
		AJPanel2.setBackground(Color.white);
		topic1.add(AJPanel2, BorderLayout.CENTER);
		topic1.setBorder(new EmptyBorder(0, 0, 35, 0));
		topic1.setBackground(Color.white);

		GridLayout gd3 = new GridLayout(1,6, 5, 0);
		AJLabel8 = new JLabel("A-a", SwingConstants.CENTER);
		emptyLabelA1 = new JLabel("");
		AJButtonA_a = new JButton("(1)	so	");
		AJButtonA_b = new JButton("(2)	as	");
		AJButtonA_c = new JButton("(3)	notwithstanding	");
		AJButtonA_d = new JButton("(4)	nevertheless	");
		AJPanel3 = new JPanel();
		AJPanel3.add(AJLabel8);
		AJPanel3.add(AJButtonA_a);
		AJPanel3.add(AJButtonA_b);
		AJPanel3.add(AJButtonA_c);
		AJPanel3.add(AJButtonA_d);
		AJPanel3.add(emptyLabelA1);
		AJPanel3.setLayout(gd3);
		AJPanel3.setBackground(Color.white);
		AJButtonA_a.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AJButtonA_a.setForeground(Color.red);
				AJButtonA_b.setForeground(Color.black);
				AJButtonA_c.setForeground(Color.black);
				AJButtonA_d.setForeground(Color.black);
			}
		});
		AJButtonA_b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AJButtonA_a.setForeground(Color.black);
				AJButtonA_b.setForeground(Color.blue);
				AJButtonA_c.setForeground(Color.black);
				AJButtonA_d.setForeground(Color.black);
			}
		});
		AJButtonA_c.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AJButtonA_a.setForeground(Color.black);
				AJButtonA_b.setForeground(Color.black);
				AJButtonA_c.setForeground(Color.red);
				AJButtonA_d.setForeground(Color.black);
			}
		});
		AJButtonA_d.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AJButtonA_a.setForeground(Color.black);
				AJButtonA_b.setForeground(Color.black);
				AJButtonA_c.setForeground(Color.black);
				AJButtonA_d.setForeground(Color.red);
			}
		});

		AJLabel9 = new JLabel("A-b", SwingConstants.CENTER);
		emptyLabelA2 = new JLabel("");
		AJButtonA_b1 = new JButton("(1)	when	");
		AJButtonA_b2 = new JButton("(2)	which	");
		AJButtonA_b3 = new JButton("(3)	where	");
		AJButtonA_b4 = new JButton("(4)	however	");
		AJPanel4 = new JPanel();
		AJPanel4.add(AJLabel9);
		AJPanel4.add(AJButtonA_b1);
		AJPanel4.add(AJButtonA_b2);
		AJPanel4.add(AJButtonA_b3);
		AJPanel4.add(AJButtonA_b4);
		AJPanel4.add(emptyLabelA2);
		AJPanel4.setLayout(gd3);
		AJPanel4.setBackground(Color.white);
		AJButtonA_b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AJButtonA_b1.setForeground(Color.red);
				AJButtonA_b2.setForeground(Color.black);
				AJButtonA_b3.setForeground(Color.black);
				AJButtonA_b4.setForeground(Color.black);
			}
		});
		AJButtonA_b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AJButtonA_b1.setForeground(Color.black);
				AJButtonA_b2.setForeground(Color.red);
				AJButtonA_b3.setForeground(Color.black);
				AJButtonA_b4.setForeground(Color.black);
			}
		});
		AJButtonA_b3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AJButtonA_b1.setForeground(Color.black);
				AJButtonA_b2.setForeground(Color.black);
				AJButtonA_b3.setForeground(Color.blue);
				AJButtonA_b4.setForeground(Color.black);
			}
		});
		AJButtonA_b4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AJButtonA_b1.setForeground(Color.black);
				AJButtonA_b2.setForeground(Color.black);
				AJButtonA_b3.setForeground(Color.black);
				AJButtonA_b4.setForeground(Color.red);
			}
		});

		AJLabel10 = new JLabel("A-c", SwingConstants.CENTER);
		emptyLabelA3 = new JLabel("");
		AJButtonA_c1 = new JButton("(1)	In	");
		AJButtonA_c2 = new JButton("(2)	With	");
		AJButtonA_c3 = new JButton("(3)	On	");
		AJButtonA_c4 = new JButton("(4)	To	");
		AJPanel5 = new JPanel();
		AJPanel5.add(AJLabel10);
		AJPanel5.add(AJButtonA_c1);
		AJPanel5.add(AJButtonA_c2);
		AJPanel5.add(AJButtonA_c3);
		AJPanel5.add(AJButtonA_c4);
		AJPanel5.add(emptyLabelA3);
		AJPanel5.setSize(300, 100);
		AJPanel5.setLayout(gd3);
		AJPanel5.setBackground(Color.white);
		AJButtonA_c1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AJButtonA_c1.setForeground(Color.blue);
				AJButtonA_c2.setForeground(Color.black);
				AJButtonA_c3.setForeground(Color.black);
				AJButtonA_c4.setForeground(Color.black);
			}
		});
		AJButtonA_c2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AJButtonA_c1.setForeground(Color.black);
				AJButtonA_c2.setForeground(Color.red);
				AJButtonA_c3.setForeground(Color.black);
				AJButtonA_c4.setForeground(Color.black);
			}
		});
		AJButtonA_c3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AJButtonA_c1.setForeground(Color.black);
				AJButtonA_c2.setForeground(Color.black);
				AJButtonA_c3.setForeground(Color.red);
				AJButtonA_c4.setForeground(Color.black);
			}
		});
		AJButtonA_c4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AJButtonA_c1.setForeground(Color.black);
				AJButtonA_c2.setForeground(Color.black);
				AJButtonA_c3.setForeground(Color.black);
				AJButtonA_c4.setForeground(Color.red);
			}
		});

		AJLabel11 = new JLabel("A-d", SwingConstants.CENTER);
		emptyLabelA4 = new JLabel("");
		AJButtonA_d1 = new JButton("(1)	strange	");
		AJButtonA_d2 = new JButton("(2)	foreign	");
		AJButtonA_d3 = new JButton("(3)	novel	");
		AJButtonA_d4 = new JButton("(4)	artificial	");
		AJPanel6 = new JPanel();
		AJPanel6.add(AJLabel11);
		AJPanel6.add(AJButtonA_d1);
		AJPanel6.add(AJButtonA_d2);
		AJPanel6.add(AJButtonA_d3);
		AJPanel6.add(AJButtonA_d4);
		AJPanel6.add(emptyLabelA4);
		AJPanel6.setSize(300, 100);
		AJPanel6.setLayout(gd3);
		AJPanel6.setBackground(Color.white);
		AJButtonA_d1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AJButtonA_d1.setForeground(Color.red);
				AJButtonA_d2.setForeground(Color.black);
				AJButtonA_d3.setForeground(Color.black);
				AJButtonA_d4.setForeground(Color.black);
			}
		});
		AJButtonA_d2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AJButtonA_d1.setForeground(Color.black);
				AJButtonA_d2.setForeground(Color.blue);
				AJButtonA_d3.setForeground(Color.black);
				AJButtonA_d4.setForeground(Color.black);
			}
		});
		AJButtonA_d3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AJButtonA_d1.setForeground(Color.black);
				AJButtonA_d2.setForeground(Color.black);
				AJButtonA_d3.setForeground(Color.red);
				AJButtonA_d4.setForeground(Color.black);
			}
		});
		AJButtonA_d4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AJButtonA_d1.setForeground(Color.black);
				AJButtonA_d2.setForeground(Color.black);
				AJButtonA_d3.setForeground(Color.black);
				AJButtonA_d4.setForeground(Color.red);
			}
		});

		GridLayout centerA = new GridLayout(3,1);
		centerJPanelA = new JPanel();
		centerJPanelA.add(topic1, BorderLayout.NORTH);
		answer1 = new JPanel(new GridLayout(4, 1, 0, 10));
		answer1.setBorder(new EmptyBorder(0, 0,10, 10));
		answer1.setBackground(Color.white);
		answer1.setPreferredSize(new Dimension(1000, 450));
		answer1.add(AJPanel3);
		answer1.add(AJPanel4);
		answer1.add(AJPanel5);
		answer1.add(AJPanel6);
		centerJPanelA.add(answer1, BorderLayout.CENTER);
		centerJPanelA.setBackground(Color.white);

		AJButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				centerJPanel.remove(AJPanel);
				centerJPanel.add(centerJPanelA,BorderLayout.CENTER);
				centerJPanel.revalidate();
				centerJPanel.repaint();
			}
		});

		//第二題
		topic2 = new JPanel();
		BJLabel1 = new JLabel("B.");
		BJLabel2 = new JLabel("		A traffic accident took place on a busy road. ");
		BJLabel3 = new JLabel("		A taxi traveling __a__ knocked down a passing motorcyclist.");
		BJLabel4 = new JLabel("		No sooner had the accident happened __b__ a crowd gathered.\n");
		BJLabel5 = new JLabel("		The motorcyclist was seriously __c__ as he __d__ motionless on the road.\n");
		BJLabel6 = new JLabel("		Blood trickled down his forehead. But he was by no means killed.\n ");
		BJLabel1.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		BJLabel2.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		BJLabel3.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		BJLabel4.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		BJLabel5.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		BJLabel6.setFont(new Font("TimesRoman", Font.PLAIN, 20));

		BJPanel2 = new JPanel(new GridLayout(6, 1 ));
		BJPanel2.add(BJLabel1);
		BJPanel2.add(BJLabel2);
		BJPanel2.add(BJLabel3);
		BJPanel2.add(BJLabel4);
		BJPanel2.add(BJLabel5);
		BJPanel2.add(BJLabel6);
		BJPanel2.setBackground(Color.white);
		topic2.add(BJPanel2, BorderLayout.CENTER);
		topic2.setBorder(new EmptyBorder(0, 0, 35, 0));
		topic2.setBackground(Color.white);

		emptyLabelB1 = new JLabel("");
		BJLabel8 = new JLabel("B-a", SwingConstants.CENTER);
		BJButtonA_a = new JButton("(1)	in full speed	");
		BJButtonA_b = new JButton("(2)	by full speed	");
		BJButtonA_c = new JButton("(3)	at full speed	");
		BJButtonA_d = new JButton("(4)	on full speed	");
		BJPanel3 = new JPanel();
		BJPanel3.add(BJLabel8);
		BJPanel3.add(BJButtonA_a);
		BJPanel3.add(BJButtonA_b);
		BJPanel3.add(BJButtonA_c);
		BJPanel3.add(BJButtonA_d);
		BJPanel3.add(emptyLabelB1);
		BJPanel3.setLayout(gd3);
		BJPanel3.setBackground(Color.white);
		BJButtonA_a.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BJButtonA_a.setForeground(Color.red);
				BJButtonA_b.setForeground(Color.black);
				BJButtonA_c.setForeground(Color.black);
				BJButtonA_d.setForeground(Color.black);
			}
		});
		BJButtonA_b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BJButtonA_b.setForeground(Color.red);
				BJButtonA_a.setForeground(Color.black);
				BJButtonA_c.setForeground(Color.black);
				BJButtonA_d.setForeground(Color.black);
			}
		});
		BJButtonA_c.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BJButtonA_c.setForeground(Color.blue);
				BJButtonA_a.setForeground(Color.black);
				BJButtonA_b.setForeground(Color.black);
				BJButtonA_d.setForeground(Color.black);

			}
		});
		BJButtonA_d.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BJButtonA_b.setForeground(Color.black);
				BJButtonA_a.setForeground(Color.black);
				BJButtonA_c.setForeground(Color.black);
				BJButtonA_d.setForeground(Color.red);

			}
		});

		emptyLabelB2 = new JLabel("");
		BJLabel9 = new JLabel("B-b", SwingConstants.CENTER);
		BJButtonA_b1 = new JButton("(1)	then	");
		BJButtonA_b2 = new JButton("(2)	than	");
		BJButtonA_b3 = new JButton("(3)	when	");
		BJButtonA_b4 = new JButton("(4)	before	");
		BJPanel4 = new JPanel();
		BJPanel4.add(BJLabel9);
		BJPanel4.add(BJButtonA_b1);
		BJPanel4.add(BJButtonA_b2);
		BJPanel4.add(BJButtonA_b3);
		BJPanel4.add(BJButtonA_b4);
		BJPanel4.add(emptyLabelB2);
		BJPanel4.setLayout(gd3);
		BJPanel4.setBackground(Color.white);
		BJButtonA_b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BJButtonA_b1.setForeground(Color.red);
				BJButtonA_b2.setForeground(Color.black);
				BJButtonA_b3.setForeground(Color.black);
				BJButtonA_b4.setForeground(Color.black);
			}
		});
		BJButtonA_b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BJButtonA_b1.setForeground(Color.black);
				BJButtonA_b2.setForeground(Color.blue);
				BJButtonA_b3.setForeground(Color.black);
				BJButtonA_b4.setForeground(Color.black);
			}
		});
		BJButtonA_b3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BJButtonA_b1.setForeground(Color.black);
				BJButtonA_b2.setForeground(Color.black);
				BJButtonA_b3.setForeground(Color.red);
				BJButtonA_b4.setForeground(Color.black);
			}
		});
		BJButtonA_b4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BJButtonA_b1.setForeground(Color.black);
				BJButtonA_b2.setForeground(Color.black);
				BJButtonA_b3.setForeground(Color.black);
				BJButtonA_b4.setForeground(Color.red);
			}
		});

		emptyLabelB3 = new JLabel("");
		BJLabel10 = new JLabel("B-c", SwingConstants.CENTER);
		BJButtonA_c1 = new JButton("(1)	injure	");
		BJButtonA_c2 = new JButton("(2)	injured	");
		BJButtonA_c3 = new JButton("(3)	to be injured	");
		BJButtonA_c4 = new JButton("(4)	damage	");
		BJPanel5 = new JPanel();
		BJPanel5.add(BJLabel10);
		BJPanel5.add(BJButtonA_c1);
		BJPanel5.add(BJButtonA_c2);
		BJPanel5.add(BJButtonA_c3);
		BJPanel5.add(BJButtonA_c4);
		BJPanel5.add(emptyLabelB3);
		BJPanel5.setSize(300, 100);
		BJPanel5.setLayout(gd3);
		BJPanel5.setBackground(Color.white);
		BJButtonA_c1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BJButtonA_c1.setForeground(Color.red);
				BJButtonA_c2.setForeground(Color.black);
				BJButtonA_c3.setForeground(Color.black);
				BJButtonA_c4.setForeground(Color.black);
			}
		});
		BJButtonA_c2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BJButtonA_c1.setForeground(Color.black);
				BJButtonA_c2.setForeground(Color.blue);
				BJButtonA_c3.setForeground(Color.black);
				BJButtonA_c4.setForeground(Color.black);
			}
		});
		BJButtonA_c3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BJButtonA_c1.setForeground(Color.black);
				BJButtonA_c2.setForeground(Color.black);
				BJButtonA_c3.setForeground(Color.red);
				BJButtonA_c4.setForeground(Color.black);
			}
		});
		BJButtonA_c4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BJButtonA_c1.setForeground(Color.black);
				BJButtonA_c2.setForeground(Color.black);
				BJButtonA_c3.setForeground(Color.black);
				BJButtonA_c4.setForeground(Color.red);
			}
		});

		emptyLabelB4 = new JLabel("");
		BJLabel11 = new JLabel("B-d", SwingConstants.CENTER);
		BJButtonA_d1 = new JButton("(1)	lay	");
		BJButtonA_d2 = new JButton("(2)	lied	");
		BJButtonA_d3 = new JButton("(3)	laid	");
		BJButtonA_d4 = new JButton("(4)	lain	");
		BJPanel6 = new JPanel();
		BJPanel6.add(BJLabel11);
		BJPanel6.add(BJButtonA_d1);
		BJPanel6.add(BJButtonA_d2);
		BJPanel6.add(BJButtonA_d3);
		BJPanel6.add(BJButtonA_d4);
		BJPanel6.add(emptyLabelB4);
		BJPanel6.setSize(300, 100);
		BJPanel6.setLayout(gd3);
		BJPanel6.setBackground(Color.white);
		BJButtonA_d1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BJButtonA_d1.setForeground(Color.blue);
				BJButtonA_d2.setForeground(Color.black);
				BJButtonA_d3.setForeground(Color.black);
				BJButtonA_d4.setForeground(Color.black);
			}
		});
		BJButtonA_d2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BJButtonA_d1.setForeground(Color.black);
				BJButtonA_d2.setForeground(Color.red);
				BJButtonA_d3.setForeground(Color.black);
				BJButtonA_d4.setForeground(Color.black);
			}
		});
		BJButtonA_d3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BJButtonA_d1.setForeground(Color.black);
				BJButtonA_d2.setForeground(Color.black);
				BJButtonA_d3.setForeground(Color.red);
				BJButtonA_d4.setForeground(Color.black);
			}
		});
		BJButtonA_d4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BJButtonA_d1.setForeground(Color.black);
				BJButtonA_d2.setForeground(Color.black);
				BJButtonA_d3.setForeground(Color.black);
				BJButtonA_d4.setForeground(Color.red);
			}
		});

		centerJPanelB = new JPanel();
		centerJPanelB.add(topic2, BorderLayout.NORTH);
		answer2 = new JPanel(new GridLayout(4, 1, 0, 10));
		answer2.setBorder(new EmptyBorder(0, 0,10, 10));
		answer2.setBackground(Color.white);
		answer2.setPreferredSize(new Dimension(1000, 450));
		answer2.add(BJPanel3);
		answer2.add(BJPanel4);
		answer2.add(BJPanel5);
		answer2.add(BJPanel6);
		centerJPanelB.add(answer2, BorderLayout.CENTER);
		centerJPanelB.setBackground(Color.white);

		AJButton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				centerJPanel.remove(AJPanel);
				centerJPanel.add(centerJPanelB,BorderLayout.CENTER);
				centerJPanel.revalidate();
				centerJPanel.repaint();
			}
		});

		//第三題
		topic3 = new JPanel();
		CJLabel1 = new JLabel("C.");
		CJLabel2 = new JLabel("		As the war got underway, all signs were indicating that things were going well for Washington and London. ");
		CJLabel3 = new JLabel("		Troops were moving __a__ into the Iraqi interior, ");
		CJLabel4 = new JLabel("		and marine forces were able to capture the main Iraqi port facility near the border of Kuwait.");
		CJLabel5 = new JLabel("		If all goes well, allied forces may be reaching the gates of Baghdad __b__ the beginning of next week,");
		CJLabel6 = new JLabel("		__c__ would bode well for Presi-dent\n");
		CJLabel7 = new JLabel("		George Bush's desire to see the war concluded __d__ quickly as possible.");
		CJLabel1.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		CJLabel2.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		CJLabel3.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		CJLabel4.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		CJLabel5.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		CJLabel6.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		CJLabel7.setFont(new Font("TimesRoman", Font.PLAIN, 20));

		CJPanel2 = new JPanel(new GridLayout(7, 1));
		CJPanel2.add(CJLabel1);
		CJPanel2.add(CJLabel2);
		CJPanel2.add(CJLabel3);
		CJPanel2.add(CJLabel4);
		CJPanel2.add(CJLabel5);
		CJPanel2.add(CJLabel6);
		CJPanel2.add(CJLabel7);
		CJPanel2.setBackground(Color.white);
		topic3.add(CJPanel2, BorderLayout.CENTER);
		topic3.setBorder(new EmptyBorder(0, 0, 35, 0));
		topic3.setBackground(Color.white);

		emptyLabelC1 = new JLabel("");
		CJLabel8 = new JLabel("C-a", SwingConstants.CENTER);
		CJButtonA_a = new JButton("(1)	soon	");
		CJButtonA_b = new JButton("(2)	rapidly	");
		CJButtonA_c = new JButton("(3)	literally	");
		CJButtonA_d = new JButton("(4)	particularly	");
		CJPanel3 = new JPanel();
		CJPanel3.add(CJLabel8);
		CJPanel3.add(CJButtonA_a);
		CJPanel3.add(CJButtonA_b);
		CJPanel3.add(CJButtonA_c);
		CJPanel3.add(CJButtonA_d);
		CJPanel3.add(emptyLabelC1);
		CJPanel3.setLayout(gd3);
		CJPanel3.setBackground(Color.white);
		CJButtonA_a.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CJButtonA_a.setForeground(Color.red);
				CJButtonA_b.setForeground(Color.black);
				CJButtonA_c.setForeground(Color.black);
				CJButtonA_d.setForeground(Color.black);
			}
		});
		CJButtonA_b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CJButtonA_b.setForeground(Color.blue);
				CJButtonA_a.setForeground(Color.black);
				CJButtonA_c.setForeground(Color.black);
				CJButtonA_d.setForeground(Color.black);
			}
		});
		CJButtonA_c.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CJButtonA_c.setForeground(Color.red);
				CJButtonA_a.setForeground(Color.black);
				CJButtonA_b.setForeground(Color.black);
				CJButtonA_d.setForeground(Color.black);
			}
		});
		CJButtonA_d.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CJButtonA_b.setForeground(Color.black);
				CJButtonA_a.setForeground(Color.black);
				CJButtonA_c.setForeground(Color.black);
				CJButtonA_d.setForeground(Color.red);
			}
		});

		emptyLabelC2 = new JLabel("");
		CJLabel9 = new JLabel("C-b", SwingConstants.CENTER);
		CJButtonA_b1 = new JButton("(1)	on	");
		CJButtonA_b2 = new JButton("(2)	with	");
		CJButtonA_b3 = new JButton("(3)	by	");
		CJButtonA_b4 = new JButton("(4)	from	");
		CJPanel4 = new JPanel();
		CJPanel4.add(CJLabel9);
		CJPanel4.add(CJButtonA_b1);
		CJPanel4.add(CJButtonA_b2);
		CJPanel4.add(CJButtonA_b3);
		CJPanel4.add(CJButtonA_b4);
		CJPanel4.add(emptyLabelC2);
		CJPanel4.setLayout(gd3);
		CJPanel4.setBackground(Color.white);
		CJButtonA_b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CJButtonA_b1.setForeground(Color.red);
				CJButtonA_b2.setForeground(Color.black);
				CJButtonA_b3.setForeground(Color.black);
				CJButtonA_b4.setForeground(Color.black);
			}
		});
		CJButtonA_b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CJButtonA_b1.setForeground(Color.black);
				CJButtonA_b2.setForeground(Color.red);
				CJButtonA_b3.setForeground(Color.black);
				CJButtonA_b4.setForeground(Color.black);
			}
		});
		CJButtonA_b3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CJButtonA_b1.setForeground(Color.black);
				CJButtonA_b2.setForeground(Color.black);
				CJButtonA_b3.setForeground(Color.blue);
				CJButtonA_b4.setForeground(Color.black);
			}
		});
		CJButtonA_b4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CJButtonA_b1.setForeground(Color.black);
				CJButtonA_b2.setForeground(Color.black);
				CJButtonA_b3.setForeground(Color.black);
				CJButtonA_b4.setForeground(Color.red);
			}
		});

		emptyLabelC3 = new JLabel("");
		CJLabel10 = new JLabel("C-c", SwingConstants.CENTER);
		CJButtonA_c1 = new JButton("(1)	what	");
		CJButtonA_c2 = new JButton("(2)	who	");
		CJButtonA_c3 = new JButton("(3)	that	");
		CJButtonA_c4 = new JButton("(4)	which	");
		CJPanel5 = new JPanel();
		CJPanel5.add(CJLabel10);
		CJPanel5.add(CJButtonA_c1);
		CJPanel5.add(CJButtonA_c2);
		CJPanel5.add(CJButtonA_c3);
		CJPanel5.add(CJButtonA_c4);
		CJPanel5.add(emptyLabelC3);
		CJPanel5.setSize(300, 100);
		CJPanel5.setLayout(gd3);
		CJPanel5.setBackground(Color.white);
		CJButtonA_c1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CJButtonA_c1.setForeground(Color.red);
				CJButtonA_c2.setForeground(Color.black);
				CJButtonA_c3.setForeground(Color.black);
				CJButtonA_c4.setForeground(Color.black);
			}
		});
		CJButtonA_c2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CJButtonA_c1.setForeground(Color.black);
				CJButtonA_c2.setForeground(Color.red);
				CJButtonA_c3.setForeground(Color.black);
				CJButtonA_c4.setForeground(Color.black);
			}
		});
		CJButtonA_c3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CJButtonA_c1.setForeground(Color.black);
				CJButtonA_c2.setForeground(Color.black);
				CJButtonA_c3.setForeground(Color.red);
				CJButtonA_c4.setForeground(Color.black);
			}
		});
		CJButtonA_c4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CJButtonA_c1.setForeground(Color.black);
				CJButtonA_c2.setForeground(Color.black);
				CJButtonA_c3.setForeground(Color.black);
				CJButtonA_c4.setForeground(Color.blue);
			}
		});

		emptyLabelC4 = new JLabel("");
		CJLabel11 = new JLabel("C-d", SwingConstants.CENTER);
		CJButtonA_d1 = new JButton("(1)	as	");
		CJButtonA_d2 = new JButton("(2)	so	");
		CJButtonA_d3 = new JButton("(3)	to	");
		CJButtonA_d4 = new JButton("(4)	for	");
		CJPanel6 = new JPanel();
		CJPanel6.add(CJLabel11);
		CJPanel6.add(CJButtonA_d1);
		CJPanel6.add(CJButtonA_d2);
		CJPanel6.add(CJButtonA_d3);
		CJPanel6.add(CJButtonA_d4);
		CJPanel6.add(emptyLabelC4);
		//CJPanel6.setSize(300, 100);
		CJPanel6.setLayout(gd3);
		CJPanel6.setBackground(Color.white);
		CJButtonA_d1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CJButtonA_d1.setForeground(Color.blue);
				CJButtonA_d2.setForeground(Color.black);
				CJButtonA_d3.setForeground(Color.black);
				CJButtonA_d4.setForeground(Color.black);
			}
		});
		CJButtonA_d2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CJButtonA_d1.setForeground(Color.black);
				CJButtonA_d2.setForeground(Color.red);
				CJButtonA_d3.setForeground(Color.black);
				CJButtonA_d4.setForeground(Color.black);
			}
		});
		CJButtonA_d3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CJButtonA_d1.setForeground(Color.black);
				CJButtonA_d2.setForeground(Color.black);
				CJButtonA_d3.setForeground(Color.red);
				CJButtonA_d4.setForeground(Color.black);
			}
		});
		CJButtonA_d4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CJButtonA_d1.setForeground(Color.black);
				CJButtonA_d2.setForeground(Color.black);
				CJButtonA_d3.setForeground(Color.black);
				CJButtonA_d4.setForeground(Color.red);
			}
		});

		centerJPanelC = new JPanel();
		centerJPanelC.add(topic3, BorderLayout.NORTH);
		answer3 = new JPanel(new GridLayout(4, 1, 0, 10));
		answer3.setBorder(new EmptyBorder(0, 0,10, 10));
		answer3.setBackground(Color.white);
		answer3.setPreferredSize(new Dimension(1000, 450));
		answer3.add(CJPanel3);
		answer3.add(CJPanel4);
		answer3.add(CJPanel5);
		answer3.add(CJPanel6);
		centerJPanelC.add(answer3, BorderLayout.CENTER);
		centerJPanelC.setBackground(Color.white);

		AJButton2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				centerJPanel.remove(AJPanel);
				centerJPanel.add(centerJPanelC,BorderLayout.CENTER);
				centerJPanel.revalidate();
				centerJPanel.repaint();
			}
		});

		//第四題
		topic4 = new JPanel();
		DJLabel1 = new JLabel("D.");
		DJLabel2 = new JLabel("		Since its establishment, the Consumer Protection Committee has taken measures that emphasize product safety and sanitation. ");
		DJLabel3 = new JLabel("		These measures also ensure that all labels and advertisements __a__ to regulations. ");
		DJLabel4 = new JLabel("		__b__, the Committee collaborates with various international consumer protection organizations");
		DJLabel5 = new JLabel("		to respond to problems involving cross-border trade and business.");
		DJLabel6 = new JLabel("		__c__ its regulatory power and administrative resources,");
		DJLabel7 = new JLabel("		the Committee __d__ a crucial role in protecting consumers in Taiwan.");
		DJLabel1.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		DJLabel2.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		DJLabel3.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		DJLabel4.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		DJLabel5.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		DJLabel6.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		DJLabel7.setFont(new Font("TimesRoman", Font.PLAIN, 20));

		DJPanel2 = new JPanel();
		DJPanel2.add(DJLabel1);
		DJPanel2.add(DJLabel2);
		DJPanel2.add(DJLabel3);
		DJPanel2.add(DJLabel4);
		DJPanel2.add(DJLabel5);
		DJPanel2.add(DJLabel6);
		DJPanel2.add(DJLabel7);
		DJPanel2.setLayout(gd);
		DJPanel2.setBackground(Color.white);
		topic4.add(DJPanel2, BorderLayout.CENTER);
		topic4.setBorder(new EmptyBorder(0, 0, 35, 0));
		topic4.setBackground(Color.white);

		emptyLabelD1 = new JLabel("");
		DJLabel8 = new JLabel("D-a", SwingConstants.CENTER);
		DJButtonA_a = new JButton("(1)	conform	");
		DJButtonA_b = new JButton("(2)	conformed	");
		DJButtonA_c = new JButton("(3)	conforming	");
		DJButtonA_d = new JButton("(4)	to conform	");
		DJPanel3 = new JPanel();
		DJPanel3.add(DJLabel8);
		DJPanel3.add(DJButtonA_a);
		DJPanel3.add(DJButtonA_b);
		DJPanel3.add(DJButtonA_c);
		DJPanel3.add(DJButtonA_d);
		DJPanel3.add(emptyLabelD1);
		DJPanel3.setLayout(gd3);
		DJPanel3.setBackground(Color.white);
		DJButtonA_a.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DJButtonA_a.setForeground(Color.blue);
				DJButtonA_b.setForeground(Color.black);
				DJButtonA_c.setForeground(Color.black);
				DJButtonA_d.setForeground(Color.black);
			}
		});
		DJButtonA_b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DJButtonA_b.setForeground(Color.red);
				DJButtonA_a.setForeground(Color.black);
				DJButtonA_c.setForeground(Color.black);
				DJButtonA_d.setForeground(Color.black);

			}
		});
		DJButtonA_c.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DJButtonA_c.setForeground(Color.red);
				DJButtonA_a.setForeground(Color.black);
				DJButtonA_b.setForeground(Color.black);
				DJButtonA_d.setForeground(Color.black);
			}
		});
		DJButtonA_d.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DJButtonA_b.setForeground(Color.black);
				DJButtonA_a.setForeground(Color.black);
				DJButtonA_c.setForeground(Color.black);
				DJButtonA_d.setForeground(Color.red);
			}
		});

		emptyLabelD2 = new JLabel("");
		DJLabel9 = new JLabel("D-b", SwingConstants.CENTER);
		DJButtonA_b1 = new JButton("(1)	Besides	");
		DJButtonA_b2 = new JButton("(2)	Except	");
		DJButtonA_b3 = new JButton("(3)	In addition	");
		DJButtonA_b4 = new JButton("(4)	From	");
		DJPanel4 = new JPanel();
		DJPanel4.add(DJLabel9);
		DJPanel4.add(DJButtonA_b1);
		DJPanel4.add(DJButtonA_b2);
		DJPanel4.add(DJButtonA_b3);
		DJPanel4.add(DJButtonA_b4);
		DJPanel4.add(emptyLabelD2);
		DJPanel4.setLayout(gd3);
		DJPanel4.setBackground(Color.white);
		DJButtonA_b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DJButtonA_b1.setForeground(Color.red);
				DJButtonA_b2.setForeground(Color.black);
				DJButtonA_b3.setForeground(Color.black);
				DJButtonA_b4.setForeground(Color.black);
			}
		});
		DJButtonA_b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DJButtonA_b1.setForeground(Color.black);
				DJButtonA_b2.setForeground(Color.red);
				DJButtonA_b3.setForeground(Color.black);
				DJButtonA_b4.setForeground(Color.black);
			}
		});
		DJButtonA_b3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DJButtonA_b1.setForeground(Color.black);
				DJButtonA_b2.setForeground(Color.black);
				DJButtonA_b3.setForeground(Color.blue);
				DJButtonA_b4.setForeground(Color.black);
			}
		});
		DJButtonA_b4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DJButtonA_b1.setForeground(Color.black);
				DJButtonA_b2.setForeground(Color.black);
				DJButtonA_b3.setForeground(Color.black);
				DJButtonA_b4.setForeground(Color.red);
			}
		});

		emptyLabelD3 = new JLabel("");
		DJLabel10 = new JLabel("D-c", SwingConstants.CENTER);
		DJButtonA_c1 = new JButton("(1)	From	");
		DJButtonA_c2 = new JButton("(2)	With	");
		DJButtonA_c3 = new JButton("(3)	Despite	");
		DJButtonA_c4 = new JButton("(4)	Beyond	");
		DJPanel5 = new JPanel();
		DJPanel5.add(DJLabel10);
		DJPanel5.add(DJButtonA_c1);
		DJPanel5.add(DJButtonA_c2);
		DJPanel5.add(DJButtonA_c3);
		DJPanel5.add(DJButtonA_c4);
		DJPanel5.add(emptyLabelD3);
		DJPanel5.setSize(300, 100);
		DJPanel5.setLayout(gd3);
		DJPanel5.setBackground(Color.white);
		DJButtonA_c1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DJButtonA_c1.setForeground(Color.red);
				DJButtonA_c2.setForeground(Color.black);
				DJButtonA_c3.setForeground(Color.black);
				DJButtonA_c4.setForeground(Color.black);
			}
		});
		DJButtonA_c2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DJButtonA_c1.setForeground(Color.black);
				DJButtonA_c2.setForeground(Color.blue);
				DJButtonA_c3.setForeground(Color.black);
				DJButtonA_c4.setForeground(Color.black);
			}
		});
		DJButtonA_c3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DJButtonA_c1.setForeground(Color.black);
				DJButtonA_c2.setForeground(Color.black);
				DJButtonA_c3.setForeground(Color.red);
				DJButtonA_c4.setForeground(Color.black);
			}
		});
		DJButtonA_c4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DJButtonA_c1.setForeground(Color.black);
				DJButtonA_c2.setForeground(Color.black);
				DJButtonA_c3.setForeground(Color.black);
				DJButtonA_c4.setForeground(Color.red);
			}
		});

		emptyLabelD4 = new JLabel("");
		DJLabel11 = new JLabel("D-d", SwingConstants.CENTER);
		DJButtonA_d1 = new JButton("(1)	plays	");
		DJButtonA_d2 = new JButton("(2)	play	");
		DJButtonA_d3 = new JButton("(3)	plaing	");
		DJButtonA_d4 = new JButton("(4)	played	");
		DJPanel6 = new JPanel();
		DJPanel6.add(DJLabel11);
		DJPanel6.add(DJButtonA_d1);
		DJPanel6.add(DJButtonA_d2);
		DJPanel6.add(DJButtonA_d3);
		DJPanel6.add(DJButtonA_d4);
		DJPanel6.add(emptyLabelD4);
		DJPanel6.setSize(300, 100);
		DJPanel6.setLayout(gd3);
		DJPanel6.setBackground(Color.white);
		DJButtonA_d1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DJButtonA_d1.setForeground(Color.blue);
				DJButtonA_d2.setForeground(Color.black);
				DJButtonA_d3.setForeground(Color.black);
				DJButtonA_d4.setForeground(Color.black);
			}
		});
		DJButtonA_d2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DJButtonA_d1.setForeground(Color.black);
				DJButtonA_d2.setForeground(Color.red);
				DJButtonA_d3.setForeground(Color.black);
				DJButtonA_d4.setForeground(Color.black);
			}
		});
		DJButtonA_d3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DJButtonA_d1.setForeground(Color.black);
				DJButtonA_d2.setForeground(Color.black);
				DJButtonA_d3.setForeground(Color.red);
				DJButtonA_d4.setForeground(Color.black);
			}
		});
		DJButtonA_d4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DJButtonA_d1.setForeground(Color.black);
				DJButtonA_d2.setForeground(Color.black);
				DJButtonA_d3.setForeground(Color.black);
				DJButtonA_d4.setForeground(Color.red);
			}
		});

		centerJPanelD = new  JPanel();
		centerJPanelD.add(topic4, BorderLayout.NORTH);
		answer4 = new JPanel(new GridLayout(4, 1, 0, 10));
		answer4.setBorder(new EmptyBorder(0, 0,10, 10));
		answer4.setBackground(Color.white);
		answer4.setPreferredSize(new Dimension(1000, 450));
		answer4.add(DJPanel3);
		answer4.add(DJPanel4);
		answer4.add(DJPanel5);
		answer4.add(DJPanel6);
		centerJPanelD.add(answer4, BorderLayout.CENTER);
		centerJPanelD.setBackground(Color.white);

		AJButton3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				centerJPanel.remove(AJPanel);
				centerJPanel.add(centerJPanelD,BorderLayout.CENTER);
				centerJPanel.revalidate();
				centerJPanel.repaint();
			}
		});

		clozeFrame1.setTitle("Engrave英文學習應用平台");
		//clozeFrame1.setSize(1000,650);
		clozeFrame1.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//clozeFrame1.setLocation(500, 100);
		clozeFrame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		clozeFrame1.setVisible(true);
	}
	/*public static void main(String[] args) {
		new ClozeFrame();
	}*/
}