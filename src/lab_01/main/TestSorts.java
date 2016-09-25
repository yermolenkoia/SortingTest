package lab_01.main;


import lab_01.filler.ArrayFiller;
import lab_01.filler.ArrayFillerDetect;
import lab_01.sorting.SortDetect;
import lab_01.sorting.Sorting;
import lab_01.spreadsheetfiller.SpreadSheetFiller;
import org.reflections.Reflections;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * form data structures with fillers and sorts, and causes all instances of sort classes and fill fillers classes
 * @author Yermolenko I.A.
 * @version 0.1
 * @since 2015-11-02
 */
public class TestSorts{
    private Map <String, Map> table = new HashMap<>();

    /**
     * creates data structures with arrays and sorts, tests sorts, adds results in spreadsheet
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws InvocationTargetException
     * @throws IOException
     * @throws ClassNotFoundException
     */

    public void test() throws IllegalAccessException, InstantiationException, InvocationTargetException, IOException,
            ClassNotFoundException {
        ArrayList<Sorting> sorters = new ArrayList<>();
        Map<String, int []> fillers = new HashMap<>();
        fillArrays(fillers);
        fillSortersList(sorters);
        Map<String, int []> tmp = newIntArrayGenerator(fillers);
        for (Sorting sorter : sorters){
            Map <String, Long> arrMap = new HashMap<>();
            fillers.forEach((k, v) -> arrMap.put(k, sorter.getTime(v)));
            fillers = newIntArrayGenerator(tmp);
            table.put(sorter.toString(), arrMap);
        }
        outputInSpreadSheet();
    }

    /**
     *
     * @param map - map that consist names of arrays fillers and int[] arrays, that consist sorted arrays
     * @return map with names of arrays fillers and int [] arrays, that filling them with different ways
     */
    private Map<String, int []> newIntArrayGenerator (Map <String, int[]> map){
        Map <String, int[]> tmpMap = new HashMap<>();
        int k = 0;
        int [][] tmpArr = new int[map.size()][];
        for (Map.Entry<String, int[]> entry : map.entrySet() ){
            tmpArr[k] = new int[entry.getValue().length];
            for(int i = 0; i < entry.getValue().length; i++){
                tmpArr[k][i] = entry.getValue()[i];
            }
            tmpMap.put(entry.getKey(), tmpArr[k]);
            k++;
        }
        return tmpMap;

    }

    /**
     * fills map with names of arrays fillers and various types arrays
     * @param fillers - empty <String, int[]> map
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    private void fillArrays(Map <String, int []> fillers) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        Reflections reflections = new Reflections("lab_01.filler");
        Set<Class<?>> implementing = reflections.getTypesAnnotatedWith(ArrayFillerDetect.class);
        ArrayList <ArrayFiller> fillersList = new ArrayList<>();
        for (Class<?> filler : implementing) {
            fillersList.add((ArrayFiller)filler.newInstance());
        }
        for (ArrayFiller filler : fillersList){
            int [] arr = new int[100];
            filler.fillArray(arr);
            fillers.put(filler.toString(), arr);
        }
    }

    /**
     * fill ArrayList with various types of arrays
     * @param sorters - empty <Sorting> ArrayList
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private void fillSortersList(ArrayList<Sorting> sorters) throws InstantiationException, IllegalAccessException, IOException, ClassNotFoundException {
        //By downloaded tools
        Reflections reflections = new Reflections("lab_01.sorting");

        Set<Class<?>> implementing = reflections.getTypesAnnotatedWith(SortDetect.class);

        for (Class<?> sorter : implementing) {
            sorters.add((Sorting)sorter.newInstance());
        }
    }

    /**
     * output results of sort testing in spreadsheet
     * @throws IOException
     */
    private void outputInSpreadSheet() throws IOException {
        String [] columns = null;
        Object [][] data = new Object[table.size()][];
        int i = 0;
        boolean columnsFill = false;
        for (Map.Entry <String, Map> entry: table.entrySet()){
            String key = entry.getKey();
            Map <String, Long> map = entry.getValue();
            data[i] = new Object[map.size()+1];
            if (!columnsFill){
                int y = 0;
                columnsFill = true;
                columns = new String[map.size() + 1];
                columns[y++] = " ";
                for (Map.Entry<String, Long> innerEntry : map.entrySet()){
                    columns[y++] = innerEntry.getKey();
                }
            }
            int i2 = 0;
            data[i][i2++] = key;
            for (Map.Entry<String, Long> entry2 : map.entrySet()){
                data[i][i2++] = entry2.getValue();
            }
            i++;
        }
        if (columns != null) {
            new SpreadSheetFiller().makeSpreadSheet(data, columns);
        }
    }
}
