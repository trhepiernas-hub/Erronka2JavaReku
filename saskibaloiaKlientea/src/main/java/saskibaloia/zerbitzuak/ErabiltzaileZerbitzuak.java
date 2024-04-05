package saskibaloia.zerbitzuak;

import com.google.gson.Gson;
import saskibaloia.ikuspegia.Aplikazioa;
import saskibaloia.modeloak.AdmnistratzaileaModeloa;
import saskibaloia.modeloak.BazkideaModeloa;
import saskibaloia.modeloak.JokalariaModeloa;

import javax.swing.*;
import java.io.BufferedWriter;

import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
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
            String json = sortuJson();
            fitxategia += ".json";

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fitxategia))) {
                writer.write(json);
            } catch (IOException e) {
                System.out.println("Fitxategia idaztean errorea: " + e.getMessage());
            }

        }
    }

    public String sortuJson() {
        Gson gson = new Gson();
        List<JokalariaModeloa> jokalariak = lortuJokalariTablakoDatuak();
        List<BazkideaModeloa> bazkideak = lortuBazkideTablakoDatuak();
        List<AdmnistratzaileaModeloa> administratzaileak = lortuAdministrtzaileTablakoDatuak();

        String jokalariJson = gson.toJson(jokalariak);
        String bazkideJson = gson.toJson(bazkideak);
        String adminJson = gson.toJson(administratzaileak);


        return "{\n" +
                "  \"jokalariak\": " + jokalariJson + ",\n" +
                "  \"bazkideak\": " + bazkideJson + ",\n" +
                "  \"administratzaileak\": " + adminJson + "\n" +
                "}";
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

           String erabiltzaileaIzena = (String) modelo.getValueAt(i, 2);
           String pertsonarenIzena = (String) modelo.getValueAt(i, 3);
           String abizena = (String) modelo.getValueAt(i, 4);
           String pasahitza = (String) modelo.getValueAt(i, 5);
           String korreoa = (String) modelo.getValueAt(i, 6);
           String kontuSortzeData = (String) modelo.getValueAt(i, 0);

           // Crea una instancia de BazkideaModeloa con los valores de la fila actual
           BazkideaModeloa bazkidea = new BazkideaModeloa();
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
            String erabiltzaileaIzena = (String) modelo.getValueAt(i, 3);
            String pertsonarenIzena = (String) modelo.getValueAt(i, 4);
            String abizena = (String) modelo.getValueAt(i, 5);
            String pasahitza = (String) modelo.getValueAt(i, 6);
            String korreoa = (String) modelo.getValueAt(i, 7);
            String jokalariKodea = (String) modelo.getValueAt(i, 0);
            String dorsalZenbakia = (String) modelo.getValueAt(i, 1);

            // Jokalaria model bat sortu eta listan gordetzen dugu
            JokalariaModeloa jokalaria = new JokalariaModeloa();
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
            String erabiltzaileaIzena = (String) modelo.getValueAt(i, 2);
            String pertsonarenIzena = (String) modelo.getValueAt(i, 3);
            String abizena = (String) modelo.getValueAt(i, 4);
            String pasahitza = (String) modelo.getValueAt(i, 5);
            String korreoa = (String) modelo.getValueAt(i, 6);
            String administratzaileKodea = (String) modelo.getValueAt(i, 0);

            // Crea una instancia de BazkideaModeloa con los valores de la fila actual
            AdmnistratzaileaModeloa administrtzailea = new AdmnistratzaileaModeloa();
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
