package saskibaloia.modeloak.tablak;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TablaModelCreator{

    /**
     *  Funtzio honek pasatako objetuaren klasearen DefaultTableModel bat sortuko du, datuak emanda
     *  @param data objecto motako datua,
     *  @return sortutako DefaultTableModel-a
     */
    public static DefaultTableModel createTableModel(Object data) {
        Class<?> klasea = data.getClass();
        List<Field> fields = new ArrayList<Field>();
        while (klasea != null) {
            fields.addAll(Arrays.asList(klasea.getDeclaredFields()));
            klasea = klasea.getSuperclass();
        }
        String[] columnNames = new String[fields.size()];
        for (int i = 0; i < fields.size(); i++) {
            columnNames[i] = fields.get(i).getName();
        }

        DefaultTableModel a;


            a = new DefaultTableModel(null ,columnNames);
            a.addTableModelListener(new TableModelListener() {
                @Override
                public void tableChanged(TableModelEvent e) {
                    if (e.getType() == TableModelEvent.UPDATE && e.getLastRow() == a.getRowCount() - 1
                            && a.getValueAt(e.getLastRow(), fields.size() -1) != null) {
                        a.addRow(new Object[a.getColumnCount()]); // Agrega una nueva fila vacía
                    }
                }
            });

        a.addRow(new Object[fields.size()]);
        return a;

    }

}
