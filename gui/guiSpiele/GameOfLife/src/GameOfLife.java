//Leon Kohlhaußen
// 2022-12-07
// Game of Life
// Das Programm simuliert das Spiel des Lebens
// und zeigt das Ergebnis in einem Fenster an.
// Der Benutzer kann die Simulation starten und stoppen
// und kann die Geschwindigkeit der Simulation ändern.
////////////////////////////////////////////////////////////////

public class GameOfLife {
    int x = 30; // x position zeile
    int y = 30; // y position spalte
    boolean[][] grid = new boolean[x][y]; // grid
    boolean[][] gridNew = new boolean[x][y]; // grid2
    // die ausgabe
    String leben = "x"; // lebendig
    String tot = " "; // tot

    // methoden
    int anzahlNachbarn(int zeile, int spalte) { // anzahl der nachbarn
        if (zeile > 0 && zeile < x && spalte > 0 && spalte < y) { // wenn die position innerhalb des arrays ist
            return wertZelle(zeile, spalte - 1) + // links
                    wertZelle(zeile, spalte + 1) + // rechts
                    wertZelle(zeile - 1, spalte - 1) + // oben links
                    wertZelle(zeile - 1, spalte + 1) + // oben rechts
                    wertZelle(zeile + 1, spalte + 1) + // unten rechts
                    wertZelle(zeile + 1, spalte - 1) + // unten links
                    wertZelle(zeile - 1, spalte) + // oben
                    wertZelle(zeile + 1, spalte); // unten
        } else {
            return 0;
        }

    }

    int wertZelle(int zeile, int spalte) { // gibt den wert der zelle zurück
        if (grid[zeile][spalte]) { // wenn die zelle lebendig ist
            return 1; // gib 1 zurück
        } else { // wenn die zelle tot ist
            return 0; // gib 0 zurück
        }
    }

    void neueZelle(int zeile, int spalte) {
        int anzahlNachbarn = anzahlNachbarn(zeile, spalte); // anzahl der nachbarn
        if (grid[zeile][spalte]) { // wenn die zelle lebt
            if (anzahlNachbarn < 2 || anzahlNachbarn > 3) { // wenn weniger als 2 oder mehr als 3 nachbarn
                gridNew[zeile][spalte] = false; // dann stirbt die zelle
            } else { // sonst
                gridNew[zeile][spalte] = true; // bleibt sie leben
            } // ende wenn
        } else { // wenn die zelle tot ist
            if (anzahlNachbarn == 3) { // wenn genau 3 nachbarn
                gridNew[zeile][spalte] = true; // dann wird die zelle geboren
            } else { // sonst
                gridNew[zeile][spalte] = false; // bleibt sie tot
            }
        }
    }

    // i ist die zeile
    // j ist die spalte

    void berechneNeueGeneration() { // berechnet die neue generation
        for (int i = 0; i < x; i++) { // für jede zeile
            for (int j = 0; j < y; j++) { // für jede spalte
                neueZelle(i, j); // berechne die neue zelle
            }
        }

    }

    void updateGrid() { // updatet das grid
        for (int i = 0; i < x; i++) { // für jede zeile
            for (int j = 0; j < y; j++) { // für jede spalte
                grid[i][j] = gridNew[i][j]; // setze das neue grid auf das alte
            }
        }
    }
}
