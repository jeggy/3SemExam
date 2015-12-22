package searching;

import tools.Files;

import java.util.Arrays;

/**
 * Created by Jógvan 22/12-2015 14:55.
 */
public class Main {

    static String[] words = Files.contentFromFile(System.getProperty("user.dir")+"/res/words.txt");
    static final String wordToFind = "web";
    static int c = 0;

    public static void main(String[] args) {
        System.out.println("Searching for '"+wordToFind+"' via sequential search:");
        long start = System.nanoTime();
        System.out.println("Found: "+isWord(wordToFind, words));
        System.out.print("Took "+(System.nanoTime()-start)+"ns");
        System.out.println(" and used "+c+" checks.");

        c = 0;

        System.out.println("\n\nSearching for '"+wordToFind+"' via binary search:");
        start = System.nanoTime();
        System.out.println("Found: "+isWordBinary(wordToFind, words));
        System.out.print("Took "+(System.nanoTime()-start)+"ns");
        System.out.println(" and used "+c+" checks.");
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
        return s1l==s2l ? 0 : -1;
    }


}
