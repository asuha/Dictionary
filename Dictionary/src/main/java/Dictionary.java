import java.util.ArrayList;

//Classe de dicionário para armazenar informações de palavras e chaves
public class Dictionary {
    private String word;
    private ArrayList<String> definitions;

    public Dictionary(String word, ArrayList<String> definitions){
        setDefinitions(definitions);
        setWord(word);
    }

    public ArrayList<String> getDefinitions() {
        return definitions;
    }


    public void setDefinitions(ArrayList<String> definitions) {
        this.definitions = definitions;
    }


    public String getWord() {
        return word;
    }


    public void setWord(String word) {
        this.word = word;
    }
}
