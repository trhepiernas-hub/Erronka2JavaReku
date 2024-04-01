package saskibaloia.modeloak;




public class JokalariaModeloa extends ErabiltzaileaModeloa {

	private String jokalariKodea;
	private String dorsalZenbakia;

	public ErabiltzaileaModeloa getErabiltzailea() {
		return new ErabiltzaileaModeloa(this.getIdErabiltzailea(), this.getErabiltzaileaIzena(),
				this.getPertsonarenIzena(), this.getAbizena(), this.getPasahitza(), this.getKorreoa());
	}

	public JokalariaModeloa(String jokalariKodea, String dorsalZenbakia, ErabiltzaileaModeloa Erabiltzailea) {
		super(Erabiltzailea);
		this.jokalariKodea = jokalariKodea;
		this.dorsalZenbakia = dorsalZenbakia;
	}

	public JokalariaModeloa() {
	}

	public String getJokalariKodea() {
		return jokalariKodea;
	}

	public void setJokalariKodea(String jokalariKodea) {
		this.jokalariKodea = jokalariKodea;
	}

	public String getDorsalZenbakia() {
		return dorsalZenbakia;
	}

	public void setDorsalZenbakia(String dorsalZenbakia) {
		this.dorsalZenbakia = dorsalZenbakia;
	}

	public JokalariaModeloa(Long idErabiltzailea, String erabiltzaileaIzena, String pertsonarenIzena, String abizena,
			String pasahitza, String korreoa, String jokalariKodea, String dorsalZenbakia) {
		super(idErabiltzailea, erabiltzaileaIzena, pertsonarenIzena, abizena, pasahitza, korreoa);
		this.jokalariKodea = jokalariKodea;
		this.dorsalZenbakia = dorsalZenbakia;
	}

}