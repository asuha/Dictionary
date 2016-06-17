import java.io.*;
import java.util.ArrayList;

//Classe que lida com o arquivo
public class FileHandler {
    private static final String filePath = "data/translations.txt";
    private BufferedReader reader;
    private FileInputStream inputFile;

    //Adiciona nova linha ao arquivo
    private void appendLine(String line){
        BufferedWriter writer = initializeWriter();

        if ( writer != null ) {

            try {

                writer.newLine();
                writer.write(line);
                writer.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    //Inicializa o reader
    private void initializeReader(){
        setReader( new BufferedReader( new InputStreamReader( getInputFile() ) ) );
    }

    //Inicializa o writer
    private BufferedWriter initializeWriter(){

        try {

            FileWriter file = new FileWriter( new File( filePath ), true );
            return new BufferedWriter(file);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    //Carrega o arquivo
    public void loadFile(){

        try {

            setInputFile( new FileInputStream( filePath ) );
            initializeReader();

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    //Gera uma nova linha para ser inserida no arquivo
    public void generateNewLine(String key, ArrayList<String> values){
        String line = key;

        for (String value : values) line += "#" + value;

        appendLine(line);
    }


    public FileInputStream getInputFile() {
        return inputFile;
    }


    public void setInputFile(FileInputStream inputFile) {
        this.inputFile = inputFile;
    }


    public BufferedReader getReader() {
        return reader;
    }


    public void setReader(BufferedReader reader) {
        this.reader = reader;
    }

}
