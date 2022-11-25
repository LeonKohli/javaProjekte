import javax.swing.*;
import java.awt.*;

public class HalloWelt1 {

	JTextField wer; // die objekte, auf die die einzelnen methoden
	JLabel gruss; // zugreifen müssen
	JCheckBox gross;

	public void starte() {

		// erzeuge die objekte für die GUI
		JFrame frame = new JFrame();
		JLabel label = new JLabel();
		JButton ok = new JButton();
		JCheckBox gross = new JCheckBox();
		gruss = new JLabel(); // für die ausgabe
		wer = new JTextField(); // für die eingabe

		// objkteigensachaften festlegen
		wer.setColumns(10);
		ok.setText(" OK ");
		label.setText("Wie heißt Du?");
		gruss.setText(" ");
		gruss.setFont(new Font("Serif", Font.PLAIN, 20));
		gross.setText("dicke Schrift");
		gross.setFont(new Font("Serif", Font.BOLD, 20));

		// insbesondere: eigenschaften des fensters
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.setSize(300, 120);

		// objekte zum fenster hinzufügen
		frame.add(label, BorderLayout.WEST);
		frame.add(wer, BorderLayout.CENTER);
		frame.add(ok, BorderLayout.EAST);
		frame.add(gruss, BorderLayout.NORTH);
		frame.add(gross, BorderLayout.SOUTH);

		// fenster anzeigen
		frame.setVisible(true);

		// das Objekt bekommt Fokus
		// markiert den Text im Textfeld
		wer.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				wer.selectAll();
			}
		});

		// die methode, die auf den button klick reagiert
		ok.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				gruss.setText("Hallo " + wer.getText());
				gruss();
			}
		});

		// die methode, die auf den checkbox klick reagiert
		gross.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if (gross.isSelected()) {
					// text dick
					gruss.setFont(new Font("Serif", Font.BOLD, 20));
				} else {
					// text normal
					gruss.setFont(new Font("Serif", Font.PLAIN, 20));
				}
			}
		});
	}

	// neues fenster öffnen mit dem gruss Text
	public void gruss() {
		JFrame frame = new JFrame();
		JLabel label = new JLabel();
		label.setText(gruss.getText());
		frame.add(label);
		frame.setVisible(true);
		frame.setSize(300, 120);
		label.setFont(gruss.getFont());
	}

}
