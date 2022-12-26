package micole;


public class DNIValidator {
    
    static boolean validate(String dni){
        
        dni = dni.trim().toUpperCase();
        int len = dni.length();
        
        if(len != 9 || !Character.isLetter(dni.charAt(len - 1)))
            return false;
        
        int num;
        try {
            num = Integer.parseInt(dni.substring(0,8)) ;
        } catch (NumberFormatException e){
            return false;
        }   
        return dni.charAt(8) == dniLetter(num);
    }
    
    private static char dniLetter(int dni){
        char[] dniLetters = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B',
        'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        
        return dniLetters[dni % 23];
    }
}
