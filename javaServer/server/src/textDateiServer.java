import java.io.*;
import java.nio.file.Files;

import org.w3c.dom.NamedNodeMap;

public class textDateiServer extends BasisServer {

    PrintWriter stift;
    String befehle = "folgende Befehle sind möglich: ";
    String[] befehleArray = { "exit", "help", "datei", "dateiInhalt", "dir", "cd", "mkdir", "rmdir", "del", "copy",
            "move" };

    // Spezielles Verhalten
    @Override
    public void schreibeAntwort(PrintWriter stift) {
        this.stift = stift;
        boolean isRunning = true;
        while (isRunning) {
            // befehle vom Client lesen
            System.out.println("Befehl vom Client: " + hoereFrage());

            // befehle vom Client auswerten
            switch (hoereFrage()) {
                case "exit":
                    isRunning = false;
                    break;
                case "help":
                    help();
                    break;
                case "datei":
                    datei();
                    break;
                case "dateiInhalt":
                    dateiInhalt();
                    break;
                case "dir":
                    dir();
                    break;
                case "cd":
                    cd();
                    break;
                case "mkdir":
                    mkdir();
                    break;
                case "rmdir":
                    rmdir();
                    break;
                case "copy":
                    copy();
                    break;
                case "move":
                    move();
                    break;
                default:
                    stift.println("Fehler: Befehl nicht gefunden");
                    stift.flush();
                    break;
            }

        }

    }

    // Konstruktor

    // befehle
    public void help() {
        stift.println(befehle);
        for (int i = 0; i < befehleArray.length; i++) {
            stift.println(befehleArray[i]);
        }
        stift.flush();
    }

    public void datei() {
        // find current directory
        File pfad = new File("."); // current directory
        stift.println("datei");
        stift.println("Bitte geben Sie den Dateinamen ein: ");
        stift.flush();
        String dateiName = hoereFrage();
        stift.println("Bitte geben Sie den Inhalt ein: ");
        stift.flush();
        String dateiInhalt = hoereFrage();
        try { // write file in a not specified directory
            FileWriter datei = new FileWriter(
                    pfad.getCanonicalPath() + "/" + dateiName + ".txt");
            datei.write(dateiInhalt);
            datei.close();
        } catch (Exception e) {
            System.out.println("Fehler: " + e);
        }
    }

    public void dateiInhalt() {
        stift.println("dateiInhalt");
        stift.println("Bitte geben Sie den Dateinamen ein: ");
        stift.flush();
        String dateiName = hoereFrage();
        try {
            FileReader datei = new FileReader(
                    "C:/home/GitHub/javaProjekte/javaServer/server/src/" + dateiName + ".txt");
            BufferedReader dateiBuffer = new BufferedReader(datei);
            String zeile = dateiBuffer.readLine();
            while (zeile != null) {
                stift.println(zeile);
                zeile = dateiBuffer.readLine();
            }
            datei.close();
        } catch (Exception e) {
            System.out.println("Fehler: " + e);
        }
        stift.flush();
    }

    public void dir() { // list all files in current directory
        stift.println("dir");
        File pfad = new File("."); // current directory
        String[] dateien = pfad.list();
        for (int i = 0; i < dateien.length; i++) {
            stift.println(dateien[i]);
        }
        stift.flush();
    }

    // verzeichnis wechseln
    public void cd() {
        stift.println("cd");
        stift.println("Bitte geben Sie den Pfad ein: ");
        stift.flush();
        String pfad = hoereFrage();
        try {
            File newDir = new File(pfad);
            if (newDir.isDirectory()) {
                System.setProperty("user.dir", pfad);
                stift.println("Verzeichnis gewechselt");
                stift.println(pfad);
            } else {
                stift.println("Fehler: Verzeichnis nicht gefunden");
                stift.println("Wollen Sie das Verzeichnis erstellen? (j/n)");
                stift.flush();
                String antwort = hoereFrage();
                if (antwort.equals("j")) {
                    newDir.mkdir();
                    stift.println("Verzeichnis erstellt");
                    stift.println(pfad);

                } else {
                    stift.println("Verzeichnis nicht erstellt");
                }
            }
        } catch (Exception e) {
            System.out.println("Fehler: " + e);

        }
        stift.flush();
    }

    public void mkdir() {
        stift.println("mkdir");
        stift.println("Bitte geben Sie den Pfad ein: ");
        stift.flush();
        String pfad = hoereFrage();
        try {
            File newDir = new File(pfad);
            if (newDir.isDirectory()) {
                stift.println("Fehler: Verzeichnis existiert bereits");
            } else {
                newDir.mkdir();
                stift.println("Verzeichnis erstellt");
                stift.println(pfad);
            }
        } catch (Exception e) {
            System.out.println("Fehler: " + e);

        }
        stift.flush();
    }

    public void rmdir() {
        stift.println("rmdir");
        stift.println("Bitte geben Sie den Pfad ein: ");
        stift.flush();
        String pfad = hoereFrage();
        try {
            File newDir = new File(pfad);
            if (newDir.isDirectory()) {
                // ask if user wants to delete directory
                stift.println("Wollen Sie das Verzeichnis wirklich löschen? (j/n)");
                stift.flush();
                String antwort = hoereFrage();
                if (antwort.equals("j")) {
                    newDir.delete();
                    stift.println("Verzeichnis gelöscht");
                    stift.println(pfad);
                } else {
                    stift.println("Verzeichnis nicht gelöscht");
                }
            } else {
                stift.println("Fehler: Verzeichnis nicht gefunden");
            }
        } catch (Exception e) {
            System.out.println("Fehler: " + e);

        }
        stift.flush();
    }

    public void copy() {
        stift.println("copy");
        stift.println("Bitte geben Sie den Dateinamen ein: ");
        stift.flush();
        String dateiName = hoereFrage();
        stift.println("Bitte geben Sie den Zielort ein: ");
        stift.flush();
        String ziel = hoereFrage();
        try {
            File datei = new File(
                    System.getProperty("user.dir") + "/" + dateiName + ".txt");
            File zielDatei = new File(ziel + "/" + dateiName + ".txt");
            if (datei.exists()) {
                // ask if user wants to copy file
                stift.println("Wollen Sie die Datei wirklich kopieren? (j/n)");
                stift.flush();
                String antwort = hoereFrage();
                if (antwort.equals("j")) {
                    Files.copy(datei.toPath(), zielDatei.toPath());
                    stift.println("Datei kopiert");
                    stift.println(dateiName + ".txt");
                } else {
                    stift.println("Datei nicht kopiert");
                }
            } else {
                stift.println("Fehler: Datei nicht gefunden");

            }
        } catch (Exception e) {
            System.out.println("Fehler: " + e);

        }
        stift.flush();
    }

    public void move() {
        stift.println("move");
        stift.println("Bitte geben Sie den Dateinamen ein: ");
        stift.flush();
        String dateiName = hoereFrage();
        stift.println("Bitte geben Sie den Zielort ein: ");
        stift.flush();
        String ziel = hoereFrage();
        try {
            File datei = new File(
                    System.getProperty("user.dir") + "/" + dateiName + ".txt");
            File zielDatei = new File(ziel + "/" + dateiName + ".txt");
            if (datei.exists()) {
                // ask if user wants to move file
                stift.println("Wollen Sie die Datei wirklich verschieben? (j/n)");
                stift.flush();
                String antwort = hoereFrage();
                if (antwort.equals("j")) {
                    Files.move(datei.toPath(), zielDatei.toPath());
                    stift.println("Datei verschoben");
                    stift.println(dateiName + ".txt");
                } else {
                    stift.println("Datei nicht verschoben");
                }
            } else {
                stift.println("Fehler: Datei nicht gefunden");

            }
        } catch (Exception e) {
            System.out.println("Fehler: " + e);

        }
        stift.flush();
    }

    // Konstruktor
    public textDateiServer(int port) {
        super(port);
        System.out.println("textDateiServer läuft auf Port " + port);
    }
}
