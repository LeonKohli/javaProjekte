import java.io.*;

//Leon Kohlhaußen
// 2022-12-06
// 1.0
//the basic server configuration for the dialogTestServer

public class dialogTestServer extends BasisServer {
    // Spezielle Eigenschaften
    // Spezielles Verhalten

    @Override
    public void schreibeAntwort(PrintWriter stift) {
        boolean isRunning = true;
        while (isRunning) {
            String[] leseZeile = hoereFrageArray();
            System.out.print("Befehl: " + leseZeile[0]);
            if (leseZeile[0].equals("exit")) {
                isRunning = false;
            }
        }

    }

    // Konstruktor
    public dialogTestServer(int port) {
        super(port);
        System.out.println("dialogTestServer läuft auf Port " + port);
    }
}
