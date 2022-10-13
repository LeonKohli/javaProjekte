public class Tester2 {
    //create a tester class for flugzeug and flugplatz
    public static void main(String[] args) {
        Flugplatz paris = new Flugplatz("FRA", "Paris-Charles de Gaulle", 2);
        Flugplatz zürich = new Flugplatz("ZRH", "Zürich-Kloten", 3);
        Flugplatz berlin = new Flugplatz("SXF", "Berlin-Schönefeld", 4);
        
 
        Flugzeug flug1 = new Flugzeug("Tu144"); // flugzeug in der luft
        Flugzeug flug2 = new Flugzeug("B747", paris); // ok
        Flugzeug flug3 = new Flugzeug("A380", paris); // ok
        Flugzeug flug4 = new Flugzeug("IL114", paris); // nö -> paris voll; Flugzeug bleibt in der Luft
 
        flug4.startet(); // nö -> flugzeug in der luft
        flug3.startet(); // ok
        flug3.landet(berlin); // ok
        flug4.landet(paris); // nun kein problem mehr
        flug2.landet(berlin); // nö -> flugzeug ist nicht in der luft
 
        paris.evakuierung(); // alle Flugzeuge aus Berlin müssen starten
        berlin.evakuierung(); // alle Flugzeuge aus Berlin müssen starten
    }
}
