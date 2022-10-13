
//Objektbeziehungen

//generalisierung
//Aggregations/Komposition
//Association

public class Frau extends Mensch {
    // Spezielle Eigenschaften
    // Spezielle Methoden
    // Spezielle Konstruktoren

    Frau(String nachname, String vorname) {
        super(nachname, vorname);
        istWeiblich = true;
    }

    Frau(String nachname, String vorname, int age) {
        super(nachname, vorname, age);
        istWeiblich = true;

    }

}