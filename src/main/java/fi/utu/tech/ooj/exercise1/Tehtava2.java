package fi.utu.tech.ooj.exercise1;

public class Tehtava2 {
    /** Tehtävä 2
     *
     * Metodi arOverlapping testaa ovatko kaksi ajanjaksoa päällekkäisiä ja palauttaa sen perusteella true tai false
     * @.pre (t1Start <= t2Start && t2Start <= t1End) || (t1Start <= t2End && t2End <= t1End) || (t2Start <= t1Start && t1Start <= t2End) || (t2Start <= t1End && t1End <= t2End) == true
     * @.post RESULT == true || RESULT == false
     */
    public static boolean areOverlapping(int t1Start, int t1End, int t2Start, int t2End) {
        if (t1Start <= t2Start && t2Start <= t1End) return true;
        if (t1Start <= t2End && t2End <= t1End) return true;
        if (t2Start <= t1Start && t1Start <= t2End) return true;
        if (t2Start <= t1End && t1End <= t2End) return true;
        return false;
    }
}
