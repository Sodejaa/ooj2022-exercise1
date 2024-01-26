package fi.utu.tech.ooj.exercise1;

public class Tehtava5 {
    /**
     * @.pre EI MÄÄRITETTY
     * @.post OSA-A && OSA-B && OSA-C && OSA-D (osat listattu tehtävänannossa)
     *
     * Rutiini luo annetun taulukon pohjalta uuden, josta on poistettu duplikaatit
     *
     * A. FORALL(i : 0 <= i < RESULT.length; !EXISTS(j : 0 <= j < RESULT.length; RESULT[i] == RESULT[j]))
     * B. FORALL(i : 0 <= i < RESULT.length; !EXISTS(j : 0 <= j < RESULT.length; i != j && RESULT[i] == RESULT[j]))
     * C. FORALL(x : arr; EXISTS(y : RESULT; x == y))
     * D. FORALL(x : RESULT; EXISTS(y : arr; x == y))
     *
     * Vastaus:
     *
     *   I  J  K  L  M
     * A X
     * B X     X  X
     * C       X  X  X
     * D    X  X     X
     *
     */
    public int[] withoutDuplicates(int[] arr) {
        return null; // ei toteutettu
    }
}
