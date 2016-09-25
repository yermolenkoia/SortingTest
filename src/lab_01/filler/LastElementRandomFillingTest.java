package lab_01.filler;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by igor on 19.11.15.
 */
public class LastElementRandomFillingTest {
    private static ArrayFiller filler;
    @Before
    public void setUp() throws Exception {
        filler = new LastElementRandomFilling();
    }

    @Test
    public void testFillArray(){
        int [] i = new int [1] ;
        filler.fillArray(i);
    }
}