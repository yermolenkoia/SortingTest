package lab_01.sorting;

import java.util.Hashtable;

/**
 * @author Yermolenko I.A.
 * @version 0.1
 * @since 2015-11-02
 * */
@SortDetect("Merge")
public class MergeSort extends Sorting{
    /**
     * {@link Sorting#toString()}
     * @return - name of sorting
     */
    public String toString(){
        return "Merge";
    }
    /**
     * {@link Sorting#sort(int[])}
     * @param arr - array, that have to sort
     */
    protected void sort(int [] arr){
        mergeSort(arr, 0, arr.length);
    }

    /**
     * realisation of merge sorting, first phase
     * @param arr - array to sort
     * @param begin - first index
     * @param end - last index
     */
    private void mergeSort(int[] arr, int begin, int end) {
        if (begin < end) {
            mergeSort(arr, begin, (begin + end) / 2);
            mergeSort(arr, (begin + end) / 2 + 1, end);
            merge(arr, begin, end);
        }
    }

    /**
     * realisation of merge sorting, first phase
     * @param arr - array to sort
     * @param begin - first index
     * @param end - last index
     */
    private void merge(int[] arr, int begin, int end) {
        int middle;
        int first = begin;
        int last;
        Hashtable<Integer, Integer> tempArray = new Hashtable<>();
        middle = (begin + end) / 2;
        last = middle;
        for (int i = begin; i < end; i++) {
            if ((first < middle) && ((last >= end) ||
                    (arr[first] < arr[last]))) {
                tempArray.put(i, arr[first]);
                first++;
            }
            else {
                tempArray.put(i, arr[last]);
                last++;
            }
        }
        for (int i = begin; i < end; i++) {
            arr[i] = tempArray.get(i);
        }
    }
}
