package saskibaloia.modeloak;

public class AdmnistratzaileaModeloa extends ErabiltzaileaModeloa {

    private String administratzaileKodea;

    public ErabiltzaileaModeloa getErabiltzailea() {
        return new ErabiltzaileaModeloa(this.getIdErabiltzailea(), this.getErabiltzaileaIzena(),
                this.getPertsonarenIzena(), this.getAbizena(), this.getPasahitza(), this.getKorreoa());
    }

    public AdmnistratzaileaModeloa(ErabiltzaileaModeloa erabiltzailea, String administratzaileKodea) {
        super(erabiltzailea);
        this.administratzaileKodea = administratzaileKodea;
    }

    public AdmnistratzaileaModeloa() {
    }

    public String getAdministratzaileKodea() {
        return administratzaileKodea;
    }

    public void setAdministratzaileKodea(String administratzaileKodea) {
        this.administratzaileKodea = administratzaileKodea;
    }

}
