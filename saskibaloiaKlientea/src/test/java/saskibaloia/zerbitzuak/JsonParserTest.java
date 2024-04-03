package saskibaloia.zerbitzuak;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import saskibaloia.modeloak.AdmnistratzaileaModeloa;
import saskibaloia.modeloak.BazkideaModeloa;
import saskibaloia.modeloak.JokalariaModeloa;
import saskibaloia.zerbitzuak.JsonParser;
class JsonParserTest {

    private JsonParser jsonParser;
    private BazkideaModeloa bazkidea;
    private JokalariaModeloa jokalaria;
    private AdmnistratzaileaModeloa administratzailea;
    @BeforeEach
    void setUp() {
        jsonParser = new JsonParser();

        bazkidea = new BazkideaModeloa();
        bazkidea.setIdErabiltzailea(1L);
        bazkidea.setErabiltzaileaIzena("erabiltzaileaIzena");
        bazkidea.setPertsonarenIzena("pertsonarenIzena");
        bazkidea.setAbizena("abizena");
        bazkidea.setPasahitza("pasahitza");
        bazkidea.setKorreoa("korreoa");
        bazkidea.setkontuSortzeData(new java.util.Date());

        jokalaria = new JokalariaModeloa();
        jokalaria.setIdErabiltzailea(1L);
        jokalaria.setErabiltzaileaIzena("erabiltzaileaIzena");
        jokalaria.setPertsonarenIzena("pertsonarenIzena");
        jokalaria.setAbizena("abizena");
        jokalaria.setPasahitza("pasahitza");
        jokalaria.setKorreoa("korreoa");
        jokalaria.setDorsalZenbakia("12");
        jokalaria.setJokalariKodea("01");

        administratzailea = new AdmnistratzaileaModeloa();
        administratzailea.setIdErabiltzailea(1L);
        administratzailea.setErabiltzaileaIzena("erabiltzaileaIzena");
        administratzailea.setPertsonarenIzena("pertsonarenIzena");
        administratzailea.setAbizena("abizena");
        administratzailea.setPasahitza("pasahitza");
        administratzailea.setKorreoa("korreoa");
        administratzailea.setAdministratzaileKodea("01");
    }
    @Test
    void parseBazkidea() {
        String a = jsonParser.parseBazkidea(bazkidea);
        System.out.println(a);
    }

    @Test
    void testParseBazkidea() {
    }

    @Test
    void parseAdmin() {
    }

    @Test
    void testParseAdmin() {
    }

    @Test
    void parseJokalaria() {
    }

    @Test
    void testParseJokalaria() {
    }

    @Test
    void parseBerria() {
    }

    @Test
    void testParseBerria() {
    }
}