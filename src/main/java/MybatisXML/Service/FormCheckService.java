package MybatisXML.Service;

import java.util.regex.Pattern;

public class FormCheckService {

    public static boolean emailChecker(String email){
        return Pattern.matches("\\w{1,20}\\.?\\w{1,20}@\\w{2,10}\\.\\w{2,10}", email);
    }

    public static boolean userNameChecker(String username){
        return Pattern.matches("\\w{2,12}", username);
    }

    public static boolean passwordChecker(String password){
        return (Pattern.matches("[a-z]{1,20}[A-Z]{1,20}[0-9]{1,20}", password) && password.length()>5);
    }
}
