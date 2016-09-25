package lab_01.filler;

import java.util.Random;

/**
 * class implement random fill of array
 * @author Yermolenko I.A.
 * @version 0.1
 * @since 2015-11-02
 */
@ArrayFillerDetect("Random")
public class RandomFilling extends ArrayFiller {
    /**
     * {@link ArrayFiller#fillArray(int[])}
     * @param arr - filling this array
     */
    public void fillArray(int [] arr){
        for (int i = 0; i < arr.length; i++){
            arr[i] = new Random().nextInt();
        }
    }
    /**
     * {@link ArrayFiller#toString()}
     * @return name of filling type
     */
    public String toString(){
        return "Random";
    }
}
