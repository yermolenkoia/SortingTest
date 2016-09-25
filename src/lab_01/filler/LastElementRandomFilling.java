package lab_01.filler;

import java.util.Random;

/**
 * class implement ordered fill of array with last random element
 * @author Yermolenko I.A.
 * @version 0.1
 * @since 2015-11-02
 */
@ArrayFillerDetect("Last Random")
public class LastElementRandomFilling extends ArrayFiller{
    /**
     * {@link ArrayFiller#fillArray(int[])}
     * @param arr - filling this array
     */
    public void fillArray (int [] arr){
        for (int i = 0; i < arr.length; i++){
            if (i == arr.length - 1){
                arr[i] = new Random().nextInt(i);
            } else {
                arr[i] = i;
            }

        }
    }
    /**
     * {@link ArrayFiller#toString()}
     * @return name of filling type
     */
    public String toString(){
        return "Last Random";
    }
}
