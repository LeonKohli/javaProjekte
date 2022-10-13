import java.util.ArrayList;

//Leon Kohlhaussen und Janneck Lehmann 19-10-2022

public class Flugplatz{
    // eigenschaften
    String kürzel;
    String name;
    int maxFlugzeuge;
    ArrayList<Flugzeug> aktuelleFlugzeuge = new ArrayList();
     
 
    //methoden

    void evakuierung() {
        System.out.println("ALAAAAAAAAAAAARM");
        //alle Flugzeuge müssen starten
        
    }


    
    boolean istPlatzFrei(){
        if (aktuelleFlugzeuge.size() < maxFlugzeuge){
            return true;
        }
        else{
        return false;
        }
    }
    

    //konstruktoren
    Flugplatz (String kürzel, String name, int maxFlugzeuge){
        this.kürzel = kürzel;
        this.name = name;
        this.maxFlugzeuge = maxFlugzeuge;
    }






}
