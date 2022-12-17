package stringapp;
import java.util.ArrayList;
import java.util.Scanner;

public class StringApp {
    
    static Scanner scan = new Scanner(System.in);
    public static void main(String... args)
    {
        cesar();
    }
            
    /** 
     * 
     * @param args 
     */
    public static void smain(String[] args){
        
        Problem.cesar();
        
        String name2 = "AAAB";
        String str = "AZAA";
        
        
        System.out.println(name2.compareTo(str));
        
        //STRING FORMAT:
   //espacio total que ocupará el número como mínimo(incluyendo ',') . número de dígitos decimales
        String cLog = String.format("%s recibió %7.2f puntos de daño","Minsc",223.31534);
        System.out.println(cLog);
        
        String str1 = String.format("%d", 101);  
        String str2 = String.format("|%10d|", 101);  // Specifying length of integer  
        String str3 = String.format("|%-10d|", 101); // Left-justifying within the specified width  
        String str4 = String.format("|% d|", 101);   
        String str5 = String.format("%010d", 101); // Filling with zeroes 
        
        str1 = str1.replace("dd", "jo");
        str1 = str1.replaceFirst("dd", "jo");
        
        str1 = String.format("%d", 101);          // Integer value  
        str2 = String.format("%s", "Amar Singh"); // String value  
        str3 = String.format("%f", 101.00);       // Float value  
        str4 = String.format("%x", 101);          // Hexadecimal value  
        str5 = String.format("%c", 'c');          // Char value  
//        for (int i = 0; i < name2.length(); i++) 
//        {
//            System.out.println(name2.indexOf('a',i));
//            i = name2.indexOf('a',i);
//        }
//        
//        System.out.println("---");
//        
//        
//        
//        int pos = name2.indexOf('d');
//        while(pos != -1)
//        {
//            System.out.println(pos);
//            pos = name2.indexOf('d', pos + 1);
//        }

        String nums = "3 12 12 3  ";
        int num = Integer.parseInt(nums.replace(" ", ""));
        
        nums = "3 12 12 3  ";
        String sol = "";
        for (char c : nums.toCharArray()) 
        {
            if (Character.isDigit(c))
                sol += c;
        }
        System.out.println(sol.charAt(3));
        //System.out.println(sol[3]);
        
        String habilidades = "fuerza,carisma,constitucion";
        String[] habArray = habilidades.split(",");
        System.out.println(String.valueOf(habilidades.toCharArray()));
        
        System.out.println(String.format("La suma de %08d + %.2f es %06.2f", 12, 3.3, 12+3.3));
                                                 // %8d --> rellenaa  la izquierda con espacios
                                                  // %08d -> rellena a  la izquierda con ceros.
                                                  // %-8d -> rellena a la derecha con espacios
        // booleanos:
        //Character. isDigit() ; .isLetter ; .isUpperCase ; . isLowerCase
        
        //pedir cadena y encriptar con césar.
        System.out.println("");
    }
    
    
    
    
    
    // Pedir una cadena al usuario y nostrar esa cadena subdivivdas
    //1. En subcadenas de longitud 3
    
    //2. Invertir la cadena original introducida por el usuario
    
    //3. Mostrar el número de cada una de las vocales (a e i o u) y consonantes
    
    //4. Codificar el algoritmo de encriptación césar.
    
    //5. Criptografía ( Vamos a egnerar un string de tamaño aleatorio ( entre 1 y 50)
    // formado por dígitos numéricos solamente, generados al azar. Una vez generado
    // el string tenemos que buscar el dígito que más se repite. Y subdividimos el string
    // por este número que hemos encontrado) luego cojemos esas subcadenas de dos en dos 
    // y mostramos su código ASCII. ejemplo: '12525905895235' --> se repite más el 5
    // subdividimos por número 5 sin incluirlo. ['12' '2' '90' '89'...] cojo de dos en dos
    // cada una de estas subcadenas. cojo el caracter correspondiente a cada uno de los dos números
    // en la tabla ASCII.
    
    //6. Sopa de letras. Le vamos a pedeir las palabras que quiere esconder y
    //vamos a generar una sopa de letras

    public static void cesar()
    {
        System.out.println("Introduce texto");
        String input = scan.nextLine();
        char[] arr = input.toLowerCase().toCharArray();
        for (int i = 0; i < arr.length; i++) 
        {
            if(arr[i] != ' ')
            {
                arr[i] += 3;
                if (arr[i] > 122)
                {
                    arr[i] -= 26;
                }
            }
        }
        System.out.println(String.valueOf(arr));
    }
    
    
    
    
    
    
    
    
    public static void ej1()
    {
        System.out.println("Introduce texto");
        String input = scan.nextLine();
        char[] inputArray = input.toCharArray();
        for (int i = 0; i < input.length(); i++) 
        {
            System.out.print(inputArray[i]);
            
            if ((i+1) % 3 == 0)
                System.out.println("");
        }
        
    }
    
    public static void ej1_1()
    {
        System.out.println("Introduce texto");
        String input = scan.nextLine();
        String[] subStrings = new String[input.length()/3+1];
        int j = 0;
        for (int i = 0; i < input.length() ; i+=3) 
        {
            subStrings[j] = input.substring(i, i+3);
            j++;
        }
        
        for (String subString : subStrings) {
            System.out.println(subString);
        }
    }
    
    public static void ej5()
    {
             
    }
    
}
    
    
    
    