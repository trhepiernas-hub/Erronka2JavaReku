package saskibaloia.modeloak;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BazkideaModeloa extends ErabiltzaileaModeloa {

	/** Bazkideak kontua sortu duen data */
	private String kontuSortzeData;

	public BazkideaModeloa(String kontuSortzeData, ErabiltzaileaModeloa erabiltzailea) {
		super(erabiltzailea);
		this.kontuSortzeData = kontuSortzeData;

	}

	public ErabiltzaileaModeloa getErabiltzailea() {
		return new ErabiltzaileaModeloa(this.getIdErabiltzailea(), this.getErabiltzaileaIzena(),
				this.getPertsonarenIzena(), this.getAbizena(), this.getPasahitza(), this.getKorreoa());
	}


	public String getkontuSortzeData() {
        return kontuSortzeData;
	}

	public void setkontuSortzeData(String kontuSortzeData) {
		this.kontuSortzeData = kontuSortzeData;
	}

	public void setErabiltzailea(ErabiltzaileaModeloa erabiltzailea) {
		super.setIdErabiltzailea(erabiltzailea.getIdErabiltzailea());
		super.setErabiltzaileaIzena(erabiltzailea.getErabiltzaileaIzena());
		super.setPertsonarenIzena(erabiltzailea.getPertsonarenIzena());
		super.setAbizena(erabiltzailea.getAbizena());
		super.setPasahitza(erabiltzailea.getPasahitza());
		super.setKorreoa(erabiltzailea.getKorreoa());
	}

	public BazkideaModeloa() {
	}
}