import java.util.ArrayList;

public class Main {

    public static void main(String[] args){

        Translator translator = new Translator();

        ArrayList<String> words = translator.translateWord("Test");
        ArrayList<String> newWords = new ArrayList<String>();
        newWords.add("Muito Obrigado");
        newWords.add("Muito Obrigada");
        translator.insertTranslation("Thanks",newWords);
        ArrayList<String> newInsert = new ArrayList<String>();
        newInsert.add("WQA");
        newInsert.add("WAS");
        translator.insertTranslation("WordTest",newInsert);

        ArrayList<String> newInsert1 = new ArrayList<String>();
        newInsert1.add("Muito Obrigado");
        newInsert1.add("Muito Obrigada");
        translator.insertTranslation("AAA",newInsert1);
    }

}
