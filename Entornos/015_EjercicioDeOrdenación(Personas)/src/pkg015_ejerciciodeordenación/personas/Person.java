package pkg015_ejerciciodeordenación.personas;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Person{

    public enum Gender {
        MALE, FEMALE, OTHER
    }
    
    // Campos
    private String name;
    private String surname;
    private String idCard;
    private String domicilio;
    private String eMail;       // name@gmail.com
    
    private LocalDate birthDate;
    private int telefono;
    private Gender gender;

    //Métodos

    private Person(String name, String surname, String idCard, String domicilio, String eMail, LocalDate birthDate, int telefono, Gender gender) {
        this.name = name;
        this.surname = surname;
        this.idCard = idCard;
        this.domicilio = domicilio;
        this.eMail = eMail;
        this.birthDate = birthDate;
        this.telefono = telefono;
        this.gender = gender;
    }
    Person() {}

    public static Person generatePerson(String name, String surname, int idCard, String domicilio, String eMail, LocalDate birthDate, int telefono, String gender) {
        if (correct(name, surname, idCard, domicilio, eMail, birthDate, telefono)) {
            String strIdCard = idCard + "" + dniLetter(idCard);
            return new Person();
        }
        return null;
    }
    
    public static Person generateRandomPerson(){
        Random random = new Random();
        String name = NameGenerator.createFullName();
        byte age = (byte) random.nextInt(100);
        String gender = Gender.values()[random.nextInt(Gender.values().length)].toString();
        String idCard = generateIdCard();
        return null;
    }
    
    public static String generateIdCard() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int idCard = random.nextInt(10000000, 99999999);
        String dniLetter = Character.toString(dniLetter(idCard));
        return idCard + dniLetter;
    }

    static boolean correct(String name, String surname, int idCard, String domicilio, String eMail, LocalDate birthDate, int telefono) {
        return nameOK(name) && nameOK(surname) && hasNDigits(idCard, 8) && nameOK(domicilio) && eMailOK(eMail)
                && birthDateOk(birthDate) && hasNDigits(telefono, 9); 
    }

    static boolean nameOK(String name) {
        return !name.trim().isEmpty();
    }

    static boolean birthDateOk(LocalDate birthDate) {
        return birthDate.getYear() >= 1900 && birthDate.isBefore(LocalDate.now());
    }

    static boolean genderOk(Gender gender) {
        return gender != null;
    }
    
    /**
     * El mail deberá contener, al menos, uno o más caracteres alfanuméricos,
     * luego una arroba y luego uno o más caracteres alfanuméricos.
     * @param eMail
     * @return 
    */
    static boolean eMailOK(String eMail) {        
        String[] mail = eMail.split("@");
        if (mail.length != 2) return false;
        for (String string : mail) {
            for (int i = 0; i < string.length(); i++) {
                if (!Character.isLetterOrDigit(string.charAt(i))){
                    return false;
                }
            }
        }
        return true;
    }
    
    static boolean hasNDigits(int num, int digits){
        int digitos = (int)(Math.log10(num)+1);
        return digitos == digits ;
    }
    
    static char dniLetter(int dni){
        char[] dniLetters = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B',
        'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        
        return dniLetters[dni % 23];
    }

    
    /*
    @Override
    public int compareTo(Object t) {
        Person other = (Person) t;
        int otherId = Integer.parseInt(other.idCard.substring(0,8));
        
        int thisId = Integer.parseInt(idCard.substring(0,8));
        
        return Integer.compare(thisId, otherId);
        /*
        if (otherId == thisId) return 0;
        if (thisId < otherId) return -1;
        else return 1;
        
        return thisId - otherId;
        
    }
    */
    
    
}
