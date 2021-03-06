package pl.edu.amu.wmi.daut.base;

import junit.framework.TestCase;

/**
 * Klasa testujaca BeginingOfTextOrLineTransitionLabel.
 */
public class TestBeginingOfTextOrLineTransitionLabel extends TestCase {
    /**
     * testy.
     */
    public final void testBeginingOfTextOrLineTransitionLabel() {
        TransitionLabel t = new BeginingOfTextOrLineTransitionLabel();

        //pozycja<0
       try {
            t.doCheckContext("wtf", -7);
            fail();
        } catch (PositionOutOfStringBordersException e) {
            assertTrue(true);
        }
        //pozycja>dlugoscSlowa
        try {
            t.doCheckContext("brlium\ntak", 15);
            fail();
        } catch (PositionOutOfStringBordersException e) {
            assertTrue(true);
        }
        //pozycja>dlugoscSlowa
        try {
            t.doCheckContext("srutututu", 10);
            fail();
        } catch (PositionOutOfStringBordersException e) {
            assertTrue(true);
        }

        //slowoPuste
        assertTrue(t.doCheckContext("", 0));
        //pozycja==0
        assertTrue(t.doCheckContext("pampararam", 0));
        //na nie-poczatku wiersza
        assertFalse(t.doCheckContext("ja\nmhm", 4));
		//na poczatku wiersza
        assertTrue(t.doCheckContext("ja\nmhm", 3));
        //w srodku wiersza
        assertFalse(t.doCheckContext("baklazan", 5));
        //na poczatku wiersza
        //Sprawdzenie metody toString().
        //assertEquals(t.toString(), "EndOfTextOrLine");
    }
}
