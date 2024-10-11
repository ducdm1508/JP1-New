package Global;

import java.util.regex.Pattern;

public class Ordervalidation {

    public static boolean validateOrderId(String id){
        return Pattern.matches("(ORDPM)[0-9]{8}", id);
    }
}
