package main;

import java.util.Random;

public final class NameGenerator {

    static Random random = new Random();
    static String[] pref = {"Ale", "Mar", "Vic", "Leo", "Dar", "Ja", "Je","Ju", "Ra", "Fa", "Lu", "Cla"};
    static String[] mid = {"ri", "jan", "i", "ti", "", "thar", "nar", "ta", "vi", "roe", "in", "udi", "li"};
    static String[] suf = {"dra", "dro", "na", "no", "tor", "", "do", "da", "er", "bow", "o", "ca", "sen", "a"};
    
    static String[] surnames = {"Dash", "Martínez", "Bolívar", "Ortega", "Buñuelos",
    "Camino", "Cornwall", "Turilli", "Lione", "Matos",};

    public static String createName() {

        String name = "";

        name += pref[random.nextInt(pref.length)];
        name += mid[random.nextInt(mid.length)];
        name += suf[random.nextInt(suf.length)];

        return name;
    }

    public static String createSurname() {
        return surnames[random.nextInt(surnames.length)];
    }

}
