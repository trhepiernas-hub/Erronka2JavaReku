package saskibaloia.modeloak.tablak;

import javax.swing.table.DefaultTableModel;
import java.lang.reflect.Field;

public class TablaModelCreator{

    /**
     *  Funtzio honek pasatako objetuaren klasearen DefaultTableModel bat sortuko du, datuak emanda
     *  @param data objecto motako datua,
     *  @return sortutako DefaultTableModel-a
     */
    public static DefaultTableModel createTableModel(Object data) {
        Class<?> klasea = data.getClass();
        Field[] fields = klasea.getDeclaredFields();
        String[] columnNames = new String[fields.length];
        for (int i = 0; i < fields.length; i++) {
            columnNames[i] = fields[i].getName();
            System.out.println(columnNames[i]);
        }

        DefaultTableModel a = new DefaultTableModel(null ,columnNames);
        a.addRow(new Object[fields.length]);
        return a;

    }

}
