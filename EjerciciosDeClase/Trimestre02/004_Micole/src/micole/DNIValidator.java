package micole;


public class DNIValidator {
    
    static boolean validate(String dni){
        
        dni = dni.trim();
        int len = dni.length();
        
        if(len != 9 || !Character.isLetter(dni.charAt(len - 1)))
            return false;
        
        char[] arr = dni.toCharArray();
        
        for (int i = 0; i < len-1; i++) {
            if (!Character.isDigit(arr[i]))
                return false;
        }
        int num = Integer.parseInt(dni.substring(0,9)) ;
        return dni.charAt(9) == dniLetter(num);
    }
    
    private static char dniLetter(int dni){
        char[] dniLetters = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B',
        'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        
        return dniLetters[dni % 23];
    }
}
