package lab_01.sorting;

/**
 * @author Yermolenko I.A.
 * @version 0.1
 * @since 2015-11-02
 */
@SortDetect("Ascending Bubble")
public class AscendingBubbleSort extends BubbleSort {
    /**
     * compare two integer
     * @param left - first integer
     * @param right - second
     * @return true if left > right, in other cases - false
     */
    protected boolean compare(int left, int right){
        return (left > right);
    }
    /**
     * {@link Sorting#toString()}
     * @return - name of sorting
     */
    public String toString(){
        return "Ascending bubble";
    }
}
