package lab_01.filler;

/**
 * class implement ordered fill of array
 * @author Yermolenko I.A.
 * @version 0.1
 * @since 2015-11-02
 */
@ArrayFillerDetect("Ordered")
public class OrderFilling extends ArrayFiller {
    /**
     * {@link ArrayFiller#fillArray(int[])}
     * @param arr - filling this array
     */
    public void fillArray(int [] arr){
        for (int i = 0; i < arr.length; i++){
            arr[i] = i;
        }
    }
    /**
     * {@link ArrayFiller#toString()}
     * @return name of filling type
     */
    public String toString(){
        return "Order";
    }
}
