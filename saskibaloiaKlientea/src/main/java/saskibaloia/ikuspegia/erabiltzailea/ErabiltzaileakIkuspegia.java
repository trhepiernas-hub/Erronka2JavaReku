package saskibaloia.ikuspegia.erabiltzailea;

import javax.swing.*;
import java.awt.*;

public class ErabiltzaileakIkuspegia
{
    JButton kargatuFitxategia = new JButton("Kargatu fitxategia");

    static JScrollPane tablak = TablaPanel.sortuTabla();
    public static JPanel erabiltzaileakPanela()
    {
        JLabel jlIzena = new JLabel("Administrtatu Taldeak");
        JPanel jpTaldeak = new JPanel();
        jpTaldeak.setLayout(new GridBagLayout());

        jpTaldeak.add(jlIzena, sortuConstraints(6, 1));
        jpTaldeak.add(tablak, sortuConstraints(3, 2));
        return jpTaldeak;
    }

    /**
     *  Funtzio honek gure gridbaglayout-ean kontraintsak sortuko ditu
     *  @param x x ejean nahi dugun tamina
     *  @param y y ejean nahi dugun tamaina
     *  @return sortutako kontraintsak
     */
    private static GridBagConstraints sortuConstraints( int x, int y) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        return gbc;
    }
}