package saskibaloia.modeloak;


import java.util.Date;

public class BerriaModeloa {

	private Long idBerria;

	/** Berriaren izenburua */
	private String izenburua;

	/** Berriaren irudiaren Linka */
	private String irudia;

	/** Berriaren textua */
	private String textua;

	/** Berriaren agitaratutako data */
	private Date data;

	public BerriaModeloa(Long idBerria, String izenburua, String irudia, String textua, Date data) {
		this.idBerria = idBerria;
		this.izenburua = izenburua;
		this.irudia = irudia;
		this.textua = textua;
		this.data = data;
	}

	public BerriaModeloa() {
	}

	public Long getidBerria() {
		return idBerria;
	}

	public void setidBerria(Long idBerria) {
		this.idBerria = idBerria;
	}

	public String getizenburua() {
		return izenburua;
	}

	public void setizenburua(String izenburua) {
		this.izenburua = izenburua;
	}

	public String getirudia() {
		return irudia;
	}

	public void setirudia(String irudia) {
		this.irudia = irudia;
	}

	public String gettextua() {
		return textua;
	}

	public void settextua(String textua) {
		this.textua = textua;
	}

	public Date getdata() {
		return data;
	}

	public void setdata(Date data) {
		this.data = data;
	}
}