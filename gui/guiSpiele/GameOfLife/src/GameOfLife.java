//Leon Kohlhaußen
// 2022-12-07
// Game of Life
// Das Programm simuliert das Spiel des Lebens
// und zeigt das Ergebnis in einem Fenster an.
// Der Benutzer kann die Simulation starten und stoppen
// und kann die Geschwindigkeit der Simulation ändern.
////////////////////////////////////////////////////////////////

public class GameOfLife {
    int x = 200; // x position zeile
    int y = 200; // y position spalte
    boolean[][] grid = new boolean[x][y]; // grid
    boolean[][] gridNew = new boolean[x][y]; // grid2
    // die ausgabe
    String leben = "x"; // lebendig
    String tot = " "; // tot

    // methoden
    public int getWidth() { // gibt die breite zurück
        return x; // x
    }

    public int getHeight() { // gibt die höhe zurück
        return y; // y
    }

    public boolean getCell(int zeile, int spalte) { // gibt den zustand der zelle zurück
        return grid[zeile][spalte];
    }

    public void setCell(int zeile, int spalte, boolean wert) { // setzt den zustand der zelle
        grid[zeile][spalte] = wert;
    }

    int anzahlNachbarn(int zeile, int spalte) { // gibt die anzahl der nachbarn zurück
        int count = 0; // count set to 0
        if (zeile > 0 && zeile < x && spalte > 0 && spalte < y) { // wenn die zelle nicht an der kante ist
            for (int i = zeile - 1; i <= zeile + 1; i++) { // für jede spalte der zeichenfläche
                for (int j = spalte - 1; j <= spalte + 1; j++) { // für jede zeile der zeichenfläche
                    if (i >= 0 && i < x && j >= 0 && j < y) { // check if the cell is within the grid
                        count += wertZelle(i, j); // add the value of the cell to the count
                    }
                }
            }
            count -= wertZelle(zeile, spalte); // subtract the value of the current cell
        }
        return count; // return the count
    }

    int wertZelle(int zeile, int spalte) { // gibt den wert der zelle zurück
        if (grid[zeile][spalte]) { // wenn die zelle lebendig ist
            return 1; // gib 1 zurück
        } else { // wenn die zelle tot ist
            return 0; // gib 0 zurück
        }
    }

    int nextState(int zeile, int spalte) { // gibt den zustand der zelle zurück
        int count = anzahlNachbarn(zeile, spalte); // anzahl der nachbarn
        if (wertZelle(zeile, spalte) == 0) { // cell is dead
            if (count == 3) { // if the cell has 3 neighbors
                return 1; // cell becomes alive
            } else {
                return 0; // cell remains dead
            }
        } else { // cell is alive
            if (count < 2 || count > 3) {
                return 0; // cell dies
            } else {
                return 1; // cell remains alive
            }
        }
    }

    void neueZelle(int zeile, int spalte) { // setzt den zustand der zelle
        int next = nextState(zeile, spalte); // determine the next state of the cell
        setzeZelle(zeile, spalte, next); // set the value of the cell to the next state
    }

    void setzeZelle(int zeile, int spalte, int wert) { // setzt den zustand der zelle
        if (wert == 1) { // wenn der wert 1 ist
            gridNew[zeile][spalte] = true; // setze die zelle auf lebendig
        } else { // wenn der wert 0 ist
            gridNew[zeile][spalte] = false; // setze die zelle auf tot
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

    public void step() {
        berechneNeueGeneration(); // compute the next generation
        updateGrid(); // update the game grid
    }

}
