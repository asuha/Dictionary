import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Translator translator = new Translator();

        System.out.println("Enter the word you want to translate: ");
        try {
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            String key = bufferRead.readLine();
            ArrayList<String> words = translator.translateWord(key);

            if (words.isEmpty()) {
                System.out.println("Searched word not found in Dictionary, do you want to insert it? (y/n)");

                if ((bufferRead.readLine()).equals("y")) {
                    ArrayList<String> translations = new ArrayList<String>();

                    String keepExecuting;
                    do {
                        System.out.println("Insert translation:");
                        try {
                            translations.add(bufferRead.readLine());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.print("Do you want to insert more words? (y/n)");

                        keepExecuting = bufferRead.readLine();
                    } while (keepExecuting.equals("y"));

                    translator.insertTranslation(key, translations);
                    System.out.println("Following words were inserted: Word - " + key +
                            " Translations: " + translator.translateWord(key));
                }

            }else{
                for (String word : words)
                    System.out.println(word);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}