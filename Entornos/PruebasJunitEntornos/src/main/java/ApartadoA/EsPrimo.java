package ApartadoA;

public class EsPrimo {

    public static void main(String[] args) {
        System.out.println(esPrimo(Integer.MAX_VALUE));
    }
    
    public static boolean esPrimo(int num) {
        if (num < 2) {
            return false;
        }
        if (num == 2 || num == 3) {
            return true;
        }
        if (num % 2 == 0 || num % 3 == 0) {
            return false;
        }
        int sqrt = (int) Math.sqrt(num) + 1;
        for (int i = 6; i <= sqrt; i += 6) {
            if (num % (i - 1) == 0 || num % (i + 1) == 0) {
                return false;
            }
        }
        return true;
    }


}
