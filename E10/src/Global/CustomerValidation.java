package Global;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class CustomerValidation {

    public static boolean validateCusId(int id) {
        return id > 0;
    }

    public static boolean validateCusName(String name) {
        return Pattern.matches("^[a-zA-Z]+$", name);
    }
}