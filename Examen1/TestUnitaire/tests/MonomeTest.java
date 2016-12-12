import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class MonomeTest {

	private static final double DELTA = 1e-15;
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMonome() {
		Monome m = new Monome();
		assertNotNull(m);
		assertEquals(m.getCoefficient(), 0.0,DELTA);
		assertEquals(m.getExposant(),0);
	}

	@Test
	public void testMonomeDoubleInt() { 
		  Monome m; 
		  double coefficient; 
		  int exposant; 
		
		  coefficient=-2.5;
		  exposant=1;
		  m = new Monome(coefficient,exposant);
		  assertEquals(m.getCoefficient(), coefficient, DELTA);
		  assertEquals(m.getExposant(),exposant);
		  
		  coefficient=1.7;
		  exposant=3;
		  m = new Monome(coefficient,exposant);
		  assertEquals(m.getCoefficient(), coefficient, DELTA);
		  assertEquals(m.getExposant(),exposant);
		  
		  coefficient=100.9;
		  exposant=10;
		  m = new Monome(coefficient,exposant);
		  assertEquals(m.getCoefficient(), coefficient, DELTA);
		  assertEquals(m.getExposant(),exposant);
		
		  // test exposant négatif
		  m = new Monome(1.0, -1); 
		  assertTrue("exposant doit être positif",m.getExposant()!=-1);	
	}

	@Test
	public void testSetCoefficient() {
		Monome m = new Monome();
		double coef; 
		
		coef = -10.5;
		m.setCoefficient(coef);
		assertEquals(m.getCoefficient(), coef, DELTA);
		
		coef = 2.3;
		m.setCoefficient(coef);
		assertEquals(m.getCoefficient(), coef, DELTA);
		
		coef = 19.99999;
		m.setCoefficient(coef);
		assertEquals(m.getCoefficient(), coef, DELTA);

	}

	@Test
	public void testGetCoefficient() {
		Monome m; 
		double coef;
		
		coef = -12.253;
		m = new Monome(coef,1);
		assertEquals(m.getCoefficient(), coef, DELTA);
		
		coef = 1.798;
		m = new Monome(coef,1);
		assertEquals(m.getCoefficient(), coef, DELTA);
		
		coef = 1897.154365;
		m = new Monome(coef,1);
		assertEquals(m.getCoefficient(), coef, DELTA);
	}

	@Test
	public void testSetExposant() {
        Monome m = new Monome();
        m.setExposant(2);
        assertTrue(m.getExposant() == 2);
	}

	@Test
	public void testGetExposant() {
		Monome m = new Monome(3.0, 2);
        assertTrue(m.getExposant() == 2);
	}

	@Test
	public void testComparerMonome() {
		Monome m1 = new Monome(3.0, 2);
        Monome m2 = new Monome(5.0, 2);
        Monome m3 = new Monome(3.0, 2);

        assertFalse(m1.comparerMonome(m2));
        assertTrue(m1.comparerMonome(m3));
	}

	@Test
	public void testToString() {		
		Monome m ; 
		m = new Monome();
		assertEquals(m.toString(), "0");
		
		m = new Monome(0,5);
		assertEquals(m.toString(), "0");
		
		m = new Monome (1,0);
		assertEquals(m.toString(), "1.0");
		
		m = new Monome (3.4,0);
		assertEquals(m.toString(), "3.4");
		
		m = new Monome (3.466,0);
		assertEquals(m.toString(), "3.466");
    
		m = new Monome (1,1);
		assertEquals(m.toString(), "x");
		
		m = new Monome (-1,1);
		assertEquals(m.toString(), "-x");
		
		m = new Monome (3,4);
		assertEquals(m.toString(), "3.0x^4");
		
		m = new Monome (3.56,19);
		assertEquals(m.toString(), "3.56x^19");
		
		m = new Monome(-4,3);
		assertEquals(m.toString(), "-4.0x^3");
		
	}

}
