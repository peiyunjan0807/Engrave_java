package sample;
public class Word {
    public String word;
    public String partOfSpeech;
    public String chineseDefinition;
    public String englishDefinition;

    public Word(String word, String partOfSpeech, String chineseDefinition, String englishDefinition){
        this.word = word;
        this.partOfSpeech = partOfSpeech;
        this.chineseDefinition = chineseDefinition;
        this.englishDefinition = englishDefinition;
    }

    public String getWord(){
        return word;
    }

    public String getPartOfSpeech(){
        return partOfSpeech;
    }

    public String getChineseDefinition(){
        return chineseDefinition;
    }

    public String getEnglishDefinition(){ return englishDefinition; }
}


