import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Translator translator = new Translator();

        System.out.println("Enter the word in want to translate: ");
        try{
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            ArrayList<String> words = translator.translateWord(bufferRead.readLine());

            if (words.isEmpty())
                System.out.println("Searched word was not found in Dictionary, do you want to insert it?");

            else
                for (String word: words)
                    System.out.println(word);
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }
}