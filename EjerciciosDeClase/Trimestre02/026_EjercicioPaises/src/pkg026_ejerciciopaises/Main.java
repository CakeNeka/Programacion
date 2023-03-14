package pkg026_ejerciciopaises;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        /* Crear 3 Paises */
        System.out.println("\nCreando paises");
        Country france = new Country("France", 643801, 68042591);
        france.addCity("Lyon", 200000);
        france.addCity("Marseille", 200000);
        france.addCity("Paris", 34575);

        Country germany = new Country("Germany", 123451, 12312334);
        germany.addCity("Wacken", 7734);
        germany.addCity("Ulm", 23453);
        germany.addCity("Berlin", 93423);

        Country italy = new Country("Italy", 1231233, 73673633);
        italy.addCity("Roma", 200000);
        italy.addCity("Milan", 23423);
        italy.addCity("Como", 32423);

        /* Añadir fronteras */
        System.out.println("\nAñadiendo fronteras");
        try {
            france.addBorderCountry(italy);
            france.addBorderCountry(germany);
            italy.addBorderCountry(italy); //Throws exception
        } catch (InvalidCountryException ex) {
            System.out.println("El Pais es incorrecto");
        }

        /* Mostrar ciudades de francia con extensión de 200000 m2 */
        System.out.println("\nCiudades de Francia con extensión 200000");
        Set<String> frenchCities = france.getCitiesWithExtension(200000);
        for (String frenchCity : frenchCities) {
            System.out.println(frenchCity);
        }

        /* Mostrar si Bulgaria es frontera de francia */
        System.out.println("\nMostrar si Bulgaria es frontera de Francia");
        Country bulgaria = new Country("Bulgaria", 110994, 6878000);
        System.out.println(france.isFrontierOf(bulgaria));

        /* Ciudad con mayor extensión de todas */
        System.out.println("\nMostrar Ciudades con extensión máxima");
        Set<Country> countriesSet = new HashSet<>();
        countriesSet.add(italy);
        countriesSet.add(germany);
        countriesSet.add(france);
        countriesSet.add(bulgaria);

        Set<String> largestCities = findLargestCity(countriesSet);
        System.out.println("Las ciudades más grandes son:");
        for (String largestCity : largestCities) {
            System.out.print(largestCity + ", ");
        }
        System.out.println();

        /* Las ciudades de un pais por orden alfabético */
        System.out.println("\nMostrar Ciudades de un pais por orden alfabético");
        printCitiesByName(germany);
        System.out.println();

        /* Las ciudades de un pais por extensión */
        System.out.println("\nMostrar Ciudades de un pais por orden de extensión");
        printCitiesByArea(germany);

        /* Crear fichero de texto */
        System.out.println("\nEscribiendo archivo de texto");
        List<Country> countriesList = new ArrayList<>(countriesSet);
        exportCountriesToCsv("paises.csv", countriesList);

        /* Crear fichero binario */
        System.out.println("\nEscribiendo archivo binario");
        serializeCountries("paises.bin", countriesList);

        /* Leer fichero de texto */
        System.out.println("\nAccediendo a archivo de texto");
        List<String> csvCountries = loadCsvCountries("paises.csv");
        for (String csvCountry : csvCountries) {
            System.out.println(csvCountry);
        }

        /* Leer fichero binario */
        System.out.println("\nAccediendo a archivo binario");
        List<Country> loadedCountries = loadBinaryCountries("paises.bin");
        for (Country loadedCountry : loadedCountries) {
            System.out.println(loadedCountry);
        }

    }

    public static Set<String> findLargestCity(Set<Country> countries) {
        Set<String> largestCities = new HashSet<>();
        int currentMax = 0;
        for (Country country : countries) {
            for (Map.Entry<String, Integer> entry : country.getCitiesArea().entrySet()) {

                if (entry.getValue() > currentMax) {
                    currentMax = entry.getValue();
                    largestCities.clear();
                }

                if (entry.getValue() == currentMax) {
                    largestCities.add(entry.getKey() + "(" + country + ")");
                }
            }
        }
        return largestCities;
    }

    public static void printCitiesByName(Country country) {
        String[] cities = new String[country.getCitiesArea().size()];
        cities = country.getCitiesArea().keySet().toArray(cities);
        Arrays.sort(cities);
        System.out.println("Ciudades de " + country + " por orden alfabético: ");
        for (String city : cities) {
            System.out.print(city + ", ");
        }
    }

    public static void printCitiesByArea(Country country) {
        System.out.println("Ciudades de " + country + " por extensión: ");
        country.getCitiesArea().entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(System.out::println);
    }

    public static void exportCountriesToCsv(String path, List<Country> countries) {

        StringBuilder csvBuilder = new StringBuilder();
        String csvHeader = "name,extension,inhabitants,numberOfCities";
        csvBuilder.append(csvHeader);
        for (Country country : countries) {
            csvBuilder.append('\n');
            csvBuilder.append(country.toCsv());
        }

        File saveFile = new File(path);
        try {
            if (saveFile.createNewFile()) {
                System.out.println("El archivo ha sido creado");
            } else {
                System.out.println("El archivo ya existe, se sobreescribiran los datos");
            }

            FileWriter fileWriter = new FileWriter(saveFile, false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.append(csvBuilder.toString());
            bufferedWriter.close();
        } catch (IOException ex) {
            System.out.println("La operación ha fallado");
        }
    }

    private static void serializeCountries(String path, List<Country> countries) {
        FileOutputStream outputFile;
        try {
            outputFile = new FileOutputStream(path);
            ObjectOutputStream outputStream = new ObjectOutputStream(outputFile);
            for (Country country : countries) {
                outputStream.writeObject(country);
            }
            outputStream.close();
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no ha sido encontrado");
        } catch (IOException ex) {
            System.out.println("La operación ha fallado");
        }
    }

    private static List<String> loadCsvCountries(String path) {
        List<String> csvCountries = new ArrayList<>();

        File archivo = new File(path);
        FileReader fileReader;
        try {
            fileReader = new FileReader(archivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String linea = bufferedReader.readLine();

            while (linea != null) {
                csvCountries.add(linea);
                linea = bufferedReader.readLine();
            }

        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no ha sido encontrado");
        } catch (IOException ex) {
            System.out.println("La operación de lectura ha fallado");
        }

        return csvCountries;
    }

    private static List<Country> loadBinaryCountries(String path) {
        List<Country> loadedCountries = new ArrayList<>();
        try {
            FileInputStream archivo = new FileInputStream(path);
            ObjectInputStream inputStream = new ObjectInputStream(archivo);

            boolean endOfFile = false;
            while (!endOfFile) {
                try {
                    loadedCountries.add((Country) inputStream.readObject());
                } catch (EOFException e) { // END OF FILE exception
                    endOfFile = true;
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return loadedCountries;
    }
}
