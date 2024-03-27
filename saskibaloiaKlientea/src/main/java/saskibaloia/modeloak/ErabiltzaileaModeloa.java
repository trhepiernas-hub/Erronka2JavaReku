package saskibaloia.modeloak;



public class ErabiltzaileaModeloa {


    private Long idErabiltzailea;

    /** Erabiltzailearen Izena */
    private String erabiltzaileaIzena;

    /** Pertsonaren Izena */
    private String pertsonarenIzena;

    /** Pertsonaren abizena */
    private String abizena;

    /** Erabiltzailearen pasahitza PASSWORD_BCRYPT hashseatuta */
    private String pasahitza;

    /** Erabiltzailearen korreoa */
    private String korreoa;

    public Long getIdErabiltzailea() {
        return idErabiltzailea;
    }

    public void setIdErabiltzailea(Long idErabiltzailea) {
        this.idErabiltzailea = idErabiltzailea;
    }

    public String getErabiltzaileaIzena() {
        return erabiltzaileaIzena;
    }

    public void setErabiltzaileaIzena(String erabiltzaileaIzena) {
        this.erabiltzaileaIzena = erabiltzaileaIzena;
    }

    public String getPertsonarenIzena() {
        return pertsonarenIzena;
    }

    public void setPertsonarenIzena(String pertsonarenIzena) {
        this.pertsonarenIzena = pertsonarenIzena;
    }

    public String getAbizena() {
        return abizena;
    }

    public void setAbizena(String abizena) {
        this.abizena = abizena;
    }

    public String getPasahitza() {
        return pasahitza;
    }

    public void setPasahitza(String pasahitza) {
        this.pasahitza = pasahitza;
    }

    public String getKorreoa() {
        return korreoa;
    }

    public void setKorreoa(String korreoa) {
        this.korreoa = korreoa;
    }

    public ErabiltzaileaModeloa(Long idErabiltzailea, String erabiltzaileaIzena, String pertsonarenIzena, String abizena,
                                String pasahitza, String korreoa) {

        this.idErabiltzailea = idErabiltzailea;
        this.erabiltzaileaIzena = erabiltzaileaIzena;
        this.pertsonarenIzena = pertsonarenIzena;
        this.abizena = abizena;
        this.pasahitza = pasahitza;
        this.korreoa = korreoa;
    }

    public ErabiltzaileaModeloa() {
    }

    public ErabiltzaileaModeloa(ErabiltzaileaModeloa erabiltzailea) {
        this.setIdErabiltzailea(erabiltzailea.getIdErabiltzailea());
        this.setErabiltzaileaIzena(erabiltzailea.getErabiltzaileaIzena());
        this.setPertsonarenIzena(erabiltzailea.getPertsonarenIzena());
        this.setAbizena(erabiltzailea.getAbizena());
        this.setPasahitza(erabiltzailea.getPasahitza());
        this.setKorreoa(erabiltzailea.getKorreoa());
    }



}
