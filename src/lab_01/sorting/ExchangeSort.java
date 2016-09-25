package lab_01.sorting;

/**
 * @author Yermolenko I.A.
 * @version 0.1
 * @since 2015-11-02
 * */
@SortDetect("Exchange")
public class ExchangeSort extends Sorting {
    /**
     * {@link Sorting#toString()}
     * @return - name of sorting
     */
    public String toString(){
        return "Exchange";
    }
    /**
     * {@link Sorting#sort(int[])}
     * @param arr - array, that have to sort
     */
    protected void sort(int [] arr){
        int left = 1;
        int right = arr.length - 1;

        while (left <= right) {
            for (int i = right; i >= left; i--) {
                if (arr[i - 1] > arr[i]) {
                    swap(arr, i - 1, i);
                }
            }
            left++;
            for (int i = left; i <= right; i++) {
                if (arr[i - 1] > arr[i]) {
                    swap(arr, i - 1, i);
                }
            }
            right--;
        }
    }
    /**
     * swaps two element
     * @param array - elements of this array will exchange with each other
     * @param i - index of first element
     * @param j - index of second element
     */
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
