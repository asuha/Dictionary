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
            //Lê a palavra à ser traduzida
            String key = bufferRead.readLine();
            //Busca as traduções para palavra
            ArrayList<String> words = translator.translateWord(key);

            //Se não existem traduções pergunda ao usuário se ele deseja inserí-las
            if (words.isEmpty()) {
                System.out.println("Searched word not found in Dictionary, do you want to insert it? (y/n)");
                //Se o usuário deseja inserir novas palavras para chave informada
                if ((bufferRead.readLine()).equals("y")) {
                    ArrayList<String> translations = new ArrayList<String>();

                    String keepExecuting;
                    do {
                        System.out.println("Insert translation:");
                        try {
                            //Solicita as traduções
                            translations.add(bufferRead.readLine());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.print("Do you want to insert more words? (y/n)");

                        keepExecuting = bufferRead.readLine();
                      //Enquanto usuário deseja inserir traduções solicita palávras
                    } while (keepExecuting.equals("y"));

                    //Insere a tradução no dicionário
                    translator.insertTranslation(key, translations);
                    //Exibe palavra chave e traduções inseridas
                    System.out.println("Following words were inserted: Word - " + key +
                            " Translations: " + translator.translateWord(key));
                }

            }else{
                //Se a palavra chave já existe no dicionário exibe as traduções
                System.out.println("Word: " + key + " Traduções: " + words);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}