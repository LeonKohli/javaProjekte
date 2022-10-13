public class Mensch {

    // eigenschaften
    String nachname;
    String vorname;
    int alter;
    boolean istWeiblich;
    boolean istVerheiratet = false;
    Mensch ehepartner = null; // ich habe einen ehepartner ... Aggregration

    // methode

    void heiratet(Mensch kandidat) { // benutze Menschen zum Heiraten ... Assoziation
                                     // benutze zwei Objekte this und kandidat

        System.out.println("Heirat von " + this.vorname + " mit " + kandidat.vorname);
        if (this.istVerheiratet) {
            System.out.println(this.vorname + " ist schon verheiratet");

        } else if (kandidat.istVerheiratet) {
            System.out.println(kandidat.vorname + " ist schon verheiratet");

        } else if (this.istWeiblich == kandidat.istWeiblich) {
            System.out.println("Gleichgeschlechtliche Ehen sind nicht erlaubt");

        } else if (this.alter < 18 || kandidat.alter < 18) {
            System.out.println("Eheschliessung unter 18 Jahren ist nicht erlaubt");

        } else { // Die Heirat
            this.istVerheiratet = true;
            kandidat.istVerheiratet = true;
            this.ehepartner = kandidat;
            kandidat.ehepartner = this;
            // sehr gut gemacht :-)
            System.out.println("Jubel!!!!!");
        }

    }

    void scheidung() {
        // benutze zwei Objekte this und ehepartner
        System.out.println(this.ehepartner + "möchte die Scheidung");
        if (!this.istVerheiratet) {
            System.out.println("Dafür muss man verheiratet sein");
        } else { // jetzt wird geschieden
            this.istVerheiratet = false;
            this.ehepartner.istVerheiratet = false;
            this.ehepartner.ehepartner = null;
            this.ehepartner = null;
            System.out.println("Jubel!!!!!");
        }
    }

    // konstruktoren
    public Mensch(String nname, String vname, int age, boolean geschlecht) {
        vorname = nname;
        nachname = vname;
        this.alter = age; // this ist das Objekt, das gerade erstellt wird
        istWeiblich = geschlecht;
        // this.nachname = nName; // ohne this arbeiten
        // this.vorname = vName;
        // this.alter = age; // this ist das Objekt was gerade erzeugt wird
        // this.istWeiblich = geschlecht;
        //
    }

    public Mensch(String nName, String vName, int age) {
        // this(nName, vName, age, false);
        this.nachname = nName;
        this.vorname = vName;
        this.alter = age;

    }

    public Mensch(String nachname, String vorname) {
        this(nachname, vorname, 18);

    }
    // generate contructor

}