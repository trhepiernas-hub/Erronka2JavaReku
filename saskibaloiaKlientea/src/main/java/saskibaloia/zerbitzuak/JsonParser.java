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
    public static BazkideaModeloa parseBazkidea(JsonObject json) {
        Gson gson = new Gson();
        return gson.fromJson(json, BazkideaModeloa.class);
    }

    /**
     * Funtzio honek Api-tik iritsitako administratzailearen JSON-a parseatzen du
     * @param json Administratzailearen datuekin json bat
     * @return AdmnistratzaileaModeloa objektua
     */
    public static AdmnistratzaileaModeloa parseAdmin(JsonObject json) {
        Gson gson = new Gson();
        return gson.fromJson(json, AdmnistratzaileaModeloa.class);
    }

    /**
     * Funtzio honek Api-tik iritsitako jokalariaren JSON-a parseatzen du
     * @param json Jokalariaren datuekin json bat
     * @return JokalariaModeloa objektua
     */
    public static JokalariaModeloa parseJokalaria(JsonObject json) {
        Gson gson = new Gson();
        return gson.fromJson(json, JokalariaModeloa.class);
    }

    public static BerriaModeloa parseBerria(JsonObject json) {
        Gson gson = new Gson();
        return gson.fromJson(json, BerriaModeloa.class);
    }
}
