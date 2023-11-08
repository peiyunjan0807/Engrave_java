package sample;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.swing.*;

public class FindFromWebsite {
    public static String word="";
    public static String partOfSpeech="";
    public static String chineseDefinition="";
    public static String englishDefinition="";

    public FindFromWebsite(){
        String html = "https://dictionary.cambridge.org/zht/%E8%A9%9E%E5%85%B8/%E8%8B%B1%E8%AA%9E-%E6%BC%A2%E8%AA%9E-%E7%B9%81%E9%AB%94/"+word;
        Document doc = null;
        try {
            doc = Jsoup.connect(html).get();
            String partOfSpeechData = doc.body().select("span[class=pos dpos]").toString();
            String englishDefinitionData = doc.body().select("div[class=def ddef_d db]").toString();
            String chineseDefinitionData = doc.body().select("span[class=trans dtrans dtrans-se  break-cj]").toString();
            partOfSpeech = apart(partOfSpeechData,0);
            englishDefinition = apart(englishDefinitionData,1);
            chineseDefinition = apart(chineseDefinitionData,0);
            if((partOfSpeech=="") || (englishDefinition=="") || (chineseDefinition == "")){
                VocabularyFrame.count = VocabularyFrame.count - 1;
                throw new Exception("cannot find");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"抱歉!查無此資料","Warning",JOptionPane.WARNING_MESSAGE);
            new ChoiceFrame();
        }
    }

    public static String apart(String definition, int mode){
        String tempString="";
        char[] tempCharArray=definition.toCharArray();
        int i=0;
        boolean sign = false;
        if(mode==0) {
            while (i < tempCharArray.length) {
                if (tempCharArray[i] == '/') {
                    break;
                }
                if (tempCharArray[i] == '<') {
                    sign = true;
                }
                if ((sign == false) && (tempCharArray[i]!='\n')) {
                    if(tempCharArray[i]=='→'){
                        tempString = tempString + "->";
                        i=i+5;
                    }else {
                        tempString = tempString + tempCharArray[i];
                    }
                }
                if (tempCharArray[i] == '>') {
                    sign = false;
                }
                i = i + 1;
            }
        }else{
            while (i < tempCharArray.length) {
                if ((tempCharArray[i] == '/') && (tempCharArray[i+1] == 'd') && (tempCharArray[i+2] == 'i' && (tempCharArray[i+3] == 'v'))) {
                    break;
                }
                if (tempCharArray[i] == '<') {
                    sign = true;
                }
                if ((sign == false) && (tempCharArray[i]!='\n')) {
                    tempString = tempString + tempCharArray[i];
                }
                if (tempCharArray[i] == '>') {
                    sign = false;
                }
                i = i + 1;
            }
        }
        return tempString;
    }
}

