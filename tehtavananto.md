# Tehtävänanto - Harjoitus 1

Pisteytys: 6 + 8 + 10 + 8 + 10 + 8 + 10 = 60

## Tehtävä 1

Kirjoita sanallinen kuvaus ja alku- ja loppuehto rutiinille `area`.

Rutiinin signatuuri ja toteutus eivät suoraan kerro rutiinin
käyttötarkoitusta, joka pitää siis päätellä ja rakentaa hieman
takaperoisesti jo annetusta toteutuksesta.

```java
public static double area(double w, double h) {
  return w * h;
}
```

### Pisteytys

* Sanallinen kuvaus 2 p., alkuehto 2 p. ja loppuehto 2 p.
* Yhteensä: 6 pistettä

---

## Tehtävä 2

Kirjoita sanallinen kuvaus sekä alku- ja loppuehto tälle rutiinille. Tehtävässä voit ajatella,
että parametrit `t1Start` ja `t1End` esittävät jonkin ajanjakson alku- ja loppuhetkeä. Vastaavasti
`t2Start` ja `t2End` edustavat jonkin toisen ajanjakson päätepisteitä.

```java
public static boolean areOverlapping(int t1Start, int t1End, int t2Start, int t2End) {
  if (t1Start <= t2Start && t2Start <= t1End) return true;
  if (t1Start <= t2End && t2End <= t1End) return true;
  if (t2Start <= t1Start && t1Start <= t2End) return true;
  if (t2Start <= t1End && t1End <= t2End) return true;
  return false;
}
```

### Pisteytys

* Sanallinen kuvaus 2 p., alkuehto 3 p. ja loppuehto 3 p.
* Yhteensä: 8 pistettä

---

## Tehtävä 3

Tulkitse suomen (tai englannin) kielelle, mitä seuraavat rutiinin toimintaa kuvaavat
totuuslausekkeet ilmaisevat:

***A.*** Alkuehto rutiinille, jonka signatuuri on `String repeatString(String s, int times)`:\
\
`s != null && s.length() > 0 && times >= 0`

***B.*** Alkuehto rutiinille, jonka signatuuri on `public Student[] getActiveStudents(Student[]
allStudents)`:\
\
`allStudents != null && FORALL(s : allStudents; s != null)`

***C.*** Loppuehto rutiinille, jonka signatuuri on `String generatePalindrome(String s)`:\
\
`s.length() <= RESULT.length() && RESULT.length() <= 2*s.length() &&`\
`RESULT.substring(0, s.length()).equals(s) &&`\
`new StringBuilder(RESULT).reverse().toString().equals(RESULT)`
- Tässä [new StringBuilder(RESULT).reverse().toString()](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/StringBuilder.html)
  kääntää merkkijonon peilikuvakseen (eli tuloksena on alkuperäinen merkkijono
  lopusta alkuun luettuna) ja merkkijono-operaatio `s.substring(0, i)` palauttaa
 `i` ensimmäistä merkkiä merkkijonosta `s`.

***D.*** Alkuehto rutiinille, jonka signatuuri on `Student findStudent(Student[] students, String
studentNumber)`:\
\
`students != null && studentNumber != null && studentNumber.length() > 0 &&`\
`FORALL(i : 0 <= i < studentNumber.length(); Character.isDigit(studentNumber.charAt(i)))`.
- Tässä [Character.isDigit](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Character.html)
  on Javan standardikirjastosta löytyvä metodi, joka palauttaa `true`, mikäli
  parametrina saatu merkki on numero.

***E.*** Loppuehto rutiinille, jonka signatuuri on `Student findStudent2(Student[] students, String
studentNumber)`:\
\
`(EXISTS(s : students; s.getStudentNumber().equals(studentNumber)) ==> ((RESULT != null) &&`\
`RESULT.getStudentNumber().equals(studentNumber))) && (!EXISTS(s :
students; s.getStudentNumber().equals(studentNumber)) ==> (RESULT == null))`

**Huomaa, että jotkin kuvaukset voivat olla puutteellisia.** Tästä huolimatta
tehtävänä on vain tulkita annettu ehtolauseke eikä arvioida sitä, mitä
rutiinin ehkä kuuluisi tehdä. Tehtävästä on samasta syystä jätetty pois myös
varsinainen toteutus.

### Pisteytys

* 2 pistettä per kohta
* Yhteensä: 10 pistettä
 
---

## Tehtävä 4

Odottamattomat sivuvaikutukset voivat toisinaan johtaa siihen, että
ohjelmakoodi ei toimi suunnitellulla tavalla. Arvioi seuraavista esimerkeistä,
minkälaisia sivuvaikutuksia esimerkkien mukaisissa tilanteissa voi esiintyä ja
mitä haittaa niistä voi olla. Esitä myös jokin tapa korjata funktiot.

***A.*** Ns. kumulatiivisten summien laskemiseen on kehitetty seuraavanlainen funktio:

```java
/**
 * Palauttaa taulukon, jonka kukin alkio sisältää ko. alkion ja kaikkien
 * sitä syötetaulukossa edeltävien alkioiden summan.
 * 
 * Toisin sanoen tulostaulukon arvot ovat
 * [arr[0], arr[0] + arr[1], arr[0] + arr[1] + arr[2], ...]
 */
public static int[] cumulativeSums(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
        arr[i] = arr[i-1] + arr[i];
    }
    return arr;
}
```

Tehdään kutsu `int[] result = cumulativeSums(numbers);`, missä `numbers`
on ennestään olemassa oleva taulukko

***B.*** `Numeroija`-luokan rutiini `numeroi` saa syötteenään
merkkijonotaulukon. Taulukko tulostetaan niin, että sen jokainen
alkio tulostuu omalle rivilleen rivin alkuun tulostettavan
rivinumeron kera. Luokkaa ja sen metodia käytetään alla olevassa 
esimerkissä. Tarkoituksena on, että jokainen instanssi `Numeroija`:sta
sisältäisi itsenäisen kirjanpidoln rivinumeroinnista ja jokainen
`numeroi`-kutsu jatkaisi edellisestä numeroinnista.

Toimiiko `Numeroija`-luokka ja sen rutiini määrittelynsä mukaisesti?
Jos rutiini ei toimi oikein, mikä siihen on syynä? Entä miten se 
pitää korjata?

```java
public static void main(String[] args) {
    Numeroija num1 = new Numeroija();
    Numeroija num2 = new Numeroija();
    num1.numeroi(new String[] {"moi", "hei", "päivää"});
    num2.numeroi(new String[] {"kyllä", "ei","ehkä"});
}

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

```

### Pisteytys

* 3 pistettä per kohta
* Yhteensä: 6 pistettä

---

## Tehtävä 5

Tarkastellaan rutiinia `public int[] withoutDuplicates(int[] arr)`. Rutiinin
tarkoitus on muodostaa annetun taulukon pohjalta uusi taulukko, joka sisältää
kaikki alkuperäisen taulukan sisältämät arvot ilman duplikaatteja. Esimerkiksi
taulukko `[ 1, 1, 1, 2, 2, 3]` tuottaisi paluuarvona taulukon `[ 1, 2, 3 ]` .

Rutiinin määrittelemiseksi on ehdotettu seuraavia loppuehdon osia
`(@.pre OSA-A && OSA-B && OSA-C && OSA-D)`, joista tosin ensimmäinen vaikuttaa
olevan ristiriidassa sanallisen määrittelyn kanssa.

***A.*** `FORALL(i : 0 <= i < RESULT.length; !EXISTS(j : 0 <= j < RESULT.length; RESULT[i] == RESULT[j]))`

***B.*** `FORALL(i : 0 <= i < RESULT.length; !EXISTS(j : 0 <= j < RESULT.length; i != j &&
RESULT[i] == RESULT[j]))`

***C.*** `FORALL(x : arr; EXISTS(y : RESULT; x == y))`

***D.*** `FORALL(x : RESULT; EXISTS(y : arr; x == y))`

Jos syötteenä (`arr`) on taulukko `[1, 3, 1]`, mitkä seuraavista
palautettavista taulukoista toteuttavat kunkin loppuehdon osan? 

***I.*** [] (tyhjä taulukko)

***J.*** [1]

***K.*** [1, 3]

***L.*** [1, 3, 5]

***M.*** [1, 3, 1]

Vastauksen tehtävään voit esittää esimerkiksi seuraavanlaisena taulukkona,
johon merkitään X niihin kohtiin, joissa tulostaulukko täyttää loppuehdon.
Jos esimerkiksi tulostaulukko m täyttäisi loppuehdon a, merkittäisiin
X taulukon riville a sarakkeeseen m.

```
  I  J  K  L  M
A
B
C
D
```

### Pisteytys

* Kukin oikein merkitty ruutu ½ pistettä (summa pyöristetään kokonaisiin)
* Yhteensä: 10 pistettä

---

### Tehtävä 6

***A.*** Seuraava rutiini `sqr` laskee annetun kokonaislukutaulukon jokaisen
luvun neliön (luku kerrotaan itsellään) ja palauttaa alkuperäisen kokoisen
uuden taulukon, jossa kullekin alkuperäistä lukua vastaavalle
paikalle on sijoitettu tämä laskettu luvun neliö.

```java
/**
 * Laskee annetun kokonaislukutaulukon jokaisen luvun neliön
 * (luku kerrotaan itsellään) ja palauttaa alkuperäisen kokoisen
 * uuden taulukon, jossa kullekin alkuperäistä lukua vastaavalle
 * paikalle on sijoitettu tämä laskettu luvun neliö.
 *
 * Huom! Toimii vain pienillä luvuilla, koska neliöinti aiheuttaa
 * melko äkkiä kokonaislukuarvon ylivuodon.
 *
 * @.pre input != null && FORALL(x: input; x > -10000 && x < 10000)
 * @.post RESULT.length == input.length &&
 *        FORALL(x: RESULT; x >= 0) &&
 *        FORALL(0 <= i < RESULT.length; RESULT[i] == input[i] * input[i])
 */
static int[] sqr(int[] input) {
    int[] tmp = new int[input.length];
    for (int i = 0; i < input.length; i++)
        tmp[i] = input[i] * input[i];
    return tmp;
}
```

Tehtävä: laadi luokkaan `Tehtava6ATests` (sijaitsee Maven-käytäntöjen
mukaan testikansiossa `src/test/java/fi/utu/...`) ominaisuustesti,
joka todentaa ominaisuuden `epäNegatiivinen`, ts. jokainen rutiinin
tuottamalle taulukon alkiolle `x` pätee `x >= 0`. Tämä on ilmeistä,
sillä jokaisen negatiivisen kokonaisluvun tulo itsensä kanssa muuttaa
luvun etumerkin ja pos. kokonaislukujen tapauksessa etumerkki ei vaihdu.

Huomaa, että alkuehto rajoittaa generoitavien testitapausten joukkoa.
Testiluokan alussa olevat esimerkit antavat vinkkiä, miten testitapauksia
voi rajata tehtävän kontekstissa.

Ominaisuus on myös kuvattu em. määrittelyn loppuehdon toisella rivillä.

Huom! Voit myös tässä A-kohdan tehtävässä rakentaa ominaisuustestin
sijaan 5 kpl ominaisuutta testaavia yksikkötestitapauksia. Muista,
että esim. `assertEquals` ei vertaa oikein kahta taulukkoa vaikka toimisikin
yksittäisille alkioille.

Huom! Voit myös tässä A-kohdan tehtävässä rakentaa ominaisuustestin
sijaan 10 kpl ominaisutta testaavia `assert`-väittämiä. Muista, että
`assert`-ominaisuus aktivoituu vain kun java-virtuaalikoneen käynnistää
`-ea`-optiolla.

***B.*** Seuraava rutiini `capitalize` käy läpi annetun merkkijonon sana
kerrallaan ja suurentaa jokaisen sanan ensimmäisen kirjaimen isoksi
kirjaimeksi, jos muunnokselle on tarvetta. Rutiinia voidaan käyttää
esim. otsikoiden kirjainasun korjaamiseen.

```java
  /**
   * @.pre input != null && !input.isBlank()
   * @.post RESULT.equals(
   *          Arrays.stream(input.split(" ")).map(m -> m.isEmpty() ? "" : ("" + m.charAt(0)).toUpperCase() + m.substring(1)).collect(Collectors.joining(" "))
   *        )
   */
  static String capitalize(String input) {
      StringBuffer buffer = new StringBuffer();

      boolean upper = true;
      for (char c : input.toCharArray()) {
          if (upper)
              buffer.append(Character.toUpperCase(c));
          else
              buffer.append(c);
          upper = c == ' ';
      }
      return buffer.toString();
  }
```

Rutiinin toimintaa demonstroi esimerkiksi seuraava koodi:
```java
System.out.println(capitalize("terve maailma"));
Terve Maailma
```

Tehtävä: laadi luokkaan `Tehtava6BTests` (sijaitsee Maven-käytäntöjen
mukaan testikansiossa `src/test/java/fi/utu/...`) ominaisuustesti,
joka todentaa rutiinin noudattavan alku- ja loppuehtojaan. Mikäli
rutiini ei toimi määrittelynsä mukaisesti, anna esimerkki syötteestä,
millä toiminta on virheellinen.

Toiminta voidaan todentaa hyödyntämällä strategiaa *'toinen toteutus'*,
jossa verrataan varsinaisen toteutuksen ja sopimusehtojen mukaisen
odotetun tuloksen vastaavuutta eri syötteillä. 

Huomaa, että alkuehto rajoittaa generoitavien testitapausten joukkoa.
Testiluokan alussa olevat esimerkit antavat vinkkiä, miten testitapauksia
voi rajata tehtävän kontekstissa.

Huom! Voit myös tässä B-kohdan tehtävässä rakentaa ominaisuustestin
sijaan 5 kpl ominaisuutta testaavia yksikkötestitapauksia.

### Pisteytys

* 4 pistettä per kohta
* Yhteensä: 8 pistettä

---

### Tehtävä 7

Seuraava rutiini etsii syötteen merkkijonosta avain-arvo-pareja
[Scanner](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Scanner.html)-oliolla ja lisää ne
`Map`-muotoiseen (tässä [`HashMap`](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/HashMap.html)) tietorakenteeseen:

```java 
public static Map<String, Integer> processKeyValuePairsFromString(String input) {
    Scanner scanner = new Scanner(input).useDelimiter("\\s+|=");
    Map<String, Integer> output = new HashMap<>();

    while (scanner.hasNext()) {
       String key = scanner.next();
       String tempValue = scanner.next();
       Integer value = Integer.valueOf(tempValue);
       output.put(key, value);
    }
    
    scanner.close();
    return output;
}
```

Oikein muotoiltu syöte erottelee avaimen ja arvon toisistaan `'='`-merkillä ja
parit toisistaan välilyönnillä (`' '`). Oikeanlainen syöte sisältää myös vain
[kokonaislukumuotoisia](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Integer.html) arvoja. Esimerkki oikeanlaisesta syötteestä on
esimerkiksi `"pituus=100 leveys=40 massa=20"`.

Rutiini toimii oikein vain kun syöte on oikeanlainen. Muussa tapauksessa
päädytään virhetilanteeseen. Esimerkkejä virhetilanteista ovat tapaukset,
jossa jonkin parin arvo ei ole numero tai mikäli syöte ei sisällä
avain-arvo-pareja. Keksitkö muita ongelmatilanteita?

Testaa rutiinia seuraavilla merkkijonoilla:\
`"pituus=paljon leveys=vähän massa=eiole"`\
`"eiTässäOleMitäänPareja"`

***A.*** Luettele nimeltä, mitkä kaikki poikkeukset rutiini voi nostaa eri syötteillä
ja tilanteissa (selvitä kirjastorutiinien dokumentaatiosta tai kokeilemalla).

***B.*** Lisää rutiiniin poikkeuksien käsittely. Käsittele seuraavat poikkeukset erikseen:
- Jos avain-arvo-pareja ei löydy, palautetaan rutiinista tyhjä `Map` (esim. `Map.of()`)
- Jos jonkin avain-arvo-parin arvo ei ole kokonaisluku, ohitetaan kyseinen pari
  ja jatketaan normaalisti.

Toteuta tehtävän poikkeuskäsittely projektin lähdekoodihakemistossa toimitetun
luokan `Tehtava7` rutiiniin `processKeyValuePairsFromStringTaskB`.

***C.*** Lisää poikkeuksien käsittely. Poikkeuksia ei nyt halutakaan käsitellä
rutiinin sisällä vaan käsittelyn vastuu siirretään rutiinin kutsujalle.

- Jos avain-arvo-pareja ei löydy, nostetaan rutiinissa poikkeus [`IllegalArgumentException`](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/IllegalArgumentException.html)
- Jos jonkin avain-arvo-parin arvo ei ole kokonaisluku, nostetaan tilannetta kuvaava poikkeus 

Toteuta tehtävän poikkeuskäsittely projektin lähdekoodihakemistossa toimitetun
luokan `Tehtava7` rutiiniin `processKeyValuePairsFromStringTaskC` yhteyteen.

---

### Pisteytys

* A-kohta 2 pistettä, B- ja C-kohdat 4 pistettä
* Yhteensä: 10 pistettä

---
