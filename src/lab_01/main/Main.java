package lab_01.main;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Yermolenko I.A.
 * @version 0.1
 * @since 2015-11-04
 */

public class Main {
    public static void main (String [] args) throws InvocationTargetException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        new TestSorts().test();
    }
}
