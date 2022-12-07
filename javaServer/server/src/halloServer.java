//Leon Kohlhaußen
// 2022-12-06
// 1.0
//the basic server configuration for the halloServer

//imports
import java.io.*;

public class halloServer extends BasisServer {
    // Spezielle Eigenschaften
    // Spezielles Verhalten
    @Override
    public void schreibeAntwort(PrintWriter stift) {
        // print a hallo message with a hallo from getHallo
        stift.println();
        stift.println(getHallo() + " Das war: " + getLanguage() + " !");
        stift.println();
        stift.flush();

    }

    // Konstruktor
    public halloServer(int port) {
        super(port);
    }

    String[][] helloArray = {
            { "English", "Welcome!" },
            { "Afrikaans", "hallo" },
            { "Albanian", "Përshëndetje" },
            { "Amharic", "ሰላም" },
            { "Arabic", "مرحبا" },
            { "Armenian", "Բարեւ" },
            { "Azerbaijani", "Salam" },
            { "Basque", "Kaixo" },
            { "Belarusian", "добры дзень" },
            { "Bengali", "হ্যালো" },
            { "Bosnian", "zdravo" },
            { "Bulgarian", "Здравейте" },
            { "Catalan", "Hola" },
            { "Cebuano", "Hello" },
            { "Chichewa", "Moni" },
            { "Chinese (Simplified)", "您好" },
            { "Chinese (Traditional)", "您好" },
            { "Corsican", "Bonghjornu" },
            { "Croatian", "zdravo" },
            { "Czech", "Ahoj" },
            { "Danish", "Hej" },
            { "Dutch", "Hallo" },
            { "English", "Hello" },

    };

    public String getHallo() {
        // get a random hello message from the helloArray
        int random = (int) (Math.random() * helloArray.length);
        return helloArray[random][1];
    }

    public String getLanguage() {
        // get the language of the random hello message from the helloArray
        int random = (int) (Math.random() * helloArray.length);
        return helloArray[random][0];
    }
}
