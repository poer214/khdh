import java.util.regex.Pattern;

public class EmailValidator {
    
    private static final String EMAIL_REGEX = "^\\S+@\\S+\\.\\S+$";
    
    public static boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        return pattern.matcher(email).matches();
    }
    
    public static void main(String[] args) {
        String email = "ㅋ@ㅋ.ㅋ";
        if (isValidEmail(email)) {
            System.out.println(email + " 허용");
        } else {
            System.out.println(email + " 불가");
        }
    }
}