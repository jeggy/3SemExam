package searching;

import tools.Files;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Jógvan 22/12-2015 14:55.
 */
public class Main {

    static String[] words = Files.contentFromFile(System.getProperty("user.dir")+"/res/words.txt");
    static final String wordToFind = "web";
    static int c = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = "";
        while(!word.equalsIgnoreCase("stop!")) {
            c = 0;
            System.out.print("Type a word and check if it's a word: ");
            word = scanner.next();

            System.out.println("Searching for '" + word + "' via sequential search:");
            long start = System.nanoTime();
            System.out.println("Found: " + isWord(word, words));
            System.out.print("Took " + (System.nanoTime() - start) + "ns");
            System.out.println(" and used " + c + " checks.");

            c = 0;

            System.out.println("\n\nSearching for '" + word + "' via binary search:");
            start = System.nanoTime();
            System.out.println("Found: " + isWordBinary(word, words));
            System.out.print("Took " + (System.nanoTime() - start) + "ns");
            System.out.println(" and used " + c + " checks.");

            System.out.println("----------------------------------");
        }
    }

    private static boolean isWord(String word, String[] words) {
        for (String s : words) {
            c++;
            if (s.equalsIgnoreCase(word))
                return true;
        }
        return false;
    }

    private static boolean isWordBinary(String word, String[] words) {
        return isWordBinary(word, words, 0, words.length-1);
    }

    private static boolean isWordBinary(String word, String[] words, int start, int end){
        if(start>end) return false;
        int half = (end+start) >>> 1;

        int compared = compare(word, words[half]);

        if(compared==0){
            c++;
            return true;
        }else if(compared < 0){
            c+=2;
            return isWordBinary(word, words, start, half-1);
        }else if(compared > 0){
            c+=3;
            return isWordBinary(word, words, half+1, end);
        }

        return false;
    }

    /**
     * Compares 2 strings and returns 0 if they are equal
     * or -1 if 's1' has a lower ascii value than 's2' or +1 otherwise.
     * @param s1
     * @param s2
     * @return the compared value (-1, 0 ,1)
     */
    private static int compare(String s1, String s2){
        int s1l = s1.length();
        int s2l = s2.length();
        int lim = s1l<s2l ? s1l : s2l;

        for (int i = 0; i < lim; i++) {
            if(s1.charAt(i)>s2.charAt(i)){
                return 1;
            }else if(s1.charAt(i)<s2.charAt(i)){
                return -1;
            }
        }
        return s1l == s2l ? 0 : -1;
    }


}
