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
    private JButton eKargatuFitxategiaButton;
    private JButton eAktulizatuDatubasekoDatuakButton;
    private JButton eGordeFitxategiraButton;
    private JButton eExportatuSqlKodearaButton;
    private JButton eIgoDatubaseraButton;
    private JTable jtJokalaraiak;
    private JTable jtDbJokalariak;
    private JTable jtAdministrtzaileak;
    private JTable jtDbAdministratzaileak;
    private JTable jtDbBazkideak;
    private JTable jtBazkideak;
    private JTable jpDbBerriak;
    private JTable table2jpBerriak;
    private JButton bKargatuFitxategiaButton;
    private JButton bAktulizatuDatubasekoDatuakButton;
    private JButton bGordeFitxategiraButton;
    private JButton bExportatuSqlKodearaButton;
    private JButton bIgoDatubaseraButton;
    private JButton pKargatuFitxategiaButton;
    private JButton pAktulizatuDatubasekoDatuakButton;
    private JButton pGordeFitxategiraButton;
    private JButton pExportatuSqlKodearaButton;
    private JButton pIgoDatubaseraButton;
    private JTable jtDbPartiduak;
    private JTable jtPartiduak;

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
       jtDbAdministratzaileak.setModel(createTable(new AdmnistratzaileaModeloa(), 0));
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
