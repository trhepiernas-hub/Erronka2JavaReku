package saskibaloia.zerbitzuak;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import saskibaloia.ikuspegia.Aplikazioa;
import saskibaloia.modeloak.AdmnistratzaileaModeloa;
import saskibaloia.modeloak.BazkideaModeloa;
import saskibaloia.modeloak.JokalariaModeloa;
import saskibaloia.modeloak.tablak.TablaModelCreator;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ErabiltzaileZerbitzuakTest {

    @Test
    void lortuBazkideTablakoDatuak() {
        Aplikazioa aplikazioa = Aplikazioa.getInstace();
        BazkideaModeloa bazkidea = new BazkideaModeloa();
        bazkidea.setIdErabiltzailea(1L);
        bazkidea.setErabiltzaileaIzena("erabiltzaileaIzena");
        bazkidea.setPertsonarenIzena("pertsonarenIzena");
        bazkidea.setAbizena("abizena");
        bazkidea.setPasahitza("pasahitza");
        bazkidea.setKorreoa("korreoa");
        bazkidea.setkontuSortzeData("2020-02-12");
        aplikazioa.addDataJtBazkideak(bazkidea);
        ErabiltzaileZerbitzuak erabiltzaileZerbitzuak = new ErabiltzaileZerbitzuak();
        List<BazkideaModeloa> a = erabiltzaileZerbitzuak.lortuBazkideTablakoDatuak();
        BazkideaModeloa bazkidea2 = (BazkideaModeloa) a.getLast();
        boolean result = true;
        result = result && bazkidea2.getIdErabiltzailea() == null;
        result = result && bazkidea.getErabiltzaileaIzena().equals(bazkidea2.getErabiltzaileaIzena());
        result = result && bazkidea.getPertsonarenIzena().equals(bazkidea2.getPertsonarenIzena());
        result = result && bazkidea.getAbizena().equals(bazkidea2.getAbizena());
        result = result && bazkidea.getPasahitza().equals(bazkidea2.getPasahitza());
        result = result && bazkidea.getKorreoa().equals(bazkidea2.getKorreoa());
        result = result && bazkidea.getkontuSortzeData().equals(bazkidea2.getkontuSortzeData());
        assertTrue(result);

    }

    @Test
    void lortuJokalariTablakoDatuak() {
        Aplikazioa aplikazioa = Aplikazioa.getInstace();
        JokalariaModeloa jokalaria = new JokalariaModeloa();
        jokalaria.setIdErabiltzailea(1L);
        jokalaria.setErabiltzaileaIzena("erabiltzaileaIzena");
        jokalaria.setPertsonarenIzena("pertsonarenIzena");
        jokalaria.setAbizena("abizena");
        jokalaria.setPasahitza("pasahitza");
        jokalaria.setKorreoa("korreoa");
        jokalaria.setDorsalZenbakia("12");
        jokalaria.setJokalariKodea("01");
        aplikazioa.addDataJtJokalariak(jokalaria);
        ErabiltzaileZerbitzuak erabiltzaileZerbitzuak = new ErabiltzaileZerbitzuak();
        List<JokalariaModeloa> a = erabiltzaileZerbitzuak.lortuJokalariTablakoDatuak();
        JokalariaModeloa jokalaria2 = (JokalariaModeloa) a.getLast();
        boolean result = true;
        result = result && jokalaria2.getIdErabiltzailea() == null;
        result = result && jokalaria.getErabiltzaileaIzena().equals(jokalaria2.getErabiltzaileaIzena());
        result = result && jokalaria.getPertsonarenIzena().equals(jokalaria2.getPertsonarenIzena());
        result = result && jokalaria.getAbizena().equals(jokalaria2.getAbizena());
        result = result && jokalaria.getPasahitza().equals(jokalaria2.getPasahitza());
        result = result && jokalaria.getKorreoa().equals(jokalaria2.getKorreoa());
        result = result && jokalaria.getDorsalZenbakia().equals(jokalaria2.getDorsalZenbakia());
        result = result && jokalaria.getJokalariKodea().equals(jokalaria2.getJokalariKodea());
        assertTrue(result);
    }

    @Test
    void lortuAdministrtzaileTablakoDatuak() {
        Aplikazioa aplikazioa = Aplikazioa.getInstace();
        AdmnistratzaileaModeloa administratzailea = new AdmnistratzaileaModeloa();
        administratzailea.setIdErabiltzailea(1L);
        administratzailea.setErabiltzaileaIzena("erabiltzaileaIzena");
        administratzailea.setPertsonarenIzena("pertsonarenIzena");
        administratzailea.setAbizena("abizena");
        administratzailea.setPasahitza("pasahitza");
        administratzailea.setKorreoa("korreoa");
        administratzailea.setAdministratzaileKodea("01");
        aplikazioa.addDataJtAdministrtzaileak(administratzailea);
        ErabiltzaileZerbitzuak erabiltzaileZerbitzuak = new ErabiltzaileZerbitzuak();
        List<AdmnistratzaileaModeloa> a = erabiltzaileZerbitzuak.lortuAdministrtzaileTablakoDatuak();
        AdmnistratzaileaModeloa administratzailea2 = (AdmnistratzaileaModeloa) a.getLast();
        boolean result = true;
        result = result && administratzailea2.getIdErabiltzailea() == null;
        result = result && administratzailea.getErabiltzaileaIzena().equals(administratzailea2.getErabiltzaileaIzena());
        result = result && administratzailea.getPertsonarenIzena().equals(administratzailea2.getPertsonarenIzena());
        result = result && administratzailea.getAbizena().equals(administratzailea2.getAbizena());
        result = result && administratzailea.getPasahitza().equals(administratzailea2.getPasahitza());
        result = result && administratzailea.getKorreoa().equals(administratzailea2.getKorreoa());
        result = result && administratzailea.getAdministratzaileKodea().equals(administratzailea2.getAdministratzaileKodea());
        assertTrue(result);

    }
}