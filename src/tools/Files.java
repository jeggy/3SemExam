package tools;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Jógvan 22/12-2015 14:55.
 */
public class Files {
    /**
     *
     * @param path
     * @return files content or null if something goes wrong.
     */
    public static String[] contentFromFile(String path){
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String l;
            ArrayList<String> full = new ArrayList<>();
            while((l = br.readLine()) != null){
                full.add(l);
            }
            br.close();
            return full.toArray(new String[full.size()]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
