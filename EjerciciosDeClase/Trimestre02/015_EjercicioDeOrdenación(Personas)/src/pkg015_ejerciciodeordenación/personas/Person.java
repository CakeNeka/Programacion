package pkg015_ejerciciodeordenación.personas;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Person implements Comparable{

    public enum Gender {
        MALE, FEMALE, OTHER
    }
    
    // Campos
    private String name;
    private String surname;
    private String idCard;
    private final String domicilio; // ¿Por qué debe ser constante?
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
    

    public static Person generatePerson(String name, String surname, int idCard, String domicilio, String eMail, LocalDate birthDate, int telefono, String stringGender) {
        stringGender = stringGender.toUpperCase();
        if (correct(name, surname, idCard, domicilio, eMail, birthDate, telefono)) {
            String strIdCard = idCard + "" + dniLetter(idCard);
            Gender gender = Gender.valueOf(stringGender);
            return new Person(name, surname, strIdCard, domicilio, eMail, birthDate, telefono, gender);
        }
        return null;
    }
    
    /**
     * personas GENERADAS ALEATORIAMENTE
     * @return 
     */
    public static Person generateRandomPerson(){
        ThreadLocalRandom random = ThreadLocalRandom.current();
        
        String name = NameGenerator.createName();
        String surname = NameGenerator.createSurname();
        String idCard = generateIdCard();
        String domicilio = "Calle " + surname;
        String eMail = name + "@gmail.com";
        LocalDate birthDate = generateRandomDate();
        int telefono = random.nextInt(100000000, 999999999);
        Gender gender = Gender.values()[random.nextInt(Gender.values().length)];
        return new Person(name, surname, idCard, domicilio, eMail, birthDate, telefono, gender);
    }
    
    /**
     * Genera una fecha aleatoria entre el 1900 y este año
     * @return Fecha de nacimiento generada aleatoriamente
     */
    private static LocalDate generateRandomDate() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int[] daysOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int maxYear = LocalDate.now().getYear();
        
        int year = random.nextInt(1900, maxYear + 1);
        if (isLeap(year)) 
            daysOfMonth[1] = 29;
        
        int month = random.nextInt(1,13);
        int day = random.nextInt(1, daysOfMonth[month-1] + 1);
        return LocalDate.of(year, month, day);
    }
    
    static boolean isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    
    /**
     * Genera un DNI Aleatorio
     * @return El DNI con letra
     */
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
    
    /**
     * "El nombre no esté vacío"
     * @param name
     * @return 
     */
    static boolean nameOK(String name) {
        return !name.trim().isEmpty();
    }
    
    /**
     * Supongo que controlamos que no sea en el futuro ni hace demasiado tiempo
     * @param birthDate
     * @return 
     */
    static boolean birthDateOk(LocalDate birthDate) {
        return birthDate.getYear() >= 1900 && birthDate.isBefore(LocalDate.now());
    }
    
    /**
     * El valor del string está en el enum
     * @param gender
     * @return 
     */
    static boolean genderOk(String gender) {
        try{
            Gender g = Gender.valueOf(gender);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
    
    /**
     * El mail deberá contener, al menos, uno o más caracteres alfanuméricos,
     * luego una arroba y luego uno o más caracteres alfanuméricos.
     * ¿Por qué no comprobar que tiene una arroba y un punto?
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
    
    /**
     * El teléfono serán 9 números
     * El dni serán 8 números
     * @param num El número a evaluar
     * @param expectedDigits Los digitos que esperamos que tenga
     * @return 
     */
    static boolean hasNDigits(int num, int expectedDigits){
        int digitos = (int)(Math.log10(num)+1);
        return digitos == expectedDigits ;
    }
    
    static char dniLetter(int dni){
        char[] dniLetters = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B',
        'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        
        return dniLetters[dni % 23];
    }
    
    @Override
    public int compareTo(Object t) {
        Person other = (Person) t;
        return (int) (this.getAge() - other.getAge());
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", surname=" + surname + ", idCard=" + idCard + ", domicilio=" + domicilio + ", eMail=" + eMail + ", birthDate=" + birthDate + ", telefono=" + telefono + ", gender=" + gender + '}';
    }
    
    
    
    // Getters y Setters
    
    public long getAge(){
        return birthDate.until(LocalDate.now(), ChronoUnit.DAYS) ;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (nameOK(name))
            this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if (nameOK(surname))
            this.surname = surname;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(int idCard) {
        if (hasNDigits(idCard,8))
            this.idCard = idCard + "" + dniLetter(idCard);
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        if (eMailOK(eMail))
            this.eMail = eMail;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        if (birthDateOk(birthDate))
            this.birthDate = birthDate;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        if (hasNDigits(telefono, 9))
            this.telefono = telefono;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (genderOk(gender))
            this.gender = Gender.valueOf(gender);
    }
    
    
    
}
