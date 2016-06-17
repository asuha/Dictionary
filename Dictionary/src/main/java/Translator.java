import java.io.IOException;
import java.util.*;

public class Translator {
    private AVLTree tree;
    private FileHandler file;

    public Translator(){
        setTree( new AVLTree() );
        setFile( new FileHandler() );
        getFile().loadFile();
        loadDictionary();
    }

    private Dictionary prepareData(String line){
        if ( line != null) {

            List<String> lineValues = new LinkedList<String>(Arrays.asList(line.split("#")));
            ArrayList<String> values = new ArrayList<String>();
            String key = lineValues.remove(0);
            values.addAll(lineValues);
            return new Dictionary( key, values );

        }

        return null;
    }

    private void loadDictionary(){
        String line;
        try {

            while ( ( line = getFile().getReader().readLine() ) != null) {
                Dictionary dictionary = prepareData(line);
                getTree().insert(dictionary.getWord(), dictionary.getDefinitions());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<String> translateWord(String word){
        return getTree().searchNode(word);
    }

    public void insertTranslation(String key, ArrayList<String> translations){
        Node node = getTree().insert(key, translations);
        getFile().generateNewLine(node.getKey(), node.getValues());
    }

    public AVLTree getTree() {
        return tree;
    }

    public void setTree(AVLTree tree) {
        this.tree = tree;
    }

    public FileHandler getFile() {
        return file;
    }

    public void setFile(FileHandler file) {
        this.file = file;
    }
}
