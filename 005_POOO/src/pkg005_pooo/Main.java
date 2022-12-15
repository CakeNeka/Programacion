package pkg005_pooo;

import java.util.Random;

public class Main {
        
    static Random rand = new Random();
    
    public static void main(String[] args) {
        
        
        System.out.println(dniLetter(77390301));
        
        Persona[] personas = new Persona[60];
        double time = System.nanoTime();
        // 4.5 ms string concatenation
        //     ms string builder
        for(int i = 0; i < personas.length; i++){    
            personas[i] = generatePersona();
        }
        
        System.out.printf("Time elapsed: %.04f ms\n", (System.nanoTime() - time) / 1_000_000);
        
        for(int i = 0; i < personas.length; i++){    
            System.out.println(personas[i]);
        }
        
        
        
    }

    static String generateName(){
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        String name = "";
        String[] pref = {"Ale","Mar","Vic","Leo","Dar","Ja","Je","Car"};
        String[] mid = {"ri","jan","i","ti","","thar","nar","ta","vi","roe"};
        String[] suf = {"dra","dro","na","no","tor","","do","da","er"};
        
        sb.append(pref[rand.nextInt(pref.length)]);
        sb.append(mid[rand.nextInt(mid.length)]);
        sb.append(suf[rand.nextInt(suf.length)]);
        
        sb.append(", ");
        String[] first = {"Rey","Reina","Archimago","Gigante","Príncipe","Goblin","Demonio","Bruja"};
        String[] location = {"del Zaidín" , "de Dílar", "de Atenas","de La Atlántida"};
        
        sb.append(first[rand.nextInt(first.length)]);
        sb.append(" ");
        sb.append(location[rand.nextInt(location.length)]);
        return sb.toString();
    }

    static Persona generatePersona(){
        Random rand = new Random();
        
        String name = generateName();
        float altura = (float) (Math.random() + 1);
        float peso = (float) (30 + Math.random() * (120 - 30));
        
        String nacion = Persona.Nacionalidad.values()
                [rand.nextInt(Persona.Nacionalidad.values().length)].toString();
        
        char dniLet = (char) (rand.nextInt(24) + 65);
        String dni = String.valueOf((int)(Math.random() * 10000000)) + Character.toString(dniLet);
        int edad = rand.nextInt(120);
        
        String sexo = Persona.Sexo.values()
                [rand.nextInt(Persona.Sexo.values().length)].toString();
        
        return new Persona(name, altura, peso, nacion, dni, (byte)edad, sexo);
    }
    
    static boolean dniValidator(String dni){
        
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
    
    static char dniLetter(int dni){
        char[] dniLetters = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B',
        'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        
        return dniLetters[dni % 23];
    }

    
    
    
    
    
    
    
    
    
    
    public static int sumSubarraysOfLengthk(int[] arr, int k) {

        int sum = 0;
        int curSum = 0;

        for (int i = 0; i < k; i++) {
            curSum += arr[i];
        }

        sum = curSum;

        for (int i = 0; i < arr.length - k; i++) {
            curSum -= arr[i];
            curSum += arr[i + k];

            sum += curSum;
        }

        return sum;
    }

    public static int algoritmoExamen(int[] tables, int customers) {
        boolean ZeroFound = false;
        boolean goodTableFound = false;
        int i = 0;
        int best = 0;
        int mesaConMasAsientosOcupados = 0;

        while (i < tables.length && !ZeroFound) {
            if (tables[i] == 0) {
                best = i + 1;
                ZeroFound = true;
            } else if (tables[i] + customers == 4) {
                best = i + 1;
                goodTableFound = true;
            } else if (tables[i] + customers < 4 && mesaConMasAsientosOcupados < tables[i]
                    && !goodTableFound) {

                mesaConMasAsientosOcupados = tables[i];
                best = i + 1;
            }
            i++;
        }

        return best;
    }
}
