package lab_01.spreadsheetfiller;

import org.jopendocument.dom.OOUtils;
import org.jopendocument.dom.spreadsheet.SpreadSheet;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.io.File;
import java.io.IOException;

/**
 * class outputting table, that consist time for each kind of sorting and array fill in *.ods file
 * consist only one method makeSpreadSheet
 * @author Yermolenko I.A.
 * @version 0.1
 * @since 2015-11-4
 */
public class SpreadSheetFiller {
    /**
     * make a *.ods file and open it
     * for method realisation using jOpenDocument library
     * @param data - table consist information about sorting-time for each kind of array fill
     * @param columns - headline for columns
     * @throws IOException
     */
    
    public void makeSpreadSheet(Object [][] data, String [] columns) throws IOException {
        TableModel model = new DefaultTableModel(data, columns);
        // Save the data to an ODS file and open it.
        final File file = new File("spreadsheet.ods");
        SpreadSheet.createEmpty(model).saveAs(file);
        OOUtils.open(file);
    }
}
