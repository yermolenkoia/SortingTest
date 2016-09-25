package lab_01.sorting;

import java.util.Arrays;

/**
 * @author Yermolenko I.A.
 * @version 0.1
 * @since 2015-11-02
 * */
@SortDetect("Standard")
public class StandardSorting extends Sorting {
    /**
     * {@link Sorting#sort(int[])}
     * @param arr - array, that have to sort
     */
    @Override
    protected void sort(int[] arr) {
        Arrays.sort(arr);
    }

    /**
     * {@link Sorting#toString()}
     * @return - name of sorting
     */
    public String toString(){
        return "Standard";
    }
}