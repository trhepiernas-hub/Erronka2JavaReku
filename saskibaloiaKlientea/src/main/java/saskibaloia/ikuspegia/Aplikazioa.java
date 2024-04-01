package saskibaloia.ikuspegia;

import saskibaloia.kontrolatzaileak.BerriaKontrolatzailea;
import saskibaloia.kontrolatzaileak.ErabiltzaileKontrolatzailea;
import saskibaloia.modeloak.AdmnistratzaileaModeloa;
import saskibaloia.modeloak.BazkideaModeloa;
import saskibaloia.modeloak.BerriaModeloa;
import saskibaloia.modeloak.JokalariaModeloa;
import saskibaloia.modeloak.tablak.TablaModelCreator;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Aplikazioa {

    private static Aplikazioa aplikazioa;
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
    private JTable jtDbBerriak;
    private JTable jtBerriak;
    private JButton bKargatuFitxategiaButton;
    private JButton bAktulizatuDatubasekoDatuakButton;
    private JButton bGordeFitxategiraButton;
    private JButton bExportatuSqlKodearaButton;
    private JButton bIgoDatubaseraButton;

    private Aplikazioa() {
        JFrame frame = new JFrame("aplikazioa");
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        createTables();
        sortuActionListenerrak();
    }

    public static Aplikazioa getInstace() {
        if (aplikazioa == null) {
            aplikazioa = new Aplikazioa();
        }
        return aplikazioa;
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
       jtBerriak.setModel(createTable(new BerriaModeloa(), 1));
       jtDbBerriak.setModel(createTable(new BerriaModeloa(), 0));
    }

    private void sortuActionListenerrak() {
        eKargatuFitxategiaButton.addActionListener(new ErabiltzaileKontrolatzailea());
        eAktulizatuDatubasekoDatuakButton.addActionListener(new ErabiltzaileKontrolatzailea());
        eGordeFitxategiraButton.addActionListener(new ErabiltzaileKontrolatzailea());
        eExportatuSqlKodearaButton.addActionListener(new ErabiltzaileKontrolatzailea());
        eIgoDatubaseraButton.addActionListener(new ErabiltzaileKontrolatzailea());

        bKargatuFitxategiaButton.addActionListener(new BerriaKontrolatzailea());
        bAktulizatuDatubasekoDatuakButton.addActionListener(new BerriaKontrolatzailea());
        bGordeFitxategiraButton.addActionListener(new BerriaKontrolatzailea());
        bExportatuSqlKodearaButton.addActionListener(new BerriaKontrolatzailea());
        bIgoDatubaseraButton.addActionListener(new BerriaKontrolatzailea());

    }

    /**
     * Funtzio honek DefaultTableModel bat sortuko du, guk pasatako parametroen arabera
     * @param mota Tablaren Objetu mota
     * @param tipo taularen mota, 0 tabla ezingo da editatu edo 1 baldin bada enventlistner bat ekarriko dut azkenko filan idaztean beste row bat sortuko du
     */
    private DefaultTableModel createTable( Object mota, int tipo) {
        return  TablaModelCreator.createTableModel(mota, tipo);
    }

    public JTable getJtJokalaraiak() {
        return jtJokalaraiak;
    }

    public JTable getJtAdministrtzaileak() {
        return jtAdministrtzaileak;
    }

    public JTable getJtBazkideak() {
        return jtBazkideak;
    }

    /**
     * Metodo honek Bazkidea bat gehitzen du Aplikazioaren Jtable-ari
     * @param bazkidea BazkideaModeloa objetua
     */
    public void addDataJtBazkideak (BazkideaModeloa bazkidea) {
        DefaultTableModel b = (DefaultTableModel) getJtBazkideak().getModel();
        b.addRow(new Object[]{bazkidea.getkontuSortzeData(), bazkidea.getIdErabiltzailea(), bazkidea.getErabiltzaileaIzena(), bazkidea.getPertsonarenIzena(), bazkidea.getAbizena(), bazkidea.getPasahitza(), bazkidea.getKorreoa()});
        getJtBazkideak().setModel(b);
    }

    /**
     * Metodo honek Administrtzaile bat gehitzen du Aplikazioaren Jtable-ari
     * @param administratzailea AdmnistratzaileaModeloa objetua
     */
    public void addDataJtAdministrtzaileak (AdmnistratzaileaModeloa administratzailea) {
        DefaultTableModel b = (DefaultTableModel) getJtAdministrtzaileak().getModel();
        b.addRow(new Object[]{administratzailea.getAdministratzaileKodea(), administratzailea.getIdErabiltzailea(), administratzailea.getErabiltzaileaIzena(), administratzailea.getPertsonarenIzena(), administratzailea.getAbizena(), administratzailea.getPasahitza(), administratzailea.getKorreoa()});
        getJtAdministrtzaileak().setModel(b);
    }

    /**
     * Metodo honek Joklaria bat gehitzen du Aplikazioaren Jtable-ari
     * @param jokalaria JokalariaModeloa objetua
     */
    public void addDataJtJokalariak (JokalariaModeloa jokalaria) {
        DefaultTableModel b = (DefaultTableModel) getJtJokalaraiak().getModel();
        b.addRow(new Object[]{jokalaria.getJokalariKodea(), jokalaria.getDorsalZenbakia(), jokalaria.getIdErabiltzailea(), jokalaria.getErabiltzaileaIzena(), jokalaria.getPertsonarenIzena(), jokalaria.getAbizena(), jokalaria.getPasahitza(), jokalaria.getKorreoa()});
        getJtJokalaraiak().setModel(b);
    }

    public JTable getJtBerriak() {
        return jtBerriak;
    }
}
