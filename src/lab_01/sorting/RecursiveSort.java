package lab_01.sorting;

/**
 * implement recursive sorting
 * @author Yermolenko I.A.
 * @version 0.1
 * @since 2015-11-02
 * */
@SortDetect("Recursive")
public class RecursiveSort extends Sorting {
    /**
     * swaps two element
     * @param array - elements of this array will exchange with each other
     * @param i - index of first element
     * @param j - index of second element
     */
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    /**
     * {@link Sorting#toString()}
     * @return - name of sorting
     */
    public String toString(){
        return "Recursive";
    }
    /**
     * {@link Sorting#sort(int[])}
     * @param arr - array, that have to sort
     */
    protected void sort(int [] arr){
        recSort(arr, 0, arr.length - 1);
    }

    /**
     * realisation of recursive sorting
     * @param arr - array, that need to sort
     * @param left - left index
     * @param right - right index
     */
    private void recSort(int [] arr, int left, int right){
        int middle = arr [(left + right)/2];
        int i = left, j = right;
        while (i <= j){
            while (arr[i] < middle){
                i++;
            }
            while (arr[j] > middle){
                j--;
            }
            if (i <= j){
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        if (left < j){
            recSort(arr, left, j);
        }
        if (i < right){
            recSort(arr, i, right);
        }
    }
}
