package tools;

import java.util.regex.Pattern;

/**
 * Created by Jógvan on 30/11-2015 17:56.
 */
public class Regex {

    public static boolean isColor(String val){
        return Pattern.matches("^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$", val);
    }

    public static boolean validUsername(int min, int max, String val){
        return Pattern.matches("^[a-z0-9_-]{"+min+","+max+"}$", val);
    }
}
