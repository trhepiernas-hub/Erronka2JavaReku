package saskibaloia.zerbitzuak;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import saskibaloia.ikuspegia.Aplikazioa;
import saskibaloia.modeloak.AdmnistratzaileaModeloa;
import saskibaloia.modeloak.BazkideaModeloa;
import saskibaloia.modeloak.ErabiltzaileaModeloa;
import saskibaloia.modeloak.JokalariaModeloa;

import javax.swing.*;
import java.io.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ErabiltzaileZerbitzuak {

    /**
     * Metodo honek erabiltzaileari filechoser aukera bat erakusten dio eta erabiltzaileak aukeratutako fitxategia erakusten du
     * @param mezua Lehioan agertuko den mezua
     * @return String bat fitxategiaren helbidearekin
     */
    public String eskatuFitxategia(String mezua) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle(mezua);
        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile().getAbsolutePath();
        }
        return null;
    }

    /**
     * Metodo honek erabiltzaileari fitxategia nun kokatu nahi duen eskatzen dio eta tabletan diten datuak fitxategi
     * batera pasatzen ditu erabiltzaileak jarritako kokalekuan gordez
     */
    public void GordeFitxategira() {
        String fitxategia = eskatuFitxategia("Nun gorde nahi duzu fitxategia?");

        if (fitxategia == null) {
            return;
        }

        String json = sortuJson();
        fitxategia += ".json";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fitxategia))) {
            writer.write(json);
        } catch (IOException e) {
            System.out.println("Fitxategia idaztean errorea: " + e.getMessage());
        }
    }

    /**
     * Funtzio honek tablako datuekin json bat sortu eta bidaltzen du
     * @return tablako datuekin json bat
     */
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

    /**
     * Meodo honek gure ekipotik json fitxategi bat kargatzen tabletan gero guk bertatik editatzeko
     */
    public void kargatuFitxategia() {
        Aplikazioa aplikazioa = Aplikazioa.getInstace();
        String fitxategia = eskatuFitxategia("Aukeratu fitxategia");
        if (fitxategia == null) {
            return;
        }
        try {
            // Fitxategia Irakurri
            JsonObject jsonObject = JsonParser.parseReader(new FileReader(fitxategia)).getAsJsonObject();

            // Json objetuak lortu
            String jokalariak = jsonObject.get("jokalariak").toString();
            String bazkideak = jsonObject.get("bazkideak").toString();
            String administratzaileak = jsonObject.get("administratzaileak").toString();

            // Json objetuak parseatu
            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<JokalariaModeloa>>(){}.getType();
            List<JokalariaModeloa> jokalariaModeloaList = gson.fromJson(jokalariak, listType);

            listType = new TypeToken<ArrayList<BazkideaModeloa>>(){}.getType();
            List<BazkideaModeloa> bazkideaModeloaList = gson.fromJson(bazkideak, listType);

            listType = new TypeToken<ArrayList<AdmnistratzaileaModeloa>>(){}.getType();
            List<AdmnistratzaileaModeloa> admnistratzaileaModeloaList = gson.fromJson(administratzaileak, listType);

            for (JokalariaModeloa jokalariaModeloa : jokalariaModeloaList) {
                aplikazioa.addDataJtJokalariak(jokalariaModeloa);
            }

            for (BazkideaModeloa bazkideaModeloa : bazkideaModeloaList) {
                aplikazioa.addDataJtBazkideak(bazkideaModeloa);
            }

            for (AdmnistratzaileaModeloa admnistratzaileaModeloa : admnistratzaileaModeloaList) {
                aplikazioa.addDataJtAdministrtzaileak(admnistratzaileaModeloa);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Fitxategia ez da aurkitu: " + e.getMessage());

        }
    }

    /**
     * Metodo honek gure tabletako datuak insert into sql kodera bihurtzen ditu eta fitxategi batean gorde
     */
    public void exportatuSqlKodeara() {

        String fitxategia = eskatuFitxategia("Nun gorde nahi duzu fitxategia?");
        if (fitxategia == null) {
            return;
        }
        fitxategia += ".sql";
        List<JokalariaModeloa> jokalariak = lortuJokalariTablakoDatuak();
        List<BazkideaModeloa> bazkideak = lortuBazkideTablakoDatuak();
        List<AdmnistratzaileaModeloa> administratzaileak = lortuAdministrtzaileTablakoDatuak();

        StringBuilder sql = new StringBuilder();

        for (JokalariaModeloa jokalaria : jokalariak) {
            sql.append(insertErabiltzailea(jokalaria));
            sql.append("INSERT INTO `jokalaria` (`dorsal_zenbakia`, `jokalari_kodea`, `id_erabiltzailea`) VALUES (");
            sql.append(jokalaria.getDorsalZenbakia()).append(", ");
            sql.append(jokalaria.getJokalariKodea()).append(", ");
            sql.append("LAST_INSERT_ID()").append(");\n");
        }

        for (BazkideaModeloa bazkidea : bazkideak) {
            sql.append(insertErabiltzailea(bazkidea));
            sql.append("INSERT INTO `bazkidea` (`kontu_sortze_data`, `id_erabiltzailea`) VALUES (");
            sql.append(bazkidea.getkontuSortzeData()).append(", ");
            sql.append("LAST_INSERT_ID()").append(");\n");
        }

        for (AdmnistratzaileaModeloa administratzailea : administratzaileak) {
            sql.append(insertErabiltzailea(administratzailea));
            sql.append("INSERT INTO `administratzailea` (`administratzaile_kodea`, `id_erabiltzailea`) VALUES (");
            sql.append(administratzailea.getAdministratzaileKodea()).append(", ");
            sql.append("LAST_INSERT_ID()").append(");\n");
        }

        final String sqlKodea = sql.toString();

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fitxategia));
            bufferedWriter.write(sqlKodea);
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Errorea fitxategia sortzean: " + e.getMessage());
        }
    }

    /**
     * Funtzio honek Inserti into sql kodea bat sortzen du erabiltzailea modeloarekin
     * @param erabiltzaileaModeloa ErabiltzaileaModeloa objetua
     * @return String bat sql kodearekin
     */
    public String insertErabiltzailea(ErabiltzaileaModeloa erabiltzaileaModeloa) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO `erabiltzailea` (`id_erabiltzailea`," +
                "`abizena`, `erabiltzailea_izena`, `korreoa`, `pasahitza`," +" " +
                "`pertsonaren_izena`) VALUES (");
        sql.append(erabiltzaileaModeloa.getIdErabiltzailea()).append(", ");
        sql.append(erabiltzaileaModeloa.getAbizena()).append(", ");
        sql.append(erabiltzaileaModeloa.getErabiltzaileaIzena()).append(", ");
        sql.append(erabiltzaileaModeloa.getKorreoa()).append(", ");
        sql.append(erabiltzaileaModeloa.getPasahitza()).append(", ");
        sql.append(erabiltzaileaModeloa.getPertsonarenIzena()).append(");\n");
        return sql.toString();
    }
}
