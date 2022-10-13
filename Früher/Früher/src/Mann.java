//Objektbeziehungen:

//generalisierung
//Aggregations/Komposition
//Association

public class Mann extends Mensch {
    // Spezielle Eigenschaften
    // Spezielle Methoden
    // Spezielle Konstruktoren

    Mann(String nachname, String vorname) {
        super(nachname, vorname);
        istWeiblich = false;
    }

    Mann(String nachname, String vorname, int age) {
        super(nachname, vorname, age);
        istWeiblich = false;

    }
}