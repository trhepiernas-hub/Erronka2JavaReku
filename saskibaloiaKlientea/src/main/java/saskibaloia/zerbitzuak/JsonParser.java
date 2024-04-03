package saskibaloia.zerbitzuak;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import saskibaloia.modeloak.AdmnistratzaileaModeloa;
import saskibaloia.modeloak.BazkideaModeloa;
import saskibaloia.modeloak.BerriaModeloa;
import saskibaloia.modeloak.JokalariaModeloa;

public class JsonParser {

    /**
     * Funtzio honek Api-tik iritsitako bazkidearen JSON-a parseatzen du
     * @param json Bazkidearen datuekin json bat
     * @return BazkideaModeloa objektua
     */
    public BazkideaModeloa parseBazkidea(JsonObject json) {
        Gson gson = new Gson();
        return gson.fromJson(json, BazkideaModeloa.class);
    }

    /**
     * Funtzio honek bazkidea parseatzen du eta JSON bat bueltatzen du
     * @param bazkidea BazkideaModeloa objektua
     * @return BazkideaModeloa objektua JSON formatuan
     */
    public String parseBazkidea(BazkideaModeloa bazkidea) {
        Gson gson = new Gson();
        return gson.toJson(bazkidea);
    }

    /**
     * Funtzio honek Api-tik iritsitako administratzailearen JSON-a parseatzen du
     * @param json Administratzailearen datuekin json bat
     * @return AdmnistratzaileaModeloa objektua
     */
    public AdmnistratzaileaModeloa parseAdmin(JsonObject json) {
        Gson gson = new Gson();
        return gson.fromJson(json, AdmnistratzaileaModeloa.class);
    }

    /**
     * Funtzio honek administratzailea parseatzen du eta JSON bat bueltatzen du
     * @param admin AdmnistratzaileaModeloa objektua
     * @return AdmnistratzaileaModeloa objektua JSON formatuan
     */
    public String parseAdmin(AdmnistratzaileaModeloa admin) {
        Gson gson = new Gson();
        return gson.toJson(admin);
    }


    /**
     * Funtzio honek Api-tik iritsitako jokalariaren JSON-a parseatzen du
     * @param json Jokalariaren datuekin json bat
     * @return JokalariaModeloa objektua
     */
    public JokalariaModeloa parseJokalaria(JsonObject json) {
        Gson gson = new Gson();
        return gson.fromJson(json, JokalariaModeloa.class);
    }

    /**
     * Funtzio honek jokalaria parseatzen du eta JSON bat bueltatzen du
     * @param jokalaria JokalariaModeloa objektua
     * @return JokalariaModeloa objektua JSON formatuan
     */
    public String parseJokalaria(JokalariaModeloa jokalaria) {
        Gson gson = new Gson();
        return gson.toJson(jokalaria);
    }

    /**
     * Funtzio honek Api-tik iritsitako berriaren JSON-a parseatzen du
     * @param json Berriaren datuekin json bat
     * @return BerriaModeloa objektua
     */
    public BerriaModeloa parseBerria(JsonObject json) {
        Gson gson = new Gson();
        return gson.fromJson(json, BerriaModeloa.class);
    }

    /**
     * Funtzio honek berria parseatzen du eta JSON bat bueltatzen du
     * @param berria BerriaModeloa objektua
     * @return BerriaModeloa objektua JSON formatuan
     */
    public String parseBerria(BerriaModeloa berria) {
        Gson gson = new Gson();
        return gson.toJson(berria);
    }
}
