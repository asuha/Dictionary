import java.io.*;
import java.util.ArrayList;

public class FileHandler {
    private static final String filePath = "data/translations.txt";
    private BufferedReader reader;
    private FileInputStream inputFile;


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


    private void initializeReader(){
        setReader( new BufferedReader( new InputStreamReader( getInputFile() ) ) );
    }


    private BufferedWriter initializeWriter(){

        try {

            FileWriter file = new FileWriter( new File( filePath ), true );
            return new BufferedWriter(file);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


    public void loadFile(){

        try {

            setInputFile( new FileInputStream( filePath ) );
            initializeReader();

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }


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
