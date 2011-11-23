package pl.edu.amu.wmi.daut.base;

import junit.framework.TestCase;

/**
test metody FirstAcceptedWord
 */
public class TestFirstAcceptedWord extends TestCase{
    
	public final void testFirstAcceptedWordEmpty(){
	AutomatonSpecification a = new NaiveAutomatonSpecification();
	State s0 = a.addState();
	a.markAsInitial(s0);
	a.markAsFinal(s0);
	assertEquals(a.firstAcceptedWord(), "");
}
	
	public final void testFirstAcceptedWordA(){
	AutomatonSpecification a = new NaiveAutomatonSpecification();
	State s0 = a.addState();
	State s1 = a.addState();
	State s2 = a.addState();
	a.markAsInitial(s0);
	a.markAsFinal(s0);
	a.markAsFinal(s1);
	a.markAsFinal(s2);
	a.addTransition(s0, s1, new CharTransitionLabel('a'));
	a.addTransition(s1, s2, new CharTransitionLabel('a'));
	a.addTransition(s0, s1, new CharTransitionLabel('a'));
	assertEquals(a.firstAcceptedWord(), "");
}

	public final void testFirstAcceptedWordB(){
	AutomatonSpecification a = new NaiveAutomatonSpecification();
	State s0 = a.addState();
	State s1 = a.addState();
	State s2 = a.addState();
	State s3 = a.addState();
	State s4 = a.addState();
	State s5 = a.addState();
	State s6 = a.addState();
	a.markAsInitial(s0);
	a.markAsFinal(s1);
	a.addTransition(s0, s2, new CharTransitionLabel('a'));
	a.addTransition(s2, s3, new CharTransitionLabel('a'));
	a.addTransition(s3, s4, new CharTransitionLabel('a'));
	a.addTransition(s4, s5, new CharTransitionLabel('a'));
	a.addTransition(s5, s6, new CharTransitionLabel('a'));
	a.addTransition(s0, s1, new CharTransitionLabel('b'));
	assertEquals(a.firstAcceptedWord(), "b");
}
public final void testFirstAcceptedWordC(){
	AutomatonSpecification a = new NaiveAutomatonSpecification();
	State s0 = a.addState();
	State s1 = a.addState();
	State s2 = a.addState();
	State s3 = a.addState();
	a.markAsInitial(s0);
	a.markAsFinal(s1);
	a.addTransition(s0, s1, new CharTransitionLabel('c'));
	a.addTransition(s0, s3, new CharTransitionLabel('a'));
	a.addTransition(s2, s1, new CharTransitionLabel('c'));
	a.addTransition(s2, s3, new CharTransitionLabel('a'));
	a.addTransition(s3, s0, new CharTransitionLabel('b'));
	a.addTransition(s3, s2, new CharTransitionLabel('a'));
	a.addTransition(s1, s0, new CharTransitionLabel('a'));
	a.addTransition(s1, s2, new CharTransitionLabel('a'));
	assertEquals(a.firstAcceptedWord(), "");//brak pierwszego slowa
}

public final void testFirstAcceptedWordD(){
	AutomatonSpecification a = new NaiveAutomatonSpecification();
	State s0 = a.addState();
	State s1 = a.addState();
	State s2 = a.addState();
	State s3 = a.addState();
	a.markAsInitial(s0);
	a.markAsFinal(s1);
	a.addTransition(s0, s1, new CharTransitionLabel('b'));
	a.addTransition(s0, s3, new CharTransitionLabel('a'));
	a.addTransition(s2, s1, new CharTransitionLabel('a'));
	a.addTransition(s2, s3, new CharTransitionLabel('b'));
	a.addTransition(s3, s0, new CharTransitionLabel('b'));
	a.addTransition(s3, s2, new CharTransitionLabel('a'));
	a.addTransition(s1, s0, new CharTransitionLabel('b'));
	a.addTransition(s1, s2, new CharTransitionLabel('b'));
	assertEquals(a.firstAcceptedWord(), "aaa");
}
}