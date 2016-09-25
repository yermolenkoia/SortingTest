package lab_01.spreadsheetfiller;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;


public class SpreadSheetFillerTest {
    private static SpreadSheetFiller spreadSheetFiller;
    private static Object [][] a = {{"abc", 20, 127831, 329103 },{"test", 80, 29310, 90}};
    private static String [] b;
    @BeforeClass
    //    @After
    public static void setUp(){
        spreadSheetFiller = new SpreadSheetFiller();
        b = new String[]{"abc", "asd"};
    }

    @Test
//    @Test(timeout = 2)
//    @Test(expected = NullPointerException.class)
    public void testPrint() throws Exception {
        spreadSheetFiller.makeSpreadSheet(a, b);
    }

    @Test(expected = IOException.class)
    public void open(){

    }

    @Test
    public void asd1(){

    }
}