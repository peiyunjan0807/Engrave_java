package sample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class CardFrame extends JFrame{
    JFrame cardFrame1;
    JPanel jpBack,jpCenter,jpLeft,jpRight,jpLeftUp,jpLeftDown,jpRightUp,jpRightDown,jpWord,jpInformation;
    ImageIcon iconPrevious,iconNext;
    JButton jbPrevious,jbNext,jbTurn,jbExit,jbChangeOrder;
    JLabel word,partOfSpeech,chineseDefinition;
    JTextArea englishDefinition;
    boolean side = true; //true: 正面; false: 反面
    static boolean style = true; //true: (正面)單字; false: (正面)資訊
    int index = 0;
    boolean exit = false;

    public CardFrame(){
        cardFrame1 = new JFrame();
        String pathPrevious = "pictures/previous.png";
        String pathNext = "pictures/next.png";
        iconPrevious = new ImageIcon(pathPrevious);
        iconNext = new ImageIcon(pathNext);
        jpBack = new JPanel(new BorderLayout());
        jbPrevious = new JButton(iconPrevious);
        jbPrevious.setBackground(new Color(225,247,255));
        jbChangeOrder = new JButton("重新排序");
        jbChangeOrder.setFont(new Font("TimesRoman",Font.BOLD,30));
        jbChangeOrder.setBackground(new Color(215,206,250));
        jbNext = new JButton(iconNext);
        jbNext.setBackground(new Color(225,247,255));
        jpLeft = new JPanel(new GridLayout(3,1,15,50));
        jpLeft.setBackground(new Color(225,247,255));
        jpLeftUp = new JPanel();
        jpLeftUp.setBackground(new Color(225,247,255));
        jpLeftDown = new JPanel(new GridLayout(2,1));
        jpLeftDown.setBackground(new Color(225,247,255));
        jpLeftDown.add(jbChangeOrder);
        jpLeft.add(jpLeftUp);
        jpLeft.add(jbPrevious);
        jpLeft.add(jpLeftDown);
        jpRight = new JPanel(new GridLayout(3,1,15,50));
        jpRight.setBackground(new Color(225,247,255));
        jpRightUp = new JPanel();
        jpRightUp.setBackground(new Color(225,247,255));
        jpRightDown = new JPanel(new GridLayout(2,1));
        jpRightDown.setBackground(new Color(225,247,255));
        jbTurn = new JButton(" 翻 面 ");
        jbTurn.setFont(new Font("TimesRoman",Font.BOLD,30));
        jbTurn.setBackground(new Color(215,206,250));
        jbExit = new JButton(" 離 開 ");
        jbExit.setFont(new Font("TimesRoman",Font.BOLD,30));
        jbExit.setBackground(new Color(215,206,250));
        jpRightDown.add(jbTurn,BorderLayout.NORTH);
        jpRightDown.add(jbExit,BorderLayout.CENTER);
        jpRight.add(jpRightUp);
        jpRight.add(jbNext);
        jpRight.add(jpRightDown);

        jpBack.add(jpLeft,BorderLayout.WEST);
        jpBack.add(jpRight,BorderLayout.EAST);

        cardFrame1.add(jpBack);

        jpWord = new JPanel();

        VocabularyFrame.cardData = randomCard(VocabularyFrame.cardData);
        word = new JLabel(VocabularyFrame.cardData.get(0).word,JLabel.CENTER);
        word.setFont(new Font("TimesRoman",Font.BOLD,80));
        jpWord.add(word);
        jpWord.setBackground(new Color(225,247,255));
        jpInformation = new JPanel(new GridLayout(3,1));
        jpInformation.setBackground(new Color(225,247,255));
        partOfSpeech = new JLabel(VocabularyFrame.cardData.get(0).partOfSpeech,JLabel.CENTER);
        partOfSpeech.setFont(new Font("TimesRoman",Font.BOLD,50));
        chineseDefinition = new JLabel(VocabularyFrame.cardData.get(0).chineseDefinition,JLabel.CENTER);
        if(VocabularyFrame.cardData.get(0).chineseDefinition.length()>30){
            chineseDefinition.setFont(new Font("TimesRoman",Font.BOLD,15));
        }else if(VocabularyFrame.cardData.get(0).chineseDefinition.length()>15) {
            chineseDefinition.setFont(new Font("TimesRoman", Font.BOLD, 25));
        }else{
            chineseDefinition.setFont(new Font("TimesRoman", Font.BOLD, 35));
        }
        englishDefinition = new JTextArea();
        englishDefinition.setBackground(new Color(225,247,255));
        String originalText=VocabularyFrame.cardData.get(0).englishDefinition;
        char[] charTemp = originalText.toCharArray();
        int strlen = charTemp.length;
        String finalText = "";
        String space = "     ";
        String temp = space;
        int count=0;
        int len=0;
        int i=0;
        while(i < strlen){
            temp = temp + charTemp[i];
            len = len + 1;
            if((len > 45) || (i == strlen - 1)){
                if((charTemp[i] != ' ') && (i != strlen - 1)){
                    temp = temp + '-';
                }
                finalText = finalText + temp + "\n";
                temp = space;
                len = 0;
            }
            i = i + 1;
        }
        englishDefinition.setText(finalText);
        englishDefinition.setFont(new Font("TimesRoman",Font.BOLD,25));

        jpInformation.add(partOfSpeech);
        jpInformation.add(chineseDefinition);
        jpInformation.add(englishDefinition);

        initialize();

        jpBack.add(jpCenter,BorderLayout.CENTER);

        cardFrame1.setTitle("單字卡");
        cardFrame1.setSize(1000,625);
        GUIUtil.toCenter(cardFrame1);
        //cardFrame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cardFrame1.setVisible(true);

        jbTurn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(getSide()==true){
                    setPanel(false);
                }else{
                    setPanel(true);
                }
            }
        });

        jbChangeOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VocabularyFrame.cardData = randomCard(VocabularyFrame.cardData);
            }
        });

        jbExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setExit(true);
                VocabularyFrame.count=0;
                cardFrame1.dispose();
                VocabularyFrame.cardData = new ArrayList<>();
            }
        });

        jbPrevious.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setIndex(index - 1);
                showCard();
                setPanel(true);
            }
        });

        jbNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setIndex(index + 1);
                showCard();
                setPanel(true);
            }
        });
    }

    public void setExit(boolean exit){
        this.exit = exit;
    }

    public boolean getExit(){
        return this.exit;
    }

    public void setIndex(int index){
        this.index=index;
    }

    public int getIndex(){
        return this.index;
    }


    public void showCard(){
        int number = VocabularyFrame.cardData.size();
        if(!getExit()){
            if(getIndex()>=number){
                setIndex(0);
            }
            if(getIndex()<0){
                setIndex(number-1);
            }
            word.setText(VocabularyFrame.cardData.get(getIndex()).word);
            partOfSpeech.setText(VocabularyFrame.cardData.get(getIndex()).partOfSpeech);
            chineseDefinition.setText(VocabularyFrame.cardData.get(getIndex()).chineseDefinition);
            if(VocabularyFrame.cardData.get(getIndex()).chineseDefinition.length()>30){
                chineseDefinition.setFont(new Font("TimesRoman",Font.BOLD,15));
            }else if(VocabularyFrame.cardData.get(getIndex()).chineseDefinition.length()>15) {
                chineseDefinition.setFont(new Font("TimesRoman", Font.BOLD, 25));
            }else{
                chineseDefinition.setFont(new Font("TimesRoman", Font.BOLD, 35));
            }
            String originalText=VocabularyFrame.cardData.get(getIndex()).englishDefinition;
            char[] charTemp = originalText.toCharArray();
            int strlen = charTemp.length;
            String finalText = "";
            String space = "     ";
            String temp = space;
            int count=0;
            int len=0;
            int i=0;
            while(i < strlen){
                temp = temp + charTemp[i];
                len = len + 1;
                if((len > 45) || (i == strlen - 1)){
                    if((charTemp[i] != ' ') && (i != strlen - 1)){
                        temp = temp + '-';
                    }
                    finalText = finalText + temp + "\n";
                    temp = space;
                    len = 0;
                }
                i = i + 1;
            }
            englishDefinition.setText(finalText);
        }
    }

    public void initialize(){
        jpCenter = new JPanel();
        if(style==true){
            jpCenter.setLayout(new BorderLayout());
            jpCenter.setBackground(new Color(225,247,255));
            jpCenter.add(word,BorderLayout.CENTER);
        }else{
            jpCenter.setLayout(new BorderLayout());
            jpCenter.setBackground(new Color(225,247,255));
            jpCenter.add(jpInformation);
        }
    }

    public void setSide(boolean side){
        this.side=side;
    }

    public boolean getSide(){
        return side;
    }

    public void setPanel(boolean side){
        jpCenter.removeAll();
        if(style == true){
            if(side == true){
                jpCenter.setLayout(new BorderLayout());
                jpCenter.setBackground(new Color(225,247,255));
                jpCenter.add(word,BorderLayout.CENTER);
                setSide(true);
            }else{
                jpCenter.setLayout(new BorderLayout());
                jpCenter.setBackground(new Color(225,247,255));
                jpCenter.add(jpInformation,BorderLayout.CENTER);
                setSide(false);
            }
        }else{
            if(side == true){
                jpCenter.setLayout(new BorderLayout());
                jpCenter.setBackground(new Color(225,247,255));
                jpCenter.add(jpInformation,BorderLayout.CENTER);
                setSide(true);
            }else{
                jpCenter.setLayout(new BorderLayout());
                jpCenter.setBackground(new Color(225,247,255));
                jpCenter.add(word,BorderLayout.CENTER);
                setSide(false);
            }
        }
        jpCenter.repaint(); //重要!!!
        jpCenter.revalidate();
    }

    public ArrayList<Word> randomCard(ArrayList<Word> cardData){
        ArrayList<Word> tempCardArray = new ArrayList<>();
        Random random = new Random();
        int len = cardData.size();
        int tempIndex;
        boolean hasBeenUsed[] = new boolean[len];
        for(int i=0;i<len;i++){
            hasBeenUsed[i] = false;
        }
        for(int i=0;i<len;i++){
            tempIndex = random.nextInt(len);
            while(hasBeenUsed[tempIndex] == true){
                tempIndex = random.nextInt(len);
            }
            tempCardArray.add(cardData.get(tempIndex));
            hasBeenUsed[tempIndex] = true;
        }
        return tempCardArray;
    }
}
