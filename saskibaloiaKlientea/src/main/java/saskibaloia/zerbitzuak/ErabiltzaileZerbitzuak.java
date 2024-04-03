package saskibaloia.zerbitzuak;

import org.w3c.dom.CDATASection;
import saskibaloia.ikuspegia.Aplikazioa;
import saskibaloia.modeloak.AdmnistratzaileaModeloa;
import saskibaloia.modeloak.BazkideaModeloa;
import saskibaloia.modeloak.JokalariaModeloa;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErabiltzaileZerbitzuak {

    /**
     * Metodo honek erabiltzaileari fitxategia nun kokatu nahi duen eskatzen dio eta tabletan diten datuak fitxategi
     * batera pasatzen ditu erabiltzaileak jarritako kokalekuan gordez
     */
    public void GordeFitxategira() {
        // TODO implement here
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Nun gorde nahi duzu fitxategia?");
        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            String fitxategia = fileChooser.getSelectedFile().getAbsolutePath();
            System.out.println("Gordetzen: " + fitxategia);

        }
    }

    private void fitxategiaSortu() {
    //TODO: tabletatik datuak bildu eta Json artxiboetara pasatu
        List<JokalariaModeloa> jokalariak = lortuJokalariTablakoDatuak();
        List<BazkideaModeloa> bazkideak = lortuBazkideTablakoDatuak();
        List<AdmnistratzaileaModeloa> administratzaileak = lortuAdministrtzaileTablakoDatuak();


    }

    /**
     * Funtzio honek Bazkidearen tablatik datuak lortu eta bazkidea model moduan bueltatzen ditu
     * @return Lista bat BazkideaModeloa objetuekin
     */
   public List<BazkideaModeloa> lortuBazkideTablakoDatuak() {
       Aplikazioa datuak = Aplikazioa.getInstace();
       JTable modelo = datuak.getJtBazkideak();
       List<BazkideaModeloa> bazkideak = new ArrayList<>();
       int filas = modelo.getRowCount();

       for (int i = 0; i < filas; i++) {
           Long idErabiltzailea = (Long) modelo.getValueAt(i, 1); // Supongamos que la columna 1 es de tipo Long
           String erabiltzaileaIzena = (String) modelo.getValueAt(i, 2); // Supongamos que la columna 2 es de tipo String
           String pertsonarenIzena = (String) modelo.getValueAt(i, 3); // Supongamos que la columna 3 es de tipo String
           String abizena = (String) modelo.getValueAt(i, 4); // Supongamos que la columna 4 es de tipo String
           String pasahitza = (String) modelo.getValueAt(i, 5); // Supongamos que la columna 5 es de tipo String
           String korreoa = (String) modelo.getValueAt(i, 6); // Supongamos que la columna 6 es de tipo String
           Date kontuSortzeData = (Date) modelo.getValueAt(i, 0); // Supongamos que la columna 7 es de tipo Date

           // Crea una instancia de BazkideaModeloa con los valores de la fila actual
           BazkideaModeloa bazkidea = new BazkideaModeloa();
           bazkidea.setIdErabiltzailea(idErabiltzailea);
           bazkidea.setErabiltzaileaIzena(erabiltzaileaIzena);
           bazkidea.setPertsonarenIzena(pertsonarenIzena);
           bazkidea.setAbizena(abizena);
           bazkidea.setPasahitza(pasahitza);
           bazkidea.setKorreoa(korreoa);
           bazkidea.setkontuSortzeData(kontuSortzeData);

           // Agrega el objeto BazkideaModeloa a la lista
           bazkideak.add(bazkidea);
       }
         return bazkideak;
    }

    /**
     * Funtzio honek Jokalariren tablatik datuak artu eta Jokalaria model moduan bueltatzen ditu
     * @return Lista bat JokalariaModeloa objetuekin
     */
    public List<JokalariaModeloa> lortuJokalariTablakoDatuak() {
        Aplikazioa datuak = Aplikazioa.getInstace();
        JTable modelo = datuak.getJtJokalaraiak();
        List<JokalariaModeloa> jokalariak = new ArrayList<>();

        for (int i = 0; i < modelo.getRowCount(); i++) {
            // Objetuarentzako datuak lortu tablatik
            Long idErabiltzailea = (Long) modelo.getValueAt(i, 2);
            String erabiltzaileaIzena = (String) modelo.getValueAt(i, 3);
            String pertsonarenIzena = (String) modelo.getValueAt(i, 4);
            String abizena = (String) modelo.getValueAt(i, 5);
            String pasahitza = (String) modelo.getValueAt(i, 6);
            String korreoa = (String) modelo.getValueAt(i, 7);
            String jokalariKodea = (String) modelo.getValueAt(i, 0);
            String dorsalZenbakia = (String) modelo.getValueAt(i, 1);

            // Jokalaria model bat sortu eta listan gordetzen dugu
            JokalariaModeloa jokalaria = new JokalariaModeloa();
            jokalaria.setIdErabiltzailea(idErabiltzailea);
            jokalaria.setErabiltzaileaIzena(erabiltzaileaIzena);
            jokalaria.setPertsonarenIzena(pertsonarenIzena);
            jokalaria.setAbizena(abizena);
            jokalaria.setPasahitza(pasahitza);
            jokalaria.setKorreoa(korreoa);
            jokalaria.setJokalariKodea(jokalariKodea);
            jokalaria.setDorsalZenbakia(dorsalZenbakia);

            // Agrega el objeto JokalariaModeloa a la lista
            jokalariak.add(jokalaria);
        }

        return jokalariak;
    }

    /**
     * Funtzio honek administratzailearen tablatik datuak lortu eta administratzaile model moduan bueltatzen ditu
     * @return Lista bat AdmnistratzaileaModeloa objetuekin
     */
    public List<AdmnistratzaileaModeloa> lortuAdministrtzaileTablakoDatuak() {
        Aplikazioa datuak = Aplikazioa.getInstace();
        JTable modelo = datuak.getJtAdministrtzaileak();
        List<AdmnistratzaileaModeloa> administratzaileak = new ArrayList<>();
        int filas = modelo.getRowCount();

        for (int i = 0; i < filas; i++) {
            Long idErabiltzailea = (Long) modelo.getValueAt(i, 1); // Supongamos que la columna 1 es de tipo Long
            String erabiltzaileaIzena = (String) modelo.getValueAt(i, 2); // Supongamos que la columna 2 es de tipo String
            String pertsonarenIzena = (String) modelo.getValueAt(i, 3); // Supongamos que la columna 3 es de tipo String
            String abizena = (String) modelo.getValueAt(i, 4); // Supongamos que la columna 4 es de tipo String
            String pasahitza = (String) modelo.getValueAt(i, 5); // Supongamos que la columna 5 es de tipo String
            String korreoa = (String) modelo.getValueAt(i, 6); // Supongamos que la columna 6 es de tipo String
            String administratzaileKodea = (String) modelo.getValueAt(i, 0); // Supongamos que la columna 7 es de tipo Date

            // Crea una instancia de BazkideaModeloa con los valores de la fila actual
            AdmnistratzaileaModeloa administrtzailea = new AdmnistratzaileaModeloa();
            administrtzailea.setIdErabiltzailea(idErabiltzailea);
            administrtzailea.setErabiltzaileaIzena(erabiltzaileaIzena);
            administrtzailea.setPertsonarenIzena(pertsonarenIzena);
            administrtzailea.setAbizena(abizena);
            administrtzailea.setPasahitza(pasahitza);
            administrtzailea.setKorreoa(korreoa);
            administrtzailea.setAdministratzaileKodea(administratzaileKodea);

            // Agrega el objeto BazkideaModeloa a la lista
            administratzaileak.add(administrtzailea);
        }
        return administratzaileak;
    }
    public void kargatuFitxategia() {
    }

    public void exportatuSqlKodeara() {
    }

    public void igoDatubasera() {
    }

    public void aktualizatuDatubasekoDatuak() {
    }
}
