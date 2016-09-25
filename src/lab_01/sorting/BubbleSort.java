package lab_01.sorting;

/**
 * @author Yermolenko I.A.
 * @version 0.1
 * @since 2015-11-02
 */
public abstract class BubbleSort extends Sorting {
    /**
     * {@link Sorting#sort(int[])}
     * @param arr - array, that have to sort
     */
    @Override
    protected void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (compare(arr[j], arr[j + 1])) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * compare two integer
     * @param left - first integer
     * @param right - second
     * @return true or false
     */
    protected abstract boolean compare(int left, int right);
}
