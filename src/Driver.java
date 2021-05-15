import java.io.File;
import java.io.FileNotFoundException;
import java.util.Dictionary;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Driver {
    public static void main(String[] args) throws FileNotFoundException {
        Set<String> words = new TreeSet<String>();
        File f = new File("dict1.txt");
        Scanner filescan = new Scanner(f);
        String word;

        //words.add("TEST");
        //System.out.println(words);
        while (filescan.hasNextLine()){
            word = filescan.nextLine();
            words.add(word);
        }
        //System.out.println(words);

        Set<String> match = matchSet("Barbra Bush", words);
//        System.out.println(match);
        Anagrams TEST = new Anagrams(words);
        //System.out.println(TEST.getWords("BarbraBush"));
        TEST.print("hairbrush");

    }

    public static Set<String> matchSet(String word, Set<String> dictionary){
        LetterInventory w = new LetterInventory(word);
        Set<String> matchingWords = new TreeSet<>();
        for (String dWord: dictionary) {
            LetterInventory dW = new LetterInventory(dWord);
            if(w.contains(dW)){
                matchingWords.add(dWord);
            }
        }
        return matchingWords;
    }
}
