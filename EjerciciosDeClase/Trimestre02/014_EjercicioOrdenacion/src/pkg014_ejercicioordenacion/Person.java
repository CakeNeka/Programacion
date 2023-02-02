package pkg014_ejercicioordenacion;

import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Person implements Comparable{

    public enum Gender {
        MALE, FEMALE, OTHER
    }

    // Campos
    private String name;
    private byte age;
    private Gender gender;
    private String idCard;

    //Métodos
    private Person(String name, byte age, Gender gender, String idCard) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.idCard = idCard;
    }

    public static Person generatePerson(String name, byte age, String gender, String idCard) {
        if (correct(name, age, idCard)) {
            Gender g = genderOkRut(gender);
            return new Person(name, age, g, idCard);
        }
        return null;
    }
    
    public static Person generateRandomPerson(){
        Random random = new Random();
        String name = NameGenerator.createFullName();
        byte age = (byte) random.nextInt(100);
        String gender = Gender.values()[random.nextInt(Gender.values().length)].toString();
        String idCard = generateIdCard();
        return generatePerson(name, age, gender, idCard);
    }
    
    public static String generateIdCard() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int idCard = random.nextInt(10000000, 99999999);
        String dniLetter = Character.toString(dniLetter(idCard));
        return idCard + dniLetter;
    }

    static boolean correct(String name, byte edad, String idCard) {
        return nameOK(name) && ageOK(edad) && idCardOK(idCard);
    }

    static boolean nameOK(String name) {
        return !name.trim().isEmpty();
    }

    static boolean ageOK(byte edad) {
        return edad >= 0 && edad < 130;
    }

    static Gender genderOK(String gender) {

        for (Gender value : Gender.values()) {
            if (value.toString().equals(gender)) {
                return Gender.valueOf(gender);
            }
        }
        return Gender.OTHER;
    }

    static Gender genderOkRut(String gender) {
        gender = gender.toUpperCase();
        Gender res;
        try {
            res = Gender.valueOf(gender);
        } catch (IllegalArgumentException ex){
            System.err.println(ex.getMessage());
            res = Gender.OTHER;
        }
        return res;
    }
    
    static boolean idCardOkRut(String dni) {
        return true;
    }
    
    static boolean idCardOK(String dni){
        
        dni = dni.trim();
        int len = dni.length();
        
        if(len != 9 || !Character.isLetter(dni.charAt(len - 1)))
            return false;
        
        char[] arr = dni.toCharArray();
        
        for (int i = 0; i < len-1; i++) {
            if (!Character.isDigit(arr[i]))
                return false;
        }
        int num = Integer.parseInt(dni.substring(0,8)) ;
        return dni.charAt(8) == dniLetter(num);
    }
    
    static char dniLetter(int dni){
        char[] dniLetters = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B',
        'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        
        return dniLetters[dni % 23];
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", age=" + age + ", gender=" + gender + ", idCard=" + idCard + '}';
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

    @Override
    public int compareTo(Object t) {
        Person other = (Person) t;
        return this.age - other.age;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        return this.age == other.age;
    }

    

    public String showNameId() {
        return name + " " + idCard;
    }
    
    // Getters & Setters
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
    
    
    
}
