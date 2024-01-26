package fi.utu.tech.ooj.exercise1;

public class Tehtava3 {
    class Student {

    }

    /**
     * @.pre s != null && s.length() > 0 && times >= 0
     *
     * Alkuehto rutiinille tarkistaa, että merkkijonotyyppinen parametri s ei saa olla tyhjä ja sen pituus on oltava suurempi 0 merkkiä ja times on oltava 0 tai suurempi
     *
     * @.post EI MÄÄRITETTY
     */
    String repeatString(String s, int times) {
        return s.repeat(times);
    }

    /**
     * @.pre allStudents != null && FORALL(s : allStudents; s != null)
     *
     * Alkuehto rutiinille tarkistaa, että parametrinä annettava taulukko allStudent ei saa olla tyhjä
     * eikä myöskään taulukon yksittäinen alkio saa olla tyhjä
     *
     * @.post EI MÄÄRITETTY
     */
    public Student[] getActiveStudents(Student[] allStudents) {
        return null; // ei toteutettu
    }

    /**
     * @.pre EI MÄÄRITETTY
     * @.post s.length() <= RESULT.length() &&
     *        RESULT.length() <= 2*s.length() &&
     *        RESULT.substring(0, s.length()).equals(s) &&
     *        new StringBuilder(RESULT).reverse().toString().equals(RESULT)
     *
     * Loppuehto rutiinille tarkistaa, että s on pituudeltaan pienempi tai yhtäsuuri, kuin lopputulos.
     * Ja, että lopputulos pienempi tai yhtäsuuri, kuin kaksi kertaa s:n pituus.
     * Ja, että lopputuloksen alimerkkijonon, jonka indeksinumero on sama, kuin alkuperäisen pituus on oltava alusta katsottuna sama, kuin s
     * Palautettava merkkijono on oltava sama, kuin syötteenä annettu merkkijono käännettynä toisinpäin
     * lopuksi luodaan stringbuilder olio, joka tarkastaa, että palautettava merkkijono on peilikuva alkuperäisestä
     */
    String generatePalindrome(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    /**
     * @.pre students != null &&
     *       studentNumber != null &&
     *       studentNumber.length() > 0 &&
     *       FORALL(i : 0 <= i < studentNumber.length(); Character.isDigit(studentNumber.charAt(i)))
     *
     * Alkuehto rutiinille tarkistaa ettei students, studentNumber ole null ja, että studentNumberin pituus on suurmepi, kuin nolla.
     * Ja tarkistaa, että jokainen alkio studentNumberissa on luku.
     *
     * @.post EI MÄÄRITETTY
     */
    Student findStudent(Student[] students, String studentNumber) {
        return null; // ei toteutettu
    }

    /**
     * @.pre (EXISTS(s : students;
     *          s.getStudentNumber ().equals(studentNumber)) ==> (RESULT != null)) &&
 *           (RESULT.getStudentNumber().equals(studentNumber) &&
     *          (!EXISTS(s : students; s.getStudentNumber().equals(studentNumber))) ==> (RESULT == null))
     *
     * Alkuehto rutiinille käy kaikki opiskelija läpi ja saa niiden opiskelijanumeron ja vertaa, että saatu opsikelijanumero vastaa oikeaa opiskelijanumeroa.
     * Ja tulos ei saa olla null.
     */
    Student findStudent2(Student[] students, String studentNumber) {
        return null; // ei toteutettu
    }
}
