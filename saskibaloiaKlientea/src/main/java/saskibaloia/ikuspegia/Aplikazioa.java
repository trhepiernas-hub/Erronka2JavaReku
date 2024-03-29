package saskibaloia.ikuspegia;

import saskibaloia.modeloak.AdmnistratzaileaModeloa;
import saskibaloia.modeloak.BazkideaModeloa;
import saskibaloia.modeloak.JokalariaModeloa;
import saskibaloia.modeloak.tablak.TablaModelCreator;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Aplikazioa {
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JTable jtJokalaraiak;
    private JTable jtDbJokalariak;
    private JTable jtAdministrtzaileak;
    private JTable jtAdministratzailea;
    private JTable jtDbBazkideak;
    private JTable jtBazkideak;

    public Aplikazioa() {
        JFrame frame = new JFrame("aplikazioa");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        createTables();
    }

    /**
     * Metodo honek interfazeko tabla guztiak sortzen ditu
     */
    private void createTables() {
       jtJokalaraiak.setModel(createTable(new JokalariaModeloa(), 1));
       jtDbJokalariak.setModel(createTable(new JokalariaModeloa(), 0));
       jtAdministrtzaileak.setModel(createTable(new AdmnistratzaileaModeloa(), 1));
       jtAdministratzailea.setModel(createTable(new AdmnistratzaileaModeloa(), 0));
       jtDbBazkideak.setModel(createTable(new BazkideaModeloa(), 1));
       jtBazkideak.setModel(createTable(new BazkideaModeloa(), 0));
    }

    /**
     * Funtzio honek DefaultTableModel bat sortuko du, guk pasatako parametroen arabera
     * @param mota Tablaren Objetu mota
     * @param tipo taularen mota, 0 tabla ezingo da editatu edo 1 baldin bada enventlistner bat ekarriko dut azkenko filan idaztean beste row bat sortuko du
     */
    private DefaultTableModel createTable( Object mota, int tipo) {
        return  TablaModelCreator.createTableModel(mota, tipo);


    }
}
