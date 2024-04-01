package saskibaloia.kontrolatzaileak;

import saskibaloia.zerbitzuak.ErabiltzaileZerbitzuak;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ErabiltzaileKontrolatzailea implements ActionListener {
    /**
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        ErabiltzaileZerbitzuak erabiltzaileZerbitzuak = new ErabiltzaileZerbitzuak();
        switch (e.getActionCommand()) {
            case "Kargatu Fitxategia" :
                erabiltzaileZerbitzuak.kargatuFitxategia();
                break;
            case "Gorde Fitxategira" :
                erabiltzaileZerbitzuak.GordeFitxategira();
                break;
            case "Exportatu Sql kodeara" :
                erabiltzaileZerbitzuak.exportatuSqlKodeara();
                break;
            case "Igo Datubasera" :
                erabiltzaileZerbitzuak.igoDatubasera();
                break;
            case "Aktualizatu Datubaseko datuak" :
                erabiltzaileZerbitzuak.aktualizatuDatubasekoDatuak();
                break;
        };
    }
}
