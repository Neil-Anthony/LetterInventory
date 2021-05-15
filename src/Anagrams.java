import java.util.Dictionary;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Anagrams {
    private final Set<String> dictionary;
    private Set<String> solutionSet = new HashSet<>();
    private LetterInventory lI;
    private Set<String> matchingWords;


    public Anagrams(Set<String> dictionary){

        if(dictionary == null){
            throw new IllegalArgumentException();
        }
        this.dictionary = dictionary;
    }


    public Set<String> getWords(String phrase){
        /*
        If passed in a string that is empty Fail.
        Otherwise-
        Make a LetterInventory of the String
        Make an empty string HashSet.
        Go through each dictionary word, if
         */
        if (phrase == null){
            throw new IllegalArgumentException();
        }
        lI = new LetterInventory(phrase);
        matchingWords = new HashSet<>();
        for (String dWord: dictionary) {
            if(lI.contains(dWord)){
                matchingWords.add(dWord);
            }
        }
        return matchingWords;
    }

    public void print(String phrase){
        boolean solution = false;
        lI = new LetterInventory(phrase);

        /*
        If the getWords does not find any words that

         */

        if (getWords(phrase)== null && phrase.length() == 0){
//            System.out.println("Victory is mine!");
            System.out.println(solutionSet);
            //solutionSet.clear();
        } else {
            for(String g : getWords(phrase)){
                lI = new LetterInventory(phrase);
                if (lI.contains(g)){
                    solutionSet.add(g);
                    lI.subtract(g);
                    print(lI.toString());
                }
                solutionSet.remove(g);
                /*
                solutionSet.add(g);
                phr.subtract(g);
                //System.out.println(solutionSet);
                Set<String> wordSet = getWords(phr.toString());
                //System.out.print(solutionSet);
                if (!phr.isEmpty() && wordSet.size() == 0){
                    solutionSet.clear();
                }
//                String next = phr.toString();
                print(phr.toString());
                 */
            }
        }
    }
}

