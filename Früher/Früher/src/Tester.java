//Objektbeziehungen
//generalisierung
//Aggregation/Komposition
//Assoziation
//LeonK 13.10.22

public class Tester {
    public static void main(String[] args) {

        Frau susi = new Frau("Sorglos", "Susi", 32);
        Frau pippi = new Frau("Langer Strumpf", "Pippi", 12);
        Mann benjamin = new Mann("Blümchen", "Benjamin"); // ohne altersangabe
        Mann peter = new Mann("Pan", "Peter"); // automatisch 18

        benjamin.heiratet(peter); // nö -> früher nicht möglich
        benjamin.heiratet(pippi); // nö -> pippi ist zu jung
        benjamin.heiratet(susi); // kein Problem
        susi.heiratet(peter); // nö -> susi ist schon wech

        susi.scheidung(); // kein problem
        benjamin.scheidung(); // nö -> ist ja schon geschieden
        susi.heiratet(peter); // nun kein problem mehr
    }
}
