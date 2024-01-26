package fi.utu.tech.ooj.exercise1;
/** Jokainen instanssi, ei ole yksityinen, eli laskuri ei nollaannu välissä.
 * Korjaus: muutetaan laskuri muutujat yksityisiksi
*/
class Numeroija {
    static int laskuri = 1;

    void numeroi(String[] rivit) {
        int uusiLaskuri = laskuri;
        for (var rivi : rivit) {
            System.out.println(uusiLaskuri++ + " " + rivi);
        }
        laskuri = uusiLaskuri;
    }
}
public class Tehtava4 {
    /**
     * Palauttaa taulukon, jonka kukin alkio sisältää ko. alkion ja kaikkien
     * sitä syötetaulukossa edeltävien alkioiden summan.
     *
     * Toisin sanoen tulostaulukon arvot ovat
     * [arr[0], arr[0] + arr[1], arr[0] + arr[1] + arr[2], ...]
     *
     * Ongelmaksi muodostuu, että funktio muokkaa parametrinä saatua taulukkoa eikä luo kopiata taulukosta.
     * Johon edelä olevien alkioiden summat tallennettaisiin. Voisi myös ottaa ulkoisen laskurin, johon alkioiden summa tallennetaan
     * ja laskemisen jälkeen arvo lisätään taulukkoon.
     * Esimerkkiratkaisu: Luodaan välimuisti, johon alkioiden summa tallennetaan ja se vaihdetaan laskun jälkeen listan alkioksi.
     */
    public static int[] cumulativeSums(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i-1] + arr[i];
        }
        return arr;
    }
}
