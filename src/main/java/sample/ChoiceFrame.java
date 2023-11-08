package sample;

import javax.swing.*;

public class ChoiceFrame extends JFrame {
    public ChoiceFrame(){
        super("Choice Frame");
        String[] options = {"再查詢一次","改成手動輸入","重新輸入單字"};
        int choice = JOptionPane.showOptionDialog(this,"發生錯誤，請選擇處理方式","請選擇",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,"再查詢一次");
        VocabularyFrame.count = VocabularyFrame.count + 1;
        if(choice == JOptionPane.YES_OPTION){
            new FindFromWebsite();
        }else if(choice == JOptionPane.NO_OPTION){
            FindFromWebsite.partOfSpeech = JOptionPane.showInputDialog(this, "請輸入詞性");
            FindFromWebsite.chineseDefinition = JOptionPane.showInputDialog(this, "請輸入中文解釋");
            FindFromWebsite.englishDefinition = JOptionPane.showInputDialog(this, "請輸入英文解釋");
        }else if(choice == JOptionPane.CANCEL_OPTION){
            String[] optionsAgain = {"查詢線上字典","手動輸入"};
            FindFromWebsite.word = JOptionPane.showInputDialog(this, "請輸入單字");
            int way = JOptionPane.showOptionDialog(this,"請選擇進行方式","請選擇",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,optionsAgain,"查詢線上字典");
            if(way == JOptionPane.YES_OPTION) {
                new FindFromWebsite();
                AddInVisitor.partOfSpeech = FindFromWebsite.partOfSpeech;
                AddInVisitor.chineseDefinition = FindFromWebsite.chineseDefinition;
                AddInVisitor.englishDefinition = FindFromWebsite.englishDefinition;
            }else {
                AddInVisitor.partOfSpeech = JOptionPane.showInputDialog(this, "請輸入詞性");
                AddInVisitor.chineseDefinition = JOptionPane.showInputDialog(this, "請輸入中文解釋");
                AddInVisitor.englishDefinition = JOptionPane.showInputDialog(this, "請輸入英文解釋");
            }
        }
    }

    public static String inputPartOfSpeech(){
        String partOfString = JOptionPane.showInputDialog(null, "請輸入詞性");
        return partOfString;
    }

    public static String inputChineseDefinition(){
        String chineseDefinition = JOptionPane.showInputDialog(null, "請輸入中文解釋");
        return chineseDefinition;
    }

    public static String inputEnglishDefinition(){
        String englishDefinition = JOptionPane.showInputDialog(null, "請輸入英文解釋");
        return englishDefinition;
    }

}

