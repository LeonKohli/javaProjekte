import java.util.ArrayList;

//Leon Kohlhaussen und Janneck Lehmann 19-10-2022

public class Flugplatz{
    // eigenschaften
    String kürzel;
    String name;
    int maxFlugzeuge;
    ArrayList<Flugzeug> aktuelleFlugzeuge = new ArrayList<Flugzeug>();
     
 
    //methoden

    void evakuierung() {
        System.out.println("ALAAAAAAAAAAAARM");
        //alle Flugzeuge müssen starten
        for (Flugzeug flugzeug : aktuelleFlugzeuge) {
            flugzeug.startet();
        }
    }


    
    boolean istPlatzFrei(){
        if (aktuelleFlugzeuge.size() < maxFlugzeuge){
            return true;
        }
        else{
        return false;
        }
    }

    void zeigeFlugzeuge(){
        for (Flugzeug flugzeug : aktuelleFlugzeuge) {
            System.out.println("Flugzeug: " + flugzeug.modell);
        }
    }


    

    //konstruktoren
    Flugplatz (String kürzel, String name, int maxFlugzeuge){
        this.kürzel = kürzel;
        this.name = name;
        this.maxFlugzeuge = maxFlugzeuge;
    }






}
