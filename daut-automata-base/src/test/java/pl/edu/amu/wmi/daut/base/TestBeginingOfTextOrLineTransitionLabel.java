package pl.edu.amu.wmi.daut.base;

import junit.framework.TestCase;

/**
 * Klasa testujaca BeginingOfTextOrLineTransitionLabel.
 *//*
public class TestBeginingOfTextOrLineTransitionLabel extends TestCase {

    public final void testEndOfTextOrLineTransitionLabel() {
        TransitionLabel t = new BeginingOfTextOrLineTransitionLabel();

        //hgw czy to trzeba
        assertFalse(t.canAcceptCharacter('a'));
        assertTrue(t.canBeEpsilon());
        assertFalse(t.isEmpty());
        assertTrue(t.isContextual());

        //Sprawdzenie poprawności metody checkContext().
        assertTrue(t.doCheckContext("", 0));
        assertFalse(t.doCheckContext("", 1));
        assertTrue(t.doCheckContext("ma\nka", 1));
        try {
            testowana.checkContext("ma\nka", 7);
            fail();
        } catch (PositionOutOfStringBordersException e) {
            assertTrue(true);
        }
        try {
            testowana.checkContext("ma\nka", -2);
            fail();
        } catch (PositionOutOfStringBordersException e) {
            assertTrue(true);
        }

        //Sprawdzenie metody toString().
        assertEquals(testowana.toString(), "EndOfTextOrLine");
    }
}

/*
  	  	 /**  Wyjątek który rzuca klasa BeginingOfTextOrLineTransitionLabel */
/*   	  	+class PositionOutOfStringBordersException extends RuntimeException { 
 * private static final long serialVersionUID = 1L;
   	  	+}
 
 * /* 	     @Override
 	     protected boolean doCheckContext(String s, int position) {
 	-        if (!s.isEmpty() && position == 0 || s.charAt(-1) == '\n') {
 	+        if ((s.length() < position) || (position < 0)) {
 	+            throw new PositionOutOfStringBordersException();
 	+        } else if (!s.isEmpty() && position == 0 || s.charAt(-1) == '\n') {
  	             return true;
  	         }
  	         return false;*/