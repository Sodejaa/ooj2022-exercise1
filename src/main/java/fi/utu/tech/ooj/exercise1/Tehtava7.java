package fi.utu.tech.ooj.exercise1;

import java.util.*;

public class Tehtava7 {
    /**
     * NumberFormatException: "pituus=paljon leveys=vähän massa=eiole"
     * NoSuchElementException: "eiTässäOleMitäänPareja"
     * NullPointerException: parametri: null
     */

    // TODO: Toteuta tehtävän 7b poikkeuskäsittely tähän metodiin
    public static Map<String, Integer> processKeyValuePairsFromStringTaskB(String input) {
        Scanner scanner = new Scanner(input).useDelimiter("\\s+|=");
        Map<String, Integer> output = new HashMap<>();

        while (scanner.hasNext()) {
            try {
                String key = scanner.next();
                String tempValue = scanner.next();
                Integer value = Integer.valueOf(tempValue);
                output.put(key, value);
            } catch (NoSuchElementException e) {
                return Map.of();
            } catch (NumberFormatException e) {
                continue;
            }
        }

        scanner.close();
        return output;
    }

    // TODO: Toteuta tehtävän 7c poikkeuskäsittely tämän metodin yhteyteen
    public static Map<String, Integer> processKeyValuePairsFromStringTaskC(String input)
            throws IllegalArgumentException, NumberFormatException {
        if (input.contains("=") == false || input.contains(" ") == false) {
            throw new IllegalArgumentException("Syötteessä ei ole avain-arvo-pareja");
        }
        Scanner scanner = new Scanner(input).useDelimiter("\\s+|=");
        Map<String, Integer> output = new HashMap<>();

        while (scanner.hasNext()) {
            String key = scanner.next();
            String tempValue = scanner.next();
            if (scanner.hasNextInt() == false) {
                throw new NumberFormatException("avain-arvo-pareissa on muita, kuin kokonaislukuja");
            }
            Integer value = Integer.valueOf(tempValue);
            output.put(key, value);
        }

        scanner.close();
        return output;
    }
}

