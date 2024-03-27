package saskibaloia.ikuspegia.erabiltzailea;

import saskibaloia.modeloak.ErabiltzaileaModeloa;
import saskibaloia.modeloak.tablak.TablaModelCreator;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TablaPanel extends JFrame  {

    static JPanel panel = new JPanel();
    JTable tabla = null;
    static JScrollPane scroll;

//    public TablaPanel() {
//        super("Tabla de usuarios");
//        sortuScrollTabla();
//        getContentPane().add(scroll);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    }

    public static JScrollPane sortuTabla() {
        return new TablaPanel().sortuScrollTabla();
    }

    private JScrollPane sortuScrollTabla() {
        DefaultTableModel dtm = TablaModelCreator.createTableModel(new ErabiltzaileaModeloa());

        dtm.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE && e.getLastRow() == dtm.getRowCount() - 1
                        && dtm.getValueAt(e.getLastRow(), 5) != null) {
                    dtm.addRow(new Object[dtm.getColumnCount()]); // Agrega una nueva fila vacía
                }
            }
        });
        tabla = new JTable(dtm);
        tabla.setPreferredScrollableViewportSize(new Dimension(500, 70));

        scroll = new JScrollPane(tabla);

        return scroll;
    }

    public static void main(String[] args) {
        TablaPanel frame = new TablaPanel();
        frame.pack();
        frame.setVisible(true);
    }
}
