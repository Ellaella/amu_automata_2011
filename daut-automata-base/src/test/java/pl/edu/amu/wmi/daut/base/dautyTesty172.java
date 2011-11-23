package pl.edu.amu.wmi.daut.base;

import junit.framework.TestCase;
/*
 * Klasa testujaca FirstAcceptedString.
 */


public class TestFirstAcceptedString extends TestCase {

    public final void testFirstAcceptedStringEmpty(){
        NaiveAutomatonSpecification spec = new NaiveAutomatonSpecification();
        State s0 = spec.addState();
        spec.markAsInitial (s0);
        spec.marAsFinal (s0);
        assertTrue(spec.firstAcceptedString(), '');
    }

    public final void testFirstAcceptedStringA1(){
        NaiveAutomatonSpecification spec = new NaiveAutomatonSpecification();
        State s0 = spec.addState();
        State s1 = spec.addState();
        State s2 = spec.addState();
        State s3 = spec.addState();
        State s4 = spec.addState();
        State s5 = spec.addState();
        State s6 = spec.addState();
        State s7 = spec.addState();
        spec.addTransition(s0, s1, new CharTransitionLabel('a'));
        spec.addTransition(s1, s2, new CharTransitionLabel('a'));
        spec.addTransition(s2, s3, new CharTransitionLabel('a'));
        spec.addTransition(s3, s4, new CharTransitionLabel('a'));
        spec.addTransition(s4, s5, new CharTransitionLabel('a'));
        spec.addTransition(s5, s6, new CharTransitionLabel('a'));
        spec.addTransition(s0, s7, new CharTransitionLabel('b'));
        spec.markAsInitial (s0);
        spec.marAsFinal (s7);
        assertTrue(spec.firstAcceptedString(), 'b');
    }

    public final void testFirstAcceptedStringA2(){
        NaiveAutomatonSpecification spec = new NaiveAutomatonSpecification();
        State s0 = spec.addState();
        State s1 = spec.addState();
        State s2 = spec.addState();
        spec.addTransition(s0, s1, new CharTransitionLabel('a'));
        spec.addTransition(s1, s1, new CharTransitionLabel('a'));
        spec.addTransition(s0, s2, new CharTransitionLabel('b'));
        spec.markAsInitial (s0);
        spec.marAsFinal (s2);
        assertTrue(spec.firstAcceptedString(), 'b');
    }


    public final void testFirstAcceptedStringA3(){
        NaiveAutomatonSpecification spec = new NaiveAutomatonSpecification();
        State s0 = spec.addState();
        State s1 = spec.addState();
        State s2 = spec.addState();
        State s3 = spec.addState();
        State s4 = spec.addState();
        State s5 = spec.addState();
        State s6 = spec.addState();
        spec.addTransition(s0, s1, new CharTransitionLabel('a'));
        spec.addTransition(s0, s2, new CharTransitionLabel('b'));
        spec.addTransition(s0, s3, new CharTransitionLabel('c'));
        spec.addTransition(s1, s4, new CharTransitionLabel('a'));
        spec.addTransition(s2, s5, new CharTransitionLabel('c'));
        spec.addTransition(s4, s5, new CharTransitionLabel('z'));
        spec.addTransition(s3, s6, new CharTransitionLabel('a'));
        spec.addTransition(s5, s6, new CharTransitionLabel('a'));
        spec.addTransition(s6, s3, new CharTransitionLabel('a'));
        spec.markAsInitial (s0);
        spec.marAsFinal (s6);
        assertTrue(spec.firstAcceptedString(), 'aaza');
    }

    public final void testFirstAcceptedStringA4(){
        NaiveAutomatonSpecification spec = new NaiveAutomatonSpecification();
        State s0 = spec.addState();
        State s1 = spec.addState();
        State s2 = spec.addState();
        State s3 = spec.addState();
        spec.addTransition(s0, s1, new CharTransitionLabel('a'));
        spec.addTransition(s1, s0, new CharTransitionLabel('a'));
        spec.addTransition(s1, s2, new CharTransitionLabel('b'));
        spec.addTransition(s2, s1, new CharTransitionLabel('b'));
        spec.addTransition(s2, s3, new CharTransitionLabel('a'));
        spec.addTransition(s3, s2, new CharTransitionLabel('a'));
        spec.addTransition(s0, s3, new CharTransitionLabel('b'));
        spec.addTransition(s3, s0, new CharTransitionLabel('b'));
        spec.markAsInitial (s0);
        spec.marAsFinal (s3);
        assertTrue(spec.firstAcceptedString(), 'aba');
    }

    public final void testFirstAcceptedStringA5(){
        NaiveAutomatonSpecification spec = new NaiveAutomatonSpecification();
        State s0 = spec.addState();
        State s1 = spec.addState();
        State s2 = spec.addState();
        State s3 = spec.addState();
        spec.addTransition(s0, s1, new CharTransitionLabel('a'));
        spec.addTransition(s0, s2, new CharTransitionLabel('a'));
        spec.addTransition(s0, s3, new CharTransitionLabel('c'));
        spec.addTransition(s1, s2, new CharTransitionLabel('a'));
        spec.addTransition(s1, s0, new CharTransitionLabel('b'));
        spec.addTransition(s2, s0, new CharTransitionLabel('a'));
        spec.markAsInitial (s0);
        spec.marAsFinal (s3);
        assertTrue(spec.firstAcceptedString(), '');
    }
}