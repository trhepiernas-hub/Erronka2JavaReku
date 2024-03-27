package saskibaloia.ikuspegia;

import saskibaloia.ikuspegia.erabiltzailea.ErabiltzaileakIkuspegia;

import javax.swing.*;

public class mainIkuspegia {

    JFrame aplikazioa = new JFrame("Saskibaloia Aplikazioa");
    JTabbedPane panelak = new JTabbedPane();

    JPanel erabiltzaileak = ErabiltzaileakIkuspegia.erabiltzaileakPanela();

    public mainIkuspegia() {
        panelak.add("Erabiltzaileak", erabiltzaileak);
        aplikazioa.getContentPane().add(panelak);
        aplikazioa.setSize(800, 600);
        aplikazioa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        aplikazioa.pack();
        aplikazioa.setVisible(true);
    }
}
