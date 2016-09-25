package lab_01.filler;

/**
 * abstract class for classes, that filling arrays
 * @author Yermolenko I.A.
 * @version 0.1
 * @since 2015-11-01
 */
public abstract class ArrayFiller {
    /**
     * realisation of array filling
     * @param arr - filling this array
     */
    public abstract void fillArray(int[] arr);

    /**
     * @return - name of filling type
     */
    public abstract String toString();
}
