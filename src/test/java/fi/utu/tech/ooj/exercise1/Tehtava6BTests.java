package fi.utu.tech.ooj.exercise1;

import net.jqwik.api.*;
import net.jqwik.api.constraints.NotBlank;

public class Tehtava6BTests {
    // provide non-blank strings
    @Provide
    Arbitrary<String> nonBlankStrings() {
        return Arbitraries.strings().filter(s -> !s.isBlank());
    }

    // custom jqwik annotation for generating non-blank non-null input
    // based on values filtered by 'nonBlankStrings'
    @Property
    boolean nonBlankStringIsNotBlank(@ForAll("nonBlankStrings") String s) {
        return !s.isBlank();
    }

    // built-in jqwik annotation for generating non-blank non-null input
    @Property
    boolean nonBlankStringIsNotBlank2(@ForAll @NotBlank String s) {
        return !s.isBlank();
    }

    // TODO: Tehtävä 6b: Kirjoita tähän pyydetyt ominaisuustestit
    @Property
    boolean capitalizeWords(@ForAll("nonBlankStrings") String s) {
        if (s != null && s.isBlank() == false) {
            if (Tehtava6.capitalize(s).isBlank() == false) {
                return true;
            }
        }
        return false;
    }

    // TODO: Tehtävä 6b: Vaihtoehtoisesti, kirjoita tähän 5 kpl ominaisuutta testaavaa yksikkötestiä
}
