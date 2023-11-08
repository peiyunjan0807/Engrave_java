package sample;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenFrame {
	private JFrame listenFrame1;
	private JLabel title, easy, medium, hard;
	private JButton homeButton, backOption;
	private JButton easy1, easy2, easy3, easy4, easy5, easy6;
	private JButton medium1, medium2, medium3, medium4;
	private JButton hard1, hard2, hard3, hard4;
	private JPanel homePanel, option, optionEasy, optionMedium, optionHard;

	ImageIcon iconListenJButton1;
	public ListenFrame() {
		listenFrame1 = new JFrame();
		title = new JLabel("Listening Test", JLabel.CENTER);
		title.setFont(title.getFont().deriveFont(56f));
		title.setOpaque(true);
		title.setBackground(Color.white);
		listenFrame1.add(title, BorderLayout.NORTH);

		homeButton = new JButton("回首頁");
		homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	listenFrame1.dispose();
                new UI();
            }
        });

		backOption = new JButton("題目");
		backOption.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				listenFrame1.dispose();
				new ListenFrame();
			}
		});

		homePanel = new JPanel(new GridLayout(15, 1));
		homePanel.setBorder(new EmptyBorder(0, 3, 0, 5));
		homePanel.setBackground(Color.white);
		homePanel.add(homeButton);
		listenFrame1.add(homePanel,BorderLayout.WEST);


		option = new JPanel(new GridLayout(6, 1));
		option.setBorder(new EmptyBorder(0, 5, 10, 10));
		option.setBackground(Color.white);
		optionEasy = new JPanel(new GridLayout(2, 3, 7, 7));
		easy = new JLabel("Easy");
		easy.setFont(easy.getFont().deriveFont(30f));
		option.add(easy);
		easy1 = new JButton("Lauv - Reforget");
		easy1.setFont(new Font("TimesRoman", Font.BOLD, 20));
		easy1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String[] args = {"Lauv - Reforget", "https://youtu.be/hmlQOKVMOmk", "songs/song1-1.txt", "pushed", "below", "guess", "regret", "sunrise", "carousel", "footsteps", "faded"};
					Player player = new Player();
					listenFrame1.dispose();
					player.main(args);
				}
				catch (IllegalStateException event) {
						System.err.println("無法開啟");
				}
			}
		});
		easy2 = new JButton("Sasha Sloan - Dancing With Your Ghost");
		easy2.setFont(new Font("TimesRoman", Font.BOLD, 20));
		easy2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String[] args = {"Sasha Sloan - Dancing With Your Ghost", "https://youtu.be/a5RQ0z29XoU", "songs/song1-2.txt", "Yelling", "Screaming", "tight", "Heaven", "myself", "harder", "record", "chance"};
					Player player = new Player();
					listenFrame1.dispose();
					player.main(args);
				}
				catch (IllegalStateException event) {
					System.err.println("無法開啟");
				}
			}
		});
		easy3 = new JButton("Maroon 5 - Memories");
		easy3.setFont(new Font("TimesRoman", Font.BOLD, 20));
		easy3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String[] args = {"Maroon 5 - Memories", "https://youtu.be/SlPhMPnQ58k", "songs/song1-3.txt", "wish", "through", "Toast", "raise", "hatred", "lighting", "torches", "drop"};
					Player player = new Player();
					listenFrame1.dispose();
					player.main(args);
				} catch (IllegalStateException event) {
					System.err.println("無法開啟");
				}
			}
		});
		easy4 = new JButton("Meghan Trainor - Like I'm Gonna Lose You");
		easy4.setFont(new Font("TimesRoman", Font.BOLD, 20));
		easy4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String[] args = {"Meghan Trainor - Like I'm Gonna Lose You\nft. John Legend", "https://youtu.be/2-MBfn8XjIU", "songs/song1-4.txt", "silver", "disappeared", "relief", "granted", "blink", "whisper", "promised", "truth"};
					Player player = new Player();
					listenFrame1.dispose();
					player.main(args);
				} catch (IllegalStateException event) {
					System.err.println("無法開啟");
				}
			}
		});
		easy5 = new JButton("Ariana Grande & Justin Bieber - Stuck with U");
		easy5.setFont(new Font("TimesRoman", Font.BOLD, 20));
		easy5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String[] args = {"Ariana Grande & Justin Bieber - Stuck with U", "https://youtu.be/pE49WK-oNjU", "songs/song1-5.txt", "stick", "strike", "cancel", "throw", "insane", "streets", "spend", "tonight"};
					Player player = new Player();
					listenFrame1.dispose();
					player.main(args);
				} catch (IllegalStateException event) {
					System.err.println("無法開啟");
				}
			}
		});
		easy6 = new JButton("Wiz Khalifa - See You Again ft. Charlie Puth");
		easy6.setFont(new Font("TimesRoman", Font.BOLD, 20));
		easy6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String[] args = {"Wiz Khalifa - See You Again\nft. Charlie Puth", "https://youtu.be/RgKAFK5djSk", "songs/song1-6.txt", "planes", "standing", "laugh", "switch", "vibe", "broken", "brotherhood", "Established"};
					Player player = new Player();
					listenFrame1.dispose();
					player.main(args);
				} catch (IllegalStateException event) {
					System.err.println("無法開啟");
				}
			}
		});
		optionEasy.add(easy1);
		optionEasy.add(easy2);
		optionEasy.add(easy3);
		optionEasy.add(easy4);
		optionEasy.add(easy5);
		optionEasy.add(easy6);
		option.add(optionEasy);

		optionMedium = new JPanel(new GridLayout(2, 2, 7, 7));
		medium = new JLabel("Medium");
		medium.setFont(medium.getFont().deriveFont(30f));
		option.add(medium);
		medium1 = new JButton("Taylor Swift - willow");
		medium1.setFont(new Font("TimesRoman", Font.BOLD, 20));
		medium1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String[] args = {"Taylor Swift - willow", "https://youtu.be/RsEZmictANA", "songs/song2-1.txt", "Rough", "priceless", "pillow", "mythical", "trophy", "prize", "signal", "bait"};
					Player player = new Player();
					listenFrame1.dispose();
					player.main(args);
				} catch (IllegalStateException event) {
					System.err.println("無法開啟");
				}
			}
		});
		medium2 = new JButton("Avril Lavigne - We Are Warriors");
		medium2.setFont(new Font("TimesRoman", Font.BOLD, 20));
		medium2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String[] args = {"Avril Lavigne - We Are Warriors", "https://youtu.be/3tBk7ONm95Q", "songs/song2-2.txt", "shattered", "Steadier", "gathered", "soldiers", "conquer", "falter", "marching", "armor"};
					Player player = new Player();
					listenFrame1.dispose();
					player.main(args);
				} catch (IllegalStateException event) {
					System.err.println("無法開啟");
				}
			}
		});
		medium3 = new JButton("Keala Settle - This Is Me");
		medium3.setFont(new Font("TimesRoman", Font.BOLD, 20));
		medium3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String[] args = {"Keala Settle - This Is Me", "https://youtu.be/wEJd2RyGm8Q", "songs/song2-3.txt", "ashamed", "dust", "glorious", "sharpest", "bruised", "apologies", "bullets", "barricades"};
					Player player = new Player();
					listenFrame1.dispose();
					player.main(args);
				} catch (IllegalStateException event) {
					System.err.println("無法開啟");
					new UI();
				}
			}
		});
		medium4 = new JButton("LANY - Malibu Nights");
		medium4.setFont(new Font("TimesRoman", Font.BOLD, 20));
		medium4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String[] args = {"LANY - Malibu Nights", "https://youtu.be/g5xxhaKm1RQ", "songs/song2-4.txt", "rhyme", "blindsided", "bare", "dealing", "fades", "whiskey", "fragile", "chasing"};
					Player player = new Player();
					listenFrame1.dispose();
					player.main(args);
				} catch (IllegalStateException event) {
					System.err.println("無法開啟");
				}
			}
		});
		optionMedium.add(medium1);
		optionMedium.add(medium2);
		optionMedium.add(medium3);
		optionMedium.add(medium4);
		option.add(optionMedium);

		optionHard = new JPanel(new GridLayout(2, 2, 7, 7));
		hard = new JLabel("Hard");
		hard.setFont(hard.getFont().deriveFont(30f));
		option.add(hard);
		hard1 = new JButton("Katy Perry - Firework");
		hard1.setFont(new Font("TimesRoman", Font.BOLD, 20));
		hard1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String[] args = {"Katy Perry - Firework", "https://youtu.be/QGJuMBdaqIw", "songs/song3-1.txt", "Drifting", "buried", "screams", "ignite", "shoot", "burst", "replaced", "burst"};
					Player player = new Player();
					listenFrame1.dispose();
					player.main(args);
				} catch (IllegalStateException event) {
					System.err.println("無法開啟");
				}
			}
		});
		hard2 = new JButton("Katy Perry - Rise");
		hard2.setFont(new Font("TimesRoman", Font.BOLD, 20));
		hard2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String[] args = {"Katy Perry - Rise", "https://youtu.be/hdw1uKiTI5c", "songs/song3-2.txt", "thrive", "archetype", "faith", "veins", "negotiate", "vultures", "conscious", "chaos"};
					Player player = new Player();
					listenFrame1.dispose();
					player.main(args);
				} catch (IllegalStateException event) {
					System.err.println("無法開啟");
				}
			}
		});
		hard3 = new JButton("Justin Bieber - Come Around Me");
		hard3.setFont(new Font("TimesRoman", Font.BOLD, 20));
		hard3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String[] args = {"Justin Bieber - Come Around Me", "https://youtu.be/GtDwH6fPRMA", "songs/song3-3.txt", "influence", "comprehend", "win-win", "expeditiously", "perfection", "aggressively", "wit", "shawty"};
					Player player = new Player();
					listenFrame1.dispose();
					player.main(args);
				} catch (IllegalStateException event) {
					System.err.println("無法開啟");
				}
			}
		});
		hard4 = new JButton("ØZI - FREE FALL");
		hard4.setFont(new Font("TimesRoman", Font.BOLD, 20));
		hard4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String[] args = {"ØZI - FREE FALL", "https://youtu.be/kxDEuRWkeT0", "songs/song3-4.txt", "intoxicated", "Poured", "magnetized", "Pure", "anticipated", "parachute", "Adrenaline", "accelerate"};
					Player player = new Player();
					listenFrame1.dispose();
					player.main(args);
				} catch (IllegalStateException event) {
					System.err.println("無法開啟");
				}
			}
		});
		optionHard.add(hard1);
		optionHard.add(hard2);
		optionHard.add(hard3);
		optionHard.add(hard4);
		option.add(optionHard);
		//option.setBackground(Color.white);
		option.setBorder(new EmptyBorder(0, 10, 20, 20));

		listenFrame1.add(option, BorderLayout.CENTER);
		
		listenFrame1.setTitle("Engrave英文學習應用平台");
		//listenFrame1.setSize(1000,625);
		listenFrame1.setExtendedState(JFrame.MAXIMIZED_BOTH);
		listenFrame1.setLocation(500, 100);
		listenFrame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    listenFrame1.setVisible(true);
	}

	public static void main(String[] args) {
		ListenFrame test = new ListenFrame();
	}
}