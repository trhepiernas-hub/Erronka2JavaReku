package saskibaloia.ikuspegia;

import saskibaloia.kontrolatzaileak.ErabiltzaileKontrolatzailea;
import saskibaloia.modeloak.AdmnistratzaileaModeloa;
import saskibaloia.modeloak.BazkideaModeloa;
import saskibaloia.modeloak.JokalariaModeloa;
import saskibaloia.modeloak.tablak.TablaModelCreator;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Aplikazioa {

    private static Aplikazioa aplikazioa;
    private JPanel panel1;
    private JButton eKargatuFitxategiaButton;
    private JButton eGordeFitxategiraButton;
    private JButton eExportatuSqlKodearaButton;
    private JTable jtJokalaraiak;
    private JTable jtAdministrtzaileak;
    private JTable jtBazkideak;

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

    /**
     * Aplikazioaren istantzia bat sortuta dagoen komprobatzen du eta ez badago sortu beste hau itzuli
     * @return Aplikazioaren instazia bat
     */
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
       jtJokalaraiak.setModel(createTable(new JokalariaModeloa()));
       jtAdministrtzaileak.setModel(createTable(new AdmnistratzaileaModeloa()));
       jtBazkideak.setModel(createTable(new BazkideaModeloa()));

    }

    /**
     * MEtodo honek botoi guztiei actionListener bat gehitzen die
     */
    private void sortuActionListenerrak() {
        eKargatuFitxategiaButton.addActionListener(new ErabiltzaileKontrolatzailea());
        eGordeFitxategiraButton.addActionListener(new ErabiltzaileKontrolatzailea());
        eExportatuSqlKodearaButton.addActionListener(new ErabiltzaileKontrolatzailea());

    }

    /**
     * Funtzio honek DefaultTableModel bat sortuko du, guk pasatako parametroen arabera
     * @param mota Tablaren Objetu mota
     */
    private DefaultTableModel createTable( Object mota) {
        return  TablaModelCreator.createTableModel(mota);
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

    /**
     * Metodo honek Jokalarien taula garbitzen du
     */
    public void clearJokalariakTable() {
        DefaultTableModel b = (DefaultTableModel) getJtJokalaraiak().getModel();
        b.setRowCount(0);
        getJtJokalaraiak().setModel(b);
    }

    /**
     * Metodo honek Administrtzaileen taula garbitzen du
     */
    public void clearAdministrtzaileakTable() {
        DefaultTableModel b = (DefaultTableModel) getJtAdministrtzaileak().getModel();
        b.setRowCount(0);
        getJtAdministrtzaileak().setModel(b);
    }

    /**
     * Metodo honek Bazkideen taula garbitzen du
     */
    public void clearBazkideakTable() {
        DefaultTableModel b = (DefaultTableModel) getJtBazkideak().getModel();
        b.setRowCount(0);
        getJtBazkideak().setModel(b);
    }
}
