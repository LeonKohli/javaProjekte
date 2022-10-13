//Leon Kohlhaussen und Janneck Lehmann 19-10-2022



public class Flugzeug {
    //eigenschaften
    String modell;
    Flugplatz aktuellerFlugplatz = null; //Aktueller FLugplatz wenn "Null" in der luft

    //methoden
    void startet() {

    }
        
    void landet(Flugplatz ziel){
        
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




















