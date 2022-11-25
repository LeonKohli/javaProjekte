import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Memory {

  ArrayList<Karte> spielKarten = new ArrayList<Karte>();
  Karte zuletztAufgedeckt = null;
  JFrame frame = new JFrame();

  void zeigeAlleKarten() { // nur für testzwecke
    System.out.println("-------------------------------");
    for (int nr = 0; nr < spielKarten.size(); nr++) {
      System.out.println(nr + ": " + spielKarten.get(nr));
    }
    System.out.println("-------------------------------");
  }

  void mischeKarten(int anzahlPärchen) {

    ArrayList<Integer> nummern = new ArrayList<Integer>();
    for (int nr = 0; nr < anzahlPärchen; nr++) {
      // zahlen von 0 bis ?? zu einer nummernliste hinzuf�gen
      nummern.add(nr);
      // ... und das 2x, da ja memory
      nummern.add(nr);
    }

    for (int nr = 0; nr < 2 * anzahlPärchen; nr++) {
      // per zufall aus nummernliste eine nummer w�hlen
      int nummer = (int) (Math.random() * nummern.size());

      // ... entsprechende karte zu den spielkarten hinzufügen
      spielKarten.add(new Karte(nummern.get(nummer)));
      // ... und die nummer aus der nummernliste l�schen
      nummern.remove(nummer);
    }
    zeigeAlleKarten(); // nur zur demo
  }

  public void starte(int anzahlPärchen) {

    mischeKarten(anzahlPärchen);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new FlowLayout());
    frame.setSize(500, 500);
    frame.setVisible(true);

    frame.setSize(400, 150);
    frame.setVisible(true);

  }

  class Karte extends JButton {
    // variablen
    String inhalt;

    // methoden
    void deckeAuf() {
      this.setBackground(Color.WHITE);
      setText(inhalt);

    }

    void deckeZu() {
      // colorize the button
      this.setBackground(Color.GRAY);
      setText(inhalt);
    }

    // konstruktor
    Karte(int nummer) {
      inhalt = "" + nummer;
      deckeZu();
      addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          deckeAuf();
          if (zuletztAufgedeckt == null) {
            zuletztAufgedeckt = Karte.this;
          } else {
            if (zuletztAufgedeckt.inhalt.equals(Karte.this.inhalt)) {
              System.out.println("richtig");
              spielKarten.remove(zuletztAufgedeckt);
              spielKarten.remove(Karte.this);
              frame.remove(zuletztAufgedeckt);
              frame.remove(Karte.this);
              frame.revalidate();
              frame.repaint();
            } else {
              System.out.println("falsch");
              zuletztAufgedeckt.deckeZu();
              Karte.this.deckeZu();
            }
            zuletztAufgedeckt = null;
          }
        }
      });
      frame.add(this);
    }
  }
}
