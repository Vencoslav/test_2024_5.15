import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class TabulkaModel extends AbstractTableModel {
    private List<SoutezniPar> sezanamParu = new ArrayList<>();

    @Override
    public int getRowCount() {
        return sezanamParu.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        SoutezniPar par = sezanamParu.get(rowIndex);
        switch (columnIndex){
            case 0:
                par.getStartovniCislo();
            case 1:
                par.getDatum();
            case 2:
                par.getJmeno();
            case 3:
                par.getDivokaKarta();

        }
        return null;
    }
}