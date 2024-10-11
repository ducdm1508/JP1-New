package Global;

import java.util.regex.Pattern;

public class ProductValidation {

    public static boolean validateProId(String id){
        return Pattern.matches("(MS|NE|SE)[0-9]{6}", id);
    }

    public static boolean validateProName(String name){
        return Pattern.matches("^[a-zA-Z\\\\s]+$", name);
    }

}
