package recursion;

import java.io.File;

/**
 * Created by Jógvan 21/12-2015 14:28.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("addFromN(5): "+addFromN(5));
        System.out.println();

        System.out.print("printString(\"ABC\"): ");
        printString("ABC");
        System.out.println("\n");

        System.out.println("Files in this project: ");

        printFoldersAndFiles(System.getProperty("user.dir")+"/src");
    }

    public static void printFoldersAndFiles(String folder) {
        printFoldersAndFiles(folder, " ");
    }

    public static void printFoldersAndFiles(String folder, String space){
        File file = new File(folder);
        System.out.println(space+file.getName());

        if(file.isDirectory()){
            for (int i = 0; i < file.listFiles().length; i++) {
                printFoldersAndFiles(file.listFiles()[i].getAbsolutePath(), space + "  ");
            }
        }
    }

    private static int addFromN(int n){
        return n + (n>0 ? addFromN(n-1) : n);
    }

    private static void printString(String string){
        if(string.length()>0){ // Basecase
            printString(string.substring(1));
            System.out.print(string.charAt(0));
        }
    }

}
