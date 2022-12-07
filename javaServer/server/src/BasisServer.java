//Leon Kohlhaußen
// 2022-12-06
// 1.0
//the basic server configuration

import java.net.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BasisServer implements Runnable { // die Eigenschaften und das Verhalten der Klasse BasisServer (die
                                               // Eigenschaften und das Verhalten der Klasse BasisServer werden
                                               // durch die Schnittstelle Runnable definiert)

    // die Eigenschaften

    private ServerSocket serverSocket;
    protected BufferedReader vomClient; // die Ohren zum Hören
    private PrintWriter zumClient; // der zum Schreiben auf dem Server
    private int port; // der Port für die Kommunikation

    // Konstruktor

    BasisServer(int port) { // der Konstruktor
        this.port = port;
        try {
            this.serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            System.out.println("Fehler beim Erzeugen des ServerSockets auf Port " + port);
        }
        System.out.println("Server läuft auf Port " + port);

    }

    // Methoden
    public void run() { // die Methode run() wird durch die Schnittstelle Runnable definiert
        permanenteVerbindungMitClient();
    }

    void verbindungMitClient() { // die Verbindung zum Client
        try {
            // warte auf Client-Anfragen... und warte... und warte...
            System.out.println("Server wartet am Port " + port + " auf Client-Anfragen");
            Socket serverSocket = this.serverSocket.accept();
            System.out.println("Server hat Client-Anfrage erhalten" + serverSocket.getInetAddress());
            // vomClient = ... -> die Ohren
            vomClient = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));

            // zumClient = ... -> der Bleistift
            zumClient = new PrintWriter(serverSocket.getOutputStream());
            zumClient.println(">> ");
            zumClient.flush();
            // schreibe Info zum Client und schicke mit flush los
            schreibeAntwort(zumClient);
            // LocalDateTime now = LocalDateTime.now();
            // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy
            // HH:mm:ss");
            // String formatted = now.format(formatter);
            // zumClient.println("Hallo, ich bin der BasisServer und es ist " + formatted);
            // zumClient.flush();

            // Verbindung schließen
            serverSocket.close();
        } catch (IOException e) {
            System.out.println("Fehler beim Erzeugen des ServerSockets auf Port " + port);
        }
    }

    void permanenteVerbindungMitClient() { // endlose Verbindung
        while (true) {
            verbindungMitClient();
        }
    }

    /**
     * Wird durch die einzelnen Server überschrieben - der "eigentliche" Job. <br/>
     * Beachte: als abstrakte M. hier nicht möglich, da in verbindungMitClient()
     * benutzt.
     * 
     * @param zumClient Der Bleistift des BasisServers ist gekapselt (private)
     */
    public void schreibeAntwort(PrintWriter zumClient) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        String formatted = now.format(formatter);
        zumClient.println("Hallo, ich bin der BasisServer und es ist " + formatted);
        zumClient.flush();
    };

    /**
     * Unterschiedliches Verhalten beim Schreiben, aber gleiches
     * Verhalten beim Hören -> deshalb beim basisServer implementiert
     * 
     * @return Die vom Client gesendete Zeile als String
     */
    public String hoereFrage() {
        try { // zeilenweises Schreiben/Lesen, wie es zB von telnet praktiziert
            return vomClient.readLine();
        } catch (Exception ex) {
            System.out.println(" >> Fehler beim Lesen der Zeile vom Client");
            return ""; // Rückgabewert bei verstopften Ohren
        }
    }

    /**
     * Die vom Client gesendete Zeile wird an den Leerzeichen gesplittet (getrennt)
     * 
     * @return Die vom Client gesendete Zeile als Array mit Strings
     */
    public String[] hoereFrageArray() { // z.B. 'zeige test.txt' oder 'nutze notenDB':
        return hoereFrage().split(" ");
    }
}
