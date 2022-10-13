//Leon Kohlhaussen und Janneck Lehmann 19-10-2022



public class Flugzeug {
    //eigenschaften
    String modell;
    Flugplatz aktuellerFlugplatz = null; //Aktueller FLugplatz wenn "Null" in der luft

    //methoden
    void startet() {
        if (aktuellerFlugplatz != null) {
            aktuellerFlugplatz.aktuelleFlugzeuge.remove(this);
            aktuellerFlugplatz = null;
        }
        else {
            System.out.println("Flugzeug ist schon in der Luft");
        }

    }
        
    void landet(Flugplatz ziel){
        if (ziel.istPlatzFrei()){
            ziel.aktuelleFlugzeuge.add(this);
        }
        else {
            System.out.println("Flugplatz ist voll");
        }
        
    }
    //konstruktoren
    Flugzeug(String modell) {
        this.modell = modell;

    }



    Flugzeug(String modell, Flugplatz ziel) {
        this.modell = modell;
        landet(ziel);

    }
}




















