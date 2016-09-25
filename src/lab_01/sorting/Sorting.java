package lab_01.sorting;

/**
 * abstract class for classes, that implementing various sorting realisation
 * @author Yermolenko I.A.
 * @version 0.1
 * @since 2015-11-02
 */
public abstract class Sorting {
    /**
     * method for sorting realisation
     * @param arr - array, that have to sort
     */
    abstract protected void sort(int [] arr);

    /**
     * @return - name of sorting
     */
    public abstract String toString();
    /**
     * for measure execute time using System.nanoTime()
     * @param arr - array for sort
     * @return sort execute time
     */
    public long getTime(int [] arr){
        long begin = System.nanoTime();
        sort(arr);
        long end = System.nanoTime();
        return (end-begin);
    }
}
